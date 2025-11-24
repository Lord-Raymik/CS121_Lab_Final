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

**public static void main(String[] args)**  
```
create a new MainMenu
call start() on the new MainMenu
```

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

### Hotel - class
This class, despite it's name, practically represents the entirety of a game. Representing the hotel itself, this stores practically all the data related to a game, including hotel stats, going through turns, handling events, etc. Due to having a menu, Hotel also implements the HasMenu interface. It includes the follow variables and methods.  

MainMenu - mainMenu: this is a reference to the main menu.  

GameLog - log: this is the log for the current game.  

EventList - events: this is an arraylist containing all the events the game goes through on each turn.  

double - balance: this is the money the hotel currently has.  

double - rating: this is the customer rating the hotel currently has.  

int - rooms: this is the max number of rooms.  

int - guests: this is the current number of guests in rooms.  

int - staff: this is the current number of staff.  

double - service: basically customer satisfaction. influences how your rating changes with each guest.  

double - staffContent: this influences how likely it is that staff

### Event - class
This class represents an event that happens during a turn. It contains a string explaining it's situation, as well as containing a list of different EventChoice objects. This class also contians menus, so it will implement the HasMenu interface.  

Hotel - hotel: this is a reference to the hotel.  

String - premise: this is the situation that the event describes, which will be printed for the user.  

ArrayList<EventChoice> - choices: this is an arraylist containing every choice the user can make in response to the event.  

**public static void main(String[] args)**  
```
create a new event
define some test premise and choices for it
call start() on the event
```

**public Event()**  
```
set hotel to null
set String to "null"
set choices to an empty arraylist
```

**public Event(Hotel hotel, String inPremise, ArrayList<EventChoice> inChoices)**  
```
set the event's values to match the parameters
```

**public void setHotel(Hotel input)**  

**public void setPremise(String input)**  

**public void setChoices(ArrayList<EventChoice> input)**  

**public void String menu()**  
```
create a new Scanner
print out the premise
print out the choice value in each EventChoice
ask the user what they would like do
save their response to a variable
if the response does not correspond to one of the question indexes, set the response to null
return the value from the response
```

**public void start()**  
```
create a new boolean called keepGoing, set it to true
while keepGoing
    call menu() and save it's return value in a variable calle input
    if input corresponds to an EventChoice
        set keepGoing to false
        print out the result value from the corresponding EventChoice
        call choose() on the corresponding EventChoice
```

### EventChoice - class
This class represents a choice contained within an event. It has it's own name representing what the choice itself is, as well as what hotel variable it affects, and by how much.  

Hotel - hotel: this is a reference to the hotel.  

String - choice: this is effectively the text explaining what the choice actually is.  

String - result: this is the text that occurs when you pick this choice.   

EventVar - targetValue: this specifies which value in Hotel is being targeted.  

double - amount: this is the amount that the target value is being changed by. It will add to it if it's positive, and subtract if it's negative.  

**public static void main(String[] args)**  
```
create a new Hotel
create a new EventChoice
set the EventChoice to reference the hotel
design some test values for the choice and apply them to it
print the choice from the EventChoice
print the result form the EventChoice
print the current values in the Hotel
call choose() on the EventChoice
print the new values from Hotel
```

**public EventChoice()**  
```
set hotel to null
set choice to "null"
set result "null"
set targetValue to null
set amount to 0
```

**public EventChoice(Hotel inHotel, String inChoice, String inResult, EventVar inTarget, double inAmount)**  
```
set hotel to inHotel
set choice to inChoice
set consequence to inResult
set targetValue to inTarget
set amount to inAmount
```

**public void setHotel(Hotel input)**  

**public void setChoice(String input)**  

**public void setResult(String input)**  

**public void setTargetValue(EventVar input)**  

**public void setAmount(double input)**  

**public String getChoice()**  

**public String getResult()**  

**public void choose()**  
```
if hotel != null
    target the variable in hotel corresponding to targetValue
    change the variable by amount, adding to it if amount is positive and subtracting if negative
```

### EventVar - enum
This is an enumeration representing what variable in hotel is being targeted by an EventChoice. It can be one of the following values.  
```
Balance
Rating
Room
Guest
Staff
Service
StaffContent
```
### EventList - class
This class extends ArrayList<Event>. It has methods relating to interacting with the events it contains.  

**public void run()**  
```
for every Event in the EventList
    call start()
call clear() on the EventList
```

### GameLog - class
This class keeps track of a game throughout every turn, remembering what it's variable's values were at each turn, as well as what ending a game had. In short, it should be able to clearly show how a run went throughout it's playtime. This class has menus, so it will implement the HasMenu interface.  

String - ending: this value is null until the user finished a the corresponding game.  

ArrayList<double> - balance: tracks the balance of the hotel every turn.  

ArrayList<double> - rating: tracks the rating of the hotel every turn.  

ArrayList<int> - rooms: tracks the number of rooms in the hotel every turn.  

ArrayList<int> - guests: tracks the number of guests in the hotel every turn.  

ArrayList<int> - staff: tracks the number of staff in the hotel every turn.  

ArrayList<double> - service: tracks the service of the hotel every turn.  

ArrayList<double> - staffContent: tracks the staff contentedness in the hotel every turn.  

**public static void main(String[] args)**  
```
create a new 
```

**public GameLog()**  
```
set ending to be null
set every arraylist tracking a value to be empty
```

**public String menu()**  
```
create a new Scanner
print out the different options the user can select
ask the user for their response and save it to a variable
return the user's response
```

**public void start()**  
```
create a new boolean called keepGoing, set it to true
while keepGoing
    call menu() and save its response to a variable called input
    if input is "0"
        set keepGoing to false
    if input is "1"
        if ending != null
            print the ending the game had
        print the last values in the arraylists tracking the hotel variables
    if input corresponds to a specific variable (will not define which number is which now)
        print what the variable's value was during every turn
```

**public void addTurnValues(Hotel hotel)**  
```
for every hotel variable that has a corresponding arraylist tracking it over every turn
    add the hotel value to the arraylist tracking it
```

**public void setEnding(String input)**  

### LogList - class
This class extends ArrayList<gameLog>. It has a menu used for interacting with these GameLogs, so it implements the HasMenu interface.  

**public String menu()**  
```
create a new Scanner
print the options the user can select
ask the user for their response and save it to a variable
return the value in the user's response variable
```
