# Makefile for Java project

# Define the compiler and flags
JAVAC = javac
JAVA = java
JFLAGS = 

# Define the source directory
SRCDIR = src

# Define the package names
PACKAGEDIRS = mygame Controllers Models Utils Views

# Define the source files
SOURCES = $(wildcard $(SRCDIR)/*/*.java) $(wildcard $(SRCDIR)/*.java)$(wildcard $(SRCDIR)/*/*/*.java) 

# Define the classpath
CLASSPATH = 

# Define the output directory
OUTDIR = out

# Define the main class
MAINCLASS = labyrinth

# Default target
default: build

# Compile the Java source files
build:
	$(JAVAC) -d $(OUTDIR) $(SOURCES)

# Run the Java application
run:
	$(JAVA) -classpath $(OUTDIR) $(MAINCLASS)

# Clean the compiled class files
clean:
	rm -rf $(OUTDIR)/*

# Clean and rebuild the project
rebuild: clean build

# Phony targets
.PHONY: default build run clean rebuild




# JFLAGS = -g
# JC = javac
# .SUFFIXES: .java .class
# .java.class:
# 	$(JC) $(JFLAGS) $*.java

# CLASSES = \
# 	src/mygame/labyrinth.java \
# 	src/mygame/Controllers/CharactersMovesManage.java \
# 	src/mygame/Controllers/dragonActionAI.java \
# 	src/mygame/Controllers/GameTimers.java \
# 	src/mygame/Models/TheDragon/Dragon.java \
# 	src/mygame/Models/TheFighter/FighterCaracter.java \
# 	src/mygame/Utils/MapMaths.java \
# 	src/mygame/Utils/PicturesPath.java \
# 	src/mygame/Views/FireAndShieldManage.java \
# 	src/mygame/Views/RightSidePanel.java

# default: classes

# classes: $(CLASSES:.java=.class)

# clean:
# 	$(RM) src/mygame/*.class
# 	$(RM) src/mygame/Controllers/*.class
# 	$(RM) src/mygame/Models/TheDragon/*.class
# 	$(RM) src/mygame/Models/TheFighter/*.class
# 	$(RM) src/mygame/Utils/*.class
# 	$(RM) src/mygame/Views/*.class
