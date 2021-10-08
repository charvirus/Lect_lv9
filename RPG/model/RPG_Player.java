package model;

import java.util.ArrayList;

import controller.RPG_Guild;
import controller.RPG_Inventory;

public class RPG_Player {
	private static int money;
	private static RPG_Guild guild = new RPG_Guild();
	private static RPG_Inventory inven = new RPG_Inventory();

	RPG_Player() {
		money = 100000;
		guild.setGuild();
	}

	public void guildMenu() {
		guild.guildMenu();
	}

	public void inventoryMenu() {
		inven.inventoryMenu();
	}

	public static ArrayList<RPG_Unit> getGuildList() {
		return guild.getGuildList();
	}

	public static ArrayList<RPG_Item> getItemList() {
		return inven.getitemList();
	}

	public static RPG_Unit getGuildUnit(int num) {
		return guild.getGuildUnit(num);
	}

	public static void setPlayerMoney(int paraMoney) {
		money = paraMoney;
	}

	public static int getPlayerMoney() {
		return money;
	}
	
	public static RPG_Guild getGuild() {
		return guild;
	}
}
