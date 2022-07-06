import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class AA {
	public static void main(String[] args)throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		while( (str = br.readLine()) != null )
		{
			String arr[] = str.split(" ");
			String numbers = arr[0];
			int sum = Integer.parseInt(arr[1]);
			System.out.println(new QuickSums().minSums(numbers, sum));			
		}			
	}	
	static class QuickSums
	{

		int minPlus = Integer.MAX_VALUE;
		public int minSums(String numbers, int sum) {
			go (numbers,"",sum,0);
			if (minPlus == Integer.MAX_VALUE) return -1;
			return minPlus-1;
		}

		public void go (String num, String s, int sum, int i) {
			if (i>=num.length()) {
				int t = 0;
				long rs = 0;
				StringTokenizer st = new StringTokenizer(s,"+");
				t = st.countTokens();
				while (st.hasMoreTokens()) {
					rs+=Long.parseLong((String)st.nextToken());
				}
				if (rs == sum) minPlus = Math.min(minPlus,t);
			} else {
				if (i == 0) go (num,""+num.charAt(i), sum, i+1);
				else {
					go (num,s+"+"+num.charAt(i),sum,i+1);
					go (num,s+num.charAt(i),sum,i+1);
				}

			}


		}
	}

	/****************** HELPFUL FUNCTIONS ************************************/
	static class TCMath {

		public static double EPSILON = 1.0E-9;

		public static long gcd (long a, long b) {
			long a1 = Math.max(a,b);
			long b1 = Math.min(a,b);
			while(true) {
				if (a1%b1==0) return b1;
				b1=a1%b1;
				a1=b1;
			}
		}


		public static char[][] stringArrayToCharMap(String[] str) {
			char[][] map = new char[str.length][str[0].length()];
			for (int i = 0; i<str.length; i++) {
				for (int j = 0; j<str[0].length(); j++) {
					map[i][j] = str[i].charAt(j);

				}      

			}  
			return map;
		}


		public static long getFactorial(int n) {
			long ret = 1;
			for (int i = 1; i<=n; i++) {
				ret*=i;  
			}
			return ret;

		}

		public static int[][] stringArrayToIntMap(String[] str) {
			int[][] map = new int[str.length][str[0].length()];
			for (int i = 0; i<str.length; i++) {
				for (int j = 0; j<str[0].length(); j++) {
					map[i][j] = str[i].charAt(j)-'0';

				}      

			}  
			return map;
		}

		public static int[] getNextPermutation (int[] a) {
			int temp;
			// Find largest index j with a[j] < a[j+1]
			int j = a.length - 2;
			while (j>-1 && a[j] >= a[j+1]) {
				j--;
			}
			//cant generate next lexographical permutation
			if (j<=-1) return null;
			// Find index k such that a[k] is smallest integer
			// greater than a[j] to the right of a[j]
			int k = a.length - 1;
			while (a[j] > a[k]) {
				k--;
			}
			// Interchange a[j] and a[k]
			temp = a[k];
			a[k] = a[j];
			a[j] = temp;
			// Put tail end of permutation after jth position in increasing order
			int r = a.length - 1;
			int s = j + 1;
			while (r > s) {
				temp = a[s];
				a[s] = a[r];
				a[r] = temp;
				r--;
				s++;
			}
			return a;
		}

		public static int compareDoubles(double a, double b) {
			if (Math.abs(a-b)<=EPSILON) return 0;
			if (a-b > 0 && Math.abs(a-b) > EPSILON) return 1;
			if (a-b < 0 && Math.abs(a-b) > EPSILON) return -1;      
			//error return
			return -2;
		}

		public double planeDistance(double x1,double y1,double x2,double y2) {
			return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));  
		}


	}

}
