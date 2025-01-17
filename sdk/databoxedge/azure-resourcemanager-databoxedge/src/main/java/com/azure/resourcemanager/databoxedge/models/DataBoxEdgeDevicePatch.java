// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.databoxedge.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.Map;

/**
 * The Data Box Edge/Gateway device patch.
 */
@Fluent
public final class DataBoxEdgeDevicePatch implements JsonSerializable<DataBoxEdgeDevicePatch> {
    /*
     * The tags attached to the Data Box Edge/Gateway resource.
     */
    private Map<String, String> tags;

    /**
     * Creates an instance of DataBoxEdgeDevicePatch class.
     */
    public DataBoxEdgeDevicePatch() {
    }

    /**
     * Get the tags property: The tags attached to the Data Box Edge/Gateway resource.
     * 
     * @return the tags value.
     */
    public Map<String, String> tags() {
        return this.tags;
    }

    /**
     * Set the tags property: The tags attached to the Data Box Edge/Gateway resource.
     * 
     * @param tags the tags value to set.
     * @return the DataBoxEdgeDevicePatch object itself.
     */
    public DataBoxEdgeDevicePatch withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeMapField("tags", this.tags, (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DataBoxEdgeDevicePatch from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DataBoxEdgeDevicePatch if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the DataBoxEdgeDevicePatch.
     */
    public static DataBoxEdgeDevicePatch fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DataBoxEdgeDevicePatch deserializedDataBoxEdgeDevicePatch = new DataBoxEdgeDevicePatch();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedDataBoxEdgeDevicePatch.tags = tags;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDataBoxEdgeDevicePatch;
        });
    }
}
