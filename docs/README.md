# Duke - User Guide
1. Introduction
2. Quick Start
3. Features <br/>
   3.1 Adding a 'todo' task: `todo` <br/>
   3.2 Adding an 'event': `event` <br/>
   3.3 Adding a 'deadline': `deadline` <br/>
   3.4 Listing all tasks: `list` <br/>
   3.5 Finding tasks by keywords: `find` <br/>
   3.6 Deleting a task: `delete` <br/>
   3.7 Marking a task as done: `done` <br/>
   3.8 Saving the data <br/>
   3.9 Exiting the program: `bye` <br/>
4. Command Summary

## 1. Introduction
Duke is for those who prefer to work with a Command Line Interface (CLI) for managing tasks. If you can type fast, Duke can get your tasks managed fasster than traditional GUI apps. Interested? Jump to Section 2, "Quick Start" to get started. Enjoy!

## 2. Quick Start
1. Ensure you have Java 11 or above installed in your Computer.
2. Download the latest iP.jar.
3. You may launch the program by double clicking the downloaded jar file, or run command java -jar iP.jar .
4. Type the command and press 'Enter' on the keyboard to execute it.
5. Refer to Section 3, "Features" for details of each command.

## 3. Features
#### Command Format
* Words in UPPER_CASE are the parameters to be supplied by the user e.g. in `todo TASK`, `TASK` is a parameter which can be used as `todo read book`.
* Command word is case-insensitive e.g. `todo` can be entered as `TODO`.
### 3.1 Adding a 'todo' task: `todo`
Adds a 'todo' task to the task list. <br/>
Format: `todo TASK` <br/>
Example: 
* `todo read book`
### 3.2 Adding an 'event': `event`
Adds an 'event' to the task list. <br/>
Format: `event TASK /at EVENT_TIME` <br/>
Example:
* `event team project meeting /at 2/10/2019 2-4pm`
### 3.3 Adding a 'deadline': `deadline`
Adds a 'deadline' to the task list. <br/>
Format: `deadline TASK /by DUE_TIME` <br/>
Example:
* `deadline submit report /by 11/10/2019 5pm`
### 3.4 Listing all tasks: `list`
Shows a list of tasks in the task list. <br/>
Format: `list`
### 3.5 Finding tasks by keywords: `find`
Find tasks which descriptions contain the given keywords. <br/>
Format: `find KEYWORD` <br/>
Example:
* `find book`
### 3.6 Deleting a task: `delete`
Deletes the specified task from the task list. <br/>
Format: `delete INDEX` <br/>
Example:
* `delete 1`
#### Note:
* The index refers to the index number shown in the displayed task list. 
### 3.7 Marking a task as done: `done`
Marks the specified task from the task list as done. <br/>
Format: `done INDEX` <br/>
Example:
* `done 1` <br/>
#### Note:
* The index refers to the index number shown in the displayed task list.
### 3.8 Saving the data
Task list data are saved in the hard disk automatically after any command that changes the data. <br/>
There is no need to save manually. <br/>
This data can be accessed during later sessions. <br/>
### 3.9 Exiting the program: `bye`
Exits the program. <br/>
Format: `exit`

## 4. Command Summary
* `todo TASK` <br/>
  e.g. `todo read book`
* `event TASK /at EVENT_TIME` <br/>
  e.g. `event team project meeting /at 2/10/2019 2-4pm`
* `deadline TASK /by DUE_TIME` <br/>
  e.g. `deadline submit report by 11/10/2019 5pm`
* `list`
* `find KEYWORD` <br/>
  e.g. `find book`
* `delete INDEX` <br/>
  e.g. `delete 1`
* `done INDEX` <br/>
  e.g. `done 1`
* `bye`
