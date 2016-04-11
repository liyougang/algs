package com.ligang.algs.hd;

import java.util.Scanner;

/**
 * the highest building in our city has only one elevator. 
 * A request list is made up with N positive numbers. 
 * The numbers denote at which floors the elevator will stop, 
 * in specified order. It costs 6 seconds to move the elevator up one floor,
 * and 4 seconds to move down one floor.
 * The elevator will stay for 5 seconds at each stop.
 * @author gang.li01
 *
 */
public class Main1008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Scanner scanner = new Scanner(System.in);
          while(true){
        	  int N = scanner.nextInt();
        	  if(N == 0){
        		  break;
        	  }
        	  int[] reqArr = new int[N+1]; 
        	  for(int i =1 ;i<=N+1;i++){
        		  reqArr[i] = scanner.nextInt();
        	  }
        	  int result = 0;
        	  for(int i = 1 ;i<=N+1;i++){
        		  if(reqArr[i] >reqArr[i-1]){
        			  result += (reqArr[i] - reqArr[i-1])*6+5;
        		  }
        		  else{
        			  result += (reqArr[i-1] - reqArr[i] )*4+5;
        		  }
        	  }
        	  System.out.println(result);
          }
          
          
	}

}
