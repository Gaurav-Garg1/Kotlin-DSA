fun main(){ // Testing the Tree in Testing Tree
    val tree = dsTree()
    tree.visitDepthFirst { println(it.value) }
    println("-----------")
    tree.visitLevelFirst { println(it.value) }
    println("-----------")
    tree.printEachLevel()
    println("-----------")
    println(tree.find("Graph"))
    println(tree.find("AVL Tree"))
}

fun dsTree():TreeNode<String>{ //Function to nice dsa tree for us.
    val root = TreeNode("Data_Structures")

    val easy = TreeNode("Easy")
    val vEasy = TreeNode("Very_Easy")

    val arr = TreeNode("Array")
    val ll = TreeNode("Linked_List")
    val st = TreeNode("Stack")
    val queue = TreeNode("Queue")

    val tr = TreeNode("Tree")
    val gr = TreeNode("Graph")

    val a1 = TreeNode("Single_Dimensional_Array")
    val a2 = TreeNode("Multi_Dimensional_Array")
    val l1 = TreeNode("Slingly")
    val l2 = TreeNode("Doubly")
    val l3 = TreeNode("Circular")

    val tr1 = TreeNode("Binary Tree")
    val tr2 = TreeNode("BST")
    val tr3 = TreeNode("Trie")

    root.run {
        add(vEasy)
        add(easy)
    }
    vEasy.run {
        add(arr)
        add(ll)
        add(st)
        add(queue)
    }
    easy.run {
        add(tr)
        add(gr)
    }
    arr.run {
        add(a1)
        add(a2)
    }
    ll.run {
        add(l1)
        add(l2)
        add(l3)
    }
    tr.run {
        add(tr1)
        add(tr2)
        add(tr3)
    }
    return root
}
