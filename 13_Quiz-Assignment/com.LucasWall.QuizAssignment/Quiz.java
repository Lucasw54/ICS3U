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

import com.LucasWall.GUIInputAssignment.GUIInput.Actions;

public class Quiz implements ActionListener
{//Beginning of Quiz
	private static JPanel pnl_panel;
	private static JFrame fr_frame;
	
	//Labels
	private static JLabel lbl_TitleLabel;
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
	
	//Images - (Labels)
	private static JLabel img_CodeBackground;
	private static BufferedImage BufferedCodeBackground;
	private static Image ImageCodeBackground;
	private static ImageIcon icn_CodeBackground;
	
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
	
	private static JCheckBox chk_RedEye;
	
	//Buttons
	private static JButton btn_Start;
	private static JButton btn_Previous;
	private static JButton btn_Next;
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
	private static String Question8Input = "";
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
	
	//------New Colours
	public static final Color NEW_GREEN = new Color(212, 255, 238);
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
		//BufferedTitleTextBox = null;
		try
		{//Beginning of try
			BufferedCodeBackground = ImageIO.read(new File("JavaCode.jpg"));
			//BufferedTitleTextBox = ImageIO.read(new File("TextBox1.jpg"));
		}//End of try
		catch (IOException e)
		{//Beginning of catch
			e.printStackTrace();
		}//End of catch
		//Creates Scaled Instances of Images
		ImageCodeBackground = BufferedCodeBackground.getScaledInstance(1224, 816, 100);
		//ImageTitleTextBox = BufferedTitleTextBox.getScaledInstance(1224, 816, 100);
				
		//Creates image icons
		icn_CodeBackground = new ImageIcon(ImageCodeBackground);
		//icn_TitleTextBox = new ImageIcon(ImageTitleTextBox);
		
		//-----------Creating GUI Objects
		//Labels
		lbl_TitleLabel = new JLabel(str_Difficulty  + "Java Quiz!");
		lbl_TitleLabel.setBounds(0,10,1152,70);
		pnl_panel.add(lbl_TitleLabel);
		lbl_TitleLabel.setHorizontalAlignment(JLabel.CENTER);
		lbl_TitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
		
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
		
		//Combo Boxes
		
		//Check Boxes
		
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
		
		//Images(Labels)	
		img_CodeBackground = new JLabel(icn_CodeBackground);
		img_CodeBackground.setBounds(0,0,1224,816);
		pnl_panel.add(img_CodeBackground);				

