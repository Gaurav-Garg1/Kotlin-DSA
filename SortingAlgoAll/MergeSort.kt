// Generic MergeSort
fun <T : Comparable<T>> List<T>.mergeSort():List<T>{ 
    if(this.size < 2) return this // if the size of list is less than 2 then it's sorted so return, also the base condition for recursion.
    val middle = this.size/2 //split the list at this middle point
    val left = this.subList(0,middle).mergeSort() //keep splitting the list on left and right side
    val right = this.subList(middle,this.size).mergeSort()
    
    return merge(left,right) // when both the left and right side are end of recursion tree start merging and move upward
}

private fun <T : Comparable<T>> merge(left: List<T>, right: List<T>) : List<T>{ //merge function to merge left and right lists
    var li = 0 // left index
    var ri = 0  // right index
    val result = mutableListOf<T>() // result of the join of left and right will be stored here
    while(li < left.size && ri < right.size){ //while both the index are withing the bounds
        val le = left[li] //left element
        val re = right[ri] //right element 
        
        if(le < re){ // if left element is small add it to the result and increment the left index
            result.add(le)
            li++
        } else if (le > re){ // if left element is greater then add right element to the result and increment the right index
            result.add(re)
            ri++
        } else { // both are equal so add both of them and increment both indices
            result.add(le)
            result.add(re)
            li++
            ri++
        }
    }
    // now at least one of the index is out of bounds meaning either left or right is completely sorted and added to result list
    if(li < left.size) result.addAll(left.subList(li,left.size)) //whichever the list has elements left in it add all of them to the result
    if(ri < right.size) result.addAll(right.subList(ri,right.size))
    
    return result
}

fun main(args: Array<String>){
   val list = readLine()!!.split(' ').map{
       it.toInt()
   }
   println(list.mergeSort().joinToString(" "))
}
