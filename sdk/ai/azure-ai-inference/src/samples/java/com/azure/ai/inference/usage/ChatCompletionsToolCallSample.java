// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.ai.inference.usage;

import com.azure.ai.inference.ChatCompletionsClient;
import com.azure.ai.inference.ChatCompletionsClientBuilder;
import com.azure.ai.inference.models.ChatChoice;
import com.azure.ai.inference.models.ChatCompletions;
import com.azure.ai.inference.models.ChatCompletionsFunctionToolDefinition;
import com.azure.ai.inference.models.ChatCompletionsOptions;
import com.azure.ai.inference.models.ChatRequestAssistantMessage;
import com.azure.ai.inference.models.ChatRequestMessage;
import com.azure.ai.inference.models.ChatRequestSystemMessage;
import com.azure.ai.inference.models.ChatRequestToolMessage;
import com.azure.ai.inference.models.ChatRequestUserMessage;
import com.azure.ai.inference.models.ChatResponseMessage;
import com.azure.ai.inference.models.CompletionsFinishReason;
import com.azure.ai.inference.models.ChatCompletionsToolCall;
import com.azure.ai.inference.models.FunctionCall;
import com.azure.ai.inference.models.FunctionDefinition;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Configuration;
import com.azure.core.credential.AzureKeyCredential;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ChatCompletionsToolCallSample {
     /**
     * @param args Unused. Arguments to the program.
     */
    public static void main(String[] args) {
        String key = Configuration.getGlobalConfiguration().get("AZURE_API_KEY");
        String endpoint = Configuration.getGlobalConfiguration().get("MODEL_ENDPOINT");
        ChatCompletionsClient client = new ChatCompletionsClientBuilder()
            .credential(new AzureKeyCredential(key))
            .endpoint(endpoint)
            .buildClient();

        List<ChatRequestMessage> chatMessages = new ArrayList<>();
        chatMessages.add(new ChatRequestSystemMessage("You are a helpful assistant."));
        chatMessages.add(new ChatRequestUserMessage("What sort of clothing should I wear today in Berlin?"));

        ChatCompletionsFunctionToolDefinition toolDefinition = new ChatCompletionsFunctionToolDefinition(
            getFutureTemperatureFunctionDefinition());

        ChatCompletionsOptions chatCompletionsOptions = new ChatCompletionsOptions(chatMessages);
        chatCompletionsOptions.setTools(Arrays.asList(toolDefinition));

        ChatCompletions chatCompletions = client.complete(chatCompletionsOptions);

        // Take your function_call result as the input prompt to make another request to service.
        chatMessages = handleFunctionCallResponse(chatCompletions.getChoices(),
            chatMessages);
        ChatCompletions chatCompletionsAnswer = client.complete(new ChatCompletionsOptions(chatMessages));

        System.out.printf("Message: %s.%n", chatCompletionsAnswer.getChoice().getMessage().getContent());
    }

    private static List<ChatRequestMessage> handleFunctionCallResponse(List<ChatChoice> choices,
                                                                       List<ChatRequestMessage> chatMessages) {
        String toolCallId = null;
        StringBuilder functionArguments = new StringBuilder();
        for (ChatChoice choice : choices) {
            ChatResponseMessage choiceMessage = choice.getMessage();
            ChatCompletionsToolCall toolCall = choiceMessage.getToolCalls().get(0);
            FunctionCall functionCall = toolCall.getFunction();

            // We are looking for finish_reason = "tool call".
            if (CompletionsFinishReason.TOOL_CALLS.equals(choice.getFinishReason())) {

                // Add the tool call to the chat history.
                ChatRequestAssistantMessage messageHistory = new ChatRequestAssistantMessage("");
                messageHistory.setToolCalls(choiceMessage.getToolCalls());
                chatMessages.add(messageHistory);

                // We call futureTemperature() and pass the result to the service.
                System.out.printf("Function name: %s, arguments: %s.%n", functionCall.getName(),
                    functionCall.getArguments());

                if (toolCall.getId() != null) {
                    toolCallId = toolCall.getId();
                }

                functionArguments.append(functionCall.getArguments());

                // As an additional step, you may want to deserialize the parameters, so you can call your function
                FunctionArguments parameters = BinaryData.fromString(functionArguments.toString()).toObject(FunctionArguments.class);
                System.out.println("Location Name: " + parameters.locationName);
                System.out.println("Date: " + parameters.date);
                String functionCallResult = futureTemperature(parameters.locationName, parameters.date);

                ChatRequestToolMessage toolRequestMessage = new ChatRequestToolMessage(functionCallResult, toolCallId);

                chatMessages.add(toolRequestMessage);
            }
        }
        return chatMessages;
    }

    // In this example we ignore the parameters for our tool function
    private static String futureTemperature(String locationName, String data) {
        return "-7 C";
    }

    private static FunctionDefinition getFutureTemperatureFunctionDefinition() {
        FunctionDefinition functionDefinition = new FunctionDefinition("FutureTemperature");
        functionDefinition.setDescription("Get the future temperature for a given location and date.");
        FutureTemperatureParameters parameters = new FutureTemperatureParameters();
        functionDefinition.setParameters(BinaryData.fromObject(parameters));
        return functionDefinition;
    }

    private static class FunctionArguments {
        @JsonProperty(value = "location_name")
        private String locationName;

        @JsonProperty(value = "date")
        private String date;
    }

    private static class FutureTemperatureParameters {
        @JsonProperty(value = "type")
        private String type = "object";

        @JsonProperty(value = "properties")
        private FutureTemperatureProperties properties = new FutureTemperatureProperties();
    }

    private static class FutureTemperatureProperties {
        @JsonProperty(value = "unit") StringField unit = new StringField("Temperature unit. Can be either Celsius or Fahrenheit. Defaults to Celsius.");
        @JsonProperty(value = "location_name") StringField locationName = new StringField("The name of the location to get the future temperature for.");
        @JsonProperty(value = "date") StringField date = new StringField("The date to get the future temperature for. The format is YYYY-MM-DD.");
    }

    private static class StringField {
        @JsonProperty(value = "type")
        private final String type = "string";

        @JsonProperty(value = "description")
        private String description;

        @JsonCreator
        StringField(@JsonProperty(value = "description") String description) {
            this.description = description;
        }
    }
}
