package by.tataranovich.leasingcompany.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tataranovich.leasingcompany.dao.interfaces.IClientDAO;
import by.tataranovich.leasingcompany.model.Client;
import by.tatatanovich.leasingcompany.connect.LazyConnectionPool;

public class JDBCClientDAO extends AbstractDAO<Client> implements IClientDAO {
    private static final Logger lOGGER = LogManager.getLogger(JDBCClientDAO.class);

    private final static String GET_CLIENT_BY_CONTRACT_ID = "SELECT clients.id, clients.first_name, clients.last_name, clients.phone FROM clients LEFT JOIN contracts ON clients.id=contracts.ñlient_id WHERE contracts.id=?";
    private final static String GET_CLIENT_BY_ID = "SELECT client.id, client.street, client.house from client WHERE client.id=?";
    private final static String GET_CLIENTS_ALL_BY_LEASING_COMPANY_ID = "SELECT clients.id, clients.first_name, clients.last_name, clients.phone FROM leasing_company_has_clients LEFT JOIN clients ON clients.id=leasing_company_has_clients.ñlients_id WHERE leasing_company_has_clients.leasing_company_id=?";
    private final static String INSERT_CLIENT = "INSERT INTO clients (first_name,last_name, phone) VALUES (?,?,?)";
    private final static String UPDATE_CLIENT_BY_ID = "UPDATE clients SET clients.last_name=? WHERE client.id=?";
    private final static String DELETE_CLIENT_BY_ID = "DELETE from clients WHERE id=?";
    private final static String INSERT_CLIENT_TO_LEASING_COMPANY_HAS_CLIENTS = "INSERT INTO leasing_company_has_clients (leasing_company_id, clients.id) VALUES (?,?)";

    private Client setFieldsForClient(ResultSet result, Client client) {
	try {
	    client.setId(result.getInt("id"));
	    client.setFirstName(result.getString("first_name"));
	    client.setLastName(result.getString("last_name"));
	    client.setPhone(result.getString("phone"));
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	}
	return client;
    }

    // @Override
    // String getTableName() {
    // return "clients";
    // }
    //
    // @Override
    // public Client popularQueryGetById(ResultSet result) {
    // Client client = new Client();
    // try {
    // client.setId(result.getInt("id"));
    // client.setFirst_name(result.getString("first_name"));
    // client.setLast_name(result.getString("last_name"));
    // client.setPhone(result.getInt("phone"));
    // } catch (SQLException e) {
    // lOGGER.error(e.getMessage());
    // }
    // return client;
    // }

    public Client getClientByContractId(Integer id) {
	connection = getConnection();
	Client client = new Client();
	try (PreparedStatement preparedStatement = connection.prepareStatement(GET_CLIENT_BY_CONTRACT_ID)) {
	    preparedStatement.setInt(1, id);
	    try (ResultSet result = preparedStatement.executeQuery()) {
		if (result.next()) {
		    setFieldsForClient(result, client);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return client;
    }

    @Override
    public Client getById(Integer id) {
	connection = getConnection();
	Client client = new Client();
	try (PreparedStatement preparedStatement = connection.prepareStatement(GET_CLIENT_BY_ID)) {
	    preparedStatement.setInt(1, id);
	    try (ResultSet result = preparedStatement.executeQuery()) {
		if (result.next()) {
		    setFieldsForClient(result, client);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return client;
    }

    public List<Client> getAllbyLeasingCompanyId(int idLeasingCompany) {
	connection = getConnection();
	List<Client> clientList = new ArrayList<>();
	try (Statement statement = connection.createStatement()) {
	    try (ResultSet result = statement.executeQuery(GET_CLIENTS_ALL_BY_LEASING_COMPANY_ID)) {
		while (result.next()) {
		    Client client = new Client();
		    setFieldsForClient(result, client);
		    clientList.add(client);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return clientList;
    }
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void add(Client client, int idLeasingCompany) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT);
		PreparedStatement statement = connection
			.prepareStatement(INSERT_CLIENT_TO_LEASING_COMPANY_HAS_CLIENTS)) {
	    preparedStatement.setString(1, client.getFirstName());
	    preparedStatement.setString(2, client.getLastName());
	    preparedStatement.setString(3, client.getPhone());
	    statement.setInt(1, idLeasingCompany);
	    statement.setInt(2, client.getId());
	    preparedStatement.executeUpdate();
	    /// INSERT Many to many
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }

    public void delete(Integer id) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT_BY_ID)) {
	    preparedStatement.setInt(1, id);
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }

    public void update(Client client) {
	connection = getConnection();
	
	    
	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENT_BY_ID)) {
	    connection.setAutoCommit(false);
	    preparedStatement.setString(1, client.getFirstName());
	    preparedStatement.setString(2, client.getLastName());
	    preparedStatement.setString(3, client.getPhone());
	    preparedStatement.setInt(4, client.getId());
	    preparedStatement.executeUpdate();
	    connection.commit();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    if (connection != null) {
		try {
		    connection.setAutoCommit(true);
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	}
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	}
    

    @Override
    public void add(Client entity) {
	// TODO Auto-generated method stub

    }

    @Override
    public List<Client> getAll() {
	// TODO Auto-generated method stub
	return null;
    }

}






// new
// public ArrayList<Contract> getContractsByIdClient(int id) {
// connection = getConnection();
// // PreparedStatement preparedStatement = null;
// // ResultSet result = null;
// ArrayList<Contract> contracts = new ArrayList<Contract>();
// try (PreparedStatement preparedStatement = connection
// .prepareStatement("SELECT * FROM contracts WHERE clients_id=?")) {
// preparedStatement.setInt(1, id);
// try (ResultSet result = preparedStatement.executeQuery()) {
// while (result.next()) {
// Contract contract = new Contract();
// contract.setId(result.getInt("id"));
// contract.setDate(result.getDate("date"));
//
// Client client = new Client();
// client.setId(result.getInt("clients_id"));
// contract.setClient(client);
//
// Car car = new Car();
// car.setId(result.getInt("cars_id"));
// contract.setCar(car);
//
// LeasingProgramm leasingProgramm = new LeasingProgramm();
// leasingProgramm.setId(result.getInt("leasingProgramm_id"));
// contract.setLeasingProgramm(leasingProgramm);
//
// Credit credit = new Credit();
// credit.setId(result.getInt("credits_id"));
// contract.setCredit(credit);
//
// LeasingCompany leasingCompany = new LeasingCompany();
// leasingCompany.setId(result.getInt("leasing_company_id"));
// contract.setLeasingCompany(leasingCompany);
//
// contracts.add(contract);
//
// }
// } catch (SQLException e) {
// lOGGER.error(e.getMessage());
// }
// } catch (SQLException e) {
// lOGGER.error(e.getMessage());
// } finally {
// LazyConnectionPool.getInstance().releaseConnection(connection);
// }
// return contracts;
// }
