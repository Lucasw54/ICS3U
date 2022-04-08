package com.LucasWall.QuizAssignment;
//Imports
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
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class Quiz implements ActionListener
{//Beginning of Quiz
	private static JPanel pnl_panel;
	private static JFrame fr_frame;
	
	//Labels
	private static JLabel lbl_TitleLabel;
	private static JLabel lbl_Name;
	private static JLabel lbl_Score;
	private static JLabel lbl_Question1Title;
	private static JLabel lbl_Question2Title;
	private static JLabel lbl_Question3Title;
	private static JLabel lbl_Question4Title;
	private static JLabel lbl_Question5Title;
	private static JLabel lbl_Question6Title;
	private static JLabel lbl_Question7Title;
	private static JLabel lbl_Question8Title;
	private static JLabel lbl_Question9Title;
	private static JLabel lbl_Question10Title;
	
	//Separators
	private static JSeparator sep_Title;
	
	//TextFields
	private static JTextField txt_Name;
	private static JTextField txt_Question5;
	private static JTextField txt_Question6;
	
	//Images - (Labels)
	private static JLabel img_CodeBackground;
	private static BufferedImage BufferedCodeBackground;
	private static Image ImageCodeBackground;
	private static ImageIcon icn_CodeBackground;
	
	private static JLabel img_Java;
	private static BufferedImage BufferedJava;
	private static Image ImageJava;
	private static ImageIcon icn_Java;
	
	//Radio Buttons
	private static ButtonGroup bg_Difficulty;
	private static JRadioButton rad_Easy;
	private static JRadioButton rad_Medium;
	private static JRadioButton rad_Hard;
	private static JRadioButton rad_Insane;
	
	private static ButtonGroup bg_Question1;
	private static JRadioButton rad_Q1AnswerA;
	private static JRadioButton rad_Q1AnswerB;
	private static JRadioButton rad_Q1AnswerC;
	private static JRadioButton rad_Q1AnswerD;
	
	private static ButtonGroup bg_Question2;
	private static JRadioButton rad_Q2AnswerA;
	private static JRadioButton rad_Q2AnswerB;
	private static JRadioButton rad_Q2AnswerC;
	private static JRadioButton rad_Q2AnswerD;
	//Combo Boxes
	
	private static JComboBox<String> cbo_SelectSizeComboBox;
	
	//Check Boxes
	
	private static JCheckBox chk_Q7AnswerA;
	private static JCheckBox chk_Q7AnswerB;
	private static JCheckBox chk_Q7AnswerC;
	private static JCheckBox chk_Q7AnswerD;
	private static JCheckBox chk_Q8AnswerA;
	private static JCheckBox chk_Q8AnswerB;
	private static JCheckBox chk_Q8AnswerC;
	private static JCheckBox chk_Q8AnswerD;
	
	//Buttons
	private static JButton btn_Start;
	private static JButton btn_Previous;
	private static JButton btn_Next;
	private static JButton btn_TrueTop;
	private static JButton btn_FalseTop;
	private static JButton btn_TrueBottom;
	private static JButton btn_FalseBottom;
	private static JButton btn_Quit;
	private static JButton btn_Reset;
	
	//--------Other Globals 
	private static Quiz instance;
	public static JProgressBar bar_Load = new JProgressBar();
	private static String str_Difficulty = "";
	private static double dbl_Page = 1;
	private static double Score = 0;
	private static String ScoreCheck = "";
	private static String[] Letters = {"A","B","C","D"};
	private static String Name ="";
	
	private static String Question1 = "";
	private static String Question2 = "";
	private static String Question3 = "";
	private static String Question4 = "";
	private static String Question5 = "";
	private static String Question6 = "";
	private static String Question7 = "";
	private static String Question8 = "";
	private static String Question9 = "";
	private static String Question10 = "";
	
	private static String Question1Input = "";
	private static String Question2Input = "";
	private static String Question3Input = "";
	private static String Question4Input = "";
	private static String Question5Input = "";
	private static String Question6Input = "";
	
	private static String Question7Input = "";
	private static String Question7AInput = "";
	private static String Question7BInput = "";
	private static String Question7CInput = "";
	private static String Question7DInput = "";
	
	private static String Question8Input = "";
	private static String Question8AInput = "";
	private static String Question8BInput = "";
	private static String Question8CInput = "";
	private static String Question8DInput = "";
	
	private static String Question9Input = "";
	private static String Question10Input = "";
	
	private static String Question1CorrectAnswer = "";
	private static String Question2CorrectAnswer = "";
	private static String Question3CorrectAnswer = "";
	private static String Question4CorrectAnswer = "";
	private static String Question5CorrectAnswer = "";
	private static String Question6CorrectAnswer = "";
	private static String Question7CorrectAnswer = "";
	private static String Question8CorrectAnswer = "";
	private static String Question9CorrectAnswer = "";
	private static String Question10CorrectAnswer = "";
	
	private static Boolean Question1Submitted = false;
	private static Boolean Question2Submitted = false;
	private static Boolean Question3Submitted = false;
	private static Boolean Question4Submitted = false;
	private static Boolean Question5Submitted = false;
	private static Boolean Question6Submitted = false;
	private static Boolean Question7Submitted = false;
	private static Boolean Question8Submitted = false;
	private static Boolean Question9Submitted = false;
	private static Boolean Question10Submitted = false;
	
	private static Boolean Check = true;
	
	//------New Colours
	public static final Color NEW_GREEN = new Color(212, 255, 238);
	public static final Color DARK_GREY = new Color(102,102,102);
	public static final Color WRONG_RED = new Color(251, 255, 250);
	public static final Color TRUE = new Color(66, 135, 245);
	public static final Color FALSE = new Color(247, 69, 25);

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
		START,
		EASY,
		MEDIUM,
		HARD,
		INSANE,
		PREVIOUS,
		NEXT,
		Q1A1,
		Q1A2,
		Q1A3,
		Q1A4,
		Q2A1,
		Q2A2,
		Q2A3,
		Q2A4,
		Q7A1,
		Q7A2,
		Q7A3,
		Q7A4,
		Q8A1,
		Q8A2,
		Q8A3,
		Q8A4,
		TRUETOP,
		FALSETOP,
		TRUEBOTTOM,
		FALSEBOTTOM,
		RESULTS,
		RESET,
		QUIT
	}//End of Actions
	
	public static void GUI() {
		instance = new Quiz();
		String[] optionsToChoose = { "Choose Dimensions", "$5 | 4x6", "$7 | 6x8", "$10 | 8x10", "$15 | 12x17"};
		String[] optionsToChoose2 = { "Choose City", "Barrie", "Belleville", "Cambridge"};
		//Panel Config
		pnl_panel = new JPanel();
		pnl_panel.setBackground(NEW_GREEN);
		pnl_panel.setLayout(null);
		pnl_panel.setBorder(FrameBorder);
				
		//Frame Config
		fr_frame = new JFrame();
		fr_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr_frame.add(pnl_panel);
		fr_frame.setSize(1152, 720);
		fr_frame.setLocationRelativeTo(null);
		fr_frame.setBackground(DARK_GREY);
	
		//----All Things Images
		BufferedCodeBackground = null;
		BufferedJava = null;
		try
		{//Beginning of try
			BufferedCodeBackground = ImageIO.read(new File("JavaCode.jpg"));
			BufferedJava = ImageIO.read(new File("JavaLogo.jpg"));
		}//End of try
		catch (IOException e)
		{//Beginning of catch
			e.printStackTrace();
		}//End of catch
		//Creates Scaled Instances of Images
		ImageCodeBackground = BufferedCodeBackground.getScaledInstance(1224, 816, 100);
		ImageJava = BufferedJava.getScaledInstance(1224, 816, 100);
				
		//Creates image icons
		icn_CodeBackground = new ImageIcon(ImageCodeBackground);
		icn_Java = new ImageIcon(ImageJava);
		
		//-----------Creating GUI Objects
		//Labels
		lbl_TitleLabel = new JLabel(str_Difficulty  + "Java Quiz!");
		lbl_TitleLabel.setBounds(0,10,1152,70);
		pnl_panel.add(lbl_TitleLabel);
		lbl_TitleLabel.setHorizontalAlignment(JLabel.CENTER);
		lbl_TitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
		
		lbl_Name = new JLabel("Question 0:  What is your name?");
		lbl_Name.setBounds(40,75,1100,70);
		pnl_panel.add(lbl_Name);
		lbl_Name.setFont(new Font("Times New Roman", Font.BOLD, 32));
		
		lbl_Score = new JLabel(number.format(Score) + " /10");
		lbl_Score.setBounds(970,10,1100,70);
		pnl_panel.add(lbl_Score);
		lbl_Score.setFont(new Font("Times New Roman", Font.BOLD, 72));
		
		lbl_Question1Title = new JLabel("Question 1: " + Question1);
		lbl_Question1Title.setBounds(40,130,1100,40);
		pnl_panel.add(lbl_Question1Title);
		lbl_Question1Title.setFont(new Font("Times New Roman", Font.BOLD, 32));
		
		lbl_Question2Title = new JLabel("Question 2: " + Question2);
		lbl_Question2Title.setBounds(40,380,1100,40);
		pnl_panel.add(lbl_Question2Title);
		lbl_Question2Title.setFont(new Font("Times New Roman", Font.BOLD, 32));
		
		lbl_Question3Title = new JLabel("Question 3: " + Question3);
		lbl_Question3Title.setBounds(40,130,1100,40);
		pnl_panel.add(lbl_Question3Title);
		lbl_Question3Title.setFont(new Font("Times New Roman", Font.BOLD, 32));
		
		lbl_Question4Title = new JLabel("Question 4: " + Question4);
		lbl_Question4Title.setBounds(40,380,1100,40);
		pnl_panel.add(lbl_Question4Title);
		lbl_Question4Title.setFont(new Font("Times New Roman", Font.BOLD, 32));
		
		lbl_Question5Title = new JLabel("Question 5: " + Question5);
		lbl_Question5Title.setBounds(40,130,1100,40);
		pnl_panel.add(lbl_Question5Title);
		lbl_Question5Title.setFont(new Font("Times New Roman", Font.BOLD, 32));
		
		lbl_Question6Title = new JLabel("Question 6: " + Question6);
		lbl_Question6Title.setBounds(40,380,1100,40);
		pnl_panel.add(lbl_Question6Title);
		lbl_Question6Title.setFont(new Font("Times New Roman", Font.BOLD, 32));
		
		lbl_Question7Title = new JLabel("Question 7: " + Question7);
		lbl_Question7Title.setBounds(40,130,1100,40);
		pnl_panel.add(lbl_Question7Title);
		lbl_Question7Title.setFont(new Font("Times New Roman", Font.BOLD, 32));
		
		lbl_Question8Title = new JLabel("Question 8: " + Question8);
		lbl_Question8Title.setBounds(40,380,1100,40);
		pnl_panel.add(lbl_Question8Title);
		lbl_Question8Title.setFont(new Font("Times New Roman", Font.BOLD, 32));
		
		lbl_Question9Title = new JLabel("Question 9: " + Question9);
		lbl_Question9Title.setBounds(40,130,1100,40);
		pnl_panel.add(lbl_Question9Title);
		lbl_Question9Title.setFont(new Font("Times New Roman", Font.BOLD, 32));
		
		lbl_Question10Title = new JLabel("Question 10: " + Question10);
		lbl_Question10Title.setBounds(40,380,1100,40);
		pnl_panel.add(lbl_Question10Title);
		lbl_Question10Title.setFont(new Font("Times New Roman", Font.BOLD, 32));
		
		//Separators
		sep_Title = new JSeparator();
		sep_Title.setBounds(0, 80, 1200, 25);
		pnl_panel.add(sep_Title);
		sep_Title.setForeground(DARK_GREY);
		
		//Radio Buttons
		//Difficulty
		rad_Easy = new JRadioButton("");    
		rad_Easy.setBounds(90,420,140,30);  
		rad_Easy.setActionCommand(Actions.EASY.name());
		rad_Easy.addActionListener(instance);
		pnl_panel.add(rad_Easy);
		
		rad_Medium = new JRadioButton("");      
		rad_Medium.setBounds(90,555,100,30);  
		rad_Medium.setActionCommand(Actions.MEDIUM.name());
		rad_Medium.addActionListener(instance);
		pnl_panel.add(rad_Medium);
		
		rad_Hard = new JRadioButton("");    
		rad_Hard.setBounds(670,420,140,30);  
		rad_Hard.setActionCommand(Actions.HARD.name());
		rad_Hard.addActionListener(instance);
		pnl_panel.add(rad_Hard);
		
		rad_Insane = new JRadioButton("");      
		rad_Insane.setBounds(670,555,100,30);  
		rad_Insane.setActionCommand(Actions.INSANE.name());
		rad_Insane.addActionListener(instance);
		pnl_panel.add(rad_Insane);
		
		bg_Difficulty = new ButtonGroup();    
		bg_Difficulty.add(rad_Easy);//adds Radio Button to Button Group
		bg_Difficulty.add(rad_Medium);//adds Radio Button to Button Group
		bg_Difficulty.add(rad_Hard);//adds Radio Button to Button Group
		bg_Difficulty.add(rad_Insane);//adds Radio Button to Button Group
		
		//Question 1
		rad_Q1AnswerA = new JRadioButton("");    
		rad_Q1AnswerA.setBounds(90,190,500,30);  
		rad_Q1AnswerA.setActionCommand(Actions.Q1A1.name());
		rad_Q1AnswerA.addActionListener(instance);
		pnl_panel.add(rad_Q1AnswerA);
		
		rad_Q1AnswerB = new JRadioButton("");      
		rad_Q1AnswerB.setBounds(90,300,500,30);  
		rad_Q1AnswerB.setActionCommand(Actions.Q1A2.name());
		rad_Q1AnswerB.addActionListener(instance);
		pnl_panel.add(rad_Q1AnswerB);
		
		rad_Q1AnswerC = new JRadioButton("");    
		rad_Q1AnswerC.setBounds(600,190,500,30);  
		rad_Q1AnswerC.setActionCommand(Actions.Q1A3.name());
		rad_Q1AnswerC.addActionListener(instance);
		pnl_panel.add(rad_Q1AnswerC);
		
		rad_Q1AnswerD = new JRadioButton("");      
		rad_Q1AnswerD.setBounds(600,300,500,30);  
		rad_Q1AnswerD.setActionCommand(Actions.Q1A4.name());
		rad_Q1AnswerD.addActionListener(instance);
		pnl_panel.add(rad_Q1AnswerD);
		
		bg_Question1 = new ButtonGroup();    
		bg_Question1.add(rad_Q1AnswerA);//adds Radio Button to Button Group
		bg_Question1.add(rad_Q1AnswerB);//adds Radio Button to Button Group
		bg_Question1.add(rad_Q1AnswerC);//adds Radio Button to Button Group
		bg_Question1.add(rad_Q1AnswerD);//adds Radio Button to Button Group
		
		//Question 2
		rad_Q2AnswerA = new JRadioButton("");    
		rad_Q2AnswerA.setBounds(90,445,500,30);  
		rad_Q2AnswerA.setActionCommand(Actions.Q2A1.name());
		rad_Q2AnswerA.addActionListener(instance);
		pnl_panel.add(rad_Q2AnswerA);
		
		rad_Q2AnswerB = new JRadioButton("");      
		rad_Q2AnswerB.setBounds(90,570,500,30);  
		rad_Q2AnswerB.setActionCommand(Actions.Q2A2.name());
		rad_Q2AnswerB.addActionListener(instance);
		pnl_panel.add(rad_Q2AnswerB);
		
		rad_Q2AnswerC = new JRadioButton("");    
		rad_Q2AnswerC.setBounds(600,445,500,30);  
		rad_Q2AnswerC.setActionCommand(Actions.Q2A3.name());
		rad_Q2AnswerC.addActionListener(instance);
		pnl_panel.add(rad_Q2AnswerC);
		
		rad_Q2AnswerD = new JRadioButton("");      
		rad_Q2AnswerD.setBounds(600,570,500,30);  
		rad_Q2AnswerD.setActionCommand(Actions.Q2A4.name());
		rad_Q2AnswerD.addActionListener(instance);
		pnl_panel.add(rad_Q2AnswerD);
		
		bg_Question2 = new ButtonGroup();    
		bg_Question2.add(rad_Q2AnswerA);//adds Radio Button to Button Group
		bg_Question2.add(rad_Q2AnswerB);//adds Radio Button to Button Group
		bg_Question2.add(rad_Q2AnswerC);//adds Radio Button to Button Group
		bg_Question2.add(rad_Q2AnswerD);//adds Radio Button to Button Group
		
		//Text Fields
		txt_Name = new JTextField(20);
		txt_Name.setBounds(500,95,150,30);
		pnl_panel.add(txt_Name);
		
		txt_Question5 = new JTextField(20);
		txt_Question5.setBounds(200,210,350,50);
		pnl_panel.add(txt_Question5);
		
		txt_Question6 = new JTextField(20);
		txt_Question6.setBounds(200,500,350,50);
		pnl_panel.add(txt_Question6);
		
		
		//Combo Boxes
		
		//Check Boxes
		chk_Q7AnswerA = new JCheckBox("");  
		chk_Q7AnswerA.setBounds(90,190,500,30); 
		chk_Q7AnswerA.setActionCommand(Actions.Q7A1.name());
		chk_Q7AnswerA.addActionListener(instance);
        pnl_panel.add(chk_Q7AnswerA); 
        
        chk_Q7AnswerB = new JCheckBox("");  
        chk_Q7AnswerB.setBounds(90,300,500,30);  
        chk_Q7AnswerB.setActionCommand(Actions.Q7A2.name());
        chk_Q7AnswerB.addActionListener(instance);
        pnl_panel.add(chk_Q7AnswerB); 
        
        chk_Q7AnswerC = new JCheckBox("");  
        chk_Q7AnswerC.setBounds(600,190,500,30);  
        chk_Q7AnswerC.setActionCommand(Actions.Q7A3.name());
        chk_Q7AnswerC.addActionListener(instance);
        pnl_panel.add(chk_Q7AnswerC);  
        
        chk_Q7AnswerD = new JCheckBox("");  
        chk_Q7AnswerD.setBounds(600,300,500,30);  
        chk_Q7AnswerD.setActionCommand(Actions.Q7A4.name());
        chk_Q7AnswerD.addActionListener(instance);
        pnl_panel.add(chk_Q7AnswerD);  
        
        chk_Q8AnswerA = new JCheckBox("");  
        chk_Q8AnswerA.setBounds(90,445,500,30);  
        chk_Q8AnswerA.setActionCommand(Actions.Q8A1.name());
        chk_Q8AnswerA.addActionListener(instance);
        pnl_panel.add(chk_Q8AnswerA); 
        
        chk_Q8AnswerB = new JCheckBox("");  
        chk_Q8AnswerB.setBounds(90,570,500,30);  
        chk_Q8AnswerB.setActionCommand(Actions.Q8A2.name());
        chk_Q8AnswerB.addActionListener(instance);
        pnl_panel.add(chk_Q8AnswerB); 
        
        chk_Q8AnswerC = new JCheckBox("");  
        chk_Q8AnswerC.setBounds(600,445,500,30);   
        chk_Q8AnswerC.setActionCommand(Actions.Q8A3.name());
        chk_Q8AnswerC.addActionListener(instance);
        pnl_panel.add(chk_Q8AnswerC);  
        
        chk_Q8AnswerD = new JCheckBox("");  
        chk_Q8AnswerD.setBounds(600,570,500,30);  
        chk_Q8AnswerD.setActionCommand(Actions.Q8A4.name());
        chk_Q8AnswerD.addActionListener(instance);
        pnl_panel.add(chk_Q8AnswerD);
	
		//Text Areas 
		
		//Buttons
		btn_Start = new JButton("Start");
		btn_Start.setBounds(350, 630, 400, 50);
		btn_Start.setActionCommand(Actions.START.name());
		btn_Start.addActionListener(instance);
		pnl_panel.add(btn_Start);
		btn_Start.setEnabled(false);
		
		btn_Quit = new JButton("Quit");
		btn_Quit.setBounds(20, 25, 80, 25);
		btn_Quit.setActionCommand(Actions.QUIT.name());
		btn_Quit.addActionListener(instance);
		pnl_panel.add(btn_Quit);
		
		btn_Reset = new JButton("Reset");
		btn_Reset.setBounds(100, 25, 80, 25);
		btn_Reset.setActionCommand(Actions.RESET.name());
		btn_Reset.addActionListener(instance);
		pnl_panel.add(btn_Reset);
		
		btn_Previous = new JButton("Previous");
		btn_Previous.setBounds(290, 15, 80, 60);
		btn_Previous.setActionCommand(Actions.PREVIOUS.name());
		btn_Previous.addActionListener(instance);
		pnl_panel.add(btn_Previous);
		
		btn_Next = new JButton("Next");
		btn_Next.setBounds(785, 15, 80, 60);
		btn_Next.setActionCommand(Actions.NEXT.name());
		btn_Next.addActionListener(instance);
		pnl_panel.add(btn_Next);
		
		btn_TrueTop = new JButton("True");
		btn_TrueTop.setBounds(120, 190, 350, 180);
		btn_TrueTop.setActionCommand(Actions.TRUETOP.name());
		btn_TrueTop.addActionListener(instance);
		pnl_panel.add(btn_TrueTop);
		btn_TrueTop.setForeground(TRUE);
		btn_TrueTop.setFont(new Font("", Font.BOLD, 46));
		
		btn_FalseTop = new JButton("False");
		btn_FalseTop.setBounds(560, 190, 350, 180);
		btn_FalseTop.setActionCommand(Actions.FALSETOP.name());
		btn_FalseTop.addActionListener(instance);
		pnl_panel.add(btn_FalseTop);
		btn_FalseTop.setForeground(FALSE);
		btn_FalseTop.setFont(new Font("", Font.BOLD, 46));
		
		btn_TrueBottom = new JButton("True");
		btn_TrueBottom.setBounds(120, 460, 350, 180);
		btn_TrueBottom.setActionCommand(Actions.TRUEBOTTOM.name());
		btn_TrueBottom.addActionListener(instance);
		pnl_panel.add(btn_TrueBottom);
		btn_TrueBottom.setForeground(TRUE);
		btn_TrueBottom.setFont(new Font("", Font.BOLD, 46));
		
		btn_FalseBottom = new JButton("False");
		btn_FalseBottom.setBounds(560, 460, 350, 180);
		btn_FalseBottom.setActionCommand(Actions.FALSEBOTTOM.name());
		btn_FalseBottom.addActionListener(instance);
		pnl_panel.add(btn_FalseBottom);
		btn_FalseBottom.setForeground(FALSE);
		btn_FalseBottom.setFont(new Font("", Font.BOLD, 46));
		
		//Images(Labels)	
		img_CodeBackground = new JLabel(icn_CodeBackground);
		img_CodeBackground.setBounds(0,0,1224,816);
		pnl_panel.add(img_CodeBackground);				

		img_Java = new JLabel(icn_Java);
		img_Java.setBounds(0,0,1224,816);
		pnl_panel.add(img_Java);				

		//Frame config
		fr_frame.setVisible(true);
		fr_frame.setTitle("Grade 11 Computer Studies Quiz!");
		StartPage();
	}
	public static void StartPage() {
		img_CodeBackground.setVisible(true);
		img_Java.setVisible(true);
		rad_Easy.setVisible(true);
		rad_Medium.setVisible(true);
		rad_Hard.setVisible(true);
		rad_Insane.setVisible(true);
		btn_Start.setVisible(true);
		lbl_TitleLabel.setVisible(false);
		lbl_Score.setVisible(false);
		lbl_Question1Title.setVisible(false);
		rad_Q1AnswerA.setVisible(false);
		rad_Q1AnswerB.setVisible(false);
		rad_Q1AnswerC.setVisible(false);
		rad_Q1AnswerD.setVisible(false);
		rad_Q2AnswerA.setVisible(false);
		rad_Q2AnswerB.setVisible(false);
		rad_Q2AnswerC.setVisible(false);
		rad_Q2AnswerD.setVisible(false);
		lbl_Name.setVisible(false);
		lbl_Question2Title.setVisible(false);
		lbl_Question3Title.setVisible(false);
		lbl_Question4Title.setVisible(false);
		lbl_Question5Title.setVisible(false);
		lbl_Question6Title.setVisible(false);
		lbl_Question7Title.setVisible(false);
		lbl_Question8Title.setVisible(false);
		lbl_Question9Title.setVisible(false);
		lbl_Question10Title.setVisible(false);
		sep_Title.setVisible(false);
		btn_Quit.setVisible(false);
		btn_Next.setVisible(false);
		btn_TrueTop.setVisible(false);
		btn_FalseTop.setVisible(false);
		btn_TrueBottom.setVisible(false);
		btn_FalseBottom.setVisible(false);
		btn_Previous.setVisible(false);
		btn_Reset.setVisible(false);
		txt_Name.setVisible(false);
		txt_Question5.setVisible(false);
		txt_Question6.setVisible(false);
		chk_Q7AnswerA.setVisible(false);
		chk_Q7AnswerB.setVisible(false);
		chk_Q7AnswerC.setVisible(false);
		chk_Q7AnswerD.setVisible(false);
		chk_Q8AnswerA.setVisible(false);
		chk_Q8AnswerB.setVisible(false);
		chk_Q8AnswerC.setVisible(false);
		chk_Q8AnswerD.setVisible(false);
		
		btn_Next.setEnabled(false);
		bg_Difficulty.clearSelection();
	}
	public static void QuestionPage1() {
		rad_Easy.setVisible(false);
		rad_Medium.setVisible(false);
		rad_Hard.setVisible(false);
		rad_Insane.setVisible(false);
		img_CodeBackground.setVisible(false);
		btn_Start.setVisible(false);
		btn_Previous.setVisible(false);
		lbl_Question3Title.setVisible(false);
		lbl_Question4Title.setVisible(false);
		btn_TrueTop.setVisible(false);
		btn_FalseTop.setVisible(false);
		btn_TrueBottom.setVisible(false);
		btn_FalseBottom.setVisible(false);
		
		img_Java.setVisible(true);
		lbl_TitleLabel.setVisible(true);
		lbl_Score.setVisible(true);
		lbl_Name.setVisible(true);
		sep_Title.setVisible(true);
		btn_Quit.setVisible(true);
		btn_Next.setVisible(true);
		btn_Reset.setVisible(true);
		lbl_Question1Title.setVisible(true);
		rad_Q1AnswerA.setVisible(true);
		rad_Q1AnswerB.setVisible(true);
		rad_Q1AnswerC.setVisible(true);
		rad_Q1AnswerD.setVisible(true);
		rad_Q2AnswerA.setVisible(true);
		rad_Q2AnswerB.setVisible(true);
		rad_Q2AnswerC.setVisible(true);
		rad_Q2AnswerD.setVisible(true);
		lbl_Question2Title.setVisible(true);
		txt_Name.setVisible(true);
		
		btn_Next.setEnabled(false);
		
		if(Question1Submitted == true){
			btn_Next.setEnabled(true);
		}
	}
	public static void QuestionPage2() {
		btn_Previous.setVisible(true);
		lbl_Question3Title.setVisible(true);
		lbl_Question4Title.setVisible(true);
		btn_TrueTop.setVisible(true);
		btn_FalseTop.setVisible(true);
		btn_TrueBottom.setVisible(true);
		btn_FalseBottom.setVisible(true);
		
		lbl_Name.setVisible(false);
		lbl_Question1Title.setVisible(false);
		rad_Q1AnswerA.setVisible(false);
		rad_Q1AnswerB.setVisible(false);
		rad_Q1AnswerC.setVisible(false);
		rad_Q1AnswerD.setVisible(false);
		rad_Q2AnswerA.setVisible(false);
		rad_Q2AnswerB.setVisible(false);
		rad_Q2AnswerC.setVisible(false);
		rad_Q2AnswerD.setVisible(false);
		lbl_Question2Title.setVisible(false);
		lbl_Question5Title.setVisible(false);
		lbl_Question6Title.setVisible(false);
		lbl_Question7Title.setVisible(false);
		lbl_Question8Title.setVisible(false);
		lbl_Question9Title.setVisible(false);
		lbl_Question10Title.setVisible(false);
		txt_Name.setVisible(false);
		txt_Question5.setVisible(false);
		txt_Question6.setVisible(false);
		
		btn_Next.setEnabled(false);
		
		if(Question3Submitted == true){
			btn_Next.setEnabled(true);
		}
	}
	public static void QuestionPage3() {
		lbl_Question5Title.setVisible(true);
		lbl_Question6Title.setVisible(true);
		
		txt_Question5.setVisible(true);
		txt_Question6.setVisible(true);
		
		lbl_Question1Title.setVisible(false);
		lbl_Question2Title.setVisible(false);
		lbl_Question3Title.setVisible(false);
		lbl_Question4Title.setVisible(false);
		lbl_Question7Title.setVisible(false);
		lbl_Question8Title.setVisible(false);
		lbl_Question9Title.setVisible(false);
		lbl_Question10Title.setVisible(false);
		
		btn_TrueTop.setVisible(false);
		btn_FalseTop.setVisible(false);
		btn_TrueBottom.setVisible(false);
		btn_FalseBottom.setVisible(false);
		
		chk_Q7AnswerA.setVisible(false);
		chk_Q7AnswerB.setVisible(false);
		chk_Q7AnswerC.setVisible(false);
		chk_Q7AnswerD.setVisible(false);
		chk_Q8AnswerA.setVisible(false);
		chk_Q8AnswerB.setVisible(false);
		chk_Q8AnswerC.setVisible(false);
		chk_Q8AnswerD.setVisible(false);
		
		if(Question5Submitted == false) {
			btn_Next.setEnabled(false);
		}
		System.out.println("");
		System.out.println(Question5Submitted);
	}
	public static void QuestionPage4() {
		lbl_Question7Title.setVisible(true);
		lbl_Question8Title.setVisible(true);
		
		lbl_Question1Title.setVisible(false);
		lbl_Question2Title.setVisible(false);
		lbl_Question3Title.setVisible(false);
		lbl_Question4Title.setVisible(false);
		lbl_Question5Title.setVisible(false);
		lbl_Question6Title.setVisible(false);
		lbl_Question9Title.setVisible(false);
		lbl_Question10Title.setVisible(false);
		txt_Question5.setVisible(false);
		txt_Question6.setVisible(false);
		
		chk_Q7AnswerA.setVisible(true);
		chk_Q7AnswerB.setVisible(true);
		chk_Q7AnswerC.setVisible(true);
		chk_Q7AnswerD.setVisible(true);
		chk_Q8AnswerA.setVisible(true);
		chk_Q8AnswerB.setVisible(true);
		chk_Q8AnswerC.setVisible(true);
		chk_Q8AnswerD.setVisible(true);
		
		if(Question7Submitted == false) {
			btn_Next.setEnabled(false);
		}
	}
	public static void QuestionPage5() {
		lbl_Question9Title.setVisible(true);
		lbl_Question10Title.setVisible(true);
		
		lbl_Question1Title.setVisible(false);
		lbl_Question2Title.setVisible(false);
		lbl_Question3Title.setVisible(false);
		lbl_Question4Title.setVisible(false);
		lbl_Question5Title.setVisible(false);
		lbl_Question6Title.setVisible(false);
		lbl_Question7Title.setVisible(false);
		lbl_Question8Title.setVisible(false);
		
		chk_Q7AnswerA.setVisible(false);
		chk_Q7AnswerB.setVisible(false);
		chk_Q7AnswerC.setVisible(false);
		chk_Q7AnswerD.setVisible(false);
		chk_Q8AnswerA.setVisible(false);
		chk_Q8AnswerB.setVisible(false);
		chk_Q8AnswerC.setVisible(false);
		chk_Q8AnswerD.setVisible(false);
	}
	public static void Results() {
		
	}
	public static void main(String[] args) {
		GUI();
		while(Check = true) 
		{//Beginning of while
			try
			{//Beginning of try
				//Make invisble while waiting for input
				Thread.sleep(10);
			}//End of try
			catch (InterruptedException e) 
			{//Beginning of catch
				e.printStackTrace();
			}//End of catch
			Question5Input = txt_Question5.getText();
			Question6Input = txt_Question6.getText();
			if(Question5Submitted == false) {
				if(!Question5Input.equals("") && !Question6Input.equals("")){
					btn_Next.setEnabled(true);
				}
			}
			else if(lbl_Question5Title.isVisible()) {
				if(!Question5Input.equals("") && !Question6Input.equals("")){
					btn_Next.setEnabled(true);
				}
			}
		}//End of while
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == Actions.START.name())
		{//Beginning of if
			QuestionPage1();
			dbl_Page += 1;
			System.out.println(dbl_Page);
		}//End ofif
		else if (e.getActionCommand() == Actions.EASY.name())
		{//Beginning of else if
			btn_Previous.setBounds(290, 15, 80, 60);
			btn_Next.setBounds(785, 15, 80, 60);
			
			Question1 = "	'.setVisible' does what?";
			Question2 = "	'.setText' does what?";
			Question3 = "	True or False: A multiple line comment starts with //";
			Question4 = "	True or False: An 'int' Data Type can have up to 7 decimals";
			Question5 = "	What is the proper naming convention for a TextField";
			Question6 = "	System.out.println(\"Hello World\"); will output:";
			Question7 = "	What are the benifits of a ComboBox input type";
			Question8 = "	Why is Java useful?";
			Question9 = "	= does what";
			Question10 = "	 Variable means what?";
			
			rad_Q1AnswerA.setText("Determines wether or not a object is visible or not"); 
			rad_Q1AnswerB.setText("Determines wether or not a object is on the panel"); 
			rad_Q1AnswerC.setText("If set to false the object is deleted"); 
			rad_Q1AnswerD.setText("Creates a new panel");
			
			rad_Q2AnswerA.setText("Changes the opacity of the text"); 
			rad_Q2AnswerB.setText("Changes wether or not the object shows text"); 
			rad_Q2AnswerC.setText("Sets the text of a desired object"); 
			rad_Q2AnswerD.setText("Changes the text of a desired variable");
			
			chk_Q7AnswerA.setText("A compact list of choices");
			chk_Q7AnswerB.setText("Hidden until the dropdown is clicked");
			chk_Q7AnswerC.setText("Gives you the ability to enter a value that is not in the list");
			chk_Q7AnswerD.setText("Gives you the ability to create variables");
			
			chk_Q8AnswerA.setText("Easy to write");
			chk_Q8AnswerB.setText("Compilled to Binaries");// This is C++
			chk_Q8AnswerC.setText("Reusable code");
			chk_Q8AnswerD.setText("Widespread and Relevant");
			
			Question1CorrectAnswer = "A";
			Question2CorrectAnswer = "C";
			Question3CorrectAnswer = "False";
			Question4CorrectAnswer = "False";
			Question5CorrectAnswer = "txt";
			Question6CorrectAnswer = "Hello World";
			Question7CorrectAnswer = "A,B,C";
			Question8CorrectAnswer = "A,C,D";
			Question9CorrectAnswer = "";
			Question10CorrectAnswer = "";
			
			ScoreCheck = "Easy";
			str_Difficulty = "Easy";
			btn_Start.setEnabled(true);
			lbl_TitleLabel.setText(str_Difficulty  + " Java Quiz!");
			lbl_Question1Title.setText("Question 1: " + Question1);
			lbl_Question2Title.setText("Question 2: " + Question2);
			lbl_Question3Title.setText("Question 3: " + Question3);
			lbl_Question4Title.setText("Question 4: " + Question4);
			lbl_Question5Title.setText("Question 5: " + Question5);
			lbl_Question6Title.setText("Question 6: " + Question6);
			lbl_Question7Title.setText("Question 7: " + Question7);
			lbl_Question8Title.setText("Question 8: " + Question8);
			lbl_Question9Title.setText("Question 9: " + Question9);
			lbl_Question10Title.setText("Question 10: " + Question10);
		}//End of else if
		else if (e.getActionCommand() == Actions.MEDIUM.name())
		{//Beginning of else if
			btn_Previous.setBounds(280, 15, 80, 60);
			btn_Next.setBounds(795, 15, 80, 60);
			
			Question1 = "	'.setEnabled' does what?";
			Question2 = "	Java was invented by";
			Question3 = "	True or False: The identifier for a char is \"a\"";
			Question4 = "	True or False: Java is an object-oriented language";
			Question5 = "	What is the proper naming convention for a ComboBox";
			Question6 = "	double Number = 5; System.out.println(Number); will output:";
			Question7 = "	! Usually means what";
			Question8 = "	What are some datatypes that can be created as Variables";
			Question9 = "	+= does what?";
			Question10 = "	 Concatenation in java means what";
			
			rad_Q1AnswerA.setText("Determines wether or not a object is visible or not"); 
			rad_Q1AnswerB.setText("Determines wether or not a object is enabled / interactable"); 
			rad_Q1AnswerC.setText("Allows the computer to access your local wifi"); 
			rad_Q1AnswerD.setText("Enables the frame");
			
			rad_Q2AnswerA.setText("Bill Joy"); 
			rad_Q2AnswerB.setText("James Gosling"); 
			rad_Q2AnswerC.setText("Bill Gates"); 
			rad_Q2AnswerD.setText("Isaac Newton");
			
			chk_Q7AnswerA.setText("Is");
			chk_Q7AnswerB.setText("Is not");
			chk_Q7AnswerC.setText("Can");
			chk_Q7AnswerD.setText("Can not");
			
			chk_Q8AnswerA.setText("Boolean");
			chk_Q8AnswerB.setText("Integer");
			chk_Q8AnswerC.setText("Triple");
			chk_Q8AnswerD.setText("Double");
			
			Question1CorrectAnswer = "B";
			Question2CorrectAnswer = "B";
			Question3CorrectAnswer = "False";
			Question4CorrectAnswer = "True";
			Question5CorrectAnswer = "cbo";
			Question6CorrectAnswer = "5";
			Question7CorrectAnswer = "B";
			Question8CorrectAnswer = "A,B,D";
			Question9CorrectAnswer = "";
			Question10CorrectAnswer = "";
			
			ScoreCheck = "Medium";
			str_Difficulty = "Medium";
			btn_Start.setEnabled(true);
			lbl_TitleLabel.setText(str_Difficulty  + " Java Quiz!");
			lbl_Question1Title.setText("Question 1: " + Question1);
			lbl_Question2Title.setText("Question 2: " + Question2);
			lbl_Question3Title.setText("Question 3: " + Question3);
			lbl_Question4Title.setText("Question 4: " + Question4);
			lbl_Question5Title.setText("Question 5: " + Question5);
			lbl_Question6Title.setText("Question 6: " + Question6);
			lbl_Question7Title.setText("Question 7: " + Question7);
			lbl_Question8Title.setText("Question 8: " + Question8);
			lbl_Question9Title.setText("Question 9: " + Question9);
			lbl_Question10Title.setText("Question 10: " + Question10);
		}//End of else if
		else if (e.getActionCommand() == Actions.HARD.name())
		{//Beginning of else if
			btn_Previous.setBounds(290, 15, 80, 60);
			btn_Next.setBounds(785, 15, 80, 60);
			
			Question1 = "	'.setSelected()' is used to reset a";
			Question2 = "	'.clearSelection' is used for";
			Question3 = "	True or False: The identifier for a float is 3.14f";
			Question4 = "	True or False: 'final int' is used to create a constant variable";
			Question5 = "	JRE stands for what?";
			Question6 = "	double Price = 5; System.out.println(\"Price:  \"+Price); Outputs";
			Question7 = "	&& Does what";
			Question8 = "	For Loops include";
			Question9 = "	-= does what";
			Question10 = "	 HI";
			
			rad_Q1AnswerA.setText("Text Area"); 
			rad_Q1AnswerB.setText("Radio Button"); 
			rad_Q1AnswerC.setText("Check Boxes"); 
			rad_Q1AnswerD.setText("Combo Boxes");
			
			rad_Q2AnswerA.setText("Radio Buttons"); 
			rad_Q2AnswerB.setText("Combo Boxes"); 
			rad_Q2AnswerC.setText("Check Boxes"); 
			rad_Q2AnswerD.setText("Buttons");
			
			chk_Q7AnswerA.setText("And");
			chk_Q7AnswerB.setText("Or");
			chk_Q7AnswerC.setText("Next");
			chk_Q7AnswerD.setText("For");
			
			chk_Q8AnswerA.setText("Initialization");
			chk_Q8AnswerB.setText("Representation");
			chk_Q8AnswerC.setText("Termination");
			chk_Q8AnswerD.setText("Increment");
			
			Question1CorrectAnswer = "C";
			Question2CorrectAnswer = "A";
			Question3CorrectAnswer = "True";
			Question4CorrectAnswer = "True";
			Question5CorrectAnswer = "";
			Question6CorrectAnswer = "";
			Question7CorrectAnswer = "A";
			Question8CorrectAnswer = "A,C,D";
			Question9CorrectAnswer = "";
			Question10CorrectAnswer = "";
			
			ScoreCheck = "Hard";
			str_Difficulty = "Hard";
			btn_Start.setEnabled(true);
			lbl_TitleLabel.setText(str_Difficulty  + " Java Quiz!");
			lbl_Question1Title.setText("Question 1: " + Question1);
			lbl_Question2Title.setText("Question 2: " + Question2);
			lbl_Question3Title.setText("Question 3: " + Question3);
			lbl_Question4Title.setText("Question 4: " + Question4);
			lbl_Question5Title.setText("Question 5: " + Question5);
			lbl_Question6Title.setText("Question 6: " + Question6);
			lbl_Question7Title.setText("Question 7: " + Question7);
			lbl_Question8Title.setText("Question 8: " + Question8);
			lbl_Question9Title.setText("Question 9: " + Question9);
			lbl_Question10Title.setText("Question 10: " + Question10);
		}//End of else if
		else if (e.getActionCommand() == Actions.INSANE.name())
		{//Beginning of else if
			btn_Previous.setBounds(290, 15, 80, 60);
			btn_Next.setBounds(785, 15, 80, 60);
			
			Question1 = "	.setSelectedIndex(0) is used to reset a";
			Question2 = "	An exclamation in Java usually means";
			Question3 = "	True or False: An identifier for boolean exists";
			Question4 = "	True or False: In 2022 Java is the common coding language";
			Question5 = "	What is the Latest version of Java in 2022";
			Question6 = "	What year was Java created?";
			Question7 = "	|| does what";
			Question8 = "	What is the difference of System.out.println from System.out.print";
			Question9 = "	 == does what";
			Question10 = "	 HI";
			
			rad_Q1AnswerA.setText("Text Area"); 
			rad_Q1AnswerB.setText("Radio Button"); 
			rad_Q1AnswerC.setText("Check Boxes"); 
			rad_Q1AnswerD.setText("Combo Boxes");
			
			rad_Q2AnswerA.setText("Error"); 
			rad_Q2AnswerB.setText("Is not"); 
			rad_Q2AnswerC.setText("Is"); 
			rad_Q2AnswerD.setText("Caution");
			
			chk_Q7AnswerA.setText("And");
			chk_Q7AnswerB.setText("Or");
			chk_Q7AnswerC.setText("Next");
			chk_Q7AnswerD.setText("For");
			
			chk_Q8AnswerA.setText("Prints a line on a GUI");
			chk_Q8AnswerB.setText("Prints a line on a Piece of Paper");
			chk_Q8AnswerC.setText("Prints a line");
			chk_Q8AnswerD.setText("Prints a line and brings the cursor to the next line");
			
			Question1CorrectAnswer = "Combo Boxes";
			Question2CorrectAnswer = "Is not";
			Question3CorrectAnswer = "False";
			Question4CorrectAnswer = "True";
			Question5CorrectAnswer = "";
			Question6CorrectAnswer = "";
			Question7CorrectAnswer = "B";
			Question8CorrectAnswer = "D";
			Question9CorrectAnswer = "";
			Question10CorrectAnswer = "";
			
			ScoreCheck = "Insane";
			str_Difficulty = "Insane";
			btn_Start.setEnabled(true);
			lbl_TitleLabel.setText(str_Difficulty  + " Java Quiz!");
			lbl_Question1Title.setText("Question 1: " + Question1);
			lbl_Question2Title.setText("Question 2: " + Question2);
			lbl_Question3Title.setText("Question 3: " + Question3);
			lbl_Question4Title.setText("Question 4: " + Question4);
			lbl_Question5Title.setText("Question 5: " + Question5);
			lbl_Question6Title.setText("Question 6: " + Question6);
			lbl_Question7Title.setText("Question 7: " + Question7);
			lbl_Question8Title.setText("Question 8: " + Question8);
			lbl_Question9Title.setText("Question 9: " + Question9);
			lbl_Question10Title.setText("Question 10: " + Question10);
		}//End of else if
		else if (e.getActionCommand() == Actions.Q1A1.name())
		{//Beginning of else if
			Question1Input = "A";
			if(Question1Submitted == false) {
				if(Question1Input != "" && Question2Input != "") {
					btn_Next.setEnabled(true);
				}
			}
		}//End of else if
		else if (e.getActionCommand() == Actions.Q1A2.name())
		{//Beginning of else if
			Question1Input = "B";
			if(Question1Submitted == false) {
				if(Question1Input != "" && Question2Input != "") {
					btn_Next.setEnabled(true);
				}
			}
		}//End of else if
		else if (e.getActionCommand() == Actions.Q1A3.name())
		{//Beginning of else if
			Question1Input = "C";
			if(Question1Submitted == false) {
				if(Question1Input != "" && Question2Input != "") {
					btn_Next.setEnabled(true);
				}
			}
		}//End of else if
		else if (e.getActionCommand() == Actions.Q1A4.name())
		{//Beginning of else if
			Question1Input = "D";
			if(Question1Submitted == false) {
				if(Question1Input != "" && Question2Input != "") {
					btn_Next.setEnabled(true);
				}
			}
		}//End of else if
		else if (e.getActionCommand() == Actions.Q2A1.name())
		{//Beginning of else if
			Question2Input = "A";
			if(Question1Submitted == false) {
				if(Question1Input != "" && Question2Input != "") {
					btn_Next.setEnabled(true);
				}
			}
		}//End of else if
		else if (e.getActionCommand() == Actions.Q2A2.name())
		{//Beginning of else if
			Question2Input = "B";
			if(Question1Submitted == false) {
				if(Question1Input != "" && Question2Input != "") {
					btn_Next.setEnabled(true);
				}
			}
		}//End of else if
		else if (e.getActionCommand() == Actions.Q2A3.name())
		{//Beginning of else if
			Question2Input = "C";
			if(Question1Submitted == false) {
				if(Question1Input != "" && Question2Input != "") {
					btn_Next.setEnabled(true);
				}
			}
		}//End of else if
		else if (e.getActionCommand() == Actions.Q2A4.name())
		{//Beginning of else if
			Question2Input = "D";
			if(Question1Submitted == false) {
				if(Question1Input != "" && Question2Input != "") {
					btn_Next.setEnabled(true);
				}
			}
		}//End of else if
		else if (e.getActionCommand() == Actions.Q7A1.name())
		{//Beginning of else if
			Question7AInput = "A";
			if(Question7Submitted == false) {
				if(Question7Input != "" && Question8Input != "") {
					btn_Next.setEnabled(true);
				}
			}
		}//End of else if
		else if (e.getActionCommand() == Actions.Q7A2.name())
		{//Beginning of else if
			Question7BInput = "B";
			if(Question7Submitted == false) {
				if(Question7Input != "" && Question8Input != "") {
					btn_Next.setEnabled(true);
				}
			}
		}//End of else if
		else if (e.getActionCommand() == Actions.Q7A3.name())
		{//Beginning of else if
			Question7CInput = "C";
			if(Question7Submitted == false) {
				if(Question7Input != "" && Question8Input != "") {
					btn_Next.setEnabled(true);
				}
			}
		}//End of else if
		else if (e.getActionCommand() == Actions.Q7A4.name())
		{//Beginning of else if
			Question7DInput = "D";
			if(Question7Submitted == false) {
				if(Question7Input != "" && Question8Input != "") {
					btn_Next.setEnabled(true);
				}
			}
		}//End of else if
		else if (e.getActionCommand() == Actions.Q8A1.name())
		{//Beginning of else if
			Question8AInput = "A";
			if(Question7Submitted == false) {
				if(Question7Input != "" && Question8Input != "") {
					btn_Next.setEnabled(true);
				}
			}
		}//End of else if
		else if (e.getActionCommand() == Actions.Q8A2.name())
		{//Beginning of else if
			Question8BInput = "B";
			if(Question7Submitted == false) {
				if(Question7Input != "" && Question8Input != "") {
					btn_Next.setEnabled(true);
				}
			}
		}//End of else if
		else if (e.getActionCommand() == Actions.Q8A3.name())
		{//Beginning of else if
			Question8CInput = "C";
			if(Question7Submitted == false) {
				if(Question7Input != "" && Question8Input != "") {
					btn_Next.setEnabled(true);
				}
			}
		}//End of else if
		else if (e.getActionCommand() == Actions.Q8A4.name())
		{//Beginning of else if
			Question8DInput = "D";
			if(Question7Submitted == false) {
				if(Question7Input != "" && Question8Input != "") {
					btn_Next.setEnabled(true);
				}
			}
		}//End of else if
		else if (e.getActionCommand() == Actions.TRUETOP.name())
		{//Beginning of else if
			Question3Input = "True";
			System.out.println(Question3Submitted);
			if(Question3Submitted == false) {
				if(Question3Input != "" && Question4Input != "") {
					btn_Next.setEnabled(true);
				}
			}
			btn_TrueTop.setEnabled(false);
			btn_FalseTop.setEnabled(true);
		}//End of else if
		else if (e.getActionCommand() == Actions.FALSETOP.name())
		{//Beginning of else fi
			Question3Input = "False";
			System.out.println(Question3Submitted);
			if(Question3Submitted == false) {
				if(Question3Input != "" && Question4Input != "") {
					btn_Next.setEnabled(true);
				}
			}
			btn_TrueTop.setEnabled(true);
			btn_FalseTop.setEnabled(false);
		}//End of else if
		else if (e.getActionCommand() == Actions.TRUEBOTTOM.name())
		{//Beginning of else if
			Question4Input = "True";
			if(Question3Submitted == false) {
				if(Question3Input != "" && Question4Input != "") {
					btn_Next.setEnabled(true);
				}
			}
			btn_TrueBottom.setEnabled(false);
			btn_FalseBottom.setEnabled(true);
		}//End of else if
		else if (e.getActionCommand() == Actions.FALSEBOTTOM.name())
		{//Beginning of else if
			Question4Input = "False";
			if(Question3Submitted == false) {
				if(Question3Input != "" && Question4Input != "") {
					btn_Next.setEnabled(true);
				}
			}
			btn_TrueBottom.setEnabled(true);
			btn_FalseBottom.setEnabled(false);
		}//End of else if
		else if (e.getActionCommand() == Actions.PREVIOUS.name())
		{//Beginning of else if
			if (dbl_Page == 2) {
				StartPage();
			}
			else if (dbl_Page ==3) {
				QuestionPage1();
				dbl_Page -= 1;
			}
			else if (dbl_Page == 4) {
				QuestionPage2();
				dbl_Page -= 1;
			}
			else if (dbl_Page == 5) {
				QuestionPage3();
				dbl_Page -= 1;
			}
			else if (dbl_Page == 6) {
				QuestionPage4();
				dbl_Page -= 1;
			}
			else if (dbl_Page == 7) {
				QuestionPage5();
				dbl_Page -= 1;
			}
		}//End of else if
		else if (e.getActionCommand() == Actions.NEXT.name())
		{//Beginning of else if
			if (dbl_Page == 1) {
				
			}
			else if (dbl_Page == 1) {
				
			}
			else if (dbl_Page == 2) {
				QuestionPage2();
				rad_Q1AnswerA.setEnabled(false);
				rad_Q1AnswerB.setEnabled(false);
				rad_Q1AnswerC.setEnabled(false);
				rad_Q1AnswerD.setEnabled(false);
				rad_Q2AnswerA.setEnabled(false);
				rad_Q2AnswerB.setEnabled(false);
				rad_Q2AnswerC.setEnabled(false);
				rad_Q2AnswerD.setEnabled(false);
				dbl_Page += 1;
			}
			else if (dbl_Page == 3) {
				QuestionPage3();
				dbl_Page += 1;
			}
			else if (dbl_Page == 4) {
				QuestionPage4();
				dbl_Page += 1;
			}
			else if (dbl_Page == 5) {
				QuestionPage5();
				dbl_Page += 1;
			}
			System.out.println(ScoreCheck + Question1Submitted);
			//------------------EASY
			if(ScoreCheck.equals("Easy")) {
				//Question1
				if(Question1Input.equals ("A") && Question1Submitted == false){
					Score += 1;
					Question1Submitted = true;
				}
				else {
					Question1Submitted = true;
				}
				//Question2
				if(Question2Input.equals ("C")&& Question2Submitted == false){
					Score += 1;
					Question2Submitted = true;
				}
				else {
					Question2Submitted = true;
				}
				
				//Question3
				if(Question3Input.equals("False") && Question3Submitted == false) {
					Score += 1;
					Question3Submitted = true;
					btn_TrueTop.setEnabled(false);
					btn_FalseTop.setEnabled(false);
				}
				else if(Question3Input.equals("True") && Question3Submitted == false){
					Question3Submitted = true;
					btn_TrueTop.setEnabled(false);
					btn_FalseTop.setEnabled(false);
				}
				//Question4
				if(Question4Input.equals("False") && Question4Submitted == false) {
					Score += 1;
					Question4Submitted = true;
					btn_TrueBottom.setEnabled(false);
					btn_FalseBottom.setEnabled(false);
				}
				else if(Question4Input.equals("True") && Question4Submitted == false){
					Question4Submitted = true;
					btn_TrueBottom.setEnabled(false);
					btn_FalseBottom.setEnabled(false);
				}
				//Easy Question 5
				Question5Input = txt_Question5.getText();
				if(Question5Submitted == false) {
					if(Question5Input.equals("txt") ||  Question5Input.equals(".txt")) {
						Score += 1;
						Question5Submitted = true;
						txt_Question5.setEnabled(false);
					}
					else if(!Question5Input.equals("")){
						Question5Submitted = true;
						txt_Question5.setEnabled(false);
					}
				}
				//Easy Question 6
				Question6Input = txt_Question6.getText();
				if(Question6Submitted == false) {
					if(Question6Input.equals("Hello World")) {
						Score += 1;
						Question6Submitted = true;
						txt_Question6.setEnabled(false);
					}
					else if(!Question6Input.equals("")){
						Question6Submitted = true;
						txt_Question6.setEnabled(false);
					}
				}
				//Easy Question 7
				Question7Input = Question7AInput + Question7BInput + Question7CInput + Question7DInput;
				System.out.println(Question7Input);
				if(Question7Submitted == false) {
					if(Question7Input.equals("ABC")) {
						Score += 1;
						Question7Submitted = true;
						chk_Q7AnswerA.setEnabled(false);
						chk_Q7AnswerB.setEnabled(false);
						chk_Q7AnswerC.setEnabled(false);
						chk_Q7AnswerD.setEnabled(false);
					}
					else if(!Question7Input.equals("")){
						chk_Q7AnswerA.setEnabled(false);
						chk_Q7AnswerB.setEnabled(false);
						chk_Q7AnswerC.setEnabled(false);
						chk_Q7AnswerD.setEnabled(false);
						Question7Submitted = true;
					}
				}
				//Easy Question 8
				Question8Input = Question8AInput + Question8BInput + Question8CInput + Question8DInput;
				System.out.println(Question8Input);
				if(Question8Submitted == false) {
					if(Question8Input.equals("ACD")) {
						Score += 1;
						chk_Q8AnswerA.setEnabled(false);
						chk_Q8AnswerB.setEnabled(false);
						chk_Q8AnswerC.setEnabled(false);
						chk_Q8AnswerD.setEnabled(false);
						Question8Submitted = true;
					}
					else if(!Question8Input.equals("")){
						chk_Q8AnswerA.setEnabled(false);
						chk_Q8AnswerB.setEnabled(false);
						chk_Q8AnswerC.setEnabled(false);
						chk_Q8AnswerD.setEnabled(false);
						Question8Submitted = true;
					}
				}
			}
			//Level MEDIUM
			if(ScoreCheck.equals("Medium")) {
				//Question 1
				if(Question1Input.equals ("B") && Question1Submitted == false){
					Score += 1;
					Question1Submitted = true;
				}
				else {
					Question1Submitted = true;
				}
				//Question 2
				if(Question2Input.equals ("B")&& Question2Submitted == false){
					Score += 1;
					Question2Submitted = true;
				}
				else {
					Question1Submitted = true;
				}
				//Question3
				if(Question3Input.equals("False") && Question3Submitted == false) {
					Score += 1;
					Question3Submitted = true;
					btn_TrueTop.setEnabled(false);
					btn_FalseTop.setEnabled(false);
				}
				else if(Question3Input.equals("True") && Question3Submitted == false){
					Question3Submitted = true;
					btn_TrueTop.setEnabled(false);
					btn_FalseTop.setEnabled(false);
				}
				//Question4
				if(Question4Input.equals("True") && Question4Submitted == false) {
					Score += 1;
					Question4Submitted = true;
					btn_TrueBottom.setEnabled(false);
					btn_FalseBottom.setEnabled(false);
				}
				else if(Question4Input.equals("False") && Question4Submitted == false){
					Question4Submitted = true;
					btn_TrueBottom.setEnabled(false);
					btn_FalseBottom.setEnabled(false);
				}
				//Medium Question 5
				Question5Input = txt_Question5.getText();
				if(Question5Submitted == false) {
					if(Question5Input.equals("cbo") ||  Question5Input.equals(".cbo")) {
						Score += 1;
						Question5Submitted = true;
						txt_Question5.setEnabled(false);
					}
					else if(!Question5Input.equals("")){
						Question5Submitted = true;
						txt_Question5.setEnabled(false);
					}
				}
				//Medium Question 6
				Question6Input = txt_Question6.getText();
				if(Question6Submitted == false) {
					if(Question6Input.equals("5")) {
						Score += 1;
						Question6Submitted = true;
						txt_Question6.setEnabled(false);
					}
					else if(!Question6Input.equals("")){
						Question6Submitted = true;
						txt_Question6.setEnabled(false);
					}
				}
				//Medium Question 7
				Question7Input = Question7AInput + Question7BInput + Question7CInput + Question7DInput;
				System.out.println(Question7Input);
				if(Question7Submitted == false) {
					if(Question7Input.equals("B")) {
						Score += 1;
						Question7Submitted = true;
						chk_Q7AnswerA.setEnabled(false);
						chk_Q7AnswerB.setEnabled(false);
						chk_Q7AnswerC.setEnabled(false);
						chk_Q7AnswerD.setEnabled(false);
					}
					else if(!Question7Input.equals("")){
						chk_Q7AnswerA.setEnabled(false);
						chk_Q7AnswerB.setEnabled(false);
						chk_Q7AnswerC.setEnabled(false);
						chk_Q7AnswerD.setEnabled(false);
						Question7Submitted = true;
					}
				}
				//Medium Question 8
				Question8Input = Question8AInput + Question8BInput + Question8CInput + Question8DInput;
				System.out.println(Question8Input);
				if(Question8Submitted == false) {
					if(Question8Input.equals("ABD")) {
						Score += 1;
						chk_Q8AnswerA.setEnabled(false);
						chk_Q8AnswerB.setEnabled(false);
						chk_Q8AnswerC.setEnabled(false);
						chk_Q8AnswerD.setEnabled(false);
						Question8Submitted = true;
					}
					else if(!Question8Input.equals("")){
						chk_Q8AnswerA.setEnabled(false);
						chk_Q8AnswerB.setEnabled(false);
						chk_Q8AnswerC.setEnabled(false);
						chk_Q8AnswerD.setEnabled(false);
						Question8Submitted = true;
					}
				}
			}
			if(ScoreCheck.equals("Hard")) {
				//Question 1
				if(Question1Input.equals ("C")&& Question2Submitted == false){
					Score += 1;
					Question1Submitted = true;
				}
				else {
					Question1Submitted = true;
				}
				//Question 2
				if(Question2Input.equals ("A")&& Question2Submitted == false){
					Score += 1;
					Question2Submitted = true;
				}
				else {
					Question1Submitted = true;
				}
				//Question3
				if(Question3Input.equals("True") && Question3Submitted == false) {
					Score += 1;
					Question3Submitted = true;
					btn_TrueTop.setEnabled(false);
					btn_FalseTop.setEnabled(false);
				}
				else if(Question3Input.equals("False") && Question3Submitted == false){
					Question3Submitted = true;
					btn_TrueTop.setEnabled(false);
					btn_FalseTop.setEnabled(false);
				}
				//Question4
				if(Question4Input.equals("True") && Question4Submitted == false) {
					Score += 1;
					Question4Submitted = true;
					btn_TrueBottom.setEnabled(false);
					btn_FalseBottom.setEnabled(false);
				}
				else if(Question4Input.equals("False") && Question4Submitted == false){
					Question4Submitted = true;
					btn_TrueBottom.setEnabled(false);
					btn_FalseBottom.setEnabled(false);
				}
				//Hard Question 5
				Question5Input = txt_Question5.getText();
				if(Question5Submitted == false) {
					if(Question5Input.equals("Java Runtime Environment") ||  Question5Input.equals("JavaRuntime Environment") ||  Question5Input.equals("Java runtime environment")) {
						Score += 1;
						Question5Submitted = true;
						txt_Question5.setEnabled(false);
					}
					else if(!Question5Input.equals("")){
						Question5Submitted = true;
						txt_Question5.setEnabled(false);
					}
				}
				//Hard Question 6
				Question6Input = txt_Question6.getText();
				if(Question6Submitted == false) {
					if(Question6Input.equals("Price: 5") || Question6Input.equals("Price:5")) {
						Score += 1;
						Question6Submitted = true;
						txt_Question6.setEnabled(false);
					}
					else if(!Question6Input.equals("")){
						Question6Submitted = true;
						txt_Question6.setEnabled(false);
					}
				}
				//Hard Question 7
				Question7Input = Question7AInput + Question7BInput + Question7CInput + Question7DInput;
				System.out.println(Question7Input);
				if(Question7Submitted == false) {
					if(Question7Input.equals("A")) {
						Score += 1;
						Question7Submitted = true;
						chk_Q7AnswerA.setEnabled(false);
						chk_Q7AnswerB.setEnabled(false);
						chk_Q7AnswerC.setEnabled(false);
						chk_Q7AnswerD.setEnabled(false);
					}
					else if(!Question7Input.equals("")){
						chk_Q7AnswerA.setEnabled(false);
						chk_Q7AnswerB.setEnabled(false);
						chk_Q7AnswerC.setEnabled(false);
						chk_Q7AnswerD.setEnabled(false);
						Question7Submitted = true;
					}
				}
				//Hard Question 8
				Question8Input = Question8AInput + Question8BInput + Question8CInput + Question8DInput;
				System.out.println(Question8Input);
				if(Question8Submitted == false) {
					if(Question8Input.equals("ACD")) {
						Score += 1;
						chk_Q8AnswerA.setEnabled(false);
						chk_Q8AnswerB.setEnabled(false);
						chk_Q8AnswerC.setEnabled(false);
						chk_Q8AnswerD.setEnabled(false);
						Question8Submitted = true;
					}
					else if(!Question8Input.equals("")){
						chk_Q8AnswerA.setEnabled(false);
						chk_Q8AnswerB.setEnabled(false);
						chk_Q8AnswerC.setEnabled(false);
						chk_Q8AnswerD.setEnabled(false);
						Question8Submitted = true;
					}
				}
			}
			if(ScoreCheck.equals("Insane")) {
				//Insane Question 1
				if(Question1Input.equals ("D")&& Question1Submitted == false){
					Score += 1;
					Question1Submitted = true;
				}
				else {
					Question1Submitted = true;
				}
				//Insane Question 2
				if(Question2Input.equals ("B")&& Question2Submitted == false){
					Score += 1;
					Question2Submitted = true;
				}
				else {
					Question1Submitted = true;
				}
				//Insane Question 3
				if(Question3Input.equals("False") && Question3Submitted == false) {
					Score += 1;
					Question3Submitted = true;
					btn_TrueTop.setEnabled(false);
					btn_FalseTop.setEnabled(false);
				}
				else if(Question3Input.equals("True") && Question3Submitted == false){
					Question3Submitted = true;
					btn_TrueTop.setEnabled(false);
					btn_FalseTop.setEnabled(false);
				}
				//Insane Question 4
				if(Question4Input.equals("True") && Question4Submitted == false) {
					Score += 1;
					Question4Submitted = true;
					btn_TrueBottom.setEnabled(false);
					btn_FalseBottom.setEnabled(false);
				}
				else if(Question4Input.equals("False") && Question4Submitted == false){
					Question4Submitted = true;
					btn_TrueBottom.setEnabled(false);
					btn_FalseBottom.setEnabled(false);
				}
				//Insane Question 5
				Question5Input = txt_Question5.getText();
				if(Question5Submitted == false) {
					if(Question5Input.equals("Java 17") ||  Question5Input.equals("Java17")) {
						Score += 1;
						Question5Submitted = true;
						txt_Question5.setEnabled(false);
					}
					else if(!Question5Input.equals("")){
						Question5Submitted = true;
						txt_Question5.setEnabled(false);
					}
				}
				//Insane Question 6
				Question6Input = txt_Question6.getText();
				if(Question6Submitted == false) {
					if(Question6Input.equals("1995")) {
						Score += 1;
						Question6Submitted = true;
						txt_Question6.setEnabled(false);
					}
					else if(!Question6Input.equals("")){
						Question6Submitted = true;
						txt_Question6.setEnabled(false);
					}
				}
				//Insane Question 7
				Question7Input = Question7AInput + Question7BInput + Question7CInput + Question7DInput;
				System.out.println(Question7Input);
				if(Question7Submitted == false) {
					if(Question7Input.equals("B")) {
						Score += 1;
						Question7Submitted = true;
						chk_Q7AnswerA.setEnabled(false);
						chk_Q7AnswerB.setEnabled(false);
						chk_Q7AnswerC.setEnabled(false);
						chk_Q7AnswerD.setEnabled(false);
					}
					else if(!Question7Input.equals("")){
						chk_Q7AnswerA.setEnabled(false);
						chk_Q7AnswerB.setEnabled(false);
						chk_Q7AnswerC.setEnabled(false);
						chk_Q7AnswerD.setEnabled(false);
						Question7Submitted = true;
					}
				}
				//Insane Question 8
				Question8Input = Question8AInput + Question8BInput + Question8CInput + Question8DInput;
				System.out.println(Question8Input);
				if(Question8Submitted == false) {
					if(Question8Input.equals("D")) {
						Score += 1;
						chk_Q8AnswerA.setEnabled(false);
						chk_Q8AnswerB.setEnabled(false);
						chk_Q8AnswerC.setEnabled(false);
						chk_Q8AnswerD.setEnabled(false);
						Question8Submitted = true;
					}
					else if(!Question8Input.equals("")){
						chk_Q8AnswerA.setEnabled(false);
						chk_Q8AnswerB.setEnabled(false);
						chk_Q8AnswerC.setEnabled(false);
						chk_Q8AnswerD.setEnabled(false);
						Question8Submitted = true;
					}
				}
			}
		lbl_Score.setText(number.format(Score) + " /10");
		}//End of else if
		else if (e.getActionCommand() == Actions.RESULTS.name())
		{//Beginning of else if

		}//End of else if
		else if (e.getActionCommand() == Actions.RESET.name())
		{//Beginning of else if
			rad_Q1AnswerA.setEnabled(true);
			rad_Q1AnswerB.setEnabled(true);
			rad_Q1AnswerC.setEnabled(true);
			rad_Q1AnswerD.setEnabled(true);
			rad_Q2AnswerA.setEnabled(true);
			rad_Q2AnswerB.setEnabled(true);
			rad_Q2AnswerC.setEnabled(true);
			rad_Q2AnswerD.setEnabled(true);
			
			Question1Input = "";
			Question2Input = "";
			Question3Input = "";
			Question4Input = "";
			Question5Input = "";
			Question6Input = "";
			Question7Input = "";
			Question8Input = "";
			Question9Input = "";
			Question10Input = "";
			
			Question1Submitted = false;
			Question2Submitted = false;
			Question3Submitted = false;
			Question4Submitted = false;
			Question5Submitted = false;
			Question6Submitted = false;
			Question7Submitted = false;
			Question8Submitted = false;
			Question9Submitted = false;
			Question10Submitted = false;
			
			Score = 0;
			bg_Question1.clearSelection();
			bg_Question2.clearSelection();
			
			btn_TrueTop.setEnabled(true);
			btn_FalseTop.setEnabled(true);
			btn_TrueBottom.setEnabled(true);
			btn_FalseBottom.setEnabled(true);
			
			txt_Question5.setEnabled(true);
			txt_Question6.setEnabled(true);
			
			txt_Question5.setText("");
			txt_Question6.setText("");
			StartPage();
			lbl_Score.setText(number.format(Score) + " /10");
			dbl_Page = 1;
		}//End of else if
		else if (e.getActionCommand() == Actions.QUIT.name())
		{//Beginning of else if
			fr_frame.dispose();
			System.exit(0);
		}//End of else if
		
	}//End of ActionPerformed
}//End of Quiz
