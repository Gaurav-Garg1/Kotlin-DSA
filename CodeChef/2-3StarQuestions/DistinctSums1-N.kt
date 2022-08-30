fun sol(){
   val (l,r) = readLine()!!.split(' ').map{
       it.toInt()
   }
   // r-l+1 is the size of the array, the size will contribute the n different sums, n = size 
   // and then each remaining subarray will give 1 sum only
   // so n + n-1 is answer i.e r-l+1 + r-l+1 -1 = 2r-2l+1
   println(2*r - 2*l +1)
}
fun main(args: Array<String>){
    repeat(readLine()!!.toInt()){
       sol()
    }
}
// So from all the numbers of 1..n -> 2n - 1 distince sums can be formed 
// you can calculate n if left or rightmost number of array is given incremented by 1 by r-l+1
    
