/**
 * Main1001.java
 * @date:2016年2月29日 上午9:14:59
 * @version 1.0.0
 */
package com.ligang.algs.hd;

import java.util.Scanner;

/**
 * @author gang.li01
 *
 */
public class Main1001 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			System.out.println(sum(n));
			System.out.println();
		}
	}
	
	public static int sum(int n ){
		int sum = 0 ;
		for(int i = -0 ;i <= n ;i++){
			sum +=i;
		}
		return sum;
	}

}
