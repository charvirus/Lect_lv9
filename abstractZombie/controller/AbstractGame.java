package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.AbstractHero;
import model.AbstractUnit;
import model.AbstractZombie;
import model.AbstractZombieKing;

public class AbstractGame {
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);

	private static AbstractGame instance = new AbstractGame();

	public static AbstractGame getInstance() {
		return instance;
	};

	private AbstractHero p;
	private ArrayList<AbstractUnit> enemy = new ArrayList<>();

	private void init() {
		p = new AbstractHero("용사", 100, 5, 1, 1);
		enemy.add(new AbstractZombie("그냥좀비", 25, 5, 1, 3));
		enemy.add(new AbstractZombie("힘쎈좀비", 45, 10, 2, 6));
		enemy.add(new AbstractZombie("정예좀비", 65, 15, 3, 9));
		enemy.add(new AbstractZombieKing("좀비왕", 100, 20, 4, 12, 50));
	}

	private int chk() {
		for (int i = 0; i < enemy.size(); i++) {
			if (p.getPos() == enemy.get(i).getPos()) {
				System.out.println("좀비 출현");
				return i;
			}
		}
		return -1;
	}

	private int die(AbstractUnit a) {
		if (p.getHp() <= 0) {
			return 1;
		} else if (a.getHp() <= 0) {
			return 2;
		} else {
			return 0;
		}
	}

	private boolean fight(AbstractUnit enemy) {
		while (true) {
			p.print();
			System.out.println("==== VS ====");
			enemy.print();
			System.out.println("------------");
			System.out.println("[무엇을 할까?]");
			System.out.println("1. 공격 \t2. 물약(" + p.getcnt() + ")");
			int sel = scan.nextInt();
			if (sel == 1) {
				p.attack(enemy);
			} else if (sel == 2) {
				p.drink();
			}
			if (die(enemy) != 0) {
				break;
			}
			System.out.println();
			enemy.attack(p);
			if (die(enemy) != 0) {
				break;
			}
			System.out.println();
		}
		if (die(enemy) == 1) {
			System.out.println("사망");
			return false;
		} else {
			System.out.println("승리");
			return true;
		}
	}

	private void map(int a) {
		System.out.println("[ 현재 층 : " + p.getPos() + "]");
		System.out.println("[1] : 올라간다");
		if (a == 1) {
			System.out.println("[2] : 체력 회복");
			System.out.println("[3] : 무기 강화");
		}
	}

	public void run() {
		init();
		int act = 1;
		while (true) {
			if (p.getPos() >= 12) {
				System.out.println("생존했다.");
				break;
			}

			map(act);
			int sel = scan.nextInt();
			if (sel == 1) {
				p.setPos(p.getPos() + 1);
				int chk = chk();
				if (chk != -1) {
					boolean a = fight(enemy.get(chk));
					if (a == false) {
						break;
					}
				} else {
					System.out.println("아무일도 일어나지 않았다.");
				}
				act = 1;
			} else if (sel == 2&& act == 1 ) {
				int rnum = ran.nextInt(40) + 20;
				p.setHp(p.getHp() + rnum);
				System.out.println("체력 " + rnum + " 회복");
				act = 2;
			} else if (sel == 3&&act == 1) {
				int rnum = ran.nextInt(2) + 1;
				if (rnum == 1) {
					rnum = ran.nextInt(3) + 1;
					p.setAtk(p.getAtk() + rnum);
					System.out.println("공격력 " + rnum + " 증가");
				} else if (rnum == 2) {
					rnum = ran.nextInt(3) + 1;
					p.setDef(p.getDef() + rnum);
					System.out.println("방어력 " + rnum + " 증가");
				}
				act = 2;
			}

		}
	}
}