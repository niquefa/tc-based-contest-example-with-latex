import java.io.BufferedReader;
import java.io.InputStreamReader;


public class DD {
	public static void main(String[] args)throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		while( (str = br.readLine()) != null )
		{
			String arr[] = str.split(" ");
			int n = Integer.parseInt(arr[0]);
			int k = Integer.parseInt(arr[1]);
			System.out.println(new TheCowDivTwo().find(n,k));			
		}			
	}	

	static class TheCowDivTwo
	{
		public static int[][] memo;
		public int find(int N, int K)
		{
			int[][] memo = new int[K+1][N];
			memo[0][0] = 1;
			for(int i=0; i<N; i++) {
				for(int j=K-1; j>=0; j--) {
					for(int k=N-1; k>=0; k--) {
						memo[j+1][(k+i)%N] = (memo[j+1][(k+i)%N] + memo[j][k])%1000000007;
					}
				}
			}
			return memo[K][0];
		}

	}


}
