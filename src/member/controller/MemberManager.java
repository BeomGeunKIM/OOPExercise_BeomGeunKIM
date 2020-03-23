package member.controller;

import java.nio.file.attribute.UserPrincipalLookupService;
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
		System.out.print("검색할 아이디를 입력하세요 : ");
		String srcId = sc.next();
		
		for(int i = 0; i <= cnt; i++) {
			if(srcId == m[i].getUserId()) {
				printOne(m[i]);
			} else {
				System.out.println("검색한 회원 정보가 존재하지 않습니다."); return;
			}
		}
	}
	
	public void searchName() {
		System.out.print("검색할 아이디를 입력하세요 : ");
		String srcName = sc.next();
		
		for(int i = 0; i <= cnt; i++) {
			if(srcName == m[i].getUserName()) {
				printOne(m[i]);
			} else {
				System.out.println("검색한 회원 정보가 존재하지 않습니다."); return;
			}
		}
	}
	
	public void searchEmail() {
		System.out.print("검색할 아이디를 입력하세요 : ");
		String srcEmail = sc.nextLine();
		
		for(int i = 0; i <= cnt; i++) {
			if(srcEmail == m[i].getEmail()) {
				printOne(m[i]);
			} else {
				System.out.println("검색한 회원 정보가 존재하지 않습니다."); return;
			}
		}
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
		System.out.println("회원 ID : " + m.getUserId());
		System.out.println("회원 PWD : " + m.getUserPwd());
		System.out.println("회원 이름 : " + m.getUserName());
		System.out.println("회원 나이 : " + m.getAge());
		System.out.println("회원 성별 : " + m.getGender());
		System.out.println("회원 E-mail : " + m.getEmail());
	}
	
}
