package array;

import java.util.HashMap;


public class TwoSum {
	public int[] twoSum( int[] numbers, int target) {
		int[] result=new int[2];
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<numbers.length;i++){
			if(map.containsKey(target-numbers[i])){
				result[0]=map.get(target-numbers[i])+1;
				result[1]=i+1;
				break;
			}else{
				map.put(numbers[i], i);
			}
		}
		return result;
	}
	public static void main(String[] args){
		int[] num={1,2,3,4,5,6,8};
		TwoSum s=new TwoSum();
		int [] result=s.twoSum(num, 14);
		System.out.println(result[0]+""+result[1]);
	}

}
