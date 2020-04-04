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
       
    + [3.2 Storage](#32-storage)  
       - [3.2.1. Select Load Files](#321-select-load-files)  
       - [3.2.2. Save Current State: `save`](#322-save-current-state-save)
             
    + [3.3. Ingredient](#33-ingredient)  
       - [3.3.1. Adding an ingredient: `addingredient`](#331-adding-an-ingredient-addingredient)  
       - [3.3.2. List ingredient: `listingredient`](#332-list-ingredient-listingredient)  
       - [3.3.3. Delete an ingredient: `deleteingredient`](#333-delete-an-ingredient-deleteingredient)  
       - [3.3.4. Search for ingredient: `searchingredient`](#334-search-for-ingredient-searchingredient)  

    + [3.4. Recipe](#34-recipe)  
      - [3.4.1. Adding a recipe: `addrecipe`](#341-adding-a-recipe-addrecipe)  
      - [3.4.2. List recipe: `listrecipe`](#342-list-recipes-listrecipe)  
      - [3.4.3. Delete a recipe: `deleterecipe`](#343-delete-a-recipe-deleterecipe)
      - [3.4.4. Search for recipe: `searchrecipe`](#344-search-for-recipe-searchrecipe)  
      - [3.4.5. Cooking a recipe: `cookrecipe`](#345-cooking-a-recipe-cookrecipe)

    + [3.5. Chore](#35-chore)  
      - [3.5.1. Adding a chore: `addchore`](#351-adding-a-chore-addchore)  
      - [3.5.2. List chore: `listchore`](#352-list-chore-listchore)  
      - [3.5.3. Delete a chore: `deletechore`](#353-delete-a-chore-deletechore)  
      - [3.5.4. Search for chore: `searchchore`](#354-search-for-chore-searchchore)  
 
    + [3.6 Expenditure](#36-expenditure)  
      - [3.6.1. Display User Expenditure](#361-display-user-expenditure-displayexpenditure)  
       
  * [4. Command Summary](#4-command-summary)


## 1. Introduction

Our Project, Kitchen Helper is a kitchen application that is designed to facilitate users to track their kitchen inventory effectively. Kitchen Helper also enables users to create recipes with different ingredients and allows auto deduction when you cook using the recipe. Also, Kitchen Helper provides prompts when your ingredient are expiring or its quantity is running low, it also prompts for chores that should be completed by a deadline.      

Kitchen Helper is optimised for those who prefer working with Command Line Interface (CLI). It increases the level of convenience in our busy lives, so give this application a chance to help you!
 
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
   * `listingredient meat` : list the ingredients that has the category `meat`.
   * `exit` : exits the application.
7. Refer to [Section 3, "Features"](#3-features) for details of each command.

## 3. Features 

Command Format: 
- Words that are enclosed by angle brackets are the parameters to be supplied by the user. E.g. `deleterecipe /n <RECIPE_NAME>` 
From this example, `RECIPE_NAME` will be inputted by the user.
- Items in square brackets with the word [] are optional. E.g. `deleteingredient /n <INGREDIENT_NAME> [/q QUANTITY]` can be used as `deleteingredient /n apple or deleteingredient /n name /q 2`

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

### 3.2. Storage

#### 3.2.1. Select Load Files

At the start of Kitchen Helper, the user will be prompted with the option to either load the program data from auto-save mode or the manual-save mode. 

The auto-save mode will load Kitchen Helper from the auto-save files which store the most updated and recent data from the last used session of the user. 

Alternatively, if the user selects the manual-save mode, it will load Kitchen Helper from the manual-save files which store the version of data manually saved from the user’s last usage of the save command [Section 3.2.2, "Save Current State"](#322-save-current-state-save).  

It is important to note that any subsequent changes made to the program data during the current session will be automatically saved into the auto-save files regardless of initial load options. 

Example |  Outcome
--------|------------------
**Command**: <br> `1` <br><br> **Description**: <br> Data loaded from most recent auto-save mode files.  | Please enter '1' for auto-save and '2' for manual-save: <br> 1 <br> =================================================== <br> Okay auto-save chosen. <br> ===================================================
**Command**: <br> `2` <br><br> **Description**: <br> Data loaded from most recent manual-save mode files.  | Please enter '1' for auto-save and '2' for manual-save: <br> 2 <br> =================================================== <br> Okay manual-save chosen. <br> ===================================================


#### 3.2.2. Save Current State: `save`
At any point of the session, if the user wishes to store a back-up copy of the current state of their program data, it is recommended that the user uses the save command. The save command will store all program data of the current state into manual-save files. 

__Format:__ `save`  

Example |  Outcome
--------|------------------
**Command**: <br> `save` <br><br> **Description**: <br> Data saved into manual-save mode files.  | save <br> You have saved the current state in the following files: outputIngredientCopy.txt, outputRecipeCopy.txt, outputChoreCopy.txt  <br> =================================================== 

### 3.3. Ingredient
#### 3.3.1. Adding an ingredient: `addingredient`
You can add an ingredient to the Kitchen Helper for tracking, containing various details.

__Format:__ `addingredient /n <INGREDIENT_NAME> /c <CATEGORY> /q <QUANTITY> /p <PRICE> /e <EXPIRY>`  

* `INGREDIENT_NAME` is the name of your ingredient.
  + `INGREDIENT NAME` can only consists of alphabet letters only.
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
  + Note: System will automatically flag ingredient as expired if expiry date is same as the current date. 
  
__Notable Behavior__:
+ If you add an ingredient with the same name (case-ignored), same price and same expiry date. Kitchen Helper will increase the quantity from the existing data.
+ The expiry date used in `addingredient` given in the `User Guide` may be outdated.   
Please ensure that you input a valid date of the ingredient that is not expired. Otherwise, you may encounter problem adding a new ingredient to `Kitchen Helper`.  

Example |  Outcome
--------|------------------
**Command**: <br> `addingredient /n Beef cubes /c meat /q 3 /p 20 /e 18/03/2022` <br><br> **Description:** <br> Creates a new ingredient called `Beef cubes`, which have the following attributes: CATEGORY `meat`, QUANTITY `3`, PRICE `20` , expiry date `18/03/2022`. | addingredient /n Beef cubes /c meat /q 3 /p 20 /e 18/03/2022 <br> You have added Ingredient:Beef cubes Category:meat Quantity:3 Price:$20.00 Expiry:18/03/2022 to the ingredient list<br>===================================================
**Command**: <br> `addingredient /n Beef cubes /c meat /q 4 /p 20 /e 18/03/2022` <br><br> **Description:** <br> Creates a new ingredient called `Beef cubes`, which have the following attributes: CATEGORY `meat`, QUANTITY `3`, PRICE `20` , expiry date `18/03/2022`. | addingredient /n Beef cubes /c meat /q 3 /p 20 /e 18/03/2022 <br> Kitchen Helper has updated the quantity of Beef cubes to 7 from 3 <br>===================================================
**Command**: <br> `addingredient /n Milo /c Drink /q 30 /p 10 /e 20/03/2020` <br><br> **Description:** <br> Creates a new ingredient called `Milo`, which have the following attributes: CATEGORY `Drink`, QUANTITY `30`, PRICE `10` , expiry date `20/03/2020`. | addingredient /n Milo /c Drink /q 30 /p 10 /e 20/03/2020 <br> Expired ingredient detected in input. <br> Please enter a non-expired expiry date.<br>===================================================

#### 3.3.2. List ingredient: `listingredient`
Displays all the items currently in the ingredient list in Kitchen Helper.

__Format__: `listingredient <CATEGORY / ALL>`

Example |  Outcome
--------|------------------
**Command**: <br> `listingredient all` <br><br> **Description**: <br> Displays all ingredients from `all` categories. | listingredient all <br> Here is the list of Ingredients in Inventory <br> Format : Ingredient Name / Quantity / Price / Expiry <br>All:<br>dairy:<br>drink:<br>fruit:<br>meat:<br> Beef / 30 / 20.2 / 20/02/2020 <br>miscellaneous:<br>staple:<br>vegetable:<br>kailan / 30 / 30.45 / 12/03/2020 <br><br>===================================================
**Command**: <br> `listingredient meat` <br><br> **Description**: <br> Displays all ingredients from `meat` categories. | listingredient all <br> Here is the list of Ingredients in Inventory <br> Format : Ingredient Name / Quantity / Price / Expiry <br> Beef / 30 / 20.2 / 20/02/2020 <br><br>===================================================

#### 3.3.3. Delete an ingredient: `deleteingredient`
You can delete a specific ingredient and reduce the quantity of an ingredient from the ingredient's inventory in Kitchen Helper by using the ingredient's index. 

__Format__: `deleteingredient /i <INGREDIENT_INDEX> [/q <QUANTITY>]`
<br>
<br>
`INGREDIENT_INDEX`: This refers to the index of the ingredient which is an identification number tagged to the ingredient.  <br>
`QUANTITY` : This refers to the quantity of ingredient to be deducted. This is an optional argument.<br>
<br>
You may get the index for the ingredient that you would like to delete by getting the full list of ingredients that you have previously entered into Kitchen Helper. You may refer to the [listingredient](#332-list-ingredient-listingredient) command section to understand how to use the command. 

Example |  Outcome
--------|------------------
**Command**: <br> `deleteingredient /i 1` <br><br> **Description**: Deletes the item specified by `index 1` in the ingredient list. | deleteingredient /i 1 <br> apple has been deleted.<br>===================================================
**Command**: <br> `deleteingredient /i 2 /q 20` <br><br> **Description**: Reduces the ingredient specified by `index 2` in the ingredient list. | deleteingredient /i 2 /q 20 <br> The quantity of HL Milk has been changed!<br>===================================================

#### 3.3.4. Search for ingredient: `searchingredient`
You can search for ingredients based on a given keyword.  

__Format:__ `searchingredient <KEYWORD>`  

* `KEYWORD` is the word to search for ingredient in Kitchen Helper.

Example |  Outcome
--------|------------------
**Command**: <br> `searchingredient beef` <br> **Description:** <br> Search by ingredient's name. | searchingredient beef <br> Here are your matching ingredients in your list <br> 1. \[Meat\] Beef Qty: 3 $20.00 Exp: 18/03/2020 <br> ===================================================
**Command**: <br> `searchingredient meat` <br> **Description:** <br> Search by ingredient's category. | searchingredient meat <br> Here are your matching ingredients in your list <br> 1. \[Meat\] Beef Qty: 3 $20.00 Exp: 18/03/2020 <br> ===================================================
**Command** :<br> `searchingredient 18/03/2020` <br> **Description:** <br> Search by ingredient's expiry date. | searchingredient 18/03/2020 <br> Here are your matching ingredients in your list <br> 1. \[Meat\] Beef Qty: 3 $20.00 Exp: 18/03/2020 <br> ===================================================

### 3.4. Recipe

#### 3.4.1. Adding a recipe: `addrecipe`
Adds a new unique recipe into the List in Kitchen Helper. A recipe is a list of ingredients that are used to cook a dish.

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
  
Any `CATEGORY` that does not falls in the list could be put under `Miscellaneous`.

> All `RECIPE_NAME` has to be unique. You can check the list of existing recipes by using [`listrecipe all`](#332-list-recipes-listrecipe-1)  
> Please note that `RECIPE_NAME` and `INGREDIENT_NAME` can contain spaces. These will not be removed after addition. (i.e. "____Chicken Stew" where `_` is space will remain )

Example |  Outcome
--------|------------------
**Command**: <br> `addrecipe /n Rice Ball /i Rice:3:staple` <br><br> **Description**: <br> Creates a new recipe called `Rice Ball` which contains one ingredient, `3` portions of `Rice`. | addrecipe /n Rice Ball /i Rice:3:staple <br>Rice Ball Recipe has been created with 1 ingredients inside.<br>===================================================`
**Command**: <br> `addrecipe /n Chicken Salad /i Chicken Breast:2:meat, Lettuce:4:vegetable` <br><br> **Description**: <br> Creates a new recipe called `Chicken Salad` which contains two ingredient, `2` portions of `Chicken breast` and `4` portions of `Lettuce`. | addrecipe /n Chicken Salad /i Chicken Breast:2:meat, Lettuce:4:vegetable<br>Chicken Salad Recipe has been created with 2 ingredients inside.<br>===================================================
**Command**: <br> `addrecipe /n Chicken Salad /i Chicken Breast:2:meat, Lettuce:4:vegetable` <br><br> **Description**: <br> A duplicate recipe has been found | addrecipe /n Chicken Salad /i Chicken Breast:2:meat, Lettuce:4:vegetable<br>There is an existing recipe with the same name!<br>===================================================
#### 3.4.2. List recipes: `listrecipe`
Displays all recipe and its name or the items currently in a particular recipe in Kitchen Helper.


__Format__: `listrecipe <ITEM_NUMBER / ALL>`

Example |  Outcome
--------|------------------
**Command**: <br> `listrecipe all` <br><br> **Description**: <br> Displays all recipe number and name from RecipeList. | listrecipe all <br>Here is the list of Recipe:<br><br>Format:Recipe Number / Recipe Name<br>1/Chicken Salad<br>2/Chicken Stew<br>===================================================
**Command**: <br> `listrecipe 1` <br><br> **Description**: <br> Displays all ingredients used in recipe `1`. | listingredient 1<br>Here is the list of Ingredients in Recipe:<br><br>Format:Ingredient Name/Ingredient Category/Quantity/Price/Expiry<br>Recipe Name:Chicken Salad<br>milo/drink/10/0.0/null<br><br>===================================================


#### 3.4.3. Delete a recipe: `deleterecipe`
You can delete a recipe by using the recipe name or index from the list in Kitchen Helper. The name or index of the recipe can be found by displaying the list of recipes. 

__Format__: `deleterecipe /n <RECIPE_NAME>` OR `deleterecipe /i <RECIPE_INDEX>`
<br>
<br>
`RECIPE_NAME` : This refers to the name of the recipe. <br>
`RECIPE_INDEX`: This refers to the index of the recipe which is an identification number tagged to the recipe.<br>
<br>
You may get the index or name for the recipe that you would like to delete by getting the full list of recipes that you have previously entered into Kitchen Helper. You may refer to the [listrecipe all](#342-list-recipes-listrecipe) command section to understand how to use the command. 

Example |  Outcome
--------|------------------
**Command**: <br> `deleterecipe /n pasta` <br><br> **Description**: <br> Deletes the recipe with the name of `pasta` from the recipe list.| deleterecipe /n pasta <br> pasta has been deleted.<br>===================================================
**Command**: <br> `deleterecipe /i 2` <br><br> **Description**: <br> Deletes recipe by index. In this case, delete recipe with the `index 2` from the recipe list. | deleterecipe /i 2 <br> Beef Salad has been deleted.<br>===================================================

#### 3.4.4. Search for recipe: `searchrecipe`
You can search for recipes based on a given keyword.  

__Format:__ `searchrecipe <KEYWORD>`  

* `KEYWORD` is the word to search for recipe's name in Kitchen Helper.

Example |  Outcome
--------|------------------
**Command**: <br> `searchrecipe Chicken Stew` <br><br> **Description**: <br> Search by recipe's name. | searchrecipe Chicken Stew <br> Here are your matching recipes in your list <br> 1.Chicken Stew located at listrecipe 1 <br> ===================================================

#### 3.4.5. Cooking a recipe: `cookrecipe`
Cooks a recipe specified by the user by the recipe’s name.

__Format:__ `cookrecipe /n <RECIPE_NAME> /p <NUMBER_OF_PAX>`

* `RECIPE_NAME` is the name of your recipe.
* `NUMBER_OF_PAX` is the pax count for the specified recipe.

> Please note that expired ingredients cannot be cooked and will be prompted to clear them.

> Please note that the ingredients used in the recipe will be matched strictly by their `INGREDIENT_NAME` and `CATEGORY` when cooking a recipe. You may refer to the [addrecipe](#341-adding-a-recipe-addrecipe) command section

The `ingredient`s used in the specified recipe will be automatically deducted when there is sufficient non-expired `ingredient`s.

Situation | Example |  Outcome
----------|--------|------------------
Sufficient ingredients for all ingredients required in the specified recipe. | **Command**: <br> `cookrecipe /n chicken salad /p 2` <br><br> **Description**: <br> Cooks the recipe `Chicken Salad` for 2 people| cookrecipe /n Chicken Salad /p 2<br>Kitchen Helper is trying to cook!<br>Cooks the ‘chicken salad’ recipe with a pax 2.<br>===================================================
Insufficient ingredients for all ingredients required in the specified recipe regardless if the `ingredients` have expired or not. | **Command**: <br> `cookrecipe /n Chicken Salad /p 3`<br><br> **Description**: <br> Cooks the recipe `Chicken Salad` for 3 people| cookrecipe /n Chicken Salad /p 3<br>Kitchen Helper is trying to cook!<br>There are insufficient/missing ingredients!<br>===================================================
Insufficient non-expired ingredients available. | **Command**: <br>`cookrecipe /n warm milk /p 2`  <br><br> **Description**: <br>Cooks the recipe `warm milk` for 2 people | cookrecipe /n warm milk /p 2<br>Kitchen Helper is trying to cook!<br>There are insufficient/missing ingredients!<br>Please check for these expired ingredients: hl milk<br>===================================================

### 3.5. Chore

#### 3.5.1. Adding a chore: `addchore`
Adds a chore to the chore list in Kitchen Helper.

__Format:__ `addchore <TASK_DESCRIPTION> /by <DEADLINE>`  

Example |  Outcome
--------|------------------
**Command**: <br> `addchore buy groceries /by Monday 12pm` <br><br> **Description**: <br> Creates a new chore called `buy groceries` which contains the deadline `Monday 12pm.` | addchore buy groceries /by Monday 12pm <br> You have added this chore: <br> [x] buy groceries (by: Monday 12pm) <br> Now you have 2 chores in the list. <br> ===================================================


#### 3.5.2. List chore: `listchore`
Displays all the items currently in the chore list in Kitchen Helper.

__Format:__ `listchore`  

Example |  Outcome
--------|------------------
**Command**: <br> `listchore` | listchore <br> Here are the chores in your list: <br> 1. [x] buy groceries (by: Monday 12pm) <br> 2. [/] scrub the floor (by: this Saturday) <br> ===================================================


#### 3.5.3. Delete a chore: `deletechore`
Deletes the chore specified by the index in the chore list in Kitchen Helper. The index of the chore can be found by displaying the list of chores.

__Format:__ `deletechore <INDEX_TO_DELETE>`  

Example |  Outcome
--------|------------------
**Command**: <br> `deletechore 1` <br><br> **Description**: <br> Deletes the item specified by `index 1` in the chore list. | deletechore 1 <br> You have deleted this chore: <br> [x] buy groceries (by: Monday 12pm) <br> Now you have 0 chores in the list. <br> ===================================================


#### 3.5.4. Search for chore: `searchchore`
You can search for chores based on a given keyword.  
  
__Format:__ `searchchore <KEYWORD>`  

* `KEYWORD` is the word to search for chores in Kitchen Helper.

Example |  Outcome
--------|------------------
**Command:** <br> `searchchore groceries` <br><br> **Description**: <br> Search by chore's description. | searchchore groceries <br> Here are your matching chores in your list <br> 1.\[x\] buy groceries (by: Tuesday 12pm) <br> ===================================================
**Command:** <br> `searchchore Tuesday` <br><br> **Description**: <br> Search by chore's date. | searchchore Tuesday <br> Here are your matching chores in your list <br> 1.\[x\] buy groceries (by: Tuesday 12pm) <br> ===================================================


#### 3.5.5. Mark chore as done: `done`
Marks the chore specified by the index in the chore list in Kitchen Helper as done. The index of the chore can be found by displaying the list of chores.

__Format:__ `done <INDEX_TO_CHECK>`  

Example |  Outcome
--------|------------------
**Command**: <br> `done 1` <br><br> **Description**: <br> Marks the item specified by `index 1` in the chore list as done. | done 1 <br> You have completed this chore: <br> [/] buy groceries (by: Monday 12pm) <br> <br> ===================================================

### 3.6. Expenditure

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
addingredient | `addingredient /n <INGREDIENT_NAME> /c <CATEGORY> /q <QUANTITY> /p <PRICE> /e <EXPIRY>`<br> e.g. `addingredient /n Beef cubes /c meat /q 3 /p 20 /e 18/03/2022`  
listingredient | `listingredient <CATEGORY / ALL>` <br> e.g. `listingredient all` OR `listingredient meat`
deleteingredient | `deleteingredient /n <INGREDIENT_NAME> [/q <QUANTITY>]` OR `deleteingredient /i <ingredient_index> [/q <QUANTITY>]` <br> e.g.`deleteingredient /n apple /q 2` OR `deleteingredient /i 1`<br>
searchingredient | `searchingredient <KEYWORD>` <br> e.g. `searchingredient beef`  


__Recipe Commands__  

Feature | Command  
------- | -------  
addrecipe | `addrecipe /n <RECIPE_NAME> /i <INGREDIENT_NAME>:<QUANTITY>:<CATEGORY>[,..]` <br> e.g. `addrecipe /n Rice Ball /i Rice:3:staple`
listrecipe | `listrecipe <ITEM_NUMBER / ALL>` <br> e.g. `listrecipe all` OR `listrecipe 1`
deleterecipe | `deleterecipe /n <RECIPE_NAME>` OR `deleterecipe /i <RECIPE_INDEX>` <br> e.g. `deleterecipe /n pasta` OR `deleterecipe /i 2`<br>
searchrecipe | `searchrecipe <KEYWORD>` <br> e.g. `searchrecipe Chicken Stew`  
cookrecipe | `cookrecipe /n <RECIPE_NAME> /p <NUMBER_OF_PAX>` <br> e.g. `cookrecipe /n chicken salad /p 2`

 
__Chore Commands__  

Feature | Command  
------- | -------  
addchore | `addchore <TASK_DESCRIPTION> /by <DEADLINE>` <br> e.g. `addchore buy groceries /by Monday 12pm`
listchore | `listchore` <br> e.g. `listchore`
deletechore | `deletechore <INDEX_TO_DELETE>`  <br> e.g. `deletechore 1`
searchchore | `searchchore <KEYWORD>` <br> e.g. `searchchore groceries`  
done | `done <INDEX_TO_CHECK>` <br> e.g. `done 1`

__Storage Commands__

Feature | Command  
------- | -------  
save current state | `save`  

__Expenditure Commands__

Feature | Command  
------- | -------  
displayexpenditure | `displayexpenditure` 