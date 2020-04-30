package com.example.sampletesterapp.utils

import org.junit.Test

import org.junit.Assert.*

class ConverterUtilsKtTest {

    @Test
    fun convertFahrenheitToCelcius() {
        val input = 212f
        var output = 0f
        val expected = 100f
        //val delta = 0.1f

        output = convertFahrenheitToCelcius(input)
        assertEquals(expected,output)
    }

    @Test
    fun convertCelciusToFahrenheit() {
        val input = 100f
        var output = 0f
        val expected = 212f
        //val delta = 0.1f

        output = convertCelciusToFahrenheit(input)
        assertEquals(expected,output)
    }
}