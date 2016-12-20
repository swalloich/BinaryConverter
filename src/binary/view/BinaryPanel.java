package binary.view;

import java.awt.event.*;
import javax.swing.*;
import binary.controller.BinaryController;
import binary.model.Binary;

public class BinaryPanel extends JPanel
{
	private JButton convertButton;
	private JTextField binaryField;
	public JTextArea converted;
	private SpringLayout baseLayout;
	private Binary binary;
	private BinaryController baseController;
	
	public BinaryPanel()
	{
		super();
		this.convertButton = new JButton("Convert");
		this.binaryField = new JTextField("Enter binary here.");
		this.converted = new JTextArea(15, 36);
		baseLayout = new SpringLayout();
		binary = new Binary();
		baseController = new BinaryController();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(convertButton);
		this.add(binaryField);
		this.add(converted);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, binaryField, 0, SpringLayout.NORTH, convertButton);
		baseLayout.putConstraint(SpringLayout.WEST, binaryField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, binaryField, -6, SpringLayout.WEST, convertButton);
		baseLayout.putConstraint(SpringLayout.NORTH, convertButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, convertButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, converted, 6, SpringLayout.SOUTH, binaryField);
		baseLayout.putConstraint(SpringLayout.WEST, converted, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, converted, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, converted, -10, SpringLayout.EAST, this);
	}
	
	private void setupListeners()
	{
		binaryField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent enter)
			{
				String input = binaryField.getText();
				binary.convertToBinary(input);
				
			}
		});
		convertButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent clicked)
			{
				String input = binaryField.getText();
				binary.convertToBinary(input);
			}
		});
	}
}
