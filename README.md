# Number Range Summarizer

## Overview
This project implements a number range summarizer that groups sequential numbers into ranges.
Link for the project: https://github.com/tumieK/ImpactAssessment.git

## Example
Input:
1,3,6,7,8,12,13,14,15,21,22,23,24,31

Output:
1, 3, 6-8, 12-15, 21-24, 31

## Assumptions
- Input may be unsorted
- Duplicates are removed
- Empty input returns empty string
- Input is comma separated integers

## Tech Stack
- Java 8
- JUnit 5
- Mavern

## How to Run Tests
mvn test
