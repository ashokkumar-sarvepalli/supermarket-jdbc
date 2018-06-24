package market.dao;

import market.data.object.Order;
import market.exceptions.ItemNotFoundException;
import market.exceptions.OrderNotFoundException;

public class OrderDAO {
	
	public boolean createOrder(Order order) throws ItemNotFoundException{
		return true;
	}
	
	
	public Order viewOrder(int orderId) throws OrderNotFoundException{
		return null;
	}

}
