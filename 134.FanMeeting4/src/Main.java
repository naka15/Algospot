//2015/6/30 Algospot.com FanMeeting 
//F=0 M=1, 이진수이며 올림 없는 곱셈을 하여 해결 할 수 있음
//0또는 1밖에 없으므로 실제로 곱셈을 하지 않고 1인 경우만 자리수를 저장하고 결과 배열에 더해서 문제를 해결
//따라서 M의 1의 개수와 N의 1개수의 곱만큼 시간이 걸림
//시간초과 문제 해결, 이 전에 단순 곱셈을 이용한 방법, 카라추바 곱셈을 활용한 방법 모두 시간초과이었음.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	ArrayList<Integer> member;
	ArrayList<Integer> fan;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Main m = new Main();
		m.In();

	}

	public void In() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int result[] = new int[cases];
		for (int i = 0; i < cases; i++) {
			char m[] = br.readLine().toCharArray();
			char f[] = br.readLine().toCharArray();
			member = new ArrayList<Integer>();
			fan = new ArrayList<Integer>();
			// member중 M인 경우(1인 경우) 자리 수 입력, member는 뒤집어서 넣는다.
			for (int j = 0; j < m.length; j++) {
				if (m[j] == 'M') {
					member.add(j);
				}
			}
			
			//fan 중 M인 경우(1인 경우) 자리 수 입력
			for (int j = 0; j <f.length; j++) {
				if (f[j] == 'M') {
					fan.add(f.length-j-1);
				}
			}

			result[i] = FanMeeting(m.length, f.length);
		}
		for(int i=0; i<cases; i++)
			System.out.println(result[i]);
	}

	public int FanMeeting(int msize, int fsize) {
		ArrayList<Integer> ret = new ArrayList<>(Collections.nCopies(msize
				+ fsize - 1, 0));
		//member와 fan의 1의 자리수(남자의 위치)를 활용해 ret에 더함
		//ex)member가 원래 1000, fan이 10 이었다면
		//member의 1의 위치 3과 fan의 1의 위치 1을 더해 4를 구해내고
		//ret의 4의 위치에 1을 더함
		for (int i = 0; i < member.size(); i++) {
			int loc = member.get(i);
			for(int j=0; j<fan.size(); j++){
				ret.set(fan.get(j)+loc,ret.get(fan.get(j)+loc)+1);
			}
		}
		
		/*System.out.println();
		for(int i=0; i<ret.size(); i++){
			System.out.print(ret.get(i)+"  ");
		}System.out.println();
		for(int i=0; i<member.size(); i++){
			System.out.print(member.get(i)+ " ");
		}System.out.println();
		for(int i=0; i<fan.size(); i++){
			System.out.print(fan.get(i)+" ");
		}System.out.println();*/
		
		//ret의 msize-1~fsize-1위치까지가 유효 범위
		int retnum=0;
		for(int i=msize-1; i<fsize; i++){
			if(ret.get(i)==0)
				retnum++;
		}
		return retnum;
	}
}
