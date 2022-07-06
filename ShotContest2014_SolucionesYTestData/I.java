import java.io.BufferedReader;
import java.io.InputStreamReader;

public class I {
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
			str = br.readLine();
			int ans = getCount(b, str);
			System.out.println(ans);
		}		
	}	
	public static int getCount(int[] b, String operators)
	{
		int n = b.length;
		int[] a = new int[n];
		long add = 0, sign = 1;
		long min = 1;
		long max = Long.MAX_VALUE;
		for (int i = 0; i < n; ++i) {
			if (operators.charAt(i) == '-') {
				add -= b[i];
			} else {
				add = b[i] - add;
				sign = -sign;
			}
			if (sign == 1) {
				min = Math.max(min, 1 - add);
			} else {
				max = Math.min(max, add - 1);
			}
		}
		return max == Long.MAX_VALUE ? -1 : min <= max ? (int)(max - min + 1) : 0;
	}
}
