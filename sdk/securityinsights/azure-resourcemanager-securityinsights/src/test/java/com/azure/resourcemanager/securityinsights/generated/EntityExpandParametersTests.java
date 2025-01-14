// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.securityinsights.models.EntityExpandParameters;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;

public final class EntityExpandParametersTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        EntityExpandParameters model = BinaryData.fromString(
            "{\"endTime\":\"2021-03-07T05:51:02Z\",\"expansionId\":\"4a132fe4-646d-4039-b2df-5a8191a77fac\",\"startTime\":\"2021-03-30T14:01:12Z\"}")
            .toObject(EntityExpandParameters.class);
        Assertions.assertEquals(OffsetDateTime.parse("2021-03-07T05:51:02Z"), model.endTime());
        Assertions.assertEquals(UUID.fromString("4a132fe4-646d-4039-b2df-5a8191a77fac"), model.expansionId());
        Assertions.assertEquals(OffsetDateTime.parse("2021-03-30T14:01:12Z"), model.startTime());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        EntityExpandParameters model
            = new EntityExpandParameters().withEndTime(OffsetDateTime.parse("2021-03-07T05:51:02Z"))
                .withExpansionId(UUID.fromString("4a132fe4-646d-4039-b2df-5a8191a77fac"))
                .withStartTime(OffsetDateTime.parse("2021-03-30T14:01:12Z"));
        model = BinaryData.fromObject(model).toObject(EntityExpandParameters.class);
        Assertions.assertEquals(OffsetDateTime.parse("2021-03-07T05:51:02Z"), model.endTime());
        Assertions.assertEquals(UUID.fromString("4a132fe4-646d-4039-b2df-5a8191a77fac"), model.expansionId());
        Assertions.assertEquals(OffsetDateTime.parse("2021-03-30T14:01:12Z"), model.startTime());
    }
}
