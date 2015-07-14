import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class karatsuba {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		karatsuba k = new karatsuba();
		k.in();
	}

	public void in() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char at[] = br.readLine().toCharArray();
		char bt[] = br.readLine().toCharArray();
		ArrayList<Integer> a = new ArrayList<>(at.length);
		ArrayList<Integer> b = new ArrayList<>(bt.length);
		for (int i = 0; i < at.length; i++) {
			a.add(Character.getNumericValue(at[i]));
		}
		for (int i = 0; i < bt.length; i++) {
			b.add(Character.getNumericValue(bt[i]));
		}
		cal(a,b);
	}	

	public ArrayList<Integer> cal(ArrayList<Integer> a, ArrayList<Integer> b){
		int an=a.size();
		int bn=b.size();
		if(an<bn) return cal(b,a);
		
		if(an<=50) return multiply(a,b);
		int half = an/2;
		ArrayList<Integer> a0= new ArrayList<>(a.subList(0,half));
		ArrayList<Integer> a1 = new ArrayList<>(a.subList(half+1, a.size()-1));
		ArrayList<Integer> b0= new ArrayList<>(b.subList(0, Math.min(b.size(), half)));
		ArrayList<Integer> b1= new ArrayList<>(b.subList(Math.min(b.size(), half)+1, b.size()-1));
		
		return a;
	}
	public ArrayList<Integer> multiply(ArrayList<Integer> a, ArrayList<Integer> b){
		ArrayList<Integer> c = new ArrayList<>(a.size()+b.size()+1);
		int t=0;
		for(int i=0; i<a.size(); ++i)
			for(int j=0; j<b.size(); ++j){
				t=c.get(i+j)+a.get(i)*b.get(j);
				c.add(i+j, t);
			}
		c=normalize(c);
		return c;
	}
	
	public ArrayList<Integer> normalize(ArrayList<Integer> c){
		c.add(0);
		for(int i=0; i<c.size(); ++i){
			if(c.get(i)<0){
				int borrow=(Math.abs(c.get(i)+9))/10;
				c.add(i+1,c.get(i+1)-borrow);
				c.add(i,c.get(i)+borrow*10);
			}else{
				c.add(i+1, c.get(i+1)+c.get(i)/10);
				c.add(i,c.get(i)%10);
			}
		}
		while(c.size()>1&&c.get(c.size()-1)==0)c.remove(c.size()-1);
		return c;
	}
}
