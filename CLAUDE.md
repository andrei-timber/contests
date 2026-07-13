# CLAUDE.md

Guidance for Claude Code when working in this repository.

## What this is

A personal, long-lived collection of solutions to programming-contest, course, and interview problems. Kept "for fun" — some snippets are old or in an inconsistent state on purpose. See `README.txt` for the canonical per-source language breakdown; don't duplicate that list here.

Each top-level directory is an independent source; there is no repo-wide build. Languages and layout vary by directory (C++, Python, Java).

## Layout

- `codeeval/` — CodeEval problems, one dir per problem (`NNN_slug/`). Largest set.
- `peuler/` — Project Euler, one dir per problem (`NN_slug/`). Python.
- `algo-class/` — Stanford Algorithms course (`ProgQ*`, `Training`). C++.
- `codeforces/` — Codeforces, organized by round/division. C++.
- `google-code-jam/` — Code Jam, organized by year. C++.
- `timus/` — Timus Online Judge. Java, as a single Eclipse project (`src/`, `.classpath`, `.project`).
- `concurrency/` — Classic concurrency problems. Java. Standalone files (`Race.java`, `AtomicCounter.java`) plus `diningphils/` (a Maven project — `pom.xml`, `src/main`, `src/test`).
- `Data Structures & Algorithms/` — Neetcode-style interview prep, one dir per problem.

## Conventions

- **Commit style:** short imperative subject, e.g. `Add: <problem-name> - <detail>`.
- **Solo, single-branch.** Work happens directly on `master`; no PRs, no feature branches unless explicitly asked.
- **Author's own code.** Solutions are written by the repo owner. Claude is used here only for education/explanation and file operations, not for authoring solutions.
- **No Claude authorship on commits.** Do NOT append a `Co-Authored-By: Claude` trailer (or any Claude/AI attribution) to commits in this repo. This overrides the global default.
- **IDE metadata** (`.classpath`, `.project`) is tracked for the Eclipse-based dirs (`timus/`, `concurrency/diningphils/`); auto-generated churn in these files is expected. `.gitignore` already excludes build output (`target`, `bin`, `.settings`, `.idea`).

## Build/run notes

- Most entries are single-file solutions run ad hoc with the relevant compiler/interpreter — there is no unified test runner.
- `concurrency/diningphils/` is Maven: `mvn test` from that directory.
