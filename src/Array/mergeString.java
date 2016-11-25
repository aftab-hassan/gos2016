package Array;

public class mergeString {
	public static void main(String[] args) {
		System.out.println(mergeStrings("ab", "zsd"));
	}
	
    static String mergeStrings(String a, String b) {
    	int min = Math.min(a.length(), b.length());
    	String mergedString = "";
    	
    	for(int i = 0;i<min;i++)
    	{
    		mergedString += a.charAt(i) + "" + b.charAt(i);
    	}

    	if(a.length() > b.length())
    	{
    		for(int i = min;i<a.length();i++)
    			mergedString += a.charAt(i);	
    	}
    	else
		{
			for(int i = min;i<b.length();i++)
    			mergedString += b.charAt(i);
		}

    	return mergedString;
    }
}
