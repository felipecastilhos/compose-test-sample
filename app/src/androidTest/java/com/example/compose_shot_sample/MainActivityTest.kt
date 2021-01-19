package com.example.compose_shot_sample

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.ActivityScenario
import androidx.test.filters.MediumTest
import com.karumi.shot.ActivityScenarioUtils.waitForActivity
import com.karumi.shot.ScreenshotTest
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@MediumTest
@RunWith(JUnit4::class)
class MainActivityTest: ScreenshotTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.launchDefaultPreviewScreen()
    }

    @Ignore
    @Test
    fun testDefaultPreviewHasTextView() {
        composeTestRule.onNodeWithText("Hello Android!").assertIsDisplayed()
    }

    @Test
    fun testDefaultPreviewScreenshot() {
        compareScreenshot(composeTestRule)
    }

    @Test
    fun theActivityIsShownProperly() {
        val activity = ActivityScenario.launch(MainActivity::class.java).waitForActivity()
        compareScreenshot(activity)
    }

    private fun ComposeTestRule.launchDefaultPreviewScreen() {
        setContent {
            DefaultPreview()
        }
    }
}