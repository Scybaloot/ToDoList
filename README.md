ToDoList

# Pre-work - *To Do List*

**To Do List** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: **Colby Sato**

Time spent: **10** hours spent in total

## User Stories

The following **required** functionality is completed:

* [X] User can **successfully add and remove items** from the todo list
* [X] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [X] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [ ] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [ ] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item)
* [ ] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)
* [X] Tweak the style improving the UI / UX, play with colors, images or backgrounds.
** I changed the color to green.

The following **additional** features are implemented:
* [X] Following Nielson's Heuristic of visibility of system status, I provided a dialog box 

## Video Walkthrough 

Here's a walkthrough of basic implemented user stories:

<img src='toDoList.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

Here's a walkthrough of my modified app with confirmation for user's edit action and a change in colors:

<img src='Green To Do List.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />


GIF created with [Recordit](http://recordit.co/).

## Notes

I faced several challenges while programming this application
* I misunderstood how scoping worked for variables. Ex. In the editItemActivity.java file, I received the position with intents in the onCreate method, but didn't realize I needed to call it again in the submit method.
* Calling the wrong id/item. Ex. etNewItem vs lvItems
* I misunderstood how to make a long-click listener for the list. I tried to put a long-click listener in the activity_edit_item.xml file instead of the MainActivity.java file. 
* I tried to set a new adapter view when removing and inserting items into the list.  

**Approach**

Roadblocks were faced, but I solved them by doing the following
* Asked "What is the goal?" and "What do I think I am doing?"
* Tested components to find what was working/broken.
* Read CodePath documentation, paying attention to key terms. 
* If I didn't understand a term in the documentation, I'd read more background documentation to learn how things like intents and actions worked. 
 
## License

    Copyright 2016 Colby Sato

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.