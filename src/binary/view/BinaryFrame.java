package binary.view;

import java.awt.Dimension;
import javax.swing.JFrame;
import binary.controller.BinaryController;

@SuppressWarnings("serial")
public class BinaryFrame extends JFrame
{
	private BinaryPanel basePanel;
	
	public BinaryFrame(BinaryController baseController)
	{
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		basePanel = new BinaryPanel(baseController, this);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setTitle("Binary/Text Converter");
		this.setSize(new Dimension(750, 500));
		this.setResizable(false);
		this.setVisible(true);
	}
}
