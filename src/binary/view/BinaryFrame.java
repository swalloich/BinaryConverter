package binary.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import binary.controller.BinaryController;

public class BinaryFrame extends JFrame
{
	private BinaryPanel basePanel;
	
	public BinaryFrame(BinaryController baseController)
	{
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		basePanel = new BinaryPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setTitle("Binary Converter");
		this.setSize(new Dimension(750, 500));
		this.setResizable(false);
		this.setVisible(true);
	}
}
