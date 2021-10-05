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
		category.add("과자");
		category.add("생선");
		category.add("육류");
		category.add("음료수");

		Item temp = new Item("새우깡", 1000, category.get(0));
		itemList.add(temp);
		temp = new Item("고등어", 2000, category.get(1));
		itemList.add(temp);
		temp = new Item("칸쵸", 3600, category.get(0));
		itemList.add(temp);
		temp = new Item("소고기", 6500, category.get(2));
		itemList.add(temp);
		temp = new Item("콜라", 500, category.get(3));
		itemList.add(temp);
		temp = new Item("새우", 1800, category.get(1));
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

	public int itemListCnt(User u) {
		int sum = 0;
		for (int i = 0; i < jangList.size(); i++) {
			if (u.getId().equals(jangList.get(i).getUserId())) {
				
			}
		}
		return sum;
	}

	public void addItem() {
		System.out.println("[아이템추가] 아이템 이름을 입력하세요. ");
		String name = UserManager.scan.next();
		System.out.println("[아이템추가] 가격을 입력하세요. ");
		int price = UserManager.scan.nextInt();
		printCategory();
		System.out.println("[아이템추가] 카테고리를 입력하세요.");
		int sel = UserManager.scan.nextInt();
		Item temp = new Item(name, price, category.get(sel));
		itemList.add(temp);
	}

	public void delItem() {
		printItemList();
		System.out.println("[아이템 삭제] 삭제할 아이템 번호를 입력하세요. ");
		int sel = UserManager.scan.nextInt();
		if (sel >= 0 && sel < itemList.size()) {
			itemList.remove(sel);
		} else {
			System.out.println("유효한 번호를 입력하세요.");
		}
	}

	public void addCategory() {
		System.out.println("[카테고리추가] 카테고리 이름을 입력하세요. ");
		String name = UserManager.scan.next();
		category.add(name);
	}

	public void delCategory() {
		printCategory();
		System.out.println("[아이템 삭제] 삭제할 카테고리 번호를 입력하세요. ");
		int sel = UserManager.scan.nextInt();
		if (sel >= 0 && sel < category.size()) {
			category.remove(sel);
		} else {
			System.out.println("유효한 번호를 입력하세요.");
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

	public void delJangItem(String usId, int inp) {
		jangList.remove(inp);
	}
}
