package by.tataranovich.leasingcompany.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tataranovich.leasingcompany.connect.LazyConnectionPool;
import by.tataranovich.leasingcompany.dao.ICarProviderDAO;
import by.tataranovich.leasingcompany.model.CarProvider;


public class JDBCCarProviderDAO extends AbstractDAO<CarProvider> implements ICarProviderDAO {

    private static final Logger lOGGER = LogManager.getLogger(JDBCCarProviderDAO.class);

    private final static String GET_CAR_PROVIDER_BY_ID = "SELECT * FROM car_providers WHERE car_providers.id=?";
    private final static String GET_CAR_PROVIDER_BY_CAR_ID = "SELECT * FROM car_providers LEFT JOIN cars ON car_providers.id=cars.id WHERE cars.id=?";
    private final static String GET_CAR_PROVIDERS_ALL = "SELECT * FROM car_providers";
    private final static String INSERT_CAR_PROVIDER = "INSERT into car_providers (car_providers.name, car_providers.phone) VALUES (?,?)";
    private final static String UPDATE_CAR_PROVIDER = "UPDATE car_providers SET car_providers.name =? WHERE car_providers.id=?";
    private final static String DELETE_CAR_PROVIDER_BY_ID = "DELETE from car_providers WHERE id=?";

    @Override
    public CarProvider getById(Long id) {
	connection = getConnection();
	CarProvider carProvider = new CarProvider();
	try (PreparedStatement preparedStatement = connection.prepareStatement(GET_CAR_PROVIDER_BY_ID)) {
	    preparedStatement.setLong(1, id);
	    try (ResultSet result = preparedStatement.executeQuery()) {
		if (result.next()) {
		    carProvider.setId(result.getLong("id"));
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

    public CarProvider getCarProviderByCarId(Long id) {
	connection = getConnection();
	CarProvider carProvider = new CarProvider();
	try (PreparedStatement preparedStatement = connection.prepareStatement(GET_CAR_PROVIDER_BY_CAR_ID)) {
	    preparedStatement.setLong(1, id);
	    try (ResultSet result = preparedStatement.executeQuery()) {
		if (result.next()) {
		    carProvider.setId(result.getLong("id"));
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
		    carProvider.setId(result.getLong("id"));
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

    public void delete(Long id) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAR_PROVIDER_BY_ID)) {
	    preparedStatement.setLong(1, id);
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
	    preparedStatement.setLong(3, carProvider.getId());
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }

}
