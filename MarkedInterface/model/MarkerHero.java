package model;

public class MarkerHero extends MarkerUnit implements AttackMarkerInterface {
	private int cnt = 3;

	public MarkerHero(String name, int hp, int atk, int def, int pos) {
		super(name, hp, atk, def, pos);
		// TODO Auto-generated constructor stub
	}

	public int getcnt() {
		return cnt;
	}

	public void drink() {
		if (cnt > 0) {
			this.setHp(getHp() + 100);
			cnt--;
			System.out.println("체력이 100 회복 됨");
			System.out.println("현재 체력 : " + this.getHp());
		} else {
			System.out.println("물약 부족");
		}
	}
	
	@Override
	public void attack(AttackMarkerInterface attackUnit) {
		MarkerUnit unit = (MarkerUnit) attackUnit;
		if (unit instanceof MarkerZombieKing) {
			if (((MarkerZombieKing) unit).getShield() > 0) {
				int dam = (this.getAtk() - unit.getDef()) * (ran.nextInt(150) + 50) / 100;
				if (dam <= 0) {
					dam = 1;
				}
				System.out.println(getName() + "의 공격");
				System.out.println(dam + "의 피해 입힘");
				((MarkerZombieKing) unit).setShield(((MarkerZombieKing) unit).getShield() - dam);
				if (((MarkerZombieKing) unit).getShield() <= 0) {
					System.out.println("쉴드가 파괴 됐다.");
					((MarkerZombieKing) unit).setShield(0);
				}
				System.out.println(unit.getName() + "의 남는 체력 : " + unit.getHp() + "(쉴드 : "
						+ ((MarkerZombieKing) unit).getShield() + ")");
			} else {
				super.attack(attackUnit);
			}
		}else {
			super.attack(attackUnit);
		}
	}
}
