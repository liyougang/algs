/**
 * Main1003.java
 * @date:2016年3月4日 下午3:24:58
 * @version 1.0.0
 */
package com.ligang.algs.hd;

import java.util.Scanner;

/**
 * @author gang.li01
 * @desc 求最大子序列
 */
public class Main1003 {
      class MaxSub{
    	 long max;
    	 int beginIndex;
    	 int endIndex;
    	 MaxSub(long max ,int beginIndex,int endEIndex){
    		 this.max =  max;
    		 this.beginIndex = beginIndex;
    		 this.endIndex = endEIndex;
    	}
     }		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		
			for(int i =1 ;i<=num ;i++){
				int N = scanner.nextInt();
				int[] arr = new int[N];
				for(int j =0 ;j<N;j++){
					arr[j] = scanner.nextInt();
				}
				
				//calculate max sub
				System.out.println("Case "+i+":");
				//Main1003 instance = new Main1003();
				//instance.maxSubTwo(arr);
				maxSub(arr);
			}
			
		
	}
	/**
	 * 穷举法求最大子序列
	 * @param arr
	 */
	public static void maxSub(int[] arr){
		int len = arr.length;
		int sum = 0 ;
		int begin = 0; 
		int end = 0;
		int max = 0;		
		for(int i = 0 ;i<len;i++){
			for(int j = i;j<len;j++){
				sum =sum+arr[j];
				if(sum > max){
					begin = i ;
					end = j;
					max = sum;
					
				}
			}
			sum = 0;
		}
		System.out.println(max+" "+(begin+1)+" "+(end+1));
	}
	
	/**
	 * 求最大子序列方法two--递归法，求左右中三部份的最大序列
	 * @param arr
	 */
    public  void maxSubTwo(int[] arr){
		int left = 0;
		int right = arr.length -1;
		int center = (left + right ) /2;
		MaxSub result = maxSubResult(left,right,arr);
		System.out.println(result.max+" "+(result.beginIndex+1)+" "+(result.endIndex+1));
	}
    
    public  MaxSub maxSubResult(int left ,int right,int[] arr){
    	if(left == right){
    		return new  MaxSub(arr[left], left, right);
    	}
    	
    	int center = (left+right)/2;
    	MaxSub maxLeftSum = maxSubResult(left,center,arr);
    	MaxSub maxRightSum = maxSubResult(center+1,right , arr);
    	
    	
    	//左边以center结尾的最大的sub
    	long leftBorderMaxSum = 0 ,leftBorderSum=0,leftBorderIndex =center;
    	
    	for(int i = center;i>=left;i--){
    		leftBorderSum +=arr[i];
    		if(leftBorderMaxSum < leftBorderSum){
    			leftBorderIndex = i;
    			leftBorderMaxSum = leftBorderSum;
    		}
    	}
    	
    	//右边以center开始的最大sub
    	long rightBorderMaxSum = 0 ,rightBorderSum=0,rightBorderIndex = center+1;
    	for(int j = center+1 ;j<=right ;j++){
    		rightBorderSum +=arr[j];
    		if(rightBorderMaxSum < rightBorderSum){
    			rightBorderIndex = j;
    			rightBorderMaxSum = rightBorderSum;
    		}
    	}
    	MaxSub centerMaxSum = new MaxSub(0, center, center);
    	centerMaxSum.beginIndex = (int)leftBorderIndex;
    	centerMaxSum.endIndex = (int)rightBorderIndex;
    	centerMaxSum.max = leftBorderMaxSum + rightBorderMaxSum;
    	MaxSub sumMax = maxThree(maxLeftSum,maxRightSum,centerMaxSum);
    	return sumMax;
    }
    
    public  MaxSub maxThree(MaxSub leftSum,MaxSub rightSum,MaxSub centerSum){
    	MaxSub maxSub = leftSum;
    	if(maxSub.max < rightSum.max){
    		maxSub = rightSum;
    	}
    	
    	if(maxSub.max < centerSum.max){
    		
    		maxSub = centerSum;
    	}
    	
    	return maxSub;
    }

}
