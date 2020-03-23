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
		System.out.print("���̵� �Է��ϼ��� : ");
		String userId = sc.next();
		System.out.print("�н����带 �Է��ϼ��� : ");
		String userPwd = sc.next();
		System.out.print("�̸��� �Է��ϼ��� : ");
		String userName = sc.next();
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt();
		System.out.print("������ �Է��ϼ��� : ");
		char gender = sc.next().charAt(0);
		sc.nextLine();
		System.out.print("�̸����� �Է��ϼ��� : ");
		String email = sc.nextLine();
		
		m[cnt] = new Member(userId, userPwd, userName, age, gender, email);
		cnt++;
		
		System.out.println("�Է��� �Ϸ�Ǿ����ϴ�. ���� �޴��� ���ư��ϴ�."); return;
	}
	
	public void searchId() {
		System.out.print("�˻��� ���̵� �Է��ϼ��� : ");
		String srcId = sc.next();
		
		for(int i = 0; i <= cnt; i++) {
			if(srcId == m[i].getUserId()) {
				printOne(m[i]);
			} else {
				System.out.println("�˻��� ȸ�� ������ �������� �ʽ��ϴ�."); return;
			}
		}
	}
	
	public void searchName() {
		System.out.print("�˻��� �̸��� �Է��ϼ��� : ");
		String srcName = sc.next();
		
		for(int i = 0; i <= cnt; i++) {
			if(srcName == m[i].getUserName()) {
				printOne(m[i]);
			} else {
				System.out.println("�˻��� ȸ�� ������ �������� �ʽ��ϴ�."); return;
			}
		}
	}
	
	public void searchEmail() {
		System.out.print("�˻��� E-mail�� �Է��ϼ��� : ");
		String srcEmail = sc.nextLine();
		
		for(int i = 0; i <= cnt; i++) {
			if(srcEmail == m[i].getEmail()) {
				printOne(m[i]);
			} else {
				System.out.println("�˻��� ȸ�� ������ �������� �ʽ��ϴ�."); return;
			}
		}
	}
	
	public void updatePwd() {
		System.out.print("�˻��� ���̵� �Է��ϼ��� : ");
		String srcId = sc.next();
		
		for(int i = 0; i <= cnt; i++) {
			if(srcId == m[i].getUserId()) {
				System.out.print("�����Ͻ� ��й�ȣ�� �Է��ϼ��� : ");
				String changePwd = sc.next();
				m[i].setUserPwd(changePwd);
				System.out.println("��й�ȣ ������ �Ϸ�Ǿ����ϴ�."); return;
			} else {
				System.out.println("������ ȸ���� �������� �ʽ��ϴ�."); return;
			}
		}
	}
	
	public void updateName() {
		System.out.print("�˻��� �̸��� �Է��ϼ��� : ");
		String srcName = sc.next();
		
		for(int i = 0; i <= cnt; i++) {
			if(srcName == m[i].getUserName()) {
				System.out.print("�����Ͻ� �̸��� �Է��ϼ��� : ");
				String changeName = sc.next();
				m[i].setUserName(changeName);;
				System.out.println("�̸� ������ �Ϸ�Ǿ����ϴ�."); return;
			} else {
				System.out.println("������ ȸ���� �������� �ʽ��ϴ�."); return;
			}
		}
	}
	
	public void updateEmail() {
		System.out.print("�˻��� E-mail�� �Է��ϼ��� : ");
		String srcEmail = sc.next();
		
		for(int i = 0; i <= cnt; i++) {
			if(srcEmail == m[i].getEmail()) {
				System.out.print("�����Ͻ� E-mail�� �Է��ϼ��� : ");
				String changeEmail = sc.nextLine();
				m[i].setEmail(changeEmail);
				System.out.println("E-mail ������ �Ϸ�Ǿ����ϴ�."); return;
			} else {
				System.out.println("������ ȸ���� �������� �ʽ��ϴ�."); return;
			}
		}
	}
	
	public void deleteOne() {
		System.out.print("Ż���� ȸ���� ID�� �Է��ϼ��� : ");
		String srcId = sc.next();
		for(int i = 0; i <= cnt; i++) {
			if(srcId == m[i].getUserId()) {
				for(int j = i + 1; j <= cnt; j++) {
					Member temp = m[j-1];
					m[j-1] = m[j];
					m[j] = temp;
				}
			} else {
				System.out.println("������ ȸ�� ������ �������� �ʽ��ϴ�."); return;
			}
		}cnt--;
	}
	
	public void deleteAll() {
		
	}
	
	public void printAllMember() {
		
	}
	
	public void printOne(Member m) {
		System.out.println("ȸ�� ID : " + m.getUserId());
		System.out.println("ȸ�� PWD : " + m.getUserPwd());
		System.out.println("ȸ�� �̸� : " + m.getUserName());
		System.out.println("ȸ�� ���� : " + m.getAge());
		System.out.println("ȸ�� ���� : " + m.getGender());
		System.out.println("ȸ�� E-mail : " + m.getEmail());
	}
	
}
