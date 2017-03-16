package binary.view;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import binary.controller.BinaryController;

public class ColorPanel extends JPanel
{
	private SpringLayout helpLayout;
	private BinaryController baseController;
	private JSlider primaryRedSlider;
	private JSlider primaryGreenSlider;
	private JSlider primaryBlueSlider;
	private JSlider secondaryRedSlider;
	private JSlider secondaryGreenSlider;
	private JSlider secondaryBlueSlider;
	private JLabel primaryRedLabel;
	private JLabel primaryGreenLabel;
	private JLabel primaryBlueLabel;
	private JLabel redLabel;
	private JLabel greenLabel;
	private JLabel blueLabel;
	private JLabel primarySliderLabel;
	private JLabel secondarySliderLabel;
	private Color themePrimary;
	private Color themeSecondary;
	private JButton setPrimary;
	private JPanel parentPanel;
	private BinaryPanel binaryPanel;
	private JButton setSecondary;

	public ColorPanel(BinaryController baseController,JPanel parentPanel, BinaryPanel binaryPanel)
	{
		this.binaryPanel = binaryPanel;
		this.parentPanel = parentPanel;
		this.helpLayout = new SpringLayout();
		this.baseController = baseController;
		this.primaryRedSlider = new JSlider();
		this.primaryBlueSlider = new JSlider();
		this.primaryGreenSlider = new JSlider();
		this.secondaryRedSlider = new JSlider();
		this.secondaryGreenSlider = new JSlider();
		this.secondaryBlueSlider = new JSlider();
		this.primaryRedLabel = new JLabel("Red");
		this.primaryGreenLabel = new JLabel("Green");
		this.primaryBlueLabel = new JLabel("Blue");
		this.redLabel = new JLabel("Red");
		this.greenLabel = new JLabel("Green");
		this.blueLabel = new JLabel("Blue");
		this.primarySliderLabel = new JLabel("Primary");
		this.secondarySliderLabel = new JLabel("Secondary");
		this.themePrimary = new Color(primaryRedSlider.getValue(), primaryGreenSlider.getValue(),
				primaryBlueSlider.getValue());
		this.themeSecondary = new Color(secondaryRedSlider.getValue(), secondaryGreenSlider.getValue(),
				secondaryBlueSlider.getValue());
		this.setPrimary = new JButton("Primary Color");
		this.setSecondary = new JButton("Secondary Color");

		setupPanel();
		setupLayout();
		setupListeners();
		formatButtons();
	}

	private void setupPanel()
	{
		this.setLayout(helpLayout);
		this.add(primaryRedSlider);
		this.add(primaryGreenSlider);
		this.add(primaryBlueSlider);
		this.add(secondaryRedSlider);
		this.add(secondaryGreenSlider);
		this.add(secondaryBlueSlider);
		this.add(primaryRedLabel);
		this.add(primaryGreenLabel);
		this.add(primaryBlueLabel);
		this.add(primarySliderLabel);
		this.add(secondarySliderLabel);
		this.add(redLabel);
		this.add(greenLabel);
		this.add(blueLabel);
		this.add(setPrimary);
		this.add(setSecondary);

		primaryRedSlider.setMinimum(0);
		primaryRedSlider.setMaximum(255);
		primaryGreenSlider.setMinimum(0);
		primaryGreenSlider.setMaximum(255);
		primaryBlueSlider.setMinimum(0);
		primaryBlueSlider.setMaximum(255);
		secondaryRedSlider.setMinimum(0);
		secondaryRedSlider.setMaximum(255);
		secondaryGreenSlider.setMinimum(0);
		secondaryGreenSlider.setMaximum(255);
		secondaryBlueSlider.setMinimum(0);
		secondaryBlueSlider.setMaximum(255);
	}

	private void formatButtons()
	{
		this.setPrimary.setOpaque(true);
		this.setPrimary.setBorder(new LineBorder(Color.BLACK));
		this.setPrimary.setBackground(themePrimary);
		this.setSecondary.setOpaque(true);
		this.setSecondary.setBorder(new LineBorder(Color.BLACK));
		this.setSecondary.setBackground(themeSecondary);
	}

