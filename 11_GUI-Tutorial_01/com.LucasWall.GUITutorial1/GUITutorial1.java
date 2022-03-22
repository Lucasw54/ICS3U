package com.LucasWall.GUITutorial1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class GUITutorial1 implements ActionListener {
	
	//Gui Globals
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel TitleLabel;
	private static JLabel ThisIsALabelLabel;
	private static JLabel ThisIsColourAndFont;
	private static JLabel ThisIsAPushButtonLabel;
	private static JLabel ThisIsATextFieldLabel;
	private static JLabel ThisLabelWillChangeLabel;
	private static JSeparator Section1;
	private static JSeparator Section2;
	private static JSeparator Section3;
	private static JTextField TextToLabelTextField;
	private static JButton TurnOnButton;
	private static JButton TurnOffButton;
	private static JButton TextToLabelButton;
	private static JButton ExitButton;
	
	//Other Globals
	private static String TextInTextBox;
	
	public static final Color VERY_LIGHT_RED = new Color(255,102,102);
	public static final Color DARK_GREY = new Color(102,102,102);
	
	public enum Actions
	{//Beginning of Actions
		TURNON,
		TURNOFF,
		TEXTTOLABEL,
		EXIT
		
	}//End of Actions
	
	public static void GUI() {
		GUITutorial1 instance = new GUITutorial1();
		
		//Panel Config
		panel = new JPanel();
		panel.setBackground(VERY_LIGHT_RED);
		panel.setLayout(null);
		
		//Frame Config
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(600, 400);
		//frame.setLocationRelativeTo(null);
		frame.setBackground(DARK_GREY);
		
		
		//Labels
		TitleLabel = new JLabel("Text Field to Label Machine");
		TitleLabel.setBounds(10,10,600,20);
		panel.add(TitleLabel);
		TitleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		ThisIsALabelLabel = new JLabel("This is a label!");
		ThisIsALabelLabel.setBounds(120, 80, 120, 20);
		panel.add(ThisIsALabelLabel);
		
		ThisIsColourAndFont = new JLabel("Check out this Neat Colour and Font!!");
		ThisIsColourAndFont.setBounds(250,80,600,20);
		panel.add(ThisIsColourAndFont);
		
		ThisIsAPushButtonLabel = new JLabel("This is a Push Button!!");
		ThisIsAPushButtonLabel.setBounds(120 ,180,600,20);
		panel.add(ThisIsAPushButtonLabel);
		
		ThisIsATextFieldLabel = new JLabel("Use this Text Field to Change the Label Below");
		ThisIsATextFieldLabel.setBounds(80,260,600,20);
		panel.add(ThisIsATextFieldLabel);
		ThisIsATextFieldLabel.setVisible(false);
		
		ThisLabelWillChangeLabel = new JLabel("This Label will change!");
		ThisLabelWillChangeLabel.setBounds(0,340,600,20);
		panel.add(ThisLabelWillChangeLabel);
		ThisLabelWillChangeLabel.setHorizontalAlignment(JLabel.CENTER);
		ThisLabelWillChangeLabel.setVisible(false);
		
		//Separators
		Section1 = new JSeparator();
		Section1.setBounds(0, 40, 600, 25);
		panel.add(Section1);
		Section1.setForeground(DARK_GREY);
		
		Section2 = new JSeparator();
		Section2.setBounds(100, 150, 400, 25);
		panel.add(Section2);
		Section2.setForeground(DARK_GREY);
		
		Section3 = new JSeparator();
		Section3.setBounds(100, 220, 400, 25);
		panel.add(Section3);
		Section3.setForeground(DARK_GREY);
		
		//TextFields
		TextToLabelTextField = new JTextField(20);
		TextToLabelTextField.setBounds(380, 260, 165, 25);
		panel.add(TextToLabelTextField);
		TextToLabelTextField.setVisible(false);
		
		//Buttons
		TurnOnButton = new JButton("Turn on");
		TurnOnButton.setBounds(280, 180, 80, 25);
		TurnOnButton.setActionCommand(Actions.TURNON.name());
		TurnOnButton.addActionListener(instance);
		panel.add(TurnOnButton);

		TurnOffButton = new JButton("Turn off");
		TurnOffButton.setBounds(370, 180, 80, 25);
		TurnOffButton.setActionCommand(Actions.TURNOFF.name());
		TurnOffButton.addActionListener(instance);
		panel.add(TurnOffButton);
		
		TextToLabelButton = new JButton("Text to Label");
		TextToLabelButton.setBounds(175, 300, 250, 25);
		TextToLabelButton.setActionCommand(Actions.TEXTTOLABEL.name());
		TextToLabelButton.addActionListener(instance);
		panel.add(TextToLabelButton);
		TextToLabelButton.setVisible(false);
		
		ExitButton = new JButton("Exit");
		ExitButton.setBounds(10, 10, 80, 25);
		ExitButton.setActionCommand(Actions.EXIT.name());
		ExitButton.addActionListener(instance);
		panel.add(ExitButton);
		
		//Frame config
		frame.setVisible(true);
		frame.setTitle("Working with GUI");
	}
	
	public static void main(String[] args) {
		GUI();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{//Beginning of actionPerformed
		
		//Button Calculate
		if (e.getActionCommand() == Actions.TURNON.name())
		{//Beginning of if
			TextToLabelTextField.setVisible(true);
			TextToLabelButton.setVisible(true);
			ThisLabelWillChangeLabel.setVisible(true);
			ThisIsATextFieldLabel.setVisible(true);
		}//End of if
		else if (e.getActionCommand() == Actions.TURNOFF.name())
		{//Beginning of else if
			TextToLabelTextField.setVisible(false);
			TextToLabelButton.setVisible(false);
			ThisLabelWillChangeLabel.setVisible(false);
			ThisIsATextFieldLabel.setVisible(false);
			TextToLabelTextField.setText("");
			TextInTextBox = "This Label will change!";
			ThisLabelWillChangeLabel.setText(TextInTextBox);
			
		}//End of else if
		else if (e.getActionCommand() == Actions.TEXTTOLABEL.name())
		{//Beginning of else if
			TextInTextBox = TextToLabelTextField.getText();
			ThisLabelWillChangeLabel.setText(TextInTextBox);
			
		}//End of else if
		else if (e.getActionCommand() == Actions.EXIT.name())
		{//Beginning of else if
			frame.dispose();
		}//End of else if
	}//End of actionPerformed
}
