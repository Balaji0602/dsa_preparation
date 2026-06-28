# Coding Interview Strategies & Notes

## 1. The 5-Step Interview Strategy

1. **Clarify Requirements**:
   - Ask about input data types (integers, negative numbers, floats?).
   - Ask about array sizes (can it be empty? what is the maximum size?).
   - Ask about duplicate values.
   - Clarify time and space expectations before writing code.

2. **Discuss Multiple Approaches**:
   - Start with a brute-force approach, state its complexity, and explain why it is suboptimal.
   - Pivot to optimal approach, discussing data structures (HashMaps, Heaps, Stacks).
   - Write down complexity details BEFORE writing any code.

3. **Dry Run on Whiteboard**:
   - Walk through the logic with a sample input.
   - Explicitly draw pointers and state modifications.

4. **Write Clean, Modular Code**:
   - Use meaningful variable names (e.g. `left`, `right`, `seen` instead of `i`, `j`, `s`).
   - Keep logic separated. Use helper methods if appropriate.

5. **Test Edge Cases**:
   - Walk through empty, small, or extreme inputs.
   - Point out any potential improvements.

---

## 2. Dynamic Communication Techniques

* **Talk out loud:** Explain every line you write. "I am initializing a left pointer at index 0 because..."
* **Write pseudo-comments:** Before writing code, write comments mapping out your steps.
* **Propose enhancements:** "If this array was too large to fit in memory, we could..."

---

## 3. High-Frequency Behavioral Prep (STAR Method)

* **S - Situation:** Set the context.
* **T - Task:** Detail the challenge.
* **A - Action:** What did YOU do?
* **R - Result:** Quantitative outcome.
