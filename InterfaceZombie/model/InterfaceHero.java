package model;

public class InterfaceHero extends InterfaceUnit {
	private int cnt = 3;

	public InterfaceHero(String name, int hp, int atk, int def, int pos) {
		super(name, hp, atk, def, pos);
	}

	public int getcnt() {
		return cnt;
	}

	public void drink() {
		if (cnt > 0) {
			this.setHp(this.getHp() + 100);
			cnt--;
			System.out.println("체력이 100 회복 됨");
			System.out.println("현재 체력 : " + this.getHp());
		} else {
			System.out.println("물약부족");
		}
	}
	@Override
	public void attack(InterfaceUnit target) {
		if (target instanceof InterfaceZombieKing) {
			if (((InterfaceZombieKing) target).getShield() > 0) {
				int dam = (this.getAtk() - target.getDef()) * (ran.nextInt(150) + 50) / 100;
				if (dam <= 0) {
					dam = 1;
				}
				System.out.println(getName() + "의 공격");
				System.out.println(dam + "의 피해 입힘");
				((InterfaceZombieKing) target).setShield(((InterfaceZombieKing) target).getShield() - dam);
				if (((InterfaceZombieKing) target).getShield() <= 0) {
					System.out.println("쉴드가 파괴 됐다.");
					((InterfaceZombieKing) target).setShield(0);
				}
				System.out.println(target.getName() + "의 남는 체력 : " + target.getHp() + "(쉴드 : "
						+ ((InterfaceZombieKing) target).getShield() + ")");
			} else {
				int dam = (this.getAtk() - target.getDef()) * (ran.nextInt(150) + 50) / 100;
				if (dam <= 0) {
					dam = 1;
				}
				System.out.println(this.getName() + "의 공격!");
				System.out.println(dam + "의 대미지!");
				target.setHp(target.getHp() - dam);
				System.out.println(target.getName() + "의 남은 체력 : " + target.getHp());
			}
		}else {
			int dam = (this.getAtk() - target.getDef()) * (ran.nextInt(150) + 50) / 100;
			if (dam <= 0) {
				dam = 1;
			}
			System.out.println(this.getName() + "의 공격!");
			System.out.println(dam + "의 대미지!");
			target.setHp(target.getHp() - dam);
			System.out.println(target.getName() + "의 남은 체력 : " + target.getHp());
		}
	}
}
