//Q - SRTCHK 
import java.util.PriorityQueue

fun sol(){
   val n = readLine()!!.toInt()
   val pq = PriorityQueue<Int>()
   
   readLine()!!.split(' ').map{ // Priority queue will read as well as provide a DS to retrieve element in sorted order
       pq.add(it.toInt())
   } //pq is sorted a array()
   
   val arrB = readLine()!!.split(' ').map{
       it.toInt()
   }
   
   var flag = -1
   for(i in arrB){
       if(i != pq.poll()){ // getting elements from priority queue in sorted order
           flag = 1
           break
       }
   }
   if(flag == 1) println("no") else println("yes")
}
fun main(args: Array<String>){
    repeat(readLine()!!.toInt()){
       sol()
    }
}

// to check if second array is sorted version of first.
// faster than taking 2 arrays and then sorting the first one and making comparisons
