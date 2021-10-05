package models;

public class Cart {
	private String userId;
	private String itemName;

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
	
	public void print() {
		System.out.println("["+this.userId+"] æ∆¿Ã≈€ : "+this.itemName);
	}
}
