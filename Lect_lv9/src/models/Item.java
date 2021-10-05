package models;

public class Item {
	private String name;
	private int price;
	private String category;

	public Item(String na, int pr, String cate) {
		this.name = na;
		this.price = pr;
		this.category = cate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}

	public void setCate(String cate) {
		this.category = cate;
	}

	public String getCate() {
		return this.category;
	}
	
	public void print() {
		System.out.println("[" + this.name + "]" + "[" + this.price + "]" + "[" + this.category + "]");
	}
}
