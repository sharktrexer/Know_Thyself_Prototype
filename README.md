# Know Thyself (Terminal Edition)

This a simplistic choose-your-adventure terminal game where you are presented with multiple actions in different scenarios with an overarching and branching story. 
By the end of the story your chosen actions will determine what alignment you fall onto in the [Alignment Chart](https://en.wikipedia.org/wiki/Alignment_(Dungeons_%26_Dragons)).
**Will you get the result you think you will?**

### Content
There are 40 different choices to make, 2 major branches of the story, 8 unique endings to see, 9 secret choices to find, and 9 alignments to act as. Try your best to see if you can experience it all!

I'm also attempting to port this over to an in-developement web app to learn Spring Boot & Thymeleaf [HERE](https://github.com/sharktrexer/Know_Thyself)

### Instructions
1. Have the latest version of the [Java SDK](https://www.oracle.com/java/technologies/downloads/#jdk22-windows) installed.
2. Download __Know_Thyself.jar__ and place in an appropriate directory/folder.
3. Open a command prompt and change directory to the download location.
4. Enter "java -jar Know_Thyself.jar"
5. Enjoy!

### Editable
You can also try and create your own story for the program to play through! Simply follow the formatting instructions in _Documents/Story_Code_Outline.txt_ and place all Scenario objects in a new static ArrayList<Scenario> in _ScenarioBuilder.java_.
Then simply go to Controller.java change the story variable **STORY_SCENES** = "ScenarioBuilder.copStory;" to "ScenarioBuilder._yourListNameHere_;"

You can similary find instructions in the aforementioned text file to create your own accomplishments to earn from your story.
In Controller.java change the story variable **TRACKER** = "new AccomplishmentTracker(AccomplishmentBuilder.copStoryAccomps);" to "new AccomplishmentTracker(AccomplishmentBuilder._yourAccomplishmentListNameHere_);"

### Current example of using the software:

![terminal 1](https://github.com/user-attachments/assets/e16caf2b-c6b7-4ea1-8e65-46649d4f7068)
![terminal 2](https://github.com/user-attachments/assets/4ae42631-749f-4d42-8555-dbc1ee33d170)
### After completing the story:

![terminal 3](https://github.com/user-attachments/assets/cb0ebc90-8065-4201-8420-2ce87db034d0)
![achievements](https://github.com/user-attachments/assets/99f4d5ec-3c30-4498-8c6c-abed65ba985a)

### Credits
- Programming by me, Ibrahim Sydock
- Story Writing by Zayne Wilkinson
