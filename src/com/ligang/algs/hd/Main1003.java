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

}
