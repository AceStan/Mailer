package com.util;

public class GetProviderUtil {

	public String getProvider(String email){
		
		int atIndex =  email.indexOf('@');
		String fromAtToEnd = email.substring(atIndex,email.length()-1);
		int dotIndex =  fromAtToEnd.indexOf('.');
		String provider =  fromAtToEnd.substring(1,dotIndex);
		return provider;
		
	}
}
