package a100_java_getset_db;

import java.util.Scanner;

public class S21223getsetdb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true){
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
				if(w == 1) {
					S21223_GetSetDb_Inquiry.main(args);
					
				}else if(w == 2) {
					S21223_GetSetDb_Inquiry.main(args);
					
				}else if(w == 3) {
					S21223_GetSetDb_InquiryChoice.main(args);
				
				}else if(w == 4) {
					s21223_GetSet_DB.main(args);
					
				}else if(w == 5) {
					s21223_GetSet_DB_RankUpdate.main(args);
					
				}else if(w == 6) {
					S21223_GetSetDb_Delete_InquiryChoice.main(args);
				
				}else if(w == 0) {
					System.out.println("작업을 종료합니다");
					break;
				}else {
					System.out.println("다시입력");
					continue;
				}
			
			
		}
	}

}