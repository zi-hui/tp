# Kitchen Helper - User Guide
By: `Team CS2113T-M16-2` Since: `March 2020` License: `MIT`

- [User Guide]()
  * [1. Introduction](#1-introduction)  
  * [2. Quick Start](#2-quick-start)  
  * [3. Features](#3-features)  
    + [3.1. General Commands](#31-general-commands)  
       - [3.1.1. Viewing help: `help`](#311-viewing-help-help)  
       - [3.1.2. Exiting the Program: `exit`](#312-exiting-the-program-exit)  
    + [3.2. Ingredient](#32-ingredient)  
       - [3.2.1. Adding an ingredient: `addingredient`](#321-adding-an-ingredient-addingredient)  
       - [3.2.2. List ingredient: `listingredient`](#322-list-ingredient-listingredient)  
       - [3.2.3. Delete an ingredient: `deleteingredient`](#323-delete-an-ingredient-deleteingredient)  
       - [3.2.4. Search for ingredient: `searchingredient`](#324-search-for-ingredient-searchingredient)  

    + [3.3. Recipe](#33-recipe)  
      - [3.3.1. Adding a recipe: `addrecipe`](#331-adding-a-recipe-addrecipe)  
      - [3.3.2. List recipe: `listrecipe`](#332-list-all-recipes-listrecipe-all)  
      - [3.3.3. Delete a recipe: `deleterecipe`](#333-delete-a-recipe-deleterecipe)
      - [3.3.4. Search for recipe: `searchrecipe`](#334-search-for-recipe-searchrecipe)  
      - [3.3.5. Cooking a recipe: `cookrecipe`](#335-cooking-a-recipe-cookrecipe)

    + [3.4. Chore](#34-chore)  
      - [3.4.1. Adding a chore: `addchore`](#341-adding-a-chore-addchore)  
      - [3.4.2. List chore: `listchore`](#342-list-chore-listchore)  
      - [3.4.3. Delete a chore: `deletechore`](#343-delete-a-chore-deletechore)  
      - [3.4.4. Search for chore: `searchchore`](#343-search-for-chore-searchchore)  
  
  * [4. FAQ](#4-faq)  
  * [5. Command Summary](#5-command-summary)


## 1. Introduction

Our project, Kitchen Helper is a household application which tracks household inventory, creates recipes which would indicate how much ingredients will be used, and assigns tasks to household members. The application will be easy to use, with intuitive ways of editing, finding and tracking tasks that have been added. It is optimised for those who prefer working with Command Line Interface (CLI). Kitchen Helper provides convenience in our often busy lives, so give this application a chance to help you!
This user guide aims to help you learn your way around our application, making the learning process smooth and effortless. 

So what are you waiting for? Let’s go!

## 2. Quick Start

1. Ensure that you have Java `11` or above installed on your computer.
2. Down the latest version of `KitchenHelper` from [here](https://github.com/AY1920S2-CS2113T-M16-2/tp/releases).
3. Copy the file to the folder you want to use as the home folder for KitchenHelper.
4. Type the command `java -jar kitchenhelper.jar` in the command prompt to start the application.
5. Type the command in the command box and press `Enter` to execute it.  
   e.g. typing `help` and pressing `Enter` will display help information.
6. Some example commands you can try:  
   * `help` : lists all commands 
   * `` :
   * `exit` : exits the application.
7. Refer to [Section 3, "Features"](#3-features) for details of each command.

## 3. Features 

### 3.1. General Commands
#### 3.1.1. Viewing help: `help`
Shows a list of available commands and their usages.  

__Format:__ `help`  

#### 3.1.2. Exiting the Program: `exit`
Exits the program.  

__Format:__ `exit`  


### 3.2. Ingredient
#### 3.2.1. Adding an ingredient: `addingredient`
Adds an ingredient to the list when the user buys an item to keep track.   

__Format:__ `addingredient /n INGREDIENT /c CATEGORY /q QUANTITY /p PRICE /e EXPIRY`  

__Example of usage:__  
* `addingredient /n Beef cubes /c meat /q 3 /p 20 /e 2020-03-18`
* `addingredient /n kailan /c Vegetable /q 30 /p 30.45 /e 2020-03-12`
* `addingredient /n Milo /c Drink /q 30 /p 10 /e 2020-12-20`

#### 3.2.2. List ingredient: `listingredient`
Prints out a list of ingredients added by the user. Allow users to choose which category to print out from.

__Format:__ `listingredient <all/dairy/drink/fruit/meat/miscellaneous/staple/vegetable>`

__Example of usage:__
* `listingredient all`
* `listingredient meat`
* `listingredient vegetable`
#### 3.2.3. Delete an ingredient: `deleteingredient`
Delete the specified ingredient or reduce an ingredient’s quantity from the ingredients inventory in Kitchen Helper using ingredient's name or index. 
The name or index of the ingredient can be found by displaying the list of ingredients. 

__Format__: `deleteingredient /n <INGREDIENT> [/q QUANTITY]` OR `deleteingredient /i <INGREDIENT_INDEX> [/q QUANTITY]`

__Example of usage:__
* `deleteingredient /n apple /q 2` <br>
Deletes 2 apples from the total quantity of apples. 
* `deleteingredient /n wagyu beef` <br>
Deletes the ingredient named `wagyu beef` from the ingredients inventory.
* `deleteingredient /i 1` <br>
Delete ingredient by index. In this case, delete the ingredient with index of 1.

#### 3.2.4. Search for ingredient: `searchingredient`
Search for ingredients based on given keyword.  

__Format:__ `searchingredient KEYWORD`  

__Example of usage:__  
* `searchingredient beef`  
Search by ingredient's name.
* `searchingredient meat`  
Search by ingredient's category.
* `searchingredient 2020-03-18`  
Search by ingredient's expiry date.


### 3.3. Recipe

#### 3.3.1. Adding a recipe: `addrecipe`
Adds a new unique recipe into the List in Kitchen Helper.

__Format:__ `addrecipe /n <recipe_name> /i <ingredient_name>:<quantity>:<category>[,..]`

Example |  Outcome
--------|------------------
Command: <br> `addrecipe /n Rice Ball /i Rice:3:staple` <br> Description: <br> Creates a new recipe called `Rice Ball` which contains one ingredient, `3` portions of `Rice`. | addrecipe /n Rice Ball /i Rice:3:staple <br>Rice Ball Recipe has been created with 1 ingredients inside.<br>===================================================`

#### 3.3.2. List recipes: `listrecipe 1`
Prints out details of recipe added by the user. Allow users to choose which recipe to print out from.

__Format:__ `listrecipe <recipe number>`

__Example of usage:__
* `listingredient 1`
* `listingredient 2`

#### 3.3.3. Delete a recipe: `deleterecipe`
Deletes the specific recipe name or index from the list in Kitchen Helper. The name or index of the recipe can be found by displaying the list of recipes. 

#### Listing all recipes: `listrecipe all`

__Format__: `deleterecipe /n <RECIPE>` OR `deleterecipe /i <RECIPE_INDEX>`

__Example of usage:__
* `deleterecipe /n pasta`
  Deletes the recipe with the name of `pasta` from the recipe list.
* `deleterecipe /i 2`
  Deletes recipe by index. In this case, delete recipe with the index of 2 from the recipe list.

#### 3.3.4. Search for recipe: `searchrecipe`
Search for recipes based on given keyword.  

__Format:__ `searchrecipe KEYWORD`  

__Example of usage:__  
* `searchrecipe Chicken Stew`  
Search by recipe's name.

#### 3.3.5. Cooking a recipe: `cookrecipe`
Cooks a recipe specified by the user by the recipe’s name.

__Format:__ `cookrecipe /n <recipe_name> /p <number_of_pax>`

Example |  Outcome
--------|------------------
`cookrecipe /n chicken salad /p 2` | Cooks the ‘chicken salad’ recipe with a pax 2.

### 3.4. Chore

#### 3.4.1. Adding a chore: `addchore`

#### 3.4.2. List chore: `listchore`

#### 3.4.3. Delete a chore: `deletechore`

#### 3.4.3. Search for chore: `searchchore`
Search for chores based on given keyword.  

__Format:__ `searchchore KEYWORD`  

__Example of usage:__  
* `searchchore groceries`  
Search by chore's description.
* `searchchore 2020-03-18`  
Search by chore's date.

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
deleteingredient | `deleteingredient /n INGREDIENT [/q QUANTITY]` OR `deleteingredient /i INGREDIENT_INDEX [/q QUANTITY]` <br> e.g.`deleteingredient /n apple /q 2` OR `deleteingredient /i 1`<br>
searchingredient | `searchingredient KEYWORD` <br> e.g. `searchingredient beef`  


__Recipe Commands__  

Feature | Command  
------- | -------  
addrecipe | `addrecipe /n <recipe name> /i <ingredient_name>:<quantity>:<category>[,..]`
deleterecipe | `deleterecipe /n <RECIPE>` OR `deleterecipe /i <RECIPE_INDEX>` <br> e.g. `deleterecipe /n pasta` OR `deleterecipe /i 2`<br>
searchrecipe | `searchrecipe KEYWORD` <br> e.g. `searchrecipe Chicken Stew`  

 
__Chore Commands__  

Feature | Command  
------- | -------  
searchchore | `searchchore KEYWORD` <br> e.g. `searchchore groceries`  
