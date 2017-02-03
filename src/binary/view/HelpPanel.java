package binary.view;

import javax.swing.*;
import binary.controller.BinaryController;

public class HelpPanel extends JPanel
{
	private SpringLayout helpLayout;
	private JScrollPane scroll;
	private JTextArea help;
	private BinaryController baseController;
	
	public HelpPanel(BinaryController baseController)
	{
		this.helpLayout = new SpringLayout();
		this.help = new JTextArea();
		this.scroll = new JScrollPane(help);
		this.baseController = baseController;
		
		setupPanel();
		setupLayout();
		setupListeners();
		formatHelp();
	}
	
	private void setupPanel()
	{
		this.setLayout(helpLayout);
		this.add(scroll);
	}
	
	private void formatHelp()
	{
		help.setEditable(false);
		help.setLineWrap(true);
		help.setWrapStyleWord(true);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
	
	private void setupLayout()
	{
		helpLayout.putConstraint(SpringLayout.NORTH, scroll, 10, SpringLayout.NORTH, this);
		helpLayout.putConstraint(SpringLayout.WEST, scroll, 15, SpringLayout.WEST, this);
		helpLayout.putConstraint(SpringLayout.EAST, scroll, -15, SpringLayout.EAST, this);
		helpLayout.putConstraint(SpringLayout.SOUTH, scroll, -15, SpringLayout.SOUTH, this);
	}
	
	private void setupListeners()
	{
		
	}
}
