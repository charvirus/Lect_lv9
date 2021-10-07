package controller;

import java.util.ArrayList;

import model.RPG_Item;

public class RPG_Shop {
	ArrayList<RPG_Item> itemList = new ArrayList<>();

	public RPG_Shop() {
		RPG_Item temp = new RPG_Item();
		temp.setItem(RPG_Item.getWeapon(), "나무검", 3, 1000);
		itemList.add(temp);

		temp = new RPG_Item();
		temp.setItem(RPG_Item.getWeapon(), "철검", 5, 2000);
		itemList.add(temp);

		temp = new RPG_Item();
		temp.setItem(RPG_Item.getWeapon(), "레이피어", 7, 2500);
		itemList.add(temp);

		temp = new RPG_Item();
		temp.setItem(RPG_Item.getArmor(), "티셔츠", 1, 300);
		itemList.add(temp);

		temp = new RPG_Item();
		temp.setItem(RPG_Item.getArmor(), "가죽갑옷", 4, 800);
		itemList.add(temp);

		temp = new RPG_Item();
		temp.setItem(RPG_Item.getArmor(), "가죽갑옷", 7, 1300);
		itemList.add(temp);

		temp = new RPG_Item();
		temp.setItem(RPG_Item.getRing(), "은반지", 7, 3000);
		itemList.add(temp);

		temp = new RPG_Item();
		temp.setItem(RPG_Item.getRing(), "금반지", 17, 6000);
		itemList.add(temp);

		temp = new RPG_Item();
		temp.setItem(RPG_Item.getRing(), "다이아반지", 35, 20000);
		itemList.add(temp);
	}

	public void shopMng() {
		while (true) {
			System.out.println(" ============= [ 상점 ] =============");
			System.out.println(" [1. 무기] [2. 갑옷] [3. 반지] [0. 뒤로가기]");
			int selKind = MainGame.scan.nextInt();
			if (selKind == 1) {
				System.out.println("========== [ 무기 ] ==========");
			} else if (selKind == 2) {
				System.out.println("========== [ 방어구 ] ==========");
			} else if (selKind == 3) {
				System.out.println("========== [ 반지 ] ==========");
			}
			printItems(selKind);
			if (selKind == 0) {
				break;
			}

		}
	}
	
	public void printItems(int kind) {
		int count = 0;
		for(int i = 0;i<itemList.size();i++) {
			if(itemList.get(i).getKind() != kind) {
				continue;
			}
			System.out.print(" [ "+(count+1)+"번 ] ");
			System.out.print("[ 이름 : "+itemList.get(i).getName() + " ] ");
			System.out.print("[ 능력 : "+itemList.get(i).getPower() + " ] ");
			System.out.print("[ 가격 : "+itemList.get(i).getPrice() + " ] ");
			System.out.println();
			count++;
		}
	}
}
