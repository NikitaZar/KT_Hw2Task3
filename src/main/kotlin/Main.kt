fun main() {
    val USER_CONFIRM_ANSWER = "да"
    val USER_CANCEL_ANSWER = "нет"
    val EXIT = "end"

    val amount: Long
    println("Введите сумму покупки в руб. Для выхода ведите $EXIT")
    val input = readLine()
    if (input != EXIT && input != null) {
        amount = input.toLong()
    } else {
        return
    }

    println("Вы уже делали покупки в этом месяце? $USER_CONFIRM_ANSWER/$USER_CANCEL_ANSWER")
    var isVipCustomerIn: String?
    while (true) {
        isVipCustomerIn = readLine()
        when (isVipCustomerIn) {
            USER_CANCEL_ANSWER -> break
            USER_CONFIRM_ANSWER -> break
            else -> println("Некорректный ввод ($USER_CONFIRM_ANSWER/$USER_CANCEL_ANSWER)")
        }
    }

    val isVipCustomer = isVipCustomerIn.equals(USER_CONFIRM_ANSWER)
    val customer = Customer(isVipCustomer)
    println("Стоимость покупки с учетом скидки - ${customer.calc(amount)} руб.")
}
