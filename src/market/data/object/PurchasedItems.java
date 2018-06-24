package market.data.object;

public class PurchasedItems {

	private Item item;
	private double qty;
	private double overallPrice;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public double getOverallPrice() {
		return overallPrice;
	}

	public void setOverallPrice(double overallPrice) {
		this.overallPrice = overallPrice;
	}

}
