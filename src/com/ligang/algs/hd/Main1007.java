/**
 * Main1007.java
 * @date:2016年3月11日 上午9:46:52
 * @version 1.0.0
 */
package com.ligang.algs.hd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


/**
 * @author gang.li01
 *
 *
 *Have you ever played quoit in a playground? Quoit is a game in which flat rings are pitched at some toys, with all the toys encircled awarded.
 *In the field of Cyberground, the position of each toy is fixed, and the ring is carefully designed so it can only encircle one toy at a time. 
 *On the other hand, to make the game look more attractive, the ring is designed to have the largest radius. Given a configuration of the field, 
 *you are supposed to find the radius of such a ring.
 *Assume that all the toys are points on a plane. 
 *A point is encircled by the ring if the distance between the point 
 *and the mid of the ring is strictly less than the radius of the ring. If two toys are placed at the same point,
 * the radius of the ring is considered to be 0.
 */
public class Main1007 {
	
	private static final int SIZE = 100000;
	private static Point[] num = new Point[SIZE];
	private static Point[] c = new Point[SIZE];
	private static final int L = -1;
	private static final int R = -1;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        while(true){
        	int N = scan.nextInt();
        	if(N == 0 ){
        		break;
        	}
        	for(int i = 0 ; i<N ;i++){
        		double x = scan.nextDouble();
        		double y = scan.nextDouble();
        		num[i] = new Point(x, y);
        	}  
        	Arrays.sort(num,0,N,new PointComp("x"));
        	Main1007 tt = new Main1007();
        	double dis = tt.divide_conquer(0, N-1);
        	
        	System.out.println(String.format("%.2f", dis/2));
        }
      
	}
	
	/**
	 * 计算A,B2点的最短距离
	 * @param A
	 * @param B
	 * @return
	 */
	public double distance(Point A,Point B){
		
		return Math.sqrt(Math.pow(A.x-B.x,2.0)+Math.pow(A.y-B.y,2.0));
	}
	
	/**
	 * 分治法求最短距离
	 * @param low
	 * @param high
	 * @return
	 */
	public double divide_conquer(int low,int high){
		int count = high-low;
		double dis;
		if(count ==0){
			return 0;
		}
		else if(count == 1){
			return distance(num[low],num[high]);
		}
		else if(count ==2){
			double temp1,temp2,temp3;
			temp1 = distance(num[low], num[low+1]);
			temp2 = distance(num[low+1], num[high]);
			temp3 = distance(num[low], num[high]);
			
			return min(temp1,temp2,temp3);
		}
		else{
			int mid = count /2;
			double min;
			double leftMinDistance = divide_conquer(low, mid);
			double rightMinDistance = divide_conquer(mid+1, high);
			dis = minDistance(leftMinDistance,rightMinDistance);
			
			int i = 0;
			int p = 0 ;
			for(i = 0 ; i<=mid ;i++){
				double leftRecord = num[mid].x -dis;
				if(num[i].x > leftRecord){
					num[i].index = R;
					num[i].sortBy = "y";
					c[p] = num[i];
					p++;
				}
				
			}
			
			for(;i<=high;i++){
				double rightRecord = num[mid].x+dis;
				if(num[i].x < rightRecord){
					num[i].index = L;
					num[i].sortBy = "y";
					c[p] = num[i];
					p++;
				}
				
			}
			
			Arrays.sort(c,0,p,new PointComp("y"));
			
			for(i = 0 ;i<p;i++){
				if(c[i].index == L){
					for(int j = 1 ;(j<7 && i+j<p ) ;j++){
						if(c[i+j].index == R){
							min = distance(c[i], c[i+j]);
							if(min <dis){
								dis = min;
 							}
						}
					}
				}
			}
		}
		
		return dis ;
	}
	
	public double min(double temp1,double temp2 ,double temp3){
		if(temp1 >temp2){
			temp1 = temp2;
		}
		
		if(temp1 <temp3){
			return temp1;
		}
		else{
			return temp3;
		}
	}
	
	public double minDistance(double temp1 ,double temp2){
		if(temp1 <temp2){
			return temp1;
		}
		else{
			return temp2;
		}
	}
	
}

class Point{
	Double x ;
	Double y ;
	Integer index;
	String sortBy = "x";
	Point(Double x,Double y){
		this.x = x ;
		this.y = y;
	}
	
	
	
}
class PointComp implements Comparator<Point>{
	private String sortBy = "x";
	
	public PointComp(String sortBy){
		this.sortBy = sortBy;
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Point o1, Point o2) {
		if("x".equals(this.sortBy)){
			return o1.x.compareTo(o2.x);
		}
		else if("y".equals(this.sortBy)){
			return o1.y.compareTo(o2.y);
		}
		else{
			return o1.x.compareTo(o2.x);
		}
		
	}
	
}
	
