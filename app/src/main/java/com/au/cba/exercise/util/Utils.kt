package com.au.cba.exercise.util

import com.au.cba.exercise.constant.DateDiffPeriod
import com.au.cba.exercise.constant.DateFormat
import com.au.cba.exercise.data.entity.TransactionList
import java.time.LocalDate
import java.time.Period
import java.time.ZoneId
import java.time.format.DateTimeFormatter

//TODO:To optimize for older versions
object Utils {
     fun dateFormatter(date : String) : String{
        val inputFormatter = DateTimeFormatter.ofPattern(DateFormat.INPUT_FORMAT)
        val inputDate = LocalDate.parse(date, inputFormatter)
        val localDateTime = inputDate.atStartOfDay()
        val zonedDateTime = localDateTime.atZone(ZoneId.of(DateFormat.TIME_ZONE))
        val outputFormatter = DateTimeFormatter.ofPattern(DateFormat.OUTPUT_FORMAT)
        return outputFormatter.format(zonedDateTime)
    }

    fun getDateDifference(date: String,diff: DateDiffPeriod): String {
        val period = calculatePeriod(date)
        return when(diff){
            DateDiffPeriod.DAYS -> "${period.days} days ago"
            DateDiffPeriod.MONTHS -> "${period.months} month(s), ${period.days} days ago"
            DateDiffPeriod.YEARS -> "${period.years} year(s), ${period.months} month(s), ${period.days} days ago"
        }

    }

    private fun calculatePeriod(date: String): Period {
        val inputFormatter = DateTimeFormatter.ofPattern(DateFormat.INPUT_FORMAT)
        val inputDate = LocalDate.parse(date, inputFormatter)
        val today = LocalDate.now()
        return Period.between(inputDate, today)
    }

    fun calculatePending(data: TransactionList):String{
        val sum = data.transactions.asSequence().filter { it.isPending }.sumOf { it.amount.toDouble() }
        return sum.toString()

    }
}