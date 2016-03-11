/**
 * Input1007.java
 * @date:2016年3月11日 下午3:47:27
 * @version 1.0.0
 */
package com.ligang.algs.hd.exp;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author gang.li01
 *
 */
public class Input1007 {
    
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 
         String fileName = "1007.txt";
         System.out.println("write to "+fileName);
         FileWriter fo = new FileWriter(fileName);
         BufferedWriter bf = new BufferedWriter(fo);
         for(int i = 0; i<100 ;i++){
        	 int N = new Random().nextInt();
        	 bf.write(N+"\n");
        	 for(int j = 0 ;j<N;j++){
        		 double x = new Random().nextDouble();
        		 double y = new Random().nextDouble();
        		 bf.write(x+"\n");
        		 bf.write(y+"\n");
        	 }
         }
         bf.flush();
         bf.close();
         System.out.println("write to "+fileName+"finish");
	}

}
