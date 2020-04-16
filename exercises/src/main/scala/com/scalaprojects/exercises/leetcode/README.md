# Solutions explanation

* [Two Sum](https://leetcode.com/problems/two-sum/)
    * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        #### Example:

        ```
        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].
        ```

        #### Explanation:
        For each number in the array, we want to check if any other numbers in the array form a complement to make the target (`target - nums[i] == nums[?]`). Create a Map which maps a `num` to its `index` to track which numbers we have seen in the array. We can access them quickly by doing a `.contains` to tell us whether the map contains a `num` key that equals the current complement we are looking for (`target - nums[i]`). Once we've checked if the current complement we're looking for satisfies the answer, we can return it. Else, we add the current number and its index to the complement lookup map
        
        
* [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)
    * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
      
      You may assume the two numbers do not contain any leading zero, except the number 0 itself.
      #### Example:
        ```
        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        Explanation: 342 + 465 = 807.
        ```
      
      #### Explanation:
      A recursive solution involves a few checks
      * If both digits are not defined, there's no way to add their contents, so return None
      * If one digit is defined, you can return it because there is nothing to add it to, you need to pass it back to the previous step to add it to the next lowest digit of the other number
      * If both digits are defined, check whether their sum is less than 10. If so, create a digit with that sum, then set the digit's next value to a recursive call to add the next 2 digits
      * If their sum is greater than 10, create a digit with their sum minus 10. Then set that digit's next value to a recursive call where the first digit is a 1 (from the carry over) and the second digit is a recursive call to add the next 2 digits
      
      
* [Longest Substring Without Repeats](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
    * Given a string, find the length of the longest substring without repeating characters.
    
        #### Explanation:
        * Track unique characters and the index they were last seen at in a Map[Char, Int]
        * Iterate through the string adding characters and their index to the map if they don't already exist in the map
        * If a letter exists in the map
            * Set the tracker to the index where it was first seen, the longest substring may continue from the character after where it was first seen
            * Clear the map and increment the tracker
        * Make sure to track the length of the longest substring in an int variable and replace the length when it gets longer

* [Container with Most Water](https://leetcode.com/problems/container-with-most-water/) 
    * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
      
      Note: You may not slant the container and n is at least 2.
      
      In plain English, you are trying to maximize the area contained between 2 bars in a bar chart using the x-axis as the width, and the height of the lowest bar as the height. Which 2 bars create the container of maximum area?
      #### Example: 
      See unit tests
      
      #### Explanation:
      * Start with the container of maximum width
      * Look at the next bar inward from the shorter bar and check if new container area is greater than the max seen
      * Continue until you are checking bars directly next to each other
      
* [Convert a Sorted Array to a Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)
    * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
      
      For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
    
      #### Example:
      Given the sorted array: [-10, -3, 0, 5, 9],
      
      One possible answer is: [0, -3, 9, -10, null, 5], which represents the following height balanced BST:
      
      ```
            0
           / \
         -3   9
         /   /
       -10  5
      ```
      
      #### Explanation:
      * A sorted array is the same thing as an in-order traversal of a binary search tree
      * We know binary search trees have their mid value at the root, so an in-order traversal should give us the mid value at the middle of the array as well
      * The left and right subtrees can be constructed from the values on each side of the mid value of the array in a similar way as the full array
      * Luckily, this tree comes out height-balanced because there are an equal number of values in the array on each side of the first mid value
      
* [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)
    * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
      
      #### Example:
      This binary tree is symmetric:
      ```
               1
            /     \
           2       2
          / \     / \
         3   4   4   3
        /|  /|   |\  |\
       5 6 5 6   6 5 6 5 
      ```
      
      But the following is not:
      ```
          1
         / \
        2   2
         \   \
         3    3
      ```
      
      #### Explanation:
      * Need to check if all subtrees off the root are symmetric
      * 2 children tree are symmetric
        * L child and their sibling's R child are roots of symmetric trees
        * R child and their sibling's L child are roots of symmetric trees
      * First check if both the roots are null, if they are the trees are obviously symmetric (null tree is symmetric with null tree)
      * Then check if either of the roots is null, but not both (XOR). If so, the trees are asymmetric
      * Finally check if the values or the roots are the same
      * 2 recursive calls to `isSymmetric` with root1.left/root2.right, root1.right/root2.left. Place an `&&` between these calls because we need them both to be symmetric for the whole tree to be
      
* [Flip Equivalent Binary Trees](https://leetcode.com/problems/flip-equivalent-binary-trees/) 
    * For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.
    
    A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.
      
     #### Example:
     We flipped at nodes with values 1, 3, and 5.
     ![Example](https://assets.leetcode.com/uploads/2018/11/29/tree_ex.png)
     
     #### Explanation:
     * Similar to symmetric trees above
     * 4 recursive calls
     * 2 trees are only FEQ if
        * R1's L tree is FEQ with either the L or R tree of R2 (2 calls)
        * AND
        * R2's L tree is FEQ with either the L or R tree of R1 (2 calls)
        * This can be expressed as 
        ```
        FEQ(R1L, R2L) || FEQ(R1L, R2R)
       
        &&
       
        FEQ(R1R, R2L) || FEQ(R1R, R2R)
        ```
     * Base cases are
        * Each root is `null` (true)
        * One root is `null`, other is not (false)
        * Each root is not null, but not equal (false)
    
* [Sum of nodes with even-valued grandparent](https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/)
    * Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)
      
      If there are no nodes with an even-valued grandparent, return 0.
      
    #### Example:
    ![Example](https://assets.leetcode.com/uploads/2019/07/24/1473_ex1.png)
    
    Output: 18
    
    #### Explanation:
    * Need to tell all recursive calls whether they should add their children to their return sum depending on whether the current root is even/odd
    * Calculate the value for each child
        * Each child must be not-null and the flag for summing children must be true, else the child should be a 0
    * Add the sums for each child (possibly 0 if not summing or they are null) to recursive calls using the subtrees ie `sumEvenGrandparentHelper(r.left, isEven)`

* [Leaf-Similar Trees](https://leetcode.com/problems/leaf-similar-trees/)     
    ![Example](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/16/tree.png)
    * For example, in the given tree above, the leaf value sequence is `(6, 7, 4, 9, 8)`.
    * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
      
    * Return `true` if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
    
    #### Explanation:
    * Generate a leaf-sequence for each tree and compare them
    * Leaf sequence is generated by determining whether the function is at a leaf and returning its value if so
