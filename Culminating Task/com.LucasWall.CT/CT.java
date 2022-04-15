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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class CT implements ActionListener{
	//------Gui Globals
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
	private static JSeparator sep_1;
	private static JSeparator sep_2;
	
	//TextFields
	private static JTextField txt_Display;
	private static JTextField txt_A;
	private static JTextField txt_B;
	private static JTextField txt_C;
	private static JTextField txt_a;
	private static JTextField txt_b;
	private static JTextField txt_c;
	private static JTextField txt_CurrentUnit;
	
	//Images - (Labels)
	
	//Radio Buttons
	private static JRadioButton rad_Degrees;
	private static JRadioButton rad_Radians;
	private static ButtonGroup bg_RadiansOrDegrees;
	private static JRadioButton rad_TriangleTop;
	private static JRadioButton rad_TriangleLeft;
	private static JRadioButton rad_TriangleRight;
	private static ButtonGroup bg_Theta;
	
	//Combo Boxes
	private static JComboBox cbo_ConversionType;
	private static JComboBox cbo_UnitStart;
	private static JComboBox cbo_UnitEnd;
	
	//Check Boxes
	
	//Buttons
	private static JButton btn_Quit;
	private static JButton btn_Sin;
	private static JButton btn_Cos;
	private static JButton btn_Tan;
	private static JButton btn_AC;
	private static JButton btn_AC2;
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
	
	//--------Other Globals 
	private static BufferedImage BufferedHistory;
	private static Image ImageHistory;
	private static ImageIcon icn_History;
	private static BufferedImage BufferedRightTriangle;
	private static Image ImageRightTriangle;
	private static ImageIcon icn_RightTriangle;
	private static final double PI = 3.141592653589793;
	private static String RadDegMode = "Degrees";
	private static String DisplayString = "0";
	private static Boolean Started = false;
	private static String Register = "";
	private static String History1 = "";
	private static String History2 = "";
	private static String History3 = "";
	private static String History4 = "";
	private static String History5 = "";
	private static String OperatorUsed = "";
	private static String AnswerString = "";
	private static double Answer = 0;
	private static double RegisterNumber = 0;
	private static double DisplayNumber = 0;
	private static String AnsString = "";
	private static double Ans = 0;
	private static String str_AngleA = "";
	private static String str_AngleB = "";
	private static String str_AngleC = "90";
	private static double dbl_AngleA = 0;
	private static double dbl_AngleB = 0;
	private static double dbl_AngleC = 90;
	private static double OtherAngle = 0;
	private static double Pythagorean = 0;
	
	private static String Theta = "Top";
	private static String str_Hyp = "";
	private static String str_Adj = "";
	private static String str_Opp = "";
	
	private static double dbl_Hyp;
	private static double dbl_Adj;
	private static double dbl_Opp;
	
	private static String Type = "";
	private static String UnitStart = "";
	private static String UnitEnd = "";
	
	//------New Colours
	public static final Color NEW_BLUE = new Color(147, 196, 180);
	public static final Color DARK_GREY = new Color(102,102,102);
	public static final Color WRONG_RED = new Color(251, 255, 250);
	
	//------Constant Variables
	public static final double dbl_HST_TAX  = 1.13;
	
	//------Decimal Formats
	public static DecimalFormat money = new DecimalFormat("$###,###,##0.00");
	public static DecimalFormat number = new DecimalFormat("###,###,###");
	public static DecimalFormat decimal = new DecimalFormat("###,###,##0.000");
	
	//------Borders
	public static Border FrameBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	public static Border ButtonBorder = BorderFactory.createCompoundBorder();
	
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
		EQUALS2,
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
		RESET2,
		TYPE,
		UNITSTART,
		UNITEND,
		QUIT,//Dispose's the frame and ends the program
		HISTORY
	}//End of Actions
	
	public static void GUI() {
		CT instance = new CT();
		String[] Type = {"Select Type of Conversion", "Distance", "Pressure", "Temperature", "Energy"};
		String[] optionsToChoose = { "Select Unit"};
		
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
		
		//----All Things Images
		BufferedHistory = null;
		BufferedRightTriangle = null;
		try
		{//Beginning of try
			BufferedHistory = ImageIO.read(new File("History1.png"));
			BufferedRightTriangle = ImageIO.read(new File("RightTriangle.png"));
		}//End of try
		catch (IOException e)
		{//Beginning of catch
		    e.printStackTrace();
		}//End of catch
		//Creates Scaled Instances of Images
		ImageHistory = BufferedHistory.getScaledInstance(60, 60, 100);
		ImageRightTriangle = BufferedRightTriangle.getScaledInstance(240, 180, 100);
		
		//Creates image icons
		icn_History = new ImageIcon(ImageHistory);
		icn_RightTriangle = new ImageIcon(ImageRightTriangle);
		
		//-----------Creating GUI Objects
		//Images(Labels)
		
		//img_LadyBug = new JLabel(icn_History);
		//img_LadyBug.setBounds(750,20,60,45);
		//pnl_panel.add(img_LadyBug);
		
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
		
		sep_1 = new JSeparator();
		sep_1.setBounds(380, 190, 20, 1000);
		pnl_panel.add(sep_1);
		sep_1.setForeground(DARK_GREY);
		sep_1.setOrientation(1);
		
		sep_2 = new JSeparator();
		sep_2.setBounds(770, 190, 20, 1000);
		pnl_panel.add(sep_2);
		sep_2.setForeground(DARK_GREY);
		sep_2.setOrientation(1);
		
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
		rad_TriangleRight.setActionCommand(Actions.RIGHT.name());
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
		if (Started == false) {
			txt_Display.setText(DisplayString);
		}
		
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
		
		//Combo Boxes
		cbo_ConversionType = new JComboBox<>(Type);
		cbo_ConversionType.setBounds(830, 245, 250, 30);
		cbo_ConversionType.setActionCommand(Actions.TYPE.name());
		cbo_ConversionType.addActionListener(instance);
		pnl_panel.add(cbo_ConversionType);
		
		cbo_UnitStart = new JComboBox<>(optionsToChoose);
		cbo_UnitStart.setBounds(780, 335, 200, 30);
		cbo_UnitStart.setActionCommand(Actions.UNITSTART.name());
		cbo_UnitStart.addActionListener(instance);
		pnl_panel.add(cbo_UnitStart);
		cbo_UnitStart.setEnabled(false);
		
		cbo_UnitEnd = new JComboBox<>(optionsToChoose);
		cbo_UnitEnd.setBounds(780, 435, 200, 30);
		cbo_UnitEnd.setActionCommand(Actions.UNITEND.name());
		cbo_UnitEnd.addActionListener(instance);
		pnl_panel.add(cbo_UnitEnd);
		cbo_UnitEnd.setEnabled(false);
		//Check Boxes
        
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
		
		btn_AC2 = new JButton("AC");
		btn_AC2.setBounds(290, 565, 50, 50);
		btn_AC2.setActionCommand(Actions.RESET2.name());
		btn_AC2.addActionListener(instance);
		pnl_panel.add(btn_AC2);

		btn_Equals = new JButton("=");
		btn_Equals.setBounds(590, 570, 60, 70);
		btn_Equals.setActionCommand(Actions.EQUALS.name());
		btn_Equals.addActionListener(instance);
		pnl_panel.add(btn_Equals);
		
		btn_Equals2 = new JButton("=");
		btn_Equals2.setBounds(290, 615, 50, 50);
		btn_Equals2.setActionCommand(Actions.EQUALS2.name());
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
		
		btn_History = new JButton(icn_History);
		btn_History.setBounds(5, 100, 80, 80);
		btn_History.setActionCommand(Actions.HISTORY.name());
		btn_History.addActionListener(instance);
		pnl_panel.add(btn_History);
		btn_History.setVisible(false);
		
		//Frame config
		fr_frame.setResizable(false);
		fr_frame.setVisible(true);
		fr_frame.setTitle("Culminating Task - Lucas Wall - ICS3U");//Creates a title for the frame
	}//End of GUI
	public static void main(String[] args) {
		GUI();
	}
	public static void Check() {
		while(txt_Display.isVisible()) 
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
		}//End of while
	}
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) { 
		if (e.getActionCommand() == Actions.HISTORY.name()) {
			
		}
		else if (e.getActionCommand() == Actions.DEGREES.name()) {
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
		}
		else if (e.getActionCommand() == Actions.RADIANS.name()) {
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
		}
		else if (e.getActionCommand() == Actions.TOP.name()) {
			Theta = "Top";
		}
		else if (e.getActionCommand() == Actions.RIGHT.name()) {
			Theta = "Bottom";
		}
		else if (e.getActionCommand() == Actions.SIN.name()) {
			if (Started == true) {
				Register = txt_Display.getText();
				RegisterNumber = Double.parseDouble(Register);
				DisplayNumber = Double.parseDouble(DisplayString);
				DisplayString = "";
				if(RadDegMode.equals("Degrees")) {
					RegisterNumber = Math.toRadians(RegisterNumber);
					Answer = Math.sin(RegisterNumber);
				}
				else if(RadDegMode.equals("Radians")) {
					Answer = Math.sin(RegisterNumber);
				}
				AnswerString = "" + Answer;
				}
				else if (Started == false) {
				txt_Display.setText("ERROR");
				Started = false;
				}
			txt_Display.setText(AnswerString);
		}
		else if (e.getActionCommand() == Actions.COS.name()) {
			if (Started == true) {
				Register = txt_Display.getText();
				RegisterNumber = Double.parseDouble(Register);
				DisplayNumber = Double.parseDouble(DisplayString);
				DisplayString = "";
				if(RadDegMode.equals("Degrees")) {
					RegisterNumber = Math.toRadians(RegisterNumber);
					Answer = Math.cos(RegisterNumber);
				}
				else if(RadDegMode.equals("Radians")) {
					Answer = Math.cos(RegisterNumber);
				}
				AnswerString = "" + Answer;
				}
				else if (Started == false) {
				txt_Display.setText("ERROR");
				Started = false;
				}
			txt_Display.setText(AnswerString);
		}
		else if (e.getActionCommand() == Actions.TAN.name()) {
			if (Started == true) {
				Register = txt_Display.getText();
				RegisterNumber = Double.parseDouble(Register);
				DisplayNumber = Double.parseDouble(DisplayString);
				DisplayString = "";
				if(RadDegMode.equals("Degrees")) {
					RegisterNumber = Math.toRadians(RegisterNumber);
					Answer = Math.tan(RegisterNumber);
				}
				else if(RadDegMode.equals("Radians")) {
					Answer = Math.tan(RegisterNumber);
				}
				AnswerString = "" + Answer;
				}
				else if (Started == false) {
				txt_Display.setText("ERROR");
				Started = false;
				}
			txt_Display.setText(AnswerString);
		}
		else if (e.getActionCommand() == Actions.PERCENT.name()) {
			if (Started == true) {
			Register = txt_Display.getText();
			RegisterNumber = Double.parseDouble(Register);
			DisplayNumber = Double.parseDouble(DisplayString);
			DisplayString = "";
			Answer = RegisterNumber/100;
			AnswerString = "" + Answer;
			txt_Display.setText(AnswerString);
			}
			else if (Started == false) {
			txt_Display.setText("ERROR");
			Started = false;
			}
		}
		else if (e.getActionCommand() == Actions.EQUALS.name()) {
			if (Started == true) {
				if(!Register.equals("")) {
				RegisterNumber = Double.parseDouble(Register);
				DisplayNumber = Double.parseDouble(DisplayString);
				if(OperatorUsed.equals("+")) {
					Answer = RegisterNumber + DisplayNumber;
				}
				else if(OperatorUsed.equals("-")) {
					Answer = RegisterNumber - DisplayNumber;
				}
				else if(OperatorUsed.equals("x")) {
					Answer = RegisterNumber * DisplayNumber;
				}
				else if(OperatorUsed.equals("/")) {
					Answer = RegisterNumber / DisplayNumber;
				}
				AnswerString = "" + Answer;
				txt_Display.setText(AnswerString);
				}
				else if(Register.equals("")) {
					txt_Display.setText("ERROR");
				}
			}
			else if (Started == false) {
			}
			Started = false;
			Register = "";
			OperatorUsed = "";
		}
		else if (e.getActionCommand() == Actions.EQUALS2.name()) {
			AnswerString = "";
			dbl_Hyp = 0;
			dbl_Adj = 0;
			dbl_Opp = 0;
			
			str_AngleA = txt_A.getText();
			str_AngleB = txt_B.getText();
			
			if (!str_AngleA.equals("")) {
				dbl_AngleA = Double.parseDouble(str_AngleA);
			}
			if (!str_AngleB.equals("")) {
				dbl_AngleB = Double.parseDouble(str_AngleB);
			}
		
			if(Theta.equals("Top")) {
				str_Hyp = txt_c.getText();
				str_Adj = txt_b.getText();
				str_Opp = txt_a.getText();
				
			}
			else if(Theta.equals("Bottom")) {
				str_Hyp = txt_c.getText();
				str_Adj = txt_a.getText();
				str_Opp = txt_b.getText();
		
			}
			//Triangle Theoreum First
			if (!(dbl_AngleA == 0) && dbl_AngleB == 0) {
				Answer = 180 -(90+dbl_AngleA);
				AnswerString = "∠B = " + Answer;
				txt_B.setText(decimal.format(Answer));
			}
			else if (!(dbl_AngleB == 0) && dbl_AngleA == 0) {
				Answer = 180 -(90+dbl_AngleB);
				AnswerString = "∠A = " + Answer;
				txt_A.setText(decimal.format(Answer));
			}
			
			if (!str_Hyp.equals("")) {
				dbl_Hyp = Double.parseDouble(str_Hyp);
			}
			if (!str_Adj.equals("")) {
				dbl_Adj = Double.parseDouble(str_Adj);
			}
			if (!str_Opp.equals("")) {
				dbl_Opp = Double.parseDouble(str_Opp);
			}
			//Angle First
			if(Theta.equals("Top")) {
				if (!(dbl_Opp == 0) && !(dbl_Hyp == 0) && dbl_Adj == 0) {
					txt_a.setText(decimal.format(dbl_Opp));
					txt_c.setText(decimal.format(dbl_Hyp));
					if(RadDegMode.equals("Degrees")) {
						Answer = Math.asin(dbl_Opp/dbl_Hyp);
						Answer = Math.toDegrees(Answer);
						OtherAngle = 180-(90+Answer);
					}
					else if(RadDegMode.equals("Radians")) {
						Answer = Math.asin(dbl_Opp/dbl_Hyp);
						OtherAngle = 3.14159-(1.5708+Answer);
					}
					AnswerString = "∠A = " + Answer;
					txt_A.setText(decimal.format(Answer));
					txt_B.setText(decimal.format(OtherAngle));
					Pythagorean = Math.sqrt((dbl_Hyp*dbl_Hyp)-(dbl_Opp*dbl_Opp));
					txt_b.setText(decimal.format(Pythagorean));
				}
				else if (!(dbl_Adj == 0) && !(dbl_Hyp == 0) && dbl_Opp == 0) {
					txt_b.setText(decimal.format(dbl_Adj));
					txt_c.setText(decimal.format(dbl_Hyp));
					if(RadDegMode.equals("Degrees")) {
						Answer = Math.acos(dbl_Adj/dbl_Hyp);
						Answer = Math.toDegrees(Answer);
						OtherAngle = 180-(90+Answer);
					}
					else if(RadDegMode.equals("Radians")) {
						Answer = Math.acos(dbl_Adj/dbl_Hyp);
						OtherAngle = 3.14159-(1.5708+Answer);
					}
					AnswerString = "∠A = " + Answer;
					txt_A.setText(decimal.format(Answer));
					txt_B.setText(decimal.format(OtherAngle));
					Pythagorean = Math.sqrt((dbl_Hyp*dbl_Hyp)-(dbl_Adj*dbl_Adj));
					txt_a.setText(decimal.format(Pythagorean));
					
				}
				else if (!(dbl_Opp == 0) && !(dbl_Adj == 0) && dbl_Hyp == 0) {
					txt_a.setText(decimal.format(dbl_Opp));
					txt_b.setText(decimal.format(dbl_Adj));
					if(RadDegMode.equals("Degrees")) {
						Answer = Math.atan(dbl_Opp/dbl_Adj);
						OtherAngle = 3.14159-(1.5708+Answer);
					}
					else if(RadDegMode.equals("Radians")) {
						Answer = Math.atan(dbl_Opp/dbl_Adj);
						OtherAngle = 180-(90+Answer);
						OtherAngle = Math.toRadians(OtherAngle);
					}
					AnswerString = "∠A = " + Answer;
					txt_A.setText(decimal.format(Answer));
					txt_B.setText(decimal.format(OtherAngle));
					Pythagorean = Math.sqrt((dbl_Adj*dbl_Adj)+(dbl_Opp*dbl_Opp));
					txt_c.setText(decimal.format(Pythagorean));
				}
			}
			else if(Theta.equals("Bottom")) {
				if (!(dbl_Opp == 0) && !(dbl_Hyp == 0) && dbl_Adj == 0) {
					txt_b.setText(decimal.format(dbl_Opp));
					txt_c.setText(decimal.format(dbl_Hyp));
					if(RadDegMode.equals("Degrees")) {
						Answer = Math.asin(dbl_Opp/dbl_Hyp);
						Answer = Math.toDegrees(Answer);
						OtherAngle = 180-(90+Answer);
					}
					else if(RadDegMode.equals("Radians")) {
						Answer = Math.asin(dbl_Opp/dbl_Hyp);
						OtherAngle = 3.14159-(1.5708+Answer);
					}
					AnswerString = "∠B = " + Answer;
					txt_B.setText(decimal.format(Answer));
					txt_A.setText(decimal.format(OtherAngle));
					Pythagorean = Math.sqrt((dbl_Hyp*dbl_Hyp)-(dbl_Opp*dbl_Opp));
					txt_a.setText(decimal.format(Pythagorean));
				}
				else if (!(dbl_Adj == 0) && !(dbl_Hyp == 0) && dbl_Opp == 0) {
					txt_a.setText(decimal.format(dbl_Adj));
					txt_c.setText(decimal.format(dbl_Hyp));
					if(RadDegMode.equals("Degrees")) {
						Answer = Math.acos(dbl_Adj/dbl_Hyp);
						Answer = Math.toDegrees(Answer);
						OtherAngle = 180-(90+Answer);
					}
					else if(RadDegMode.equals("Radians")) {
						Answer = Math.acos(dbl_Adj/dbl_Hyp);
						OtherAngle = 3.14159-(1.5708+Answer);
					}
					AnswerString = "∠B = " + Answer;
					txt_B.setText(decimal.format(Answer));
					txt_A.setText(decimal.format(OtherAngle));
					Pythagorean = Math.sqrt((dbl_Hyp*dbl_Hyp)-(dbl_Adj*dbl_Adj));
					txt_b.setText(decimal.format(Pythagorean));
				}
				else if (!(dbl_Opp == 0) && !(dbl_Adj == 0) && dbl_Hyp == 0) {
					txt_a.setText(decimal.format(dbl_Adj));
					txt_b.setText(decimal.format(dbl_Opp));
					if(RadDegMode.equals("Degrees")) {
						Answer = Math.atan(dbl_Opp/dbl_Adj);
						Answer = Math.toDegrees(Answer);
						OtherAngle = 180-(90+Answer);
					}
					else if(RadDegMode.equals("Radians")) {
						Answer = Math.atan(dbl_Opp/dbl_Adj);
						OtherAngle = 3.14159-(1.5708+Answer);
					}
					AnswerString = "∠B = " + Answer;
					txt_B.setText(decimal.format(Answer));
					txt_A.setText(decimal.format(OtherAngle));
					Pythagorean = Math.sqrt((dbl_Adj*dbl_Adj)+(dbl_Opp*dbl_Opp));
					txt_c.setText(decimal.format(Pythagorean));
				}
			}
			txt_A.setEditable(false);
			txt_B.setEditable(false);
			txt_C.setEditable(false);
			txt_a.setEditable(false);
			txt_b.setEditable(false);
			txt_c.setEditable(false);
		}
		else if (e.getActionCommand() == Actions.ADD.name()) {
			OperatorUsed = "+";
			Register = txt_Display.getText();
			DisplayString = "";
			txt_Display.setText(DisplayString);
		}
		else if (e.getActionCommand() == Actions.SUBTRACT.name()) {
			OperatorUsed = "-";
			Register = txt_Display.getText();
			DisplayString = "";
			txt_Display.setText(DisplayString);
		}
		else if (e.getActionCommand() == Actions.MULTIPLY.name()) {
			OperatorUsed = "x";
			Register = txt_Display.getText();
			DisplayString = "";
			txt_Display.setText(DisplayString);
		}
		else if (e.getActionCommand() == Actions.DIVIDE.name()) {
			if (Started == true) {
				OperatorUsed = "/";
				Register = txt_Display.getText();
				DisplayString = "";
			}
			else if (Started == false) {
				DisplayString ="ERROR";
			}
			txt_Display.setText(DisplayString);
		}
		else if (e.getActionCommand() == Actions.DECIMAL.name()) {
			if (Started == true) {
				DisplayString += ".";
			}
			else if (Started == false) {
				DisplayString ="";
				DisplayString += ".";
				Started = true;
			}
			txt_Display.setText(DisplayString);
		}
		else if (e.getActionCommand() == Actions.ZERO.name()) {
			if (Started == true) {
				DisplayString += "0";
			}
			else if (Started == false) {
				DisplayString ="";
				DisplayString += "0";
				Started = true;
			}
			txt_Display.setText(DisplayString);
		}
		else if (e.getActionCommand() == Actions.ONE.name()) {
			if (Started == true) {
				DisplayString += "1";
			}
			else if (Started == false) {
					DisplayString ="";
					DisplayString += "1";
					Started = true;
			}
			txt_Display.setText(DisplayString);
		}
		else if (e.getActionCommand() == Actions.TWO.name()) {
			if (Started == true) {
				DisplayString += "2";
			}
			else if (Started == false) {
				DisplayString ="";
				DisplayString += "2";
				Started = true;
			}
			txt_Display.setText(DisplayString);
		}
		else if (e.getActionCommand() == Actions.THREE.name()) {
			if (Started == true) {
				DisplayString += "3";
			}
			else if (Started == false) {
				DisplayString ="";
				DisplayString += "3";
				Started = true;
			}
			txt_Display.setText(DisplayString);
		}
		else if (e.getActionCommand() == Actions.FOUR.name()) {
			if (Started == true) {
				DisplayString += "4";
			}
			else if (Started == false) {
				DisplayString ="";
				DisplayString += "4";
				Started = true;
			}
			txt_Display.setText(DisplayString);
		}
		else if (e.getActionCommand() == Actions.FIVE.name()) {
			if (Started == true) {
				DisplayString += "5";
			}
			else if (Started == false) {
				DisplayString ="";
				DisplayString += "5";
				Started = true;
			}
			txt_Display.setText(DisplayString);
		}
		else if (e.getActionCommand() == Actions.SIX.name()) {
			if (Started == true) {
				DisplayString += "6";
			}
			else if (Started == false) {
				DisplayString ="";
				DisplayString += "6";
				Started = true;
			}
			txt_Display.setText(DisplayString);
		}
		else if (e.getActionCommand() == Actions.SEVEN.name()) {
			if (Started == true) {
				DisplayString += "7";
			}
			else if (Started == false) {
				DisplayString ="";
				DisplayString += "7";
				Started = true;
			}
			txt_Display.setText(DisplayString);
		}
		else if (e.getActionCommand() == Actions.EIGHT.name()) {
			if (Started == true) {
				DisplayString += "8";
			}
			else if (Started == false) {
				DisplayString ="";
				DisplayString += "8";
				Started = true;
			}
			txt_Display.setText(DisplayString);
		}
		else if (e.getActionCommand() == Actions.NINE.name()) {
			if (Started == true) {
				DisplayString += "9";
			}
			else if (Started == false) {
				DisplayString ="";
				DisplayString += "9";
				Started = true;
			}
			txt_Display.setText(DisplayString);
		}
		else if (e.getActionCommand() == Actions.RESET.name()) {
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
		}
		else if (e.getActionCommand() == Actions.RESET2.name()) {
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
		}
		/*
		else if (e.getActionCommand() == Actions.TYPE.name()) {
			Type = (String) cbo_ConversionType.getSelectedItem();
			if(Type.equals("Select Type of Conversion")) {
				cbo_UnitStart.setEnabled(false);
				cbo_UnitEnd.setEnabled(false);
			}
			else if(Type.equals("Distance")) {
				String[] Array_DistanceStart = {"Select Unit", "Millimeter", "Centimeter", "Meter", "Kilometer"};
				String[] Array_DistanceEnd = {"Select Unit", "Millimeter", "Centimeters", "Meter", "Kilometer"};
				
				DefaultComboBoxModel<String> Start = new DefaultComboBoxModel<>(Array_DistanceStart);
				DefaultComboBoxModel<String> End = new DefaultComboBoxModel<>(Array_DistanceEnd);
				cbo_UnitStart.setModel(Start);
				cbo_UnitEnd.setModel(End);
				
				cbo_UnitStart.setEnabled(true);
				cbo_UnitEnd.setEnabled(true);
			}
			else if(Type.equals("Pressure")) {
				String[] Array_DistanceStart = {"Select Unit", "Pascal", "Kilopascal", "Torr", "Atmosphere"};
				String[] Array_DistanceEnd = {"Select Unit", "Pascal", "Kilopascal", "Torr", "Atmosphere"};
				
				DefaultComboBoxModel<String> Start = new DefaultComboBoxModel<>(Array_DistanceStart);
				DefaultComboBoxModel<String> End = new DefaultComboBoxModel<>(Array_DistanceEnd);
				cbo_UnitStart.setModel(Start);
				cbo_UnitEnd.setModel(End);
				
				cbo_UnitStart.setEnabled(true);
				cbo_UnitEnd.setEnabled(true);
			}
			else if(Type.equals("Temperature")) {
				String[] Array_DistanceStart = {"Select Unit", "Celsius", "Fahrenheit", "Kelvin"};
				String[] Array_DistanceEnd = {"Select Unit", "Celsius", "Fahrenheit", "Kelvin"};
				
				DefaultComboBoxModel<String> Start = new DefaultComboBoxModel<>(Array_DistanceStart);
				DefaultComboBoxModel<String> End = new DefaultComboBoxModel<>(Array_DistanceEnd);
				cbo_UnitStart.setModel(Start);
				cbo_UnitEnd.setModel(End);
				
				cbo_UnitStart.setEnabled(true);
				cbo_UnitEnd.setEnabled(true);
			}
			else if(Type.equals("Energy")) {
				String[] Array_DistanceStart = {"Select Unit", "Kilocalorie", "Joule", "Kilojoule"};
				String[] Array_DistanceEnd = {"Select Unit", "Celsius", "Fahrenheit", "Kelvin"};
				
				DefaultComboBoxModel<String> Start = new DefaultComboBoxModel<>(Array_DistanceStart);
				DefaultComboBoxModel<String> End = new DefaultComboBoxModel<>(Array_DistanceEnd);
				cbo_UnitStart.setModel(Start);
				cbo_UnitEnd.setModel(End);
				
				cbo_UnitStart.setEnabled(true);
				cbo_UnitEnd.setEnabled(true);
			}
		}
		else if (e.getActionCommand() == Actions.UNITSTART.name()) {
			
		}
		else if (e.getActionCommand() == Actions.UNITEND.name()) {
			
		}
		*/
		else if (e.getActionCommand() == Actions.QUIT.name()) {
			fr_frame.dispose();
			System.exit(0);
		}
	}
}
