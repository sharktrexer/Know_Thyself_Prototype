package com.thyself;

import java.util.Objects;

//achieveType = 1 means it is an ending, 2 means it is an option
public record Accomplishment(String id, String title, int type) {
	
	public Accomplishment {
        if (type <= 0 || type >= 3) {
            throw new java.lang.IllegalArgumentException(
                String.format("Invalid Accomplishment type: %d", type));
        }
    }
	
	@Override
	public String toString() {
		return title;
	}
	
}
