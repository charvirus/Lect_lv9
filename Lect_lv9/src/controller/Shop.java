package controller;

public class Shop {
	ItemManager im = new ItemManager();
	UserManager um = new UserManager();

	public void mainMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.����]\n[2.Ż��]\n[3.�α���]\n[4.�α׾ƿ�]\n[100.������] [0.����] ");
			int sel = UserManager.scan.nextInt();
			if (sel == 1) {
				um.join();
			} else if (sel == 2) {
				um.withdraw();
			} else if (sel == 3) {
				if (um.login()) {
					loginMenu();
				}
			} else if (sel == 4) {
				um.logout();
			} else if (sel == 100) {
				managerMenu();
			} else if (sel == 0) {
				break;
			}
		}

	}

	private void loginMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1. ����]\n[2. ��ٱ��ϸ��]\n[0. �ڷΰ���]");
			int sel = UserManager.scan.nextInt();
			if (sel == 1) {
				shopMenu();
			} else if (sel == 2) {
				cartMenu();
			} else if (sel == 0) {
				break;
			}
		}
	}

	private void managerMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1. ������ ����]\n[2. ī�װ� ����]\n[3. ��ٱ��� ����]\n[4. ���� ����]\n[0.�ڷΰ���] ");
			int sel = UserManager.scan.nextInt();
			if (sel == 1) {
				itemMenu();
			} else if (sel == 2) {
				categoryMenu();
			} else if (sel == 3) {
				im.printJang();
			} else if (sel == 4) {
				userMenu();
			} else if (sel == 0) {
				run = false;
			}
		}
	}

	private void cartMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1. �� ��ٱ���]\n[2. ����]\n[3. ����]\n[0. �ڷΰ���]");
			int sel = UserManager.scan.nextInt();
			if (sel == 1) {
				im.printJang(um.getUserList().get(um.userLog));
			} else if (sel == 2) {
				im.printJang(um.getUserList().get(um.userLog));
				System.out.println("������ �������� �������ּ���.");
				int inp = UserManager.scan.nextInt();
				im.delJangItem(um.getUserList().get(um.userLog).getId(), inp);
			} else if (sel == 3) {
				int sum = 0;
				
			} else if (sel == 0) {
				run = false;
			}
		}
	}

	private void shopMenu() {
		boolean run = true;
		while (run) {
			im.printCategory();
			System.out.println("[ī�װ�] ��ȣ�� �Է��ϼ���. [����. -1]");
			int caID = UserManager.scan.nextInt();
			if (caID == -1) {
				break;
			}
			im.printItemList(caID);
			System.out.println("[������] ��ȣ�� �Է��ϼ���");
			int itID = UserManager.scan.nextInt();
			im.addCart(um.getUserList().get(um.userLog).getId(), caID, itID);
		}
	}

	private void itemMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.��ü ������]\n[2.������ �߰�]\n[3.������ ����]\n[0.�ڷΰ���]");
			int sel = UserManager.scan.nextInt();
			if (sel == 1) {
				im.printItemList();
			} else if (sel == 2) {
				im.addItem();
			} else if (sel == 3) {
				im.delItem();
			} else if (sel == 0) {
				run = false;
			}
		}
	}

	void categoryMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.��üī�װ�]\n[2.ī�װ��߰�]\n[3.ī�װ�����]\n[0.�ڷΰ���]");
			int sel = UserManager.scan.nextInt();
			if (sel == 1) {
				im.printCategory();
			} else if (sel == 2) {
				im.printCategory();
				im.addCategory();
			} else if (sel == 3) {
				im.delCategory();
			} else if (sel == 0) {
				run = false;
			}
		}
	}

	void userMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.��ü����]\n[2.�����߰�]\n[3.��������]\n[0.�ڷΰ���]");
			int sel = UserManager.scan.nextInt();
			if (sel == 1) {
				um.printUser();
			} else if (sel == 2) {
				um.join();
			} else if (sel == 3) {
				um.withdraw();
			} else if (sel == 0) {
				run = false;
			}
		}
	}
}
