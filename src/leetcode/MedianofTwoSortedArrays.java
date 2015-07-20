package leetcode;

/**
 * Created by havstack on 7/13/15.
 */
public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        double result=0.0;
        if((n+m)%2==0){
            double temp1=findTopK(nums1,0,n-1,nums2,0,m-1,(n+m)/2);
            double temp2=findTopK(nums1,0,n-1,nums2,0,m-1,(m+n)/2+1);
            result=(temp1+temp2)/2;
        }else{
            result=findTopK(nums1,0,n-1,nums2,0,m-1,(m+n+1)/2);
        }
        return result;

    }
    public double findTopK(int []nums1,int s1,int e1,int[]nums2,int s2,int e2,int k){
        int mid1=(e1+s1)/2;
        int mid2=(e2+s2)/2;

        if(s1>e1){
            return nums2[s2+k-1];
        }
        if(s2>e2){
            return nums1[s1+k-1];
        }
        if(nums1[mid1]>=nums2[mid2]){
            if((mid1-s1+1)+(mid2-s2+1)>k){
                return findTopK(nums1,s1,mid1-1,nums2,s2,e2,k);
            }else{
                return findTopK(nums1,s1,e1,nums2,mid2+1,e2,k-(mid2-s2+1));
            }
        }else{
            if((mid1-s1+1)+(mid2-s2+1)>k){
                return findTopK(nums1,s1,e1,nums2,s2,mid2-1,k);
            }else{
                return findTopK(nums1,mid1+1,e1,nums2,s2,e2,k-(mid1-s1+1));
            }
        }
    }
}
