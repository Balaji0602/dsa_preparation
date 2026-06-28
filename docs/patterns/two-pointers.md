# DSA Pattern: Two Pointers

## 1. Introduction & Core Concept

The **Two Pointers** pattern uses two index pointers to traverse a linear data structure (such as an array or a linked list) simultaneously. By coordinating the motion of these pointers, we can search for pairs, reverse arrays, or detect cycles in $O(N)$ time instead of resorting to nested loops.

There are three main variations:
1. **Opposite End Pointers:** Pointers start at opposite ends (`left = 0`, `right = N-1`) and move toward each other (e.g., sorting, reversing, binary search).
2. **Fast & Slow Pointers (Floyd's Cycle Detection):** Pointers move in the same direction at different speeds (`slow` moves 1 step, `fast` moves 2 steps at a time) (e.g., cycle detection, finding middle of linked list).
3. **Partition / Same-Direction Pointers:** One pointer iterates normally, while another tracks the boundary of elements matching a specific condition (e.g., in-place removal, Dutch National Flag).

---

## 2. When to Use (Recognition Patterns)

Look for these key indicators:
* **Keywords:** "sorted array/list", "pairs that sum to X", "reverse", "palindrome", "cycle in linked list".
* **Goal:** Process elements relative to each other (e.g., merging two sorted arrays).
* **Constraints:** Must operate in-place with $O(1)$ extra space.

---

## 3. Template Code Structure

### Opposite End Two-Pointer Template (Java)
```java
public class TwoPointersOpposite {
    public boolean hasTargetPair(int[] sortedNums, int target) {
        int left = 0;
        int right = sortedNums.length - 1;

        while (left < right) {
            int currentSum = sortedNums[left] + sortedNums[right];
            if (currentSum == target) {
                return true; // Found the pair
            } else if (currentSum < target) {
                left++; // Increase sum by moving left pointer to the right
            } else {
                right--; // Decrease sum by moving right pointer to the left
            }
        }
        return false;
    }
}
```

### Fast & Slow Pointer Template (Java)
```java
public class FloydCycleDetection {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // Moves 1 step
            fast = fast.next.next;    // Moves 2 steps
            if (slow == fast) {
                return true; // Cycle detected
            }
        }
        return false; // Reached end of list, no cycle
    }
}
```

---

## 4. Complexity & Trade-offs

* **Time Complexity:** $O(N)$ since the array is traversed in a single pass.
* **Space Complexity:** $O(1)$ as we only maintain index pointers.
* **Trade-off:** Opposite-end pointer approaches generally require the input array to be sorted. Sorting beforehand takes $O(N \log N)$ time, which may negate the $O(N)$ traversal unless the array is already sorted.

---

## 5. Visual Representation

```
Opposite End Pointers (Finding Sum = 10 in sorted array):
Array: [ 2  3  5  8  9 ]
        L            R    --> Sum = 2 + 9 = 11 > 10 (Move Right Leftwards)

Array: [ 2  3  5  8  9 ]
        L         R       --> Sum = 2 + 8 = 10 == 10 (Found!)
```

---

## 6. Common Mistakes & Pitfalls

* **Array Out of Bounds:** Forgetting to check if `left < right` or `right >= 0` inside custom update loops.
* **Dead Loops:** Forgetting to increment or decrement pointers within all logic paths of the `while` loop.
* **Fast Pointer Null Pointer Exception (NPE):** In Fast & Slow pointer problems, forgetting to check both `fast != null` and `fast.next != null` in the loop condition.

---

## 7. Recommended LeetCode Problems

| Problem # | Difficulty | Problem Name | Key Trick |
| :--- | :--- | :--- | :--- |
| 125 | Easy | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/) | Opposite end pointers, skip non-alphanumeric chars |
| 167 | Medium | [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | Opposite end pointers on sorted array |
| 141 | Easy | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) | Fast & slow pointer collision |
| 11 | Medium | [Container With Most Water](https://leetcode.com/problems/container-with-most-water/) | Opposite pointers, move the smaller height |

---

## 8. Interview Tricks & Cheat Codes

* **Sorting first:** If you encounter a problem searching for pairs/triplets and the array isn't sorted, sort it first. The sorting time $O(N \log N)$ combined with $O(N)$ two-pointer traversal is usually much faster than the $O(N^2)$ brute-force lookup.
* **Linked List Middle:** To find the midpoint of a linked list without counting, use the Fast & Slow approach. When the fast pointer reaches the end, the slow pointer will be exactly at the middle element.
