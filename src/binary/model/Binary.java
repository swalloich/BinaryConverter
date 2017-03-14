package binary.model;

public class Binary
{
	public Binary()
	{

	}

	public String convertToBinary(String currentInput)
	{
		String output = "";
		if (!binaryChecker(currentInput))
		{
			byte[] bytes = currentInput.getBytes();
			StringBuilder binary = new StringBuilder();
			for (byte length : bytes)
			{
				int val = length;
				for (int i = 0; i < 8; i++)
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
	/*
	 * I would suggest changing up the colors a bit, or allowing users to change
	 * the color with some sort of option within the program.
	 */

	// public String convertFromBinary(String currentInput)
	// {
	// String output = null;
	// if (binaryChecker(currentInput) && !currentInput.equals(""))
	// {
	// String[] binary = currentInput.split(" ");
	// StringBuilder converted = new StringBuilder();
	// for (int length = 0; length < binary.length; length++)
	// {
	// converted.append((char) Integer.parseInt(binary[length], 2));
	// }
	// output = converted.toString();
	// }
	//
	// return output;
	// }

	public String stringArrayToString(String[] input)
	{
		String output = "";
		StringBuilder converted = new StringBuilder();
		for (int index = 0; index < input.length; index++)
		{
			converted.append(input[index]);
		}
		output = converted.toString();
		return output;
	}

	public String convertFromBinary(String input)
	{
		String output = new String();
		String removeSpaces = new String();
		StringBuilder converted = new StringBuilder();

		for (int index = 0; index < input.length(); index++)
		{
			if (!input.substring(index, index + 1).equalsIgnoreCase(" ")
					&& !input.substring(index, index + 1).equalsIgnoreCase("\n"))
			{
				removeSpaces += input.charAt(index);
			}
		}

		for (int index = 0; index < removeSpaces.length(); index++)
		{
			double temp = (index + 1) % 8;
			if (temp == 0)
			{
				converted.append((char) Integer.parseInt(removeSpaces.substring((index + 1) - 8, (index + 1)), 2));
			}
		}
		output = converted.toString();
		return output;
	}

	public boolean binaryChecker(String input)
	{
		boolean isBinary = true;
		for (int index = 0; index < input.length(); index++)
		{
			if (input.substring(index, index + 1).equals("0") || input.substring(index, index + 1).equals("1")
					|| input.substring(index, index + 1).equals(" ") || input.substring(index, index + 1).equals("\n"))
			{

			} else
			{
				isBinary = false;
			}
		}
		return isBinary;
	}
}
