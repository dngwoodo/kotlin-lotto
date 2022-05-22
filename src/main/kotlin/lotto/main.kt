package lotto

fun main() {
    // 구입할 로또 갯수 입력(View)
    val inputView = InputView(Input())
    val purchaseAmount = inputView.askPurchaseAmount()

    // 로또 구입(Model)
    val seller = Seller(RandomNumbersGenerator())
    seller.issueFor(purchaseAmount)

    // 구입한 로또를 사용자에게 출력(View)
    val resultView = ResultView(Output())
    resultView.showLottos(seller.lottos)

    // 지난 주 당첨 번호를 사용자에게 출력(View)
    val lastWeekWinningNumber = inputView.askLastWeekWinningNumber()

    // 로또 분석(Model)
    val analyst = Analyst(lastWeekWinningNumber)
    analyst.analyze(purchaseAmount, seller.lottos)

    // 당첨 통계를 사용자에게 출력(View)
    resultView.showAnalyzeResult(analyst.result)
}