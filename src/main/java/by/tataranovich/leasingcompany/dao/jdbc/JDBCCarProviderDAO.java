package by.tataranovich.leasingcompany.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tataranovich.leasingcompany.dao.interfaces.ICarProviderDAO;
import by.tataranovich.leasingcompany.model.CarProvider;
import by.tatatanovich.leasingcompany.connect.LazyConnectionPool;

public class JDBCCarProviderDAO extends AbstractDAO<CarProvider> implements ICarProviderDAO {

    private static final Logger lOGGER = LogManager.getLogger(JDBCCarProviderDAO.class);

    private final static String GET_CAR_PROVIDER_BY_ID = "SELECT * FROM car_providers WHERE car_providers.id=?";
    private final static String GET_CAR_PROVIDER_BY_CAR_ID = "SELECT * FROM car_providers LEFT JOIN cars ON car_providers.id=cars.id WHERE cars.id=?";
    private final static String GET_CAR_PROVIDERS_ALL = "SELECT * FROM car_providers";
    private final static String INSERT_CAR_PROVIDER = "INSERT into car_providers (car_providers.name, car_providers.phone) VALUES (?,?)";
    private final static String UPDATE_CAR_PROVIDER = "UPDATE car_providers SET car_providers.name =? WHERE car_providers.id=?";
    private final static String DELETE_CAR_PROVIDER_BY_ID = "DELETE from car_providers WHERE id=?";

    // add method public ArrayList<Car> getcar_providersByIdCarProvider(int id)
    // @Override
    // String getTableName() {
    // return "car_providers";
    // }
    //
    // @Override
    // public CarProvider popularQueryGetById(ResultSet result) {
    // CarProvider carProvider = new CarProvider();
    // try {
    // carProvider.setId(result.getInt("id"));
    // carProvider.setName(result.getString("name"));
    // carProvider.setPhone(result.getInt("phone"));
    // } catch (SQLException e) {
    // lOGGER.error(e.getMessage());
    // }
    // return carProvider;
    // }

    @Override
    public CarProvider getById(Integer id) {
	connection = getConnection();
	// PreparedStatement preparedStatement = null;
	// ResultSet result = null;
	CarProvider carProvider = new CarProvider();
	try (PreparedStatement preparedStatement = connection.prepareStatement(GET_CAR_PROVIDER_BY_ID)) {
	    preparedStatement.setInt(1, id);
	    try (ResultSet result = preparedStatement.executeQuery()) {
		if (result.next()) {
		    carProvider.setId(result.getInt("id"));
		    carProvider.setName(result.getString("name"));
		    carProvider.setPhone(result.getString("phone"));
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return carProvider;
    }

    public CarProvider getByCarId(int id) {
	connection = getConnection();
	CarProvider carProvider = new CarProvider();
	try (PreparedStatement preparedStatement = connection.prepareStatement(GET_CAR_PROVIDER_BY_CAR_ID)) {
	    preparedStatement.setInt(1, id);
	    try (ResultSet result = preparedStatement.executeQuery()) {
		if (result.next()) {
		    carProvider.setId(result.getInt("id"));
		    carProvider.setName(result.getString("name"));
		    carProvider.setPhone(result.getString("phone"));
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return carProvider;
    }

    @Override
    public List<CarProvider> getAll() {
	connection = getConnection();
	List<CarProvider> carProviderList = new ArrayList<>();
	try (Statement statement = connection.createStatement()) {
	    try (ResultSet result = statement.executeQuery(GET_CAR_PROVIDERS_ALL)) {
		while (result.next()) {
		    CarProvider carProvider = new CarProvider();
		    carProvider.setId(result.getInt("id"));
		    carProvider.setName(result.getString("name"));
		    carProvider.setPhone(result.getString("phone"));
		    carProviderList.add(carProvider);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return carProviderList;
    }

    @Override
    public void add(CarProvider carProvider) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CAR_PROVIDER)) {
	    preparedStatement.setString(1, carProvider.getName());
	    preparedStatement.setString(2, carProvider.getPhone());
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }

    public void delete(Integer id) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAR_PROVIDER_BY_ID)) {
	    preparedStatement.setInt(1, id);
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }

    public void update(CarProvider carProvider) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAR_PROVIDER)) {
	    preparedStatement.setString(1, carProvider.getName());
	    preparedStatement.setString(2, carProvider.getPhone());
	    preparedStatement.setInt(3, carProvider.getId());
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }

}
