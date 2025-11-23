# Final Project Documentation

## Hotel Capitalist (current name)
This project will be a simulation of managing a hotel, with some game-like aspects added onto it.  
It will involve making decisions on a "turn" to "turn" basis. These decisions would influence certain variable's of your business, such as popularity, staff, room number, etc. It will also have random events happen each turn, with the way you handle them causing some sort of consequence, whether good or bad. This will make a game loop of both what to focus on each turn, as well as choosing how to handle events as they come by. The game will likely have multiple endings, based on if you get some certian amount of money by the end of the game, dont get enough money, or if you go bankrupt. Either way, I think this gameplay loop should work well if done right.  
When it comes to intended users, they would simply be whoever wants to play to game. Due to being a game, this is kind of an easy observation.  
As for what problems this game is meant to solve... I guess boredom? That's typically what games try and fix. Oh, and I guess this also solves the problem of me needing to make a final project. On yop of that, it would likely appeal to those who like text based games who also wants to simulate managing a hotel.  
For technologies and structures... I'll probably need to make a class or two involving the hotel itself. This would track things such as how many rooms it has, how many employees it has, how much money it currently has, it's popularity, staff and customer satisfaction, etc. I'll also need a class representing a random event, which I could make subclasses of to represent different types of events. As for events, I plan to generate and store them in an arraylist at the beginning of each turn. This will, obviously, require an arraylist. However, there's also generation to think about. Specifically, I want there to be universal events that can always happen, as well as situational events that only appear if, for instance, you chose a certain buisiness focus at the start fo the turn, such as expanding your number of rooms or something. This would serve to try and mix things up a bit.  
As another short aside, there are going to be a lot of menus related to this game. There will be a menu for the homescreen, a menu for the hotel, a menu for every month of running the hotel, a menu for the different events that occur each month, etc. Due to this, I think making an interface—similar to the one we made for BankOnIt—would be good here, simply due to how many different menus there are.  

Also on another note, this is a much farther goal on the milestones, but I plan to implement serialization, as well as logs to track a user's progress over a game. This will also allow me to save a list of logs from previous runs, allowing someone to look at their past attempts at the game, and maybe even see in which runs they had the best ranking in each stat, or something like that. Either way, it would be a way to provide more interaction to the user on some level, as well as just being something that makes sense to add.  

## Use case analysis
I am going to be going through an example runnig of the program, trying to show both what I want it to look/feel like, as well as give a good visual of how the mechanics will actually look while playing. I must note, this is by no means what it is guaranteed to look like in the end, and is subject to change. It is meant to give a *general idea* about how it should look and run.  

