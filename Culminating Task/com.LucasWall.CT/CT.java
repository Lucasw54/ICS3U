/*
 * Name:Lucas Wall
 * Class code: ICS3U 
 * Date:Friday, April 14, 2022 
 * Assignment #: 14 (Culminating Task)
 * Description: Using GUI elements, Simple Math, Trig ratios, Soh-Cah-Toa,
 * Pythagorean theoreum I created a calculator that can do basic calculator things
 * as well as solve for the missing angles or sides if two side lengths are given.
 * This calculator inclues sin, cos, and tan button which will output their respective
 * value depending on what value is in the Register. Finally this calculator is capable
 * of being switched back and forth from degrees to radians if you wish.
 */
package com.LucasWall.CT;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class CT implements ActionListener
{//Beginning of CT
	//------Gui Globals
	//Frame + Panel
	private static JPanel pnl_panel;
	private static JFrame fr_frame;
	
	//Labels
	private static JLabel lbl_TitleLabel;
	private static JLabel lbl_Trigononmetry;
	private static JLabel lbl_BasicCalculator;
	private static JLabel lbl_ScientificConstants;
	private static JLabel lbl_UnitConversions;
	private static JLabel lbl_RightTriangle;
	private static JLabel lbl_RightTriangleExplanation;
	private static JLabel lbl_A;
	private static JLabel lbl_B;
	private static JLabel lbl_C;
	private static JLabel lbl_a;
	private static JLabel lbl_b;
	private static JLabel lbl_c;
	private static JLabel lbl_CurrentUnit;
	private static JLabel lbl_CurrentValue;
	private static JLabel lbl_ConvertToUnit;
	private static JLabel lbl_EquivalentValue;
	
	//Separators
	private static JSeparator sep_Title;
	private static JSeparator sep_Middle;
	
	//TextFields
	private static JTextField txt_Display;
	private static JTextField txt_A;
	private static JTextField txt_B;
	private static JTextField txt_C;
	private static JTextField txt_a;
	private static JTextField txt_b;
	private static JTextField txt_c;
	private static JTextField txt_CurrentUnit;
	
	//Radio Buttons
	private static JRadioButton rad_Degrees;
	private static JRadioButton rad_Radians;
	private static ButtonGroup bg_RadiansOrDegrees;
	private static JRadioButton rad_TriangleTop;
	private static JRadioButton rad_TriangleLeft;
	private static JRadioButton rad_TriangleRight;
	private static ButtonGroup bg_Theta;
	
	//Buttons
	private static JButton btn_Quit;
	private static JButton btn_Sin;
	private static JButton btn_Cos;
	private static JButton btn_Tan;
	private static JButton btn_AC;
	private static JButton btn_ACTrig;
	private static JButton btn_Equals;
	private static JButton btn_Equals2;
	private static JButton btn_Add;
	private static JButton btn_Subtract;
	private static JButton btn_Multiply;
	private static JButton btn_Divide;
	private static JButton btn_Percent;
	private static JButton btn_Ans;
	private static JButton btn_Decimal;
	private static JButton btn_Number0;
	private static JButton btn_Number1;
	private static JButton btn_Number2;
	private static JButton btn_Number3;
	private static JButton btn_Number4;
	private static JButton btn_Number5;
	private static JButton btn_Number6;
	private static JButton btn_Number7;
	private static JButton btn_Number8;
	private static JButton btn_Number9;
	private static JButton btn_History;
	
	//------Non GUI Globals 
	//Strings
	private static String Register = "";
	private static String History1 = "";
	private static String History2 = "";
	private static String History3 = "";
	private static String History4 = "";
	private static String History5 = "";
	private static String OperatorUsed = "";
	private static String AnswerString = "";
	private static String str_AngleA = "";
	private static String str_AngleB = "";
	private static String str_AngleC = "90";
	private static String Theta = "Top";
	private static String str_Hyp = "";
	private static String str_Adj = "";
	private static String str_Opp = "";
	private static String Type = "";
	private static String UnitStart = "";
	private static String UnitEnd = "";
	private static String AnsString = "";
	private static String RadDegMode = "Degrees";
	private static String DisplayString = "0";
	
	//Doubles
	private static double dbl_AngleA = 0;
	private static double dbl_AngleB = 0;
	private static double dbl_AngleC = 90;
	private static double OtherAngle = 0;
	private static double Pythagorean = 0;
	private static double dbl_Hyp;
	private static double dbl_Adj;
	private static double dbl_Opp;
	private static double Ans = 0;
	private static double Answer = 0;
	private static double RegisterNumber = 0;
	private static double DisplayNumber = 0;
	
	//Booleans
	private static Boolean Started = false;
	
	//Image variables
	private static BufferedImage BufferedRightTriangle;
	private static Image ImageRightTriangle;
	private static ImageIcon icn_RightTriangle;
	
	//Borders
	public static Border FrameBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	public static Border ButtonBorder = BorderFactory.createCompoundBorder();
		
	//Decimal Formats
	public static DecimalFormat money = new DecimalFormat("$###,###,##0.00");
	public static DecimalFormat number = new DecimalFormat("###,###,###");
	public static DecimalFormat decimal = new DecimalFormat("###,###,##0.000");
	
	//------Constants
	//Constant double
	private static final double PI = 3.141592653589793;
	
	//New Colours
	public static final Color NEW_BLUE = new Color(147, 196, 180);
	public static final Color DARK_GREY = new Color(102,102,102);
	public static final Color WRONG_RED = new Color(251, 255, 250);
	
	public enum Actions
	{//Beginning of Actions
		DEGREES,
		RADIANS,
		SIN,
		COS,
		TAN,
		TOP,
		LEFT,
		RIGHT,
		ANS,
		PERCENT,
		EQUALS,
		EQUALSTRIG,
		ADD,
		SUBTRACT,
		MULTIPLY,
		DIVIDE,
		DECIMAL,
		ZERO,
		ONE,
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		RESET,
		RESETTRIG,
		TYPE,
		UNITSTART,
		UNITEND,
		QUIT,//Dispose's the frame and ends the program
		HISTORY
	}//End of Actions
	
	public static void GUI() 
	{//Beginning of GUI
		CT instance = new CT();
		
		//Panel Config
		pnl_panel = new JPanel();
		pnl_panel.setBackground(NEW_BLUE);
		pnl_panel.setLayout(null);
		pnl_panel.setBorder(FrameBorder);
		
		//Frame Config
		fr_frame = new JFrame();
		fr_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr_frame.add(pnl_panel);
		fr_frame.setSize(770, 720);
		fr_frame.setLocationRelativeTo(null);
		fr_frame.setBackground(DARK_GREY);	
		
		//---------All Things Images
		BufferedRightTriangle = null;
		try
		{//Beginning of try
			BufferedRightTriangle = ImageIO.read(new File("RightTriangle.png"));
		}//End of try
		catch (IOException e)
		{//Beginning of catch
		    e.printStackTrace();
		}//End of catch
		//Creates Scaled Instances of Images
		ImageRightTriangle = BufferedRightTriangle.getScaledInstance(240, 180, 100);
		
		//Creates image icons
		icn_RightTriangle = new ImageIcon(ImageRightTriangle);
		
		//-----------Creating GUI Objects
		//Labels
		lbl_TitleLabel = new JLabel("Multi-Use Calculator!");
		lbl_TitleLabel.setBounds(170,0,500,70);
		pnl_panel.add(lbl_TitleLabel);
		lbl_TitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
		
		lbl_Trigononmetry = new JLabel("Trigonometric Calculations");
		lbl_Trigononmetry.setBounds(50,175,400,70);
		pnl_panel.add(lbl_Trigononmetry);
		lbl_Trigononmetry.setFont(new Font("Times New Roman", Font.BOLD, 24));
		
		lbl_BasicCalculator = new JLabel("Basic Calculations");
		lbl_BasicCalculator.setBounds(490,175,300,70);
		pnl_panel.add(lbl_BasicCalculator);
		lbl_BasicCalculator.setFont(new Font("Times New Roman", Font.BOLD, 24));
		
		lbl_ScientificConstants = new JLabel("Scientific Constants");
		lbl_ScientificConstants.setBounds(860,500,300,70);
		pnl_panel.add(lbl_ScientificConstants);
		lbl_ScientificConstants.setFont(new Font("Times New Roman", Font.BOLD, 24));

		lbl_UnitConversions = new JLabel("Unit Conversions");
		lbl_UnitConversions.setBounds(860,175,300,70);
		pnl_panel.add(lbl_UnitConversions);
		lbl_UnitConversions.setFont(new Font("Times New Roman", Font.BOLD, 24));
		
		lbl_RightTriangleExplanation = new JLabel("Enter given values: ");
		lbl_RightTriangleExplanation.setBounds(50,470,300,120);
		pnl_panel.add(lbl_RightTriangleExplanation);
		lbl_RightTriangleExplanation.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lbl_RightTriangle = new JLabel(icn_RightTriangle);
		lbl_RightTriangle.setBounds(-30,290,400,220);
		pnl_panel.add(lbl_RightTriangle);
		
		lbl_A = new JLabel("∠A");
		lbl_A.setBounds(40,465,400,220);
		pnl_panel.add(lbl_A);
		lbl_A.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lbl_B = new JLabel("∠B");
		lbl_B.setBounds(40,505,400,220);
		pnl_panel.add(lbl_B);
		lbl_B.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lbl_C = new JLabel("∠C");
		lbl_C.setBounds(40,545,400,220);
		pnl_panel.add(lbl_C);
		lbl_C.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lbl_a = new JLabel("a");
		lbl_a.setBounds(170,465,400,220);
		pnl_panel.add(lbl_a);
		lbl_a.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lbl_b = new JLabel("b");
		lbl_b.setBounds(170,505,400,220);
		pnl_panel.add(lbl_b);
		lbl_b.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lbl_c = new JLabel("c");
		lbl_c.setBounds(170,545,400,220);
		pnl_panel.add(lbl_c);
		lbl_c.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lbl_CurrentUnit = new JLabel("Current Unit:");
		lbl_CurrentUnit.setBounds(790,300,200,20);
		pnl_panel.add(lbl_CurrentUnit);
		lbl_CurrentUnit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lbl_CurrentValue = new JLabel("Value in " + UnitStart);
		lbl_CurrentValue.setBounds(1010,300,200,20);
		pnl_panel.add(lbl_CurrentValue);
		lbl_CurrentValue.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lbl_ConvertToUnit = new JLabel("Convert to:");
		lbl_ConvertToUnit.setBounds(790,400,200,20);
		pnl_panel.add(lbl_ConvertToUnit);
		lbl_ConvertToUnit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lbl_EquivalentValue = new JLabel("Value in " + UnitEnd);
		lbl_EquivalentValue.setBounds(1010,400,200,20);
		pnl_panel.add(lbl_EquivalentValue);
		lbl_EquivalentValue.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		//Separators
		sep_Title = new JSeparator();
		sep_Title.setBounds(0, 65, 1200, 25);
		pnl_panel.add(sep_Title);
		sep_Title.setForeground(DARK_GREY);
		
		sep_Middle = new JSeparator();
		sep_Middle.setBounds(380, 190, 20, 1000);
		pnl_panel.add(sep_Middle);
		sep_Middle.setForeground(DARK_GREY);
		sep_Middle.setOrientation(1); //Flips the JSeparator vertical
		
		//Radio Buttons
		rad_Degrees = new JRadioButton("Degrees");    
		rad_Degrees.setBounds(70,225,140,30);  
		rad_Degrees.setActionCommand(Actions.DEGREES.name());
		rad_Degrees.addActionListener(instance);
		rad_Degrees.setSelected(true);
		pnl_panel.add(rad_Degrees);
		
		rad_Radians = new JRadioButton("Radians");      
		rad_Radians.setBounds(200,225,100,30);  
		rad_Radians.setActionCommand(Actions.RADIANS.name());
		rad_Radians.addActionListener(instance);
		pnl_panel.add(rad_Radians);
		
		bg_RadiansOrDegrees = new ButtonGroup();    
		bg_RadiansOrDegrees.add(rad_Degrees);//adds Radio Button rad_Degrees to Button Group
		bg_RadiansOrDegrees.add(rad_Radians);//adds Radio Button rad_Radians to Button Group
		
		rad_TriangleTop = new JRadioButton("θ");    
		rad_TriangleTop.setBounds(67,345,140,30);  
		rad_TriangleTop.setActionCommand(Actions.TOP.name());
		rad_TriangleTop.addActionListener(instance);
		rad_TriangleTop.setSelected(true);
		pnl_panel.add(rad_TriangleTop);
		
		rad_TriangleRight = new JRadioButton("θ");      
		rad_TriangleRight.setBounds(190,435,100,30);  
		rad_TriangleRight.setActionCommand(Actions.RIGHT.name());//Adds the Action RIGHT to the Radio Button
		rad_TriangleRight.addActionListener(instance);
		pnl_panel.add(rad_TriangleRight);
		
		bg_Theta = new ButtonGroup();    
		bg_Theta.add(rad_TriangleTop);//adds Radio Button rad_TriangleTop to Button Group
		bg_Theta.add(rad_TriangleLeft);//adds Radio Button rad_TriangleLeft to Button Group
		bg_Theta.add(rad_TriangleRight);//adds Radio Button rad_TriangleRight to Button Group
		
		//Text Fields
		txt_Display = new JTextField(20);
		txt_Display.setBounds(60,95,640,90);
		pnl_panel.add(txt_Display);
		txt_Display.setFont(new Font("Times New Roman", Font.BOLD, 72));
		txt_Display.setEditable(false);
		if (Started == false) 
		{//Beginning of if
			txt_Display.setText(DisplayString);
		}//End of if
		
		txt_A = new JTextField(20);
		txt_A.setBounds(70,560,80,30);
		pnl_panel.add(txt_A);
		txt_A.setFont(new Font("Times New Roman", Font.BOLD, 22));

		txt_B = new JTextField(20);
		txt_B.setBounds(70,600,80,30);
		pnl_panel.add(txt_B);
		txt_B.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		txt_C = new JTextField(20);
		txt_C.setBounds(70,640,80,30);
		pnl_panel.add(txt_C);
		txt_C.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txt_C.setText(decimal.format(90));
		txt_C.setEditable(false);
		
		txt_a = new JTextField(20);
		txt_a.setBounds(190,560,80,30);
		pnl_panel.add(txt_a);
		txt_a.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		txt_b = new JTextField(20);
		txt_b.setBounds(190,600,80,30);
		pnl_panel.add(txt_b);
		txt_b.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		txt_c = new JTextField(20);
		txt_c.setBounds(190,640,80,30);
		pnl_panel.add(txt_c);
		txt_c.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		txt_CurrentUnit = new JTextField(20);
		txt_CurrentUnit.setBounds(1000,332,120,30);
		pnl_panel.add(txt_CurrentUnit);
		txt_CurrentUnit.setFont(new Font("Times New Roman", Font.BOLD, 22));
        
		//Buttons
		btn_Quit = new JButton("Quit");
		btn_Quit.setBounds(20, 25, 80, 25);
		btn_Quit.setActionCommand(Actions.QUIT.name());
		btn_Quit.addActionListener(instance);
		pnl_panel.add(btn_Quit);
		
		btn_Sin = new JButton("sin");
		btn_Sin.setBounds(60, 260, 80, 25);
		btn_Sin.setActionCommand(Actions.SIN.name());
		btn_Sin.addActionListener(instance);
		pnl_panel.add(btn_Sin);
		
		btn_Cos = new JButton("cos");
		btn_Cos.setBounds(140, 260, 80, 25);
		btn_Cos.setActionCommand(Actions.COS.name());
		btn_Cos.addActionListener(instance);
		pnl_panel.add(btn_Cos);
		
		btn_Tan = new JButton("tan");
		btn_Tan.setBounds(220, 260, 80, 25);
		btn_Tan.setActionCommand(Actions.TAN.name());
		btn_Tan.addActionListener(instance);
		pnl_panel.add(btn_Tan);

		btn_AC = new JButton("AC");
		btn_AC.setBounds(510, 250, 220, 70);
		btn_AC.setActionCommand(Actions.RESET.name());
		btn_AC.addActionListener(instance);
		pnl_panel.add(btn_AC);
		
		btn_ACTrig = new JButton("AC");
		btn_ACTrig.setBounds(290, 565, 50, 50);
		btn_ACTrig.setActionCommand(Actions.RESETTRIG.name());
		btn_ACTrig.addActionListener(instance);
		pnl_panel.add(btn_ACTrig);

		btn_Equals = new JButton("=");
		btn_Equals.setBounds(590, 570, 60, 70);
		btn_Equals.setActionCommand(Actions.EQUALS.name());
		btn_Equals.addActionListener(instance);
		pnl_panel.add(btn_Equals);
		
		btn_Equals2 = new JButton("=");
		btn_Equals2.setBounds(290, 615, 50, 50);
		btn_Equals2.setActionCommand(Actions.EQUALSTRIG.name());
		btn_Equals2.addActionListener(instance);
		pnl_panel.add(btn_Equals2);
		
		btn_Add = new JButton("+");
		btn_Add.setBounds(670, 570, 60, 70);
		btn_Add.setActionCommand(Actions.ADD.name());
		btn_Add.addActionListener(instance);
		pnl_panel.add(btn_Add);
		
		btn_Subtract = new JButton("-");
		btn_Subtract.setBounds(670, 490, 60, 70);
		btn_Subtract.setActionCommand(Actions.SUBTRACT.name());
		btn_Subtract.addActionListener(instance);
		pnl_panel.add(btn_Subtract);
		
		btn_Multiply = new JButton("x");
		btn_Multiply.setBounds(670, 410, 60, 70);
		btn_Multiply.setActionCommand(Actions.MULTIPLY.name());
		btn_Multiply.addActionListener(instance);
		pnl_panel.add(btn_Multiply);
		
		btn_Divide = new JButton("÷");
		btn_Divide.setBounds(670, 330, 60, 70);
		btn_Divide.setActionCommand(Actions.DIVIDE.name());
		btn_Divide.addActionListener(instance);
		pnl_panel.add(btn_Divide);
		
		btn_Percent = new JButton("%");
		btn_Percent.setBounds(430, 250, 60, 70);
		btn_Percent.setActionCommand(Actions.PERCENT.name());
		btn_Percent.addActionListener(instance);
		pnl_panel.add(btn_Percent);
		
		btn_Ans = new JButton("Ans");
		btn_Ans.setBounds(430, 250, 60, 70);
		btn_Ans.setActionCommand(Actions.ANS.name());
		btn_Ans.addActionListener(instance);
		pnl_panel.add(btn_Ans);
		
		btn_Decimal = new JButton(".");
		btn_Decimal.setBounds(510, 570, 60, 70);
		btn_Decimal.setActionCommand(Actions.DECIMAL.name());
		btn_Decimal.addActionListener(instance);
		pnl_panel.add(btn_Decimal);
		
		btn_Number0 = new JButton("0");
		btn_Number0.setBounds(430, 570, 60, 70);
		btn_Number0.setActionCommand(Actions.ZERO.name());
		btn_Number0.addActionListener(instance);
		pnl_panel.add(btn_Number0);
		
		btn_Number1 = new JButton("1");
		btn_Number1.setBounds(430, 490, 60, 70);
		btn_Number1.setActionCommand(Actions.ONE.name());
		btn_Number1.addActionListener(instance);
		pnl_panel.add(btn_Number1);
		
		btn_Number2 = new JButton("2");
		btn_Number2.setBounds(510, 490, 60, 70);
		btn_Number2.setActionCommand(Actions.TWO.name());
		btn_Number2.addActionListener(instance);
		pnl_panel.add(btn_Number2);
		
		btn_Number3 = new JButton("3");
		btn_Number3.setBounds(590, 490, 60, 70);
		btn_Number3.setActionCommand(Actions.THREE.name());
		btn_Number3.addActionListener(instance);
		pnl_panel.add(btn_Number3);
		
		btn_Number4 = new JButton("4");
		btn_Number4.setBounds(430, 410, 60, 70);
		btn_Number4.setActionCommand(Actions.FOUR.name());
		btn_Number4.addActionListener(instance);
		pnl_panel.add(btn_Number4);
		
		btn_Number5 = new JButton("5");
		btn_Number5.setBounds(510, 410, 60, 70);
		btn_Number5.setActionCommand(Actions.FIVE.name());
		btn_Number5.addActionListener(instance);
		pnl_panel.add(btn_Number5);
		
		btn_Number6 = new JButton("6");
		btn_Number6.setBounds(590, 410, 60, 70);
		btn_Number6.setActionCommand(Actions.SIX.name());
		btn_Number6.addActionListener(instance);
		pnl_panel.add(btn_Number6);
		
		btn_Number7 = new JButton("7");
		btn_Number7.setBounds(430, 330, 60, 70);
		btn_Number7.setActionCommand(Actions.SEVEN.name());
		btn_Number7.addActionListener(instance);
		pnl_panel.add(btn_Number7);
		
		btn_Number8 = new JButton("8");
		btn_Number8.setBounds(510, 330, 60, 70);
		btn_Number8.setActionCommand(Actions.EIGHT.name());
		btn_Number8.addActionListener(instance);
		pnl_panel.add(btn_Number8);
		
		btn_Number9 = new JButton("9");
		btn_Number9.setBounds(590, 330, 60, 70);
		btn_Number9.setActionCommand(Actions.NINE.name());
		btn_Number9.addActionListener(instance);
		pnl_panel.add(btn_Number9);
		
		//Frame config
		fr_frame.setResizable(false);
		fr_frame.setVisible(true);
		fr_frame.setTitle("Culminating Task - Lucas Wall - ICS3U");//Creates a title for the frame
	}//End of GUI
	public static void main(String[] args)
	{//Beginning of main
		GUI();
	}//End of main
	@Override
	public void actionPerformed(ActionEvent e)
	{//Beginnig of actionPerformed
		if (e.getActionCommand() == Actions.DEGREES.name())
		{//Beginning of if
			RadDegMode = "Degrees";
			txt_C.setText("90");
			txt_A.setText("");
			txt_B.setText("");
			txt_a.setText("");
			txt_b.setText("");
			txt_c.setText("");
			txt_A.setEditable(true);
			txt_B.setEditable(true);
			txt_a.setEditable(true);
			txt_b.setEditable(true);
			txt_c.setEditable(true);
		}//End of if
		else if (e.getActionCommand() == Actions.RADIANS.name())
		{//Beginning of else if
			RadDegMode = "Radians";
			txt_C.setText("1.5708");
			txt_A.setText("");
			txt_B.setText("");
			txt_a.setText("");
			txt_b.setText("");
			txt_c.setText("");
			txt_A.setEditable(true);
			txt_B.setEditable(true);
			txt_a.setEditable(true);
			txt_b.setEditable(true);
			txt_c.setEditable(true);
		}//End of else if
		else if (e.getActionCommand() == Actions.TOP.name())
		{//Beginning of else if
			Theta = "Top";
		}//End of else if
		else if (e.getActionCommand() == Actions.RIGHT.name()) 
		{//Beginning of else if
			Theta = "Bottom";
		}//End of else if
		else if (e.getActionCommand() == Actions.SIN.name())
		{//Beginning of else if
			if (Started == true)
			{//Beginning of if
				Register = txt_Display.getText();
				RegisterNumber = Double.parseDouble(Register);
				DisplayNumber = Double.parseDouble(DisplayString);
				DisplayString = "";
				if(RadDegMode.equals("Degrees"))
				{//Beginning of if
					RegisterNumber = Math.toRadians(RegisterNumber);
					Answer = Math.sin(RegisterNumber);
				}//End of if
				else if(RadDegMode.equals("Radians"))
				{//Beginning of else if
					Answer = Math.sin(RegisterNumber);
				}//End of else if
				AnswerString = "" + Answer;
			}//End of if
			else if (Started == false)
			{//Beginning of else if
			txt_Display.setText("ERROR");
			Started = false;
			}//End of else if
			txt_Display.setText(AnswerString);
		}//End of else if
		else if (e.getActionCommand() == Actions.COS.name())
		{//Beginning of else if
			if (Started == true)
			{//Beginning of if
				Register = txt_Display.getText();
				RegisterNumber = Double.parseDouble(Register);
				DisplayNumber = Double.parseDouble(DisplayString);
				DisplayString = "";
				if(RadDegMode.equals("Degrees"))
				{//Beginning of if
					RegisterNumber = Math.toRadians(RegisterNumber);
					Answer = Math.cos(RegisterNumber);
				}//End of if
				else if(RadDegMode.equals("Radians"))
				{//Beginning of else if
					Answer = Math.cos(RegisterNumber);
				}//End of else if
				AnswerString = "" + Answer;
			}//End of if
			else if (Started == false)
			{//Beginning of else if
				txt_Display.setText("ERROR");
				Started = false;
			}//End of else if
			txt_Display.setText(AnswerString);
		}//End of else if
		else if (e.getActionCommand() == Actions.TAN.name())
		{//Beginning of else if
			if (Started == true)
			{//Beginning of if
				Register = txt_Display.getText();
				RegisterNumber = Double.parseDouble(Register);
				DisplayNumber = Double.parseDouble(DisplayString);
				DisplayString = "";
				if(RadDegMode.equals("Degrees"))
				{//Beginning of if
					RegisterNumber = Math.toRadians(RegisterNumber);
					Answer = Math.tan(RegisterNumber);
				}//End of if
				else if(RadDegMode.equals("Radians"))
				{//Beginning of else if
					Answer = Math.tan(RegisterNumber);
				}//End of else if
				AnswerString = "" + Answer;
				}//End of else if
				else if (Started == false)
				{//Begining of else if
				txt_Display.setText("ERROR");
				Started = false;
				}//End of else if
			txt_Display.setText(AnswerString);
		}//End of else if
		else if (e.getActionCommand() == Actions.PERCENT.name())
		{//Beginning of else if
			if (Started == true)
			{//Beginning of if
			Register = txt_Display.getText();
			RegisterNumber = Double.parseDouble(Register);
			DisplayNumber = Double.parseDouble(DisplayString);
			DisplayString = "";
			Answer = RegisterNumber/100;
			AnswerString = "" + Answer;
			txt_Display.setText(AnswerString);
			}//End of if
			else if (Started == false)
			{//Beginning of else if
			txt_Display.setText("ERROR");
			Started = false;
			}//End of else if
		}//End of else if
		else if (e.getActionCommand() == Actions.EQUALS.name())
		{//Beginning of else if
			if (Started == true)
			{//Beginning of if
				if(!Register.equals(""))
				{//Beginning of if
					RegisterNumber = Double.parseDouble(Register);
					DisplayNumber = Double.parseDouble(DisplayString);
					if(OperatorUsed.equals("+"))
					{//Beginning of if
						Answer = RegisterNumber + DisplayNumber;
					}//End of if
					else if(OperatorUsed.equals("-"))
					{//Beginning of else if
						Answer = RegisterNumber - DisplayNumber;
					}//End of else if
					else if(OperatorUsed.equals("x"))
					{//Beginning of else if
					Answer = RegisterNumber * DisplayNumber;
					}//End of else if
					else if(OperatorUsed.equals("/"))
					{//Beginning of else if
					Answer = RegisterNumber / DisplayNumber;
					}//End of else if
					AnswerString = "" + Answer;
					txt_Display.setText(AnswerString);
				}//End of if
				else if(Register.equals(""))
				{//Beginning of else if
					txt_Display.setText("ERROR");
				}//End of else if
			}//End of if
			Started = false;
			Register = "";
			OperatorUsed = "";
		}//End of if
		else if (e.getActionCommand() == Actions.EQUALSTRIG.name())
		{//Beginning of else if
			AnswerString = "";
			dbl_Hyp = 0;
			dbl_Adj = 0;
			dbl_Opp = 0;
			
			str_AngleA = txt_A.getText();
			str_AngleB = txt_B.getText();
			
			if (!str_AngleA.equals(""))
			{//Beginning of if
				dbl_AngleA = Double.parseDouble(str_AngleA);
			}//End of if
			if (!str_AngleB.equals(""))
			{//Beginning of if
				dbl_AngleB = Double.parseDouble(str_AngleB);
			}//End of if
			if(Theta.equals("Top"))
			{//Beginning of if
				str_Hyp = txt_c.getText();
				str_Adj = txt_b.getText();
				str_Opp = txt_a.getText();
				
			}//End of if
			else if(Theta.equals("Bottom"))
			{//Beginning of else if
				str_Hyp = txt_c.getText();
				str_Adj = txt_a.getText();
				str_Opp = txt_b.getText();
		
			}//End of else if
			//------------------Triangle Theoreum First
			if (!(dbl_AngleA == 0) && dbl_AngleB == 0)
			{//Beginning of if
				Answer = 180 -(90+dbl_AngleA);
				AnswerString = "∠B = " + Answer;
				txt_B.setText(decimal.format(Answer));
			}//End of if
			else if (!(dbl_AngleB == 0) && dbl_AngleA == 0)
			{//Beginning of else if
				Answer = 180 -(90+dbl_AngleB);
				AnswerString = "∠A = " + Answer;
				txt_A.setText(decimal.format(Answer));
			}//End of else if
			if (!str_Hyp.equals(""))
			{//Beginning of if
				dbl_Hyp = Double.parseDouble(str_Hyp);
			}//End of if
			if (!str_Adj.equals(""))
			{//Beginning of if
				dbl_Adj = Double.parseDouble(str_Adj);
			}//End of if
			if (!str_Opp.equals(""))
			{//Beginning of if
				dbl_Opp = Double.parseDouble(str_Opp);
			}//End of if
			
			//--------------Angle First
			if(Theta.equals("Top"))
			{//Beginning of if
				if (!(dbl_Opp == 0) && !(dbl_Hyp == 0) && dbl_Adj == 0)
				{//Beginning of if
					txt_a.setText(decimal.format(dbl_Opp));
					txt_c.setText(decimal.format(dbl_Hyp));
					if(RadDegMode.equals("Degrees"))
					{//Beginning of if
						Answer = Math.asin(dbl_Opp/dbl_Hyp);
						OtherAngle = 3.14159-(1.5708+Answer);
						Answer = (180/3.14)*Answer;
						OtherAngle = Math.toDegrees(OtherAngle);
					}//End of if
					else if(RadDegMode.equals("Radians"))
					{//Beginning of else if
						Answer = Math.asin(dbl_Opp/dbl_Hyp);
						OtherAngle = 3.14159-(1.5708+Answer);//Pythagorean theoreum
					}//End of else if
					AnswerString = "∠A = " + Answer;
					txt_A.setText(decimal.format(Answer));
					txt_B.setText(decimal.format(OtherAngle));
					Pythagorean = Math.sqrt((dbl_Hyp*dbl_Hyp)-(dbl_Opp*dbl_Opp));
					txt_b.setText(decimal.format(Pythagorean));
				}//End of if
				else if (!(dbl_Adj == 0) && !(dbl_Hyp == 0) && dbl_Opp == 0)
				{//Beginning of else if
					txt_b.setText(decimal.format(dbl_Adj));
					txt_c.setText(decimal.format(dbl_Hyp));
					if(RadDegMode.equals("Degrees"))
					{//Beginning of if
						Answer = Math.acos(dbl_Adj/dbl_Hyp);
						OtherAngle = 3.14159-(1.5708+Answer);
						Answer = (180/3.14)*Answer;
						OtherAngle = Math.toDegrees(OtherAngle);
					}//End of if
					else if(RadDegMode.equals("Radians"))
					{//Beginning of else if
						Answer = Math.acos(dbl_Adj/dbl_Hyp);
						OtherAngle = 3.14159-(1.5708+Answer);
					}//End of else if
					AnswerString = "∠A = " + Answer;
					txt_A.setText(decimal.format(Answer));
					txt_B.setText(decimal.format(OtherAngle));
					Pythagorean = Math.sqrt((dbl_Hyp*dbl_Hyp)-(dbl_Adj*dbl_Adj));
					txt_a.setText(decimal.format(Pythagorean));
				}//End of else if
				else if (!(dbl_Opp == 0) && !(dbl_Adj == 0) && dbl_Hyp == 0)
				{//Beginning of else if
					txt_a.setText(decimal.format(dbl_Opp));
					txt_b.setText(decimal.format(dbl_Adj));
					if(RadDegMode.equals("Degrees"))
					{//Beginning of if
						Answer = Math.atan(dbl_Opp/dbl_Adj);
						OtherAngle = 3.14159-(1.5708+Answer);
						Answer = (180/3.14)*Answer;
						OtherAngle = Math.toDegrees(OtherAngle);
					}//End of if
					else if(RadDegMode.equals("Radians"))
					{//Beginning of else if
						Answer = Math.atan(dbl_Opp/dbl_Adj);
						OtherAngle = 3.14159-(1.5708+Answer);
					}//End of else if
					AnswerString = "∠A = " + Answer;
					txt_A.setText(decimal.format(Answer));
					txt_B.setText(decimal.format(OtherAngle));
					Pythagorean = Math.sqrt((dbl_Adj*dbl_Adj)+(dbl_Opp*dbl_Opp));
					txt_c.setText(decimal.format(Pythagorean));
				}//End of else if
			}
			else if(Theta.equals("Bottom"))
			{//Beginning of else if
				if (!(dbl_Opp == 0) && !(dbl_Hyp == 0) && dbl_Adj == 0)
				{//Beginning of if
					txt_b.setText(decimal.format(dbl_Opp));
					txt_c.setText(decimal.format(dbl_Hyp));
					if(RadDegMode.equals("Degrees"))
					{//Beginning of if
						Answer = Math.asin(dbl_Opp/dbl_Hyp);
						OtherAngle = 3.14159-(1.5708+Answer);
						Answer = (180/3.14)*Answer;
						OtherAngle = Math.toDegrees(OtherAngle);
					}//End of if
					else if(RadDegMode.equals("Radians"))
					{//Beginning of else if
						Answer = Math.asin(dbl_Opp/dbl_Hyp);
						OtherAngle = 3.14159-(1.5708+Answer);
					}//End of else if
					AnswerString = "∠B = " + Answer;
					txt_B.setText(decimal.format(Answer));
					txt_A.setText(decimal.format(OtherAngle));
					Pythagorean = Math.sqrt((dbl_Hyp*dbl_Hyp)-(dbl_Opp*dbl_Opp));
					txt_a.setText(decimal.format(Pythagorean));
				}//End of else if
				else if (!(dbl_Adj == 0) && !(dbl_Hyp == 0) && dbl_Opp == 0)
				{//Beginning of else if
					txt_a.setText(decimal.format(dbl_Adj));
					txt_c.setText(decimal.format(dbl_Hyp));
					if(RadDegMode.equals("Degrees"))
					{//Beginning of if
						Answer = Math.acos(dbl_Adj/dbl_Hyp);
						OtherAngle = 3.14159-(1.5708+Answer);
						Answer = (180/3.14)*Answer;
						OtherAngle = Math.toDegrees(OtherAngle);
					}//End of if
					else if(RadDegMode.equals("Radians"))
					{//Beginning of else if
						Answer = Math.acos(dbl_Adj/dbl_Hyp);
						OtherAngle = 3.14159-(1.5708+Answer);
					}//End of else if
					AnswerString = "∠B = " + Answer;
					txt_B.setText(decimal.format(Answer));
					txt_A.setText(decimal.format(OtherAngle));
					Pythagorean = Math.sqrt((dbl_Hyp*dbl_Hyp)-(dbl_Adj*dbl_Adj));
					txt_b.setText(decimal.format(Pythagorean));
				}//End of else if
				else if (!(dbl_Opp == 0) && !(dbl_Adj == 0) && dbl_Hyp == 0)
				{//Beginning of else if
					txt_a.setText(decimal.format(dbl_Adj));
					txt_b.setText(decimal.format(dbl_Opp));
					if(RadDegMode.equals("Degrees"))
					{//Beginning of if
						Answer = Math.atan(dbl_Opp/dbl_Adj);
						OtherAngle = 3.14159-(1.5708+Answer);
						Answer = (180/3.14)*Answer;
						OtherAngle = Math.toDegrees(OtherAngle);
					}//End of if
					else if(RadDegMode.equals("Radians"))
					{//Beginning of else if
						Answer = Math.atan(dbl_Opp/dbl_Adj);
						OtherAngle = 3.14159-(1.5708+Answer);
					}//End of else if
					AnswerString = "∠B = " + Answer;
					txt_B.setText(decimal.format(Answer));
					txt_A.setText(decimal.format(OtherAngle));
					Pythagorean = Math.sqrt((dbl_Adj*dbl_Adj)+(dbl_Opp*dbl_Opp));
					txt_c.setText(decimal.format(Pythagorean));
				}//End of else if
			}//End of else if
			txt_A.setEditable(false);
			txt_B.setEditable(false);
			txt_C.setEditable(false);
			txt_a.setEditable(false);
			txt_b.setEditable(false);
			txt_c.setEditable(false);
		}//End of else if
		else if (e.getActionCommand() == Actions.ADD.name())
		{//Beginning of else if
			OperatorUsed = "+";
			Register = txt_Display.getText();
			DisplayString = "";
			txt_Display.setText(DisplayString);
		}//End of else if
		else if (e.getActionCommand() == Actions.SUBTRACT.name())
		{//Beginning of else if
			OperatorUsed = "-";
			Register = txt_Display.getText();
			DisplayString = "";
			txt_Display.setText(DisplayString);
		}//End of else if
		else if (e.getActionCommand() == Actions.MULTIPLY.name())
		{//Beginning of else if
			OperatorUsed = "x";
			Register = txt_Display.getText();
			DisplayString = "";
			txt_Display.setText(DisplayString);
		}//End of else if
		else if (e.getActionCommand() == Actions.DIVIDE.name())
		{//Beginning of else if
			if (Started == true)
			{//Beginning of if
				OperatorUsed = "/";
				Register = txt_Display.getText();
				DisplayString = "";
			}//End of if
			else if (Started == false)
			{//Beginning of else if
				DisplayString ="ERROR";
			}//End of else if
			txt_Display.setText(DisplayString);
		}//End of else if
		else if (e.getActionCommand() == Actions.DECIMAL.name())
		{//Beginning of else if
			if (Started == true)
			{//Beginning of if
				DisplayString += ".";
			}//End of if
			else if (Started == false)
			{//Beginning of else if
				DisplayString ="";
				DisplayString += ".";
				Started = true;
			}//End of else if
			txt_Display.setText(DisplayString);
		}//End of else if
		else if (e.getActionCommand() == Actions.ZERO.name())
		{//Beginning of else if
			if (Started == true) 
			{//Beginning of if
				DisplayString += "0";
			}//End of if
			else if (Started == false) 
			{//Beginning of else if
				DisplayString ="";
				DisplayString += "0";
				Started = true;
			}//End of else if
			txt_Display.setText(DisplayString);
		}//End of else if
		else if (e.getActionCommand() == Actions.ONE.name()) 
		{//Beginning of else if
			if (Started == true) 
			{//Beginning of if
				DisplayString += "1";
			}//End of if
			else if (Started == false) 
			{//Beginning of else if
					DisplayString ="";
					DisplayString += "1";
					Started = true;
			}//End of else if
			txt_Display.setText(DisplayString);
		}//End of else if
		else if (e.getActionCommand() == Actions.TWO.name()) 
		{//Beginning of else if
			if (Started == true) 
			{//Beginning of if
				DisplayString += "2";
			}//End of if
			else if (Started == false) 
			{//Beginning of else if
				DisplayString ="";
				DisplayString += "2";
				Started = true;
			}//End of else if
			txt_Display.setText(DisplayString);
		}//End of else if
		else if (e.getActionCommand() == Actions.THREE.name()) 
		{//Beginning of else if
			if (Started == true) 
			{//Beginning of if
				DisplayString += "3";
			}//End of if
			else if (Started == false) 
			{//Beginning of else if
				DisplayString ="";
				DisplayString += "3";
				Started = true;
			}//End of else if
			txt_Display.setText(DisplayString);
		}//End of else if
		else if (e.getActionCommand() == Actions.FOUR.name()) 
		{//Beginning of else if
			if (Started == true) 
			{//Beginning of if
				DisplayString += "4";
			}//End of if
			else if (Started == false) 
			{//Beginning of else if
				DisplayString ="";
				DisplayString += "4";
				Started = true;
			}//End of else if
			txt_Display.setText(DisplayString);
		}//End of else if
		else if (e.getActionCommand() == Actions.FIVE.name()) 
		{//Beginning of else if
			if (Started == true) 
			{//Beginning of if
				DisplayString += "5";
			}//End of if
			else if (Started == false) 
			{//Beginning of else if
				DisplayString ="";
				DisplayString += "5";
				Started = true;
			}//End of else if
			txt_Display.setText(DisplayString);
		}//End of else if
		else if (e.getActionCommand() == Actions.SIX.name()) 
		{//Beginning of else if
			if (Started == true) 
			{//Beginning of if
				DisplayString += "6";
			}//End of if
			else if (Started == false) 
			{//Beginning of else if
				DisplayString ="";
				DisplayString += "6";
				Started = true;
			}//End of else if
			txt_Display.setText(DisplayString);
		}//End of else if
		else if (e.getActionCommand() == Actions.SEVEN.name()) 
		{//Beginning of else if
			if (Started == true) 
			{//Beginning of if
				DisplayString += "7";
			}//End of if
			else if (Started == false) 
			{//Beginning of else if
				DisplayString ="";
				DisplayString += "7";
				Started = true;
			}//End of else if
			txt_Display.setText(DisplayString);
		}//End of else if
		else if (e.getActionCommand() == Actions.EIGHT.name()) 
		{//Beginning of else if
			if (Started == true) 
			{//Beginning of if
				DisplayString += "8";
			}//End of if
			else if (Started == false) 
			{//Beginning of else if
				DisplayString ="";
				DisplayString += "8";
				Started = true;
			}//End of else if
			txt_Display.setText(DisplayString);
		}//End of else if
		else if (e.getActionCommand() == Actions.NINE.name()) 
		{//Beginning of else if
			if (Started == true) 
			{//Beginning of if
				DisplayString += "9";
			}//End of if
			else if (Started == false) 
			{//Beginning of else if
				DisplayString ="";
				DisplayString += "9";
				Started = true;
			}//End of else if
			txt_Display.setText(DisplayString);
		}//End of else if
		else if (e.getActionCommand() == Actions.RESET.name()) 
		{//Beginning of else if
			History5 = History4;
			History4 = History3;
			History3 = History2;
			History2 = History1;
			History1 = txt_Display.getText();
			DisplayString ="0";
			Register = "";
			RegisterNumber = 0;
			DisplayNumber = 0;
			OperatorUsed = "";
			AnswerString = "";
			Started = false;
			txt_Display.setText(DisplayString);
		}//End of else if
		else if (e.getActionCommand() == Actions.RESETTRIG.name()) 
		{//Beginning of else if
			dbl_AngleA = 0;
			dbl_AngleB = 0;
			dbl_AngleC = 0;
			str_AngleA = "";
			str_AngleB = "";
			str_AngleC = "";
			txt_A.setEditable(true);
			txt_B.setEditable(true);
			txt_a.setEditable(true);
			txt_b.setEditable(true);
			txt_c.setEditable(true);
			txt_A.setText("");
			txt_B.setText("");
			txt_a.setText("");
			txt_b.setText("");
			txt_c.setText("");
		}//End of else if
		else if (e.getActionCommand() == Actions.QUIT.name()) 
		{//Beginning of else if
			fr_frame.dispose();
			System.exit(0);
		}//End of else if
	}//End of actionPerformed
}//End of CT
