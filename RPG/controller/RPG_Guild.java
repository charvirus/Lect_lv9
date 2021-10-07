package controller;

import java.util.ArrayList;

import model.RPG_Player;
import model.RPG_Unit;

public class RPG_Guild {
	final int PARTY_SIZE = 4;
	ArrayList<RPG_Unit> guildList = new ArrayList<>();
	RPG_Unit[] partyList;

	public void setGuild() {
		RPG_Unit temp = new RPG_Unit("호랑이", 1, 100, 10, 5, 0);
		guildList.add(temp);
		temp = new RPG_Unit("강아지", 1, 80, 7, 3, 0);
		guildList.add(temp);
		temp = new RPG_Unit("사슴", 1, 50, 3, 1, 0);
		guildList.add(temp);
		temp = new RPG_Unit("두더지", 1, 70, 5, 2, 0);
		guildList.add(temp);
		temp = new RPG_Unit("돼지", 1, 200, 4, 8, 0);
		guildList.add(temp);
		temp = new RPG_Unit("사자", 1, 120, 11, 7, 0);
		guildList.add(temp);

		for (int i = 0; i < PARTY_SIZE; i++) {
			guildList.get(i).setParty(true);
		}
		partyList = new RPG_Unit[PARTY_SIZE];
		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).isParty()) {
				partyList[n] = guildList.get(i);
				n++;
			}
		}
	}
	
	public RPG_Unit getGuildUnit(int num) {
		return guildList.get(num);
	}
	
	public void printAllUnitStatus() {
		System.out.println("==================================");
		System.out.println("[골드 : " + (RPG_Player.getPlayerMoney()) + "]");
		System.out.println("============= [길드원] =============");
		for(int i = 0;i<guildList.size();i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + guildList.get(i).getName() + "]");
			System.out.print(" [레벨 : " + guildList.get(i).getLevel() + "]");
			System.out.print(" [체력 : " + guildList.get(i).getHp());
			System.out.println(" / " + guildList.get(i).getMaxHp() + "]");
			System.out.print("[공격력 : " + guildList.get(i).getAtk() + "]");
			System.out.print(" [방어력 : " + guildList.get(i).getDef() + "]");
			System.out.println(" [파티중 : " + guildList.get(i).isParty() + "]");
			System.out.println();
		}
		System.out.println("==================================");
	}
	
	public void printUnitStatus(int num) {
		guildList.get(num).printStatus();
	}
	
	public void printUnitItem(int num) {
		guildList.get(num).printEquipedItem();
	}
	
}
