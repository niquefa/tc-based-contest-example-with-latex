import static java.lang.Double.parseDouble;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;


public class JJ {
	public static void main(String[] args)throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		while( (str = br.readLine()) != null )
		{
			String a[] = str.split(" ");
			double ans = compute(Integer.parseInt(a[0]) , Integer.parseInt(a[1]));
			System.out.println(format(ans+"",6));
		}			
	}
	public static double compute(int n, int k){ 
		if(k>=0){ 
			double res = 1; 
			for(int i=0;i<k;i++){ 
				res *= (double)(n-i); 
			} 
			return res; 
		} 
		else{ 
			return compute(n,k+1) / (double) (n-k); 
		} 
	} 
	private static String format(String s, int p)
	{
		String z = "0.";
		while(z.length()-2 < p)
			z += "0";
		DecimalFormat formatter = new DecimalFormat(z);
		return formatter.format(parseDouble(s)).replaceAll(",", ".");
	}  	
}
