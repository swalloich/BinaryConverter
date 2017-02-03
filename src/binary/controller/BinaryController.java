package binary.controller;

import binary.view.BinaryFrame;
import binary.view.HelpFrame;

public class BinaryController 
{
	private BinaryFrame baseFrame;
	
	public void start()
	{
		
	}
	
	public BinaryController()
	{
		baseFrame = new BinaryFrame(this);
	}
	
	public BinaryFrame getBaseFrame()
	{
		return baseFrame;
	}
}
