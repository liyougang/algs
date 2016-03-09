/**
 * Main1004.java
 * @date:2016年3月7日 下午3:59:22
 * @version 1.0.0
 */
package com.ligang.algs.hd;

import java.util.Scanner;

/**
 * @author gang.li01
 *
 */
public class Main1004 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(true){
			int N = scanner.nextInt();
			if(N == 0){
				break;
			}
			String[] colors = new String[N];
			for(int i = 0;i<N;i++){
				colors[i] = scanner.next();
			}
			
			int[] nums = new int[N];
			int max = 0;
			for(int i =0 ;i<N;i++){
				for(int j=i+1 ;j<N ;j++){
					if(colors[i].equals(colors[j])){
						nums[i]++;
					}
				}
				
				if(max < nums[i]){
					max = nums[i];
				}
			}
			
			for(int i = 0 ;i<N ;i++){
				if(nums[i] == max){
					System.out.println(colors[i]);
					break;
				}
			}
		}
	}
	

}
