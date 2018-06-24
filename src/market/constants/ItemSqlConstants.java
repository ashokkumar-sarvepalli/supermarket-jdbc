package market.constants;

public interface ItemSqlConstants {

	public final static String INSERT_ITEM = "insert into item values(?,?,?)";
	public final static String SELECT_ITEM = "select * from item where code = ?";
	public final static String UPDATE_ITEM = "update item set name=?, price=? where code=?";
	public final static String DELETE_ITEM = "delete from item where code = ?";

}
