package binary.model;

import java.util.ArrayList;

import binary.view.BinaryPanel;


public class Binary 
{
	public ArrayList<String> alphabetList;
	private BinaryPanel basePanel;
	
	public Binary()
	{
		alphabetList = new ArrayList<String>();
		basePanel = new BinaryPanel();
		

	}
	
	public void convertToBinary(String currentInput)
	{
			if(currentInput.contains("1") || currentInput.contains("0"))
			{
				if(currentInput.equalsIgnoreCase("01100001"));
				{
					basePanel.converted.setText("a");
				}
			}
	}
	
	private boolean binaryChecker(String input)
	{
		boolean isBinary = false;
		
		if(input.contains("1") || input.contains("0"))
		{
			for(int pos = 0; pos <)
				if(input.contains())
		}
		
		return isBinary;
	}
	
	private void buildAplhabetList()
	{
		alphabetList.add("a");
		alphabetList.add("b");
		alphabetList.add("c");
		alphabetList.add("d");
		alphabetList.add("d");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
		alphabetList.add("");
	}
}
