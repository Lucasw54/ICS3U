/*
 * Name:Lucas Wall
 * Class code: ICS3U 
 * Date:Friday, March 29, 2022 
 * Assignment #: 11.5
 * Description: Further Exploring GUI elements
 */
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

public class GUITutorial2 implements ActionListener
{//Beginning of GUITutorial2
	
	//----------Gui Globals
	private static JPanel pnl_panel;
	private static JFrame fr_frame;
	
	//Labels
	private static JLabel lbl_Title;
	private static JLabel lbl_ThisIsARadioButton;
	private static JLabel lbl_ThisIsAComboBox;
	private static JLabel lbl_ThisIsACheckBox;
	private static JLabel lbl_YouOrderedRadio;
	private static JLabel lbl_SizeOrderedComboBox;
	private static JLabel lbl_NumOrderedComboBox;
	private static JLabel lbl_YouOrderedCheckBox;
	
	//Separators
	private static JSeparator sep_Title;
	private static JSeparator sep_Top;
	private static JSeparator sep_Bottom;
	private static JSeparator sep_ResetVertical;
	private static JSeparator sep_ResetHorizontal;
	
	//Radio Buttons
	private static JRadioButton rad_Small;
	private static JRadioButton rad_Medium;
	private static JRadioButton rad_Large;
	private static JRadioButton rad_SmallOnClick;
	
	//Combo Boxes
	private static JComboBox<String> cbo_SelectSize;
	private static JComboBox<String> cbo_SelectHowMany;
	
	//Check Boxes
	private static JCheckBox chk_Small;
	private static JCheckBox chk_Medium;
	private static JCheckBox chk_Large;
	
	//Buttoms
	private static JButton btn_OrderRadio;
	private static JButton btn_OrderCheckBox;
	private static JButton btn_Reset;
	private static JButton btn_Exit;
	
	//----------Other Globals
	private static String RadioSize = "";
	private static String ComboSize = "";
	private static String ComboAmt = "";
	private static String CheckBoxSize1 = "";
	private static String CheckBoxSize2 = "";
	private static String CheckBoxSize3 = "";
	private static double a = 0;
	private static double b = 0;
	private static double c = 0;
	@SuppressWarnings("unused")
	private static Boolean Check = true;
	private static ButtonGroup bg_Size;
	
	//New Colours
	public static final Color NEW_BLUE = new Color(147, 196, 180);
	public static final Color DARK_GREY = new Color(102,102,102);
	public static final Color WRONG_RED = new Color(251, 255, 250);
	
	public enum Actions
	{//Beginning of Actions
		ORDERRADIO,//Action for the 'btn_OrderRadio' that disables radio buttons and makes a label
		//Visible saying what was ordered.
		RADIOSMALL,//Action on the 'Small' radio button to enable the OrderRadio button
		RADIOMEDIUM,//Action on the 'Medium' radio button to enable the OrderRadio button
		RADIOLARGE,//Action on the 'Large' radio button to enable the OrderRadio button
		RADIOSMALLONCLICK,//Action on the 'Small' radio button that does not need the button to be pressed
		//down to show the you ordered label.
		ORDERCHECKBOX,//Action for the 'btn_OrderCheckBox' that disables the check boxes and makes a label
		//Visible saying what was ordered.
		CHECKSMALL,//Action on the 'Small' CheckBox to enable the OrderCheckBox button.
		CHECKMEDIUM,//Action on the 'Medium' CheckBox to enable the OrderCheckBox button.
		CHECKLARGE,//Action on the 'Large' CheckBox to enable the OrderCheckBox button.
		
		RESET,//Action that resets the GUI elements so that they are enabled again.
		EXIT////Dispose's the frame and ends the program
	}//End of Actions
	
