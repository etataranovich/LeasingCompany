package by.tataranovich.leasingcompany.dao.jdbc;



import java.sql.Connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tatatanovich.leasingcompany.connect.LazyConnectionPool;


public abstract class AbstractDAO<T> {
    private static final Logger lOGGER = LogManager.getLogger(AbstractDAO.class);
    Connection connection = null;

    
//    abstract String getTableName();
//    
//    public T getById(int id) {
//	connection = getConnection();
//	try (PreparedStatement preparedStatement = connection
//		.prepareStatement("SELECT * FROM ? WHERE id=?")) {
//	    preparedStatement.setString(1, getTableName());
//	    preparedStatement.setInt(2, id);
//	    try (ResultSet result = preparedStatement.executeQuery()) {
//		if (result.next()) {
//		    return popularQueryGetById(result);
//		}
//	    } catch (SQLException e) {
//		lOGGER.error(e.getMessage());
//	    }
//	} catch (SQLException e) {
//	    lOGGER.error(e.getMessage());
//	} finally {
//	    LazyConnectionPool.getInstance().releaseConnection(connection);
//	}
//	return null;
//    }
//    
//    abstract T popularQueryGetById(ResultSet result);
//  abstract T popularQueryGetAll(ResultSet result);
//  abstract void popularQueryDelete();

        
   // public abstract T add(T t);

   // abstract PreparedStatement getPreparedStatement(Connection connection);

    protected Connection getConnection() {
	Connection connection = null;
	try {
	    connection = LazyConnectionPool.getInstance().getConnection();
	} catch (InterruptedException e1) {
	    lOGGER.error(e1.getMessage());
	}
	return connection;
    }   

}
    



    
//    public void add(T entity) {
//	connection = getConnection();
//	popularQueryAdd();
//	    preparedStatement.executeUpdate();
//	} catch (SQLException e) {
//	    lOGGER.error(e.getMessage());
//	} finally {
//	    LazyConnectionPool.getInstance().releaseConnection(connection);
//	}
//    }
////
//    public T getByIdWithSPreparedStatement(int id) {
//	connection = getConnection();
//	try (PreparedStatement preparedStatement = getPreparedStatement(connection)) {
//	    preparedStatement.setInt(1, id);
//	    try (ResultSet result = preparedStatement.executeQuery()) {
//		if (result.next()) {
//		    return popularQuery(result);
//		}
//	    } catch (SQLException e) {
//		lOGGER.error(e.getMessage());
//	    }
//	} catch (SQLException e) {
//	    lOGGER.error(e.getMessage());
//	} finally {
//	    LazyConnectionPool.getInstance().releaseConnection(connection);
//	}
//	return null;
//    }
//    
//    


// // Put common strings in abstract class for exampple
// public T getById(int id) {
// connection = getConnection();
// PreparedStatement preparedStatement = null;
// ResultSet result = null;
// try {
//
// // option 1
// preparedStatement = connection.prepareStatement("SELECT * FROM ? A WHERE
// A.ID=?");
// preparedStatement.setString(1, getTableName());
// preparedStatement.setInt(2, id);
//
// // option 2 in case of different Select methods:
//
// getPreparedStatement(connection);
// result = preparedStatement.executeQuery();
// if (result.hasNext()) {
// T value = populateValue(result.next());
// }
// } catch (SQLException e) {
// lOGGER.error(e.getMessage());
// } finally {
// ConnectionPool.getINSTANCE().putBackConnection(connection);
// close(preparedStatement);
// close(result);
// }
// return value;
// }
//
// abstract T popularValue(ResultSet result);
//
// abstract String getTableName(); // option 1
//
// abstract PreparedStatement getPreparedStatement(connection); // option 2
// }

// public List<T> getAll() {
// Connection connection = getConnection();
// List<T> list = new ArrayList<>();
// // Statement statement = null;
// // ResultSet result = null;
// try (PreparedStatement preparedStatement =
// connection.prepareStatement("SELECT * FROM ?")) {
// preparedStatement.setString(1, getTableName());
// try (ResultSet result = preparedStatement.executeQuery()) {
//
// while (result.next()) {
//
// T value = populateValue(result.next());
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
// return list;
// }