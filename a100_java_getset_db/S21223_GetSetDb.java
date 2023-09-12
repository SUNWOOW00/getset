package a100_java_getset_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class S21223_GetSetDb {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql;
		int num_count = 0;
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "system";
		String pw = "1234";
		
		while(true) {
		System.out.println("=======================================");
		System.out.println("********* 수행평가 조회 및 등록(수정) ********");
		System.out.println("=======================================");
		System.out.println("1.등록된 전체 학생의 점수를 조회 합니다.(등록순)");
		System.out.println("2.등록된 전체 학생의 점수를 조회 합니다.(석차순)");
		System.out.println("3.등록된 학생의 선택하여 조회 합니다.");
		System.out.println("4.학생의 점수를 입력합니다.");
		System.out.println("5.등록된 점수의 석차를 재 설정합니다.");
		System.out.println("6.등록된 학생을 선택하여 삭제합니다.");
		System.out.println("0.작업을 종료합니다");
		System.out.println("---------------------------------------");
		
		System.out.println("작업 번호를 선택하세요?");
		int w =sc.nextInt();
		if (w == 0) {
            System.out.println("작업을 종료합니다");
            break;
        }
		switch(w) {
		case 1:
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
			System.out.printf(" NO     학번 국어 영어 수학 합계    평균  등록순\n");
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
			break;
		case 2:
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
	            sql = "select * from sungil_jumsu_tbl order by avg desc";
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
	
			break;
		case 3:
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
			System.out.print("학번을 입력하세요");
			int sum = sc.nextInt();
			System.out.println("등록된 자료 :"+num_count+"건");
			System.out.println("====출력(등수기준 1.총점 2.국어 3.영어 4.수학 순)=====");
			System.out.printf(" NO     학번 국어 영어 수학 합계    평균  석차\n");
			System.out.println("========================================");
			try {
				
	            sql = "select * from sungil_jumsu_tbl where hakbun ="+sum+"order by avg desc";
			
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
	
			break;
		case 4:
			Scanner input = new Scanner(System.in);
			
			System.out.print("몇명의 성적처리를 하나요(숫자 입력) :");
			int num = input.nextInt();
			
			People stu[] = new People[num];
			
			for(int i=0; i< stu.length; i++) {
				stu[i] = new People();
			
			
			
				System.out.print("학번을 입력하세요: ");
				stu[i].setHakbun(input.nextInt());
				System.out.print("국어 점수를 입력하세요: ");
				stu[i].setKor(input.nextInt());
				System.out.print("영어 점수를 입력하세요: ");
				stu[i].setEng(input.nextInt());
				System.out.print("수학 점수를 입력하세요: ");
				stu[i].setMath(input.nextInt());
			}
			
			for(int i =0; i< stu.length; i++) {
				int rank = 1;
				for(int j=0; j< stu.length; j++) {
					if (stu[i].getSum() < stu[j].getSum()) rank ++;
				}
				stu[i].setRank(rank);
			}
			
			System.out.println("====================출력=================");
			System.out.printf(" NO     학번 국어 영어 수학 합계    평균  석차\n");
			System.out.println("========================================");
			for(int i =0; i< stu.length; i++) {
				stu[i].cnt = i+1;
				stu[i].printScore();
			}
			
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				System.out.println("클래스 로딩 성공");
				conn = DriverManager.getConnection(url, id, pw);
				System.out.println("DB 접속");
				
				for(int i =0; i<stu.length; i++) {
					sql = "insert into sungil_jumsu_tbl Values (?, ?, ?, ?, ?, ?, ?)";
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1,stu[i].getHakbun());
					pstmt.setInt(2,stu[i].getKor());
					pstmt.setInt(3,stu[i].getEng());
					pstmt.setInt(4,stu[i].getMath());
					pstmt.setInt(5,stu[i].getSum());
					pstmt.setDouble(6,stu[i].getAvg());
					pstmt.setInt(7,stu[i].getRank());
					
					pstmt.executeUpdate();
				}
				System.out.println("====================================================");
				System.out.println("DB 입력작업 성공:"+stu.length+"건 입력");
				
				pstmt.close();
				conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case 5:
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
	           
	           } catch(Exception e) {
	               e.printStackTrace();
	           }
	           System.out.println("등록된 자료 : " +num_count+"건");
	           PeopleUpdate st[] = new PeopleUpdate[num_count];
	           try {
	               sql = "select * from sungil_jumsu_tbl";
	               pstmt = conn.prepareStatement(sql);
	               ResultSet rs = pstmt.executeQuery();
	               
	               int i_cnt = 0;
	               while(rs.next()) {
	                   st[i_cnt] = new PeopleUpdate();
	                   
	                   st[i_cnt].cnt = i_cnt+1;
	                   st[i_cnt].setHakbun(rs.getInt("hakbun"));
	                   st[i_cnt].setKor(rs.getInt("kor"));
	                   st[i_cnt].setEng(rs.getInt("eng"));
	                   st[i_cnt].setMath(rs.getInt("math"));
	                   st[i_cnt].setSum(rs.getInt("sum"));
	                   st[i_cnt].setAvg(rs.getInt("avg"));
	                   st[i_cnt].setRank(rs.getInt("rank"));
	                   i_cnt++;
	               }
	           }catch(Exception e) {
	               e.printStackTrace();
	           }
	           for (int i=0; i<st.length; i++) {
	               int rank=1;
	               for (int j=0; j<st.length; j++) {
	                   if(st[i].getSum() < st[j].getSum()) rank++;
	               }
	               st[i].setRank(rank);
	           }
	         
	           System.out.println("==================출력==================");
	           System.out.printf(" NO    학번 국어 영어 수학 합계   평균 석차  \n");
	           System.out.println("=======================================");
	           for (int i=0; i<st.length; i++) {
	               st[i].cnt = i+1;
	               st[i].printScore();
	           }
	           try {
	               for(int i = 0; i < st.length; i++) {
	                   sql = "update sungil_jumsu_tbl set sum = ?, avg = ?, rank = ? where hakbun = ?" ;
	                   pstmt = conn.prepareStatement(sql);
	                   
	                   pstmt.setInt(1, st[i].getSum());
	                   pstmt.setDouble(2, st[i].getAvg());
	                   pstmt.setInt(3, st[i].getRank());
	                   pstmt.setInt(4, st[i].getHakbun());
	                   
	                   pstmt.executeUpdate();
	               }
	               System.out.println("==========================================");
	               System.out.println("석차 재 설정 : " +st.length+"건 완료");
	               
	               pstmt.close();
	               conn.close();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
			break;
		case 6:	
		
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
		System.out.print("삭제할 학번을 입력하세요");
		int tum = sc.nextInt();
		System.out.println("등록된 자료 :"+num_count+"건");
		System.out.println("====출력(등수기준 1.총점 2.국어 3.영어 4.수학 순)=====");
		System.out.printf(" NO     학번 국어 영어 수학 합계    평균  석차\n");
		System.out.println("========================================");
		try {
			
            sql = "select * from sungil_jumsu_tbl where hakbun ="+tum+"order by avg desc";
		
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
		try {
			
            sql = "delete sungil_jumsu_tbl where hakbun ="+tum;
		
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            PeopleInquiryRank p = new PeopleInquiryRank();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("==========================================");
        System.out.println("삭제 자료 : " +num_count+"건");
			break;
		
		
			}
		

		}

	}
}
