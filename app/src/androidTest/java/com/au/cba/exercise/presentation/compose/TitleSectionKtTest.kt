package com.au.cba.exercise.presentation.compose

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.au.cba.exercise.data.entity.Account
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class TitleSectionKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Mock
    lateinit var account: Account

    @Before
    fun setUp() {
        account = Mockito.mock(Account::class.java)
    }

    @Test
    fun testTitleDisplayCorrectly() {

        composeTestRule.setContent {
           TitleSection(item = account) {
           }
        }

        composeTestRule.onNodeWithText(account.accountName).assertExists()
    }
}