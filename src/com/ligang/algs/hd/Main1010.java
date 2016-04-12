package com.ligang.algs.hd;

import java.util.Scanner;
/**
Problem Description
The doggie found a bone in an ancient maze, which fascinated him a lot. However, when he picked it up, the maze began to shake, and the doggie could feel the ground sinking. He realized that the bone was a trap, and he tried desperately to get out of this maze.

The maze was a rectangle with sizes N by M. There was a door in the maze. At the beginning, the door was closed and it would open at the T-th second for a short period of time (less than 1 second). Therefore the doggie had to arrive at the door on exactly the T-th second. In every second, he could move one block to one of the upper, lower, left and right neighboring blocks. Once he entered a block, the ground of this block would start to sink and disappear in the next second. He could not stay at one block for more than one second, nor could he move into a visited block. Can the poor doggie survive? Please help him.
 

Input
The input consists of multiple test cases. The first line of each test case contains three integers N, M, and T (1 < N, M < 7; 0 < T < 50), which denote the sizes of the maze and the time at which the door will open, respectively. The next N lines give the maze layout, with each line containing M characters. A character is one of the following:

'X': a block of wall, which the doggie cannot enter; 
'S': the start point of the doggie; 
'D': the Door; or
'.': an empty block.

The input is terminated with three 0's. This test case is not to be processed.
 

Output
For each test case, print in one line "YES" if the doggie can survive, or "NO" otherwise.
 

Sample Input
4 4 5
S.X.
..X.
..XD
....
3 4 5
S.X.
..X.
...D
0 0 0
 

Sample Output
NO
YES
 

Author
ZHANG, Zheng
 

Source
ZJCPC2004
*/ 

/**
 * @date 2016-04-11 09:57
 * @author gang.li01
 *
 */
public class Main1010 {
	
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
