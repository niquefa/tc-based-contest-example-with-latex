import java.io.BufferedReader;
import java.io.InputStreamReader;


public class E {
	public static void main(String[] args)throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		while( (str = br.readLine()) != null )
		{
			String a[] = str.split(" ");
			String ans = isItPossible(a[0], a[1], Integer.parseInt(a[2]));
			System.out.println(ans);
		}			
				
	}
	public static String isItPossible(String originalWord, String finalWord, int k) {
		int diff=0;
		for(int i=0; i<originalWord.length(); i++)
			if(originalWord.charAt(i)!=finalWord.charAt(i)) diff++;

		if(diff>k)
			return "IMPOSSIBLE";
		else
			if(diff==k)
				return "POSSIBLE";
			else{
				if(((diff-k)&1)==0)
					return "POSSIBLE";
			}              
		return "IMPOSSIBLE";
	}
}
