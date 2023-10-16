package GG;
import java.util.*;

class People{
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private double avg;
	private int rank;
	
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getKor() {
		return kor;
	}
	void setKor(int kor) {
		this.kor = kor;
	}
	int getEng() {
		return eng;
	}
	void setEng(int eng) {
		this.eng = eng;
	}
	int getMath() {
		return math;
	}
	void setMath(int math) {
		this.math = math;
	}
	double getAvg() {
		return (double)this.getSum()/3;
	}
	void setAvg(double avg) {
		this.avg = avg;
	}
	public int getRank() {
		return rank;
	}
	void setRank(int rank) {
		this.rank = rank;
	}
	
	int getSum() {
		return this.getKor()+this.getEng()+this.getMath();
	}
	
	void printScore() {
		System.out.printf("%3s %3d %3d %3d %3d %3.2f %3d \n",this.getName(),this.getKor(),this.getEng(),this.getSum(),this.getAvg(),this.getRank());
	}
}
public class GreadePeople {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner input =new Scanner(System.in);
			
			System.out.print("몇명의 성적처리를 하나요");
			int num = input.nextInt();
			
			People stu [] = new People[num];
			
			for(int i=0; i<stu.length; i++) {
				stu[i]= new People();
			}
			for(int i=0; i<stu.length; i++) {
				System.out.print("성명을 입력하세요");
				stu[i].setName(input.next());
				System.out.print("국어점수를 입력하세요");
				stu[i].setKor(input.nextInt());
				System.out.print("영어점수를 입력하세요");
				stu[i].setEng(input.nextInt());
				System.out.print("수학점수를 입력하세요");
				stu[i].setMath(input.nextInt());
			}
			
			for(int i=0; i<stu.length; i++) {
				int rank=1;
				
				for(int j = 0; j<stu.length; j++) {
					if(stu[i].getSum() < stu[j].getSum()) rank++;
				}
				stu[i].setRank(rank);
			}
			System.out.println("=================================================");
			System.out.printf("%3s %3s %2s %2s %3s %3s %4s \n","성명","국어","영어","수학","합계","평균","석차");
			
			for(int i=0; i<stu.length; i++) {
				stu[i].printScore();
			}
			
	}

}
