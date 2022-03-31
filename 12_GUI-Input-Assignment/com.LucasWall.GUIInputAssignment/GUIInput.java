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

public class GUIInput implements ActionListener
{//Beginning of GUIInput
	//------Gui Globals
	private static JPanel pnl_panel;
	private static JFrame fr_frame;
	
	//Labels
	private static JLabel lbl_TitleLabel;
	private static JLabel lbl_Slogan;
	private static JLabel lbl_YrName;
	private static JLabel lbl_GeneralInfo;
	private static JLabel lbl_PhotoCorrectionOptions;
	private static JLabel lbl_NumPrints;
	private static JLabel lbl_Dimensions;
	private static JLabel lbl_ProvinceCountry;
	private static JLabel lbl_ThankYou;
	
	//Separators
	private static JSeparator sep_Title;
	private static JSeparator sep_Horizontal;
	private static JSeparator sep_GeneralInfo;
	private static JSeparator sep_PhotoCorrection;
	
	//TextFields
	private static JTextField txt_Name;
	private static JTextField txt_NumPrints;
	private static JTextField txt_Address;
	
	//Images - (Labels)
	private static JLabel img_LadyBug;
	private static JLabel img_Flag;
	
	//Radio Buttons
	private static JRadioButton rad_Pickup;
	private static JRadioButton rad_Deliver;
	
	//Combo Boxes
	private static JComboBox<String> cbo_SelectSizeComboBox;
	private static JComboBox<String> cbo_ChooseCity;
	
	//Check Boxes
	private static JCheckBox chk_RedEye;
	private static JCheckBox chk_OverExposure;
	private static JCheckBox chk_ColourCorrection;
	private static JCheckBox chk_BlemishReTouching;
	private static JCheckBox chk_PeopleRemover;
	private static JCheckBox chk_SkinCare;
	private static JCheckBox chk_SharpenImage;
	private static JCheckBox chk_AddBlur;
	
	//Buttons
	private static JButton btn_TurnOff;
	private static JButton btn_OrderAgain;
	private static JButton btn_Reset;
	private static JButton btn_Exit;
	
	//--------Other Globals 
	private static ButtonGroup bg_PickupDeliver;
	private static String str_ReceiptName = "";
	private static Boolean bool_Red_Eye = false;
	private static Boolean bool_Over_Exposure = false;
	private static Boolean bool_Colour_Correction = false;
	private static Boolean bool_Blemish_Re_Touching = false;
	private static Boolean bool_People_Remover = false;
	private static Boolean bool_Skin_Care = false;
	private static Boolean bool_Sharpen_Image = false;
	private static Boolean bool_Add_Blur = false;
	private static String str_Dimensions = "Unselected";
	private static String str_DimensionsReceipt = "";
	private static String str_prints = "";
	private static double dbl_PhotoCorrectionPrice = 5;
	private static double dbl_Subtotal = 0;
	private static double dbl_printsInt = 0;
	private static double dbl_PrintsPrice = 0;
	private static double dbl_DimensionsPrice = 0;
	private static double dbl_Total = 0;
	private static double dbl_Tax_total = 0;
	private static BufferedImage BufferedLadyBug;
	private static BufferedImage BufferedFlag;
	private static Image ImageLadyBug;
	private static Image ImageFlag;
	private static ImageIcon icn_LadyBug;
	private static ImageIcon icn_Flag;
	
	//------New Colours
	public static final Color NEW_BLUE = new Color(147, 196, 180);
	public static final Color DARK_GREY = new Color(102,102,102);
	public static final Color WRONG_RED = new Color(251, 255, 250);
	
	//------Constant Variables
	public static final double dbl_HST_TAX  = 1.13;
	
	//------Decimal Formats
	public static DecimalFormat money = new DecimalFormat("$###,###,##0.00");
	public static DecimalFormat number = new DecimalFormat("###,###,###");
	
	//------Borders
	public static Border FrameBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	public static Border ButtonBorder = BorderFactory.createCompoundBorder();
	
	public enum Actions
	{//Beginning of Actions
		RADIOPICKUP,//Action that hides Deliver Objects
		RADIODELIVER,//Action that shows Deliver Objects
		
