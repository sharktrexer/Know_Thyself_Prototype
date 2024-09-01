# Know Thyself (Terminal Edition)

This a simplistic choose-your-adventure terminal game where you are presented with multiple actions in different scenarios with an overarching and branching story. 
By the end of the story your chosen actions will determine what alignment you fall onto in the [Alignment Chart](https://en.wikipedia.org/wiki/Alignment_(Dungeons_%26_Dragons)).
**Will you get the result you think you will?**

### Content
There are 40 different choices to make, 2 major branches of the story, 8 unique endings to see, 9 secret choices to find, and 9 alignments to act as. Try your best to see if you can experience it all!

### Editable
You can also try and create your own story for the program to play through! Simply follow the formatting instructions in _Documents/Story_Code_Outline.txt_ and place all Scenario objects in a new static ArrayList<Scenario> in _ScenarioBuilder.java_.
Then simply change line 27 in _Controller.java_ from "PlayScenario(ScenarioBuilder.copStory);" to "PlayScenario(ScenarioBuilder._yourListNameHere_);"

### Instructions
TBD. However, feel free to download all the .java files from src/com/thyself and run _Controller.java_ using [this tutorial](https://stackoverflow.com/questions/1279542/how-to-execute-a-java-class-from-the-command-line)

### v1.0 Desired Outcome:
User input will be fetched through terminal to advance the story. Endings/secret options/alignments obtained are tracked. Jar file is provided.

_Current Comment:_
Just need to add a tracker for obtaining different endings/special choices, do a final round of polish, and create and upload a jar file.

In Developement Webapp Version [HERE](https://github.com/sharktrexer/Know_Thyself)

### Current example of using the software:

![terminal 1](https://github.com/user-attachments/assets/e16caf2b-c6b7-4ea1-8e65-46649d4f7068)
![terminal 2](https://github.com/user-attachments/assets/4ae42631-749f-4d42-8555-dbc1ee33d170)
### After completing the story:
![terminal 3](https://github.com/user-attachments/assets/f1db5472-4729-4df9-9e61-301890bf8d57)
