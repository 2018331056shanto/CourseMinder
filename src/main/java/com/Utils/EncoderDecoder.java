package com.Utils;

import org.mindrot.jbcrypt.BCrypt;

public class EncoderDecoder {
	
	public String stringEncoder(String string) {
		
		String hashString=BCrypt.hashpw(string, BCrypt.gensalt());
		return hashString;
	}
	
	public boolean stringDecoder(String string,String hashString)
	{
		
		boolean stringMatch=BCrypt.checkpw(string, hashString);
		return stringMatch;
	}

}
