Hotel.class: Hotel.java MenuBase.class MenuHotel.class HasMenu.class Config.class
	javac -g Hotel.java

MenuBase.class: MenuBase.java HasMenu.class
	javac -g MenuBase.java

MenuHotel.class: MenuHotel.java MenuBase.class HasMenu.class
	javac -g MenuHotel.java

HasMenu.class: HasMenu.java
	javac -g HasMenu.java

Config.class: Config.java
	javac -g Config.java

testHotel: Hotel.class
	java Hotel
