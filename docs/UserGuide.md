# Kitchen Helper - User Guide
By: `Team CS2113T-M16-2` Since: `March 2020` License: `MIT`

- [User Guide]()
  * [1. Introduction](#1-introduction)  
  * [2. Quick Start](#2-quick-start)  
  * [3. Features](#3-features)  
    + [3.1. General Commands](#31-general-commands)  
       - [3.1.1. Viewing help: `help`](#311-viewing-help-help)  
       - [3.1.2. Exiting the Program: `exit`](#312-exiting-the-program-exit)  
       - [3.1.3. Resetting the application: `reset`](#313-resetting-the-application-reset)  
    + [3.2. Ingredient](#32-ingredient)  
       - [3.2.1. Adding an ingredient: `addingredient`](#321-adding-an-ingredient-addingredient)  
       - [3.2.2. List ingredient: `listingredient`](#322-list-ingredient-listingredient)  
       - [3.2.3. Delete an ingredient: `deleteingredient`](#323-delete-an-ingredient-deleteingredient)  
       - [3.2.4. Search for ingredient: `searchingredient`](#324-search-for-ingredient-searchingredient)  

    + [3.3. Recipe](#33-recipe)  
      - [3.3.1. Adding a recipe: `addrecipe`](#331-adding-a-recipe-addrecipe)  
      - [3.3.2. List recipe: `listrecipe`](#332-list-recipes-listrecipe-1)  
      - [3.3.3. Delete a recipe: `deleterecipe`](#333-delete-a-recipe-deleterecipe)
      - [3.3.4. Search for recipe: `searchrecipe`](#334-search-for-recipe-searchrecipe)  
      - [3.3.5. Cooking a recipe: `cookrecipe`](#335-cooking-a-recipe-cookrecipe)

    + [3.4. Chore](#34-chore)  
      - [3.4.1. Adding a chore: `addchore`](#341-adding-a-chore-addchore)  
      - [3.4.2. List chore: `listchore`](#342-list-chore-listchore)  
      - [3.4.3. Delete a chore: `deletechore`](#343-delete-a-chore-deletechore)  
      - [3.4.4. Search for chore: `searchchore`](#344-search-for-chore-searchchore)  
 
    + [3.5 Storage](#35-storage)  
      - [3.5.1. Select Load Files](#351-select-load-files)  
      - [3.5.2. Save Current State: `save`](#352-save-current-state-save)
 
    + [3.6 Expenditure](#36-expenditure)  
      - [3.6.1. Display User Expenditure](#361-display-user-expenditure)  
       
  * [4. Command Summary](#4-command-summary)


## 1. Introduction

Our Project, Kitchen Helper is a kitchen application that is designed to facilitate users to track kitchen inventory effectively. KitchenHelper also enables users to create recipes with different ingredients and allows auto deduction when you cook using the recipe. Kitchen Helper also provides prompts when your ingredient is running low or even chores that should be completed by a deadline.      

 It is optimised for those who prefer working with Command Line Interface (CLI). Kitchen Helper provides convenience in our often busy lives, so give this application a chance to help you!
 
This user guide aims to help you learn your way around our application, making the learning process smooth and effortless. 
So what are you waiting for? Let’s go!

## 2. Quick Start

1. Ensure that you have Java `11` or above installed on your computer.
2. Download the latest version of `KitchenHelper` from [here](https://github.com/AY1920S2-CS2113T-M16-2/tp/releases).
3. Copy the file to the folder you want to use as the home folder for KitchenHelper.
4. Type the command `java -jar kitchenhelper.jar` in the command prompt to start the application.
5. Type the command in the command box and press `Enter` to execute it.  
   e.g. typing `help` and pressing `Enter` will display help information.
6. Some example commands you can try:  
   * `help` : lists all commands 
   * `addingredient /n Beef cubes /c meat /q 3 /p 20 /e 18/03/2020` : adds an ingredient to the list.
   * `listingredient meat` : list the ingredients that has the CATEGORY meat.
   * `exit` : exits the application.
7. Refer to [Section 3, "Features"](#3-features) for details of each command.

## 3. Features 

Command Format: 
- Words that are enclosed by angle brackets are the parameters to be supplied by the user. E.g. `deleterecipe /n <RECIPE_NAME>` 
From this example, `RECIPE_NAME` will be inputted by the user.
- Items in angle brackets with the word “optional:'' are optional. E.g. `deleteingredient /n <INGREDIENT_NAME>:<optional:QUANTITY>` can be used as `deleteingredient /n apple or deleteingredient /n name /q 2`

### 3.1. General Commands
#### 3.1.1. Viewing help: `help`
Shows a list of available commands and their usages.  

__Format:__ `help`  

#### 3.1.2. Exiting the Program: `exit`
Exits the program.  

__Format:__ `exit`  

#### 3.1.3. Resetting the application: `reset`
You can reset the application which will wipe out all existing data  

__Format:__ `reset`  

### 3.2. Ingredient
#### 3.2.1. Adding an ingredient: `addingredient`
You can add an ingredient to the Kitchen Helper for tracking, containing various details.

__Format:__ `addingredient /n <INGREDIENT> /c <CATEGORY> /q <QUANTITY> /p <PRICE> /e <EXPIRY>`  

* `INGREDIENT` is the name of your ingredient.
* `CATEGORY` is the CATEGORY of your ingredient.  
The different types of `CATEGORY` are listed below: 
  + `Meat`
  + `Vegetable`
  + `Staple`
  + `Fruit`
  + `Dairy`
  + `Drink`
  + `Miscellaneous`  
  
Any `CATEGORY` that does not falls in the list would be put under `Miscellaneous`.
* `QUANTITY` is the number of servings of the ingredient.
  + `QUANTITY` in the format of whole number.
* `PRICE` is the cost of the ingredient.
  + `PRICE` can be given up to 2 decimal points.
* `EXPIRY` is the expiry date of the ingredient.
  + `EXPIRY` in the format of dd/MM/yyyy e.g. 01/12/2020.

Example |  Outcome
--------|------------------
**Command**: <br> `addingredient /n Beef cubes /c meat /q 3 /p 20 /e 18/03/2020` <br><br> **Description:** <br> Creates a new ingredient called `Beef cubes`, which have the following attributes: CATEGORY `meat`, QUANTITY `3`, PRICE `20` , expiry date `18/03/2020`. | addingredient /n Beef cubes /c meat /q 3 /p 20 /e 18/03/2020 <br> You have added Ingredient:Beef cubes Category:meat Quantity:3 Price:$20.00 Expiry:18/03/2020 to the ingredient list<br>===================================================
**Command**: <br> `addingredient /n kailan /c Vegetable /q 30 /p 30.45 /e 12/03/2020` <br><br> **Description:** <br> Creates a new ingredient called `kailan`, which have the following attributes: CATEGORY `Vegetable`, QUANTITY `30`, PRICE `30.45` , expiry date `12/03/2020`. | addingredient /n kailan /c Vegetable /q 30 /p 30.45 /e 12/03/2020 <br> You have added Ingredient:kailan Category:Vegetable Quantity:30 Price:$30.45 Expiry:12/03/2020 to the ingredient list<br>===================================================
**Command**: <br> `addingredient /n Milo /c Drink /q 30 /p 10 /e 20/12/2020` <br><br> **Description:** <br> Creates a new ingredient called `Milo`, which have the following attributes: CATEGORY `Drink`, QUANTITY `30`, PRICE `10` , expiry date `20/12/2020`. | addingredient /n Milo /c Drink /q 30 /p 10 /e 20/12/2020 <br> You have added Ingredient:Milo Category:Drink Quantity:30 Price:$10.00 Expiry:20/12/2020 to the ingredient list<br>===================================================

#### 3.2.2. List ingredient: `listingredient`
Displays all the items currently in the ingredient list in Kitchen Helper.

__Format__: `listingredient <CATEGORY / ALL>`

Example |  Outcome
--------|------------------
**Command**: <br> `listingredient all` <br><br> **Description**: <br> Displays all ingredients from `all` categories. | listingredient all <br> Here is the list of Ingredients in Inventory <br> Format : Ingredient Name / Quantity / Price / Expiry <br>All:<br>dairy:<br>drink:<br>fruit:<br>meat:<br> Beef / 30 / 20.2 / 20/02/2020 <br>miscellaneous:<br>staple:<br>vegetable:<br>kailan / 30 / 30.45 / 12/03/2020 <br><br>===================================================
**Command**: <br> `listingredient meat` <br><br> **Description**: <br> Displays all ingredients from `meat` categories. | listingredient all <br> Here is the list of Ingredients in Inventory <br> Format : Ingredient Name / Quantity / Price / Expiry <br> Beef / 30 / 20.2 / 20/02/2020 <br><br>===================================================



#### 3.2.3. Delete an ingredient: `deleteingredient`
You can delete a specified ingredient or reduce an ingredient’s QUANTITY from the ingredients' inventory in Kitchen Helper by using ingredient's name or index. <br>

You may get the list of ingredients that you have previously keyed in, by referring to the [listingredient](#322-list-ingredient-listingredient) command section. <br>

__Format__: `deleteingredient /n <INGREDIENT_NAME> [/q QUANTITY]` OR `deleteingredient /i <INGREDIENT_INDEX> [/q QUANTITY]`
<br>
<br>
`INGREDIENT_NAME` : This refers to the name of the ingredient. <br>
`INGREDIENT_INDEX`: This refers to the index of the ingredient. <br>
`QUANTITY` : This refers to the QUANTITY of ingredient to be deducted. <br>
<br>

Example |  Outcome
--------|------------------
**Command**: <br> `deleteingredient /n apple /q 2` <br><br> **Description**: <br> Deletes `2 apples` from the total QUANTITY of `apples.` | deleteingredient /n apple /q 2 <br> The QUANTITY of apple has been changed!<br>===================================================
**Command**: <br> `deleteingredient /n wagyu beef` <br><br> **Description**: Deletes the ingredient named `wagyu beef` from the ingredients list. | deleteingredient /n wagyu beef <br> wagyu beef has been deleted.<br>===================================================
**Command**: <br> `deleteingredient /i 1` <br><br> **Description**: Deletes the item specified by `index 1` in the ingredient list. | deleteingredient /i 1 <br> apple has been deleted.<br>===================================================

#### 3.2.4. Search for ingredient: `searchingredient`
You can search for ingredients based on a given keyword.  

__Format:__ `searchingredient <KEYWORD>`  

* `KEYWORD` is the word to search for ingredient in Kitchen Helper.

Example |  Outcome
--------|------------------
**Command**: <br> `searchingredient beef` <br> **Description:** <br> Search by ingredient's name. | searchingredient beef <br> Here are your matching ingredients in your list <br> 1. \[Meat\] Beef Qty: 3 $20.00 Exp: 18/03/2020 <br> ===================================================
**Command**: <br> `searchingredient meat` <br> **Description:** <br> Search by ingredient's CATEGORY. | searchingredient meat <br> Here are your matching ingredients in your list <br> 1. \[Meat\] Beef Qty: 3 $20.00 Exp: 18/03/2020 <br> ===================================================
**Command** :<br> `searchingredient 18/03/2020` <br> **Description:** <br> Search by ingredient's expiry date. | searchingredient 18/03/2020 <br> Here are your matching ingredients in your list <br> 1. \[Meat\] Beef Qty: 3 $20.00 Exp: 18/03/2020 <br> ===================================================

### 3.3. Recipe

#### 3.3.1. Adding a recipe: `addrecipe`
Adds a new unique recipe into the List in Kitchen Helper.

__Format:__ `addrecipe /n <RECIPE_NAME> /i <INGREDIENT_NAME>:<QUANTITY>:<CATEGORY>[,..]`

* `RECIPE_NAME` is the name of your recipe.
* `INGREDIENT_NAME` is the name of your ingredient.
* `QUANTITY` number of servings of the ingredient.
* `CATEGORY` is the CATEGORY of your ingredient.  

The different types of `CATEGORY` are listed below: 
  + `Meat`
  + `Vegetable`
  + `Staple`
  + `Fruit`
  + `Dairy`
  + `Drink`
  + `Miscellaneous`  
  
:speech_balloon: Any `CATEGORY` that does not falls in the list could be put under `Miscellaneous`.

:bulb: All `RECIPE_NAME` has to be unique. You can check the list of existing recipes by using [`listrecipe all`](#332-list-recipes-listrecipe-1)  

Example |  Outcome
--------|------------------
**Command**: <br> `addrecipe /n Rice Ball /i Rice:3:staple` <br><br> **Description**: <br> Creates a new recipe called `Rice Ball` which contains one ingredient, `3` portions of `Rice`. | addrecipe /n Rice Ball /i Rice:3:staple <br>Rice Ball Recipe has been created with 1 ingredients inside.<br>===================================================`

#### 3.3.2. List recipes: `listrecipe`
Displays all recipe and its name or the items currently in a particular recipe in Kitchen Helper.


__Format__: `listrecipe <ITEM_NUMBER / ALL>`

Example |  Outcome
--------|------------------
**Command**: <br> `listrecipe all` <br><br> **Description**: <br> Displays all recipe number and name from RecipeList. | listrecipe all <br>Here is the list of Recipe:<br><br>Format:Recipe Number / Recipe Name<br>1/Chicken Salad<br>2/Chicken Stew<br>===================================================
**Command**: <br> `listrecipe 1` <br><br> **Description**: <br> Displays all ingredients used in recipe `1`. | listingredient 1<br>Here is the list of Ingredients in Recipe:<br><br>Format:Ingredient Name/Ingredient Category/Quantity/Price/Expiry<br>Recipe Name:Chicken Salad<br>milo/drink/10/0.0/null<br><br>===================================================


#### 3.3.3. Delete a recipe: `deleterecipe`
You can delete a recipe by using the recipe name or index from the list in Kitchen Helper. The name or index of the recipe can be found by displaying the list of recipes. 

You may get the list of recipes that you have previously keyed in, by referring to the [listrecipe](#332-list-recipes-listrecipe) command section. <br>

__Format__: `deleterecipe /n <RECIPE_NAME>` OR `deleterecipe /i <RECIPE_INDEX>`
<br>
<br>
`RECIPE_NAME` : This refers to the name of the recipe. <br>
`RECIPE_INDEX`: This refers to the index of the recipe. <br>
<br>

Example |  Outcome
--------|------------------
**Command**: <br> `deleterecipe /n pasta` <br><br> **Description**: <br> Deletes the recipe with the name of `pasta` from the recipe list.| deleterecipe /n pasta <br> pasta has been deleted.<br>===================================================
**Command**: <br> `deleterecipe /i 2` <br><br> **Description**: <br> Deletes recipe by index. In this case, delete recipe with the `index 2` from the recipe list. | deleterecipe /i 2 <br> Beef Salad has been deleted.<br>===================================================

#### 3.3.4. Search for recipe: `searchrecipe`
You can search for recipes based on a given keyword.  

__Format:__ `searchrecipe <KEYWORD>`  

* `KEYWORD` is the word to search for recipe's name in Kitchen Helper.

Example |  Outcome
--------|------------------
**Command**: <br> `searchrecipe Chicken Stew` <br><br> **Description**: <br> Search by recipe's name. | searchrecipe Chicken Stew <br> Here are your matching recipes in your list <br> 1.Chicken Stew located at listrecipe 1 <br> ===================================================

#### 3.3.5. Cooking a recipe: `cookrecipe`
Cooks a recipe specified by the user by the recipe’s name.

__Format:__ `cookrecipe /n <RECIPE_NAME> /p <NUMBER_OF_PAX>`

* `RECIPE_NAME` is the name of your recipe.
* `NUMBER_OF_PAX` is the pax count for the specified recipe.

Example |  Outcome
--------|------------------
**Command**: <br> `cookrecipe /n chicken salad /p 2` <br><br> **Description**: <br> Cooks the recipe `Chicken Salad` for 2 people| Cooks the ‘chicken salad’ recipe with a pax 2.<br>===================================================


### 3.4. Chore

#### 3.4.1. Adding a chore: `addchore`
Adds a chore to the chore list in Kitchen Helper.

__Format:__ `addchore <TASK_DESCRIPTION> /by <DEADLINE>`  

Example |  Outcome
--------|------------------
**Command**: <br> `addchore buy groceries /by Monday 12pm` <br><br> **Description**: <br> Creates a new chore called `buy groceries` which contains the deadline `Monday 12pm.` | addchore buy groceries /by Monday 12pm <br> You have added this chore: <br> [x] buy groceries (by: Monday 12pm) <br> Now you have 2 chores in the list. <br> ===================================================


#### 3.4.2. List chore: `listchore`
Displays all the items currently in the chore list in Kitchen Helper.

__Format:__ `listchore`  

Example |  Outcome
--------|------------------
**Command**: <br> `listchore` | listchore <br> Here are the chores in your list: <br> 1. [x] buy groceries (by: Monday 12pm) <br> 2. [/] scrub the floor (by: this Saturday) <br> ===================================================


#### 3.4.3. Delete a chore: `deletechore`
Deletes the chore specified by the index in the chore list in Kitchen Helper. The index of the chore can be found by displaying the list of chores.

__Format:__ `deletechore <INDEX_TO_DELETE>`  

Example |  Outcome
--------|------------------
**Command**: <br> `deletechore 1` <br><br> **Description**: <br> Deletes the item specified by `index 1` in the chore list. | deletechore 1 <br> You have deleted this chore: <br> [x] buy groceries (by: Monday 12pm) <br> Now you have 0 chores in the list. <br> ===================================================


#### 3.4.4. Search for chore: `searchchore`
You can search for chores based on a given keyword.  
  
__Format:__ `searchchore <KEYWORD>`  

* `KEYWORD` is the word to search for chores in Kitchen Helper.

Example |  Outcome
--------|------------------
**Command:** <br> `searchchore groceries` <br><br> **Description**: <br> Search by chore's description. | searchchore groceries <br> Here are your matching chores in your list <br> 1.\[x\] buy groceries (by: Tuesday 12pm) <br> ===================================================
**Command:** <br> `searchchore Tuesday` <br><br> **Description**: <br> Search by chore's date. | searchchore Tuesday <br> Here are your matching chores in your list <br> 1.\[x\] buy groceries (by: Tuesday 12pm) <br> ===================================================


#### 3.4.5. Mark chore as done: `done`
Marks the chore specified by the index in the chore list in Kitchen Helper as done. The index of the chore can be found by displaying the list of chores.

__Format:__ `done <INDEX_TO_CHECK>`  

Example |  Outcome
--------|------------------
**Command**: <br> `done 1` <br><br> **Description**: <br> Marks the item specified by `index 1` in the chore list as done. | done 1 <br> You have completed this chore: <br> [/] buy groceries (by: Monday 12pm) <br> <br> ===================================================

### 3.5. Storage

#### 3.5.1. Select Load Files
Prompts the user with the option to either load their data from auto-save mode or the manual-save mode. If the user chooses the manual-save mode,  it will overwrite all the data stored in auto-save mode. However, any subsequent changes made to the program data will be saved through auto-save mode regardless of initial load options, to save through manual-save mode, user will have to use the save command [Section 3.5.3, "Save Current State"](#352-save-current-state-save).



__Format:__ `addchore <task_description> /by <deadline>`  

Example |  Outcome
--------|------------------
**Command**: <br> `1` <br><br> **Description**: <br> Data loaded from most recent auto-save mode files.  | Please enter '1' for auto-save and '2' for manual-save: <br> 1 <br> =================================================== <br> Okay auto-save chosen. <br> ===================================================
**Command**: <br> `2` <br><br> **Description**: <br> Data loaded from most recent manual-save mode files.  | Please enter '1' for auto-save and '2' for manual-save: <br> 2 <br> =================================================== <br> Okay manual-save chosen. <br> ===================================================


#### 3.5.2. Save Current State: `save`
Saves the current state of the program into manual-save mode files. 
__Format:__ `save`  

Example |  Outcome
--------|------------------
**Command**: <br> `save` <br><br> **Description**: <br> Data saved into manual-save mode files.  | save <br> You have saved the current state in the following files: outputIngredientCopy.txt, outputRecipeCopy.txt, outputChoreCopy.txt  <br> =================================================== 

#### 3.6.1. Display User Expenditure: `displayexpenditure`
Displays total expenditure and amount used in cooking. Total expenditure increases whenever the user executes addingredient command to simulate purchase of groceries. Amount used in cooking indicates the cost of ingredients used in cooking, to help users know how much they made use of the ingredients they bought, and plan expenditure for future meals. 

__Format:__ `displayexpenditure`  

Example |  Outcome
--------|------------------
**Command**: <br> `displayexpenditure` <br>| displayexpenditure <br> This is the total amount you spent on buying Ingredients so far this week: $10.00  <br> This is the amount you actually spent for Ingredients used in your cooking this week: $6.00 <br> =================================================== 

## 4. Command Summary
Here is a short summary of the command used in KitchenHelper application.  
Refer back to [Section 3, "Features"](#3-features) for more information on the usage of commands.  
  
__General Commands__  

Feature | Command  
------- | -------  
help | `help`  
exit | `exit`  
reset | `reset`

__Ingredient Commands__  

Feature | Command  
------- | -------  
addingredient | `addingredient /n INGREDIENT /c CATEGORY /q QUANTITY /p PRICE /e EXPIRY`<br> e.g. `addingredient /n Beef cubes /c meat /q 3 /p 20 /e 2020-03-18`  
listingredient | `listingredient <CATEGORY / ALL>` <br> e.g. `listingredient all` OR `listingredient meat`
deleteingredient | `deleteingredient /n <INGREDIENT_NAME>> [/q QUANTITY]` OR `deleteingredient /i <ingredient_index> [/q QUANTITY]` <br> e.g.`deleteingredient /n apple /q 2` OR `deleteingredient /i 1`<br>
searchingredient | `searchingredient KEYWORD` <br> e.g. `searchingredient beef`  


__Recipe Commands__  

Feature | Command  
------- | -------  
addrecipe | `addrecipe /n <RECIPE_NAME> /i <INGREDIENT_NAME>:<QUANTITY>:<CATEGORY>[,..]` <br> e.g. `addrecipe /n Rice Ball /i Rice:3:staple`
listrecipe | `listrecipe <ITEM_NUMBER / ALL>` <br> e.g. `listrecipe all` OR `listrecipe 1`
deleterecipe | `deleterecipe /n <RECIPE_NAME>` OR `deleterecipe /i <RECIPE_INDEX>` <br> e.g. `deleterecipe /n pasta` OR `deleterecipe /i 2`<br>
searchrecipe | `searchrecipe KEYWORD` <br> e.g. `searchrecipe Chicken Stew`  
cookrecipe | `cookrecipe /n <RECIPE_NAME> /p <NUMBER_OF_PAX>` <br> e.g. `cookrecipe /n chicken salad /p 2`

 
__Chore Commands__  

Feature | Command  
------- | -------  
addchore | `addchore <TASK_DESCRIPTION> /by <DEADLINE>` <br> e.g. `addchore buy groceries /by Monday 12pm`
listchore | `listchore` <br> e.g. `listchore`
deletechore | `deletechore <INDEX_TO_DELETE>`  <br> e.g. `deletechore 1`
searchchore | `searchchore KEYWORD` <br> e.g. `searchchore groceries`  
done | `done <INDEX_TO_CHECK>` <br> e.g. `done 1`

__Storage Commands__

Feature | Command  
------- | -------  
save current state | `save`  

__Expenditure Commands__

Feature | Command  
------- | -------  
displayexpenditure | `displayexpenditure` 