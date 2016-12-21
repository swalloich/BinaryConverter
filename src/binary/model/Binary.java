package binary.model;

import java.nio.charset.StandardCharsets;

public class Binary 
{
	public Binary()
	{
		
	}
	
	public String convertToBinary(String currentInput, String output)
	{
		for()
		StandardCharsets.US_ASCII.encode(currentInput.getChars(1, 1, , 1));
		if(!binaryChecker(currentInput))
		{
			String hex;
			
			hex = Integer.toBinaryString(Integer.parseInt(currentInput,16));
			output = hex;
		}
		
		return output;
	}
	
	private boolean binaryChecker(String input)
	{
		boolean isBinary = false;
		
		if(input.contains("1") || input.contains("0"))
		{
			isBinary = true;
				if(!input.contains("1") && !input.contains("0"))
				{
					isBinary = false;
				}
		}
		
		return isBinary;
	}
}
