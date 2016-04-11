package com.ligang.algs.hd;

import java.util.Scanner;

/**FatMouse' Trade
Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others)
Total Submission(s): 62412    Accepted Submission(s): 21048


Problem Description
FatMouse prepared M pounds of cat food, ready to trade with the cats guarding the warehouse containing his favorite food, JavaBean.
The warehouse has N rooms. The i-th room contains J[i] pounds of JavaBeans and requires F[i] pounds of cat food. FatMouse does not have to trade for all the JavaBeans in the room, instead, he may get J[i]* a% pounds of JavaBeans if he pays F[i]* a% pounds of cat food. Here a is a real number. Now he is assigning this homework to you: tell him the maximum amount of JavaBeans he can obtain.
 

Input
The input consists of multiple test cases. Each test case begins with a line containing two non-negative integers M and N. Then N lines follow, each contains two non-negative integers J[i] and F[i] respectively. The last test case is followed by two -1's. All integers are not greater than 1000.
 

Output
For each test case, print in a single line a real number accurate up to 3 decimal places, which is the maximum amount of JavaBeans that FatMouse can obtain.
 

Sample Input
5 3
7 2
4 3
5 2
20 3
25 18
24 15
15 10
-1 -1
 

Sample Output
13.333
31.500
 

Author
CHEN, Yue
 

Source
ZJCPC2004
 

Recommend
JGShining   |   We have carefully selected several similar problems for you:  1008 1050 1005 1051 1003 
**/ 
public class Main1009 {

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
			
			//计算
			double max = max(M,J,F);
			System.out.println("max :"+String.format("%.3f", max));
		}
	}
	
	static double max(double remain ,double[] J ,double[] F){
		int n = J.length;
		double max = 0.0;
		double sum = 0.0;
		int count = 0;
		double usedP = 0.0;
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
