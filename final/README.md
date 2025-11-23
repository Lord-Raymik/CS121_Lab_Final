# Final Project Documentation

## Hotel Capitalist (current name)
This project will be a simulation of managing a hotel, with some game-like aspects added onto it.  
It will involve making decisions on a "turn" to "turn" basis. These decisions would influence certain variable's of your business, such as popularity, staff, room number, etc. It will also have random events happen each turn, with the way you handle them causing some sort of consequence, whether good or bad. This will make a game loop of both what to focus on each turn, as well as choosing how to handle events as they come by. The game will likely have multiple endings, based on if you get some certian amount of money by the end of the game, dont get enough money, or if you go bankrupt. Either way, I think this gameplay loop should work well if done right.  
When it comes to intended users, they would simply be whoever wants to play to game. Due to being a game, this is kind of an easy observation.  
As for what problems this game is meant to solve... I guess boredom? That's typically what games try and fix. Oh, and I guess this also solves the problem of me needing to make a final project. On yop of that, it would likely appeal to those who like text based games who also wants to simulate managing a hotel.  
For technologies and structures... I'll probably need to make a class or two involving the hotel itself. This would track things such as how many rooms it has, how many employees it has, how much money it currently has, it's popularity, staff and customer satisfaction, etc. I'll also need a class representing a random event, which I could make subclasses of to represent different types of events. Also, the hotel itself, as well as events, will need interactable text menus. I can do this through an interface, as there are multiple things I'll need it to apply to. Also relating to events, I plan to generate and store them in an arraylist at the beginning of each turn. This will, obviously, require an arraylist. However, there's also generation to think about. Specifically, I want there to be universal events that can always happen, as well as situational events that only appear if, for instance, you chose a certain buisiness focus at the start fo the turn, such as expanding your number of rooms or something. This would serve to try and mix things up a bit.  

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

