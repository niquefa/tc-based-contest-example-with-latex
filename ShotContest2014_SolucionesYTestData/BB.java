import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BB {
	public static void main(String[] args)throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		while( (str = br.readLine()) != null )
		{
			String arr[] = str.split(" ");
			int c = Integer.parseInt(arr[0]);
			int k = Integer.parseInt(arr[1]);
			int h = Integer.parseInt(arr[2]);
			System.out.println(new TheBrickTowerHardDivTwo().find(c,k,h));			
		}			
	}	
	static class TheBrickTowerHardDivTwo { 
		public int find(int C, int K, int H){ 
			int mod = 1234567891; 
			int[][][][][][] sol = new int[4][4][4][4][8][48]; 

			for(int h=1;h<=H;++h) 
				for(int c1=0;c1<C;++c1) 
					for(int c2=0;c2<C;++c2) 
						for(int c3=0;c3<C;++c3) 
							for(int c4=0;c4<C;++c4) 
								for(int k = 0;k<=K;++k) 
								{ 
									int eq = 0; 
									long csol = 0; 
									if(c1 == c2) eq++; 
									if(c2 == c3) eq++; 
									if(c3 == c4) eq++; 
									if(c4 == c1) eq++; 
									int _eq = eq; 
									for(int ac1=0;ac1<C;++ac1) 
										for(int ac2=0;ac2<C;++ac2) 
											for(int ac3=0;ac3<C;++ac3) 
												for(int ac4=0;ac4<C;++ac4) 
												{ 
													eq = _eq; 
													if(c1==ac1)eq++; 
													if(c2==ac2)eq++; 
													if(c3==ac3)eq++; 
													if(c4==ac4)eq++; 
													if(h==1) csol = _eq <= k ? 1 : 0; 
													else if(eq <= k) csol = (csol + sol[ac1][ac2][ac3][ac4][k-eq][h-1]) % mod;  
												} 
									sol[c1][c2][c3][c4][k][h] = (int)csol; 
								} 
			long fsol = 0; 
			for(int c1=0;c1<C;++c1) 
				for(int c2=0;c2<C;++c2) 
					for(int c3=0;c3<C;++c3) 
						for(int c4=0;c4<C;++c4) 
							for(int h=1;h<=H;++h) 
								fsol = (fsol + sol[c1][c2][c3][c4][K][h]) % mod; 

			return (int)fsol; 
		} 
	}



}
