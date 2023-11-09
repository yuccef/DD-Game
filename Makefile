JAVAC = javac
JAVA = java
SRC_DIR = DrawTheMap
OUT_DIR = .

# List of Java source files
SRCS = $(wildcard $(SRC_DIR)/*.java) $(wildcard TheFighter/*.java) $(wildcard TheDragon/*.java)

# Target executable
TARGET = DrawTheMap/labyrinth

all: build run

build:
	$(JAVAC) $(SRCS) -d $(OUT_DIR)

run:
	$(JAVA) -cp $(OUT_DIR) $(TARGET)

clean:
	find . -name "*.class" -type f -delete
