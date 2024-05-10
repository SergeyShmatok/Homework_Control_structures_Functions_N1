package ru.netology


fun main() {

    agoToText(172801)


}


fun agoToText(timeHasPassed: Int) {


    when (timeHasPassed) {
        in 0..<60 -> println("был(а) только что")
        in 60..<60 * 60 -> println("был(а) ${timeHasPassed / 60} ${wordFormsMinutes(timeHasPassed)} назад") // - минуты
        in 60 * 60..24 * 60 * 60 -> println("был(а) ${timeHasPassed / 3600} ${wordFormsHours(timeHasPassed)} назад") // - часы
        in 24 * 60 * 60 + 1..(24 * 60 * 60) * 2 -> println("был(а) вчера")
        in (24 * 60 * 60) * 2 + 1..(24 * 60 * 60) * 3 -> println("был(а) позавчера")
        else -> println("был(а) давно")

    }

}

fun wordFormsMinutes(timeHasPassed: Int) = when {

    (timeHasPassed / 60) % 10 == 1 && (timeHasPassed / 60) != 11 -> "минуту"
    // 1 / 21 / 31 / 41 / 51 (11 исключаем)
    ((timeHasPassed / 60) == 12 || (timeHasPassed / 60) == 13 || (timeHasPassed / 60) == 14) -> "минут"
    // 12 / 13 / 14
    (timeHasPassed / 60) % 10 == 2 || (timeHasPassed / 60) % 10 == 3 || (timeHasPassed / 60) % 10 == 4 -> "минуты"
    //2 / 22 / 32 / 42 / 52 минуты назад (то же самое для 3 и 4)
    else -> "минут"
}


fun wordFormsHours(timeHasPassed: Int) = when (timeHasPassed / 3600) {

    1, 21 -> "час"
    2, 3, 4, 22, 23, 24 -> "часа"
    else -> "часов"

}

// Или так:
//fun wordFormsHours(timeHasPassed: Int) = when {
//
//    (timeHasPassed / 3600) % 10 == 1 && (timeHasPassed / 3600) != 11 -> "час"
//    // 1, 21 час назад
//    (timeHasPassed / 3600) % 10 == 2 || (timeHasPassed / 3600) % 10 == 3 || (timeHasPassed / 3600) % 10 == 4 -> "часа"
//    // 2, 3, 4, 22, 23, 24 часа назад
//    else -> "часов"
//}
