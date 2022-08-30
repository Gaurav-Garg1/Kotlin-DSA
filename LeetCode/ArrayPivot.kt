class Solution {
    fun pivotIndex(nums: IntArray): Int {
        var sum = 0
        nums.forEach { // first calculating the sum of the array
            sum += it
        }
        var lsum = 0 //will keep track of left sum to find the leftmost piviot
        var ind = -1
        for(i in 0 until nums.size){ 
            val cur = nums[i] // reducing the array access by 1
            sum -= cur // reducing the current value form sum
            if(sum == lsum){ // checking if sum matches
               ind = i
               break
            }
            lsum += cur // adding the current value to left sum
        }
        return ind // returning the answer
    }
}
