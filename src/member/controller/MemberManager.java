package member.controller;

import java.util.Scanner;

import member.model.vo.Member;

public class MemberManager {
	
	private static Member[] m = new Member[10];
	private static int cnt = 0;
	private Scanner sc = new Scanner(System.in);
	
	public MemberManager() {}
	
	public void insertMember() {
		System.out.print("아이디를 입력하세요 : ");
		String userId = sc.next();
		System.out.print("패스워드를 입력하세요 : ");
		String userPwd = sc.next();
		System.out.print("이름을 입력하세요 : ");
		String userName = sc.next();
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.print("성별을 입력하세요 : ");
		char gender = sc.next().charAt(0);
		sc.nextLine();
		System.out.print("이메일을 입력하세요 : ");
		String email = sc.nextLine();
		
		m[cnt] = new Member(userId, userPwd, userName, age, gender, email);
		cnt++;
		
		System.out.println("입력이 완료되었습니다. 메인 메뉴로 돌아갑니다."); return;
	}
	
	public void searchId() {
		
	}
	
	public void searchName() {
		
	}
	
	public void searchEmail() {
		
	}
	
	public void updatePwd() {
		
	}
	
	public void updateName() {
		
	}
	
	public void updateEmail() {
		
	}
	
	public void deleteOne() {
		
	}
	
	public void deleteAll() {
		
	}
	
	public void printAllMember() {
		
	}
	
	public void printOne(Member m) {
		
	}
	
}
