// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automation.generated;

import com.azure.resourcemanager.automation.models.Watcher;

/**
 * Samples for Watcher Update.
 */
public final class WatcherUpdateSamples {
    /*
     * x-ms-original-file:
     * specification/automation/resource-manager/Microsoft.Automation/preview/2020-01-13-preview/examples/updateWatcher.
     * json
     */
    /**
     * Sample code: Update watcher.
     * 
     * @param manager Entry point to AutomationManager.
     */
    public static void updateWatcher(com.azure.resourcemanager.automation.AutomationManager manager) {
        Watcher resource = manager.watchers()
            .getWithResponse("rg", "MyTestAutomationAccount", "MyTestWatcher", com.azure.core.util.Context.NONE)
            .getValue();
        resource.update().withName("MyTestWatcher").withExecutionFrequencyInSeconds(600L).apply();
    }
}
