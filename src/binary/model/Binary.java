package binary.model;

public class Binary 
{
	public Binary()
	{
		
	}
	
	public String convertToBinary(String currentInput, String output)
	{
		if(!binaryChecker(currentInput))
		{
			byte[] bytes = currentInput.getBytes();
			StringBuilder binary = new StringBuilder();
			for(byte length : bytes)
			{
				int val = length;
				for(int i = 0; i < 8; i++)
				{
					binary.append((val & 128) == 0 ? 0 : 1);
					val <<= 1;
				}
				binary.append(' ');
			}
			output = binary.toString();
		}
		
		return output;
	}
	
	public String convertFromBinary(String currentInput, String output)
	{
		if(binaryChecker(currentInput))
		{
			String[] binary = currentInput.split( " " );
			StringBuilder converted = new StringBuilder();
			for(int length = 0; length < binary.length; length++)
			{
				converted.append( (char)Integer.parseInt( binary[length], 2) );
			}
			output = converted.toString();
		}
		
		return output;
	}
	
	public boolean binaryChecker(String input)
	{
		boolean isBinary = true;
		for(int index = 0; index < input.length(); index++){
			if(input.substring(index, index+1).equals("0") || input.substring(index, index+1).equals("1") || input.substring(index, index+1).equals(" "))
			{
				
			}
			else
			{
				isBinary = false;
			}
		}
		
//		if(input.contains("1") || input.contains("0") && !input.matches("[a-zA-Z]+"))
//		{
//			isBinary = true;
//				if(!input.contains("1") && !input.contains("0"))
//				{
//					isBinary = false;
//				}
//		}
		
		return isBinary;
	}
}
