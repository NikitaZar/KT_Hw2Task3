class Customer(private val isVipCustomer: Boolean) {
    companion object {
        private const val BIG_DISCOUNT_PERCENT = 5
        private const val VIP_CUSTOMER_DISCOUNT_PERCENT = 1
        private const val MIDDLE_DISCOUNT_RUB = 100L
        private const val MIDDLE_DISCOUNT_START = 1001L
        private const val MIDDLE_DISCOUNT_END = 10_0000L
        private const val KOP_PER_RUB = 1000
    }

    private fun rubToKop(amountRub: Long): Long {
        return amountRub * KOP_PER_RUB
    }

    private fun kopToRub(amountKop: Long): Long {
        return amountKop / KOP_PER_RUB
    }

    fun calc(amountRub: Long): Long {
        var finalAmount: Long
        val amountKop = rubToKop(amountRub)
        val middleDiscountStart = rubToKop(MIDDLE_DISCOUNT_START)
        val middleDiscountEnd = rubToKop(MIDDLE_DISCOUNT_END)
        val middleDiscountRub = rubToKop(MIDDLE_DISCOUNT_RUB)

        when (amountKop) {
            in 0 until middleDiscountStart -> finalAmount = amountKop
            in middleDiscountStart..middleDiscountEnd -> finalAmount = amountKop - middleDiscountRub
            else -> finalAmount = amountKop * (100 - BIG_DISCOUNT_PERCENT) / 100
        }

        finalAmount =
            kopToRub(if (isVipCustomer) finalAmount * (100 - VIP_CUSTOMER_DISCOUNT_PERCENT) / 100 else finalAmount)
        return finalAmount
    }
}