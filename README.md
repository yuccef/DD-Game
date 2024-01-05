# Dungeons & Dragons Java Game

## Overview
This project is an implementation of the "Dungeons & Dragons" game using Java with a graphical interface built with Java Swing. The game incorporates sound effects, artificial intelligence (AI), and allows players to choose a fighter at the beginning. There are three types of fighters available: Humane Fighter, Knight, and Witch. Players also choose the difficulty level (Easy, Medium, Hard), with each level featuring a dragon opponent with specific characteristics (Name, Life, Damage, Defense). The objective is to navigate through a labyrinth to find and defeat the dragon, using 'enter' to attack and 'x' to defend.

## Features
- Choose from three different types of fighters: Humane Fighter, Knight, or Witch.
- Select the difficulty level: Easy, Medium, or Hard.
- Navigate through a labyrinth to find and battle a dragon.
- Use 'enter' to attack and 'x' to defend during the dragon encounter.
- Monitor round characteristics, dynamic features (e.g., life), and a timer on the right side panel.
- Utilize Design Patterns such as Factory, Observer, and Singleton.

## Project Organization

### Project Structure
- **src**: Contains all the source code for the Java game.
  - **game**: Main game code.
    - **models**: Classes representing different objects in the game (Dragons & Fighters).
    - **views**: Different views or screens of the game (Labyrinth, RightSidePanel, FireAndShield, etc.).
    - **controllers**: Classes handling user input and managing game logic (DragonActionAI, CharactersMovesManage, Sound, etc.).
    - **utils**: Utility classes or helper functions used throughout the game (PicturePaths, MapMaths).
    - **resources**: External resources needed for the game, such as images (Packages for each Dragon/Fighter).

### Compilation
To simplify the execution of the project, a Makefile has been provided. Follow these steps:
1. Export all files (the entire project).
2. Open your terminal and navigate to the project directory.
3. Enter the command `make` in the terminal.
4. Begin playing the game!

Feel free to adjust the Makefile or include additional instructions as needed for your specific development environment.




## Sources 
 1. Github
 2. Stack overflow
 3.  Cours developpement jeux et video (Université de Lorraine)
 4.  Youtube
 5. OpenClassroom
 6. Craftpix
 7. encycolorpedia
