/**
 * Main1002.java
 * @date:2016年2月29日 上午9:22:26
 * @version 1.0.0
 */
package com.ligang.algs.hd;

import java.math.BigInteger;
import java.util.Scanner;


/**
 * @author gang.li01
 *
 */
public class Main1002 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int count = 1;
		while(scanner.hasNext() && count <=N){
			String op1 =scanner.next();
			String op2 = scanner.next();
			String result = add(op1, op2);
			System.out.println("Case "+count+":");
			System.out.println(op1 + " + " + op2 +" = " +result);
			System.out.println();
			count++;
			
		}
	}
	
	
	public static int[] carvetTo(String val ,int splitLen){
		int len = val.length();
		
		int[] result = new int[len];
		int count = 0 ;
		for(int i =len ;i >0 ; i -=splitLen){
			int end = i ;
			int start = i-splitLen <0 ? 0 : i-splitLen;
			result[count] =  Integer.parseInt(val.substring(start,end));
			count++;
		}
		int[] newResult = new int[count];
        System.arraycopy(result, 0, newResult, 0, count);
//        for(int i = 0 ; i<count ;i++){
//        	newResult[count-i-1] = result[i];
//        }
		return newResult;
	}
	
	public static String add(String val1 ,String val2){
		int[] addResult = addArry(carvetTo(val1, 4), carvetTo(val2, 4), 10000);
		String result = "";
		for(int i = 0;i <addResult.length ;i++){
			result += rightLeadZero(""+addResult[i], 4);
		}
		return trimLeftZero(result);
	} 
	
	public static String rightLeadZero(String val,int maxLen){
		
		int len = val.length();
		StringBuilder result = new StringBuilder(val);
		String zeros ="";
		if(len < maxLen){
			for(int i = 0;i<maxLen -len ;i++){
				zeros += "0";
			}
		}
	
		return zeros+val;
	}
	
	
	
	public static int[] addArry(int[] val1 ,int[] val2 ,int max){
		int carry = 0;
		if(val1.length <val2.length){
			int[] temp = val1;
			val2 = val1;
			val2 = temp;
			
		}
		
		int[] result = new int[val1.length];
		int xIndex = val1.length;
		int yIndex = val2.length;
		//common part add
		while(yIndex >0){
			int sum =  (val1[--xIndex] + val2[--yIndex] +carry);
			result[xIndex] = sum ;
			if(result[xIndex] >= max){
				
				result[xIndex] -= max;
				carry = 1;
			}
			else {
				carry = 0;
			}
		}
		
		
		while(carry >0 && xIndex >0){
			result[--xIndex] =(result[xIndex] + 1);
			if(result[xIndex] >=max){
				result[xIndex] -= max;
				carry = 1 ;
			}
			else {
				carry = 0 ;
			}
			
		}
		
		if(carry > 0){
			int[] newResult = new int[xIndex+1];
			System.arraycopy(result, 0, newResult, 1, xIndex);
			newResult[0] = 1;
			return newResult;
		}
	
		return result;
	}
	
	public static String reverse(String val){
		String str ="";
		for(int i = val.length()-1;i>=0 ;i--){
			str += val.charAt(i);
		}
		return str;
	}
    
	public static String trimLeftZero(String val){
		int xIndex = 0;
		while(xIndex < val.length()){
			xIndex++;
			if(val.charAt(xIndex) != '0'){
				break;
			}
		}
		return val.substring(xIndex,val.length());
	}
	

}
