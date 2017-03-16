package binary.view;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import binary.controller.BinaryController;

public class ColorFrame extends JDialog
{
	private ColorPanel helpPanel;

	public ColorFrame(BinaryController baseController,JFrame parent,JPanel parentPanel, BinaryPanel binaryPanel)
	{
		super(parent);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.helpPanel = new ColorPanel(baseController,parentPanel, binaryPanel);
		this.setLocation(parent.getWidth(),parent.getHeight());
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(helpPanel);
		this.setTitle("Color Settings");
		this.setSize(new Dimension(400, 380));
		this.setResizable(false);
		this.setVisible(true);
	}
}
