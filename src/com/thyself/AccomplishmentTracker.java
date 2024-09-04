package com.thyself;

import java.util.ArrayList;

public class AccomplishmentTracker {

	ArrayList<Accomplishment> endings = new ArrayList<Accomplishment>();
	ArrayList<Accomplishment> secrets = new ArrayList<Accomplishment>();
	
	ArrayList<Accomplishment> achievedEndings = new ArrayList<Accomplishment>();
	ArrayList<Accomplishment> achievedOptions = new ArrayList<Accomplishment>();
	ArrayList<String> achievedAligns = new ArrayList<String>();
	
	
	public AccomplishmentTracker(ArrayList<Accomplishment> endings, ArrayList<Accomplishment> secrets) {
		this.endings = endings;
		this.secrets = secrets;
	}

	
	// achieveType = 1 means it is an ending, 2 means it is an option, 3 means alignment	
	public void addAchievement(Accomplishment a) {
		if(a.type() == 1) {
			achievedEndings.add(a);
		}
		else if(a.type() == 2) {
			achievedOptions.add(a);
		}
		else if(a.type() == 3) {
			//TODO
			achievedAligns.add(a.title());
		}
	}

	
	
	public void printAllObtainedAchivements() {
		System.out.println("Obtained Endings: ");
		System.out.print(achievedEndings);
		System.out.println("Secret Options Found: ");
		System.out.print(achievedOptions);
		System.out.println("Aligments Acted As:  ");
		System.out.print(achievedAligns);
	}

	public void printPossibleAchievements() {
		System.out.println("Possible Endings: " + endings );
		System.out.println("Secret Options: " + secrets );
		System.out.println("Alignments:  " + Controller.alignmentsFull );
	}	
	
	public void printObtainedEndingsRatio() {
		
		System.out.println("You have seen [ " + achievedEndings.size() + "/" + endings.size() + "] total endings.");
		
		if (achievedEndings.size() == endings.size()) {
			System.out.println("This means you have seen every ending. Congratulations!");
		}
	}
	
	public void printObtainedSecretsRatio() {
		
		System.out.println("You have chosen [ " + achievedOptions.size() + "/" + secrets.size() + "] total secret options.");
		
		if (achievedOptions.size() == secrets.size()) {
			System.out.println("This means you have chosen every secret option. Well done!");
		}
	}
	
	public void printObtainedAlignsRatio() {
		
		System.out.println("You have acted as [ " + achievedAligns.size() + "/9] total alignments.");
		
		if (achievedAligns.size() == 9) {
			System.out.println("This means you have acted as every different alignment. How well rounded of you!");
		}
	}
	
	public void clearProgress() {
		achievedEndings.clear();
		achievedOptions.clear();
		achievedAligns.clear();
	}
	
	
}                                            
