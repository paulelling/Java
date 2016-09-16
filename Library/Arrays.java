/**
 * @com.register ( clsid=7CFBE009-E8B8-451A-8793-4501BFCFA1CE, typelib=E3E50ED0-2ADE-4566-8A3C-133F5A1CCDD2 )
 */
public class Arrays
{
  /**
   * Function to convert a string to a character array.
   */	
  public char[] convertCharArray(String strValue)
  { 
    return strValue.toCharArray(); 
  }
  
  
  /**
   * Function to get the dimension of an array.
   */
  public int getDimension(String strValue, char delimiter)
  {
	int numVals = 1;  
	  
	for (int z = 0; z < strValue.length(); z++)
	{		  
	  if (strValue.charAt(z) == delimiter)
	  { numVals++; }
	}
	
	return numVals;
  }
  
  
  /**
   * Function to populate a string array.
   */
  public String[] populateStringArray(char[] valArray, int numVals, char delimiter)
  {
    String valuesList[] = new String[numVals];
	
	char strNewLine = '\n';
	char strCarriageReturn = '\r';
	char strTab = '\t';
	
	int b = 0;
	
    for (int a = 0; a < valArray.length; a++)
	{
	  if (valArray[a] != delimiter)
	  {
        if (valuesList[b] == null || valArray[a] == strNewLine 
			|| valArray[a] == strTab || valArray[a] == strCarriageReturn)
		{ valuesList[b] = ""; }
		 
		valuesList[b] += valArray[a];
	  }
	  else
	  { b++; }	  
	}
	
	return valuesList;
  }
}


