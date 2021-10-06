package models;

public class Cart {
	private String userId;
	private String itemName;
	private int price;
	
	public void setUserId(String uId) {
		this.userId = uId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setItemName(String name) {
		this.itemName = name;
	}

	public String getItemName() {
		return this.itemName;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return this.price;
	}
	
	public void print() {
		System.out.println("아이템 : "+this.itemName+", 가격 : "+this.price);
	}
}
