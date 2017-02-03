package binary.view;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;

import binary.controller.BinaryController;

public class HelpFrame extends JDialog
{
	private HelpPanel helpPanel;

	public HelpFrame(BinaryController baseController,JFrame parent)
	{
		super(parent);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.helpPanel = new HelpPanel(baseController);
		this.setLocation(parent.getWidth(),parent.getHeight());
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(helpPanel);
		this.setTitle("Help");
		this.setSize(new Dimension(400, 300));
		this.setResizable(false);
		this.setVisible(true);
	}
}
