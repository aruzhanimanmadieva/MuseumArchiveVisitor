# SOFTWARE DESIGN PATTERNS
## Assignment #6 — Visitor Design Pattern

**Project Title:** Museum Archive Preservation System  

**Student Name:** Aruzhan Imanmadiyeva 

**Group:** SE-2514

**Design Pattern:** Visitor (Behavioral Design Pattern)

---
# 1. Introduction

The purpose of this assignment is to implement the Visitor Design Pattern using Java.

The Visitor Pattern is a behavioral design pattern that allows us to add new operations to existing object structures without changing their classes.

In this project, I developed a Museum Archive Preservation System. The system represents a museum archive that stores different historical materials, such as photographs, historical documents, and audio recordings.

The system performs two main operations:

1. Evaluates the preservation risk of each archive item.
2. Calculates the estimated digitization cost of each archive item.

The Visitor Pattern allows these operations to be implemented separately from the archive item classes.

# 2. Project Description

The Museum Archive Preservation System manages three types of historical materials:

- Photograph
- HistoricalDocument
- AudioRecording

Each archive item contains information about its title, age, and physical condition.

The system uses two different visitors:

**PreservationRiskVisitor**

This visitor calculates the preservation risk of each archive item based on its age and condition.

**DigitizationCostVisitor**

This visitor estimates the cost of digitizing each archive item.

Both visitors work with all three archive item types but use different algorithms.

# 3. Visitor Pattern Structure

The project contains the following components:

| Component | Class / Interface | Responsibility |
|---|---|---|
| Element Interface | ArchiveItem | Declares the accept() method. |
| Concrete Element | Photograph | Represents a historical photograph. |
| Concrete Element | HistoricalDocument | Represents a historical document. |
| Concrete Element | AudioRecording | Represents an audio recording. |
| Visitor Interface | ArchiveVisitor | Declares visit methods for all concrete elements. |
| Concrete Visitor | PreservationRiskVisitor | Calculates preservation risks. |
| Concrete Visitor | DigitizationCostVisitor | Estimates digitization costs. |
| Object Structure | ArchiveItem[] archive | Stores the archive items in an array. |
| Client | Main | Creates objects, visitors, and traverses the collection. |

# 4. Technical Implementation

## 4.1 Element Interface

The `ArchiveItem` interface declares the `accept()` method.

```java
public interface ArchiveItem {
    void accept(ArchiveVisitor visitor);
}
```

All concrete elements implement this interface.

The accept() method allows a visitor to perform an operation on an archive item.

## 4.2 Concrete Elements

The project contains three concrete elements.

**Photograph**

Represents a historical photograph. It stores its title, age, and condition.

**HistoricalDocument**

Represents an old historical document. It also stores the number of pages.

**AudioRecording**

Represents a historical audio recording. It stores the recording duration.

Each concrete element implements the `accept()` method.

For example:

```java
@Override
public void accept(ArchiveVisitor visitor) {
    visitor.visitPhotograph(this);
}
```

The other elements use the same approach:

- HistoricalDocument calls `visitHistoricalDocument(this)`.
- AudioRecording calls `visitAudioRecording(this)`.

This implementation demonstrates Double Dispatch.

## 4.3 Visitor Interface

The `ArchiveVisitor` interface declares one visit method for each concrete element.

```java
public interface ArchiveVisitor {

    void visitPhotograph(Photograph photograph);

    void visitHistoricalDocument(HistoricalDocument document);

    void visitAudioRecording(AudioRecording recording);
}
```

Every concrete visitor must implement all three methods.

This structure allows different operations to be performed on the same archive items.

## 4.4 Concrete Visitor 1 — PreservationRiskVisitor

The first visitor evaluates the preservation risk of historical materials.

It uses different formulas for different types of archive items.

**Photograph:**

Risk = Age × 0.4 + (100 − Condition) × 0.6

**HistoricalDocument:**

Risk = Age × 0.5 + (100 − Condition) × 0.5

**AudioRecording:**

Risk = Age × 0.3 + (100 − Condition) × 0.7

The result represents an estimated preservation risk percentage.

The visitor implements all three methods from the ArchiveVisitor interface.

## 4.5 Concrete Visitor 2 — DigitizationCostVisitor

The second visitor estimates the digitization cost of archive items in Kazakhstani tenge (KZT).

It uses a different calculation for each element type.

**Photograph:**

Cost = 500 + (100 − Condition) × 20

**HistoricalDocument:**

Cost = 2000 + Pages × 80

**AudioRecording:**

Cost = 1000 + Duration × 120

These formulas are simplified examples created for this educational project.

The visitor implements all three methods from the ArchiveVisitor interface.

# 5. Object Structure and Client

