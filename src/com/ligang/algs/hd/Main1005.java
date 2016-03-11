/**
 * Main1005.java
 * @date:2016年3月9日 上午9:29:33
 * @version 1.0.0
 */
package com.ligang.algs.hd;

/**
 * @author gang.li01
 * @desc Problem Description A number sequence is defined as follows:
 * f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.
 * Given A, B, and n, you are to calculate the value of f(n).
 * 
 * Sample Input
 * 1 1 3
 * 1 2 10
 * 0 0 0
 */
import java.util.Scanner;
public class Main1005 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		while (true){
			int A = scanner.nextInt();
			int B = scanner.nextInt();
			int n = scanner.nextInt();
			if(A + B +n ==0){
				break;
			}
			int[] s = new int[100];
			s[0] =1 ;
			s[1] = 1;
			s[2] = 1;
			
			for(int i =3 ;i<100;i++){
				s[i] = (A*s[i-1] +B*s[i-2]) %7;
			}
			
			System.out.println(s[n%49]);
		}
	}
	
	

}
