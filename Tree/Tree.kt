class TreeNode<T>(val value: T) { // the val in class constructor makes value a property of the class

    private val children: MutableList<TreeNode<T>> = mutableListOf() //each node will keep track of all of its children
    //The property is private, so it can't be accessed from outside the class; need to use the functions defined in the class to
    // modify or access the value of children

    fun add(child: TreeNode<T>) = children.add(child) // add children to the node

    fun visitDepthFirst(visit: (TreeNode<T>) -> Unit) { //Depth traversal of tree
        visit(this)
        children.forEach {
            it.visitDepthFirst(visit)
        }
    }

    fun visitLevelFirst(visit: (TreeNode<T>) -> Unit) { //Level traversal of tree
        visit(this)
        val queue = ArrayDeque<TreeNode<T>>()
        children.forEach { queue.addFirst(it) }
        var node: TreeNode<T>? = queue.removeLastOrNull()

        while (node != null) {
            visit(node)
            node.children.forEach { queue.addFirst(it) }
            node = queue.removeLastOrNull()
        }
    }

    fun find(value: T): Boolean { //find a element in tree visiting level order or you can use depth first to prevent the extra space usage of O(n) for queue.
        var result = false
        visitLevelFirst {
            if (value == it.value) result = true
        }
        return result
    }

    fun printEachLevel() { //to print each level of the tree in a seprate line.
        val queue = ArrayDeque<TreeNode<T>>()
        queue.addFirst(this)
        var nodesInCurrentLevel: Int

        while (queue.isNotEmpty()) {
            nodesInCurrentLevel = queue.size

            while (nodesInCurrentLevel > 0) {
                val node = queue.removeLast()
                if(nodesInCurrentLevel != 1) print("${node.value}--") else print(node.value)

                node.children.forEach { queue.addFirst(it) }
                nodesInCurrentLevel--
            }
            println()
        }
    }
    
}

//The function in level order traversal and depth first traversal could be as simple as { println(it.value) }
//This will `visit` and print all the elements in their respective order.
