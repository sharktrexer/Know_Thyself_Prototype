package com.thyself;

import java.util.List;

public class Scenario {
	
	public String 		id;	     // Unique name for scenario for options to reference
	public String 		desc;    // What the scenario is about
	public List<Option> options; // What options the user can take from this scene
	
	// Empty Scenario
	public Scenario() {
		this.id           = "";          
		this.desc         = "";        
		this.options      = null;  
	}
	
	// Standard Scenario
	public Scenario(String id, String desc, List<Option> options) {
		this.id           = id;          
		this.desc         = desc;        
		this.options      = options;     
	}  
	
	
}