The project uses an array as its Object Structure.

```java
ArchiveItem[] archive = {
    photograph,
    document,
    recording
};
```

The array stores all archive items.

The `Main` class acts as the Client. It creates the objects, creates the visitors, and traverses the collection.

The system uses a for-each loop:
 

for (ArchiveItem item : archive) {
    item.accept(riskVisitor);
}


First, the PreservationRiskVisitor visits every archive item.

Then, the DigitizationCostVisitor visits the same items and performs another operation.

This demonstrates how different visitors can work with the same object structure.

# 6. Double Dispatch

Double Dispatch is the main mechanism of the Visitor Design Pattern.

In this project, it works in two steps:

**Step 1:** The Client calls the accept() method on an archive item.

**Step 2:** The concrete element calls the matching visit method on the visitor and passes itself using `this`.

Example:

```java
public void accept(ArchiveVisitor visitor) {
    visitor.visitPhotograph(this);
}
```

When a Photograph object receives a visitor, it calls `visitPhotograph()`.

When a HistoricalDocument object receives a visitor, it calls `visitHistoricalDocument()`.

When an AudioRecording object receives a visitor, it calls `visitAudioRecording()`.

This allows Java to select the correct visitor method based on the concrete element type.

The project does not need `instanceof` or long if/else statements to identify object types.

# 7. Clean Code Principles

The project follows several Clean Code principles.

## 7.1 Meaningful Names

All classes, methods, and variables have clear and meaningful names.

For example:

- `PreservationRiskVisitor`
- `DigitizationCostVisitor`
- `visitPhotograph()`
- `accept()`

These names explain the purpose of each component.

## 7.2 Single Responsibility Principle (SRP)

Each class has one main responsibility.

- `Photograph` represents a photograph.
- `HistoricalDocument` represents a document.
- `PreservationRiskVisitor` calculates preservation risks.
- `DigitizationCostVisitor` calculates digitization costs.

This makes the code easier to understand and maintain.

## 7.3 Open/Closed Principle (OCP)

The project can be extended with new operations without modifying existing concrete element classes.

For example, we can add a new `ArchiveStatisticsVisitor` to collect statistics about the archive.

The existing elements do not need to change because they already support the Visitor interface.

However, adding a new element type would require updating the Visitor interface and its concrete visitors.

## 7.4 Encapsulation

The fields in concrete element classes are declared as private.

For example:

```java
private String title;
private int age;
private int condition;
```

Other classes access this information through public getter methods.

This protects the internal data of objects.

## 7.5 Polymorphism and Double Dispatch

The project uses interfaces and polymorphism instead of checking object types manually.

The Client works with the common `ArchiveItem` interface.

Each concrete element implements its own `accept()` method and calls the correct visitor method.

This makes the design more flexible and avoids unnecessary type-checking conditions.

# 8. Program Execution

The program follows these steps:

1. The Main class creates three archive items.
2. The items are stored in an array called `archive`.
3. The PreservationRiskVisitor is created.
4. The Client traverses the array and calls accept() on each item.
5. The visitor calculates the preservation risk.
6. The DigitizationCostVisitor is created.
7. The Client traverses the same array again.
8. The visitor calculates the digitization cost.

## Expected Output

```text
===== PRESERVATION RISK REPORT =====

Photograph: Old City Photo
Preservation risk: 35.0%

Historical document: Historical Agreement
Preservation risk: 80.0%

Audio recording: Traditional Music
Preservation risk: 24.5%

===== DIGITIZATION COST REPORT =====

Photograph: Old City Photo
Digitization cost: 1000.0 KZT

Historical document: Historical Agreement
Digitization cost: 4000.0 KZT

Audio recording: Traditional Music
Digitization cost: 2800.0 KZT
```

# 9. Advantages of the Visitor Pattern

The Visitor Pattern provides several advantages in this project:

1. It separates operations from the archive item classes.
2. It allows new operations to be added through new visitors.
3. It avoids manual type checking using instanceof.
4. It supports different algorithms for different object types.
5. It makes the code easier to organize and maintain.

# 10. Conclusion

In this assignment, I successfully implemented the Visitor Design Pattern using Java.

The Museum Archive Preservation System contains three concrete elements, one visitor interface, and two concrete visitors.

The system demonstrates Double Dispatch through the accept() and visitX() methods.

The two visitors perform different operations on the same archive items: calculating preservation risks and estimating digitization costs.

The project also demonstrates important Clean Code principles, including Single Responsibility, Open/Closed Principle, Encapsulation, Meaningful Names, and Polymorphism.

In conclusion, the Visitor Pattern helps separate operations from object structures and makes it easier to introduce new operations without changing existing element classes.