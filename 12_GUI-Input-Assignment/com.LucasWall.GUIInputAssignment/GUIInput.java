package com.LucasWall.GUIInputAssignment;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class GUIInput implements ActionListener {
	
	//------Gui Globals
	private static JPanel pnl_panel;
	private static JFrame fr_frame;
	
	//lbl
	private static JLabel lbl_TitleLabel;
	private static JLabel lbl_Slogan;
	private static JLabel lbl_YrName;
	private static JLabel lbl_NumOrdered;
	private static JLabel lbl_ThisIsAPushButtonLabel;
	private static JLabel lbl_GeneralInfo;
	private static JLabel lbl_PhotoCorrectionOptions;
	private static JLabel lbl_YouOrderedA1;
	private static JLabel lbl_NumPrints;
	private static JLabel lbl_Dimensions;
	private static JLabel lbl_ProvinceCountry;
	private static JLabel lbl_RedEye;
	private static JLabel lbl_OverExposure;
	private static JLabel lbl_ColourCorrection;
	private static JLabel lbl_BlemishRetouching;
	private static JLabel lbl_ThankYou;
	//txt
	private static JTextField txt_Name;
	private static JTextField txt_NumPrints;
	private static JTextField txt_Address;
	
	//img
	private static JLabel img_LadyBug;
	private static JLabel img_Flag;
	
	//sep
	private static JSeparator sep_Title;
	private static JSeparator sep_Horizontal;
	private static JSeparator sep_GeneralInfo;
	private static JSeparator sep_PhotoCorrection;
	
	//rad
	private static JRadioButton rad_Pickup;
	private static JRadioButton rad_Deliver;
	
	//cbo
	private static JComboBox<String> cbo_SelectSizeComboBox;
	private static JComboBox<String> cbo_ChooseCity;
	private static JComboBox<String> cbo_ChooseProvince;
	
	//chk_
	private static JCheckBox checkBox1;
	private static JCheckBox checkBox2;
	private static JCheckBox checkBox3;
	private static JCheckBox checkBox4;
	private static JCheckBox checkBox5;
	private static JCheckBox checkBox6;
	private static JCheckBox checkBox7;
	private static JCheckBox checkBox8;
	
	//btn
	private static JButton TurnOffButton;
	private static JButton ExitButton;
	private static JButton OrderAgain;
	private static JButton btn_Reset;
	
	//--------Other Globals
	private static double a = 0;
	private static double b = 0;
	private static double c = 0;
	private static Boolean Check = true;
	private static ButtonGroup bg;
	private static String ReceiptName = "";
	private static Boolean Red_Eye = false;
	private static Boolean Over_Exposure = false;
	private static Boolean Colour_Correction = false;
	private static Boolean Blemish_Re_Touching = false;
	private static Boolean People_Remover = false;
	private static Boolean Skin_Care = false;
	private static Boolean Sharpen_Image = false;
	private static Boolean Add_Blur = false;
	
	//------New Colours
	public static final Color NEW_BLUE = new Color(147, 196, 180);
	public static final Color DARK_GREY = new Color(102,102,102);
	public static final Color WRONG_RED = new Color(251, 255, 250);
	
	//------Decimal Formats
	public static DecimalFormat number = new DecimalFormat("###,###,###");
	
	//------Borders
	public static Border FrameBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	public static Border ButtonBorder = BorderFactory.createCompoundBorder();
	//List of all actions
	public enum Actions
	{//Beginning of Actions
		RADIOPICKUP,
		RADIODELIVER,
		REDEYE,
		OVER_EXPOSURE,
		COLOUR_CORRECTION,
		BLEMISH_RE_TOUCHING,
		PEOPLE_REMOVER,
		SKIN_CARE,
		SHARPEN_IMAGE,
		ADD_BLUR,
		ORDER1,
		ORDERAGAIN,
		RESET,
		EXIT
	}//End of Actions
	
	public static void CheckComboBox()
	{
		while(Check = true) 
		{//Beginning of while
			try
			{//Beginning of try
				//Make invisble while loading
				Thread.sleep(25);
			}

			catch (InterruptedException e) 
			{//Beginning of catch
				e.printStackTrace();
			}//End of catch
		}
	}
	public static void GUI() {
		GUIInput instance = new GUIInput();
		String[] optionsToChoose = { "Choose Dimensions", "4x6", "6x8", "8x10", "12x17"};
		String[] optionsToChoose2 = { "Choose City", "Barrie", "Belleville", "Cambridge", "Guelph", "Hamilton", "Kingston", "Kitchener",
				"London", "Markham", "Orillia", "Oshawa", "Ottawa", "Peterborough", "Pickering", "Richmond Hill",
				"Thunder Bay", "Timmins", "Toronto", "Vaughan", "Waterloo", "Welland", "Windsor" };
		
		//Panel Config
		pnl_panel = new JPanel();
		pnl_panel.setBackground(NEW_BLUE);
		pnl_panel.setLayout(null);
		pnl_panel.setBorder(FrameBorder);
		
		//Frame Config
		fr_frame = new JFrame();
		fr_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr_frame.add(pnl_panel);
		fr_frame.setSize(1152, 720);
		//frame.setLocationRelativeTo(null);
		fr_frame.setBackground(DARK_GREY);	
		
		//Images
		BufferedImage img1 = null;
		BufferedImage img2 = null;
		try {
			img1 = ImageIO.read(new File("LB.png"));
			img2 = ImageIO.read(new File("Flag.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image dimg = img1.getScaledInstance(60, 45, 100);
		Image eimg = img2.getScaledInstance(80, 45, 100);
		
		//Creating image icons
		ImageIcon icn_LadyBug = new ImageIcon(dimg);
		ImageIcon icn_Flag = new ImageIcon(eimg);
		
		img_LadyBug = new JLabel(icn_LadyBug);
		img_LadyBug.setBounds(750,20,60,45);
		pnl_panel.add(img_LadyBug);
		
		img_Flag = new JLabel(icn_Flag);
		img_Flag.setBounds(850,20,80,45);
		pnl_panel.add(img_Flag);
		
		//Labels
		lbl_TitleLabel = new JLabel("Shutter Bugs");
		lbl_TitleLabel.setBounds(0,5,1152,70);
		pnl_panel.add(lbl_TitleLabel);
		lbl_TitleLabel.setHorizontalAlignment(JLabel.CENTER);
		lbl_TitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
		
		lbl_Slogan = new JLabel("You Pic it we Print it");
		lbl_Slogan.setBounds(0, 60, 1152, 20);
		pnl_panel.add(lbl_Slogan);
		lbl_Slogan.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lbl_Slogan.setHorizontalAlignment(JLabel.CENTER);
		
		lbl_YrName = new JLabel("What is your name?");
		lbl_YrName.setBounds(50, 150, 250, 25);
		pnl_panel.add(lbl_YrName);
		lbl_YrName.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		lbl_NumPrints = new JLabel("How many prints would you like?");
		lbl_NumPrints.setBounds(50, 210, 400, 25);
		pnl_panel.add(lbl_NumPrints);
		lbl_NumPrints.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		lbl_NumOrdered = new JLabel("");
		lbl_NumOrdered.setBounds(350, 290, 200, 25);
		pnl_panel.add(lbl_NumOrdered);
		lbl_NumOrdered.setVisible(false);
		lbl_NumOrdered.setForeground(WRONG_RED);
		lbl_NumOrdered.setFont(new Font("Serif", Font.BOLD, 18));
		
		lbl_Dimensions = new JLabel("Choose dimensions for this order: ");
		lbl_Dimensions.setBounds(50, 270, 340, 25);
		pnl_panel.add(lbl_Dimensions);
		lbl_Dimensions.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		lbl_ProvinceCountry = new JLabel("Ontario, Canada");
		lbl_ProvinceCountry.setBounds(250, 380, 180, 20);
		pnl_panel.add(lbl_ProvinceCountry);
		lbl_ProvinceCountry.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lbl_ProvinceCountry.setVisible(false);
		
		lbl_GeneralInfo = new JLabel("General Information");
		lbl_GeneralInfo.setBounds(0,105,576,30);
		pnl_panel.add(lbl_GeneralInfo);
		lbl_GeneralInfo.setFont(new Font("Serif", Font.BOLD, 24));
		lbl_GeneralInfo.setHorizontalAlignment(JLabel.CENTER);
		
		lbl_PhotoCorrectionOptions = new JLabel("Photo Correction Options ");
		lbl_PhotoCorrectionOptions.setBounds(576,105,576,30);
		pnl_panel.add(lbl_PhotoCorrectionOptions);
		lbl_PhotoCorrectionOptions.setFont(new Font("Serif", Font.BOLD, 24));
		lbl_PhotoCorrectionOptions.setHorizontalAlignment(JLabel.CENTER);
		
		lbl_ThankYou = new JLabel("Thank You For Your Order!");
		lbl_ThankYou.setBounds(0, 300, 1152, 20);
		pnl_panel.add(lbl_ThankYou);
		lbl_ThankYou.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		lbl_ThankYou.setHorizontalAlignment(JLabel.CENTER);
		lbl_ThankYou.setVisible(false);
		
		//Separators
		sep_Title = new JSeparator();
		sep_Title.setBounds(0, 80, 1200, 25);
		pnl_panel.add(sep_Title);
		sep_Title.setForeground(DARK_GREY);
		
		sep_Horizontal = new JSeparator();
		sep_Horizontal.setBounds(600, 100, 57, 300);
		pnl_panel.add(sep_Horizontal);
		sep_Horizontal.setForeground(DARK_GREY);
		sep_Horizontal.setOrientation(1);
		
		sep_GeneralInfo = new JSeparator();
		sep_GeneralInfo.setBounds(109, 130, 350, 25);
		pnl_panel.add(sep_GeneralInfo);
		sep_GeneralInfo.setForeground(DARK_GREY);
		
		sep_PhotoCorrection = new JSeparator();
		sep_PhotoCorrection.setBounds(685, 130, 350, 25);
		pnl_panel.add(sep_PhotoCorrection);
		sep_PhotoCorrection.setForeground(DARK_GREY);
		
		//Radio Buttons
		rad_Pickup = new JRadioButton("Pick-up in store");    
		rad_Pickup.setBounds(50,320,140,30);  
		rad_Pickup.setActionCommand(Actions.RADIOPICKUP.name());
		rad_Pickup.addActionListener(instance);
		pnl_panel.add(rad_Pickup);
		
		rad_Deliver = new JRadioButton("Ship to:");      
		rad_Deliver.setBounds(200,320,100,30);  
		rad_Deliver.setActionCommand(Actions.RADIODELIVER.name());
		rad_Deliver.addActionListener(instance);
		pnl_panel.add(rad_Deliver);
		
		bg = new ButtonGroup();    
		bg.add(rad_Pickup);
		bg.add(rad_Deliver);
		
		//Text Fields
		txt_Name = new JTextField(20);
		txt_Name.setBounds(280,150,150,30);
		pnl_panel.add(txt_Name);
		
		txt_NumPrints = new JTextField(20);
		txt_NumPrints.setBounds(400,210,100,30);
		pnl_panel.add(txt_NumPrints);
		
		txt_Address = new JTextField(20);
		txt_Address.setBounds(300,320,300,30);
		pnl_panel.add(txt_Address);
		txt_Address.setVisible(false);
		
		//Combo Boxes
		cbo_SelectSizeComboBox = new JComboBox<>(optionsToChoose);
		cbo_SelectSizeComboBox.setBounds(380, 275, 180, 20);
		pnl_panel.add(cbo_SelectSizeComboBox);
		
		cbo_ChooseCity = new JComboBox<>(optionsToChoose2);
		cbo_ChooseCity.setBounds(50, 380, 180, 20);
		pnl_panel.add(cbo_ChooseCity);
		cbo_ChooseCity.setVisible(false);
		
		//Check Boxes
		checkBox1 = new JCheckBox("Red Eye");  
        checkBox1.setBounds(650,140, 200,50); 
        checkBox1.setActionCommand(Actions.REDEYE.name());
        checkBox1.addActionListener(instance);
        pnl_panel.add(checkBox1); 
        
        checkBox2 = new JCheckBox("Over Exposure");  
        checkBox2.setBounds(650,190, 200,50);  
        checkBox2.setActionCommand(Actions.OVER_EXPOSURE.name());
        checkBox2.addActionListener(instance);
        pnl_panel.add(checkBox2); 
        
        checkBox3 = new JCheckBox("Colour Correction");  
        checkBox3.setBounds(650,240, 200,50);  
        checkBox3.setActionCommand(Actions.COLOUR_CORRECTION.name());
        checkBox3.addActionListener(instance);
        pnl_panel.add(checkBox3);  
        
        checkBox4 = new JCheckBox("Blemish Re-Touching");  
        checkBox4.setBounds(650,290, 200,50);  
        checkBox4.setActionCommand(Actions.BLEMISH_RE_TOUCHING.name());
        checkBox4.addActionListener(instance);
        pnl_panel.add(checkBox4);  
        
        checkBox5 = new JCheckBox("People Remover");  
        checkBox5.setBounds(900,140, 200,50);  
        checkBox5.setActionCommand(Actions.PEOPLE_REMOVER.name());
        checkBox5.addActionListener(instance);
        pnl_panel.add(checkBox5); 
        
        checkBox6 = new JCheckBox("Skin Care");  
        checkBox6.setBounds(900,190, 200,50);  
        checkBox6.setActionCommand(Actions.SKIN_CARE.name());
        checkBox6.addActionListener(instance);
        pnl_panel.add(checkBox6); 
        
        checkBox7 = new JCheckBox("Sharpen Image");  
        checkBox7.setBounds(900,240, 200,50);   
        checkBox7.setActionCommand(Actions.SHARPEN_IMAGE.name());
        checkBox7.addActionListener(instance);
        pnl_panel.add(checkBox7);  
        
        checkBox8 = new JCheckBox("Add Blur");  
        checkBox8.setBounds(900,290, 250,50);  
        checkBox8.setActionCommand(Actions.ADD_BLUR.name());
        checkBox8.addActionListener(instance);
        pnl_panel.add(checkBox8);
        
		//Buttons
		TurnOffButton = new JButton("Place Order");
		TurnOffButton.setBounds(176, 550, 800, 75);
		TurnOffButton.setActionCommand(Actions.ORDER1.name());
		TurnOffButton.addActionListener(instance);
		pnl_panel.add(TurnOffButton);
		
		OrderAgain = new JButton("Order Again");
		OrderAgain.setBounds(476, 350, 200, 25);
		OrderAgain.setActionCommand(Actions.ORDERAGAIN.name());
		OrderAgain.addActionListener(instance);
		pnl_panel.add(OrderAgain);
		OrderAgain.setVisible(false);
		
		btn_Reset = new JButton("Reset");
		btn_Reset.setBounds(100, 25, 80, 25);
		btn_Reset.setActionCommand(Actions.RESET.name());
		btn_Reset.addActionListener(instance);
		pnl_panel.add(btn_Reset);
		
		ExitButton = new JButton("Exit");
		ExitButton.setBounds(20, 25, 80, 25);
		ExitButton.setActionCommand(Actions.EXIT.name());
		ExitButton.addActionListener(instance);
		pnl_panel.add(ExitButton);
		
		//Frame config
		fr_frame.setResizable(false);
		fr_frame.setVisible(true);
		fr_frame.setTitle("Working with Radios & Combo Boxes");
	}
	
	public static void ThankYou()
	{
		lbl_YrName.setVisible(false);
		lbl_NumPrints.setVisible(false);
		lbl_NumOrdered.setVisible(false);
		lbl_Dimensions.setVisible(false);
		lbl_GeneralInfo.setVisible(false);
		lbl_PhotoCorrectionOptions.setVisible(false);
		lbl_ProvinceCountry.setVisible(false);
		lbl_ThankYou.setVisible(false);
		sep_Horizontal.setVisible(false);
		sep_GeneralInfo.setVisible(false);
		sep_PhotoCorrection.setVisible(false);
		txt_Name.setVisible(false);
		txt_NumPrints.setVisible(false);
		txt_Address.setVisible(false);
		rad_Pickup.setVisible(false);
		rad_Deliver.setVisible(false);
		cbo_SelectSizeComboBox.setVisible(false);
		cbo_ChooseCity.setVisible(false);
		lbl_ThankYou.setVisible(false);
		OrderAgain.setVisible(false);
		lbl_ThankYou.setVisible(false);
		OrderAgain.setVisible(false);
		lbl_ThankYou.setVisible(false);
		OrderAgain.setVisible(false);
		checkBox1.setVisible(false);
		checkBox2.setVisible(false);
		checkBox3.setVisible(false);
		checkBox4.setVisible(false);
		checkBox5.setVisible(false);
		checkBox6.setVisible(false);
		checkBox7.setVisible(false);
		checkBox8.setVisible(false);
		TurnOffButton.setVisible(false);		
	
		lbl_ThankYou.setVisible(true);
		OrderAgain.setVisible(true);
		ReceiptName = txt_Name.getText();
		System.out.println(" ----------Receipt-------------------------------------------------------------");
		System.out.println("|\t\t\t\t   Shutter Bugs" +"\t\t\t\t       |");
		System.out.print("|\t\t\t\t Peterborough, ON\t\t\t       |\n");
		System.out.print("|\t\t\t\t   705-555-3722\t\t\t               |\n");
		System.out.print("|\t\t\t   *** You Pic it we Print it*** \t\t       |\n");
		System.out.print("|   ________________________________________________________________________   |\n");
		System.out.print("|\t\t\t\t\t\t\t\t\t       |\n");
		System.out.print("|\t\t\t    Here is your order: " + ReceiptName + "\t\t\t       |" + "\n");
		System.out.print("|Items:\t\t\t\t\t\t\t\t\t       |\n");
		System.out.print("|\t\t\t\t\t\t\t\t\t       |\n");
		//System.out.print("|" + "" + money.format(SubSubtotal) + " " + "\t\t\t\t\t\t       |" + "\n");
		
		//Red_Eye;
		//private static Boolean Over_Exposure;
		//private static Boolean Colour_Correction;
		//private static Boolean Blemish_Re_Touching;
		//private static Boolean People_Remover;
		//private static Boolean Skin_Care;
		//private static Boolean Sharpen_Image;
		//private static Boolean Add_Blur;
		if (Red_Eye == true) 
		{
			System.out.print("|" + "Red Eye" + "\t"  + "\t\t\t\t\t\t\t       |" + "\n");
		}
		if (Over_Exposure == true) 
		{
			System.out.print("|" + "Colour Correction" + "\t"  + "\t\t\t\t\t\t\t       |" + "\n");
		}
		if (Colour_Correction == true) 
		{
			System.out.print("|" + "Blemish Re-Touching" + "\t"  + "\t\t\t\t\t\t\t       |" + "\n");
		}
		if (Blemish_Re_Touching == true) 
		{
			System.out.print("|" + "People Remover" + "\t"  + "\t\t\t\t\t\t\t       |" + "\n");
		}
		if (People_Remover == true)
		{
			System.out.print("|" + "Skin Care" + "\t"  + "\t\t\t\t\t\t\t       |" + "\n");
		}
		if (Skin_Care == true)
		{
			System.out.print("|" + "Sharpen Image" + "\t"  + "\t\t\t\t\t\t\t       |" + "\n");
		}
		if (Sharpen_Image == true)
		{
			System.out.print("|" + "Add Blur" + "\t"  + "\t\t\t\t\t\t\t       |" + "\n");
		}
		if (Add_Blur == true)
		{
			System.out.print("|" + "Red Eye" + "\t"  + "\t\t\t\t\t\t\t       |" + "\n");
		}
		
	//	System.out.print("|" + "+HST:" + " " + money.format(Tax_total) + "\t\t\t\t\t\t\t\t       |" + "\n");
	//	System.out.print("|" + "+Tip (15%):" + " " + money.format(Tip_total) + "\t\t\t\t\t\t\t       |" + "\n");
	//	System.out.print("|" + "Your total price is:" + " " + money.format(Total) + "\t\t\t\t\t\t       |" + "\n");
		System.out.print("|\t\t\t\t\t\t\t\t\t       |\n");
		System.out.print("|\t\t     Thank you for printing with Shutter Bugs" +"\t\t       |\n");
		System.out.print("|\t\t\t\t\t\t\t\t\t       |\n");
		System.out.println(" ------------------------------------------------------------------------------");
	}
	public static void OrderAgain() {
		lbl_YrName.setVisible(true);
		lbl_NumPrints.setVisible(true);
		lbl_NumOrdered.setVisible(true);
		lbl_Dimensions.setVisible(true);
		lbl_GeneralInfo.setVisible(true);
		lbl_PhotoCorrectionOptions.setVisible(true);
		lbl_ThankYou.setVisible(true);
		sep_Horizontal.setVisible(true);
		sep_GeneralInfo.setVisible(true);
		sep_PhotoCorrection.setVisible(true);
		txt_Name.setVisible(true);
		txt_NumPrints.setVisible(true);
		rad_Pickup.setVisible(true);
		rad_Deliver.setVisible(true);
		cbo_SelectSizeComboBox.setVisible(true);
		OrderAgain.setVisible(true);
		checkBox1.setVisible(true);
		checkBox2.setVisible(true);
		checkBox3.setVisible(true);
		checkBox4.setVisible(true);
		checkBox5.setVisible(true);
		checkBox6.setVisible(true);
		checkBox7.setVisible(true);
		checkBox8.setVisible(true);
		TurnOffButton.setVisible(true);		
		
		txt_Name.setText("");
		txt_NumPrints.setText("");
		txt_Address.setText("");
		checkBox1.setSelected(false);
		checkBox2.setSelected(false);
		checkBox3.setSelected(false);
		checkBox4.setSelected(false);
		checkBox5.setSelected(false);
		checkBox6.setSelected(false);
		checkBox7.setSelected(false);
		checkBox8.setSelected(false);
		
		lbl_ThankYou.setVisible(false);
		OrderAgain.setVisible(false);
		
		cbo_SelectSizeComboBox.setSelectedIndex(0);
		cbo_ChooseCity.setSelectedIndex(0);
		bg.clearSelection();
	}
	public static void main(String[] args) {
		GUI();
		CheckComboBox();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{//Beginning of actionPerformed
		
		//Button Calculate
		if (e.getActionCommand() == Actions.ORDER1.name())
		{//Beginning of if
			ThankYou();
		}//End of if
		else if (e.getActionCommand() == Actions.ORDERAGAIN.name())
		{//Beginning of else if
			OrderAgain();
		}//End of else if
		else if (e.getActionCommand() == Actions.RADIOPICKUP.name())
		{//Beginning of else if
			lbl_ProvinceCountry.setVisible(false);
			txt_Address.setVisible(false);
			cbo_ChooseCity.setVisible(false);
		}//End of else if
		else if (e.getActionCommand() == Actions.RADIODELIVER.name())
		{//Beginning of else if
			lbl_ProvinceCountry.setVisible(true);
			txt_Address.setVisible(true);
			cbo_ChooseCity.setVisible(true);
		}//End of else if
		else if (e.getActionCommand() == Actions.REDEYE.name())
		{//Beginning of else if
			Red_Eye = true;
		}//End of else if
		else if (e.getActionCommand() == Actions.OVER_EXPOSURE.name())
		{//Beginning of else if
			Over_Exposure = true;
		}//End of else if
		else if (e.getActionCommand() == Actions.COLOUR_CORRECTION.name())
		{//Beginning of else if
			Colour_Correction = true;
		}//End of else if
		else if (e.getActionCommand() == Actions.BLEMISH_RE_TOUCHING.name())
		{//Beginning of else if
			Blemish_Re_Touching = true;
		}//End of else if
		else if (e.getActionCommand() == Actions.PEOPLE_REMOVER.name())
		{//Beginning of else if
			People_Remover = true;
		}//End of else if
		else if (e.getActionCommand() == Actions.SKIN_CARE.name())
		{//Beginning of else if
			Skin_Care = true;
		}//End of else if
		else if (e.getActionCommand() == Actions.SHARPEN_IMAGE.name())
		{//Beginning of else if
			Sharpen_Image = true;
		}//End of else if
		else if (e.getActionCommand() == Actions.ADD_BLUR.name())
		{//Beginning of else if
			Add_Blur = true;
		}//End of else if
		else if (e.getActionCommand() == Actions.RESET.name())
		{//Beginning of else if
			lbl_YrName.setVisible(true);
			lbl_NumPrints.setVisible(true);
			lbl_NumOrdered.setVisible(true);
			lbl_Dimensions.setVisible(true);
			lbl_GeneralInfo.setVisible(true);
			lbl_PhotoCorrectionOptions.setVisible(true);
			lbl_ThankYou.setVisible(true);
			sep_Horizontal.setVisible(true);
			sep_GeneralInfo.setVisible(true);
			sep_PhotoCorrection.setVisible(true);
			txt_Name.setVisible(true);
			txt_NumPrints.setVisible(true);
			rad_Pickup.setVisible(true);
			rad_Deliver.setVisible(true);
			cbo_SelectSizeComboBox.setVisible(true);
			OrderAgain.setVisible(true);
			checkBox1.setVisible(true);
			checkBox2.setVisible(true);
			checkBox3.setVisible(true);
			checkBox4.setVisible(true);
			checkBox5.setVisible(true);
			checkBox6.setVisible(true);
			checkBox7.setVisible(true);
			checkBox8.setVisible(true);
			TurnOffButton.setVisible(true);		
			
			txt_Name.setText("");
			txt_NumPrints.setText("");
			txt_Address.setText("");
			txt_Address.setVisible(false);
			lbl_ProvinceCountry.setVisible(false);
			cbo_ChooseCity.setVisible(false);
			checkBox1.setSelected(false);
			checkBox2.setSelected(false);
			checkBox3.setSelected(false);
			checkBox4.setSelected(false);
			checkBox5.setSelected(false);
			checkBox6.setSelected(false);
			checkBox7.setSelected(false);
			checkBox8.setSelected(false);
			
			lbl_ThankYou.setVisible(false);
			OrderAgain.setVisible(false);
			
			cbo_ChooseCity.setSelectedIndex(0);
			cbo_SelectSizeComboBox.setSelectedIndex(0);
			bg.clearSelection();
		}//End of else if
		else if (e.getActionCommand() == Actions.EXIT.name())
		{//Beginning of else if
			fr_frame.dispose();
			System.exit(0);
		}//End of else if
	}//End of actionPerformed
}
