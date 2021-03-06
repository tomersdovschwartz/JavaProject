import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class Hanucka {
	
	public static void main(String[] args)
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		arr.add(4);
		arr.add(2);
		arr.add(4);
		arr.add(4);
		arr.add(5);
		arr.add(2);
	
		

		System.out.println(DisguntLevel(arr,arr.size()));
	}
	
	private static void orderIdealTime(ArrayList<Integer> arr)
	{
		for(int i= 0; i < (arr.size()-1); i++)
		{
			if((i+1) < arr.size() && arr.get(i) == arr.get(i+1))
			{
				arr.remove(i+1);
				orderIdealTime(arr);
			}  
		}
		return;
	}
	
	private static ArrayList<Integer> repeatIdealTime(ArrayList<Integer> arr,int size)
	{
		Collections.sort(arr);
		ArrayList<Integer> repeatMin = new ArrayList<Integer>();
		int j=0,countMin;
		for(int i= 0; i <size; i++)
		{
			repeatMin.add(1);
			countMin=1;
			while((j+1)<arr.size() && arr.get(j) == arr.get(j+1))
			{
				j++;
				repeatMin.set(repeatMin.size()-1,++countMin);	
			}
			
				j++;
			
		}
		return repeatMin;
	}

	private static int DisguntLevel(ArrayList<Integer> idealTime, int n)
	{
		ArrayList<Integer> orderMin= new ArrayList<Integer>(idealTime);
		Collections.sort(orderMin);
		orderIdealTime(orderMin);
		ArrayList<Integer> repeatMin=repeatIdealTime(idealTime,orderMin.size());

		int disguntlevel=0,dountin,min;
		for(int i = 0; i < repeatMin.size(); i++)
		{
			dountin=1;
			min=-1;

			 while(dountin!=repeatMin.get(i))
			 {
				 if( ((orderMin.get(i)+min)>0) && (!(orderMin.contains(orderMin.get(i)+min))))
				 {
					 disguntlevel=disguntlevel+Math.abs(min);
					 dountin++;
					 orderMin.add(orderMin.get(i)+min);
				 }
			 
			 	min=-min;
			 	if(min<0)
			 	min--;
			}
		}
		return(disguntlevel);
	}
}
 
