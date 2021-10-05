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

		Item temp = new Item("�����", 1000, category.get(0));
		itemList.add(temp);
		temp = new Item("����", 2000, category.get(1));
		itemList.add(temp);
		temp = new Item("ĭ��", 3600, category.get(0));
		itemList.add(temp);
		temp = new Item("�Ұ��", 6500, category.get(2));
		itemList.add(temp);
		temp = new Item("�ݶ�", 500, category.get(3));
		itemList.add(temp);
		temp = new Item("����", 1800, category.get(1));
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

	public void addItem() {
		System.out.println("[�������߰�] ������ �̸��� �Է��ϼ���. ");
		String name = UserManager.scan.next();
		System.out.println("[�������߰�] ������ �Է��ϼ���. ");
		int price = UserManager.scan.nextInt();
		printCategory();
		System.out.println("[�������߰�] ī�װ��� �Է��ϼ���.");
		int sel = UserManager.scan.nextInt();
		Item temp = new Item(name, price, category.get(sel));
		itemList.add(temp);
	}

	public void addCategory() {
		System.out.println("[ī�װ��߰�] ī�װ� �̸��� �Է��ϼ���. ");
		String name = UserManager.scan.next();
		category.add(name);
	}

	public void addCart(String usId, int caID, int itemID) {
		int n = 0;
		Cart temp = new Cart();
		temp.setUserId(usId);
		for (int i = 0; i < itemList.size(); i++) {
			if (category.get(caID).equals(itemList.get(i).getCate())) {
				if (itemID == n) {
					temp.setItemName(itemList.get(i).getName());
				}
				n++;
			}
		}
		jangList.add(temp);
	}

	public void delJangItem(String usId, int inp) {
		jangList.remove(inp);
	}
}
