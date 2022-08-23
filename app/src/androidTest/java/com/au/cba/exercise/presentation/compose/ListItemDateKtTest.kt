package com.au.cba.exercise.presentation.compose

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListItemDateKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
    }

    @Test
    fun testDateDisplayCorrectly() {

        composeTestRule.setContent {
            ListItemDate(date = "2022-02-28")
        }

        composeTestRule.onNodeWithText("Sun,28 Feb").assertExists()
    }
}