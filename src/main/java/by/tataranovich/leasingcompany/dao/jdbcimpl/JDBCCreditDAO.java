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
import by.tataranovich.leasingcompany.dao.ICreditDAO;
import by.tataranovich.leasingcompany.model.Credit;


public class JDBCCreditDAO extends AbstractDAO<Credit> implements ICreditDAO {

    private static final Logger lOGGER = LogManager.getLogger(JDBCCreditDAO.class);

    private final static String GET_CREDIT_BY_CONTRACT_ID = "SELECT credits.id, credits.loan_amount, credits.interest_rate, credits.term FROM credits LEFT JOIN contracts ON contracts.credit_id=credits.id WHERE contracts.id=?";
    private final static String GET_CREDIT_BY_ID = "SELECT credits.id, credits.price, credits.credit_model_id from credits WHERE creditS.id=?";
    private final static String GET_CREDITS_ALL = "SELECT * FROM credits";
    private final static String INSERT_CREDIT = "INSERT into credits (credits.loan_amount, credits.interest_rate, credits.term) VALUES (?,?,?)";
    private final static String UPDATE_CREDIT_BY_ID = "UPDATE credits SET credits.loan_amount = ? WHERE credits.id=?";
    private final static String DELETE_CREDIT_BY_ID = "DELETE from credits WHERE id=?";

    private Credit setFieldsForCredit(ResultSet result, Credit credit) {
	try {
	    credit.setId(result.getLong("id"));
	    credit.setLoanAmount(result.getInt("loan_amount"));
	    credit.setInterestRate(result.getInt("interest_rate"));
	    credit.setTerm(result.getInt("term"));
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	}
	return credit;
    }

    @Override
    public Credit getById(Long id) {
	connection = getConnection();
	Credit credit = new Credit();
	try (Statement statement = connection.createStatement()) {
	    try (ResultSet result = statement.executeQuery(GET_CREDIT_BY_ID)) {
		if (result.next()) {
		    setFieldsForCredit(result, credit);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return credit;
    }

    @Override
    public List<Credit> getAll() {
	connection = getConnection();
	List<Credit> creditList = new ArrayList<>();
	try (Statement statement = connection.createStatement()) {
	    try (ResultSet result = statement.executeQuery(GET_CREDITS_ALL)) {
		while (result.next()) {
		    Credit credit = new Credit();
		    setFieldsForCredit(result, credit);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return creditList;
    }

    @Override
    public Credit getCreditByContractId(Long id) {
	connection = getConnection();
	Credit credit = new Credit();
	try (PreparedStatement preparedStatement = connection.prepareStatement(GET_CREDIT_BY_CONTRACT_ID)) {
	    preparedStatement.setLong(1, id);
	    try (ResultSet result = preparedStatement.executeQuery()) {
		if (result.next()) {
		    setFieldsForCredit(result, credit);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return credit;
    }

    @Override
    public void add(Credit credit) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CREDIT)) {
	    preparedStatement.setInt(1, credit.getLoanAmount());
	    preparedStatement.setInt(2, credit.getInterestRate());
	    preparedStatement.setInt(3, credit.getTerm());
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
	try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CREDIT_BY_ID)) {
	    preparedStatement.setLong(1, id);
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }

    @Override
    public void update(Credit credit) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CREDIT_BY_ID)) {
	    preparedStatement.setInt(1, credit.getLoanAmount());
	    preparedStatement.setLong(2, credit.getId());
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }

}