		//Frame config
		fr_frame.setVisible(true);
		fr_frame.setTitle("Grade 11 Computer Studies Quiz!");
		StartPage();
	}
	public static void StartPage() {
		img_CodeBackground.setVisible(true);
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
		btn_Previous.setVisible(false);
		if(Question1Submitted == true){
			btn_Next.setEnabled(true);
		}
		btn_Reset.setVisible(false);
		
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
		
		lbl_TitleLabel.setVisible(true);
		lbl_Score.setVisible(true);
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
		btn_Next.setEnabled(false);
		if(Question1Submitted == true){
			btn_Next.setEnabled(true);
		}
	}
	public static void QuestionPage2() {
		btn_Previous.setVisible(true);
		lbl_Question3Title.setVisible(true);
		lbl_Question4Title.setVisible(true);
		
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
	}
	public static void QuestionPage3() {
		lbl_Question5Title.setVisible(true);
		lbl_Question6Title.setVisible(true);
		
		lbl_Question1Title.setVisible(false);
		lbl_Question2Title.setVisible(false);
		lbl_Question3Title.setVisible(false);
		lbl_Question4Title.setVisible(false);
		lbl_Question7Title.setVisible(false);
		lbl_Question8Title.setVisible(false);
		lbl_Question9Title.setVisible(false);
		lbl_Question10Title.setVisible(false);
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
	}
	public static void Results() {
		
	}
	public static void main(String[] args) {
		GUI();
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
			Question9 = "	HI";
			Question10 = "	 HI";
			
			rad_Q1AnswerA.setText("Determines wether or not a object is visible or not"); 
			rad_Q1AnswerB.setText("Determines wether or not a object is on the panel"); 
			rad_Q1AnswerC.setText("If set to false the object is deleted"); 
			rad_Q1AnswerD.setText("Creates a new panel");
			
			rad_Q2AnswerA.setText("Changes the opacity of the text"); 
			rad_Q2AnswerB.setText("Changes wether or not the object shows text"); 
			rad_Q2AnswerC.setText("Sets the text of a desired object"); 
			rad_Q2AnswerD.setText("Changes the text of a desired variable");
			
			Question1CorrectAnswer = "A";
			Question2CorrectAnswer = "C";
			Question3CorrectAnswer = "False";
			Question4CorrectAnswer = "False";
			Question5CorrectAnswer = "";
			Question6CorrectAnswer = "";
			Question7CorrectAnswer = "";
			Question8CorrectAnswer = "";
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
			Question7 = "	";
			Question8 = "	HI";
			Question9 = "	HI";
			Question10 = "	 HI";
			
			rad_Q1AnswerA.setText("Determines wether or not a object is visible or not"); 
			rad_Q1AnswerB.setText("Determines wether or not a object is enabled / interactable"); 
			rad_Q1AnswerC.setText("Allows the computer to access your local wifi"); 
			rad_Q1AnswerD.setText("Enables the frame");
			
			rad_Q2AnswerA.setText("Bill Joy"); 
			rad_Q2AnswerB.setText("James Gosling"); 
			rad_Q2AnswerC.setText("Bill Gates"); 
			rad_Q2AnswerD.setText("Isaac Newton");
			
			Question1CorrectAnswer = "B";
			Question2CorrectAnswer = "B";
			Question3CorrectAnswer = "False";
			Question4CorrectAnswer = "True";
			Question5CorrectAnswer = "";
			Question6CorrectAnswer = "";
			Question7CorrectAnswer = "";
			Question8CorrectAnswer = "";
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
			Question5 = "	HI";
			Question6 = "	HI";
			Question7 = "	HI";
			Question8 = "	HI";
			Question9 = "	HI";
			Question10 = "	 HI";
			
			rad_Q1AnswerA.setText("Text Area"); 
			rad_Q1AnswerB.setText("Radio Button"); 
			rad_Q1AnswerC.setText("Check Boxes"); 
			rad_Q1AnswerD.setText("Combo Boxes");
			
			rad_Q2AnswerA.setText("Radio Buttons"); 
			rad_Q2AnswerB.setText("Combo Boxes"); 
			rad_Q2AnswerC.setText("Check Boxes"); 
			rad_Q2AnswerD.setText("Buttons");
			
			Question1CorrectAnswer = "C";
			Question2CorrectAnswer = "A";
			Question3CorrectAnswer = "True";
			Question4CorrectAnswer = "True";
			Question5CorrectAnswer = "";
			Question6CorrectAnswer = "";
			Question7CorrectAnswer = "";
			Question8CorrectAnswer = "";
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
			Question5 = "	HI";
			Question6 = "	HI";
			Question7 = "	HI";
			Question8 = "	HI";
			Question9 = "	 HI";
			Question10 = "	 HI";
			
			rad_Q1AnswerA.setText("Text Area"); 
			rad_Q1AnswerB.setText("Radio Button"); 
			rad_Q1AnswerC.setText("Check Boxes"); 
			rad_Q1AnswerD.setText("Combo Boxes");
			
			rad_Q2AnswerA.setText("Error"); 
			rad_Q2AnswerB.setText("Is not"); 
			rad_Q2AnswerC.setText("Is"); 
			rad_Q2AnswerD.setText("Caution");
			
			Question1CorrectAnswer = "Combo Boxes";
			Question2CorrectAnswer = "Is not";
			Question3CorrectAnswer = "False";
			Question4CorrectAnswer = "True";
			Question5CorrectAnswer = "";
			Question6CorrectAnswer = "";
			Question7CorrectAnswer = "";
			Question8CorrectAnswer = "";
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
			if(ScoreCheck.equals("Easy")&& Question1Submitted == false) {
				if(Question1Input.equals ("A")){
					Score += 1;
					Question1Submitted = true;
				}
				if(Question2Input.equals ("C")&& Question2Submitted == false){
					Score += 1;
					Question2Submitted = true;
					System.out.println("HII");
				}
			}
			if(ScoreCheck.equals("Medium") && Question1Submitted == false) {
				if(Question1Input.equals ("B")){
					Score += 1;
					Question1Submitted = true;
				}
				if(Question2Input.equals ("B")&& Question2Submitted == false){
					Score += 1;
					Question2Submitted = true;
				}
			}
			if(ScoreCheck.equals("Hard")) {
				
				if(Question1Input.equals ("C")){
					Score += 1;
					Question1Submitted = true;
				}
				if(Question2Input.equals ("A")&& Question2Submitted == false){
					Score += 1;
					Question2Submitted = true;
				}
			}
			if(ScoreCheck.equals("Insane")) {
				if(Question1Input.equals ("D")&& Question1Submitted == false){
					Score += 1;
					Question1Submitted = true;
				}
				if(Question2Input.equals ("B")&& Question2Submitted == false){
					Score += 1;
					Question2Submitted = true;
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
