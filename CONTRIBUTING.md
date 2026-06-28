# Contributing to DSA Preparation

Thank you for contributing! To maintain code quality, consistency, and clean automation, this repository follows strict enterprise-grade development and Git workflows.

---

## Git Workflow: GitHub Flow

Always follow these steps when working on a new problem:

1. **Synchronize Main**:
   Ensure you have the latest changes from the remote repository.
   ```bash
   git checkout main
   git pull origin main
   ```

2. **Create a Feature Branch**:
   All work must be done in a dedicated feature branch. Do not commit directly to `main`.
   Branch naming convention: `feature/<category>-<problem-name>`
   *Example*: `feature/arrays-two-sum` or `feature/dp-climbing-stairs`
   ```bash
   git checkout -b feature/arrays-two-sum
   ```

3. **Solve & Document**:
   - Write the Java solution class in `src/main/java/com/balaji/leetcode/<category>/<ProblemName>.java`.
   - Write tests in `src/test/java/com/balaji/leetcode/<category>/<ProblemName>Test.java`.
   - Add markdown notes in `leetcode/<difficulty>/<problem-name>.md` using the problem-solution template.

4. **Verify Locally**:
   Run Maven tests and check formatting style:
   ```bash
   mvn clean test checkstyle:check
   ```

5. **Commit & Push**:
   Follow the [Conventional Commits](#commit-convention) guidelines.
   ```bash
   git add .
   git commit -m "feat(arrays): solve Two Sum"
   git push origin feature/arrays-two-sum
   ```

---

## Commit Convention

We follow the [Conventional Commits specification](https://www.conventionalcommits.org/):

* **`feat(<category>)`**: Solve a new problem.
  *Example*: `feat(arrays): solve Two Sum`
* **`docs(<category>)`**: Add/edit pattern or problem documentation.
  *Example*: `docs(sliding-window): add pattern explanation`
* **`refactor(<category>)`**: Improve an existing solution without changing its behavior.
  *Example*: `refactor(graphs): optimize BFS traversal`
* **`test(<category>)`**: Add or modify unit tests.
  *Example*: `test(tree): expand edge cases for Binary Tree Paths`
* **`chore`**: Maintenance tasks, dependency updates, or workflow adjustments.
  *Example*: `chore: update maven checkstyle dependency`

---

## Pull Request Automation

Upon pushing your branch to the remote repository, a GitHub Action will:
1. Validate branch naming and commit message format.
2. Run test execution (`mvn test`) and Checkstyle checks.
3. Automatically create a Pull Request targeting `main` with detailed descriptions extracted from your files.
4. Notify you (the developer) via email.

---

## Review and Merge Flow

1. **Developer Review**:
   - Review your own code in the newly created PR on GitHub.
   - If satisfied, approve the PR or apply the `approved` label. This acts as a sign-off.
2. **Final Approval**:
   - The Approver receives an email notification requesting final review.
   - Once the Approver approves the Pull Request on GitHub, another Action will automatically merge it into `main`, delete the feature branch, and notify both of you.
