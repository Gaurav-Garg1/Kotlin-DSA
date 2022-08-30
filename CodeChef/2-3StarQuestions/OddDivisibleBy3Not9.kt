//basic programming number divisible by 3 not 9 of given length
fun sol(){
   val n = readLine()!!.toInt()
   val sb = StringBuilder()
   if(n == 1) {
       println(3)
       return
   }
   sb.append(1)
   repeat(n-2){
       sb.append(0)
   }
   sb.append(5)
   println(sb.toString())
}

fun main(args: Array<String>){
    repeat(readLine()!!.toInt()){
       sol()
    }
}
    
