import java.math.BigDecimal
import java.time.DayOfWeek
import java.time.LocalDateTime

class OrdersAnalyzer {

    data class Order(val orderId: Int, val creationDate: LocalDateTime, val orderLines: List<OrderLine>)

    data class OrderLine(val productId: Int, val name: String, val quantity: Int, val unitPrice: BigDecimal)

    fun totalDailySales(orders: List<Order>): Map<DayOfWeek, Int> {

        //Create the map
        val totalDailySalesMap : MutableMap<DayOfWeek, Int> = hashMapOf()

        //Check each order
        orders.forEach {
            addOrderToMap(it, totalDailySalesMap)
        }

        return totalDailySalesMap
    }

    private fun addOrderToMap(order: Order, totalDailySalesMap: MutableMap<DayOfWeek, Int>) {
        val dayInWeek = order.creationDate.dayOfWeek
        val orderLine = order.orderLines
        var orderSum = 0

        orderLine.forEach {
            orderSum += it.quantity
        }

        //If day already exist, add his sales count to the current order
        if (totalDailySalesMap.containsKey(dayInWeek)) {
            orderSum += totalDailySalesMap.getValue(dayInWeek)
        }

        //Save the day sales counter
        totalDailySalesMap[dayInWeek] = orderSum
    }
}

