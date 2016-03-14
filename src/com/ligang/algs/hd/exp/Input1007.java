/**
 * Input1007.java
 * @date:2016年3月11日 下午3:47:27
 * @version 1.0.0
 */
package com.ligang.algs.hd.exp;

import java.io.BufferedWriter;
import java.io.File;
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
		//目标文件目录
		if(args.length <5){
			System.out.println("参数不正确，请输入正确的参数！！！");
			System.exit(1);
		}
		String dic = args[0];
		String fileName = args[1];
		int cases = Integer.parseInt(args[2]);
		int randIntRange = Integer.parseInt(args[3]);
		double randDoubleRange = Double.parseDouble(args[4]);
		File dicpath = new File(dic);
		if(!dicpath.exists()){
			dicpath.mkdirs();
		}
        File dicFile = new File(dic, fileName);
		System.out.println("write to "+dicFile.getCanonicalPath());
         FileWriter fo = new FileWriter(dicFile,false);
         BufferedWriter bf = new BufferedWriter(fo);
         for(int i = 0; i<cases ;i++){
        	 int N = randowInt(randIntRange);
        	 
        	 bf.write(N+"\n");
        	 for(int j = 0 ;j<N;j++){
        		 double x =randowDouble(randDoubleRange);
        		 double y = randowDouble(randDoubleRange);
        		 bf.write(String.format("%.2f", x)+" "+String.format("%.2f", y) +"\n");
        	 }
         }
         bf.write(0+"\n");
         bf.flush();
         bf.close();
         System.out.println("write to "+dicFile.getCanonicalPath()+" finish");
	}

	public static int  randowInt(int n){
		Random rand = new Random();
		int result = 0;
		result = rand.nextInt(n);
		if(result == 0){
			return 1 ;
		}
		return result;
	}
	
	public static double randowDouble(double d){
		Random rand = new Random();
		return (rand.nextDouble()-0.5)*d;
	}
}
