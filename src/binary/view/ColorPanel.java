package binary.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import binary.controller.BinaryController;

@SuppressWarnings("serial")
public class ColorPanel extends JPanel
{
	private SpringLayout colorLayout;
	@SuppressWarnings("unused")
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
	@SuppressWarnings("unused")
	private BinaryPanel binaryPanel;
	private JButton setSecondary;
	private Color textColor;

	public ColorPanel(BinaryController baseController, JPanel parentPanel, BinaryPanel binaryPanel)
	{
		this.binaryPanel = binaryPanel;
		this.parentPanel = parentPanel;
		this.colorLayout = new SpringLayout();
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
		setupListeners(this);
		formatComponents();
	}

	/**
	 * Adds components to the panel.
	 */
	private void setupPanel()
	{
		this.setLayout(colorLayout);
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
	}

	/**
	 * formats buttons and sliders
	 */
	private void formatComponents()
	{
		primaryRedSlider.setMinimum(0);
		primaryRedSlider.setMaximum(255);
		primaryRedSlider.setValue(200);
		
		primaryGreenSlider.setMinimum(0);
		primaryGreenSlider.setMaximum(255);
		primaryGreenSlider.setValue(200);
		
		primaryBlueSlider.setMinimum(0);
		primaryBlueSlider.setMaximum(255);
		primaryBlueSlider.setValue(200);
		
		secondaryRedSlider.setMinimum(0);
		secondaryRedSlider.setMaximum(255);
		secondaryRedSlider.setValue(200);
		
		secondaryGreenSlider.setMinimum(0);
		secondaryGreenSlider.setMaximum(255);
		secondaryGreenSlider.setValue(200);
		
		secondaryBlueSlider.setMinimum(0);
		secondaryBlueSlider.setMaximum(255);
		secondaryBlueSlider.setValue(200);

		setPrimaryColor(getPrRed(), getPrGreen(), getPrBlue());
		setSecondaryColor(getSecRed(), getSecGreen(), getSecBlue());

		this.setPrimary.setOpaque(true);
		this.setPrimary.setBorder(new LineBorder(Color.BLACK));
		this.setPrimary.setBackground(themePrimary);
		this.setSecondary.setOpaque(true);
		this.setSecondary.setBorder(new LineBorder(Color.BLACK));
		this.setSecondary.setBackground(themeSecondary);
		setTextColor(primaryRedSlider.getValue(), primaryGreenSlider.getValue(), primaryBlueSlider.getValue(),
				setPrimary);
		setTextColor(secondaryRedSlider.getValue(), secondaryGreenSlider.getValue(), secondaryBlueSlider.getValue(),
				setSecondary);
		setTextColor(primaryRedSlider.getValue(), primaryGreenSlider.getValue(), primaryBlueSlider.getValue(),
				setPrimary);
		setTextColor(secondaryRedSlider.getValue(), secondaryGreenSlider.getValue(), secondaryBlueSlider.getValue(),
				setSecondary);

	}

