import java.io.BufferedReader;
import java.io.InputStreamReader;


public class NN {
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
			long ans = theCount(b);
			System.out.println(ans);
		}		
	}	
	public static long theCount(int[] A) {
		long ans = 1;
		int prev = 2;
		boolean seen = false;
		for(int i = 0; i < 50; i++){
			int c = count(A, i);
			if(c > prev)
				return 0;
			if(c == 2)
				ans *= 2;
			if(!seen && c == 1){
				ans *= 2;
				seen = true;
			}
			prev = c;
		}
		return ans;
	}
	private static int count(int[] A, int i) {
		int ans = 0;
		for(int a:A)
			if(a == i)
				ans++;
		return ans;
	}

}
