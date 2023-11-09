# Organization 

## In this project we will use this convention :

In an object-oriented programming (OOP) Java game, the organization and naming of folders typically follow certain conventions to ensure a well-structured and maintainable codebase. Here is a common folder structure that you might find in an OOP Java game:

    src: This folder contains all the source code for your Java game.
        com: This folder includes the top-level package for your game.
            yourcompanyname: Replace this with your actual company name or a unique identifier for your project.
                game: This folder contains the main game code.
                    models: This folder contains the various models or classes representing different objects in the game, such as Player, Enemy, Item, etc.
                    views: This folder contains the different views or screens of the game, such as MainMenu, GameScreen, EndScreen, etc.
                    controllers: This folder contains the controller classes that handle user input and manage the game logic.
                    utils: This folder contains utility classes or helper functions used throughout the game.
                    resources: This folder contains any external resources needed for the game, such as images, sound files, or other assets.

    lib: This folder may contain any external libraries or dependencies that your game requires.

    res: This folder may contain additional resources, such as configuration files, game data, or other assets needed during runtime.

It's important to note that the folder structure may vary depending on the specific requirements of your game and the preferences of the development team. However, following a structured organization like the one described above can help improve the readability, maintainability, and scalability of your codebase.