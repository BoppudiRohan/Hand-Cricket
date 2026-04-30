# 🏏 Hand Cricket

## Overview

Hand Cricket is a Java-based digital revival of the classic schoolyard game that millions of kids grew up playing between classes, during lunch breaks, and on the walk home. The rules are simple — two players simultaneously pick a number from 1 to 6. If the numbers **match**, the batsman is **out**. If they **differ**, the batsman scores the number they showed.

This project brings that experience to life as a fully playable **Player vs CPU** game in Java, complete with three unique batsman types, special abilities, and full innings logic.

---

## Usage Instructions

### Prerequisites
- Java 11 or higher installed
- An IDE such as IntelliJ IDEA (recommended)

### Steps to Run

1. Clone or download the project
2. Open the project folder in IntelliJ IDEA
3. Navigate to `src/Main.java`
4. Right click `Main.java` → click **Run 'Main'**
5. Follow the prompts in the terminal:
   - Enter **3 player names** for your team
   - Choose **heads** or **tails** for the toss
   - Enter a number **1–6** each ball to bat or bowl

### Example Gameplay
```
🏏 Welcome to Hand Cricket!

Enter 3 player names:
Rohan
Virat
Dhoni

Choose heads/tails: heads
Toss: heads → You bat first!

Batting: Rohan
Enter (1-6): 4
CPU bowled: 2
Scored: 4 runs

Enter (1-6): 3
CPU bowled: 3
OUT!
```

---

## Tech Stack

- **Language:** Java
- **IDE:** IntelliJ IDEA
- **Testing:** JUnit 4
- **Concepts used:**
  - Object-Oriented Programming (OOP)
  - Abstract classes and inheritance
  - Polymorphism
  - `java.util.Random` for CPU logic
  - `java.util.Scanner` for user input

---

## How It Works

### Game Flow
1. Player enters 3 batsman names
2. Toss decides who bats first
3. Each batsman bats until dismissed
4. Target is set after the first innings
5. Second team chases the target
6. Winner is declared

### Batsman Types & Special Abilities

| Batsman | Special Ability |
|---|---|
| **Opener** | Runs are **doubled** every 6th ball |
| **AllRounder** | **50% chance** of scoring +1 bonus run per ball |
| **WicketKeeper** | **20% chance** to survive a dismissal |

### Dismissal Logic
```java
if (batNum == bowlNum) {
    if (!b.avoidOut()) {
        b.isOut = true; // OUT!
    }
} else {
    int runs = b.applyBattingBonus(batNum, ballCount);
    b.score += runs;
}
```

---

## Project Structure

```
HandCricket_Javaproject501/
├── src/
│   ├── Main.java           -- Entry point
│   ├── Game.java           -- Match flow and logic
│   ├── Player.java         -- Team with list of batsmen
│   ├── Batsman.java        -- Abstract base class
│   ├── Opener.java         -- Doubles runs on 6th ball
│   ├── AllRounder.java     -- 50% bonus run
│   └── WicketKeeper.java   -- 20% survival chance
└── test/
    ├── TestOpener.java
    ├── TestAllRounder.java
    ├── TestWicketKeeper.java
    └── TestPlayer.java
```

---

## Tech Concepts Demonstrated

- **Inheritance** — `Opener`, `AllRounder`, and `WicketKeeper` all extend the abstract `Batsman` class
- **Polymorphism** — `Game.java` calls `b.avoidOut()` and `b.applyBattingBonus()` on a `Batsman` reference, and Java automatically runs the correct subclass version at runtime
- **Abstraction** — `Batsman` declares `applyBattingBonus()` as abstract, forcing every subclass to define its own behavior
- **Unit Testing** — 30+ JUnit test cases cover abilities, constructors, edge cases, and probabilistic behavior

---

## Credits

- Inspired by the classic Hand Cricket game played in schools across India
- Built as a CS 501 final project at Stevens Institute of Technology

---

## Developers

| Name | Role |
|---|---|
| **Rohan Boppudi** | sole developer — game logic, class design, OOP architecture, testing |
