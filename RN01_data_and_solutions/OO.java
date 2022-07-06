import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class OO
{
	public static void main(String[] args)throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while( (str = br.readLine()) != null )
		{
			String a[] = str.split(" ");
			int b[] = new int[a.length];
			for (int i = 0; i < b.length; i++)
				b[i] = Integer.parseInt(a[i]);
			long ans = minLevel(b);
			System.out.println(ans);
		}				
	}	
	public static int minLevel(int[] heights) {
		int n = heights.length;
		long[] h = new long[n];
		for (int i = 0; i < n; ++i) h[i] = heights[i];
		long left = -1;
		long right = (long) 1e10;
		while (right - left > 1) {
			long middle = (left + right) / 2;
			long min = 0;
			boolean ok = true;
			for (int i = 0; i < n; ++i) {
				min = Math.max(min + 1, h[i] - middle);
				if (min > h[i] + middle)
					ok = false;
			}
			if (ok) 
				right = middle;
			else
				left = middle;
		}
		return (int) right;
	}

}
