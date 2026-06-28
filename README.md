# Data Structures & Algorithms (DSA) Preparation Workspace

[![Java Version](https://img.shields.io/badge/Java-21-orange.svg?style=for-the-badge&logo=openjdk)](https://openjdk.org/)
[![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen.svg?style=for-the-badge&logo=githubactions)](https://github.com/)
[![Code Quality](https://img.shields.io/badge/Checkstyle-Google-blue.svg?style=for-the-badge&logo=checkmarx)](https://checkstyle.sourceforge.io/)
[![License](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)

An enterprise-grade, highly automated Java workspace designed for mastering Data Structures & Algorithms and solving LeetCode problems at scale. This repository enforces robust DevOps workflows, continuous integration, static analysis, and automated PR-to-merge pipelines.

---

## 🎯 Repository Purpose

This repository is built to store, test, and document solutions to LeetCode and standard DSA problems. Rather than a flat list of files, this workspace organizes code by **algorithmic patterns** and **problem difficulty**, making it scalable to maintain 1000+ problems while providing detailed complexity analysis, visualizations, and interview-ready notes.

---

## 📂 Repository Structure

The workspace follows a strict separation of concerns, separating source code (src) from documentation (docs and leetcode directories):

```
dsa-preparation/
│
├── .github/                       # GitHub Actions workflows & community templates
│   ├── ISSUE_TEMPLATE/            # Issue formats (bug report, feature requests)
│   ├── workflows/                 # Automated CI/CD workflows
│   ├── CODEOWNERS                 # Automatic reviewer assignments
│   └── PULL_REQUEST_TEMPLATE.md   # PR description format
│
├── docs/                          # Core reference documents
│   ├── patterns/                  # Detailed explanations of DSA patterns
│   └── templates/                 # Reusable markdown templates
│
├── leetcode/                      # Markdown analysis by difficulty
│   ├── easy/                      # Easy problems (e.g. 0001-two-sum.md)
│   ├── medium/                    # Medium problems
│   └── hard/                      # Hard problems
│
├── src/                           # Java source directories
│   ├── main/java/com/balaji/leetcode/
│   │   ├── arrays/                # Pattern-based packages (e.g., TwoSum.java)
│   │   ├── slidingwindow/
│   │   └── ...
│   └── test/java/com/balaji/leetcode/
│       ├── arrays/                # JUnit 5 test suites (e.g., TwoSumTest.java)
│       └── ...
│
├── .gitignore                     # Version control exclusions
├── CONTRIBUTING.md                # Development instructions & guidelines
├── LICENSE                        # MIT License specifications
├── pom.xml                        # Maven configuration (Java 21, JUnit 5, Checkstyle)
└── README.md                      # General repository documentation
```

---

## ⚙️ CI/CD Git & Review Workflow

This repository operates under a customized version of **GitHub Flow**, leveraging automated status checks and email routing for approvals.

```
[Developer Branch] ──(Push)──> [Run Build & Checkstyle Checks]
                                          │
                               (Creates PR & Sends Email)
                                          │
                                          ▼
[Approver Email Alert] <──(Self-Approved)── [Developer PR Review]
         │
    (Approved)
         │
         ▼
[Auto-Merge & Branch Cleanup] ──> [Success Email Notification]
```

### Automation Components
1. **PR Automation (`pr-automation.yml`)**: On pushing a feature branch, it validates branch and commit formatting, runs `mvn test` and `mvn checkstyle:check`, automatically generates a pull request, and labels it by difficulty and pattern.
2. **Notification Pipeline (`notify-*.yml`)**:
   - **PR Created**: Sends a verification email to the developer.
   - **Self-Review**: When labeled `approved` or approved by the author, an email is sent to the Approver requesting "Final Approval Required" with a diff summary.
3. **Auto-Merge & Cleanup (`auto-merge-cleanup.yml`)**: Once the Approver submits their approval, the PR is merged, the feature branch is deleted, and completion emails are dispatched to both users.

---

## 🛠️ Getting Started

### Prerequisites
- **Java Development Kit (JDK) 21** or higher.
- **Apache Maven 3.9+**.
- A GitHub repository with the following secrets configured (for email alerts):
  - `SMTP_SERVER`, `SMTP_PORT`, `SMTP_USERNAME`, `SMTP_PASSWORD`
  - `DEVELOPER_EMAIL`, `APPROVER_EMAIL`
  - `REPO_ACCESS_TOKEN` (Optional: Personal Access Token with repo/workflow scopes)

### Basic Commands
Run verification and compilation checks locally before pushing your changes:

```bash
# Compile project
mvn clean compile

# Run tests
mvn test

# Run static checkstyle analysis
mvn checkstyle:check
```

---

## 📈 Preparation Roadmap & Progress

| Milestone | Total Solved | Goal Date | Status |
| :--- | :--- | :--- | :--- |
| **50 Problems** | 1 / 50 | July 2026 | 🟩 In Progress |
| **100 Problems** | 0 / 100 | August 2026 | ⬜ Planned |
| **250 Problems** | 0 / 250 | October 2026 | ⬜ Planned |
| **500 Problems** | 0 / 500 | December 2026 | ⬜ Planned |
| **1000 Problems** | 0 / 1000 | June 2027 | ⬜ Planned |

### Solved Categories
* **Arrays / Hashing**: 1 Solved ([Two Sum](file:///leetcode/easy/0001-two-sum.md))
* **Sliding Window**: 0 Solved
* **Two Pointers**: 0 Solved
* **Binary Search**: 0 Solved
* **Dynamic Programming**: 0 Solved

---

## 🔮 Future Architecture & Enhancements

Plan to integrate the following advanced elements as the workspace scales:
- **LeetCode API Sync**: Automate stats tracking by pulling submission data directly from LeetCode.
- **GitHub Pages Dashboard**: Host interactive charts showing difficulty distributions and pattern heatmaps.
- **AI Explanation Generator**: A local script leveraging LLMs to draft initial solution walkthroughs based on Java source code.
- **PDF Revision Exporter**: Script to compile all markdown notes into highly readable sheets for pre-interview revision.
