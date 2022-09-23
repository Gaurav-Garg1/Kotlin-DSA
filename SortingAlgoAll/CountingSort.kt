// Strengths:
// Linear time. Counting sort runs in O(n) time, making it asymptotically faster than comparison-based sorting algorithms like quicksort or merge sort.
// Weaknesses:
// Restricted inputs. Counting sort only works when the range of potential items in the input is known ahead of time.
// Space cost. If the range of potential values is big, then counting sort requires a lot of space (sometimes more than O(n)).

// Assuming - The input size here is 1e6 but the range of input is 1-100[both inclusive] so counting sort is the best candidate in such case
fun main(args: Array<String>){
   val fa = Array<Int>(100){ 0 } // frequncy array of 1-100
   readLine()!!.split(' ').forEach{
       ++arr[it.toInt() - 1] // for each occurance of an element between the given range increase the associated index by 1
   }
   val sb = StringBuilder() // to build the sorted string
   for(i in 1..100){ // iterating over the indices
       repeat(arr[i-1]){ // adding the index to the string * frequency
           sb.append("$i ") // must use string builder, do not print directly to console as it will take too much time
       }
   }
   println(sb.toString()) // you can trim the extra trailing space if you want.
}
