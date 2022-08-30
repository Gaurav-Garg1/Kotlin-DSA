fun sol(){
   val (n,k) = readLine()!!.split(' ').map{
       it.toInt()
   }
   fun gcd(x: Int ,y : Int): Int {
        if(y == 0) return x
        return gcd(y , x%y)
   }
   println(n/gcd(n,k)) //printing the LCM/slices i.e x*y/gcd(x,y) because X*Y = LCM * GCD of X,Y
   // LCM will be multiple of n and k so will be devided by k easily
}
fun main(args: Array<String>){
    repeat(readLine()!!.toInt()){
       sol()
    }
}
// N people , K slices per pizza to find minimum number for everyone to get equal number of slices
// answer will be LCM / K = number of pizza
