package a100_java_getset_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class PeopleInquiryRank {
    private int hakbun;        
    private int kor;            
    private int eng;            
    private int math;
    private int sum;            

    private double avg;    
    private int rank;            
    public int cnt;

    public int getHakbun() {
        return hakbun;
    }
    public void setHakbun(int hakbun) {
        this.hakbun = hakbun;
    }
    public int getKor() {
        return kor;
    }
    public void setKor(int kor) {
        this.kor = kor;
    }
    public int getEng() {
        return eng;
    }
    public void setEng(int eng) {
        this.eng = eng;
    }
    public int getMath() {
        return math;
    }
    public void setMath(int math) {
        this.math = math;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
    public void setAvg(double avg) {
        this.avg = avg;
    }
    public int getSum() {
        return getKor() + getEng() + getMath();
    }
    public double getAvg() {
        return  (double)getSum() / 3;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }

    void printScore() {
        System.out.printf(" %3d %3s %3d %3d %3d %3d %3.2f %3d \n",
                cnt, hakbun, kor, eng, math, getSum(), getAvg(), rank );
    }
}
	
public class S21223_GetSetDb_Inquiry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql;
		int num_count = 0;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "system";
		String pw = "1234";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("클래스 로딩 성공");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB 접속");
			
			sql = "select count(*) from sungil_jumsu_tbl";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			num_count = rs.getInt(1);
	
		}catch(SQLException e) {
			System.out.println("SQL을 확인합니다");
			e.printStackTrace();
			
		}catch(Exception e) {
            e.printStackTrace();
        }
		System.out.println("등록된 자료 :"+num_count+"건");
		System.out.println("====================출력=================");
		System.out.printf(" NO     학번 국어 영어 수학 합계    평균  석차\n");
		System.out.println("========================================");
		try {
            sql = "select * from sungil_jumsu_tbl";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            PeopleInquiryRank p = new PeopleInquiryRank();
            
            num_count = 0;
            while(rs.next()) {
            	  p.cnt = num_count+1;
                  p.setHakbun(rs.getInt("hakbun"));
                  p.setKor(rs.getInt("kor"));
                  p.setEng(rs.getInt("eng"));
                 p.setMath(rs.getInt("math"));
                 p.setSum(rs.getInt("sum"));
                  p.setAvg(rs.getInt("avg"));
                 p .setRank(rs.getInt("rank"));
                 p.printScore();
                  num_count++;
            	
            }
		}catch(Exception e) {
            e.printStackTrace();
		}
		System.out.println("==========================================");
        System.out.println("출력된 자료 : " +num_count+"건");
	}
}
