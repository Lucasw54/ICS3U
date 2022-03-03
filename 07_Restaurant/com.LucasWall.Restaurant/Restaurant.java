/*
 * Name:Lucas Wall
 * Class code: ICS3U 
 * Date:Friday, February 15, 2022 
 * Assignment #: 7
 * Description: Using scanner, variables and decimal formatting create a restaurant menu and receipt.
 */
package com.LucasWall.Restaurant;

//Imports
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Restaurant
{//Beginning of Restaurant
	//Global Objects
	private static JLabel photo1;
	private static JLabel photo2;
	private static JLabel photo3;
	private static JLabel photo4;
	private static JLabel photo5;
	private static JLabel photo1Label;
	private static JLabel photo2Label;
	private static JLabel photo3Label;
	private static JLabel photo4Label;
	private static JLabel photo5Label;
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel IceCreamLabel;
	
	//Creating new colour for GUI
	public static final Color LIGHT_BLUE = new Color(142, 230, 219);


	public static void main (String[] args) 
	{//Beginning of main
	
	//--------------------------Create and Initialize
	
	//Customers name for the order
	String name = "";
		
	//Create variable for Moose Track's
	String Moose = "Moose Tracks";
	//Create variable for Mint Moose Track's
	String MintMoose = "Mint Moose Tracks";
	//Create variable for Chocolate Moose Tracks
	String ChocMoose = "Chocolate Moose Tracks";
	//Create variable for Caramel
	String Caramel = "Caramel";
	//Create variable for Campfire
	String Campfire = "Campfire";
	
	//# of each type of scoop
	int Moose_ammount = 0;
	int MintMoose_ammount = 0;
	int ChocMoose_ammount = 0;
	int Caramel_ammount = 0;
	int Campfire_ammount = 0;
	
	//Too MUCH!
	int Too_much = 0;
	
	//Price of each type of scoop
	double Moose_price = Math.random()+1;
	double MintMoose_price = Math.random()+2;
	double ChocMoose_price = Math.random()+2;
	double Caramel_price = Math.random()+1;
	double Campfire_price = Math.random()+2;
	
	//Constant variables, Tax 13% and Tip 15%
	final double HST_TAX  = 1.13;
	final double TIP = 1.15;
	
	//-------------Decimal Formatting
	DecimalFormat money = new DecimalFormat("$#,###.00");
	DecimalFormat number = new DecimalFormat("#,###");
	
	//--------------------------User Input
	//Name
	Scanner Uin_name = new Scanner(System.in);
	
	//yn of each
	Scanner Uin_Mooseyn = new Scanner(System.in);
	Scanner Uin_MintMooseyn = new Scanner(System.in);
	Scanner Uin_ChocMooseyn = new Scanner(System.in);
	Scanner Uin_Caramelyn = new Scanner(System.in);
	Scanner Uin_Campfireyn = new Scanner(System.in);
	
	//# of each
	Scanner Uin_Moose_ammount = new Scanner(System.in);
	Scanner Uin_MintMoose_ammount = new Scanner(System.in);
	Scanner Uin_ChocMoose_ammount = new Scanner(System.in);
	Scanner Uin_Caramel_ammount = new Scanner(System.in);
	Scanner Uin_Campfire_ammount = new Scanner(System.in);

	
	//--------------------------GUI
	//Setting up panel
	panel = new JPanel();
	panel.setBackground(LIGHT_BLUE);
	
	//Setting up frame
	frame = new JFrame();
	frame.setSize(400,850);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(panel);

	panel.setLayout(null);
	
	//Parlor name
	IceCreamLabel= new JLabel("Lucas's Pipe Dream Ice Cream: Flavours!");
	IceCreamLabel.setBounds(10, 20, 300, 25);
	panel.add(IceCreamLabel);
	
	//Flavor Labels
	photo1Label= new JLabel("Moose Tracks");
	photo1Label.setBounds(180, 127, 200, 25);
	panel.add(photo1Label);
	
	photo2Label= new JLabel("Mint Moose Tracks");
	photo2Label.setBounds(180, 282, 200, 25);
	panel.add(photo2Label);
	
	photo3Label= new JLabel("Chocolate Moose Tracks");
	photo3Label.setBounds(180, 437, 200, 25);
	panel.add(photo3Label);
	
	photo4Label= new JLabel("Caramel");
	photo4Label.setBounds(180, 592, 200, 25);
	panel.add(photo4Label);
	
	photo5Label= new JLabel("Campfire");
	photo5Label.setBounds(180, 747, 200, 25);
	panel.add(photo5Label);

	//Moose tracks photo
	ImageIcon image1 = new ImageIcon("Tracks.png");
	photo1 = new JLabel(image1);
	photo1.setBounds(10,50,150,150);
	panel.add(photo1);
	
	//Mint Moose Tracks photo
	ImageIcon image2 = new ImageIcon("MintTracks.png");
	photo2 = new JLabel(image2);
	photo2.setBounds(10,205,150,150);
	panel.add(photo2);
	
	//Chocolate Moose Tracks photo
	ImageIcon image3 = new ImageIcon("Chocolate.png");
	photo3 = new JLabel(image3);
	photo3.setBounds(10,360,150,150);
	panel.add(photo3);

	//Caramel photo
	ImageIcon image4 = new ImageIcon("Caramel.png");
	photo4 = new JLabel(image4);
	photo4.setBounds(10,515,150,150);
	panel.add(photo4);
	
	//Campfire photo
	ImageIcon image5 = new ImageIcon("Campfire.png");
	photo5 = new JLabel(image5);
	photo5.setBounds(10,670,150,150);
	panel.add(photo5);

	frame.setVisible(true);
	frame.setTitle("Flavour Display");
	
	//--------------------------Outputting
	//Intro
	System.out.print("Welcome! to Lucas's Pipe Dream Ice Cream");
	System.out.print("\n-------------------------------------------------------\n\n");
	System.out.println("What is the name for the order?");
	name = Uin_name.nextLine();
	System.out.print("Thanks!\n\n");
	
	//Ordering
	System.out.print("Today's flavours are:   ($ per scoop) " + "\n");
	System.out.print("-------------------------------------------------------" + "\n");
	System.out.print(Moose + ":" + " \t\t " + money.format(Moose_price) + " " + "each" + "\n");
	System.out.print(MintMoose + ":" + "       " + money.format(MintMoose_price) + " " + "each" + "\n");
	System.out.print(ChocMoose + ":" + "  " + money.format(ChocMoose_price) + " " + "each" + "\n");
	System.out.print(Caramel + ":" + "  \t\t " + money.format(Caramel_price) + " " + "each" + "\n");
	System.out.print(Campfire + ":" + "  \t\t " + money.format(Campfire_price) + " " + "each" + "\n");
	System.out.print("-------------------------------------------------------\n");
	
	//Checkout + User input
	System.out.print("\n" + "Which flavours would you like on your cone?\n");
	System.out.print("(Maximum of 3 scoops of each!)\n");
	
	//MooseTracks input
	System.out.print(Moose + "?" + " " + "(Yes/No)" + "\n");
	String Mooseyn= Uin_Mooseyn.nextLine();
	if (Mooseyn. equals("Yes")) 
	{
		System.out.print("How many scoops's would you like?" + " (#)");
		Moose_ammount = Uin_Moose_ammount.nextInt();
		System.out.print("\n");
	}
	
	//Mint MooseTracks input
	System.out.print(MintMoose + "?" + " " + "(Yes/No)" + "\n");
	String MintMooseyn= Uin_MintMooseyn.nextLine();
	if (MintMooseyn. equals("Yes")) 
	{
		System.out.print("How many scoops's would you like?" + " (#)");
		MintMoose_ammount = Uin_MintMoose_ammount.nextInt();
		System.out.print("\n");
	}
	
	//Chocolate input
	System.out.print(ChocMoose + "?" + " " + "(Yes/No)" + "\n");
	String ChocMooseyn= Uin_ChocMooseyn.nextLine();
	if (ChocMooseyn. equals("Yes")) 
	{
		System.out.print("How many scoops's would you like?" + " (#)");
		ChocMoose_ammount = Uin_ChocMoose_ammount.nextInt();
		System.out.print("\n");
	}
	
	//Caramel input
	System.out.print(Caramel + "?" + " " + "(Yes/No)" + "\n");
	String Caramelyn= Uin_Caramelyn.nextLine();
	if (Caramelyn. equals("Yes"))
	{
		System.out.print("How many scoops's would you like?" + " (#)");
		Caramel_ammount = Uin_Caramel_ammount.nextInt();
		System.out.print("\n");
	}
	
	//Campfire input
	System.out.print(Campfire + "?" + " " + "(Yes/No)" + "\n");
	String Campfireyn= Uin_Campfireyn.nextLine();
	if (Campfireyn. equals("Yes"))
	{
		System.out.print("How many scoops's would you like?" + " (#)");
		Campfire_ammount = Uin_Campfire_ammount.nextInt();
		System.out.print("\n");
	}
	
	if (Moose_ammount > 3)
	{
		Moose_ammount = 0;
		Too_much = 1;
	}
	
	if (MintMoose_ammount > 3)
	{
		MintMoose_ammount = 0;
		Too_much = 1;
	}
	
	if (ChocMoose_ammount > 3)
	{
		ChocMoose_ammount = 0;
		Too_much = 1;
	}
	
	if (Caramel_ammount > 3)
	{
		Caramel_ammount = 0;
		Too_much = 1;
	}
	
	if (Campfire_ammount > 3)
	{
		Campfire_ammount = 0;
		Too_much = 1;
	}
	
	//-------------------------Calculations
	double Moosesub = Moose_ammount*Moose_price;
	double MintMoosesub = MintMoose_ammount*MintMoose_price;
	double ChocMoosesub = ChocMoose_ammount*ChocMoose_price;
	double Caramelsub = Caramel_ammount*Caramel_price;
	double Campfiresub = Campfire_ammount*Campfire_price;
	double SubSubtotal = Moosesub+MintMoosesub+ChocMoosesub+Caramelsub+Campfiresub;
	double Subtotal = SubSubtotal*TIP;
	double Total = Subtotal*HST_TAX;
	double Tax_total = Total-Subtotal;
	double Tip_total = Subtotal-SubSubtotal;
	
	//--------------------------Outputting
	//Receipt
	System.out.println(" ----------Receipt-------------------------------------------------------------");
	System.out.println("|\t\t\t   Lucas's Pipe Dream Ice Cream" +"\t\t\t       |");
	System.out.print("|\t\t\t\t Peterborough, ON\t\t\t       |\n");
	System.out.print("|\t\t\t\t   705-555-3722\t\t\t               |\n");
	System.out.print("|\t\t\t     *** Ice Cold Ice Cream*** \t\t\t       |\n");
	System.out.print("|   ________________________________________________________________________   |\n");
	System.out.print("|\t\t\t\t\t\t\t\t\t       |\n");
	System.out.print("|\t\t\t    Here is your order: " + name + "\t\t\t       |" + "\n");
	System.out.print("|Items:\t\t\t\t\t\t\t\t\t       |\n");
	
	//If too much of a flavour
	if (Too_much > 0)
	{
		System.out.print("|Too much of a flavour re-run code to order again. \t\t\t       |" + "\n");
	}
	
	//If none of the flavaour
	if (Moose_ammount > 0) 
	{
		System.out.print("|" + money.format(Moosesub) + "\t" + number.format(Moose_ammount) + " " + Moose + "\t\t\t\t\t\t\t       |" + "\n");
	}
	if (MintMoose_ammount > 0) 
	{
		System.out.print("|" + money.format(MintMoose_price) + "\t" + number.format(MintMoose_ammount) + " " + MintMoose + "\t\t\t\t\t\t       |" + "\n");
	}
	if (ChocMoose_ammount > 0) 
	{
		System.out.print("|" + money.format(ChocMoose_price) + "\t" + number.format(ChocMoose_ammount) + " " + ChocMoose + "\t\t\t\t\t       |" + "\n");
	}
	if (Caramel_ammount > 0) 
	{
		System.out.print("|" + money.format(Caramel_price) + "\t" + number.format(Caramel_ammount) + " " + Caramel + "\t\t\t\t\t\t\t       |" + "\n");
	}
	if (Campfire_ammount > 0)
	{
		System.out.print("|" + money.format(Campfire_price) + "\t" + number.format(Campfire_ammount) + " " + Campfire + "\t\t\t\t\t\t\t       |" + "\n");
	}
	
	
	System.out.print("|\t\t\t\t\t\t\t\t\t       |\n");
	System.out.print("|" + "Your subtotal is: " + money.format(SubSubtotal) + " " + "\t\t\t\t\t\t       |" + "\n");
	System.out.print("|" + "+HST:" + " " + money.format(Tax_total) + "\t\t\t\t\t\t\t\t       |" + "\n");
	System.out.print("|" + "+Tip (15%):" + " " + money.format(Tip_total) + "\t\t\t\t\t\t\t       |" + "\n");
	System.out.print("|" + "Your total price is:" + " " + money.format(Total) + "\t\t\t\t\t\t       |" + "\n");
	System.out.print("|\t\t\t\t\t\t\t\t\t       |\n");
	System.out.print("|\t     Thank you for shopping at Lucas's Pipe Dream Ice Cream" +"\t       |\n");
	System.out.print("|\t\t\t\t\t\t\t\t\t       |\n");
	System.out.println(" ------------------------------------------------------------------------------");
	}//End of main
}//End of Restaurant
