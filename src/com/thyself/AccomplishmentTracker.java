package com.thyself;

import java.util.ArrayList;

public class AccomplishmentTracker {

	ArrayList<Accomplishment> endings = new ArrayList<Accomplishment>();
	ArrayList<Accomplishment> secrets = new ArrayList<Accomplishment>();
	
	ArrayList<Accomplishment> achievedEndings = new ArrayList<Accomplishment>();
	ArrayList<Accomplishment> achievedOptions = new ArrayList<Accomplishment>();
	ArrayList<String> achievedAligns = new ArrayList<String>();
	
	
	public AccomplishmentTracker(ArrayList<Accomplishment> accomps) {
		for(Accomplishment a : accomps) {
			if(a.type() == 1) endings.add(a);
			if(a.type() == 2) secrets.add(a);
		}
	}

	public void addAchievement(String id) {
		
		for(Accomplishment a : endings) {
			if(a.id() != id) {continue;}
			achievedEndings.add(a);
		}
		for(Accomplishment a : secrets) {
			if(a.id() != id) {continue;}
			achievedOptions.add(a);
		}
	
	}

	public void addAlignment(String a) {
		if(!achievedAligns.contains(a)) {
			achievedAligns.add(a);
		}
	}
	
	public void printAllObtainedAchievements() {
		System.out.println("Obtained Endings: ");
		System.out.print(achievedEndings + "\n");
		System.out.println("Secret Options Found: ");
		System.out.print(achievedOptions + "\n");
		System.out.println("Alignments Acted As:  ");
		System.out.print("[");
		for(String a : achievedAligns) {
			System.out.print(a + ", ");
		}
		System.out.print("]\n\n");
		
	}

	public void printPossibleAchievements() {
		System.out.println("Possible Endings: " + endings );
		System.out.println("Secret Options: " + secrets );
		System.out.print("Alignments: ");
		System.out.print("[");
		for(String a : Controller.alignmentsFull) {
			System.out.print(a + ", ");
		}
		System.out.print("]\n\n");
	}	
	
	public void printAllRatios() {
		printObtainedEndingsRatio();
		printObtainedSecretsRatio();
		printObtainedAlignsRatio();
	}
	
	void printObtainedEndingsRatio() {
		
		System.out.println("You have seen [" + achievedEndings.size() + "/" + endings.size() + "] total endings.");
		
		if (achievedEndings.size() == endings.size()) {
			System.out.println("This means you have seen every ending. Congratulations!");
		}
	}
	
	void printObtainedSecretsRatio() {
		
		System.out.println("You have chosen [" + achievedOptions.size() + "/" + secrets.size() + "] total secret options.");
		
		if (achievedOptions.size() == secrets.size()) {
			System.out.println("This means you have chosen every secret option. Well done!");
		}
	}
	
	void printObtainedAlignsRatio() {
		
		System.out.println("You have acted as [" + achievedAligns.size() + "/9] total alignments.");
		
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
