# Solutions explanation

* Two Sum
    * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        ####Example:

        ```
        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].
        ```

        ####Explanation:
        For each number in the array, we want to check if any other numbers in the array form a complement to make the target (`target - nums[i] == nums[?]`). Create a Map which maps a `num` to its `index` to track which numbers we have seen in the array. We can access them quickly by doing a `.contains` to tell us whether the map contains a `num` key that equals the current complement we are looking for (`target - nums[i]`). Once we've checked if the current complement we're looking for satisfies the answer, we can return it. Else, we add the current number and its index to the complement lookup map
        
        
* [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)
    * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
      
      You may assume the two numbers do not contain any leading zero, except the number 0 itself.
      ####Example:
        ```
        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        Explanation: 342 + 465 = 807.
        ```
      
      ####Explanation:
      A recursive solution involves a few checks
      * If both digits are not defined, there's no way to add their contents, so return None
      * If one digit is defined, you can return it because there is nothing to add it to, you need to pass it back to the previous step to add it to the next lowest digit of the other number
      * If both digits are defined, check whether their sum is less than 10. If so, create a digit with that sum, then set the digit's next value to a recursive call to add the next 2 digits
      * If their sum is greater than 10, create a digit with their sum minus 10. Then set that digit's next value to a recursive call where the first digit is a 1 (from the carry over) and the second digit is a recursive call to add the next 2 digits
      
      
* [Longest Substring Without Repeats](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
    * Given a string, find the length of the longest substring without repeating characters.
    
    ####Explanation:
    * Track unique characters and the index they were last seen at in a Map[Char, Int]
    * Iterate through the string adding characters and their index to the map if they don't already exist in the map
    * If a letter exists in the map
        * Set the tracker to the index where it was first seen, the longest substring may continue from the character after where it was first seen
        * Clear the map and increment the tracker
    * Make sure to track the length of the longest substring in an int variable and replace the length when it gets longer
    