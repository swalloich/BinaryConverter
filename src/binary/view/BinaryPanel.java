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
	private JLabel in;
	private JLabel out;
	private SpringLayout baseLayout;
	private Binary binary;
	public BinaryPanel(BinaryController baseController)
	{
		super();
		this.convertButton = new JButton("Convert");
//		this.binaryField = new JTextField("Enter input here");
		this.toBeConverted = new JTextArea();
		this.converted = new JTextArea();
		this.in = new JLabel("Input");
		this.out = new JLabel("Output");
		baseLayout = new SpringLayout();
		binary = new Binary();
		
		setupPanel();
		setupLayout();
		setupListeners();
		setTextFieldProperties();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(convertButton);
//		this.add(binaryField);
		this.add(toBeConverted);
		this.add(converted);
		this.add(in);
		this.add(out);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, toBeConverted, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, toBeConverted, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, convertButton, 6, SpringLayout.EAST, toBeConverted);
		baseLayout.putConstraint(SpringLayout.EAST, convertButton, -6, SpringLayout.WEST, converted);
		baseLayout.putConstraint(SpringLayout.NORTH, converted, 28, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, converted, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, toBeConverted, 28, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, converted, 451, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, converted, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, toBeConverted, -451, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, convertButton, 186, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, out, 0, SpringLayout.WEST, converted);
		baseLayout.putConstraint(SpringLayout.EAST, out, 0, SpringLayout.EAST, converted);
		baseLayout.putConstraint(SpringLayout.WEST, in, 0, SpringLayout.WEST, toBeConverted);
		baseLayout.putConstraint(SpringLayout.EAST, in, 0, SpringLayout.EAST, toBeConverted);
		baseLayout.putConstraint(SpringLayout.SOUTH, out, -6, SpringLayout.NORTH, converted);
		baseLayout.putConstraint(SpringLayout.SOUTH, in, -6, SpringLayout.NORTH, toBeConverted);
	}
	
	private void setTextFieldProperties()
	{
		converted.setWrapStyleWord(true);
		converted.setLineWrap(true);
		converted.setEditable(false);
		toBeConverted.setWrapStyleWord(true);
		toBeConverted.setLineWrap(true);
		out.setHorizontalAlignment(SwingConstants.CENTER);
		in.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	private void setupListeners()
	{
		
//			public void actionPerformed(ActionEvent enter)
//			{
//				String input = binaryField.getText();
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
		
//		binaryField.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent clicked)
//			{
//				String input = binaryField.getText();
//					if(!binary.binaryChecker(input) && !input.equals(""))
//					{
//						converted.setText(binary.convertToBinary(input, input));
//					}
//					else if(!input.equals(""))
//					{
//						converted.setText(binary.convertFromBinary(input, input));
//					}
//				}
//		});
	}
}
