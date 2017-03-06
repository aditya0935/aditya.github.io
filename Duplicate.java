package com.util;

import java.util.ArrayList;



public class Duplicate {

	
	
	
	
	
	public void Maximum (String text)
	{
		String ptext=text;
		String[] array ;
		String[] array1  ;
		
	
		
		 array=ptext.split("\\.");
	
		
		
		
		
		
		
		for(int i=0;i<array.length-1;i++)
			 
		 {
			array1[i]=array[i].split("\\s+ ");
			
		 }
		
		
		int max = 0;

		for (int i = 1; i < array1.length; i++) 
		
		{
		    if (array1[i].length() > max)
		    {
		      max = array1[i].length();
		    }
		
		
		
		System.out.print("Maximum :-"max);
		}
		
	public static void main (String args[])
	{
		Duplicate d=new Duplicate();
		
		
		d.Maximum("hiii hello good morning.I am fine Now .will you be there");
		
		
	}
	
	
}
