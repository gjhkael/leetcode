package array;
/*
 * 
 */
public class MaxSubArray {
	public static int maxSubArray(int[] array){
		int currMax=0;
		int result=0;
		
		for(int i=0;i<array.length;i++){
			currMax = array[i]>currMax+array[i]?array[i]:array[i]+currMax;
			if(currMax>result)
				result=currMax;
		}
		return result;
		
	}
	
	public static void main(String[] args){
		int[] array={1,-2,3,10,-4,7,2,-5};
		int result=maxSubArray(array);

		System.out.println(result);

	}
	
	
}