	/**
	 * adds the constraints for ColorPanel.
	 */
	private void setupLayout()
	{
		colorLayout.putConstraint(SpringLayout.EAST, setPrimary, 0, SpringLayout.EAST, setSecondary);
		colorLayout.putConstraint(SpringLayout.NORTH, setSecondary, 0, SpringLayout.NORTH, secondaryGreenSlider);
		colorLayout.putConstraint(SpringLayout.WEST, setSecondary, 6, SpringLayout.EAST, secondaryGreenSlider);
		colorLayout.putConstraint(SpringLayout.SOUTH, setSecondary, 0, SpringLayout.SOUTH, secondaryGreenSlider);
		colorLayout.putConstraint(SpringLayout.NORTH, setPrimary, 0, SpringLayout.NORTH, primaryGreenSlider);
		colorLayout.putConstraint(SpringLayout.WEST, setPrimary, 6, SpringLayout.EAST, primaryGreenSlider);
		colorLayout.putConstraint(SpringLayout.SOUTH, setPrimary, 0, SpringLayout.SOUTH, primaryGreenSlider);
		colorLayout.putConstraint(SpringLayout.SOUTH, primarySliderLabel, -324, SpringLayout.SOUTH, this);
		colorLayout.putConstraint(SpringLayout.NORTH, primaryRedSlider, 6, SpringLayout.SOUTH, primarySliderLabel);
		colorLayout.putConstraint(SpringLayout.WEST, primarySliderLabel, 0, SpringLayout.WEST, primaryRedSlider);
		colorLayout.putConstraint(SpringLayout.NORTH, primaryBlueLabel, 0, SpringLayout.NORTH, primaryBlueSlider);
		colorLayout.putConstraint(SpringLayout.WEST, primaryBlueLabel, 10, SpringLayout.WEST, this);
		colorLayout.putConstraint(SpringLayout.SOUTH, primaryBlueLabel, 0, SpringLayout.SOUTH, primaryBlueSlider);
		colorLayout.putConstraint(SpringLayout.EAST, primaryBlueLabel, 0, SpringLayout.WEST, primaryBlueSlider);
		colorLayout.putConstraint(SpringLayout.NORTH, primaryGreenLabel, 0, SpringLayout.NORTH, primaryGreenSlider);
		colorLayout.putConstraint(SpringLayout.EAST, primaryGreenLabel, -348, SpringLayout.EAST, this);
		colorLayout.putConstraint(SpringLayout.WEST, primaryRedLabel, 0, SpringLayout.WEST, primaryGreenLabel);
		colorLayout.putConstraint(SpringLayout.WEST, primaryGreenLabel, 10, SpringLayout.WEST, this);
		colorLayout.putConstraint(SpringLayout.SOUTH, primaryGreenLabel, 0, SpringLayout.SOUTH, primaryGreenSlider);
		colorLayout.putConstraint(SpringLayout.NORTH, primaryRedLabel, 0, SpringLayout.NORTH, primaryRedSlider);
		colorLayout.putConstraint(SpringLayout.SOUTH, primaryRedLabel, 0, SpringLayout.SOUTH, primaryRedSlider);
		colorLayout.putConstraint(SpringLayout.EAST, primaryRedLabel, -348, SpringLayout.EAST, this);
		colorLayout.putConstraint(SpringLayout.WEST, primaryGreenSlider, 52, SpringLayout.WEST, this);
		colorLayout.putConstraint(SpringLayout.NORTH, primaryBlueSlider, 6, SpringLayout.SOUTH, primaryGreenSlider);
		colorLayout.putConstraint(SpringLayout.NORTH, primaryGreenSlider, 6, SpringLayout.SOUTH, primaryRedSlider);
		colorLayout.putConstraint(SpringLayout.WEST, primaryBlueSlider, 0, SpringLayout.WEST, primaryRedSlider);
		colorLayout.putConstraint(SpringLayout.WEST, primaryRedSlider, 52, SpringLayout.WEST, this);
		colorLayout.putConstraint(SpringLayout.SOUTH, secondarySliderLabel, -135, SpringLayout.SOUTH, this);
		colorLayout.putConstraint(SpringLayout.NORTH, secondaryRedSlider, 6, SpringLayout.SOUTH, secondarySliderLabel);
		colorLayout.putConstraint(SpringLayout.WEST, secondarySliderLabel, 0, SpringLayout.WEST, primaryRedSlider);
		colorLayout.putConstraint(SpringLayout.NORTH, blueLabel, 0, SpringLayout.NORTH, secondaryBlueSlider);
		colorLayout.putConstraint(SpringLayout.WEST, blueLabel, 10, SpringLayout.WEST, this);
		colorLayout.putConstraint(SpringLayout.SOUTH, blueLabel, 0, SpringLayout.SOUTH, secondaryBlueSlider);
		colorLayout.putConstraint(SpringLayout.EAST, blueLabel, 0, SpringLayout.WEST, secondaryBlueSlider);
		colorLayout.putConstraint(SpringLayout.NORTH, greenLabel, 0, SpringLayout.NORTH, secondaryGreenSlider);
		colorLayout.putConstraint(SpringLayout.WEST, greenLabel, 10, SpringLayout.WEST, this);
		colorLayout.putConstraint(SpringLayout.SOUTH, greenLabel, 0, SpringLayout.SOUTH, secondaryGreenSlider);
		colorLayout.putConstraint(SpringLayout.EAST, greenLabel, 0, SpringLayout.WEST, secondaryRedSlider);
		colorLayout.putConstraint(SpringLayout.NORTH, redLabel, 0, SpringLayout.NORTH, secondaryRedSlider);
		colorLayout.putConstraint(SpringLayout.WEST, redLabel, 10, SpringLayout.WEST, this);
		colorLayout.putConstraint(SpringLayout.SOUTH, redLabel, 0, SpringLayout.SOUTH, secondaryRedSlider);
		colorLayout.putConstraint(SpringLayout.EAST, redLabel, 0, SpringLayout.WEST, secondaryRedSlider);
		colorLayout.putConstraint(SpringLayout.NORTH, secondaryBlueSlider, 6, SpringLayout.SOUTH, secondaryGreenSlider);
		colorLayout.putConstraint(SpringLayout.WEST, secondaryBlueSlider, 0, SpringLayout.WEST, primaryRedSlider);
		colorLayout.putConstraint(SpringLayout.NORTH, secondaryGreenSlider, 6, SpringLayout.SOUTH, secondaryRedSlider);
		colorLayout.putConstraint(SpringLayout.WEST, secondaryGreenSlider, 0, SpringLayout.WEST, primaryRedSlider);
		colorLayout.putConstraint(SpringLayout.WEST, secondaryRedSlider, 0, SpringLayout.WEST, primaryRedSlider);
		
		primaryRedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		primaryGreenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		primaryBlueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		redLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		blueLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}

