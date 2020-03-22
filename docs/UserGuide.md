# Kitchen Helper - User Guide
By: `Team CS2113T-M16-2` Since: `March 2020` License: `MIT`

1. [Introduction](#1-introduction)  
2. [Quick Start](#2-quick-start)  
3. [Features](#3-features)  
   3.1 [General Commands](#31-general-commands)  
   * [Viewing help: `help`](#viewing-help-help)  
   * [Exiting the Program: `exit`](#exiting-the-program-exit)  
   
   3.2 [Ingredient](#32-ingredient)  
   * [Adding an ingredient: `addingredient`](#adding-an-ingredient-addingredient)  
   * List ingredient: `listingredient`  
   * Delete an ingredient: `deleteingredient`  
   * [Search for ingredient: `searchingredient`](#search-for-ingredient-searchingredient)  

   3.3 [Recipe](#33-recipe)  
   * Adding a recipe: `addrecipe`  
   * List recipe: `listrecipe`  
   * Delete a recipe: `deleterecipe`  
   * [Search for recipe: `searchrecipe`](#search-for-recipe-searchrecipe)  

   3.4 [Chore](#34-chore)  
   * Adding a chore: `addchore`  
   * List chore: `listchore`  
   * Delete a chore: `deletechore`  
   * [Search for chore: `searchchore`](#search-for-chore-searchchore)  

4. [FAQ](#4-faq)  
5. [Commands Summary](#5-command-summary)

## 1. Introduction

{Give a product intro}

## 2. Quick Start

1. Ensure that you have Java `11` or above installed on your computer.
2. Down the latest version of `KitchenHelper` from [here](https://github.com/AY1920S2-CS2113T-M16-2/tp/releases).
3. Copy the file to the folder you want to use as the home folder for KitchenHelper.
4. Type the command `java -jar kitchenhelper.jar` in the command prompt to start the application.
5. Type the command in the command box and press `Enter` to execute it.  
   e.g. typing `help` and pressing `Enter` will display help information.
6. Some example commands you can try:  
   * `` :
   * `` :
   * `exit` : exits the application.
7. Refer to [Section 3, "Features"](#3-features) for details of each command.

## 3. Features 

### 3.1 General Commands
#### Viewing help: `help`
Shows a list of available commands and their usages.  
__Format:__ `help`  

#### Exiting the Program: `exit`
Exits the program.  
__Format:__ `exit`  


### 3.2 Ingredient
#### Adding an ingredient: `addingredient`
Adds an ingredient to the list when the user buys an item to keep track.   
__Format:__ `addingredient /n INGREDIENT /c CATEGORY /q QUANTITY /p PRICE /e EXPIRY`  
__Example of usage:__  
* `addingredient /n Beef cubes /c meat /q 3 /p 20 /e 2020-03-18`
* `addingredient /n kailan /c Vegetable /q 30 /p 30.45 /e 2020-03-12`
* `addingredient /n Milo /c Drink /q 30 /p 10 /e 2020-12-20`

#### Search for ingredient: `searchingredient`
Search for ingredients based on given keyword.  
__Format:__ `searchingredient KEYWORD`  
__Example of usage:__  
* `searchingredient beef`  
Search by ingredient's name.
* `searchingredient meat`  
Search by ingredient's category.
* `searchingredient 2020-03-18`  
Search by ingredient's expiry date.


### 3.3 Recipe

#### Search for recipe: `searchrecipe`
Search for recipes based on given keyword.  
__Format:__ `searchrecipe KEYWORD`  
__Example of usage:__  
* `searchrecipe Chicken Stew`  
Search by recipe's name.


### 3.4 Chore

#### Search for chore: `searchchore`
Search for chores based on given keyword.  
__Format:__ `searchchore KEYWORD`  
__Example of usage:__  
* `searchchore groceries`  
Search by chore's description.
* `searchchore 2020-03-18`  
Search by chore's date.

{Give detailed description of each feature}

### Adding a to-do: `todo`
Adds a to-do item to the list of to-dos.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.  

Example of usage: 

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

## 4. FAQ

**Q**: How do I transfer my data to another computer? 

**A**: Well, write the User Guide in active voice anyway.

## 5. Command Summary
Here is a short summary of the command used in KitchenHelper application.  
Refer back to [Section 3, "Features"](#3-features) for more information on the usage of commands.  
  
__General Commands__  
Feature | Command  
------- | -------  
help | `help`  
exit | `exit`  


__Ingredient Commands__  
Feature | Command  
------- | -------  
addingredient | `addingredient /n INGREDIENT /c CATEGORY /q QUANTITY /p PRICE /e EXPIRY`<br> e.g. `addingredient /n Beef cubes /c meat /q 3 /p 20 /e 2020-03-18`  
searchingredient | `searchingredient KEYWORD` <br> e.g. `searchingredient beef`  


__Recipe Commands__  
Feature | Command  
------- | -------  
searchrecipe | `searchrecipe KEYWORD` <br> e.g. `searchrecipe Chicken Stew`  

 
__Chore Commands__  
Feature | Command  
------- | -------  
searchchore | `searchchore KEYWORD` <br> e.g. `searchchore groceries`  

{Give a 'cheat sheet' of commands here}

* Add to-do `todo n/TODO_NAME d/DEADLINE`
