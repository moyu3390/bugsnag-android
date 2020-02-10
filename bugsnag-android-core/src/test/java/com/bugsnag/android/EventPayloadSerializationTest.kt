package com.bugsnag.android

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameter
import org.junit.runners.Parameterized.Parameters
import java.io.File

@RunWith(Parameterized::class)
internal class EventPayloadSerializationTest {

    companion object {
        @JvmStatic
        @Parameters
        fun testCases(): Collection<Pair<JsonStream.Streamable, String>> {
            Notifier.version = "9.9.9"
            Notifier.name = "AndroidBugsnagNotifier"
            Notifier.url = "https://bugsnag.com"
            return generateSerializationTestCases(
                "report",
                EventPayload("api-key", File(""))
            )
        }
    }

    @Parameter
    lateinit var testCase: Pair<EventPayload, String>

    @Test
    fun testJsonSerialisation() = verifyJsonMatches(testCase.first, testCase.second)
}