### Example session diagram
```
========== Hotel Capitalist ==========

What would you like to do?

0) Quit
1) Start a new game
2) Continue current game
3) View previous records

Choose 0-3: 3

========== Previous Games ==========

Please select a record from a previous game

0) Quit

1) [example game 1]
2) [example game 2]
3) [example game 3]
...
(until the final record)

Choose 0-[number of records]: 1

---------- [example game 1] ----------

Ending: Success (kind of arbitrary at this point, and is a placeholder)

Final value: $100000.00
Final Rating: 4.7 / 5.0

Final Staff: 26
...
(various other stats about the run)


Press ENTER to exit

========== Previous Games ==========

Please select a record from a previous game

0) Quit

1) [example game 1]
2) [example game 2]
3) [example game 3]
...
(until the final record)

Choose 0-[number of records]: 0

========== Hotel Capitalist ==========

What would you like to do?

0) Quit
1) Start a new game
2) Continue current game
3) View previous records

Choose 0-3: 1

---------- New Game ----------

Please enter the name of your hotel...

Name: [my hotel (example name)]

========== [my hotel] ==========

Beginnings...

Congrats! You have just opened a new hotel. You will need to manage it, and make sure it stays afloat. Now there's supposed to be some sort of story element about why you need to do it, but thats not decided upon yet. So for now, you need to get, say... $100000 of revenue by, lets say... the end of the year. Again this is all subject to change. now lets get started.

========== [my hotel] ==========

    Current revenue: $11000.00
    Current Rating: 2.0 / 5.0
    Current rooms: 0 / 20


Before you start your work for the month, would you like to

0) Continue

1) Hire staff
2) Fire staff
...
(more to be determined)

Choose 0-(...): 1

---------- Hire Staff ----------

Current Staff: 1
Current Staff Costs: $1000.00


The monthly pay per staff member is $500 (subject to change). Depending on certain conditions, your staff may decide to quit every month.

How many staff members would you like to hire: 2


New Staff: 3
New staff costs: $3000.00

========== [my hotel] ==========

    Current revenue: $10000.00
    Current rating: 2.0 / 5.0
    Current rooms: 5 / 20


Before you start your work for the month, would you like to

0) Continue

1) Hire staff
2) Fire staff
...
(more to be determined)

Choose 0-(...): 0

========== January, Year 1 ==========

What would you like to focus on this month?

1) Advertising
    - Costs $[amount]
    - Increase popularity, more customers
2) Service
    - Costs $[amount]
    - Increases reviews, betters ratings
...
(final choices to be determined later)

Choose 1-[...]: 1

---------- Event ----------

A popular influencer is staying a night in your hotel. Their experience could have a big impact on your ratings.

What would you like to do?

1) Leave them be
    - No cost
2) Make sure their stay is fine
    - Low cost
    - Increased chance of a good review
3) Go above and beyond
    - High cost
    - High chance of good review
    - No chance of bad review

Choose 1-3: 1

Something went wrong! Their experience went poorly, and their fans noticed.

    @ Lost 0.7 ratings @

---------- Event ----------

A festival is happening in the local area. And with it comes a lot of people lookign for a place to stay!

    @ All rooms now occupied @

... (so on and so forth with some amount of events)

========== Monthly Report ==========

January, Year 1


    Rooms:
        Leaving: -5
        Incoming: 20

        Current rooms: 20 / 20

    Finances:
        Staff costs: -$1500.00
        Guest revenue: $4000.00
        
        Current revenue: $12500.00
    
    Ratings:
        Initial: 2.0 / 5.0
        Current: 1.3 / 5.0
    

Press ENTER to continue

========== [my hotel] ==========

    Current revenue: $12500.00
    Current rating: 1.3 / 5.0
    Current rooms: 20 / 20


Before you start your work for the month, would you like to

0) Continue

1) Hire staff
2) Fire staff
...
(more to be determined)

Choose 0-(...): 

...
(continue on with turns like this until eventually, you reach the end)
...

========== The End ==========

Congratulations! You managed to make enough money by the end of the year, or something like that.
You got the good ending.

Final revenue: $100000 (lets say)
Final ratings: 4.5 / 5.0 (lets also say)

...
(so and so other stats)
...

Thank you for playing Hotel Capitalist, have a wonderful day.

Press Enter to continue

========== Hotel Capitalist ==========

What would you like to do?

0) Quit
1) Start a new game
2) Continue current game
3) View previous records

Choose 0-3: 0
```

