package model;

public class RPG_Unit {
	String name;
	int level;
	int hp;
	int maxHp;
	int atk;
	int def;
	int exp;
	boolean party;
	RPG_Item weapon;
	RPG_Item armor;
	RPG_Item ring;

	public RPG_Unit(String n, int l, int h, int a, int d, int e) {
		this.name = n;
		this.level = l;
		this.maxHp = h;
		this.atk = a;
		this.def = d;
		this.exp = e;
		this.hp = this.maxHp;
		this.party = false;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}

	public RPG_Unit(String n, int l, int h, int a, int d, int e, boolean p) {
		this.name = n;
		this.level = l;
		this.maxHp = h;
		this.atk = a;
		this.def = d;
		this.exp = e;
		this.hp = this.maxHp;
		this.party = p;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}

	public void setItem(RPG_Item w, RPG_Item a, RPG_Item r) {
		this.weapon = w;
		this.armor = a;
		this.ring = r;
	}

	public void printStatus() {
		System.out.print("[ 이름 : " + this.name + " ]");
		System.out.print("[ 레벨 : " + this.level + " ]");
		if (this.ring != null) {
			System.out.print(" [ 체력 : " + hp + "+" + this.ring.getPower() + " ] ");
		} else {
			System.out.print(" [ 체력 : " + hp);
		}
		if(this.ring != null) {
			System.out.println(" / "+this.maxHp+" + "+this.ring.getPower() +" ] ");
		}else {
			System.out.println(" / "+this.maxHp+" ] ");
		}
		if(this.weapon != null) {
			System.out.print(" [ 공격력 : "+this.atk +" + "+this.weapon.getPower() + " ] ");
		}else {
			System.out.print(" [ 공격력 : "+this.atk );
			
		}
		
	}
}
