# Isabella Cheong Project Portfolio

### Overview - Kitchen Helper
Kitchen Helper is a Command Line application to help users manage their kitchen inventory more conveniently and more efficiently.

### Contributions
+ Responsibility: Issue Tracker

#### Enhancements implemented
+ Addition and Listing of chores
    + What it does: It allows the user to add chores to complete by a certain deadline. The user can then view all the chores in their list.
    + Justification: This feature improves the product slightly because it increases the usability of the application such that the user can keep track of chores in addition to their kitchen inventory. 
    + Highlights: This enhancement allows for the user to specify the deadline by a String or by a Java Date object. This increases user alternatives.
+ Deletion and Marking of chores as done
    + What it does: It allows users to delete chores by specifying the index of the chore in the list. Similarly, users can mark chores as done by specifying the index of the chore in the list.
    + Justification: The ability to mark chores as done is what motivates users and what helps them track their chores. When the chores are no longer relevant, or if the user makes a mistake in addition of chores, they can delete the chore.
    + Highlights: Users can delete chores by their index in the list instead of by their names, which is less troublesome for users to type. By specifying index, it is also certain that the corresponding chore associated with that index is deleted.
+ Chore notification
    + What it does: It notifies users during the startup of the application, if there are overdue chores or chores with deadlines upcoming in the next three days.
    + Justification: This feature improves the product slightly because users can better manage their completion of chores when they can be reminded of more pressing chores.
    + Highlights: This enhancement is possible because of the deadline specified by Date. 
+ Expenditure
    + What it does: It tracks the weekly total expenditure, as well as the amount used in cooking in the week. The value resets every week at Monday midnight.
    + Justification: This feature improves the product slightly because it helps users to manage expenditure. By comparing the amount used in cooking with their expenditure, users can see how much of their purchase they actually made use of and gauge their future spending on ingredients accordingly.
    + Highlights: The expenditure automatically increases whenever user executes the `addingredient` command. The amount used in cooking automatically increases when users execute `cookrecipe` command. Users will also be prompted to edit expenditure values when they execute `deleteingredient`.
    
