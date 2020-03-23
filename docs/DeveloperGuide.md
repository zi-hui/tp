# Developer Guide
By: `CS2113T-M16-2` Since: `2020`

![Supported Java versions](https://img.shields.io/badge/Java-11-blue.svg) ![Supported OS](https://img.shields.io/badge/Supported%20OS-Windows|MacOS|Linux-yellow.svg) 
- [Developer Guide](#developer-guide)
  * [1. Introduction](#1-introduction)
    + [1.1. Purpose](#11-purpose)
    + [1.2. Scope](#12-scope)
  * [2. Setting up](#2-setting-up)
  * [3. Design](#3-design)
  * [4. Implementation](#4-implementation)
    + [4.1.Ingredient-related Features](#41ingredient-related-features)
      - [4.1.1. Addition of ingredient](#411-addition-of-ingredient)
      - [4.1.2. List all/ specific ingredient(s)](#412-list-all-specific-ingredients)
      - [4.1.3. Delete all/ specific ingredients(s)](#413-delete-all-specific-ingredientss)
      - [4.1.4. Search for ingredients based on keyword(s)](#414-search-for-ingredients-based-on-keywords)
    + [4.2. Recipe-related Features](#42-recipe-related-features)
      - [4.2.1. Addition of recipe](#421-addition-of-recipe)
      - [4.2.2. List all/ specific recipe(s)](#422-list-all-specific-recipes)
      - [4.2.3. Delete all/ specific recipe(s)](#423-delete-all-specific-recipes)
      - [4.2.4. Search for recipe based on keyword(s)](#424-search-for-recipe-based-on-keywords)
    + [4.3. Chore-related Features](#43-chore-related-features)
      - [4.3.1. Addition of chore](#431-addition-of-chore)
      - [4.3.2. List all/ specific chore(s)](#432-list-all-specific-chores)
      - [4.3.3. Delete all/ specific chore(s)](#433-delete-all-specific-chores)
      - [4.3.4. Search for chore based on keyword(s)](#434-search-for-chore-based-on-keywords)
    + [4.4. Storage](#44-storage)
    + [4.5. Logging](#45-logging)
    + [4.6. Configuration](#46-configuration)
  * [Appendices](#appendices)
    + [Appendix A: Product Scope](#appendix-a-product-scope)
    + [Appendix B: User Stories](#appendix-b-user-stories)
    + [Appendix C: Value proposition - Use cases](#appendix-c-value-proposition---use-cases)
    + [Appendix D: Non-Functional Requirements](#appendix-d-non-functional-requirements)
    + [Appendix E: Glossary](#appendix-e-glossary)
    + [Appendix G: Instructions for Manual Testing](#appendix-g-instructions-for-manual-testing)
      - [G.1. Launch and Shutdown](#g1-launch-and-shutdown)
      - [G.2. Deleting a](#g2-deleting-a)
      - [G.3. Saving data](#g3-saving-data)

## 1. Introduction
### 1.1. Purpose
### 1.2. Scope

## 2. Setting up

## 3. Design
{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

## 4. Implementation
This section describes some details on how the features are being implemented. All recipe/ ingredient/ chore-related features can be broken down into 4 distinct functionality, addition, listing, deletion and searching.

### 4.1.Ingredient-related Features
#### 4.1.1. Addition of ingredient
#### 4.1.2. List all/ specific ingredient(s)
#### 4.1.3. Delete all/ specific ingredients(s)
#### 4.1.4. Search for ingredients based on keyword(s)

### 4.2. Recipe-related Features
#### 4.2.1. Addition of recipe
Users can add a new recipe to the application where there must be at least one or more `ingredient`s. The failure to do so will trigger an exception where the user will be notified of an invalid command and the syntax of the addition of recipe will be displayed. 

> It is important that the name of the new recipe has not appeared in the list of recipes in the application.

When the user attempts to create a new recipe, the `AddRecipeCommand`, ‘Parser’ and `Recipe` class will be accessed and the following sequence of actions are called to create a `recipe` object:

1. User’s input will be parsed and identified with the keyword `addrecipe`.
2. This will automatically trigger the parsing of the user’s input string into a suitable format for the addition of `recipe` object.
3. A `AddRecipeCommand` object will be created and checked for an existing recipe with the same name. An exception will be triggered when there is an existing recipe.
4. `Ingredient`s parsed in step 2 will be added to the newly created recipe according to their category.
5. Finally, the recipe that is filled with `ingredients` will be added to the list of recipes.

All description and warnings to the user utilises the `UI` class, which controls the printing of the text on the console. 

#### 4.2.2. List all/ specific recipe(s)
#### 4.2.3. Delete all/ specific recipe(s)
#### 4.2.4. Search for recipe based on keyword(s)

### 4.3. Chore-related Features
#### 4.3.1. Addition of chore
#### 4.3.2. List all/ specific chore(s)
#### 4.3.3. Delete all/ specific chore(s)
#### 4.3.4. Search for chore based on keyword(s)

### 4.4. Storage

### 4.5. Logging
Logging in the application refers to storing exceptions, warnings and messages that occur during the execution of Kitchen Helper. It was included to help developers to identify bugs and to simplify their debugging process. 

The `java.util.logging` package in Java is used for logging. The logging mechanism can be managed from the `KitchenHelper` class through the `kitchenLogs` logger object.

All control of the logger for the application can be viewed/ altered in the `setUpLogger()` method. The current settings for the logger are as follow:

- All logs of `Level.SEVERE` level will be shown on the console when an input/ program flow has caused a possible disruption to the execution of the program. (See the levels of logging below)
- All information above ‘Level.FINE’ level is logged into a log file, `KitchenLogs.log`.
- Logging is made to be displayed in the `SimpleFormatter` style where the date, class and error description are logged.

Logging Levels:
- `Level.SEVERE`: a serious failure, which prevents normal execution of the program, for end users and system administrators.
- `Level.WARNING`: a potential problem, for end users and system administrators.
- `Level.INFO`: reasonably significant informational message for end users and system administrators.
- `Level.CONFIG`: hardware configuration, such as CPU type.
- `Level.FINE`, `Level.FINER`, `Level.FINEST`: three levels used for providing tracing information for the software developers.

Additional logging can be done by adding the calling of the global logger and invoking the function `log()`. This will ensure that all loggings will be made to the same file across the various classes. 

An example is shown below:
```java
public static final Logger kitchenLogs = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
kitchenLogs.log(Level.WARNING, description_of_warning_here, e.toString());
```

### 4.6. Configuration

## Appendices 
### Appendix A: Product Scope

### Appendix B: User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

### Appendix C: Value proposition - Use cases

{Describe the value proposition: what problem does it solve?}

### Appendix D: Non-Functional Requirements

1. Should work on any mainstream OS as long as it has Java `11` or above installed.
2. A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.

### Appendix E: Glossary

* *Mainstream OS* - Windows, Linux, Unix, OS-X

### Appendix G: Instructions for Manual Testing
#### G.1. Launch and Shutdown
#### G.2. Deleting a 
#### G.3. Saving data
{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