	public static void CheckComboBox()
	{//Beginning of CheckComboBox
		while(Check = true) 
		{//Beginning of while
			try {//Beginning of try
				//Make invisble while waiting for input
				Thread.sleep(25);
			}//End of try
			catch (InterruptedException e) 
			{//Beginning of catch
				e.printStackTrace();
			}//End of catch
			//-----Creates a pop-up that that says what you ordered
			ComboSize = (String) cbo_SelectSize.getSelectedItem();
			if(ComboSize == "Select Size")
			{//Beginning of if
				lbl_SizeOrderedComboBox.setText("←Select Size");
				lbl_SizeOrderedComboBox.setForeground(WRONG_RED);
				lbl_SizeOrderedComboBox.setFont(new Font("Serif", Font.BOLD, 18));
			}//End of if
			else if(ComboSize != "Select Size")
			{//Beginning of else if
				cbo_SelectSize.setEnabled(false);
				lbl_SizeOrderedComboBox.setText("You ordered A: " + ComboSize);
				lbl_SizeOrderedComboBox.setForeground(Color.black);
				lbl_SizeOrderedComboBox.setVisible(true);
				lbl_SizeOrderedComboBox.setFont(new Font("", Font.PLAIN, 14));
				lbl_NumOrderedComboBox.setVisible(true);
			}//End of else if
			
			//-----Creates a pop-up that that says how many you ordered
			ComboAmt = (String) cbo_SelectHowMany.getSelectedItem();
			if(ComboAmt == "Select No.")
			{//Beginning of if
				lbl_NumOrderedComboBox.setText("←Select How Many");
				lbl_NumOrderedComboBox.setForeground(WRONG_RED);
				lbl_NumOrderedComboBox.setFont(new Font("Serif", Font.BOLD, 18));
			}//End of if
			else if(ComboAmt != "Select No.")
			{//Beginning of if
				cbo_SelectHowMany.setEnabled(false);
				lbl_NumOrderedComboBox.setText("# Ordered: " + ComboAmt);
				lbl_NumOrderedComboBox.setVisible(true);
				lbl_NumOrderedComboBox.setForeground(Color.black);
				lbl_NumOrderedComboBox.setFont(new Font("", Font.PLAIN, 14));
				lbl_SizeOrderedComboBox.setVisible(true);
			}//End of if
		}//End of while
	}//End of CheckComboBox
	public static void GUI()
	{//Beginning of GUI
		GUITutorial2 instance = new GUITutorial2();	//Creates a new instance variable
		String[] optionsToChooseSize = { "Select Size", "Small", "Medium", "Large"};//Creates an array for the size cbo box
		String[] optionsToChooseAmount = { "Select No.", "1", "2", "3"};//Creates an array for the amount cbo box

		//Panel Config
		pnl_panel = new JPanel();
		pnl_panel.setBackground(NEW_BLUE);
		pnl_panel.setLayout(null);
		
		//Frame Config
		fr_frame = new JFrame();
		fr_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr_frame.add(pnl_panel);
		fr_frame.setSize(600, 600);
		fr_frame.setLocationRelativeTo(null);
		fr_frame.setBackground(DARK_GREY);
		
		//Labels
		lbl_Title = new JLabel("Radio's, Dropdowns, and Check Boxes!");
		lbl_Title.setBounds(10,10,600,20);
		pnl_panel.add(lbl_Title);
		lbl_Title.setHorizontalAlignment(JLabel.CENTER);
		lbl_Title.setFont(new Font("null", Font.BOLD, 18));
		
		lbl_ThisIsARadioButton = new JLabel("Here is a Radio Button: ");
		lbl_ThisIsARadioButton.setBounds(30, 60, 250, 20);
		pnl_panel.add(lbl_ThisIsARadioButton);
		
		lbl_YouOrderedRadio = new JLabel("You ordered A: " + RadioSize);
		lbl_YouOrderedRadio.setBounds(290, 100, 200, 25);
		pnl_panel.add(lbl_YouOrderedRadio);
		lbl_YouOrderedRadio.setVisible(false);
		
		lbl_SizeOrderedComboBox = new JLabel("←Select Size");
		lbl_SizeOrderedComboBox.setBounds(350, 260, 200, 25);
		pnl_panel.add(lbl_SizeOrderedComboBox);
		lbl_SizeOrderedComboBox.setVisible(false);
		lbl_SizeOrderedComboBox.setForeground(WRONG_RED);
		lbl_SizeOrderedComboBox.setFont(new Font("Serif", Font.BOLD, 18));
		
		lbl_NumOrderedComboBox = new JLabel("←Select How Many");
		lbl_NumOrderedComboBox.setBounds(350, 290, 200, 25);
		pnl_panel.add(lbl_NumOrderedComboBox);
		lbl_NumOrderedComboBox.setVisible(false);
		lbl_NumOrderedComboBox.setForeground(WRONG_RED);
		lbl_NumOrderedComboBox.setFont(new Font("Serif", Font.BOLD, 18));
		
		lbl_YouOrderedCheckBox = new JLabel("You ordered A: " + CheckBoxSize1 + "," + CheckBoxSize2 + "," + CheckBoxSize3);
		lbl_YouOrderedCheckBox.setBounds(290, 435, 280, 25);
		pnl_panel.add(lbl_YouOrderedCheckBox);
		lbl_YouOrderedCheckBox.setVisible(false);
		
		lbl_ThisIsAComboBox = new JLabel("This is a Combo Box: ");
		lbl_ThisIsAComboBox.setBounds(30 ,260 ,600,20);
		pnl_panel.add(lbl_ThisIsAComboBox);
		
		lbl_ThisIsACheckBox = new JLabel("This is a Check Box: ");
		lbl_ThisIsACheckBox.setBounds(30,393,600,20);
		pnl_panel.add(lbl_ThisIsACheckBox);
		
		//Separators
		sep_Title = new JSeparator();
		sep_Title.setBounds(0, 40, 600, 25);
		pnl_panel.add(sep_Title);
		sep_Title.setForeground(DARK_GREY);
		
		sep_Top = new JSeparator();
		sep_Top.setBounds(15, 206, 570, 25);
		pnl_panel.add(sep_Top);
		sep_Top.setForeground(DARK_GREY);
		
		sep_Bottom = new JSeparator();
		sep_Bottom.setBounds(15, 373, 570, 25);
		pnl_panel.add(sep_Bottom);
		sep_Bottom.setForeground(DARK_GREY);
		
		sep_ResetVertical= new JSeparator();
		sep_ResetVertical.setBounds(480, 500, 570, 90);
		pnl_panel.add(sep_ResetVertical);
		sep_ResetVertical.setForeground(DARK_GREY);
		sep_ResetVertical.setOrientation(1);
		
		sep_ResetHorizontal= new JSeparator();
		sep_ResetHorizontal.setBounds(484, 495, 570, 25);
		pnl_panel.add(sep_ResetHorizontal);
		sep_ResetHorizontal.setForeground(DARK_GREY);
		
		//Radio Buttons
		rad_Small = new JRadioButton("Small");    
		rad_Small.setBounds(180,55,100,30);  
		rad_Small.setActionCommand(Actions.RADIOSMALL.name());
		rad_Small.addActionListener(instance);
		pnl_panel.add(rad_Small);
		
		rad_Medium = new JRadioButton("Medium");      
		rad_Medium.setBounds(180,105,100,30);  
		rad_Medium.setActionCommand(Actions.RADIOMEDIUM.name());
		rad_Medium.addActionListener(instance);
		pnl_panel.add(rad_Medium);
		
		rad_Large = new JRadioButton("Large");      
		rad_Large.setBounds(180,155,100,30);    
		rad_Large.setActionCommand(Actions.RADIOLARGE.name());
		rad_Large.addActionListener(instance);
		pnl_panel.add(rad_Large);
		
		bg_Size = new ButtonGroup();    
		bg_Size.add(rad_Small);
		bg_Size.add(rad_Medium); 
		bg_Size.add(rad_Large); 
		
		rad_SmallOnClick = new JRadioButton("Small");      
		rad_SmallOnClick.setBounds(470,55,100,30);    
		rad_SmallOnClick.setActionCommand(Actions.RADIOSMALLONCLICK.name());
		rad_SmallOnClick.addActionListener(instance);
		pnl_panel.add(rad_SmallOnClick);
		
		//Combo Boxes
		cbo_SelectSize = new JComboBox<>(optionsToChooseSize);
		cbo_SelectSize.setBounds(180, 260, 150, 20);
		pnl_panel.add(cbo_SelectSize);
		
		cbo_SelectHowMany = new JComboBox<>(optionsToChooseAmount);
		cbo_SelectHowMany.setBounds(180, 290, 150, 20);
		pnl_panel.add(cbo_SelectHowMany);
		
		//Check Boxes
		chk_Small = new JCheckBox("Small");  
		chk_Small.setBounds(180,390, 100,50);  
		chk_Small.setActionCommand(Actions.CHECKSMALL.name());
		chk_Small.addActionListener(instance);
        pnl_panel.add(chk_Small); 
        
        chk_Medium = new JCheckBox("Medium");  
        chk_Medium.setBounds(180,440, 100,50);  
        chk_Medium.setActionCommand(Actions.CHECKMEDIUM.name());
        chk_Medium.addActionListener(instance);
        pnl_panel.add(chk_Medium); 
        
        chk_Large = new JCheckBox("Large");  
        chk_Large.setBounds(180,490, 100,50);  
        chk_Large.setActionCommand(Actions.CHECKLARGE.name());
        chk_Large.addActionListener(instance);  
        pnl_panel.add(chk_Large);  
		
		//Buttons
        btn_OrderRadio = new JButton("Place Order");
        btn_OrderRadio.setBounds(280, 60, 160, 25);
        btn_OrderRadio.setActionCommand(Actions.ORDERRADIO.name());
        btn_OrderRadio.addActionListener(instance);
		pnl_panel.add(btn_OrderRadio);
		btn_OrderRadio.setEnabled(false);

		btn_OrderCheckBox = new JButton("Place Order");
		btn_OrderCheckBox.setBounds(280, 393, 160, 25);
		btn_OrderCheckBox.setActionCommand(Actions.ORDERCHECKBOX.name());
		btn_OrderCheckBox.addActionListener(instance);
		pnl_panel.add(btn_OrderCheckBox);
		btn_OrderCheckBox.setEnabled(false);
		
		btn_Reset = new JButton("Reset");
		btn_Reset.setBounds(500, 520, 80, 25);
		btn_Reset.setActionCommand(Actions.RESET.name());
		btn_Reset.addActionListener(instance);
		pnl_panel.add(btn_Reset);
		
		btn_Exit = new JButton("Exit");
		btn_Exit.setBounds(10, 10, 80, 25);
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
		CheckComboBox();
	}//End of main
	
