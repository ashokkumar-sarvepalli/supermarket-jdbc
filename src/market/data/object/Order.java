package market.data.object;

import java.util.List;

public class Order {

	private int orderNo;
	private String phone;
	private String custName;
	private double amount;
	private List<PurchasedItems> itemList;

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<PurchasedItems> getItemList() {
		return itemList;
	}

	public void setItemList(List<PurchasedItems> itemList) {
		this.itemList = itemList;
	}

}
