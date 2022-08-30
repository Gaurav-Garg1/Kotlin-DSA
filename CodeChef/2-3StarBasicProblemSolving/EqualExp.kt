fun sol(){
   val (a,b,p,q)= readLine()!!.split(' ').map{
       it.toInt()
   }
   
   if(p%a != 0 || q%b != 0) {
       println("No")
       return
   }
   
   val daysA = p/a
   val daysB = q/b
   val absDiff = kotlin.math.abs(daysA-daysB)
   if(absDiff == 1 || absDiff == 0) println("Yes") else println("No")
}

fun main(args: Array<String>){
    repeat(readLine()!!.toInt()){
       sol()
    }
}
// is it possible for the skill level of p1 and p2 reach exactly p,q when starting from 0 
// and both have increase of a,b working each day
// they both work on alternate days.
// if "one of them" is on "same number of work days" or "one less" or "one more" day when they both are at p and q then it is possible.
