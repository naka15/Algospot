//2015/6/18 Algospot.com 문제 Fence https://algospot.com/judge/problem/read/FENCE
//분할 정복

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
	private int fenceNum;
	private int arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		Main m = new Main();
		m.In();
	}
	
	public void In() throws NumberFormatException, IOException{
		BufferedReader 	br = new BufferedReader(new InputStreamReader(System.in));
		int cases= Integer.parseInt(br.readLine());
		int result[] = new int[cases];
		for (int i=0; i<cases; i++){
			fenceNum=Integer.parseInt(br.readLine());
			arr= new int[fenceNum];
			String t[]= new String[fenceNum];
			t=br.readLine().split(" ");
			for(int j=0; j<fenceNum; j++){
				arr[j]=Integer.parseInt(t[j]);
			}
			
			result[i]=solve(0,fenceNum-1);
		}
		for(int i=0; i<cases; i++)
			System.out.println(result[i]);
	}
	
	public int solve(int left, int right){
		if(left==right)
			return arr[left];
		int mid = (left+right)/2;
		//1,2의 경우 왼쪽 또는 오른쪽이 큰 경우
		int ret = Math.max(solve(left,mid),solve(mid+1,right));
		int low=mid;
		int high=mid+1;
		int height=Math.min(arr[low],arr[high]);
		ret = Math.max(ret,height*(high-low+1));
		//3의 경우, 왼쪽 오른쪽 걸쳐 큰 경우
		while(low>left||high<right){
			//high<right,  high==right&&low>left 인 경우 while문 들어와서 high++는 잘못된 메모리를 가르킬 수 있기 때문
			//low==left인 경우 low가 어떤 값을 갖던 high쪽으로 늘어나야함, low-1쪽보다 high+1쪽이 큰 경우 high++ 
			if(high<right&&(low==left||arr[low-1]<arr[high+1])){
				high++;
				height=Math.min(height, arr[high]);
			}else{
				low--;
				height=Math.min(height, arr[low]);
			}
			ret=Math.max(ret,height*(high-low+1));
		}
		
		return ret;
	}

}
