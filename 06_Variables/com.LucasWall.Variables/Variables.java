/*
 * Name:Lucas Wall
 * Class code: ICS3U 
 * Date:Friday, February 9, 2022 
 * Assignment #: 6
 * Description: Variables introduction
 */
package com.LucasWall.Variables;

public class Variables
{//Beginning of Variables
	
	public static void main(String[] args)
	{//Beginning of main
		
		String first_name = "Larry";
		String last_name = "Page";
		int your_age = 25;
		String month = "February";
		int day = 23;
		int year = 1998;
		int job = -1;
		char no = 'N'; 
		String restaurant_name = "The Keg";
		Double money = 63.84;
		char money_symbol = '$';
		
		System.out.println("My name is" + " " + first_name + " " + last_name + ".");
		System.out.println("I am" + " " + your_age + " " + "years of age.");
		System.out.println("I was born in" + " " + month + " " + "on the" + " " + day + "rd" + " " + "day" + " " + "in the year" + " " + year + ".");
		if(job < 0) {
			System.out.println(no + "o" + "," + " " + "I do not have a part time job.");	
		}
		
		else {
			System.out.println("Congrats you finally got a part time job!");
		}
		
		System.out.println("My last meal that I ate was at the restaurant" + " " + restaurant_name + "." + "\n" + "This meal cost me " + money);
	}//end of main

}//end of Variables
