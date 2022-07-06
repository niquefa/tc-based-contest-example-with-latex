import java.io.BufferedReader;
import java.io.InputStreamReader;


public class GG
{
	public static void main(String[] args)throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while( (str = br.readLine()) != null )
		{
			int N = Integer.parseInt(str.trim());
			String a[] = new String[N];
			for (int i = 0; i < N; i++)
			{
				a[i] = br.readLine();				
			}
			String ans[] = uniform(a);
			for (String s : ans) 
			{
				System.out.println(s);
			}
		}			
	}		
	public static String[] uniform(String[] nums) {
		String[] ret = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < nums[i].length(); j++) {
				if (nums[i].charAt(j) >= '0' && nums[i].charAt(j) <= '9')
					sb.append(nums[i].charAt(j));
				else if (nums[i].charAt(j) != ' ')
					sb.append('.');
			}
			ret[i] = sb.toString();
		}
		return ret;
	}
	public static String[] uniform3(String[] numbers)
	{
		String result[] = new String[numbers.length];

		for (int i=0; i<numbers.length; i++)
			result[i] = new String("");

		for (int i=0; i<numbers.length; i++)
			for (int j=0; j<numbers[i].length(); j++)
				if (numbers[i].charAt(j) != ' ' && !Character.isDigit(numbers[i].charAt(j)))
					result[i] += ".";
				else if (numbers[i].charAt(j) != ' ' && numbers[i].charAt(j) != '.')
					result[i] += numbers[i].charAt(j);

		return result;        
	}
}
