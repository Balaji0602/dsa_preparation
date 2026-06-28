# DSA Pattern: Binary Search

## 1. Introduction & Core Concept

**Binary Search** is an efficient algorithm for finding an item from a sorted list of items or searching for a specific value within a monotonic search space. It works by repeatedly dividing in half the portion of the list that could contain the item, reducing the search space from $N$ to $N/2$ at each step, resulting in a time complexity of $O(\log N)$.

Modern binary search is not just for searching sorted arrays. It can be applied to:
1. **Discrete Math / Binary Search on Answer:** Searching a range of integers to find the minimum or maximum valid configuration that satisfies a condition (e.g., minimum capacity needed to ship packages in $D$ days).
2. **Finding Boundaries:** Locating the first or last occurrence of an element or finding insertion indices (lower/upper bounds).

---

## 2. When to Use (Recognition Patterns)

Look for these key indicators:
* **Keywords:** "sorted array", "find in log(N) time", "minimize the maximum value", "maximize the minimum value".
* **Monotonicity:** If you can design a function `isValid(x)` such that if `isValid(x)` is true, then `isValid(y)` is also true for all $y > x$ (or vice versa).

---

## 3. Template Code Structure

### Classic Binary Search Template (Java)
```java
public class BinarySearchClassic {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Prevent integer overflow: left + (right - left) / 2
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Found target
            } else if (nums[mid] < target) {
                left = mid + 1; // Target lies in the right half
            } else {
                right = mid - 1; // Target lies in the left half
            }
        }
        return -1; // Target not found
    }
}
```

### Boundary Search (Lower Bound / First Occurrence)
```java
public class BinarySearchBoundary {
    public int findFirstOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // Note the upper bound

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid; // Narrow search to left half, including mid
            } else {
                left = mid + 1; // Narrow search to right half, excluding mid
            }
        }
        return left; // 'left' points to first index where value is >= target
    }
}
```

---

## 4. Complexity & Trade-offs

* **Time Complexity:** $O(\log N)$ for searching. If the array is unsorted, sorting it takes $O(N \log N)$, which makes binary search only worth it if you perform multiple queries.
* **Space Complexity:** $O(1)$ for iterative binary search.
* **Trade-off:** Requires random access ($O(1)$ indexing). It cannot be used directly on singly linked lists because accessing elements by index takes $O(N)$ time.

---

## 5. Visual Representation

```
Search Space: Target = 7
Index:  0   1   2   3   4   5   6
Array: [1,  3,  4,  6,  7,  8,  10]
        L           M           R   (Mid = index 3, Val = 6 < 7. Move L = Mid + 1)

Array: [1,  3,  4,  6,  7,  8,  10]
                        L   M   R   (Mid = index 5, Val = 8 > 7. Move R = Mid - 1)

Array: [1,  3,  4,  6,  7,  8,  10]
                        L           (Mid = index 4, Val = 7 == 7. Found!)
                        R
```

---

## 6. Common Mistakes & Pitfalls

* **Integer Overflow:** Writing `int mid = (left + right) / 2`. If `left` and `right` are large positive integers, their sum will exceed `Integer.MAX_VALUE` and overflow to a negative value. Always write `int mid = left + (right - left) / 2`.
* **Infinite Loops:** Using incorrect boundary updates. For example, if your condition is `while (left < right)` and you write `left = mid`, you can get stuck in an infinite loop when `left` and `right` are adjacent because integer division rounds down.
* **Incorrect Return Value:** Not understanding what `left` represents when the loop terminates. Depending on your design, `left` represents the insertion point or the first valid element.

---

## 7. Recommended LeetCode Problems

| Problem # | Difficulty | Problem Name | Key Trick |
| :--- | :--- | :--- | :--- |
| 704 | Easy | [Binary Search](https://leetcode.com/problems/binary-search/) | Standard implementation |
| 34 | Medium | [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | Implement lower bound and upper bound |
| 33 | Medium | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) | Determine which side of the rotation is sorted |
| 875 | Medium | [Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/) | Binary search on answer space (speed range) |

---

## 8. Interview Tricks & Cheat Codes

* **Search Space Bounds:** When doing binary search on answers, determine your boundaries (`low` and `high`) clearly. `low` is the minimum possible answer (e.g. 1 banana per hour) and `high` is the maximum possible answer (e.g. max bananas in a single pile).
* **Verify monotonicity:** Make sure that if a candidate answer is valid, all answers greater (or smaller) are also guaranteed to be valid. If this property holds, you can use binary search.
