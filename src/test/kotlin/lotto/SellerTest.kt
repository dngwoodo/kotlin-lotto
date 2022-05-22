package lotto

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SellerTest : DescribeSpec({
    describe("issueFor") {
        it("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.") {
            val purchaseAmount = 14000
            val lottoPrice = 1000
            val lottoCount = purchaseAmount / lottoPrice
            val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
            val seller = Seller(StubRandomNumberGenerator(lottoNumbers))

            seller.issueFor(14000)

            seller.lottos shouldBe (1..lottoCount).map { lottoNumbers }
        }
    }
})

class StubRandomNumberGenerator(private val numbers: List<Int>) : RandomNumberGenerator {
    override fun generate() = numbers
}
