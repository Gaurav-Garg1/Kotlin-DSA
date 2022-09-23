fun <T : Comparable<T>> Array<T>.swapAt(n1:Int, n2:Int){ //extenstion swap function
    this[n1] = this[n2].also{ this[n2] = this[n1] }
}

// generic quick sort with hoare pivot extended on Array.
fun <T : Comparable<T>> Array<T>.sortHoare(low:Int = 0, high:Int = this.size-1) { // intially the range of the sort is complete array
    if(low < high){ // if the range contains at least 2 elements, the base for recursion
        val p = this.partitionHore(low, high) //quicksorting using Hoare partition/technique over the range and getting the middle pivot
        this.sortHoare(low, p) // recursive call for the first half before the pivot
        this.sortHoare(p+1,high) // recursive call for the second half after the pivot
    }
}

fun <T : Comparable<T>> Array<T>.partitionHore(low: Int, high: Int) : Int {
   val p = this[low] //Hoare partition always chooses the first number as the pivot
   var i = low-1 //decreasing low by 1 because of do-while loop
   var j = high+1 //increasing high by 1 because of do-while loop
   while(true){
       do{
           --j
       } while(this[j] > p) // keep decreasing j(moving towards beginning) till we get the number less than the pivot
       
       do{
           ++i
       } while(this[i] < p) // keep increasing teh i(moving towards the end) till we get an element greater than the pivot
       
       if(i < j){ // if i and j do not cross each other or overlap then we can swap 
            this.swapAt(i,j) // this will swap the element at j which is smaller than the pivot and element at i which is greater than or equal to the pivot
       } else {
           return j //returning j which is the pivot seperating the lists.
       }
   }
}

fun main(args: Array<String>){
   val arr = readLine()!!.split(' ').map{
       it.toInt()
   }.toTypedArray()
   arr.sortHoare() // in-place sort
   println(list.joinToString(" "))
}
    
