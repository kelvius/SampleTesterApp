package com.example.sampletesterapp

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.sampletesterapp.ui.auth.LoginActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *
 * Base Espresso Test
 * onView(ViewMatcher) - Finds the view
 *.perform(ViewAction) - Performs an action on the view
 *.check(ViewAssertion); - Validates a assertioin
 *
 * Resources
 * https://developer.android.com/training/testing/espresso/basics
 * https://www.vogella.com/tutorials/AndroidTestingEspresso/article.html
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val rule:ActivityTestRule<LoginActivity> = ActivityTestRule(
        LoginActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.sampletesterapp", appContext.packageName)
    }

    @Test
    fun user_input_email() {
        onView(withId(R.id.et_email)).perform(typeText("probel-kun@gmail.com"))
    }

    @Test
    fun user_input_password() {
        onView(withId(R.id.et_password)).perform(typeText("123456"))
    }

    @Test
    fun user_can_enter_text_and_display_success() {
        onView(withId(R.id.et_email)).perform(typeText("probelalkhan@gmail.com"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.et_password)).perform(typeText("123456"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btn_submit)).perform(click())
        onView(withId(R.id.tv_text)).check(matches(withText("Welcome,probelalkhan@gmail.com")))
    }
}
