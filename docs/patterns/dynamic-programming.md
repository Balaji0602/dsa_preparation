# DSA Pattern: Dynamic Programming

## 1. Introduction & Core Concept

**Dynamic Programming (DP)** is a technique used to solve complex problems by breaking them down into simpler subproblems, solving each subproblem exactly once, and storing their solutions (usually in an array or hash map) to avoid redundant computations.

A problem can be solved using Dynamic Programming if it exhibits two key properties:
1. **Overlapping Subproblems:** The problem can be broken down into subproblems which are reused multiple times (e.g., calculating Fibonacci numbers).
2. **Optimal Substructure:** The optimal solution to the problem can be constructed from the optimal solutions of its subproblems.

There are two primary implementation methods:
- **Top-Down (Memoization):** Starts with the target problem and recursively breaks it down, caching results of subproblems.
- **Bottom-Up (Tabulation):** Solves all small subproblems first, storing results in a table, and uses them to build up to the target problem.

---

## 2. When to Use (Recognition Patterns)

Look for these key indicators:
* **Keywords:** "maximum/minimum cost", "longest/shortest path", "number of distinct ways to...", "subset/knapsack".
* **State Dependence:** The decision at step $i$ depends on the decisions made at previous steps $i-1, i-2, \dots$.

---

## 3. Template Code Structure

### 1D Dynamic Programming: Bottom-Up Tabulation (Java)
Using the classic "Climbing Stairs" problem (Fibonacci sequence dynamic calculation).

```java
public class ClimbingStairsDP {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        // DP Table to store subproblem results
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        // State Transition: dp[i] = dp[i-1] + dp[i-2]
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
```

### 1D Dynamic Programming: Space Optimized (Java)
Since we only need the last two states, we can optimize space from $O(N)$ to $O(1)$.

```java
public class ClimbingStairsSpaceOptimized {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int prev2 = 1; // dp[i-2]
        int prev1 = 2; // dp[i-1]

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
```

---

## 4. Complexity & Trade-offs

* **Time Complexity:** $O(State \times Transition\_Time)$. For standard 1D DP, this is typically $O(N)$. For 2D DP (e.g., Grid paths, Knapsack), it is $O(M \times N)$.
* **Space Complexity:**
  - $O(N)$ or $O(M \times N)$ for tables.
  - Can often be optimized to $O(1)$ or $O(\min(M, N))$ by discarding obsolete states and only keeping the last row/column.
* **Trade-off:** Bottom-Up (Tabulation) avoids recursive call stack overhead, but Top-Down (Memoization) might solve fewer subproblems if not all states are reachable.

---

## 5. Visual Representation

```
Subproblem Dependency Grid (2D DP / Grid Path):
To calculate (i, j), we rely on (i-1, j) and (i, j-1):

   [ (i-1, j-1) ] -> [  (i-1, j)  ]
                            |
   [  (i, j-1)  ] -> [    (i, j)  ] (Current State)
```

---

## 6. Common Mistakes & Pitfalls

* **Incorrect Base Cases:** Setting incorrect initial values (e.g., $dp[0]$ or $dp[1]$) which leads to array index out of bounds or calculation errors.
* **Array Index Out of Bounds:** Forgetting to handle inputs smaller than base-case indices (e.g., passing $n=1$ when your code initializes $dp[2]$ directly).
* **State Transition Misalignment:** Defining a transition that references out-of-order states or values that have not been computed yet. Ensure bottom-up loops run in correct direction (forward or backward).

---

## 7. Recommended LeetCode Problems

| Problem # | Difficulty | Problem Name | Key Trick |
| :--- | :--- | :--- | :--- |
| 70 | Easy | [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) | 1D DP, space optimization to O(1) |
| 322 | Medium | [Coin Change](https://leetcode.com/problems/coin-change/) | Unbounded knapsack, track min coins |
| 1143 | Medium | [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/) | 2D DP grid matching characters |
| 72 | Hard | [Edit Distance](https://leetcode.com/problems/edit-distance/) | 2D DP matching string mutations |

---

## 8. Interview Tricks & Cheat Codes

* **The DP Framework:**
  1. **Define the State:** What does `dp[i]` or `dp[i][j]` represent in plain English? (e.g., "Maximum profit using up to index `i` with weight capacity `j`").
  2. **State Transition:** Find the equation linking states together.
  3. **Base Cases:** Define boundary values.
* **Knapsack Traversal Order:** In 0/1 Knapsack optimization, when compressing a 2D table into a 1D array, you must run the inner loop **backwards** to prevent using the same item multiple times.
