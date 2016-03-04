/**
 * Main1002.java
 * @date:2016年2月29日 上午9:22:26
 * @version 1.0.0
 */
package com.ligang.algs.hd;

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
		String reverseVal = reverse(val);
		for(int i =len ;i >0; i -=splitLen){
			int start = (i-splitLen) <0 ? 0 :(i - splitLen);
			int end =  i;
			result[count] =  Integer.parseInt(val.substring(start,end));
			count++;
		}
		int[] newResult = new int[count];
		int len1 = count;
		for(int i = 0 ;i<len1;i++){
			newResult[i] = result[--count];
		}
      //  System.arraycopy(result, 0, newResult, 0, count);
		return newResult;
	}
	
	public static String add(String val1 ,String val2){
		String[] addResult = addArry(carvetTo(val1, 4), carvetTo(val2, 4));
		String result = "";
		for(int i = 0;i <addResult.length ;i++){
			result += addResult[i];
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
	
	
	
	public static String[] addArry(int[] val1 ,int[] val2){
		int carry = 0;
		if(val1.length <val2.length){
			int[] temp = val1;
			val1 = val2;
			val2 = temp;
			
		}
		
		int[] result = new int[val1.length];
		String[] resultStr = new String[val1.length];
		int xIndex = val1.length;
		int yIndex = val2.length;
		
		//common part add
		while(yIndex >0){
			int sum =  (val1[--xIndex] + val2[--yIndex] +carry);
			int maxLen = (val1[xIndex]+"").length() > (val2[yIndex]+"").length() ?( val1[xIndex]+"").length() :(val2[yIndex]+"").length();
			result[xIndex] = sum ;
			resultStr[xIndex] = rightLeadZero((result[xIndex]+""), maxLen);
			if(result[xIndex] >= maxNum[maxLen]){
				result[xIndex] -= maxNum[maxLen];
				resultStr[xIndex] = rightLeadZero((result[xIndex]+""), maxLen);
				carry = 1;
			}
			else {
				carry = 0;
			}
		}
		
		
		while( xIndex >0){
			int maxLen = (result[xIndex]+"").length();
			result[--xIndex] =(val1[xIndex] + carry);
			resultStr[xIndex] = rightLeadZero((result[xIndex]+""), maxLen);
			if(result[xIndex] >=maxNum[maxLen]){
				result[xIndex] -= maxNum[maxLen];
				resultStr[xIndex] = rightLeadZero((result[xIndex]+""), maxLen);
				carry = 1 ;
			}
			else {
				carry = 0 ;
			}
			
		}
		
		
		
		if(carry > 0){
			int[] newResult = new int[val1.length+1];
			String[] newResultStr = new String[val1.length+1];
			System.arraycopy(resultStr, 0, newResultStr, 1, val1.length);
			newResultStr[0] = "1";
			return newResultStr;
		}
	
		return resultStr;
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
			
			if(val.charAt(xIndex) != '0'){
				break;
			}
			xIndex++;
		}
		return val.substring(xIndex);
	}
	
	static int maxNum[] = {0,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000};

}
