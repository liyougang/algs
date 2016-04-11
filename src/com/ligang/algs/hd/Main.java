package com.ligang.algs.hd;

import java.util.Scanner;

/**
 * Main1000
 * @author ligang
 *
 */
public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(true){
			int M = scan.nextInt();
			int N = scan.nextInt();
			
			if(M == -1 && N == -1){
				break;
			}
			double[] J = new double[N];
			double [] F = new double[N];
			for(int i = 0 ;i<N ;i++){
				J[i] = scan.nextInt();
				F[i] = scan.nextInt();
			}
			
			double max = max(M,J,F);
			System.out.println(String.format("%.3f", max));
		}
	}
	
	static double max(double remain ,double[] J ,double[] F){
		int n = J.length;
		double sum = 0.0;
		int count = 0;
		double unitMax = 0.0;
		for(int i = 0 ;i<n && remain >0;i++){
			for(int j = 0;j<n;j++){
				double temp = J[j] / (F[j]);
				if(unitMax < temp){
					unitMax = temp;
					count = j ;
				}
			}
			
			if(F[count] <remain){
				sum +=J[count];
				remain = remain - F[count];
			}
			else{
				if(remain *unitMax >J[count]){
					remain = remain - (J[count]/unitMax);
					sum +=J[count];
				}
				else{
					sum +=remain *unitMax;
					remain = 0;
				}
			}
			
			J[count] =0;
			count = 0;
			unitMax = 0.0;
		}
		
		return sum;
	}
	
	

}
