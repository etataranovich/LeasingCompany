package by.tataranovich.leasingcompany.dao.jdbcimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tataranovich.leasingcompany.connect.LazyConnectionPool;
import by.tataranovich.leasingcompany.dao.LeasingCompanyDAO;
import by.tataranovich.leasingcompany.model.LeasingCompany;

public class JDBCLeasingCompanyDAO extends AbstractDAO<LeasingCompany> implements LeasingCompanyDAO {

    private static final Logger lOGGER = LogManager.getLogger(JDBCLeasingCompanyDAO.class);

    private final static String GET_LEASING_COMPANY_BY_ID = "SELECT * FROM leasing_company WHERE leasing_company.id=?";
    private final static String GET_LEASING_COMPANY_ALL = "SELECT * FROM leasing_company";
    private final static String INSERT_LEASING_COMPANY = "INSERT into leasing_company (leasing_company.name, leasing_company.phone) VALUES (?,?)";
    private final static String UPDATE_LEASING_COMPANY = "UPDATE leasing_company SET leasing_company.name =? WHERE leasing_company.id=?";
    private final static String DELETE_LEASING_COMPANY_BY_ID = "DELETE from leasing_company WHERE id=?";

    private LeasingCompany setFieldsForLeasingCompany(ResultSet result, LeasingCompany leasingCompany) {
	try {
	    leasingCompany.setId(result.getLong("id"));
	    leasingCompany.setName(result.getString("name"));
	    leasingCompany.setPhone(result.getString("phone"));
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	}
	return leasingCompany;
    }

    @Override
    public LeasingCompany getById(Long id) {
	connection = getConnection();
	LeasingCompany leasingCompany = new LeasingCompany();
	try (PreparedStatement preparedStatement = connection.prepareStatement(GET_LEASING_COMPANY_BY_ID)) {
	    preparedStatement.setLong(1, id);
	    try (ResultSet result = preparedStatement.executeQuery()) {
		if (result.next()) {
		    setFieldsForLeasingCompany(result, leasingCompany);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return leasingCompany;
    }

    @Override
    public List<LeasingCompany> getAll() {
	connection = getConnection();
	List<LeasingCompany> leasingCompanyList = new ArrayList<>();
	try (Statement statement = connection.createStatement()) {
	    try (ResultSet result = statement.executeQuery(GET_LEASING_COMPANY_ALL)) {
		while (result.next()) {
		    LeasingCompany leasingCompany = new LeasingCompany();
		    setFieldsForLeasingCompany(result, leasingCompany);
		    leasingCompanyList.add(leasingCompany);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return leasingCompanyList;
    }

    @Override
    public void add(LeasingCompany leasingCompany) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LEASING_COMPANY)) {
	    preparedStatement.setString(1, leasingCompany.getName());
	    preparedStatement.setString(2, leasingCompany.getPhone());
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
	try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LEASING_COMPANY_BY_ID)) {
	    preparedStatement.setLong(1, id);
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }
   
    @Override
    public void update(LeasingCompany leasingCompany) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LEASING_COMPANY)) {
	    preparedStatement.setString(1, leasingCompany.getName());
	    preparedStatement.setString(2, leasingCompany.getPhone());
	    preparedStatement.setLong(3, leasingCompany.getId());
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }
}
