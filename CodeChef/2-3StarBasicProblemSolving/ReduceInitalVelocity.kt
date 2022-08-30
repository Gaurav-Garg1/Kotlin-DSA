fun sol(){
   val (u,v,a,s) = readLine()!!.split(' ').map{
       it.toInt()
   }
   if(v*v >= u*u - 2*a*s) println("Yes") else println("No") //if the initial velocity U can be reduced below final velocity V then "YES
}
fun main(args: Array<String>){
    repeat(readLine()!!.toInt()){
       sol()
    }
}
 
