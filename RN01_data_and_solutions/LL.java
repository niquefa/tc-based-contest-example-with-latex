import java.io.BufferedReader;
import java.io.InputStreamReader;


public class LL {
	public static void main(String[] args)throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while( (str = br.readLine()) != null )
		{			
			String a[] = str.split(" ");
			int data[] = new int[a.length];
			for (int i = 0; i < data.length; i++)
				data[i] = Integer.parseInt(a[i]);
			int N = Integer.parseInt(br.readLine().trim());
			int ans[] = transform(data, N);
			for (int i = 0; i < ans.length; i++) {
				if( i > 0 )
					System.out.print(" ");
				System.out.print(ans[i]);
			}
			System.out.println();
		}			
	}	
	public static int[] transform(int[] data, int L){
		int[] res = new int[data.length];
		boolean bandera=false;

		int n = data.length;

		for(int i=0;i<L;i++){
			if(!bandera){
				res = valores(data,n);
				bandera=true;
			}
			else{
				n/=2;
				int[] tmp;
				tmp = valores(res,n);  
				for(int j=0;j<n;j++){
					res[j]=tmp[j];  
				}
			}
		}

		return res;
	}

	public static int[] valores(int[] data, int n){

		int[] res = new int[data.length];

		int p=0;

		for(int i=0;i<n-1;i+=2){
			res[p] = data[i] + data[i+1];  
			p++;  
		}

		for(int i=0;i<n-1;i+=2){
			res[p] = data[i] - data[i+1];
			p++;  
		}

		return res;
	}
}
