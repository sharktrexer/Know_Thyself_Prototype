package com.thyself;

//achieveType = 1 means it is an ending, 2 means it is an option, 3 means alignment
public record Accomplishment(String id, String title, int type) {
	
	public Accomplishment {
        if (type <= 0 || type >= 4) {
            throw new java.lang.IllegalArgumentException(
                String.format("Invalid type: %d", type));
        }
    }
	
}
