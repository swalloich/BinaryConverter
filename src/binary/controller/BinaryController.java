package binary.controller;

import binary.model.Binary;
import binary.view.BinaryFrame;
import binary.view.BinaryPanel;

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
