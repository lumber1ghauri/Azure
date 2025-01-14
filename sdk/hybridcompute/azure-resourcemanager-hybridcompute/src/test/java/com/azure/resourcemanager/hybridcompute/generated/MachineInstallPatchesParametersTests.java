// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcompute.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.hybridcompute.models.LinuxParameters;
import com.azure.resourcemanager.hybridcompute.models.MachineInstallPatchesParameters;
import com.azure.resourcemanager.hybridcompute.models.VMGuestPatchClassificationLinux;
import com.azure.resourcemanager.hybridcompute.models.VMGuestPatchClassificationWindows;
import com.azure.resourcemanager.hybridcompute.models.VMGuestPatchRebootSetting;
import com.azure.resourcemanager.hybridcompute.models.WindowsParameters;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class MachineInstallPatchesParametersTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MachineInstallPatchesParameters model = BinaryData.fromString(
            "{\"maximumDuration\":\"PT28H58M12S\",\"rebootSetting\":\"Always\",\"windowsParameters\":{\"classificationsToInclude\":[\"Definition\"],\"kbNumbersToInclude\":[\"adm\",\"sr\"],\"kbNumbersToExclude\":[\"vxpvgomz\"],\"excludeKbsRequiringReboot\":false,\"maxPatchPublishDate\":\"2021-11-03T15:37:36Z\"},\"linuxParameters\":{\"classificationsToInclude\":[\"Other\",\"Security\",\"Security\"],\"packageNameMasksToInclude\":[\"dawkzbali\",\"urqhaka\",\"hashsfwxosow\",\"xcug\"],\"packageNameMasksToExclude\":[\"ooxdjebwpuc\",\"wfvovbv\",\"euecivyhzceuoj\"]}}")
            .toObject(MachineInstallPatchesParameters.class);
        Assertions.assertEquals(Duration.parse("PT28H58M12S"), model.maximumDuration());
        Assertions.assertEquals(VMGuestPatchRebootSetting.ALWAYS, model.rebootSetting());
        Assertions.assertEquals(VMGuestPatchClassificationWindows.DEFINITION,
            model.windowsParameters().classificationsToInclude().get(0));
        Assertions.assertEquals("adm", model.windowsParameters().kbNumbersToInclude().get(0));
        Assertions.assertEquals("vxpvgomz", model.windowsParameters().kbNumbersToExclude().get(0));
        Assertions.assertEquals(false, model.windowsParameters().excludeKbsRequiringReboot());
        Assertions.assertEquals(OffsetDateTime.parse("2021-11-03T15:37:36Z"),
            model.windowsParameters().maxPatchPublishDate());
        Assertions.assertEquals(VMGuestPatchClassificationLinux.OTHER,
            model.linuxParameters().classificationsToInclude().get(0));
        Assertions.assertEquals("dawkzbali", model.linuxParameters().packageNameMasksToInclude().get(0));
        Assertions.assertEquals("ooxdjebwpuc", model.linuxParameters().packageNameMasksToExclude().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MachineInstallPatchesParameters model
            = new MachineInstallPatchesParameters().withMaximumDuration(Duration.parse("PT28H58M12S"))
                .withRebootSetting(VMGuestPatchRebootSetting.ALWAYS)
                .withWindowsParameters(new WindowsParameters()
                    .withClassificationsToInclude(Arrays.asList(VMGuestPatchClassificationWindows.DEFINITION))
                    .withKbNumbersToInclude(Arrays.asList("adm", "sr"))
                    .withKbNumbersToExclude(Arrays.asList("vxpvgomz"))
                    .withExcludeKbsRequiringReboot(false)
                    .withMaxPatchPublishDate(OffsetDateTime.parse("2021-11-03T15:37:36Z")))
                .withLinuxParameters(new LinuxParameters()
                    .withClassificationsToInclude(Arrays.asList(VMGuestPatchClassificationLinux.OTHER,
                        VMGuestPatchClassificationLinux.SECURITY, VMGuestPatchClassificationLinux.SECURITY))
                    .withPackageNameMasksToInclude(Arrays.asList("dawkzbali", "urqhaka", "hashsfwxosow", "xcug"))
                    .withPackageNameMasksToExclude(Arrays.asList("ooxdjebwpuc", "wfvovbv", "euecivyhzceuoj")));
        model = BinaryData.fromObject(model).toObject(MachineInstallPatchesParameters.class);
        Assertions.assertEquals(Duration.parse("PT28H58M12S"), model.maximumDuration());
        Assertions.assertEquals(VMGuestPatchRebootSetting.ALWAYS, model.rebootSetting());
        Assertions.assertEquals(VMGuestPatchClassificationWindows.DEFINITION,
            model.windowsParameters().classificationsToInclude().get(0));
        Assertions.assertEquals("adm", model.windowsParameters().kbNumbersToInclude().get(0));
        Assertions.assertEquals("vxpvgomz", model.windowsParameters().kbNumbersToExclude().get(0));
        Assertions.assertEquals(false, model.windowsParameters().excludeKbsRequiringReboot());
        Assertions.assertEquals(OffsetDateTime.parse("2021-11-03T15:37:36Z"),
            model.windowsParameters().maxPatchPublishDate());
        Assertions.assertEquals(VMGuestPatchClassificationLinux.OTHER,
            model.linuxParameters().classificationsToInclude().get(0));
        Assertions.assertEquals("dawkzbali", model.linuxParameters().packageNameMasksToInclude().get(0));
        Assertions.assertEquals("ooxdjebwpuc", model.linuxParameters().packageNameMasksToExclude().get(0));
    }
}
