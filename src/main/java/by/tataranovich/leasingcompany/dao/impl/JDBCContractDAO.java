package by.tataranovich.leasingcompany.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tataranovich.leasingcompany.connect.LazyConnectionPool;
import by.tataranovich.leasingcompany.dao.IContractDAO;
import by.tataranovich.leasingcompany.model.Contract;

public class JDBCContractDAO extends AbstractDAO<Contract> implements IContractDAO {
    private static final Logger lOGGER = LogManager.getLogger(JDBCContractDAO.class);

    private final static String GET_CONTRACTS_BY_CLIENT_ID = "SELECT contracts.id, contracts.date from contracts LEFT JOIN clients ON contracts.client_id=clients.id WHERE client_id=?";
    private final static String GET_CONTRACTS_BY_LEASING_COMPANY_ID = "SELECT contracts.id, contracts.date FROM contracts LEFT JOIN leasing_company ON contracts.leasing_company_id=leasing_company.id WHERE leasing_company.id=?";
    private final static String GET_CONTRACT_BY_ID = "SELECT contracts.id, contracts.date from contracts WHERE contracts.id=?";
    private final static String GET_CONTRACTS_ALL = "SELECT contracts.id, contracts.date from contracts";
    private final static String INSERT_CONTRACT = "INSERT into contracts (date, clients_id,cars_id, leasing_programm_id, credits_id, leasing_company_id) VALUES (?,?,?,?,?,?)";
    private final static String UPDATE_CONTRACT_BY_ID = "UPDATE contracts SET contracts.date =? WHERE contracts.id=?";
    private final static String DELETE_CONTRACT_BY_ID = "DELETE from contracts WHERE id=?";

    // private final static String INSERT_INTO_LEASING_COPANY_HAS_CLIENTS = "INSERT
    // into Leasing_company_has_Clients Leasing_company_id =? Clients_id =? if NOT
    // EXIST ";

    @Override
    public Contract getById(Long id) {
	connection = getConnection();
	Contract contract = new Contract();
	try (PreparedStatement preparedStatement = connection.prepareStatement(GET_CONTRACT_BY_ID)) {
	    preparedStatement.setLong(1, id);
	    try (ResultSet result = preparedStatement.executeQuery()) {
		if (result.next()) {
		    contract.setId(result.getLong("id"));
		    contract.setDate(result.getDate("date"));
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return contract;
    }

    @Override
    public List<Contract> getAll() {
	connection = getConnection();
	List<Contract> contractList = new ArrayList<>();
	try (Statement statement = connection.createStatement()) {
	    try (ResultSet result = statement.executeQuery(GET_CONTRACTS_ALL)) {
		while (result.next()) {
		    Contract contract = new Contract();
		    contract.setId(result.getLong("id"));
		    contract.setDate(result.getDate("date"));
		    contractList.add(contract);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return contractList;
    }

    @Override
    public List<Contract> getContractsByIdClient(Long id) {
	connection = getConnection();
	List<Contract> contractList = new ArrayList<>();
	try (PreparedStatement preparedStatement = connection.prepareStatement(GET_CONTRACTS_BY_CLIENT_ID)) {
	    preparedStatement.setLong(1, id);
	    try (ResultSet result = preparedStatement.executeQuery()) {
		while (result.next()) {
		    Contract contract = new Contract();
		    contract.setId(result.getLong("id"));
		    contract.setDate(result.getDate("date"));
		    contractList.add(contract);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return contractList;
    }

    @Override
    public List<Contract> getContractsByIdLeasingCompany(Long id) {
	connection = getConnection();
	List<Contract> contractList = new ArrayList<>();
	try (PreparedStatement preparedStatement = connection.prepareStatement(GET_CONTRACTS_BY_LEASING_COMPANY_ID)) {
	    preparedStatement.setLong(1, id);
	    try (ResultSet result = preparedStatement.executeQuery()) {
		while (result.next()) {
		    Contract contract = new Contract();
		    contract.setId(result.getLong("id"));
		    contract.setDate(result.getDate("date"));
		    contractList.add(contract);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return contractList;
    }

    public void add(Contract contract, Integer idLeasingCompany) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT)) {
	    preparedStatement.setObject(1, contract.getDate());
	    preparedStatement.setLong(2, contract.getClient().getId());
	    preparedStatement.setLong(3, contract.getCar().getId());
	    preparedStatement.setLong(4, contract.getLeasingProgramm().getId());
	    preparedStatement.setLong(5, contract.getCredit().getId());
	    preparedStatement.setLong(6, contract.getLeasingProgramm().getId());
	    preparedStatement.setLong(7, contract.getId());
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }

    @Override
    public void delete(Long id) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT_BY_ID)) {
	    preparedStatement.setLong(1, id);
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }

    @Override
    public void update(Contract contract) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONTRACT_BY_ID)) {
	    preparedStatement.setObject(1, contract.getDate());
	    preparedStatement.setLong(2, contract.getClient().getId());
	    preparedStatement.setLong(3, contract.getCar().getId());
	    preparedStatement.setLong(4, contract.getLeasingProgramm().getId());
	    preparedStatement.setLong(5, contract.getCredit().getId());
	    preparedStatement.setLong(6, contract.getLeasingProgramm().getId());
	    preparedStatement.setLong(7, contract.getId());
	    preparedStatement.executeUpdate();
	    connection.commit();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }

    @Override
    public void add(Contract entity) {

    }

}

// private void addToLeasingCompanyHasClients(Contract contract) {
// connection = getConnection();
// connection.setAutoCommit(false);
// try (PreparedStatement preparedStatement =
// connection.prepareStatement(INSERT_INTO_LEASING_COPANY_HAS_CLIENTS)) {
// preparedStatement.setInt(1, contract.getLeasingCompany().getId());
// preparedStatement.setInt(2, contract.getClient().getId());
// preparedStatement.executeUpdate();
// connection.commit();
// } catch (SQLException e) {
// lOGGER.error(e.getMessage());
// connection.rollback();
// } finally {
// if (connection != null) {
// connection.setAutoCommit(true);
// }
// LazyConnectionPool.getInstance().releaseConnection(connection);
// }
// }
