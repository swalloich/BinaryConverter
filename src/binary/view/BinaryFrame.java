package binary.view;

import java.awt.Dimension;

import javax.swing.JFrame;

import binary.controller.BinaryController;

public class BinaryFrame extends JFrame
{
	private BinaryPanel basePanel;
	
	public BinaryFrame(BinaryController baseController)
	{
		basePanel = new BinaryPanel();
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setTitle("Binary Converter");
		this.setSize(new Dimension(500, 500));
		this.setVisible(true);
	}
}
