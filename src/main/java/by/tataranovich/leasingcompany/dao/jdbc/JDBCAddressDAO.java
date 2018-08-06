package by.tataranovich.leasingcompany.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tataranovich.leasingcompany.dao.interfaces.IAddressDAO;
import by.tataranovich.leasingcompany.model.Address;
import by.tatatanovich.leasingcompany.connect.LazyConnectionPool;

public class JDBCAddressDAO extends AbstractDAO<Address> implements IAddressDAO {
    private static final Logger lOGGER = LogManager.getLogger(JDBCAddressDAO.class);
    private final static String GET_ADDRESSES_BY_LEASING_COMPANY_ID = "SELECT addresses.id, addresses.street, addresses.house from addresses LEFT JOIN leasing_company ON leasing_company.id=addresses.leasing_company_id WHERE leasing_company_id=?";
    private final static String GET_ADDRESS_BY_ID = "SELECT addresses.id, addresses.street, addresses.house from addresses WHERE addresses.id=?";
    private final static String GET_ADDRESS_ALL = "SELECT addresses.id, addresses.street, addresses.house from addresses";
    private final static String INSERT_ADDRESS = "INSERT into addresses (addresses.street, addresses.house, addresses.leasing_company_id ) VALUES (?,?,?)";
    private final static String UPDATE_ADDRESS_BY_ID = "UPDATE addresses SET addresses.street =? WHERE addresses.id=?";
    private final static String DELETE_ADDRESS_BY_ID = "DELETE from addresses WHERE id=?";

    private Address setFieldsForAddress(ResultSet result, Address address) {
	try {
	    address.setId(result.getInt("id"));
	    address.setStreet(result.getString("street"));
	    address.setHouseNumber(result.getString("house_number"));
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	}
	return address;
    }

    @Override
    public Address getById(Integer id) {
	connection = getConnection();
	Address address = new Address();
	try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ADDRESS_BY_ID)) {
	    preparedStatement.setInt(1, id);
	    try (ResultSet result = preparedStatement.executeQuery()) {
		if (result.next()) {
		    setFieldsForAddress(result, address);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return address;
    }

    @Override
    public List<Address> getAddressesByLeasingCompanyId(Integer id) {
	connection = getConnection();
	List<Address> addressList = new ArrayList<>();
	try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ADDRESSES_BY_LEASING_COMPANY_ID)) {
	    preparedStatement.setInt(1, id);
	    try (ResultSet result = preparedStatement.executeQuery()) {
		while (result.next()) {
		    Address address = new Address();
		    setFieldsForAddress(result, address);
		    addressList.add(address);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return addressList;
    }

    @Override
    public List<Address> getAll() {
	connection = getConnection();
	List<Address> addressList = new ArrayList<>();
	try (Statement statement = connection.createStatement()) {
	    try (ResultSet result = statement.executeQuery(GET_ADDRESS_ALL)) {
		while (result.next()) {
		    Address address = new Address();
		    setFieldsForAddress(result, address);
		    addressList.add(address);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return addressList;
    }

    public void add(Address address, Integer leasingCompanyId) throws SQLException {
	connection = getConnection();
	connection.setAutoCommit(false);
	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADDRESS)) {
	    preparedStatement.setString(1, address.getStreet());
	    preparedStatement.setString(2, address.getHouseNumber());
	    preparedStatement.setInt(3, leasingCompanyId);
	    preparedStatement.executeUpdate();
	    connection.commit();
	} catch (SQLException e) {
	    connection.rollback();
	    lOGGER.error(e.getMessage());
	} finally {
	    if (connection != null) {
		connection.setAutoCommit(true);
	    }
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }

    public void delete(Integer id) {
	connection = getConnection();

	try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ADDRESS_BY_ID)) {
	    preparedStatement.setInt(1, id);
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }

    public void update(Address address) throws SQLException {
	connection = getConnection();
	connection.setAutoCommit(false);
	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADDRESS_BY_ID)) {
	    preparedStatement.setString(1, address.getStreet());
	    preparedStatement.setInt(2, address.getId());
	    preparedStatement.executeUpdate();
	    connection.commit();
	} catch (SQLException e) {
	    connection.rollback();
	    lOGGER.error(e.getMessage());
	} finally {
	    if (connection != null) {
		connection.setAutoCommit(true);
	    }
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }

    @Override
    public void add(Address entity) {
	// TODO Auto-generated method stub

    }

}

// @Override
// Address popularQuery(ResultSet result) throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }

// public void popularQueryAdd() {
// Address address = new Address();
// try (PreparedStatement preparedStatement = connection
// .prepareStatement("INSERT INTO address (street,house,leasing_company_id)
// VALUES (?,?,?)")) {
// preparedStatement.setString(1, address.getStreet());
// preparedStatement.setInt(2, address.getHouse());
// preparedStatement.setInt(3, address.getLeasingCompany().getId());
// } catch (SQLException e) {
// lOGGER.error(e.getMessage());
// }
// return preparedStatement;
// }
//
// @Override
// PreparedStatement getPreparedStatement(Connection connection) {
// PreparedStatement preparedStatement = connection.prepareStatement(
// "SELECT * FROM ADDRESS A left join region R on A.REGION_ID=R.ID WHERE A.ID=?
// AND A.City=?");
// preparedStatement.setInt(1, id); // TODO check the first '?' has index 1 or 0
// preparedStatement.setString(2, city);
// return preparedStatement;
// }
// Âûםוסעט מעהוכüםûי לועמה
// private Address setAddress(ResultSet result, Address address) {
// try {
// if (result.next()) {
// address.setId(result.getInt("id"));
// address.setStreet(result.getString("street"));
// address.setHouse(result.getInt("house"));
// LeasingCompany leasingCompany = new LeasingCompany();
// leasingCompany.setId(result.getInt("leasing_company_id"));
// address.setLeasingCompany(leasingCompany);
// }
// } catch (SQLException e) {
// lOGGER.error(e.getMessage());
// }
// return address;
// }
//
// }
