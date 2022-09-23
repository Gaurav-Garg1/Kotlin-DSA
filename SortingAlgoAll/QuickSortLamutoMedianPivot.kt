// Implenting median of 3 choice of pivot in Lamuto Sort, Meadian of 3 can be used in any version like Hoare, DutchFlag, etc

fun <T : Comparable<T>> Array<T>.swapAt(n1:Int, n2:Int){ //extension function for swapping
    this[n1] = this[n2].also{ this[n2] = this[n1] }
}

//take the first, last and middle elements and swap them in such a way that the median of those three will be in the middle
fun <T : Comparable<T>> Array<T>.median(low:Int = 0, high:Int = this.size-1):Int { 
    val center = (low + high) / 2
    if(this[low] > this[center]) this.swapAt(low, center)
    if(this[low] > this[high]) this.swapAt(low, high)
    if(this[center] > this[high]) this.swapAt(center,high)
    return center
}

fun <T : Comparable<T>> Array<T>.sortLamuto(low:Int = 0, high:Int = this.size-1) {
    if(low < high){
        val pi = this.median(low, high) // setting the median in the middle and getting the index
        this.swapAt(pi, high) // swapping the middle with the last so that the lamuto sort works the same
        val p = this.partitionLamuto(low, high) //partitioning/quicksorting using lamuto
        this.sortLamuto(low, p-1) //recursive call 
        this.sortLamuto(p+1,high) //recursive call
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
   list.sortLamuto()
   println(list.joinToString(" "))
}
    
