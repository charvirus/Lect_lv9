package model;

public class InterfaceZombie extends InterfaceUnit{

	public InterfaceZombie(String name, int hp, int atk, int def, int pos) {
		super(name, hp, atk, def, pos);
	}
	@Override
	public void attack(InterfaceUnit target) {
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
