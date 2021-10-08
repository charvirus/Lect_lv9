package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

		}
	}
}
