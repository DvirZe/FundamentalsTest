import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal
import java.time.DayOfWeek
import java.time.LocalDateTime

class Tests {

    @Test
    fun orderTest() {

        val orders = mutableListOf<OrdersAnalyzer.Order>()

        //Saturday
        var lines = mutableListOf(
            OrdersAnalyzer.OrderLine(9872, "Pencil", 3, BigDecimal(3.00)))


        orders.add(OrdersAnalyzer.Order(554, LocalDateTime.parse("2017-03-25T10:35:20"), lines))

        //Saturday
        lines = mutableListOf(
                OrdersAnalyzer.OrderLine(9872, "Pencil", 2, BigDecimal(3.00)),
                OrdersAnalyzer.OrderLine(1746, "Eraser", 1, BigDecimal(1.00)))

        orders.add(OrdersAnalyzer.Order(555, LocalDateTime.parse("2017-03-25T11:24:20"), lines))

        //Monday
        lines = mutableListOf(
                OrdersAnalyzer.OrderLine(5723, "Pen", 4, BigDecimal(4.22)),
                OrdersAnalyzer.OrderLine(9872, "Pencil", 3, BigDecimal(3.12)),
                OrdersAnalyzer.OrderLine(3433, "Erasers Set", 1, BigDecimal(6.15))
        )

        orders.add(OrdersAnalyzer.Order(453, LocalDateTime.parse("2017-03-27T14:53:12"), lines))

        //Monday
        lines = mutableListOf(
                OrdersAnalyzer.OrderLine(5723, "Pen", 7, BigDecimal(4.22)),
                OrdersAnalyzer.OrderLine(3433, "Erasers Set", 2, BigDecimal(6.15)))

        orders.add(OrdersAnalyzer.Order(431, LocalDateTime.parse("2017-03-20T12:15:02"), lines))

        //Sunday
        lines = mutableListOf(
                OrdersAnalyzer.OrderLine(9872, "Pencil", 4, BigDecimal(3.12)),
                OrdersAnalyzer.OrderLine(4098, "Eraser", 5, BigDecimal(4.50)))

        orders.add(OrdersAnalyzer.Order(690, LocalDateTime.parse("2017-03-26T11:14:00"), lines))

        val ordersAnalyzer = OrdersAnalyzer()

        val map = ordersAnalyzer.totalDailySales(orders)

        val testMap : MutableMap<DayOfWeek, Int> = hashMapOf(DayOfWeek.SUNDAY to 9, DayOfWeek.MONDAY to 17, DayOfWeek.SATURDAY to 6)

        assertEquals(map, testMap)

        println(map)

    }

}