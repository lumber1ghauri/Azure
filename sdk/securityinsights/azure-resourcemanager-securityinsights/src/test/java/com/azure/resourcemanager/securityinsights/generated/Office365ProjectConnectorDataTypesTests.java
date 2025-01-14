// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.securityinsights.models.DataTypeState;
import com.azure.resourcemanager.securityinsights.models.Office365ProjectConnectorDataTypes;
import com.azure.resourcemanager.securityinsights.models.Office365ProjectConnectorDataTypesLogs;
import org.junit.jupiter.api.Assertions;

public final class Office365ProjectConnectorDataTypesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        Office365ProjectConnectorDataTypes model = BinaryData.fromString("{\"logs\":{\"state\":\"Disabled\"}}")
            .toObject(Office365ProjectConnectorDataTypes.class);
        Assertions.assertEquals(DataTypeState.DISABLED, model.logs().state());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        Office365ProjectConnectorDataTypes model = new Office365ProjectConnectorDataTypes()
            .withLogs(new Office365ProjectConnectorDataTypesLogs().withState(DataTypeState.DISABLED));
        model = BinaryData.fromObject(model).toObject(Office365ProjectConnectorDataTypes.class);
        Assertions.assertEquals(DataTypeState.DISABLED, model.logs().state());
    }
}
