package com.crud.restapi.utils;

import java.util.UUID;

public class Utility {
	static int max = 1;
	public static int generateID() {
//		UUID uniqueid = UUID.randomUUID();		
//	    return uniqueid.toString();
		return max++;		
	}

}