	private void setupLayout()
	{
		helpLayout.putConstraint(SpringLayout.NORTH, setPrimary, 0, SpringLayout.NORTH, primaryGreenSlider);
		helpLayout.putConstraint(SpringLayout.WEST, setPrimary, 24, SpringLayout.EAST, primaryGreenSlider);
		helpLayout.putConstraint(SpringLayout.SOUTH, setPrimary, 0, SpringLayout.SOUTH, primaryGreenSlider);
		helpLayout.putConstraint(SpringLayout.SOUTH, primarySliderLabel, -324, SpringLayout.SOUTH, this);
		helpLayout.putConstraint(SpringLayout.NORTH, primaryRedSlider, 6, SpringLayout.SOUTH, primarySliderLabel);
		helpLayout.putConstraint(SpringLayout.WEST, primarySliderLabel, 0, SpringLayout.WEST, primaryRedSlider);
		helpLayout.putConstraint(SpringLayout.NORTH, primaryBlueLabel, 0, SpringLayout.NORTH, primaryBlueSlider);
		helpLayout.putConstraint(SpringLayout.WEST, primaryBlueLabel, 10, SpringLayout.WEST, this);
		helpLayout.putConstraint(SpringLayout.SOUTH, primaryBlueLabel, 0, SpringLayout.SOUTH, primaryBlueSlider);
		helpLayout.putConstraint(SpringLayout.EAST, primaryBlueLabel, 0, SpringLayout.WEST, primaryBlueSlider);
		helpLayout.putConstraint(SpringLayout.NORTH, primaryGreenLabel, 0, SpringLayout.NORTH, primaryGreenSlider);
		helpLayout.putConstraint(SpringLayout.EAST, primaryGreenLabel, -348, SpringLayout.EAST, this);
		helpLayout.putConstraint(SpringLayout.WEST, primaryRedLabel, 0, SpringLayout.WEST, primaryGreenLabel);
		helpLayout.putConstraint(SpringLayout.WEST, primaryGreenLabel, 10, SpringLayout.WEST, this);
		helpLayout.putConstraint(SpringLayout.SOUTH, primaryGreenLabel, 0, SpringLayout.SOUTH, primaryGreenSlider);
		helpLayout.putConstraint(SpringLayout.NORTH, primaryRedLabel, 0, SpringLayout.NORTH, primaryRedSlider);
		helpLayout.putConstraint(SpringLayout.SOUTH, primaryRedLabel, 0, SpringLayout.SOUTH, primaryRedSlider);
		helpLayout.putConstraint(SpringLayout.EAST, primaryRedLabel, -348, SpringLayout.EAST, this);
		helpLayout.putConstraint(SpringLayout.WEST, primaryGreenSlider, 52, SpringLayout.WEST, this);
		helpLayout.putConstraint(SpringLayout.NORTH, primaryBlueSlider, 6, SpringLayout.SOUTH, primaryGreenSlider);
		helpLayout.putConstraint(SpringLayout.NORTH, primaryGreenSlider, 6, SpringLayout.SOUTH, primaryRedSlider);
		helpLayout.putConstraint(SpringLayout.WEST, primaryBlueSlider, 0, SpringLayout.WEST, primaryRedSlider);
		helpLayout.putConstraint(SpringLayout.WEST, primaryRedSlider, 52, SpringLayout.WEST, this);
		helpLayout.putConstraint(SpringLayout.SOUTH, secondarySliderLabel, -135, SpringLayout.SOUTH, this);
		helpLayout.putConstraint(SpringLayout.NORTH, secondaryRedSlider, 6, SpringLayout.SOUTH, secondarySliderLabel);
		helpLayout.putConstraint(SpringLayout.WEST, secondarySliderLabel, 0, SpringLayout.WEST, primaryRedSlider);
		helpLayout.putConstraint(SpringLayout.NORTH, blueLabel, 0, SpringLayout.NORTH, secondaryBlueSlider);
		helpLayout.putConstraint(SpringLayout.WEST, blueLabel, 10, SpringLayout.WEST, this);
		helpLayout.putConstraint(SpringLayout.SOUTH, blueLabel, 0, SpringLayout.SOUTH, secondaryBlueSlider);
		helpLayout.putConstraint(SpringLayout.EAST, blueLabel, 0, SpringLayout.WEST, secondaryBlueSlider);
		helpLayout.putConstraint(SpringLayout.NORTH, greenLabel, 0, SpringLayout.NORTH, secondaryGreenSlider);
		helpLayout.putConstraint(SpringLayout.WEST, greenLabel, 10, SpringLayout.WEST, this);
		helpLayout.putConstraint(SpringLayout.SOUTH, greenLabel, 0, SpringLayout.SOUTH, secondaryGreenSlider);
		helpLayout.putConstraint(SpringLayout.EAST, greenLabel, 0, SpringLayout.WEST, secondaryRedSlider);
		helpLayout.putConstraint(SpringLayout.NORTH, redLabel, 0, SpringLayout.NORTH, secondaryRedSlider);
		helpLayout.putConstraint(SpringLayout.WEST, redLabel, 10, SpringLayout.WEST, this);
		helpLayout.putConstraint(SpringLayout.SOUTH, redLabel, 0, SpringLayout.SOUTH, secondaryRedSlider);
		helpLayout.putConstraint(SpringLayout.EAST, redLabel, 0, SpringLayout.WEST, secondaryRedSlider);
		helpLayout.putConstraint(SpringLayout.NORTH, secondaryBlueSlider, 6, SpringLayout.SOUTH, secondaryGreenSlider);
		helpLayout.putConstraint(SpringLayout.WEST, secondaryBlueSlider, 0, SpringLayout.WEST, primaryRedSlider);
		helpLayout.putConstraint(SpringLayout.NORTH, secondaryGreenSlider, 6, SpringLayout.SOUTH, secondaryRedSlider);
		helpLayout.putConstraint(SpringLayout.WEST, secondaryGreenSlider, 0, SpringLayout.WEST, primaryRedSlider);
		helpLayout.putConstraint(SpringLayout.WEST, secondaryRedSlider, 0, SpringLayout.WEST, primaryRedSlider);

		primaryRedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		primaryGreenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		primaryBlueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		redLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		blueLabel.setHorizontalAlignment(SwingConstants.CENTER);

	}

