import java.io.BufferedReader;
import java.io.InputStreamReader;


public class B
{
	public static void main(String[] args)throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		while( (str = br.readLine()) != null )
		{
			String a[] = str.split(" ");
			String d[] = br.readLine().split(" ");
			int ans = count(a[0],a[1],a[2],d);
			System.out.println(ans);
		}			
	}	
	public static int count(String badPrefix, String badSuffix, String badSubstring, String[] vocabulary) {

		int res = 0;

		for (String s : vocabulary)
			if (s.startsWith(badPrefix) || s.endsWith(badSuffix) || s.matches("^.+"+badSubstring+".+$"))
				res++;

		return res;

	}

}
