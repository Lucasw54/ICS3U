package com.LucasWall.ForLoops;

import java.text.DecimalFormat;

public class ForLoops {

	public static DecimalFormat money = new DecimalFormat("$###,###,###.##");

	public static void main(String[] args) {
		double i = 1;
		double b = 0.01;
		double c = 0;
		
		for (int a = 1; a <= 31; a+=1){	
			i = i*2;
			c = b*i;
			System.out.println("Money on Day " + a + ":	" + money.format(c));
		}
	
	}
}