		REDEYE,//Action that sets RedEye to true so that the receipt know to print it out
		OVER_EXPOSURE,//Action that sets Over Exposure to true so that the receipt know to print it out
		COLOUR_CORRECTION,//Action that sets Colour Correction to true so that the receipt know to print it out
		BLEMISH_RE_TOUCHING,//Action that sets Blemish Re-Touching to true so that the receipt know to print it out
		PEOPLE_REMOVER,//Action that sets People Remover to true so that the receipt know to print it out
		SKIN_CARE,//Action that sets Skin Care to true so that the receipt know to print it out
		SHARPEN_IMAGE,//Action that sets Sharpen Image to true so that the receipt know to print it out
		ADD_BLUR,//Action that sets Add Blur to true so that the receipt know to print it out
		
		ORDER,//Action that sets RedEye to true so that the receipt know to print it out
		ORDERAGAIN,//Action that sets RedEye to true so that the receipt know to print it out
		
		RESET,//Action that resets the GUI elements so that they are enabled again.
		EXIT//Dispose's the frame and ends the program
	}//End of Actions
	public static void GUI() {
		GUIInput instance = new GUIInput();
		String[] optionsToChoose = { "Choose Dimensions", "$5 | 4x6", "$7 | 6x8", "$10 | 8x10", "$15 | 12x17"};
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
		
		//----All Things Images
		BufferedLadyBug = null;
		BufferedFlag = null;
		try
		{//Beginning of try
			BufferedLadyBug = ImageIO.read(new File("LB.png"));
			BufferedFlag = ImageIO.read(new File("Flag.png"));
		}//End of try
		catch (IOException e)
		{//Beginning of catch
		    e.printStackTrace();
		}//End of catch
		//Creates Scaled Instances of Images
		ImageLadyBug = BufferedLadyBug.getScaledInstance(60, 45, 100);
		ImageFlag = BufferedFlag.getScaledInstance(80, 45, 100);
		
		//Creates image icons
		icn_LadyBug = new ImageIcon(ImageLadyBug);
		icn_Flag = new ImageIcon(ImageFlag);
		
		//-----------Creating GUI Objects
		//Images(Labels)
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
		
		lbl_NumPrints = new JLabel("How many prints would you like? (50 Cents Each)");
		lbl_NumPrints.setBounds(50, 210, 500, 25);
		pnl_panel.add(lbl_NumPrints);
		lbl_NumPrints.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
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
		
		lbl_PhotoCorrectionOptions = new JLabel("Photo Correction Options (+5$ Each)");
		lbl_PhotoCorrectionOptions.setBounds(570,105,576,30);
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
		
		bg_PickupDeliver = new ButtonGroup();    
		bg_PickupDeliver.add(rad_Pickup);//adds Radio Button rad_Pickup to Button Group
		bg_PickupDeliver.add(rad_Deliver);//adds Radio Button rad_Deliver to Button Group
		
		//Text Fields
		txt_Name = new JTextField(20);
		txt_Name.setBounds(280,150,150,30);
		pnl_panel.add(txt_Name);
		
		txt_NumPrints = new JTextField(20);
		txt_NumPrints.setBounds(540,210,50,30);
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
		chk_RedEye = new JCheckBox("Red Eye");  
		chk_RedEye.setBounds(650,140, 200,50); 
		chk_RedEye.setActionCommand(Actions.REDEYE.name());
		chk_RedEye.addActionListener(instance);
        pnl_panel.add(chk_RedEye); 
        
        chk_OverExposure = new JCheckBox("Over Exposure");  
        chk_OverExposure.setBounds(650,190, 200,50);  
        chk_OverExposure.setActionCommand(Actions.OVER_EXPOSURE.name());
        chk_OverExposure.addActionListener(instance);
        pnl_panel.add(chk_OverExposure); 
        
        chk_ColourCorrection = new JCheckBox("Colour Correction");  
        chk_ColourCorrection.setBounds(650,240, 200,50);  
        chk_ColourCorrection.setActionCommand(Actions.COLOUR_CORRECTION.name());
        chk_ColourCorrection.addActionListener(instance);
        pnl_panel.add(chk_ColourCorrection);  
        
        chk_BlemishReTouching = new JCheckBox("Blemish Re-Touching");  
        chk_BlemishReTouching.setBounds(650,290, 200,50);  
        chk_BlemishReTouching.setActionCommand(Actions.BLEMISH_RE_TOUCHING.name());
        chk_BlemishReTouching.addActionListener(instance);
        pnl_panel.add(chk_BlemishReTouching);  
        
        chk_PeopleRemover = new JCheckBox("People Remover");  
        chk_PeopleRemover.setBounds(900,140, 200,50);  
        chk_PeopleRemover.setActionCommand(Actions.PEOPLE_REMOVER.name());
        chk_PeopleRemover.addActionListener(instance);
        pnl_panel.add(chk_PeopleRemover); 
        
        chk_SkinCare = new JCheckBox("Skin Care");  
        chk_SkinCare.setBounds(900,190, 200,50);  
        chk_SkinCare.setActionCommand(Actions.SKIN_CARE.name());
        chk_SkinCare.addActionListener(instance);
        pnl_panel.add(chk_SkinCare); 
        
        chk_SharpenImage = new JCheckBox("Sharpen Image");  
        chk_SharpenImage.setBounds(900,240, 200,50);   
        chk_SharpenImage.setActionCommand(Actions.SHARPEN_IMAGE.name());
        chk_SharpenImage.addActionListener(instance);
        pnl_panel.add(chk_SharpenImage);  
        
        chk_AddBlur = new JCheckBox("Add Blur");  
        chk_AddBlur.setBounds(900,290, 250,50);  
        chk_AddBlur.setActionCommand(Actions.ADD_BLUR.name());
        chk_AddBlur.addActionListener(instance);
        pnl_panel.add(chk_AddBlur);
        
		//Buttons
        btn_TurnOff = new JButton("Place Order");
        btn_TurnOff.setBounds(176, 550, 800, 75);
        btn_TurnOff.setActionCommand(Actions.ORDER.name());
        btn_TurnOff.addActionListener(instance);
		pnl_panel.add(btn_TurnOff);
		
		btn_OrderAgain = new JButton("Order Again");
		btn_OrderAgain.setBounds(476, 350, 200, 25);
		btn_OrderAgain.setActionCommand(Actions.ORDERAGAIN.name());
		btn_OrderAgain.addActionListener(instance);
		pnl_panel.add(btn_OrderAgain);
		btn_OrderAgain.setVisible(false);
		
		btn_Reset = new JButton("Reset");
		btn_Reset.setBounds(100, 25, 80, 25);
		btn_Reset.setActionCommand(Actions.RESET.name());
		btn_Reset.addActionListener(instance);
		pnl_panel.add(btn_Reset);
		
		btn_Exit = new JButton("Exit");
		btn_Exit.setBounds(20, 25, 80, 25);
		btn_Exit.setActionCommand(Actions.EXIT.name());
		btn_Exit.addActionListener(instance);
		pnl_panel.add(btn_Exit);
		
		//Frame config
		fr_frame.setResizable(false);
		fr_frame.setVisible(true);
		fr_frame.setTitle("Working with Radios & Combo Boxes");//Creates a title for the frame
	}//End of GUI
	
