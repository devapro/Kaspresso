package com.kaspersky.kaspresso.files.resources.impl

import com.kaspersky.kaspresso.device.screenshots.screenshotfiles.ScreenshotDirectoryProvider
import com.kaspersky.kaspresso.files.models.TestMethod
import com.kaspersky.kaspresso.files.resources.ResourcesDirNameProvider

/**
 * Special mapper between new and old systems of resource providing
 */
internal class SupportLegacyResourcesDirNameProvider(
    private val screenshotDirectoryProvider: ScreenshotDirectoryProvider,
) : ResourcesDirNameProvider {

    override fun getResourcesDirName(testMethod: TestMethod, runNumber: Int): String {
        val relocatedTestMethod = com.kaspersky.kaspresso.device.screenshots.screenshotfiles.TestMethod(
            className = testMethod.className,
            methodName = testMethod.methodName
        )
        return screenshotDirectoryProvider.getDirectoryForTest(relocatedTestMethod, runNumber)
    }
}
