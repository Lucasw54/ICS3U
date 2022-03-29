/*
 * Name:Lucas Wall
 * Class code: ICS3U 
 * Date:Friday, March 28, 2022 
 * Assignment #: 11
 * Description: Explore GUI elements aswell as set text and get text methods, using proper naming 
 * conventions to create a basic java GUI. The goal of this programe is to 
 */
package com.LucasWall.GUITutorial1;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class GUITutorial1 implements ActionListener
{//Beginning of GUITutorial1
	//---------Gui Globals
	//Labels
	private static JPanel pnl_panel;
	private static JFrame fr_frame;
	private static JLabel lbl_Title;
	private static JLabel lbl_ThisIsALabel;
	private static JLabel lbl_ThisIsColourAndFont;
	private static JLabel lbl_ThisIsAPushButton;
	private static JLabel lbl_ThisIsATextField;
	private static JLabel lbl_ThisLabelWillChange;
	
	//Separators
	private static JSeparator sep_Title;
	private static JSeparator sep_Top;
	private static JSeparator sep_Bottom;
	
	//Textfields
	private static JTextField txt_TextToLabel;
	
	//Buttons
	private static JButton btn_TurnOn;
	private static JButton btn_TurnOff;
	private static JButton btn_TextToLabel;
	private static JButton btn_Exit;
	
	//------Other Globals
	private static String TextInTextBox;
	
	//Creating Custom Colours
	private static final Color VERY_LIGHT_RED = new Color(255,102,102);
	private static final Color DARK_GREY = new Color(102,102,102);
	
	public enum Actions
	{//Beginning of Actions
		TURNON, //Action to turn on the text to label maker
		TURNOFF, //Action to turn off the text to label maker
		TEXTTOLABEL, //Action which sets 'lbl_ThisLabelWillChange' to whatever is in the 'txt_TextToLabel'
		EXIT//Dispose's the frame and ends program
	}//End of Actions
	
	public static void GUI()
	{//Beginning of GUI
		//Creates a new instance variable
		GUITutorial1 instance = new GUITutorial1();
		
		//Panel Config
		pnl_panel = new JPanel();
		pnl_panel.setBackground(VERY_LIGHT_RED);
		pnl_panel.setLayout(null);
		
		//Frame Config
		fr_frame = new JFrame();
		fr_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr_frame.add(pnl_panel);
		fr_frame.setSize(600, 400);
		fr_frame.setLocationRelativeTo(null);
		fr_frame.setBackground(DARK_GREY);
		
		//Labels
		lbl_Title = new JLabel("Text Field to Label Machine");
		lbl_Title.setBounds(10,10,600,20);
		pnl_panel.add(lbl_Title);
		lbl_Title.setHorizontalAlignment(JLabel.CENTER);
		lbl_Title.setFont(new Font("Serif", Font.BOLD, 18));
		
		lbl_ThisIsALabel = new JLabel("This is a label!");
		lbl_ThisIsALabel.setBounds(120, 80, 120, 20);
		pnl_panel.add(lbl_ThisIsALabel);
		
		lbl_ThisIsColourAndFont = new JLabel("Check out this Neat Colour and Font!!");
		lbl_ThisIsColourAndFont.setBounds(250,80,600,20);
		pnl_panel.add(lbl_ThisIsColourAndFont);
		
		lbl_ThisIsAPushButton = new JLabel("This is a Push Button!!");
		lbl_ThisIsAPushButton.setBounds(120 ,180,600,20);
		pnl_panel.add(lbl_ThisIsAPushButton);
		
		lbl_ThisIsATextField = new JLabel("Use this Text Field to Change the Label Below");
		lbl_ThisIsATextField.setBounds(80,260,600,20);
		pnl_panel.add(lbl_ThisIsATextField);
		lbl_ThisIsATextField.setVisible(false);
		
		lbl_ThisLabelWillChange = new JLabel("This Label will change!");
		lbl_ThisLabelWillChange.setBounds(0,340,600,20);
		pnl_panel.add(lbl_ThisLabelWillChange);
		lbl_ThisLabelWillChange.setHorizontalAlignment(JLabel.CENTER);
		lbl_ThisLabelWillChange.setVisible(false);
		
		//Separators
		sep_Title = new JSeparator();
		sep_Title.setBounds(0, 40, 600, 25);
		pnl_panel.add(sep_Title);
		sep_Title.setForeground(DARK_GREY);
		
		sep_Top = new JSeparator();
		sep_Top.setBounds(100, 150, 400, 25);
		pnl_panel.add(sep_Top);
		sep_Top.setForeground(DARK_GREY);
		
		sep_Bottom = new JSeparator();
		sep_Bottom.setBounds(100, 220, 400, 25);
		pnl_panel.add(sep_Bottom);
		sep_Bottom.setForeground(DARK_GREY);
		
		//TextFields
		txt_TextToLabel= new JTextField(20);
		txt_TextToLabel.setBounds(380, 260, 165, 25);
		pnl_panel.add(txt_TextToLabel);
		txt_TextToLabel.setVisible(false);
		
		//Buttons
		btn_TurnOn = new JButton("Turn on");
		btn_TurnOn.setBounds(280, 180, 80, 25);
		btn_TurnOn.setActionCommand(Actions.TURNON.name());
		btn_TurnOn.addActionListener(instance);
		pnl_panel.add(btn_TurnOn);

		btn_TurnOff = new JButton("Turn off");
		btn_TurnOff.setBounds(370, 180, 80, 25);
		btn_TurnOff.setActionCommand(Actions.TURNOFF.name());
		btn_TurnOff.addActionListener(instance);
		pnl_panel.add(btn_TurnOff);
		
		btn_TextToLabel = new JButton("Text to Label");
		btn_TextToLabel.setBounds(175, 300, 250, 25);
		btn_TextToLabel.setActionCommand(Actions.TEXTTOLABEL.name());
		btn_TextToLabel.addActionListener(instance);
		pnl_panel.add(btn_TextToLabel);
		btn_TextToLabel.setVisible(false);
		
		btn_Exit = new JButton("Exit");
		btn_Exit.setBounds(10, 10, 80, 25);
		btn_Exit.setActionCommand(Actions.EXIT.name());
		btn_Exit.addActionListener(instance);
		pnl_panel.add(btn_Exit);
		
		//Frame config
		fr_frame.setVisible(true);
		fr_frame.setTitle("Working with GUI");
	}//End of GUI
	
	public static void main(String[] args)
	{//Beginning of Main
		GUI();
	}//End of Main
	
	@Override
	public void actionPerformed(ActionEvent e)
	{//Beginning of actionPerformed
		if (e.getActionCommand() == Actions.TURNON.name())
		{//Beginning of if
			txt_TextToLabel.setVisible(true);
			btn_TextToLabel.setVisible(true);
			lbl_ThisLabelWillChange.setVisible(true);
			lbl_ThisIsATextField.setVisible(true);
		}//End of if
		else if (e.getActionCommand() == Actions.TURNOFF.name())
		{//Beginning of else if
			txt_TextToLabel.setVisible(false);
			btn_TextToLabel.setVisible(false);
			lbl_ThisLabelWillChange.setVisible(false);
			lbl_ThisIsATextField.setVisible(false);
			txt_TextToLabel.setText("");
			TextInTextBox = "This Label will change!";
			lbl_ThisLabelWillChange.setText(TextInTextBox);
			
		}//End of else if
		else if (e.getActionCommand() == Actions.TEXTTOLABEL.name())
		{//Beginning of else if
			TextInTextBox = txt_TextToLabel.getText();
			lbl_ThisLabelWillChange.setText(TextInTextBox);
			
		}//End of else if
		else if (e.getActionCommand() == Actions.EXIT.name())
		{//Beginning of else if
			fr_frame.dispose();
			System.exit(0);
		}//End of else if
	}//End of actionPerformed
}//End of GUITutorial1