	/**
	 * Method for themePrimary listener.
	 */
	private void primarySliderStuff()
	{
		setPrimaryColor(primaryRedSlider.getValue(), primaryGreenSlider.getValue(), primaryBlueSlider.getValue());
		this.setPrimary.setBackground(themePrimary);
		setTextColor(themePrimary.getRed(), themePrimary.getGreen(), themePrimary.getBlue(), setPrimary);
	}

	/**
	 * Method for themeSecondary listener.
	 */
	private void secondarySliderStuff()
	{
		setSecondaryColor(secondaryRedSlider.getValue(), secondaryGreenSlider.getValue(),
				secondaryBlueSlider.getValue());
		this.setSecondary.setBackground(themeSecondary);
	}

	private void setupListeners(JPanel thisPanel)
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

		ChangeListener secondarySlider = new ChangeListener()
		{
			public void stateChanged(ChangeEvent changed)
			{
				secondarySliderStuff();
			}
		};
		secondaryRedSlider.addChangeListener(secondarySlider);
		secondaryGreenSlider.addChangeListener(secondarySlider);
		secondaryBlueSlider.addChangeListener(secondarySlider);

		setPrimary.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent clicked)
			{
				List<JComponent> temp = new ArrayList<JComponent>();
				temp = getButtons(parentPanel);

				setBackground(themePrimary);
				changeComponentBackground(getSliders(thisPanel), themePrimary);
				parentPanel.setBackground(themePrimary);
				changeTextColor(temp, themePrimary);
			}
		});

		setSecondary.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent clicked)
			{
				changeComponentBackground(getButtons(parentPanel), themeSecondary);
			}
		});
	}

	private void setTextColor(int r, int g, int b, JComponent button)
	{
		int average = ((r + g + b) / 3);

		if (average > 50)
		{
			setTextColorColor(Color.BLACK);
		} else
		{
			setTextColorColor(Color.WHITE);
		}

		button.setForeground(textColor);
	}

	public List<JComponent> getSliders(final Container container)
	{
		Component[] components = container.getComponents();
		List<JComponent> sliders = new ArrayList<JComponent>();
		for (int index = 0; index < components.length; index++)
		{
			if (components[index] instanceof JSlider)
			{
				sliders.add((JComponent) components[index]);
			}
		}
		return sliders;
	}

	public List<JComponent> getButtons(final Container container)
	{
		Component[] components = container.getComponents();
		List<JComponent> buttons = new ArrayList<JComponent>();
		for (int index = 0; index < components.length; index++)
		{
			if (components[index] instanceof JButton)
			{
				buttons.add((JComponent) components[index]);
			}
		}
		return buttons;
	}

	public void changeComponentBackground(List<JComponent> components, Color color)
	{
		for (JComponent comp : components)
		{
			comp.setBackground(color);
			comp.setOpaque(true);
		}
	}

	public void changeTextColor(List<JComponent> components, Color backgroundColor)
	{
		for (JComponent comp : components)
		{
			setTextColor(backgroundColor.getRed(), backgroundColor.getGreen(), backgroundColor.getBlue(), comp);
		}
	}

	public Color getPrimaryThemeColor()
	{
		return themePrimary;
	}

	public Color getSecondaryThemeColor()
	{
		return themeSecondary;
	}

	public void setPrimaryColor(int r, int g, int b)
	{
		themePrimary = new Color(r, g, b);
	}

	public void setSecondaryColor(int r, int g, int b)
	{
		themeSecondary = new Color(r, g, b);
	}

	public void setTextColorValues(int r, int g, int b)
	{
		textColor = new Color(r, g, b);
	}

	public void setTextColorColor(Color color)
	{
		textColor = color;
	}

	public int getPRSlider()
	{
		return primaryRedSlider.getValue();
	}

	public int getPGSlider()
	{
		return primaryGreenSlider.getValue();
	}

	public int getPBSlider()
	{
		return primaryBlueSlider.getValue();
	}

	public int getPrRed()
	{
		return themePrimary.getRed();
	}

	public int getPrGreen()
	{
		return themePrimary.getGreen();
	}

	public int getPrBlue()
	{
		return themePrimary.getBlue();
	}

	public int getSecRed()
	{
		return themeSecondary.getRed();
	}

	public int getSecGreen()
	{
		return themeSecondary.getGreen();
	}

	public int getSecBlue()
	{
		return themeSecondary.getBlue();
	}
}
