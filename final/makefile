Hotel.class: Hotel.java MenuBase.class MenuHotel.class MenuStaff.class MenuStats.class MenuTurn.class HasMenu.class Config.class
	javac -g Hotel.java

MenuBase.class: MenuBase.java HasMenu.class
	javac -g MenuBase.java

MenuHotel.class: MenuHotel.java MenuBase.class HasMenu.class
	javac -g MenuHotel.java

MenuStaff.class: MenuStaff.java MenuBase.class HasMenu.class
	javac -g MenuStaff.java

MenuStats.class: MenuStats.java MenuBase.class HasMenu.class
	javac -g MenuStats.java

MenuTurn.class: MenuTurn.java MenuBase.class HasMenu.class
	javac -g MenuTurn.java

HasMenu.class: HasMenu.java
	javac -g HasMenu.java

Config.class: Config.java
	javac -g Config.java

testHotel: Hotel.class
	java Hotel

clean:
	rm *.class
