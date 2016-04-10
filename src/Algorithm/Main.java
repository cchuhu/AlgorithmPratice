package Algorithm;

import java.util.ArrayList;
import java.util.Scanner;

import javax.rmi.CORBA.Tie;

/** 
 * @author Huhu
 * @version 创建时间：Apr 8, 2016 7:50:57 PM 
 * 类说明 动态规划问题
 */
public class Main {
	int n;//糖果数量
	int v;//货车容量
static int [] ti;
static int [] pi;
static int[][] dp;

	public static void main(String[] args){
		Scanner sc = new Scanner (System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		ti = new int[10001];
		pi = new int[10001];
		dp = new int[10001][10001];
		int n = sc.nextInt();
		int v = sc.nextInt();
		for(int i = 0;i<n;i++){
			//读入每组数据
			ti [i]= sc.nextInt();
			pi [i]= sc.nextInt();
	
		}
		
		for(int j = 1; j<=n; j++)  
		{  
		    for(int k = v; k >=ti[j]; k--) 
		    {  
		    	
		    	if(dp[j-1][v]>=dp[j-1][v-ti[j]]+pi[j]){
		    		//不装糖果的情况
		    		dp[j][v] = dp[j-1][v];
		    	}else{
		    		//装入糖果的情况
		    		dp[j][v]=dp[j-1][v-ti[j]]+pi[j];
		    		list.add(k);
		    	}
		    }
		    
		}  
		//第一行
		if(dp[n][v] == 0){
			System.out.println(0);
			System.out.println("No");
		}else{
			System.out.println(dp[n][v]);
			//第二行
			for(Integer item:list){
				System.out.println(item+" ");
			}
		}
		
	}
}
