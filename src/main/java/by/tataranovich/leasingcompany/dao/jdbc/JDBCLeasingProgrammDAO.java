package by.tataranovich.leasingcompany.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tataranovich.leasingcompany.dao.interfaces.ILeasingProgrammDAO;
import by.tataranovich.leasingcompany.model.LeasingProgramm;
import by.tatatanovich.leasingcompany.connect.LazyConnectionPool;


public class JDBCLeasingProgrammDAO extends AbstractDAO<JDBCLeasingProgrammDAO> implements ILeasingProgrammDAO {

    private static final Logger lOGGER = LogManager.getLogger(JDBCLeasingProgrammDAO.class);

    private final static String GET_LEASING_PROGRAMM_BY_CONTRACT_ID = "SELECT leasing_programms.name, leasing_programms.max_year_term, leasing_programms.commision FROM leasing_programms LEFT JOIN contracts ON contracts.leasing_programm_id=leasing_programms.id WHERE contracts.id=?";
    private final static String GET_LEASING_PROGRAMM_BY_ID = "SELECT leasing_programms.id, leasing_programms.name, leasing_programms.max_year_term, leasing_programms.commision from leasing_programms WHERE leasing_programms.id=?";
    private final static String GET_LEASING_PROGRAMMS_ALL = "SELECT * FROM leasing_programms";
    private final static String INSERT_LEASING_PROGRAMM = "INSERT into leasing_programms (leasing_programms.loan_amount, leasing_programms.interest_rate, leasing_programms.term) VALUES (?,?,?)";
    private final static String UPDATE_LEASING_PROGRAMM_BY_ID = "UPDATE leasing_programms SET leasing_programms.loan_amount = ? WHERE leasing_programms.id=?";
    private final static String DELETE_LEASING_PROGRAMM_BY_ID = "DELETE from leasing_programms WHERE id=?";

    private LeasingProgramm setFieldsForLeasingProgramm(ResultSet result, LeasingProgramm leasingProgramm) {
	try {
	    leasingProgramm.setId(result.getInt("id"));
	    leasingProgramm.setName(result.getString("name"));
	    leasingProgramm.setMaxYearTerm(result.getInt("max_year_term"));
	    leasingProgramm.setCommision(result.getInt("commision"));
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	}
	return leasingProgramm;
    }

    @Override
    public LeasingProgramm getById(Integer id) {
	connection = getConnection();
	LeasingProgramm leasingProgramm = new LeasingProgramm();
	try (Statement statement = connection.createStatement()) {
	    try (ResultSet result = statement.executeQuery(GET_LEASING_PROGRAMM_BY_ID)) {
		if (result.next()) {
		    setFieldsForLeasingProgramm(result, leasingProgramm);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return leasingProgramm;
    }

    @Override
    public List<LeasingProgramm> getAll() {
	connection = getConnection();
	List<LeasingProgramm> leasingProgrammList = new ArrayList<>();
	try (Statement statement = connection.createStatement()) {
	    try (ResultSet result = statement.executeQuery(GET_LEASING_PROGRAMMS_ALL)) {
		while (result.next()) {
		    LeasingProgramm leasingProgramm = new LeasingProgramm();
		    setFieldsForLeasingProgramm(result, leasingProgramm);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return leasingProgrammList;
    }

    @Override
    public LeasingProgramm getLeasingProgrammByContractId(Integer id) {
	connection = getConnection();
	LeasingProgramm leasingProgramm = new LeasingProgramm();
	try (Statement statement = connection.createStatement()) {
	    try (ResultSet result = statement.executeQuery(GET_LEASING_PROGRAMM_BY_CONTRACT_ID)) {
		if (result.next()) {
		    setFieldsForLeasingProgramm(result, leasingProgramm);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return leasingProgramm;
    }

    @Override
    public void add(LeasingProgramm leasingProgramm) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LEASING_PROGRAMM)) {
	    preparedStatement.setString(1, leasingProgramm.getName());
	    preparedStatement.setInt(2,  leasingProgramm.getMaxYearTerm());
	    preparedStatement.setInt(3, leasingProgramm.getCommision());
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }

    public void delete(Integer id) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LEASING_PROGRAMM_BY_ID)) {
	    preparedStatement.setInt(1, id);
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }

    public void update(LeasingProgramm leasingProgramm) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LEASING_PROGRAMM_BY_ID)) {
	    preparedStatement.setInt(1, leasingProgramm.getMaxYearTerm());
	    preparedStatement.setInt(2, leasingProgramm.getCommision());
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }



}
