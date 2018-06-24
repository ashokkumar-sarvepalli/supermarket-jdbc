package market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import market.constants.ItemSqlConstants;
import market.data.object.Item;
import market.dbconnection.DBConnection;
import market.exceptions.ItemAlreadyExistsException;
import market.exceptions.ItemNotFoundException;

public class ItemDAO {

	public boolean createItem(Item item) throws ItemAlreadyExistsException {
		try {
			Connection con = DBConnection.getConnection();
			Item itemNew = selectItem(item.getCode());
			if (itemNew != null) {
				throw new ItemAlreadyExistsException("The item with the same Item code already Exists");
			}

			PreparedStatement ps = con.prepareStatement(ItemSqlConstants.INSERT_ITEM);
			ps.setInt(1, item.getCode());
			ps.setString(2, item.getName());
			ps.setDouble(3, item.getPrice());
			ps.executeUpdate();
		} catch (ItemAlreadyExistsException iaeEx) {
			throw iaeEx;
		} catch (Exception ex) {
			ex.printStackTrace();
			// log the exception in logs
			return false;
		}
		return true;
	}

	public boolean updateItem(Item item) throws ItemNotFoundException {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(ItemSqlConstants.UPDATE_ITEM);
			ps.setString(1, item.getName());
			ps.setDouble(2, item.getPrice());
			ps.setInt(3, item.getCode());
			int result = ps.executeUpdate();
			if (result == 0) {
				throw new ItemNotFoundException("The item you are searching is not found");
			}
		} catch (ItemNotFoundException ex) {
			throw ex;
		} catch (Exception ex) {

			// log the exception in logs
			return false;
		}
		return true;
	}

	public boolean deleteItem(int id) throws ItemNotFoundException {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(ItemSqlConstants.DELETE_ITEM);
			ps.setInt(1, id);
			int result = ps.executeUpdate();
			if (result == 0) {
				throw new ItemNotFoundException("The item you are searching is not found");
			}
		} catch (ItemNotFoundException ex) {
			throw ex;
		} catch (Exception ex) {

			// log the exception in logs
			return false;
		}
		return true;
	}

	public Item viewItem(int id) throws ItemNotFoundException {
		try {
			Item item = selectItem(id);
			if (item == null) {
				throw new ItemNotFoundException("The item you are searching is not found");
			}
			return item;

		} catch (ItemNotFoundException ex) {
			throw ex;
		} catch (Exception ex) {

			// log the exception in logs
			return null;
		}
	}

	private Item selectItem(int id) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(ItemSqlConstants.SELECT_ITEM);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Item item = new Item();
				item.setCode(rs.getInt("code"));
				item.setName(rs.getString("name"));
				item.setPrice(rs.getDouble("price"));
				return item;
			}

			return null;
		} catch (Exception ex) {

			// log the exception in logs
			return null;
		}
	}

}
