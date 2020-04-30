package com.example.sampletesterapp.utils

fun convertFahrenheitToCelcius(fahrenheit: Float) : Float{
    return ((fahrenheit-32)*5/9)
}

fun convertCelciusToFahrenheit(celcius: Float): Float{
    return ((celcius*9)/5)+32
}