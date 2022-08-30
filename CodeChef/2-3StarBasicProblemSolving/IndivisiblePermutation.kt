// Every to consecutive numbers are co-primne so the number is not divisible by it's index.
fun sol(){
       var n = readLine()!!.toInt()
       print("$n ")
       n--
       for(i in 1..n) print("$i ")
       println()
}
fun main(args: Array<String>){
    repeat(readLine()!!.toInt()){
       sol()
    }
}
