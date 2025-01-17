// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.securityinsights.fluent.models.AscCheckRequirementsProperties;
import java.io.IOException;

/**
 * Represents ASC (Azure Security Center) requirements check request.
 */
@Fluent
public final class AscCheckRequirements extends DataConnectorsCheckRequirements {
    /*
     * Describes the kind of connector to be checked.
     */
    private DataConnectorKind kind = DataConnectorKind.AZURE_SECURITY_CENTER;

    /*
     * ASC (Azure Security Center) requirements check properties.
     */
    private AscCheckRequirementsProperties innerProperties;

    /**
     * Creates an instance of AscCheckRequirements class.
     */
    public AscCheckRequirements() {
    }

    /**
     * Get the kind property: Describes the kind of connector to be checked.
     * 
     * @return the kind value.
     */
    @Override
    public DataConnectorKind kind() {
        return this.kind;
    }

    /**
     * Get the innerProperties property: ASC (Azure Security Center) requirements check properties.
     * 
     * @return the innerProperties value.
     */
    private AscCheckRequirementsProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the subscriptionId property: The subscription id to connect to, and get the data from.
     * 
     * @return the subscriptionId value.
     */
    public String subscriptionId() {
        return this.innerProperties() == null ? null : this.innerProperties().subscriptionId();
    }

    /**
     * Set the subscriptionId property: The subscription id to connect to, and get the data from.
     * 
     * @param subscriptionId the subscriptionId value to set.
     * @return the AscCheckRequirements object itself.
     */
    public AscCheckRequirements withSubscriptionId(String subscriptionId) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AscCheckRequirementsProperties();
        }
        this.innerProperties().withSubscriptionId(subscriptionId);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("kind", this.kind == null ? null : this.kind.toString());
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AscCheckRequirements from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AscCheckRequirements if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the AscCheckRequirements.
     */
    public static AscCheckRequirements fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AscCheckRequirements deserializedAscCheckRequirements = new AscCheckRequirements();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("kind".equals(fieldName)) {
                    deserializedAscCheckRequirements.kind = DataConnectorKind.fromString(reader.getString());
                } else if ("properties".equals(fieldName)) {
                    deserializedAscCheckRequirements.innerProperties = AscCheckRequirementsProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAscCheckRequirements;
        });
    }
}
