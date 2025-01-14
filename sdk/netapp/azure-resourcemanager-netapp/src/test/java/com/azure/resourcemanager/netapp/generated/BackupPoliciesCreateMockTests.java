// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.netapp.NetAppFilesManager;
import com.azure.resourcemanager.netapp.models.BackupPolicy;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class BackupPoliciesCreateMockTests {
    @Test
    public void testCreate() throws Exception {
        String responseStr
            = "{\"etag\":\"ylkmqp\",\"properties\":{\"backupPolicyId\":\"yhlfb\",\"provisioningState\":\"Succeeded\",\"dailyBackupsToKeep\":1304757403,\"weeklyBackupsToKeep\":296049099,\"monthlyBackupsToKeep\":1159366069,\"volumesAssigned\":2022448357,\"enabled\":false,\"volumeBackups\":[{\"volumeName\":\"hhpzpofoiyjwpf\",\"volumeResourceId\":\"kmkkholvdnd\",\"backupsCount\":772540044,\"policyEnabled\":true},{\"volumeName\":\"phuartv\",\"volumeResourceId\":\"ukyefchnmnahmnxh\",\"backupsCount\":1852256635,\"policyEnabled\":false},{\"volumeName\":\"wrweoo\",\"volumeResourceId\":\"fifhxwrsnew\",\"backupsCount\":2142810621,\"policyEnabled\":false},{\"volumeName\":\"ubqmamh\",\"volumeResourceId\":\"cx\",\"backupsCount\":874456434,\"policyEnabled\":true}]},\"location\":\"ttaboidvmfqh\",\"tags\":{\"g\":\"bowsepd\",\"c\":\"mtdherngb\",\"obkauxofsh\":\"uahokq\"},\"id\":\"phwpnulaiywzej\",\"name\":\"whslwkoj\",\"type\":\"llndnpd\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        NetAppFilesManager manager = NetAppFilesManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        BackupPolicy response = manager.backupPolicies()
            .define("fr")
            .withRegion("ugswvx")
            .withExistingNetAppAccount("pqcbfrmbodthsq", "gvriibakclac")
            .withTags(mapOf("njmxmcuqudtcvcl", "zqwmvt", "iyji", "ynpdkvgfab", "n", "uzphdugnei", "jiuqhibtozi", "gox"))
            .withDailyBackupsToKeep(1264104137)
            .withWeeklyBackupsToKeep(920817597)
            .withMonthlyBackupsToKeep(1501794203)
            .withEnabled(false)
            .create();

        Assertions.assertEquals("ttaboidvmfqh", response.location());
        Assertions.assertEquals("bowsepd", response.tags().get("g"));
        Assertions.assertEquals(1304757403, response.dailyBackupsToKeep());
        Assertions.assertEquals(296049099, response.weeklyBackupsToKeep());
        Assertions.assertEquals(1159366069, response.monthlyBackupsToKeep());
        Assertions.assertEquals(false, response.enabled());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
