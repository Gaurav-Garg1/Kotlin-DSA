//Bubble Sort -> We check pairs of element in array n times and place the greatest or smallest at its correct position 
//               We do this n times to sort the complete array. 
//               Time Complexity is O(n^2) even in best case. Space Complexity is O(1) as there is no use of DS proportional to the size of the array.


//Ascending order.
fun bubbleSort(arr: Array<Int>){
    for(i in 0 until arr.size) // i -> 0..arr.size-1
        for(j in 0 until arr.size-i-1) // j -> 0..arr.size-i -1 -1 { 1st minus one is because array.size is out of bounds and 2nd minus one is because we want to stop one step before as we are accessing array.size-1 as we are accessing j+1 inside the if condition.}
            if(arr[j] > arr[j+1]) arr[j] = arr[j+1].also { arr[j+1] = arr[j] } //swap
}

fun sol(){
   val arr = readLine()!!.split(' ').map{
       it.toInt()
   }.toTypedArray()
   
   bubbleSort(arr)
   println(arr.joinToString(" "))
}

fun main(args: Array<String>){
    repeat(readLine()!!.toInt()){
       sol()
    }
}

//Ascending order alternate loop to omit double access or storing of size.
fun bubbleSortAlt(arr: Array<Int>){
    for(i in arr.size-1 downTo 0) //both inclusive
        for(j in 0 until i) //right limit exclusive
            if(arr[j] > arr[j+1]) arr[j] = arr[j+1].also { arr[j+1] = arr[j] }
}

//For descending order sort you just need to change the comparator symbol arr[j] < arr[j+1]
//What this will do is just keep pushing the smallest element to the last instead of the greatest element 
//Thus will sort the array in descending order.

//Instead the bubbling up the largest or smallest elemnt to end you can just bubble them to front by reversing the loops
//Its just the concept that matters.
