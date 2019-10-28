package dinamicos

fun main(){
    TSP()
}

class TSP {
    val inicio = readLine()?.toInt()
    val city = arrayOf(
            arrayOf(0,13,33,28,37,7,32,40,80,26),
            arrayOf(0,0,39,83,50,68,16,98,81,55),
            arrayOf(0,0,0,80,88,49,53,75,63,55),
            arrayOf(0,0,0,0,94,4,20,6,59,76),
            arrayOf(0,0,0,0,0,81,87,85,4,19),
            arrayOf(0,0,0,0,0,0,96,53,40,37),
            arrayOf(0,0,0,0,0,0,0,80,57,68),
            arrayOf(0,0,0,0,0,0,0,0,65,41),
            arrayOf(0,0,0,0,0,0,0,0,0,97),
            arrayOf(0,0,0,0,0,0,0,0,0,0)
    )

    data class Dato(val valor: Int, val columna : Int)

    init {
        println(city.joinToString {
            "${it.joinToString{
                "$it".padEnd(4, ' ')
            }}\n"
        })

    }
    fun distancia(){
        for ((i, c) in city.withIndex()){
            c.minBy {
                if(it == 0) Int.MAX_VALUE
                else it
            }
            for ((x, y) in c.withIndex()){
                c.minBy {
                    if(it == 0) Int.MAX_VALUE
                    else it
                }

            }
        }
    }


}