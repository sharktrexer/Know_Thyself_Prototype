package com.thyself;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Controller {
	
	// Keeps track of the choices made and scenarios experienced
	static List<String> userTags = new ArrayList<String>();
			
	// Keeps track of points earned for each alignment, where the index is represented by the Alignment enum
	static Integer[] chart = new Integer[] {0,0,0,0,0,0,0,0,0};
	
	// String representations of each alignment.
	final static String[] alignments = new String[] {
			"LG", "NG", "CG", "LN", "TN", "CN", "LE", "NE", "CE" };
	
	final static String[] alignmentsFull = new String[] {
			"Lawful Good", "Neutral Good", "Chaotic Good", 
			"Lawful Neutral", "True Neutral", "Chaotic Neutral", 
			"Lawful Evil", "Neutral Evil", "Chaotic Evil" };
	
	// Launch point
	public static void main(String[] args) {
		// Game logic
		PlayScenario(ScenarioBuilder.copStory);
	}
	
	/* Uses int value of Alignment to increment chart score. As
	 * Success: return 1 else -1 */
	private static int IncrementAlignment(Alignment align) {
		
		if(align == null)
			return -1;
		
		chart[align.ordinal()]++; 
		return 1;
	}
	
	// Iterates through chart array to search for ties in values
	// Adds associated alignment tags to userTags if there are ties. 
	// This will be used to know which of tie breaker scenario options should be available.
	private static boolean CheckForAlignTies() {
		
		// Get max alignment score
		int max = 0;
		for(int i = 0; i < chart.length; i++) {
			if(chart[i] > max) {
				max = chart[i];
			}
		}
		
		List<String> ties = new ArrayList<String>();
		// Loop again to find any ties and store their alignment.
		for(int i = 0; i < chart.length; i++) {
			if(chart[i] == max) {
				ties.add("tie_" + alignments[i]);
			}
		}
		
		// If there are ties, add the appropriate tie tag for each tied alignment
		if(ties.size() < 2) 
			return false;
		
		for(String s : ties) { userTags.add(s); }
		return true;
	}
	
	// Check if UserTags contains all tags of the passed in list
	private static boolean DoesUserTagsContains(List<String> tags) {
		
		boolean containsAll = true;
		// If ever false, return false, otherwise loop until true can be concluded
		for(String tag : tags) {
			containsAll = userTags.contains(tag);
			if(!containsAll)
				break;
		}
		return containsAll;
	}
	
	private static void AddTagsToUser(List<String> tags) {
		
		for(String tag : tags) {
			userTags.add(tag);
		}
	}	
	
	// Returns number input from user or -1 for input that is not within 1 to maxNum.
	// Also has cases for special debug commands to print info.
	private static int ValidatePlayerInput(BufferedReader in, int maxNum) {
		
		// Invalid inputs or reader IOExceptions are caught
		try {
			String line = in.readLine().strip();
			
			// No detection needed, input is only being used to continue
			if(maxNum <= 0)
				return -1;
			
			// Assume input is not a valid number given input length is > 1
			if(line.length() > 1) {
				// Check for debug commands if input is not a number. Still treated as invalid input 
				String msg = "";
				switch(line) {
					case "tags":
						System.out.println(userTags);
						msg = "Received tags Debug Command";
						break;
					case "align":
						//System.out.println(alignmentChart);
						System.out.println(chart);
						msg = "Received alignment Debug Command";
						break;
					default:
						msg = "Invalid Input";
						break;
				}
				throw new IOException(msg);
			}
			
			// Check for valid number within 0 to maxNum
			int num = Integer.parseInt(line);
			if(num < 1 || num > maxNum) {
				throw new IOException("Invalid Number");
			}
			return num;
		}
		catch(NumberFormatException | IOException ex) { //Input failed
			System.out.println("Input Error:\t" + ex.getMessage());
			return -1;
		}
	}
	
	private static void PlayScenario(List<Scenario> scenes) {
		
		// Game vars
		boolean end = false;
		int index   = 0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		// Scenario vars
		Scenario 	 curScene;
		List<Option> availOptions;
		Option chosenOp;
		String nextSceneID;
		boolean onlyTransition;
		
		while(!end) {
			curScene 	   = scenes.get(index);
			availOptions   = new ArrayList<Option>();
			chosenOp       = null;
			nextSceneID    = "";
			onlyTransition = false;
			
			// Print info
			System.out.println(curScene.desc);
			
			// In case of null options
			if(curScene.options != null) {
				// Fetch options, and check if these are transition options
				// there SHOULDN'T be any non-transitional options if the first option is
				for(Option op : curScene.options) {
					
					// Transition options, one option is automatically selected, no list required
					// Get option PointsID where conditions are met, or if there are not conditions
					// Empty tags on transition option means this is the only option anyway
					if(op.desc == "" && (op.tagsRequired == null || 
										 op.tagsRequired.isEmpty() || 
										 DoesUserTagsContains(op.tagsRequired) )) 
					{
						nextSceneID = op.pointsToID;
						onlyTransition = true;
						break;
					}
					// Regular options, just add to list if no conditions or conditions are met
					else if(op.tagsRequired == null || DoesUserTagsContains(op.tagsRequired)){
						availOptions.add(op);
					}				
				}
			}
			else { onlyTransition = true; }
			
			// User needs to choose an option, if applicable
			if(!onlyTransition) {
				
				int ind = 0;
				// Print available options
				for(Option op : availOptions) {
					ind++;
					System.out.println(ind + ". " + op.desc);
				}
				
				int input = -1;
				// Input and validation
				while(input < 0) {
					
					System.out.println("\nPlease enter a valid number associated with the above options.");
					input = ValidatePlayerInput(in, availOptions.size()) - 1;
				}
				// Store chosen option and its values
				chosenOp = availOptions.get(input);
				
				nextSceneID = chosenOp.pointsToID;
				
				if(chosenOp.tags != null) 
					AddTagsToUser(chosenOp.tags);
				
				if(chosenOp.alignment != null)
					IncrementAlignment(chosenOp.alignment); // If -1 is returned there is a problem!
				
				if(chosenOp.resultDesc != "")
					System.out.println("\n" + chosenOp.resultDesc + "\n");
				
			}
			// User's choice has been determined already, this is a transition to the next scene
			else {
				System.out.println("\nPlease enter anything to continue");
				ValidatePlayerInput(in, 0);
			}
			
			// Change scenario
			int tempInd = index;
			if(nextSceneID != "") {
				for(int i = index; i < scenes.size(); i++) {
					if(scenes.get(i).id == nextSceneID) {
						index = i;
						break;
					}
				}
			}
			
			/* Don't end the game if there is a tie of alignments! 
			 * Instead, the game must play through the final and special tie breaker scenario 
			 * (stored in the last spot of the scenes list)
			 */
			if(tempInd == index && index != scenes.size() - 1 && CheckForAlignTies()) 
				index = scenes.size() - 1;

			// End if the index did not change
			end = tempInd == index;
		}
		// Story ended
		
		// Who cares if this throws an error, will this cause problems in the future?
		try { in.close(); } catch (IOException e) {}
		
		System.out.println("Story ended!\n");
		System.out.println("You're alignment is... ");
		
		// Get max alignment score
		int max = 0;
		int indexOfMaxAlign = 0;
		for(int i = 0; i < chart.length; i++) {
			if(chart[i] > max) {
				max = chart[i];
				indexOfMaxAlign = i;
			}
		}
		
		// Print alignment and short descriptor (starting with "This means you ")
		String playerAlign = alignmentsFull[indexOfMaxAlign];
		String msg = "";
		
		System.out.print(playerAlign + ". This means you ");
		
		switch(playerAlign) {
		case "Lawful Good"    :
			msg = "stick to your strong values which includes putting others first.";
			break;
		case "Neutral Good"   :
			msg = "put others first as best as you can.";
			break;
		case "Chaotic Good"   :
			msg = "do whatever you like but still put others first.";
			break;
		case "Lawful Neutral" :
			msg = "believe rules are what keeps everything functioning.";
			break;
		case "True Neutral"   :
			msg = "don't have very strong opinions other than you prefer your life to be pleasant.";
			break;
		case "Chaotic Neutral": 
			msg = "value freedom above all else.";
			break;
		case "Lawful Evil"    :
			msg = "stick to your strong values, stepping on whomever gets in your way.";
			break;
		case "Neutral Evil"   :
			msg = "believe you are better than most, if not all people.";
			break;
		case "Chaotic Evil"   :
			msg = "believe you can get away with anything you want, when you want.";
			break;
		}
		System.out.print(msg);
		
	}

}
