package a100_java_getset_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


	
public class S21223_GetSetDb_InquiryRank {

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
		System.out.println("====출력(등수기준 1.총점 2.국어 3.영어 4.수학 순=====");
		System.out.printf(" NO     학번 국어 영어 수학 합계    평균  석차\n");
		System.out.println("========================================");
		try {
            sql = "select * from sungil_jumsu_tbl"+
		" order by avg desc, kor desc";
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
