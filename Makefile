# Makefile for Java project

# Compiler
JAVAC = javac

# Flags for compiler
JAVACFLAGS = -cp .

# Java interpreter
JAVA = java

# Flags for Java interpreter
JAVAFLAGS = -cp .

# Source files
SOURCES = src/mygame/labyrinth.java \
          src/mygame/CaractereButtonInterface.java \
          src/mygame/Controllers/CharactersMovesManage.java \
          src/mygame/Controllers/dragonActionAI.java \
          src/mygame/Controllers/GameTimers.java \
          src/mygame/Models/TheDragon/Dragon.java \
          src/mygame/Models/TheFighter/FighterCaracter.java \
          src/mygame/Utils/MapMaths.java \
          src/mygame/Utils/PicturesPath.java \
          src/mygame/Views/FireAndShieldManage.java \
          src/mygame/Views/RightSidePanel.java

# Class files
CLASSES = $(SOURCES:.java=.class)

# Main class
MAIN_CLASS = src.mygame.CaractereButtonInterface

# Default target
all: compile run clean

# Compile Java source files
compile: $(CLASSES)

%.class: %.java
	$(JAVAC) $(JAVACFLAGS) $<

# Run the Java program
run:
	$(JAVA) $(JAVAFLAGS) $(MAIN_CLASS)

# Clean compiled files
clean:
clean:
	del src\mygame\*.class
	del src\mygame\Controllers\*.class
	del src\mygame\Models\TheDragon\*.class
	del src\mygame\Models\TheFighter\*.class
	del src\mygame\Utils\*.class
	del src\mygame\Views\*.class






    