	private void setupListeners()
	{
		ChangeListener primarySlider = new ChangeListener()
		{
			public void stateChanged(ChangeEvent changed)
			{
				primarySliderStuff();
			}
		};
		primaryRedSlider.addChangeListener(primarySlider);
		primaryGreenSlider.addChangeListener(primarySlider);
		primaryBlueSlider.addChangeListener(primarySlider);

		setPrimary.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent clicked)
			{
				setBackground(themePrimary);
				parentPanel.setBackground(themePrimary);
				
			}
		});
		setSecondary.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent clicked)
			{
				primaryRedSlider.setBackground(themeSecondary);
				primaryGreenSlider.setBackground(themeSecondary);
				primaryBlueSlider.setBackground(themeSecondary);
				secondaryRedSlider.setBackground(themeSecondary);
				secondaryGreenSlider.setBackground(themeSecondary);
				secondaryBlueSlider.setBackground(themeSecondary);
				binaryPanel.setConvertColor(themeSecondary);
				binaryPanel.setColorColor(themeSecondary);
			}
		});
	}

	private void primarySliderStuff()
	{
		this.themePrimary = new Color(this.primaryRedSlider.getValue(), this.primaryGreenSlider.getValue(),
				this.primaryBlueSlider.getValue());
		this.setPrimary.setBackground(themePrimary);
	}
	
	private void secondarySliderStuff()
	{
		this.themeSecondary = new Color(this.secondaryRedSlider.getValue(), this.secondaryGreenSlider.getValue(),
				this.secondaryBlueSlider.getValue());
		this.setSecondary.setBackground(themeSecondary);
	}

	public Color getPrimaryThemeColor()
	{
		return themePrimary;
	}

	public Color getSecondaryThemeColor()
	{
		return themeSecondary;
	}
}