	public static void main(String[] args)
	{//Beginning of main
		GUI();
	}//End of main
	
	@Override
	public void actionPerformed(ActionEvent e)
	{//Beginning of actionPerformed
		if (e.getActionCommand() == Actions.ORDER.name())
		{//Beginning of if
			//Changes order Objects to not visible
			lbl_YrName.setVisible(false);
			lbl_NumPrints.setVisible(false);
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
			btn_OrderAgain.setVisible(false);
			lbl_ThankYou.setVisible(false);
			btn_OrderAgain.setVisible(false);
			lbl_ThankYou.setVisible(false);
			btn_OrderAgain.setVisible(false);
			chk_RedEye.setVisible(false);
			chk_OverExposure.setVisible(false);
			chk_ColourCorrection.setVisible(false);
			chk_BlemishReTouching.setVisible(false);
			chk_PeopleRemover.setVisible(false);
			chk_SkinCare.setVisible(false);
			chk_SharpenImage.setVisible(false);
			chk_AddBlur.setVisible(false);
			btn_TurnOff.setVisible(false);		
			
			//Shows the Thank you Objects
			lbl_ThankYou.setVisible(true);
			btn_OrderAgain.setVisible(true);
			
			//-------Receipt logic
			str_ReceiptName = txt_Name.getText();
			str_Dimensions = (String) cbo_SelectSizeComboBox.getSelectedItem();
			str_prints = txt_NumPrints.getText();
			dbl_printsInt = Integer.parseInt(str_prints);
			dbl_Subtotal += dbl_printsInt * 0.50;
			dbl_PrintsPrice = dbl_printsInt * 0.50;
			dbl_DimensionsPrice = 0;
			if(str_Dimensions.equals("$5 | 4x6"))
			{//Beginning of if
				str_DimensionsReceipt = "4x6";
				dbl_Subtotal += 5;
				dbl_DimensionsPrice = 5;
			}//End of if
			else if(str_Dimensions.equals("$7 | 6x8"))
			{//Beginning of else if
				str_DimensionsReceipt = "6x8";
				dbl_Subtotal += 7;
				dbl_DimensionsPrice = 7;
			}//End of else if
			else if(str_Dimensions.equals("$10 | 8x10"))
			{//Beginning of else if
				str_DimensionsReceipt = "8x10";
				dbl_Subtotal += 10;
				dbl_DimensionsPrice = 10;
			}//End of else if
			else if(str_Dimensions.equals("$15 | 12x17"))
			{//Beginning of else if
				str_DimensionsReceipt = "12x17";
				dbl_Subtotal += 15;
				dbl_DimensionsPrice = 15;
			}//End of else if
			//-------Receipt System.out.print
			System.out.println(" ----------Receipt-------------------------------------------------------------");
			System.out.println("|\t\t\t\t   Shutter Bugs" +"\t\t\t\t       |");
			System.out.print("|\t\t\t\t Peterborough, ON\t\t\t       |\n");
			System.out.print("|\t\t\t\t   705-555-3722\t\t\t               |\n");
			System.out.print("|\t\t\t   *** You Pic it we Print it*** \t\t       |\n");
			System.out.print("|   ________________________________________________________________________   |\n");
			System.out.print("|\t\t\t\t\t\t\t\t\t       |\n");
			System.out.print("|\t\t\t    Here is your order: " + str_ReceiptName + "\t\t\t       |" + "\n");
			System.out.print("|Items:\t\t\t\t\t\t\t\t\t       |\n");
			System.out.print("|\t\t\t\t\t\t\t\t\t       |\n");
			System.out.print("|" + money.format(dbl_DimensionsPrice) + "  Dimensions (" + str_DimensionsReceipt + ")" + " \t\t\t\t\t\t       |\n");
			System.out.print("|" +  money.format(dbl_PrintsPrice) + "  " + number.format(dbl_printsInt) + " Prints" + " \t\t\t\t\t\t\t       |\n");
			if (bool_Red_Eye == true) 
			{//Beginning of if
				dbl_Subtotal+=5;
				System.out.print("|" + money.format(dbl_PhotoCorrectionPrice) + "\tRed Eye" + "\t"  + "\t\t\t\t\t\t\t       |" + "\n");
			}//End of if
			if (bool_Over_Exposure == true) 
			{//Beginning of if
				dbl_Subtotal+=5;
				System.out.print("|" + money.format(dbl_PhotoCorrectionPrice) + "\tOver Exposure" + "\t"  + "\t\t\t\t\t\t       |" + "\n");
			}//End of if
			if (bool_Colour_Correction == true) 
			{//Beginning of if
				dbl_Subtotal+=5;
				System.out.print("|" + money.format(dbl_PhotoCorrectionPrice) + "\tColour Correction" + "\t"  + "\t\t\t\t\t       |" + "\n");
			}//End of if
			if (bool_Blemish_Re_Touching == true) 
			{//Beginning of if
				dbl_Subtotal+=5;
				System.out.print("|" + money.format(dbl_PhotoCorrectionPrice) + "\tBlemish Re-Touching" + "\t"  + "\t\t\t\t\t       |" + "\n");
			}//End of if
			if (bool_People_Remover == true)
			{//Beginning of if
				dbl_Subtotal+=5;
				System.out.print("|" + money.format(dbl_PhotoCorrectionPrice) + "\tPeople Remover" + "\t"  + "\t\t\t\t\t\t       |" + "\n");
			}//End of if
			if (bool_Skin_Care == true)
			{//Beginning of if
				dbl_Subtotal+=5;
				System.out.print("|"+ money.format(dbl_PhotoCorrectionPrice) + "\tSkin Care" + "\t"  + "\t\t\t\t\t\t       |" + "\n");
			}//End of if
			if (bool_Sharpen_Image == true)
			{//Beginning of if
				dbl_Subtotal+=5;
				System.out.print("|" + money.format(dbl_PhotoCorrectionPrice) + "\tSharpen Image" + "\t"  + "\t\t\t\t\t\t       |" + "\n");
			}//End of if
			if (bool_Add_Blur == true)
			{//Beginning of if
				dbl_Subtotal+=5;
				System.out.print("|" + money.format(dbl_PhotoCorrectionPrice) + "\tAdd Blur" + "\t"  + "\t\t\t\t\t\t       |" + "\n");
			}//End of if
			
			//Totalling Logic
			dbl_Total = dbl_Subtotal*dbl_HST_TAX;
			dbl_Tax_total = dbl_Total-dbl_Subtotal;
			
			//Bottom half of receipt System.out prints
			System.out.print("|\t\t\t\t\t\t\t\t\t       |\n");
			System.out.print("|" + "Subtotal:" + " " + money.format(dbl_Subtotal) + " " + "\t\t\t\t\t\t\t       |" + "\n");
			System.out.print("|" + "+HST:" + " " + money.format(dbl_Tax_total) + "\t\t\t\t\t\t\t\t       |" + "\n");
		    System.out.print("|" + "Your total price is:" + " " + money.format(dbl_Total) + "\t\t\t\t\t\t       |" + "\n");
			System.out.print("|\t\t\t\t\t\t\t\t\t       |\n");
			System.out.print("|\t\t     Thank you for printing with Shutter Bugs" +"\t\t       |\n");
			System.out.print("|\t\t\t\t\t\t\t\t\t       |\n");
			System.out.println(" ------------------------------------------------------------------------------");
		}//End of if
		else if (e.getActionCommand() == Actions.ORDERAGAIN.name())
		{//Beginning of else if
			//Makes ordering objects visible again
			lbl_YrName.setVisible(true);
			lbl_NumPrints.setVisible(true);
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
			chk_RedEye.setVisible(true);
			chk_OverExposure.setVisible(true);
			chk_ColourCorrection.setVisible(true);
			chk_BlemishReTouching.setVisible(true);
			chk_PeopleRemover.setVisible(true);
			chk_SkinCare.setVisible(true);
			chk_SharpenImage.setVisible(true);
			chk_AddBlur.setVisible(true);	
			btn_TurnOff.setVisible(true);

			//Hides Thank You Objects
			lbl_ThankYou.setVisible(false);
			btn_OrderAgain.setVisible(false);
			
			//Sets all of the checkboxes to unselected
			chk_RedEye.setSelected(false);
			chk_OverExposure.setSelected(false);
			chk_ColourCorrection.setSelected(false);
			chk_BlemishReTouching.setSelected(false);
			chk_PeopleRemover.setSelected(false);
			chk_SkinCare.setSelected(false);
			chk_SharpenImage.setSelected(false);
			chk_AddBlur.setSelected(false);
			
			//Resets Text Boxes, Combo Boxes, Radio Buttons, and Variables
			txt_Name.setText("");
			txt_NumPrints.setText("");
			txt_Address.setText("");
			cbo_SelectSizeComboBox.setSelectedIndex(0);
			cbo_ChooseCity.setSelectedIndex(0);
			bg_PickupDeliver.clearSelection();
			str_Dimensions = "";
			str_DimensionsReceipt = "";
			dbl_Subtotal = 0;//Resets Subtotal
			bool_Red_Eye = false;//Sets to false so that it does not get calculated twice
			bool_Over_Exposure = false;//Sets to false so that it does not get calculated twice
			bool_Colour_Correction = false;//Sets to false so that it does not get calculated twice
			bool_Blemish_Re_Touching = false;//Sets to false so that it does not get calculated twice
			bool_People_Remover = false;//Sets to false so that it does not get calculated twice
			bool_Skin_Care = false;//Sets to false so that it does not get calculated twice
			bool_Sharpen_Image = false;//Sets to false so that it does not get calculated twice
			bool_Add_Blur = false;//Sets to false so that it does not get calculated twice
			//Makes space for the next receipt in the console
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
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
			bool_Red_Eye = true;
		}//End of else if
		else if (e.getActionCommand() == Actions.OVER_EXPOSURE.name())
		{//Beginning of else if
			bool_Over_Exposure = true;
		}//End of else if
		else if (e.getActionCommand() == Actions.COLOUR_CORRECTION.name())
		{//Beginning of else if
			bool_Colour_Correction = true;
		}//End of else if
		else if (e.getActionCommand() == Actions.BLEMISH_RE_TOUCHING.name())
		{//Beginning of else if
			bool_Blemish_Re_Touching = true;
		}//End of else if
		else if (e.getActionCommand() == Actions.PEOPLE_REMOVER.name())
		{//Beginning of else if
			bool_People_Remover = true;
		}//End of else if
		else if (e.getActionCommand() == Actions.SKIN_CARE.name())
		{//Beginning of else if
			bool_Skin_Care = true;
		}//End of else if
		else if (e.getActionCommand() == Actions.SHARPEN_IMAGE.name())
		{//Beginning of else if
			bool_Sharpen_Image = true;
		}//End of else if
		else if (e.getActionCommand() == Actions.ADD_BLUR.name())
		{//Beginning of else if
			bool_Add_Blur = true;
		}//End of else if
		else if (e.getActionCommand() == Actions.RESET.name())
		{//Beginning of else if
			lbl_YrName.setVisible(true);
			lbl_NumPrints.setVisible(true);
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
			btn_OrderAgain.setVisible(true);
			chk_RedEye.setVisible(true);
			chk_OverExposure.setVisible(true);
			chk_ColourCorrection.setVisible(true);
			chk_BlemishReTouching.setVisible(true);
			chk_PeopleRemover.setVisible(true);
			chk_SkinCare.setVisible(true);
			chk_SharpenImage.setVisible(true);
			chk_AddBlur.setVisible(true);
			btn_TurnOff.setVisible(true);		
			
			//Sets the Ship to Object to not visible
			txt_Address.setVisible(false);
			lbl_ProvinceCountry.setVisible(false);
			cbo_ChooseCity.setVisible(false);
			
			//Sets Thank you Objects to not visible
			btn_OrderAgain.setVisible(false);
			lbl_ThankYou.setVisible(false);
			
			//Sets all of the checkboxes to unselected
			chk_RedEye.setSelected(false);
			chk_OverExposure.setSelected(false);
			chk_ColourCorrection.setSelected(false);
			chk_BlemishReTouching.setSelected(false);
			chk_PeopleRemover.setSelected(false);
			chk_SkinCare.setSelected(false);
			chk_SharpenImage.setSelected(false);
			chk_AddBlur.setSelected(false);
			
			//Resets Text Boxes, Combo Boxes, Radio Buttons, and Variables
			txt_Name.setText("");//Sets the Txt of the textfield to empty
			txt_NumPrints.setText("");//Sets the Txt of the textfield to empty
			txt_Address.setText("");//Sets the Txt of the textfield to empty
			cbo_ChooseCity.setSelectedIndex(0);//Clears the ComboBox
			cbo_SelectSizeComboBox.setSelectedIndex(0);//Clears the ComboBox
			bg_PickupDeliver.clearSelection();//Clears selected radio in the button group
			dbl_Subtotal = 0;//Resets Subtotal
			bool_Red_Eye = false;//Sets to false so that it does not get calculated twice
			bool_Over_Exposure = false;//Sets to false so that it does not get calculated twice
			bool_Colour_Correction = false;//Sets to false so that it does not get calculated twice
			bool_Blemish_Re_Touching = false;//Sets to false so that it does not get calculated twice
			bool_People_Remover = false;//Sets to false so that it does not get calculated twice
			bool_Skin_Care = false;//Sets to false so that it does not get calculated twice
			bool_Sharpen_Image = false;//Sets to false so that it does not get calculated twice
			bool_Add_Blur = false;//Sets to false so that it does not get calculated twice
		}//End of else if
		else if (e.getActionCommand() == Actions.EXIT.name())
		{//Beginning of else if
			fr_frame.dispose();//Closes Frame
			System.exit(0);//Ends Program
		}//End of else if
	}//End of actionPerformed
}//End of GUIInput
