package com.au.cba.exercise

import androidx.compose.material.Surface
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.au.cba.exercise.presentation.viewmodel.TransactionViewModel
import com.au.cba.exercise.shared.*
import com.au.cba.exercise.theme.CBAExerciseTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.rules.RuleChain
import javax.inject.Inject

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class DisplayViewTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @get:Rule
    val rule: RuleChain = RuleChain.outerRule(hiltRule)
        .around(composeTestRule)


    @Inject
    lateinit var viewModel:TransactionViewModel


    @Before
    fun init() {
        hiltRule.inject()
        val fakeTransactionService = FakeTransactionService()
        val fakeRemoteDateSource = FakeRemoteDateSource(fakeTransactionService)
        val fakeRepository = FakeRepository(fakeRemoteDateSource)
        var fakeUseCase  = FakeUseCase(fakeRepository)



    }

    @Before
    fun setup() {
        composeTestRule.setContent {
            CBAExerciseTheme {
                Surface {
                    DisplayView(viewModel)
                }
            }
        }
    }

    @Ignore
    @Test
    fun testDisplayViewData(){

    }

    @Ignore
    @Test
    fun testTheTitleSection() {
        val accountName = "Complete Access"
        composeTestRule.onNodeWithText(accountName).assertExists()
    }
}