## Data design
The program needs to manage data related to the hotel. These are things such as the hotel's name, it's current revenue, it's current rating, the number of staff, the quality of service, the staff satisfaction, etc. On top of that, as I want to implement serialization later, I plan to track and store data about a user's current run, which can then be accessed later. Finally, the data for events needs to be tracked. These are things such as which events actual exist(this refers to the text and choices related to them), what are the consequences of the events, and on top of that, certian things about this are also going to be tracked.  
In short, there is a lot of data to keep track of. And, we need to represent it effectively.  
When it comes to the hotel's data, a lot of it can simply be saved as primitive values. Mostly in the form of ints and doubles. Things get a tad bit more tricky when we get into both the random events, as well as the logs of the different games.  
To begin with the events, and data related to it. The events themselves are going to be a type of object—likely with subclasses and such for different types of events—which will need to somehow be created and stored in the hotel each turn, as they will all need to be called in the menu. As for how I'm going to store them in the hotel class, I think an arraylist/something similar would be great. Now, we need to talk about how to store the different event situations, as well as what options each one has, and what they correlate to. As for the events themselves, I will mkae a list containing all the different events, which will also let me break up the events into different lists based on category—such as if they're general events, monthly focus based events, etc. Next, the events themselves, and how they work. I plan to make each event store a string which describes it's situation. I plan to make each event store a list of different EventChoice objects. These choices will hold a string, contianing a description of what they are/do, a specified variable for hotel that they affect, as well as how much they affect it by. This should allow me to add any number of choices to an event, as well as even make different choices potentially affect entirely different stats. This should allow easier creation of new events and their choices. Also, due to the event having a menu, it will implement our interface for that. Through all of this—admittedy long—explanation about events, I think they should be about good for now.  
Now, I need to talk about the serialization of data. Specifically, I need to define the structure of the logs that track a run's data. To start, this will definitely be a class. It will need to be able to track a game's final values, while also being able to track it's individual values over each turn. This would best be accomplished by an arraylist. This would allow me to append new values to the log after every turn, on top of that, it can simply grab the last value in the arraylist whenever it needs the final value. This structure covers both requirements for how the data needs to be tracked, which I believe shows that it is a very effective choice. The log itself will likely also have some other values, such as what ending you have if it's a past log, but that is a fairly simple variable to track. On top of all this, due to the log having a menu, it will need to implement our interface for that.  

When it comes to data needing to be persistent, there are two main things to speak of. Specifically, the current game, and previous games. Previous games can be stored through an arraylist of previous run logs. This arraylist can then be serialized, allowing these previous logs to be persistent. Next, the hotel. the hotel itself is basically our current run. It stores all of our values, it stores our current run log, it stores where we currently are. Effectively, to be able to save our current run, we simply need to serialize the current Hotel object. By doing this, we are able to make sure that our data is able to persist even if the program closes.

## Algorithm documentation
This section will go over various data members, including what they are, and what they do.

### HasMenu - interface
This is an interface representing that something has a menu. It includes abstract methods such as:  

**public String menu()**  
**public void start()**  

### MainMenu - class
This class represents the main menu, which begins on the program starting. It is from here that the user can decide to start a new game, continue a previous game, view records of previous games, or exit the program. As it is a menu, it will need to include the HasMenu interface. It will include the following data members and methods.  

Hotel - currentGame: This variable represents an existing game. It will be serialized to a file when the program is not running, and loaded when it starts. If there is no current run, it will be saved as null.  
LogList - previousGames: This is a custom class which acts as a list of GameLog's. It has it's own menu, through which the logs are accessed and viewed.  

**public MainMenu()**  
```
call loadGame()
```

**public String menu()**  
```
create a new scanner
print out the menu text, including all the user's options.
save the user's response as a variable
return said variable
```

**public void start()**  
```
create a new boolean called keepGoing, set it to true
while keepGoing
    call menu and save it's return value to a variable called input
    if input is "0"
        set keepGoing to false
        call saveGame()
    if input is "1"
        create a new Hotel and save it to currentGame
        call start() on the new Hotel
    if input is "2"
        if currentGame is null
            tell the user there is no game to load
        else
            call start() on the Hotel in currentGame
    if input is "3"
        call start() on the LogList in previousGames
```

**public void saveGame()**  
```
try
    create a new FileOutputStream named gameFileOut
    create a new ObjectOutputStream named gameObjectOut, connect it to gameFileOut
    create a new FileOutputStream named logFileOut
    create a new ObjectOutputStream named logObjectOut, connect it to logFileOut
    write currentGame to gameObjectOut
    write previousGames to logObjectOut
    close all the streams
catch IOException
    print the exception
```

**public void loadGame()**  
```
try
    create a new fileInputStream named gameFileIn
    create a new objectInputStream named gameObjectIn, connect it to gameFileIn
    create a new fileInputStream named logFileIn
    create a new objectInputStream named logObjectIn, connect it to logFileIn
    read the object from gameObjectIn and save it to currentGame
    read the object from logObjectIn and save it to previousGames
    close all the streams
catch IOException
    set currentGame to null
    create a new empty LogList and save it to previousGames
catch ClassNotFoundException
    print the exception
```
