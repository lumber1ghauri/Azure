// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.securityinsights.fluent.models.SettingListInner;
import com.azure.resourcemanager.securityinsights.fluent.models.SettingsInner;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class SettingListInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SettingListInner model = BinaryData.fromString(
            "{\"value\":[{\"kind\":\"Settings\",\"etag\":\"lsmdesqplpvmjc\",\"id\":\"ewbidyvteowxv\",\"name\":\"piudeugfsxzecpa\",\"type\":\"wkufykhvuhxepm\"},{\"kind\":\"Settings\",\"etag\":\"tznabao\",\"id\":\"slujdjltym\",\"name\":\"mvguihywart\",\"type\":\"pphkixkykxds\"}]}")
            .toObject(SettingListInner.class);
        Assertions.assertEquals("lsmdesqplpvmjc", model.value().get(0).etag());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SettingListInner model = new SettingListInner().withValue(
            Arrays.asList(new SettingsInner().withEtag("lsmdesqplpvmjc"), new SettingsInner().withEtag("tznabao")));
        model = BinaryData.fromObject(model).toObject(SettingListInner.class);
        Assertions.assertEquals("lsmdesqplpvmjc", model.value().get(0).etag());
    }
}
