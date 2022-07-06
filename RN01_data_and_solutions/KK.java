
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;
public class KK
{
	public static void main(String[] args)throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		while( (str = br.readLine()) != null )
		{
			int N = Integer.parseInt(str);
			String a[] = new String[N];
			for (int i = 0; i < N; i++)
				a[i] = br.readLine();
			String ans[] = attackPositions(a);
			if( ans.length == 0 )
			{
				System.out.println("0 found");
				continue;
			}
			System.out.println(ans.length+" found");
			for (int i = 0; i < ans.length; i++)
				System.out.println(ans[i]);
		}			
	}
	public static String[] attackPositions(String[] pieces) {
		int[] dx={2,2,1,1,-2,-2,-1,-1};
		int[] dy={1,-1,2,-2,1,-1,2,-2};
		int[] xx=new int[pieces.length];
		int[] yy=new int[pieces.length];
		int minx=99999999;
		int miny=99999999;

		for(int i=0; i<pieces.length; i++){
			StringTokenizer st=new StringTokenizer(pieces[i]," ,");
			xx[i]=Integer.parseInt(st.nextToken());
			yy[i]=Integer.parseInt(st.nextToken());
			minx=Math.min(minx,xx[i]);
			miny=Math.min(miny,yy[i]);
		}
		Vector ans=new Vector();
		for(int x=minx-2; x<=minx+2; x++){
			outer:
				for(int y=miny-2; y<=miny+2; y++){
					goodness:
						for(int i=0; i<xx.length; i++){
							for(int j=0; j<dx.length; j++){
								if(x+dx[j]==xx[i] && y+dy[j]==yy[i]) continue goodness;
							}
							continue outer;
						}
		ans.add(x+","+y);
				}
		}
		String[] a=new String[ans.size()];
		for(int i=0; i<a.length; i++){
			a[i]=ans.elementAt(i).toString();
		}
		return a;
	}
}
