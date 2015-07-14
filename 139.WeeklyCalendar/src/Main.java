import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2015/6/30 Algospot.com WEEKLYCALNER https://algospot.com/judge/problem/read/WEEKLYCALENDAR
public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Main m = new Main();
		m.IN();
	}

	public void IN() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int result[][] = new int[cases][7];
		for (int i = 0; i < cases; i++) {
			String s[] = new String[3];
			s = br.readLine().split(" ");
			int month = Integer.parseInt(s[0]);
			int day = Integer.parseInt(s[1]);
			String week = s[2];
			result[i]=calender(month,day,week);
		}
		for(int i=0; i<cases; i++){
			for(int j=0; j<7; j++){
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}

	public int[] calender(int month, int day, String week) {
		int ret[] = new int[7];
		int i = 0;
		switch (week) {
		case "Sunday":
			i = 0;
			break;
		case "Monday":
			i = 1;
			break;
		case "Tuesday":
			i = 2;
			break;
		case "Wednesday":
			i = 3;
			break;
		case "Thursday":
			i = 4;
			break;
		case "Friday":
			i = 5;
			break;
		case "Saturday":
			i = 6;
			break;
		}

		int limitDay=getLimitDay(month);
		
		int preMonthLimit = 0;
		if (day - i < 1) {
			if(month==1){
				preMonthLimit=getLimitDay(12);
			}else{
				preMonthLimit=getLimitDay(month-1);
			}
		}
		int x=day;
		for (int j = i; j >=0; j--) {
			if(x>0){
				ret[j]=x--;
			}else{
				ret[j]=preMonthLimit--;
			}
		}
		x=day+1;
		int t=1;
		for(int j=i+1; j<=6; j++){
			if(x<=limitDay){
				ret[j]=x++;
			}else{
				ret[j]=t++;
			}
		}
		return ret;
	}

	public int getLimitDay(int month) {
		int limitDay;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12) {
			limitDay = 31;
		} else if (month == 2) {
			limitDay = 28;
		} else {
			limitDay = 30;
		}
		return limitDay;

	}
}
