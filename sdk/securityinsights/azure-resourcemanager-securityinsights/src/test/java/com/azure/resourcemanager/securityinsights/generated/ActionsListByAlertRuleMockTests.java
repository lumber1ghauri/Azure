// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.securityinsights.SecurityInsightsManager;
import com.azure.resourcemanager.securityinsights.models.ActionResponse;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ActionsListByAlertRuleMockTests {
    @Test
    public void testListByAlertRule() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"workflowId\":\"ebxxopyic\",\"logicAppResourceId\":\"vspeslhwyykgvr\"},\"etag\":\"pumdd\",\"id\":\"ajk\",\"name\":\"dyd\",\"type\":\"tpfcudvafnbfbqv\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        SecurityInsightsManager manager = SecurityInsightsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<ActionResponse> response
            = manager.actions().listByAlertRule("ka", "bpyhssrlvkpkp", "ocm", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("pumdd", response.iterator().next().etag());
        Assertions.assertEquals("ebxxopyic", response.iterator().next().workflowId());
        Assertions.assertEquals("vspeslhwyykgvr", response.iterator().next().logicAppResourceId());
    }
}
