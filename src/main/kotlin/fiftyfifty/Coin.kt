package fiftyfifty

class Coin {
    companion object {
        const val HEAD = 1;
        const val TAIL = 0;
    }

    fun flipResult(): Int{
        return (TAIL..HEAD).random()
    }

}