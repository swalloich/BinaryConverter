package binary.view;

import java.awt.event.*;
import javax.swing.*;
import binary.controller.BinaryController;
import binary.model.Binary;

public class BinaryPanel extends JPanel
{
	private JButton convertButton;
//	private JTextField binaryField;
	private JTextArea toBeConverted;
	private JTextArea converted;
	private SpringLayout baseLayout;
	private Binary binary;
	private BinaryController baseController;
	
	public BinaryPanel(BinaryController baseController)
	{
		super();
		this.convertButton = new JButton("Convert");
//		this.binaryField = new JTextField("Enter input here");
		this.toBeConverted = new JTextArea(15, 15);
		this.converted = new JTextArea();
		
		baseLayout = new SpringLayout();
		binary = new Binary();
		this.baseController = baseController;
		
		setupPanel();
		setupLayout();
		setupListeners();
		setConvertedProperties();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(convertButton);
//		this.add(binaryField);
		this.add(toBeConverted);
		this.add(converted);
	}
	
	private void setupLayout()
	{

		baseLayout.putConstraint(SpringLayout.NORTH, convertButton, 117, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, toBeConverted, 0, SpringLayout.NORTH, converted);
		baseLayout.putConstraint(SpringLayout.WEST, toBeConverted, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, toBeConverted, 0, SpringLayout.SOUTH, converted);
		baseLayout.putConstraint(SpringLayout.EAST, toBeConverted, 230, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, converted, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, converted, -230, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, converted, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, converted, -10, SpringLayout.EAST, this);
	}
	
	private void setConvertedProperties()
	{
		converted.setWrapStyleWord(true);
		converted.setLineWrap(true);
		converted.setRows(5);
		converted.setEditable(false);
	}
	
	private void setupListeners()
	{
		
//			public void actionPerformed(ActionEvent enter)
//			{
//				String input = toBeConverted.getText();
//				if(!binary.binaryChecker(input))
//				{
//					converted.setText(binary.convertToBinary(input, input));
//				}
//				else
//				{
//					converted.setText(binary.convertFromBinary(input, input));
//				}
//				
//			}
		
			toBeConverted.addKeyListener(new KeyListener()
			{
			public void keyTyped(KeyEvent e)
			{
				
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					String input = toBeConverted.getText();
					if(!binary.binaryChecker(input))
					{
						converted.setText(binary.convertToBinary(input, input));
					}
					else
					{
						converted.setText(binary.convertFromBinary(input, input));
					}
				}
			}

			public void keyReleased(KeyEvent e)
			{
				
			}
		});
		
		convertButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent clicked)
			{
				String input = toBeConverted.getText();
					if(!binary.binaryChecker(input) && !input.equals(""))
					{
						converted.setText(binary.convertToBinary(input, input));
					}
					else if(!input.equals(""))
					{
						converted.setText(binary.convertFromBinary(input, input));
					}
				}
		});
	}
}
