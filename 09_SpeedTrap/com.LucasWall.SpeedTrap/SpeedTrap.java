/*
 * Name:Lucas Wall
 * Class code: ICS3U 
 * Date:Friday, March 2, 2022 
 * Assignment #: 9
 * Description: 
 */
package com.LucasWall.SpeedTrap;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class SpeedTrap {

	private static JPanel panel;
	private static JFrame frame;
	private static JLabel CardsForceLabel;
	private static JSeparator Sep1;
	private static JLabel SchooAreaLabel;
	private static JLabel NameofDriveLabel;
	private static JLabel DriverLicenceLabel;
	private static JLabel VehicleSpeedLabel;
	private static JLabel OffenseLabel;
	private static JLabel PenLevelLabel;
	private static JLabel FineLabel;
	private static JLabel DemeritLabel;
	private static JLabel DriveSafely;
	
	private static String Name = "";
	private static String DriversLicense = "";
	private static double VehicleSpeed = 0;
	private static String PenaltyLevel = "";
	private static double fine = 0;
	private static double Demerits = 0;
	
	
	public static final Color VERY_LIGHT_RED = new Color(255,102,102);
	public static final Color DARK_GREY = new Color(102,102,102);
	public static final Color BLACK = new Color(0,0,0);
	public static final Color LIGHT_BLUE = new Color(227, 255, 253);
	
	DecimalFormat money = new DecimalFormat("$#,###.00");
	static DecimalFormat speed = new DecimalFormat("#,### Km/h");
	DecimalFormat license = new DecimalFormat("#####-#####-#####");

	
	public static void main(String[] args) {
		
		Scanner Uin_name = new Scanner(System.in);
		Scanner Uin_license = new Scanner(System.in);
		Scanner Uin_speed = new Scanner(System.in);
		
		
		//------------OutPutting
		System.out.println("What is the Offendee's name?");
		Name = Uin_name.nextLine();
		System.out.println("\nWhat is the Offendee's Licence Plate?");
		DriversLicense = Uin_license.nextLine();
		System.out.println("\nWhat was the speed that the vehicle was travelling in the school zone?");
		VehicleSpeed = Uin_speed.nextInt();
		
		switch(PenaltyLevel) {
		
			case "Warning":
			{
				shirt_price = 9.99;
				break;
			}
			
			case "Minimum":
			{
				shirt_price = 14.99;
				break;
			}
		
			case "Maximum":
			{
				shirt_price = 19.99;
				break;
			}
			case "Severe":
			{
				shirt_price = 19.99;
				break;
			}
			case "NoPenalty":
			{
				shirt_price = 19.99;
				break;
			}
	}
		GUI();
		
	}//End of main
	
	public static void GUI() {
		panel = new JPanel();
		
		panel.setBackground(LIGHT_BLUE);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(600, 400);	
		frame.setLocationRelativeTo(null);
		frame.setBackground(DARK_GREY);
		
		CardsForceLabel = new JLabel("Cards Police Force");
		CardsForceLabel.setBounds(0,10,600,20);
		panel.add(CardsForceLabel);
		CardsForceLabel.setHorizontalAlignment(JLabel.CENTER);
		
		Sep1 = new JSeparator();
		Sep1.setBounds(70,30,460,10);
		Sep1.setForeground(BLACK);
		panel.add(Sep1);
		
		SchooAreaLabel = new JLabel("Violation of Speed Limit in a School Zone");
		SchooAreaLabel.setBounds(30,50,280,20);
		panel.add(SchooAreaLabel);
		
		NameofDriveLabel = new JLabel("Name of Driver: " +Name);
		NameofDriveLabel.setBounds(40,90,400,20);
		panel.add(NameofDriveLabel);
		
		DriverLicenceLabel = new JLabel("Driver’s License: " +DriversLicense);
		DriverLicenceLabel.setBounds(40,110,400,20);
		panel.add(DriverLicenceLabel);
		
		VehicleSpeedLabel = new JLabel("Vehicle’s Speed: " +speed.format(VehicleSpeed));
		VehicleSpeedLabel.setBounds(40,130,200,20);
		panel.add(VehicleSpeedLabel);
		
		OffenseLabel = new JLabel("Offense:");
		OffenseLabel.setBounds(40,170,200,20);
		panel.add(OffenseLabel);
		
		PenLevelLabel = new JLabel("HMM:" + " Penalty level");
		PenLevelLabel.setBounds(40,210,200,20);
		panel.add(PenLevelLabel);
		
		FineLabel = new JLabel("Fine:");
		FineLabel.setBounds(40,230,200,20);
		panel.add(FineLabel);
		
		DemeritLabel = new JLabel("Points Taken:");
		DemeritLabel.setBounds(40,250,1,20);
		panel.add(DemeritLabel);
		
		DriveSafely = new JLabel("Please drive carefully and obey speed limits in school zones.");
		DriveSafely.setBounds(0,340,600,20);
		panel.add(DriveSafely);
		DriveSafely.setHorizontalAlignment(JLabel.CENTER);

		frame.setVisible(true);
		frame.setTitle("Test GUI");
	}
}
