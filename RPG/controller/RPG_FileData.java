package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.RPG_Item;
import model.RPG_Player;
import model.RPG_Unit;

public class RPG_FileData {
	public void save() throws IOException {
		FileWriter fout = null;
		String path = "gameData.txt";

		fout = new FileWriter(path);
		ArrayList<RPG_Unit> temp = RPG_Player.getGuildList();
		String gameData = "";
		gameData += RPG_Player.getPlayerMoney();
		gameData += "\r\n";
		gameData += temp.size();
		gameData += "\r\n";

		for (int i = 0; i < temp.size(); i++) {
			gameData += temp.get(i).getName();
			gameData += "/";
			gameData += temp.get(i).getLevel();
			gameData += "/";
			gameData += temp.get(i).getMaxHp();
			gameData += "/";
			gameData += temp.get(i).getAtk();
			gameData += "/";
			gameData += temp.get(i).getDef();
			gameData += "/";
			gameData += temp.get(i).getExp();
			gameData += "/";
			gameData += temp.get(i).isParty();
			gameData += "\r\n";
			if (temp.get(i).getWeapon() == null) {
				gameData += temp.get(i).getWeapon();
			} else {
				RPG_Item item = temp.get(i).getWeapon();
				String weaponData = "";
				weaponData += item.getKind();
				weaponData += ",";
				weaponData += item.getName();
				weaponData += ",";
				weaponData += item.getPower();
				weaponData += ",";
				weaponData += item.getPrice();
				gameData += weaponData;
			}
			gameData += "/";
			if (temp.get(i).getArmor() == null) {
				gameData += temp.get(i).getArmor();
			} else {
				RPG_Item item = temp.get(i).getArmor();
				String weaponData = "";
				weaponData += item.getKind();
				weaponData += ",";
				weaponData += item.getName();
				weaponData += ",";
				weaponData += item.getPower();
				weaponData += ",";
				weaponData += item.getPrice();
				gameData += weaponData;
			}
			gameData += "/";
			if (temp.get(i).getArmor() == null) {
				gameData += temp.get(i).getRing();
			} else {
				RPG_Item item = temp.get(i).getRing();
				String weaponData = "";
				weaponData += item.getKind();
				weaponData += ",";
				weaponData += item.getName();
				weaponData += ",";
				weaponData += item.getPower();
				weaponData += ",";
				weaponData += item.getPrice();
				gameData += weaponData;
			}
			gameData += "\r\n";
		}
		gameData += RPG_Player.getItemSize();
		gameData += "\r\n";
		for(int i =0;i<RPG_Player.getItemSize();i++) {
			RPG_Item item = RPG_Player.getItemList().get(i);
			
			gameData += item.getKind();
			gameData += "/";
			gameData += item.getName();
			gameData += "/";
			gameData += item.getPower();
			gameData += "/";
			gameData += item.getPrice();
			gameData += "\r\n";
		}
		System.out.println(gameData);
		fout.write(gameData,0,gameData.length());
		fout.close();
	}
	
	public void loadData() throws IOException{
		File file = null;
		FileReader reader = null;
		BufferedReader br = null;
		String path = "gameData.txt";
		file = new File(path);
		if(file.exists()) {
			reader = new FileReader(path);
			br = new BufferedReader(reader);
			String money = br.readLine();
			RPG_Player.setPlayerMoney(Integer.parseInt(money));
			System.out.println(money);
			String guildSize = br.readLine();
			int size = Integer.parseInt(guildSize);
			RPG_Player.getGuildList().clear();
			System.out.println(size);
			for(int i = 0;i<size;i++) {
				String unitData = br.readLine();
				String[] unitArr = unitData.split("/");
				String name = unitArr[0];
				int level = Integer.parseInt(unitArr[1]);
				
			}
		}
	}
}
