package binary.view;

import java.awt.event.*;
import javax.swing.*;

public class BinaryPanel extends JPanel
{
	private JButton convertButton;
	private JTextField binaryField;
	private JTextArea converted;
	private SpringLayout baseLayout;
	
	public BinaryPanel()
	{
		convertButton = new JButton("Convert");
		binaryField = new JTextField("Enter binary here.");
		converted = new JTextArea(15, 36);
		baseLayout = new SpringLayout();
		
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
			}
		});
		convertButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent clicked)
			{
				String input = binaryField.getText();
			}
		});
	}
}
