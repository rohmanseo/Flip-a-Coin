package fiftyfifty

class Person(val name: String, var money: Double,val rewardWhenWin:Double,val riskWhenLose: Double){

    private var numberOfWin = 0

    fun getWinProbability(numberOfGamble: Int): Double{
        return ((numberOfWin.toDouble()/numberOfGamble.toDouble()) * 100)
    }

    fun win(){
        money += rewardWhenWin
        numberOfWin += 1
    }

    fun lose(){
        money -= riskWhenLose
    }

}