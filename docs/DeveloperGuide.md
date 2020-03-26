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

The addition of the ingredient feature allows the user to keep track of the ingredients in the ingredient’s list.   
For example, `addingredient /n beef /c meat /q 2 /p 20 /e 2020-02-18` will add the ingredient `beef` 
which have the following attributes:  category `meat`, quantity `2`, price `$20` and expiry `2020-02-18`  

##### Implementation

{insert sequence diagram of addingredient command}  

The following steps explained “Sequence diagram for an example `addingredient` command”:  
1. The user enters  `addingredient /n beef /c meat /q 2 /p 20 /e 2020-02-18`.  
2. `KitchenHelper` calls `Parser#parseUserCommand()` which splits the user’s input into 2 parts 
and enters a switch case for execution.  
3. `parseUserCommand` in the Parser object will call its own method `Parser#prepareAddIngredient`.  
4. `prepareAddIngredient` will first validates the user’s remaining attributes and if successful, 
it will execute `AddIngredientCommand` with the attributes, 
otherwise it will throw an `InvalidCommand` along with the syntax of `addingredient command`  
5. On execute(), the ingredient is added based on the category into the ingredient’s list.

#### 4.1.2. List all/ specific ingredient(s)
#### 4.1.3. Delete all/ specific ingredients(s)
#### 4.1.4. Search for ingredients based on keyword(s)

The search for ingredients feature allows the user to find ingredients using a keyword in the ingredient’s list.  
For example, `searchingredient beef` will find all the ingredients that contain `beef`.  

##### Implementation  

{insert sequence diagram of searchingredient command}

The following steps explained “Sequence diagram for an example `searchingredient` command”:
1. The user enters `searchingredient beef`
2. `KitchenHelper` calls `Parser#parseUserCommand()` which splits the user’s input into 2 parts 
and enters a switch case for execution.
3. `parseUserCommand` in the Parser object will call a method `SearchIngredientCommand`.
4. On execute(), the list of ingredients that contains the keyword will be displayed.

##### Design considerations:

Aspects: How `searchingredient` executes:  

- Alternative 1 (current choice): Find if the keyword is part of the substring of the ingredient, 
`[Meat] Beef Qty:3 $20.00 Exp:2020-03-18.`  

|     |     |
|-----|-----|
|**Pros** | 1. Easily to find by any attributes such as category, ingredient’s name,  quantity, price and expiry date.|  
|**Cons** | 1. Searching `beef [meat]` will fail to show any matching result.|

- Alternative 2: Take in all the predicates given by the user and find using the predicates as a keyword

|     |     |
|-----|-----|
|**Pros** | 1. More accurate searching of the ingredient is available for the user.|  
|**Cons** | 1. Requires users to enter more precise predicate keywords which could be more inconvenient.|

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

The search for recipe feature allows the user to find recipes using a keyword in the recipe’s list.  
For example, `searchrecipe Chicken` will find all recipes that contain `Chicken`.  


##### Implementation

{insert sequence diagram of searchrecipe command}

The following steps explained “Sequence diagram for an example `searchrecipe` command”:
1. The user enters `searchrecipe Chicken`
2. `KitchenHelper` calls `Parser#parseUserCommand()` which splits the user’s input into 2 parts 
and enters a switch case for execution.  
3. `parseUserCommand` in the Parser object will call a method `SearchRecipeCommand`.  
4. On execute(), the list of recipes' name that contains the keyword will be displayed.  

##### Design considerations:

Aspects: How `searchrecipe` executes:  

- Alternative 1 (current choice): Find if the keyword is part of the substring of the recipe’s name 
and returns the recipe’s name and the index of recipe in the recipe’s list.  

|     |     |
|-----|-----|
|**Pros** | 1. Easy to find similar recipe by their name.|  
|**Cons** | 1. Only shows the different recipe that contains the keyword.|

- Alternative 2: Find the keyword within the recipe’s ingredient.  

|     |     |
|-----|-----|
|**Pros** | 1. More accurate searching of the recipe that uses the ingredients.|  
|**Cons** | 1. Could be more memory intensive to find if the list is huge.|

### 4.3. Chore-related Features
#### 4.3.1. Addition of chore
#### 4.3.2. List all/ specific chore(s)
#### 4.3.3. Delete all/ specific chore(s)
#### 4.3.4. Search for chore based on keyword(s)

The search for chore feature allows the user to find chores using a keyword in the chore’s list.  
For example, `searchchore groceries` will find all chores that contain `groceries`.  

##### Implementation  

{insert sequence diagram of searchchore command}

The following steps explained “Sequence diagram for an example `searchchore` command”:  
1. The user enters `searchchore groceries`  
2. `KitchenHelper` calls `Parser#parseUserCommand()` which splits the user’s input into 2 parts 
and enters a switch case for execution.  
3. `parseUserCommand` in the Parser object will call a method `SearchChoreCommand`.  
4. On execute(), the list of chore that contains the keyword will be displayed.  

##### Design considerations:

- Alternative 1 (current choice): Find if the keyword is part of the substring of the chore, 
`[x] buy groceries (by: Tuesday 12pm)`.   
 
|     |     |
|-----|-----|
|**Pros** | 1. Easily to find by any attributes such as description and date.|  
|**Cons** | 1. Searching `buy groceries [x]` will fail to show any matching result.|

- Alternative 2: Take in all the predicates given by the user and find using the predicates as a keyword  

|     |     |
|-----|-----|
|**Pros** | 1. More accurate searching of the chore is available for the user..|  
|**Cons** | 1. Requires users to enter more precise predicate keywords which could be more inconvenient.|

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
