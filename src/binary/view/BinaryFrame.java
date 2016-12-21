package binary.view;

import java.awt.Dimension;

import javax.swing.JFrame;

import binary.controller.BinaryController;

public class BinaryFrame extends JFrame
{
	private BinaryController baseController;
	private BinaryPanel basePanel;
	
	public BinaryFrame(BinaryController baseController)
	{
		super();
		this.baseController = baseController;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		basePanel = new BinaryPanel(baseController);
		
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
