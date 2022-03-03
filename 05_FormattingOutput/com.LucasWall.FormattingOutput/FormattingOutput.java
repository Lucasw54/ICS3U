/*
 * Name:Lucas Wall
 * Class code: ICS3U 
 * Date:Friday, February 8, 2022 
 * Assignment #: 5
 * Description: This assignment is making use of a few key elements of Java. 
 * Print, Println, \n, \t, Concatenating and Commenting to ensure tidy code.
 */
package com.LucasWall.FormattingOutput;

public class FormattingOutput
{//Beginning of FormattingOutput
	
	public static void main(String[] args)
		{//Beginning of main
		
		String M = "Macbeth";
		String LM = "Lady Macbeth";	
		
		//Print the name of the play
		System.out.println(M + "\tAct 2, Scene 2, Page 4     |" + "\t Written by William Shakespear" + "\n" +  "-------------------------------------------------------------------------");
		//Print Macbeth
		System.out.print(M + ":" + "\n" + "Whence is that knocking?" + "\n" + "How is ’t with me when every noise appals me?");
		//Print Macbeth
		System.out.println("\n" +  "What hands are here? Ha! They pluck out mine eyes.");
		//Print Macbeth
		System.out.print("Will all great Neptune’s ocean wash this blood" + "\n" + "Clean from my hand? No, this my hand will rather" + "\n" + "The multitudinous seas incarnadine," + "\n" + "Making the green one red.");
		//Print Lady Macbeth
		System.out.println("\n\n" + LM + " enters." + "\n" + LM + ":" + "\n" + "My hands are of your color, but I shame" + "\n" + "To wear a heart so white." + "\n\n" + "Knock within" + "\n\n" + "I hear a knocking" + "\n" + "At the south entry. Retire we to our chamber." + "\n" + "A little water clears us of this deed." + "\n" + "How easy is it, then! Your constancy" + "\n" + "Hath left you unattended." + "\n\n" + "Knock within" + "\n\n" + "Hark! More knocking." + "\n" + "Get on your nightgown, lest occasion call us" + "And show us to be watchers. Be not lost" + "\n" + "So poorly in your thoughts." + "\n");
		//Print Macbeth
		System.out.print(M + ":" + "\n" + "To know my deed, ’twere best not know myself." + "\n\n" + "Knock within" + "\n\n" + "Wake Duncan with thy knocking. I would thou couldst." + "\n\n" + "Exeunt");

	}//End of main
	
}//End of FormattingOutput
