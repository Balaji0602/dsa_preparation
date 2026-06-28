# DSA Pattern: Sliding Window

## 1. Introduction & Core Concept

The **Sliding Window** pattern is a method used to convert a nested loop problem into a single loop, thereby reducing time complexity from $O(N^2)$ or $O(N^3)$ to $O(N)$. It is used primarily on linear data structures (arrays, strings, or lists) when we need to find or analyze a contiguous block (subarray/substring) of elements that satisfies specific conditions.

There are two primary types of sliding windows:
1. **Fixed Size Window:** The window size $K$ is constant. We slide the window from left to right, adding one new element and removing one old element at each step.
2. **Variable Size/Dynamic Window:** The window size grows or shrinks dynamically depending on whether the current window satisfies a specific condition.

---

## 2. When to Use (Recognition Patterns)

Look for these key indicators in a problem description:
* **Keywords:** "contiguous subarray", "substring", "consecutive elements", "longest/shortest/maximum/minimum subarray".
* **Goal:** Optimize a subsegment (e.g., maximum sum of $K$ consecutive elements, longest substring with at most $K$ distinct characters).
* **Linear Structure:** The problem is based on arrays, strings, or singly linked lists.

---

## 3. Template Code Structure

### Variable Size Window Template (Java)
```java
public class SlidingWindowVariable {
    public int longestSubarray(int[] nums, int target) {
        int left = 0;
        int currentWindowSum = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            // Expand: Include the element at right pointer
            currentWindowSum += nums[right];

            // Shrink: Contract window from left while condition is violated
            while (currentWindowSum > target) {
                currentWindowSum -= nums[left];
                left++;
            }

            // Update: Record the optimal state (valid window sizes)
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
```

---

## 4. Complexity & Trade-offs

* **Time Complexity:** $O(N)$. Even though there is a nested `while` loop, the `left` pointer only moves forward and can visit each index at most once. Hence, the amortized cost is $O(N)$.
* **Space Complexity:** $O(1)$ if we only use variables to store state, or $O(K)$ or $O(\Sigma)$ if we use a Hash Map or Frequency Array to store unique element counts in the window.
* **Trade-off:** Sliding window requires the array to be indexed or processable from left to right. It cannot easily be applied if elements cannot be added/removed in $O(1)$ time.

---

## 5. Visual Representation

```
Fixed Window (size 3):
Step 1: [ 1  3  5 ] -2  4  1   (Sum = 9)
         L      R

Step 2:  1 [ 3  5  -2 ] 4  1   (Sum = 6; added -2, removed 1)
             L      R

Step 3:  1  3 [ 5  -2  4 ] 1   (Sum = 7; added 4, removed 3)
                L      R
```

---

## 6. Common Mistakes & Pitfalls

* **Off-by-One in Window Length:** The length of a contiguous window from index `left` to `right` is `right - left + 1`. Using `right - left` is a common bug.
* **Incorrect Shrinking Condition:** Ensure the contraction loop updates all tracking variables (e.g., hash maps, frequency arrays, sums) before incrementing `left`.
* **State Updates after Shrinking:** In variable-size windows, check if you should record/compare the length *before* or *after* the shrinking loop. Typically, it is done *after* the `while` loop when the window is guaranteed to be valid.

---

## 7. Recommended LeetCode Problems

| Problem # | Difficulty | Problem Name | Key Trick |
| :--- | :--- | :--- | :--- |
| 643 | Easy | [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/) | Fixed size window, track max sum |
| 3 | Medium | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Variable window, use Set/Map to track duplicate chars |
| 209 | Medium | [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) | Variable window, minimize length |
| 76 | Hard | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | Frequency array comparison, complex shrinking state |

---

## 8. Interview Tricks & Cheat Codes

* **Hash Map or Frequency Array:** If the problem involves tracking character counts (like anagrams or distinct characters), use a frequency array `new int[128]` instead of a `HashMap<Character, Integer>` for faster execution time and $O(1)$ space.
* **Shrink Only when Necessary:** For "longest subarray" problems, sometimes you don't need to shrink the window back to a valid state. You can keep the window size constant and just slide it along (meaning the window size never decreases, which matches the goal of finding the maximum length).
