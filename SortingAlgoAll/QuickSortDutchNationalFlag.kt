// generic quicksort using dutch national flag technique
fun <T : Comparable<T>> Array<T>.swapAt(n1:Int, n2:Int) { //Extension function to swap
    this[n1] = this[n2].also{ this[n2] = this[n1] }
}

//using median of 3 as pivot
fun <T : Comparable<T>> Array<T>.dutchFlagSort(low: Int = 0, high:Int = this.size-1){
    if(low < high){
        //Can use first or last element as pivot too
        val middle = dutchPartition(low,high,this.median(low, high)) //calling dutch partition with the bounds indices and index of pivot which is meadian in this case.
        this.dutchFlagSort(low, middle.first - 1)
        this.dutchFlagSort(middle.second + 1, high)
    }
}

// partition will return the pair of index which encloses the sub list containing all elements equal to pivot
fun <T : Comparable<T>> Array<T>.dutchPartition(low: Int, high: Int, pi: Int) : Pair<Int,Int> { 
    val p = this[pi] // getting the value of pivot
    var smaller = low // setting index for elements smaller than pivot as low
    var equal = low  // setting index for elements equal to pivot as low
    var larger = high // setting index for elements larger than pivot as high
    while(equal <= larger){ // while equal does not overlap larger
        // we will be moving the index of equal ahead.
        if(this[equal] < p){  //if element is smaller than pivot place it at smaller index and increment both smaller and equal
            this.swapAt(smaller,equal)
            ++smaller
            ++equal
        } else if(this[equal] == p){ //if element is equal to pivot just increment the equal pointer
            ++equal
        } else { // now that the element is larger than the pivot swap it with the lager index and increment the index (equal will visit this again) 
            this.swapAt(equal, larger)
            --larger
        }
    }
    return Pair(smaller,larger) // the array is not partitioned better [smaller than pivot | equal to pivot | greater than pivot] and we returning that indices of pipes in the illustration.
}

fun <T : Comparable<T>> Array<T>.median(low:Int, high:Int):Int { //swapping first, last, middle s.t. the meadian is in center
    val center = (low + high) / 2
    if(this[low] > this[center]) this.swapAt(low, center)
    if(this[low] > this[high]) this.swapAt(low, high)
    if(this[center] > this[high]) this.swapAt(center,high)
    return center // returning the index of median
}

  // Another way to return the index of median when comparing the first last and middle without swapping them.
// fun <T : Comparable<T>> Array<T>.median(low:Int, high:Int): Int { 
//     val mid = this[(low + high) / 2]
//     val b = this[low]
//     val e = this[high]
//     if(b <= mid && mid <= e) return (low+high)/2 // Index of middle element which is median 
//     if(mid <= b && b <= e) return low // index of low element which is the median
//     return high // index of last element which is the median if control reaches here
// }

fun main(args: Array<String>){
   val list = readLine()!!.split(' ').map{
       it.toInt()
   }.toTypedArray()
   list.dutchFlagSort() // in place sort
   println(list.joinToString(" ")) 
}
    
