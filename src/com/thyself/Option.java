package com.thyself;

import java.util.List;

public class Option {
	
	public String 		desc;		  // What the option is
	public String 		pointsToID;   // What scenario, by id, the option will take the player to
	public List<String> tags;		  // What tags the user receives upon choosing this option, if applicable
	public String 		alignment;    // What alignment this option increases, if applicable
	public List<String> tagsRequired; // What tags this options requires the user to have
	public String 		resultDesc;   // What directly results from the option after picking it
	
	// Empty option
	public Option() {
		this.desc 		  = "";
		this.tags 		  =	null;
		this.alignment 	  =	"";
		this.tagsRequired = null;
		this.resultDesc   = "";
	}
	
	// For a parent option that only leads into child options. Has no tags, alignment, condition, or resulting text
	public Option(String desc, String pointsToID) {
		this.desc 		  =	desc;
		this.pointsToID   = pointsToID;
		this.tags 		  = null;
		this.alignment    = "";
		this.tagsRequired = null;
		this.resultDesc   = "";
	}
	
	// For a conditional child option. Only appears if user has appropriate tags
	public Option(String desc, String pointsToID, List<String> tags, String alignment, List<String> tagsRequired, String resultDesc) {
		this.desc 		  = desc;
		this.pointsToID   = pointsToID;
		this.tags 		  = tags;
		this.alignment 	  = alignment;
		this.tagsRequired = tagsRequired;
		this.resultDesc   = resultDesc;
	}
	
	
	// For an unconditional child option. Will always be visible.
	public Option(String desc, String pointsToID, List<String> tags, String alignment, String resultDesc) {
		this.desc 		  = desc;
		this.pointsToID   = pointsToID;
		this.tags 		  = tags;
		this.alignment 	  = alignment;
		this.tagsRequired = null;
		this.resultDesc   = resultDesc;
	}
	
	// For a transitional option. It won't be displayed to the user. Params are flipped since tagsRequired is the most important aspect
	public Option(List<String> tagsRequired, String pointsToID) {
		this.desc 		  = "";
		this.pointsToID   = pointsToID;
		this.tags 		  = null;
		this.alignment    = "";
		this.tagsRequired = tagsRequired;
		this.resultDesc   = "";
	}
}
