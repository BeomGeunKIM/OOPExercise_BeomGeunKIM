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
		char gender = ' ';
		while(true) {
			System.out.print("성별을 입력하세요 : ");
			gender = sc.next().charAt(0);
			if(gender == 'm' || gender == 'M' || gender == '남' || gender == 'f' || gender == 'F' || gender == '여') {
				break;
			} else {
				System.out.println("잘못입력하셨습니다. 다시 입력하세요");
			}
		}
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
		
		for(int i = 0; i < cnt; i++) {
			if(srcId.equals(m[i].getUserId())) {
				printOne(m[i]); return;
			} else {
				System.out.println("검색한 회원 정보가 존재하지 않습니다."); return;
			}
		}
	}
	
	public void searchName() {
		System.out.print("검색할 이름을 입력하세요 : ");
		String srcName = sc.next();
		
		for(int i = 0; i < cnt; i++) {
			if(srcName.equals(m[i].getUserName())) {
				printOne(m[i]); return;
			} else {
				System.out.println("검색한 회원 정보가 존재하지 않습니다."); return;
			}
		}
	}
	
	public void searchEmail() {
		System.out.print("검색할 E-mail을 입력하세요 : ");
		String srcEmail = sc.next();
		
		for(int i = 0; i < cnt; i++) {
			if(srcEmail.equals(m[i].getEmail())) {
				printOne(m[i]); return;
			} else {
				System.out.println("검색한 회원 정보가 존재하지 않습니다."); return;
			}
		}
	}
	
	public void updatePwd() {
		System.out.print("검색할 아이디를 입력하세요 : ");
		String srcId = sc.next();
		
		for(int i = 0; i < cnt; i++) {
			if(srcId.equals(m[i].getUserId())) {
				System.out.print("변경하실 비밀번호를 입력하세요 : ");
				String changePwd = sc.next();
				m[i].setUserPwd(changePwd);
				System.out.println("비밀번호 수정이 완료되었습니다."); return;
			} else {
				System.out.println("수정할 회원이 존재하지 않습니다."); return;
			}
		}
	}
	
	public void updateName() {
		System.out.print("검색할 이름을 입력하세요 : ");
		String srcName = sc.next();
		
		for(int i = 0; i < cnt; i++) {
			if(srcName.equals(m[i].getUserName())) {
				System.out.print("변경하실 이름을 입력하세요 : ");
				String changeName = sc.next();
				m[i].setUserName(changeName);;
				System.out.println("이름 수정이 완료되었습니다."); return;
			} else {
				System.out.println("수정할 회원이 존재하지 않습니다."); return;
			}
		}
	}
	
	public void updateEmail() {
		System.out.print("검색할 E-mail을 입력하세요 : ");
		String srcEmail = sc.next();
		
		for(int i = 0; i < cnt; i++) {
			if(srcEmail.equals(m[i].getEmail())) {
				System.out.print("변경하실 E-mail을 입력하세요 : ");
				String changeEmail = sc.nextLine();
				m[i].setEmail(changeEmail);
				System.out.println("E-mail 수정이 완료되었습니다."); return;
			} else {
				System.out.println("수정할 회원이 존재하지 않습니다."); return;
			}
		}
	}
	
	public void deleteOne() {
		System.out.print("탈퇴할 회원의 ID를 입력하세요 : ");
		String srcId = sc.next();
		if(cnt == 0) {
			System.out.println("삭제할 회원 정보가 존재하지 않습니다."); return;
		}
		for(int i = 0; i < cnt; i++) {
			if(srcId.equals(m[i].getUserId())) {
				for(int j = i + 1; j < cnt; j++) {
					Member temp = m[j-1];
					m[j-1] = m[j];
					m[j] = temp;
				}
			} 
		}cnt--;
	}
	
	public void deleteAll() {
		for(int i = 0; i < cnt; i++) {
			m[i].setUserId(null);
			m[i].setUserPwd(null);
			m[i].setUserName(null);
			m[i].setAge(0);
			m[i].setGender('\u0000');
			m[i].setEmail(null);
		}
		cnt = 0;
		System.out.println("전체 회원정보 삭제가 완료되었습니다.");
	}
	
	public void printAllMember() {
		if(cnt != 0) {
			for(int i = 0; i < cnt; i++) {
				printOne(m[i]);
			}
		} else {
			System.out.println("출력할 회원정보가 없습니다.");
		}
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
