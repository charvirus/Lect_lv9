package controller;

import java.util.Vector;

import models.Cart;
import models.Item;
import models.User;

public class ItemManager {
	Vector<String> category = new Vector<>();
	Vector<Item> itemList = new Vector<>();
	Vector<Cart> jangList = new Vector<>();

	public ItemManager() {
		init();
	}

	void init() {
		category.add("����");
		category.add("����");
		category.add("����");
		category.add("�����");

		Item temp = new Item("�����", 1000, category.get(0), 5);
		itemList.add(temp);
		temp = new Item("����", 2000, category.get(1), 5);
		itemList.add(temp);
		temp = new Item("ĭ��", 3600, category.get(0), 5);
		itemList.add(temp);
		temp = new Item("�Ұ��", 6500, category.get(2), 5);
		itemList.add(temp);
		temp = new Item("�ݶ�", 500, category.get(3), 5);
		itemList.add(temp);
		temp = new Item("����", 1800, category.get(1), 5);
		itemList.add(temp);
	}

	public void printJang() {
		for (int i = 0; i < jangList.size(); i++) {
			jangList.get(i).print();
		}
	}

	public void printJang(User u) {
		for (int i = 0; i < jangList.size(); i++) {
			if (u.getId().equals(jangList.get(i).getUserId())) {
				jangList.get(i).print();
			}
		}
	}

	public void printCategory() {
		for (int i = 0; i < category.size(); i++) {
			System.out.println("[" + i + "] " + category.get(i));
		}
	}

	public void printItemList() {
		for (int i = 0; i < itemList.size(); i++) {
			System.out.print("[" + i + "]");
			itemList.get(i).print();
		}
	}

	public void printItemList(int caID) {
		int n = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (category.get(caID).equals(itemList.get(i).getCate())) {
				System.out.print("[" + n + "]");
				itemList.get(i).print();
				n++;
			}
		}
	}

	public int itemListTotal(User u) {
		int sum = 0;
		for (int i = 0; i < jangList.size(); i++) {
			if (u.getId().equals(jangList.get(i).getUserId())) {
				sum += jangList.get(i).getPrice();
			}
		}
		return sum;
	}

	public void addItem() {
		System.out.println("[�������߰�] ������ �̸��� �Է��ϼ���. ");
		String name = UserManager.scan.next();
		System.out.println("[�������߰�] ������ �Է��ϼ���. ");
		int price = UserManager.scan.nextInt();
		printCategory();
		System.out.println("[�������߰�] ī�װ��� �Է��ϼ���.");
		int sel = UserManager.scan.nextInt();
		System.out.println("[�������߰�] ������ �Է��ϼ���.");
		int cnt = UserManager.scan.nextInt();
		Item temp = new Item(name, price, category.get(sel), cnt);
		itemList.add(temp);
	}

	public void delItem() {
		printItemList();
		System.out.println("[������ ����] ������ ������ ��ȣ�� �Է��ϼ���. ");
		int sel = UserManager.scan.nextInt();
		if (sel >= 0 && sel < itemList.size()) {
			itemList.remove(sel);
		} else {
			System.out.println("��ȿ�� ��ȣ�� �Է��ϼ���.");
		}
	}

	public void addCategory() {
		System.out.println("[ī�װ��߰�] ī�װ� �̸��� �Է��ϼ���. ");
		String name = UserManager.scan.next();
		category.add(name);
	}

	public void delCategory() {
		printCategory();
		System.out.println("[������ ����] ������ ī�װ� ��ȣ�� �Է��ϼ���. ");
		int sel = UserManager.scan.nextInt();
		if (sel >= 0 && sel < category.size()) {
			category.remove(sel);
		} else {
			System.out.println("��ȿ�� ��ȣ�� �Է��ϼ���.");
		}
	}

	public void addCart(String usId, int caID, int itemID) {
		int n = 0;
		Cart temp = new Cart();
		temp.setUserId(usId);
		for (int i = 0; i < itemList.size(); i++) {
			if (category.get(caID).equals(itemList.get(i).getCate())) {
				if (itemID == n) {
					temp.setItemName(itemList.get(i).getName());
					temp.setPrice(itemList.get(i).getPrice());
				}
				n++;
			}
		}
		jangList.add(temp);
	}

	public void delJangItem(int inp) {
		jangList.remove(inp);
	}

	public void delUserJangItem(User user) {
		for (int i = 0; i < jangList.size(); i++) {
			if (user.getId().equals(jangList.get(i).getUserId())) {
				jangList.remove(i);
			}
		}
	}

	public int getItemCnt(int caID, int itID) {
		int cnt = 0;
		int n = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (category.get(caID).equals(itemList.get(i).getCate())) {
				if (itID == n) {
					cnt = itemList.get(i).getCnt();
				}
				n++;
			}
		}
		return cnt;
	}
}
