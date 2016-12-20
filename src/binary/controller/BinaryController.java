package binary.controller;

import java.util.ArrayList;

import binary.view.BinaryFrame;

public class BinaryController 
{
	private ArrayList<Object> binaryValues;
	private BinaryFrame baseFrame;
	
	public void start()
	{
		
	}
	
	public BinaryController()
	{
		binaryValues = new ArrayList<Object>();
		baseFrame = new BinaryFrame(this);
				
		buildBinaryValues();
	}
	
	public void convertToBinary(String input)
	{
		for(int index = 0; index > binaryValues.size(); index++)
		{
			if(!input.contains((CharSequence)binaryValues))
			{
				System.out.println("it worked");
			}
		}
		
	}
	
	private void buildBinaryValues()
	{
		binaryValues.add(1);
		binaryValues.add(0);
	}
	
	public BinaryFrame getBaseFrame()
	{
		return baseFrame;
	}
}
