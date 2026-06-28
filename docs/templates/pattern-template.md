# DSA Pattern: [Pattern Name]

## 1. Introduction & Core Concept

<!-- Describe the pattern, the fundamental logic behind it, and why it is useful. -->

---

## 2. When to Use (Recognition Patterns)

Look for these key indicators or phrases in a problem description:
* **Indicator 1:** <!-- e.g., "Find contiguous subarray matching condition X" -->
* **Indicator 2:** <!-- e.g., "Sorted array and searching for a pair" -->
* **Indicator 3:** <!-- e.g., "Top K elements" -->

---

## 3. Template Code Structure

Here is the standard Java template for implementing this pattern:

```java
public class PatternTemplate {
    // Template methods
}
```

---

## 4. Complexity & Trade-offs

* **Time Complexity range:** $O(N)$ to $O(N \log N)$
* **Space Complexity range:** $O(1)$ to $O(N)$
* **Trade-offs:** <!-- Space vs. Time trade-offs, stability, recursion depth etc. -->

---

## 5. Visual Representation

<!-- Simple ASCII flow diagram or description of how pointers/datastructures move. -->
```
Example Visualization:
[ L . . . . . R ]   --> Window expands
  L   [ . . . R ]   --> Left pointer shrinks window
```

---

## 6. Common Mistakes & Pitfalls

* **Mistake 1:** <!-- e.g., Off-by-one errors on boundary conditions -->
* **Mistake 2:** <!-- e.g., Forgetting to update pointers inside loops -->

---

## 7. Recommended LeetCode Problems

| Problem # | Difficulty | Problem Name | Key Trick |
| :--- | :--- | :--- | :--- |
| 1 | Easy | [Problem](link) | Basic implementation |
| 2 | Medium | [Problem](link) | Managing state changes |
| 3 | Hard | [Problem](link) | Combining with other patterns |

---

## 8. Interview Tricks & Cheat Codes

* **Trick 1:** <!-- e.g., "If it is an array and asks for subarray, try sliding window first." -->
* **Trick 2:** <!-- e.g., "Use a dummy head for linked list operations to simplify boundary conditions." -->
