package binary.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import binary.controller.BinaryController;
import binary.model.Binary;

@SuppressWarnings("serial")
public class BinaryPanel extends JPanel
{
	private JButton convertButton;
//	private JTextField binaryField;
	private JTextArea toBeConverted;
	private JTextArea converted;
	private JLabel in;
	private JLabel out;
	private JButton setTheme;
	private JScrollPane scrollIn;
	private JScrollPane scrollOut;
	private SpringLayout baseLayout;
	private Binary binary;
	private BinaryController baseController;
	private JFrame myFrame;
	private ColorPanel colorPanel;
	
	public BinaryPanel(BinaryController baseController,JFrame myframe)
	{
		super();
		this.myFrame = myframe;
		this.baseController = baseController;
		this.convertButton = new JButton("Convert");
//		this.binaryField = new JTextField("Enter input here");
		this.toBeConverted = new JTextArea();
		this.converted = new JTextArea();
		this.in = new JLabel("Input");
		this.out = new JLabel("Output");
		this.baseLayout = new SpringLayout();
		this.binary = new Binary();
		this.scrollIn = new JScrollPane(toBeConverted);
		this.scrollOut = new JScrollPane(converted);
		this.setTheme = new JButton("Colors");
		this.colorPanel = null;
		setupPanel();
		formatButtons();
		setupLayout();
		setupListeners();
		setTextFieldProperties();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(convertButton);
//		this.add(binaryField);
		this.add(in);
		this.add(out);
		this.add(scrollIn);
		this.add(scrollOut);
		this.add(setTheme);
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
		baseLayout.putConstraint(SpringLayout.SOUTH, out, -6, SpringLayout.NORTH, converted);
		baseLayout.putConstraint(SpringLayout.NORTH, scrollOut, 0, SpringLayout.NORTH, toBeConverted);
		baseLayout.putConstraint(SpringLayout.WEST, scrollOut, 0, SpringLayout.WEST, out);
		baseLayout.putConstraint(SpringLayout.SOUTH, scrollOut, 0, SpringLayout.SOUTH, toBeConverted);
		baseLayout.putConstraint(SpringLayout.EAST, scrollOut, 0, SpringLayout.EAST, out);
		baseLayout.putConstraint(SpringLayout.NORTH, in, 0, SpringLayout.NORTH, out);
		baseLayout.putConstraint(SpringLayout.WEST, in, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, in, -151, SpringLayout.WEST, out);
		baseLayout.putConstraint(SpringLayout.NORTH, scrollIn, 6, SpringLayout.SOUTH, in);
		baseLayout.putConstraint(SpringLayout.EAST, scrollIn, 300, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, scrollIn, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, scrollIn, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, setTheme, 25, SpringLayout.EAST, scrollIn);
		baseLayout.putConstraint(SpringLayout.SOUTH, setTheme, 0, SpringLayout.SOUTH, scrollIn);
		baseLayout.putConstraint(SpringLayout.EAST, setTheme, 125, SpringLayout.EAST, scrollIn);
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
		scrollIn.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollOut.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
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
						converted.setText(binary.convertToBinary(input));
					}
					else
					{
						converted.setText(binary.convertFromBinary(input));
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
					converted.setText(binary.convertToBinary(input));
				}
				else if(!input.equals(""))
				{
					converted.setText(binary.convertFromBinary(input));
				}
			}
		});
		
		setTheme.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ColorFrame colorFrame = new ColorFrame(baseController,myFrame,getMe(),getMe());
				colorPanel = colorFrame.getPanel();
				
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
	
	private BinaryPanel getMe()
	{
		return this;
	}
	
	public void formatButtons()
	{
		convertButton.setOpaque(true);
		convertButton.setBorder(new LineBorder(Color.BLACK));
		if(colorPanel != null)
		{
		convertButton.setBackground(colorPanel.getSecondaryThemeColor());
		}
		
		setTheme.setOpaque(true);
		setTheme.setBorder(new LineBorder(Color.BLACK));
		if(colorPanel != null)
		{
		setTheme.setBackground(colorPanel.getSecondaryThemeColor());
		}
	}
	
	public void setConvertColor(Color color)
	{
		this.convertButton.setBackground(color);
	}
	
	public void setColorColor(Color color)
	{
		this.setTheme.setBackground(color);
	}
}
