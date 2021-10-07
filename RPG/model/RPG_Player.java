package model;

import controller.RPG_Guild;
import controller.RPG_Inventory;

public class RPG_Player {
	private static int money;
	private static RPG_Guild guild = new RPG_Guild();
	private static RPG_Inventory inven = new RPG_Inventory();
	RPG_Player(){
		money = 100000;
		guild.setGuild();
	}
	
	
	public void setPlayerMoney(int money) {
		this.money = money;
	}
	
	public static int getPlayerMoney() {
		return money;
	}
}
