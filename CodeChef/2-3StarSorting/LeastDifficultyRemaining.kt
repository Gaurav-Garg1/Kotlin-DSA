fun sol(){
    val sum = 0 
    val arrDif = readLine()!!.split(' ').map{
       it.toInt()
   }// read the array where Ai is the number of problems of difficulty i, here arrDiff would be 1 indexed as per the question
   var k = readLine()!!.toInt() //reading the number of problems able to delete
   for(i in 9 downTo 0){
       k -= arrDif[i] 
       if(k<0){ // deleating from end till k is greater than or equal to zero so that we can get the least difficulty problem
           println(i+1) // adding 1 because the array should be 1 indexed.
           break
       }
   }
}

fun main(args: Array<String>){
    repeat(readLine()!!.toInt()){
       sol()
    }
}
