import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class PP {
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
			a = new String[b[0]];
			for (int i = 0; i < b[0]; i++)
			{
				a[i] = br.readLine();
			}
			LandAndSea ob = new LandAndSea();
			int ans[] = ob.howManyIslands(a);
			System.out.print("{");
			for (int i = 0; i < ans.length; i++) {
				if( i > 0 )
					System.out.print(", ");
				System.out.print(ans[i]);
			}			
			System.out.println("}");
		}		
	}	
	static  class LandAndSea { 
		int n,m,cnt,curd,curo; 
		int[][] col, r, col2, w; 
		int[] dep, cdep; 

		int[] di; 
		int[] dj; 

		public int[] howManyIslands(String[] seaMap) { 
			di = new int[] {0,0,1,-1,1,1,-1,-1}; 
			dj = new int[] {1,-1,0,0,1,-1,1,-1}; 
			String[] s = seaMap; 
			n = s.length; 
			m = s[0].length(); 
			r = new int[n+2][m+2]; 
			col = new int[n+2][m+2]; 
			col2 = new int[n+2][m+2]; 
			for (int i=0; i<n+2; i++) { 
				Arrays.fill(r[i], 0); 
				Arrays.fill(col[i], 0); 
			} 
			for (int i=0; i<n; i++) 
				for (int j=0; j<m; j++) 
					if (s[i].charAt(j) == 'x') 
						r[i+1][j+1] = 1; 

			n += 2; 
			m += 2; 
			cnt = 0; 
			for (int i=0; i<n; i++) 
				for (int j=0; j<m; j++) 
					if (r[i][j] == 1 && col[i][j] == 0) { 
						cnt++; 
						dfs(i, j); 
					} 
			dep = new int[cnt+1]; 
			w = new int[cnt+1][cnt+1]; 
			for (int i=0; i<=cnt; i++) 
				Arrays.fill(w[i], 0); 
			Arrays.fill(dep, -1); 
			for (int i=0; i<n; i++) 
				Arrays.fill(col2[i], 0); 
			dfs2(0, 0); 
			curd = 0; 
			while (true) { 
				boolean find = false; 
				curd++; 
				for (int i=0; i<n; i++) 
					for (int j=0; j<m; j++) 
						if (r[i][j] == 0 && isnear(i, j, curd - 1) && col2[i][j] == 0) { 
							dfs2(i, j); 
							find = true; 
						} 
				if (!find) 
					break; 
			} 
			Arrays.fill(dep, -1); 
			curd = -1; 
			for (int i=1; i<=cnt; i++) 
				if (dep[i] == -1) 
					dfs3(i); 

			int[] res = new int[curd+1]; 
			Arrays.fill(res, 0); 
			for (int i=1; i<=cnt; i++) 
				res[dep[i]]++; 

			return res; 
		} 

		private void dfs3(int i) { 
			dep[i] = 0; 
			for (int j=1; j<=cnt; j++) 
				if (w[i][j] == 1) { 
					if (dep[j] == -1) 
						dfs3(j); 
					if (dep[j] + 1 > dep[i]) 
						dep[i] = dep[j] + 1; 
				} 
			if (dep[i] > curd) 
				curd = dep[i]; 
		} 

		private boolean isnear(int i, int j, int d) { 
			for (int k=0; k<4; k++) { 
				int ni = i + di[k]; 
				int nj = j + dj[k]; 
				if (ni >= 0 && ni < n && nj >= 0 && nj < m) 
					if (r[ni][nj] == 1 && dep[col[ni][nj]] == d) { 
						curo = col[ni][nj]; 
						return true; 
					} 
			} 
			return false; 
		} 

		private void dfs2(int i, int j) { 
			col2[i][j] = 1; 
			for (int k=0; k<4; k++) { 
				int ni = i + di[k]; 
				int nj = j + dj[k]; 
				if (ni >= 0 && ni < n && nj >= 0 && nj < m) { 
					if (col2[ni][nj] == 0 && r[ni][nj] == 0) 
						dfs2(ni, nj); 
					if (r[ni][nj] == 1 && dep[col[ni][nj]] == -1) { 
						w[curo][col[ni][nj]] = 1; 
						dep[col[ni][nj]] = curd; 
					} 
				} 
			} 
		} 

		private void dfs(int i, int j) { 
			col[i][j] = cnt; 
			for (int k=0; k<8; k++) { 
				int ni = i + di[k]; 
				int nj = j + dj[k]; 
				if (ni >= 0 && ni < n && nj >= 0 && nj < m) 
					if (col[ni][nj] == 0 && r[ni][nj] == 1) 
						dfs(ni, nj); 
			} 
		} 

	} 


}
