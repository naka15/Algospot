import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String result[] = new String[cases];
		for (int i = 0; i < cases; i++) {
			String temp = sc.next();
			int[] message = new int[7];
			//string to int 배열에 값 넣기
			for (int j = 0; j < 7; j++) {
				message[j] = Character.getNumericValue(temp.charAt(j));
			}
			//1,3,5,7   2,3,6,7		4,5,6,7 xor 이 000 이면 맞음
			
			int x = message[0]^message[2]^message[4]^message[6];
			int y = message[1]^message[2]^message[5]^message[6];
			int z = message[3]^message[4]^message[5]^message[6];
			//String code = ""+z+y+x;
			int code = z*4+y*2+x;
			if(code==0){
				/*for(int k=0; k<7; k++){
					System.out.println(message[k]);
				}*/
				temp=""+message[2]+message[4]+message[5]+message[6];
				result[i]=temp;
			}else{
				message[code-1]=message[code-1]^1;
				temp=""+message[2]+message[4]+message[5]+message[6];
				result[i]=temp;
			}//if 끝
		}//for 끝
		for(int i=0; i<cases; i++){
			System.out.println(result[i]);
		}
	}//main 끝

}
