package com.ligang.algs.hd;

import java.util.Scanner;

/**
 * Main1000
 * @author ligang
 *
 */
public class Main {

	private static int axisx[] = {0,-1,0,1};//行上的偏移
	private static int axisy[] = {-1,0,1,0};//列上的偏移
	private static int T= 0;// 走出迷宫的时间
	private static int N = 0 ; //迷宫宽度
	private static int M = 0; //迷宫长度
	private static int dx = 0;//终点x坐标
	private static int dy = 0;//终点y坐标
	private static String[][] map = new String[N][M]; //迷宫组成
	private static boolean escape = false; //是否可逃脱
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(true){
			N = scanner.nextInt();
			M = scanner.nextInt();
			int sx = 0;
			int sy = 0;
			int wallNum = 0;
			T = scanner.nextInt();
			if(N == 0 && M ==0 && T==0){
				break;
			}
			map = new String[N][M]; 
			for(int i=0;i<N;i++){
				String readLine = scanner.next();
				for(int j =0 ;j<M;j++){
					map[i][j] = readLine.charAt(j)+"";
					if("S".equals(map[i][j])){
						sx= i;
						sy = j;
					}else if("X".equals(map[i][j])){
						wallNum++;
					}
					else if("D".equals(map[i][j])){
						dx = i;
						dy = j;
					}
				}
			}
			
			if(!(N*M - wallNum < T)){
				dfs(sx,sy,0);
			}
			else{
				escape = false;
			}
			if(escape){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
		}
	}
	
	/**
	 * 深度搜索
	 * @param sx 开始位置 x坐标
	 * @param sy 开始位置 y坐标
	 * @param cnt 已用时间
	 */
	private static void dfs(int sx,int sy , int cnt){
		
		if(sx == dx && sy == dy && cnt == T){
			escape = true;
			return ;
		}
		int temp = 0 ;
		temp =(T- cnt) - (Math.abs(sx-dx)+Math.abs(sy-dy));
		//temp 小于 0时间不够，temp&1等于1则temp为奇数
		if(temp < 0 || ((temp&1) == 1)){
			escape = false;
			return ;
		}
		
		for(int i = 0 ;i<4;i++){
			if(sx+axisx[i] > N-1 || sx+axisx[i]<0 ||sy+axisy[i] > M-1 || sy+axisy[i] <0){
				continue;
			}
			if(!"X" .equals(map[sx+axisx[i]][sy+axisy[i]])){
				map[sx+axisx[i]][sy+axisy[i]] = "X";
				dfs(sx+axisx[i],sy+axisy[i],cnt+1);
				map[sx+axisx[i]][sy+axisy[i]] = ".";
			}
			
			if(escape){
				break;
			}
		}
	}


}
