//Generic QuickSort with Lamuto Pivot

fun <T : Comparable<T>> Array<T>.swapAt(n1:Int, n2:Int){ //swap extension function
    this[n1] = this[n2].also{ this[n2] = this[n1] }
}

fun <T : Comparable<T>> Array<T>.sortLamuto(low:Int = 0, high:Int = this.size-1) { //by default the low and high are the first and the last index
    if(low < high){ // if the list has more than 1 element, the base to end recursion
        val p = this.partitionLamuto(low, high) //quick sorting the current list to get the index of the Pivot and then sort on both sides of it
        this.sortLamuto(low, p-1) //recursive call on the first half of list
        this.sortLamuto(p,high) // recursive call on the other half of list
    }
}

fun <T : Comparable<T>> Array<T>.partitionLamuto(low: Int, high: Int) : Int {
   val p = this[high] //Lamuto Always chooses highest element as Piviot
   var i = low // the index at which the pivot will be; to return the index of pivot in the end 
   for(j in low until high){ // traversing all the indices from low to high and comparing with the pivot
        if(this[j] <= p){ // if the index is less or equal to the pivot we place them in front using `i` and increment i
            this.swapAt(i,j) 
            i++
       }
   }
   this.swapAt(i,high) // put the pivot at i and now the array is divided into 2 sections one less than pivot other greater
   return i //returning the index of the pivot that will be used to determine the next sub lists for the sort.
}

fun main(args: Array<String>){
   val list = readLine()!!.split(' ').map{
       it.toInt()
   }.toTypedArray()
   list.sortLamuto() //inplace sorting
   println(list.joinToString(" ")) 
}
    
