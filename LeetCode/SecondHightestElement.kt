class Solution {
    fun dominantIndex(nums: IntArray): Int {
        var H = 0 // to store Highest value
        var sH = 0 // to store Second Highest value
        var ind = 0 // to store the index of the highest value
        for(i in 0 until nums.size){ 
            val cur = nums[i] // to reduce access by one
            if(H < cur){ // set values when a value is greater than Highest 
                sH = H 
                H = cur
                ind = i     
            } else if(cur != H && sH < cur) sH = cur //if the element is between highest and Second highest
        }
        //This approach to find second highest only requires 1 traversal and no sorting.
        return if(sH*2 <= H) ind else -1 // return if highest is atleat twice as big 
    }
}
