package controller;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import models.User;

public class UserManager {
	private Random ran = new Random();
	public static Scanner scan = new Scanner(System.in);
	private Vector<User> userList = new Vector<>();
	public int userLog = -1;

	public UserManager() {
		init();
	}

	private void init() {
		String[] a = { "��", "��", "��", "��", "��", "��" };
		String[] b = { "ö", "��", "��", "��", "��", "��" };
		String[] c = { "��", "��", "��", "��", "��", "��" };
		for (int i = 0; i < 10; i++) {
			int r = ran.nextInt(a.length);
			String name = a[r];
			r = ran.nextInt(b.length);
			name += b[r];
			r = ran.nextInt(c.length);
			name += c[r];
			User temp = new User(name, ran.nextInt(10000));
			userList.add(temp);
		}
	}

	public void join() {
		System.out.println("[����] id �� �Է��ϼ���.");
		String id = scan.next();
		User temp = new User(id, 1000);
		userList.add(temp);
		System.out.println("[�޼���] " + temp.getId() + "�� ������ ���ϵ帳�ϴ�.");
	}

	public void withdraw() {
		System.out.println("[Ż��] id �� �Է��ϼ���.");
		String id = scan.next();
		int idx = -1;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId().equals(id)) {
				idx = i;
			}
		}
		if (idx == -1) {
			System.out.println("�������� ���� ���̵��Դϴ�.");
		} else {
			userList.remove(idx);
			System.out.println("Ż�� �Ǿ����ϴ�.");
		}
	}

	public boolean login() {
		userLog = -1;
		System.out.println("[�α���] id �� �Է��ϼ���.");
		String id = scan.next();
		for (int i = 0; i < userList.size(); i++) {
			if (id.equals(userList.get(i).getId())) {
				userLog = i;
				break;
			}
		}
		if (userLog == -1) {
			System.out.println("[�޼���] �������� �ʴ� ���̵� �Դϴ�.");
		} else {
			System.out.println("[�޼���] " + userList.get(userLog).getId() + "�� �α���");
			return true;
		}
		return false;
	}

	public void logout() {
		if (userLog != -1) {
			System.out.println("[�޼���] " + userList.get(userLog).getId() + "�� �α׾ƿ�");
		}
		userLog = -1;
	}

	public void printUser() {
		for (int i = 0; i < userList.size(); i++) {
			System.out.print("[" + i + "]");
			userList.get(i).print();
		}
	}
	
	public Vector<User> getUserList(){
		return userList;
	}
}
