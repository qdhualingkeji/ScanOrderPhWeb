package com.qdhualing.app.util;

import java.util.HashSet;
import java.util.Set;

public  class InputIdsReturnIdArray {

	public static Set<Integer> InputIds(String ids,String split){
		Set<Integer> setId = new HashSet<Integer> (5,0.5F);
		String idArray[] = ids.split(split);
		try{
			for (String id : idArray) {
				if(!setId.add((Integer)Integer.parseInt(id))){
					return null;
				}
			}
		}
		catch(NumberFormatException e){
			return null;
		}
		return setId;
		
	}
}