	@Override
	public void actionPerformed(ActionEvent e)
	{//Beginning of actionPerformed
		//Button Calculate
		if (e.getActionCommand() == Actions.ORDERRADIO.name())
		{//Beginning of if
			System.out.println(RadioSize);
			lbl_YouOrderedRadio.setVisible(true);
			lbl_YouOrderedRadio.setText("You ordered a: " + RadioSize);
			btn_OrderRadio.setEnabled(false);
			rad_Small.setEnabled(false);
			rad_Medium.setEnabled(false);
			rad_Large.setEnabled(false);
			rad_SmallOnClick.setEnabled(false);
			
		}//End of else if
		else if (e.getActionCommand() == Actions.RADIOSMALL.name())
		{//Beginning of else if
			btn_OrderRadio.setEnabled(true);
			RadioSize = "Small";
		}//End of else if
		else if (e.getActionCommand() == Actions.RADIOMEDIUM.name())
		{//Beginning of else if
			btn_OrderRadio.setEnabled(true);
			RadioSize = "Medium";
		}//End of else if
		else if (e.getActionCommand() == Actions.RADIOLARGE.name())
		{//Beginning of else if
			btn_OrderRadio.setEnabled(true);
			RadioSize = "Large";
		}//End of else if
		else if (e.getActionCommand() == Actions.RADIOSMALLONCLICK.name())
		{//Beginning of else if
			RadioSize = "Small";
			lbl_YouOrderedRadio.setVisible(true);
			lbl_YouOrderedRadio.setText("You ordered a: " + RadioSize);
			btn_OrderRadio.setEnabled(false);
			rad_Small.setEnabled(false);
			rad_Medium.setEnabled(false);
			rad_Large.setEnabled(false);
		}//End of else if
		else if (e.getActionCommand() == Actions.CHECKSMALL.name())
		{//Beginning of else if
			//Logic to determine what version of Small to print
			if(a == 0)
			{//Beginning of if
				if (b == 0 && c == 0)
				{//Beginning of if
					CheckBoxSize1 = "Small";
					a += 1;
				}//End of if
				else if (b == 1 || c == 1)
				{//Beginning of else if
					CheckBoxSize1 = "Small, ";
					a += 1;
				}//End of else if
			}//End of if
			else if(a == 1)
			{//Beginning of if
				CheckBoxSize1 = "";
				a -= 1;
			}//End of if
			btn_OrderCheckBox.setEnabled(true);
		}//End of else if
		else if (e.getActionCommand() == Actions.CHECKMEDIUM.name())
		{///Beginning of else if
			//Logic to determine what version of Medium to print
			if(b == 0)
			{//Beginning of if
				if (a == 0 && b == 0 && c == 0)
				{//Beginning of if
					CheckBoxSize2 = "Medium";
					b += 1;
				}//End of if
				else if (a == 1)
				{//Beginning of else if
					CheckBoxSize2 = ", Medium";
					b += 1;
				}//End of else if
				else if (c == 1 && a == 1)
				{//Beginnin of else if
					CheckBoxSize2 = ", Medium ";
					b += 1;
				}//End of else if
				else if (c == 1)
				{//Beginning of else if
					CheckBoxSize2 = "Medium, ";
					b += 1;
				}//End of else if
			}//End of if
			else if(b == 1)
			{//Beginning of else if
				CheckBoxSize2 = "";
				b -= 1;
			}//End of else if
			btn_OrderCheckBox.setEnabled(true);
		}//End of else if
		else if (e.getActionCommand() == Actions.CHECKLARGE.name())
		{//Beginning of else if
			//Logic to determine what version of Large to print
			if(c == 0)
			{//Beginning of if
				if (b == 0)
				{//Beginning of if
					CheckBoxSize3 = "Large";
					c += 1;
				}//End of if
				else if (b == 1)
				{//Beginning of else if
					CheckBoxSize3 = ", Large";
					c += 1;
				}//End of else if
			}//End of if
			else if(c == 1)
			{//Beginning of else if
				CheckBoxSize3 = "";
				c -= 1;
			}//End of else if
			if(a == 1)
			{//Beginning of if
				CheckBoxSize3 = ", and Large";
			}//End of if
			btn_OrderCheckBox.setEnabled(true);
		}//End of else if
		else if (e.getActionCommand() == Actions.ORDERCHECKBOX.name())
		{//Beginning of else if
			chk_Small.setEnabled(false);
			chk_Medium.setEnabled(false);
			chk_Large.setEnabled(false);
			btn_OrderCheckBox.setEnabled(false);
			lbl_YouOrderedCheckBox.setText("You ordered A: " + CheckBoxSize1 + CheckBoxSize2 + CheckBoxSize3);
			lbl_YouOrderedCheckBox.setVisible(true);
		}//End of else if
		else if (e.getActionCommand() == Actions.RESET.name())
		{//Beginning of else if
			//Resets Radio Button portion
			rad_Small.setEnabled(true);
			rad_Medium.setEnabled(true);
			rad_Large.setEnabled(true);
			bg_Size.clearSelection();
			rad_SmallOnClick.setSelected(false);
			rad_SmallOnClick.setEnabled(true);
			btn_OrderRadio.setEnabled(false);
			lbl_YouOrderedRadio.setVisible(false);
			lbl_YouOrderedRadio.setText("You ordered A: " + RadioSize);
			//Resets Combo Box portion
			lbl_SizeOrderedComboBox.setVisible(false);
			lbl_NumOrderedComboBox.setVisible(false);
			cbo_SelectSize.setSelectedIndex(0);
			cbo_SelectHowMany.setSelectedIndex(0);
			cbo_SelectSize.setEnabled(true);
			cbo_SelectHowMany.setEnabled(true);
			//Resets Check Box portion
			a = 0;
			b = 0;
			c = 0;
			chk_Small.setEnabled(true);
			chk_Medium.setEnabled(true);
			chk_Large.setEnabled(true);
			chk_Small.setSelected(false);
			chk_Medium.setSelected(false);
			chk_Large.setSelected(false);
			CheckBoxSize1 = "";
			CheckBoxSize2 = "";
			CheckBoxSize3 = "";
			lbl_YouOrderedCheckBox.setText("You ordered A: " + CheckBoxSize1 + CheckBoxSize2 + CheckBoxSize3);
			lbl_YouOrderedCheckBox.setVisible(true);
		}//End of else if
		else if (e.getActionCommand() == Actions.EXIT.name())
		{//Beginning of else if
			fr_frame.dispose();
			System.exit(0);
		}//End of else if
	}//End of actionPerformed
}//End of GUITutorial2
