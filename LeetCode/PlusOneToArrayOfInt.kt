class Solution {
    fun plusOne(digits: IntArray): IntArray {
        val last = digits.last()
        if(last != 9){
            digits[digits.size - 1] = last+1
            return digits
        } // if last is not 9 then finish easily by ending with 9
        var flag = -1
        for(i in digits) {
            if(i != 9) {
                flag = 1
                break
            } // quickly check if there any digit other than 9 in complete array
        }
        
        if(flag == 1){  // if all are not 9 then increase till not 9 then break by adding 1
            for(i in digits.size-1 downTo 0){
                val cur = digits[i]
                if(cur == 9){
                    digits[i] = 0
                } else {
                    digits[i] = cur + 1
                    break
                }
            }
            return digits
        }
        
        val arr = IntArray(digits.size + 1) { 0 } // if all are 9 then increase size and return 
        arr[0] = 1
        return arr
    }
}
