package com.LucasWall.GUITutorial2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;

public class GUITutorial2 implements ActionListener {
	
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
	private static JRadioButton SizeRadio;
	public static JComboBox<String> SelectSizeComboBox;
	public static JComboBox<String> SelectHowMany;
	private static JCheckBox SizeCheckBox;
	private static JButton TurnOnButton;
	private static JButton TurnOffButton;
	private static JButton TextToLabelButton;
	private static JButton ExitButton;
	
	//Other Globals
	private static String TextInTextBox;
	
	public static final Color NEW_BLUE = new Color(147, 196, 180);
	public static final Color DARK_GREY = new Color(102,102,102);
	
	public enum Actions
	{//Beginning of Actions
		ORDER1,
		ORDER2,
		EXIT
	}//End of Actions
	
	public static void GUI() {
		GUITutorial2 instance = new GUITutorial2();
		String[] optionsToChoose = { "Select Size", "Small", "Medium", "Large"};
		String[] optionsToChoose2 = { "Select No.", "1", "2", "3"};
		
		//Panel Config
		panel = new JPanel();
		panel.setBackground(NEW_BLUE);
		panel.setLayout(null);
		
		//Frame Config
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(600, 600);
		//frame.setLocationRelativeTo(null);
		frame.setBackground(DARK_GREY);
		
		
		//Labels
		TitleLabel = new JLabel("Radio's, Dropdowns, and Check Boxes!");
		TitleLabel.setBounds(10,10,600,20);
		panel.add(TitleLabel);
		TitleLabel.setHorizontalAlignment(JLabel.CENTER);
		TitleLabel.setFont(new Font("Serif", Font.BOLD, 18));
		
		ThisIsALabelLabel = new JLabel("Here is a Radio Button: ");
		ThisIsALabelLabel.setBounds(30, 60, 250, 20);
		panel.add(ThisIsALabelLabel);
		
		ThisIsAPushButtonLabel = new JLabel("This is a Combo Box: ");
		ThisIsAPushButtonLabel.setBounds(30 ,260 ,600,20);
		panel.add(ThisIsAPushButtonLabel);
		
		ThisIsATextFieldLabel = new JLabel("This is a Check Box: ");
		ThisIsATextFieldLabel.setBounds(30,393,600,20);
		panel.add(ThisIsATextFieldLabel);
		
		//Separators
		Section1 = new JSeparator();
		Section1.setBounds(0, 40, 600, 25);
		panel.add(Section1);
		Section1.setForeground(DARK_GREY);
		
		Section2 = new JSeparator();
		Section2.setBounds(15, 206, 570, 25);
		panel.add(Section2);
		Section2.setForeground(DARK_GREY);
		
		Section3 = new JSeparator();
		Section3.setBounds(15, 373, 570, 25);
		panel.add(Section3);
		Section3.setForeground(DARK_GREY);
		
		//Radio Buttons
		JRadioButton r1 = new JRadioButton("Small");    
		r1.setBounds(180,55,100,30);  
		panel.add(r1);
		
		JRadioButton r2 = new JRadioButton("Medium");      
		r2.setBounds(180,105,100,30);    
		panel.add(r2);
		
		JRadioButton r3 = new JRadioButton("Large");      
		r3.setBounds(180,155,100,30);    
		panel.add(r3);
		
		ButtonGroup bg = new ButtonGroup();    
		bg.add(r1);
		bg.add(r2); 
		bg.add(r3); 
		
		//Combo Boxes
		SelectSizeComboBox = new JComboBox<>(optionsToChoose);
		SelectSizeComboBox.setBounds(180, 260, 150, 20);
		panel.add(SelectSizeComboBox);
		
		SelectHowMany = new JComboBox<>(optionsToChoose2);
		SelectHowMany.setBounds(180, 290, 150, 20);
		panel.add(SelectHowMany);
		
		//Check Boxes
        JCheckBox checkBox1 = new JCheckBox("Small");  
        checkBox1.setBounds(180,390, 100,50);  
        
        JCheckBox checkBox2 = new JCheckBox("Medium", true);  
        checkBox2.setBounds(180,440, 100,50);  
        
        JCheckBox checkBox3 = new JCheckBox("Large", true);  
        checkBox3.setBounds(180,490, 100,50);  
     
        panel.add(checkBox1);  
        panel.add(checkBox2);  
        panel.add(checkBox3);  
		
		//Buttons
		TurnOnButton = new JButton("Place Order");
		TurnOnButton.setBounds(280, 60, 160, 25);
		TurnOnButton.setActionCommand(Actions.ORDER1.name());
		TurnOnButton.addActionListener(instance);
		panel.add(TurnOnButton);

		TurnOffButton = new JButton("Place Order");
		TurnOffButton.setBounds(450, 393, 160, 25);
		TurnOffButton.setActionCommand(Actions.ORDER2.name());
		TurnOffButton.addActionListener(instance);
		panel.add(TurnOffButton);
		
		ExitButton = new JButton("Exit");
		ExitButton.setBounds(10, 10, 80, 25);
		ExitButton.setActionCommand(Actions.EXIT.name());
		ExitButton.addActionListener(instance);
		panel.add(ExitButton);
		
		//Frame config
		frame.setVisible(true);
		frame.setTitle("Working with Radios & Combo Boxes");
	}
	
	public static void main(String[] args) {
		GUI();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{//Beginning of actionPerformed
		
		//Button Calculate
		if (e.getActionCommand() == Actions.ORDER1.name())
		{//Beginning of if

		}//End of if
		else if (e.getActionCommand() == Actions.ORDER2.name())
		{//Beginning of else if

		}//End of else if
		else if (e.getActionCommand() == Actions.EXIT.name())
		{//Beginning of else if
			frame.dispose();
		}//End of else if
	}//End of actionPerformed
}
