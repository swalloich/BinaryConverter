package binary.view;

import java.awt.Dimension;
import javax.swing.JFrame;
import binary.controller.BinaryController;

public class HelpFrame extends JFrame
{
	private HelpPanel helpPanel;

	public HelpFrame(BinaryController baseController)
	{
		super();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.helpPanel = new HelpPanel(baseController);
		
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
