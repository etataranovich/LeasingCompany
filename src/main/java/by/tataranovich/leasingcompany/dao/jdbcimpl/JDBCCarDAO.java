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
import by.tataranovich.leasingcompany.dao.ICarDAO;
import by.tataranovich.leasingcompany.model.Car;
import by.tataranovich.leasingcompany.model.CarModel;


public class JDBCCarDAO extends AbstractDAO<Car> implements ICarDAO {

    private static final Logger lOGGER = LogManager.getLogger(JDBCCarDAO.class);

    private final static String GET_CARS_BY_CAR_PROVIDER_ID = "SELECT cars.id, cars.price, cars.car_model_id FROM cars LEFT JOIN car_providers ON car_providers.id=cars.car_provider_id WHERE car_provider_id=?";
    private final static String GET_CAR_BY_CONTRACT_ID = "SELECT cars.id, cars.price, cars.car_model_id FROM cars LEFT JOIN contracts ON contracts.ñar_id=cars.id WHERE contracts.id=?";
    private final static String GET_CAR_BY_ID = "SELECT cars.id, cars.price, cars.car_model_id from cars WHERE car.id=?";
    private final static String GET_CARS_ALL = "SELECT cars.id, cars.price, cars.car_model_id from cars";
    private final static String INSERT_CAR = "INSERT into cars (cars.price, cars.car_model_id) VALUES (?,?)";
    private final static String UPDATE_CAR_BY_ID = "UPDATE cars SET car.price =? WHERE car.id=?";
    private final static String DELETE_CAR_BY_ID = "DELETE from cars WHERE id=?";

    private Car setFieldsForCar(ResultSet result, Car car) {
	try {
	    car.setId(result.getLong("id"));
	    car.setPrice(result.getInt("price"));
	    car.setCarModel(CarModel.getById(result.getInt("car_model_id")));
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	}
	return car;
    }


    @Override
    public Car getById(Long id) {
	connection = getConnection();
	Car car = new Car();
	try (Statement statement = connection.createStatement()) {
	    try (ResultSet result = statement.executeQuery(GET_CAR_BY_ID)) {
		if (result.next()) {
		    setFieldsForCar(result, car);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return car;
    }
    
    @Override
    public Car getCarByContractId(Long idContract) {
 	connection = getConnection();
 	Car car = new Car();
 	try (PreparedStatement preparedStatement = connection.prepareStatement(GET_CAR_BY_CONTRACT_ID)) {
	    preparedStatement.setLong(1, idContract);
	    try (ResultSet result = preparedStatement.executeQuery()) {
 		 
 		if (result.next()) {
 		    setFieldsForCar(result, car);
 		}
 	    } catch (SQLException e) {
 		lOGGER.error(e.getMessage());
 	    }
 	} catch (SQLException e) {
 	    lOGGER.error(e.getMessage());
 	} finally {
 	    LazyConnectionPool.getInstance().releaseConnection(connection);
 	}
 	return car;
     }

    @Override
    public List<Car> getAll() {
	connection = getConnection();
	List<Car> carList = new ArrayList<>();
	try (Statement statement = connection.createStatement()) {
	    try (ResultSet result = statement.executeQuery(GET_CARS_ALL)) {
		while (result.next()) {
		    Car car = new Car();
		    setFieldsForCar(result, car);
		    carList.add(car);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return carList;
    }

    @Override
    public List<Car> getCarByCarProviderId(Long id) {
	connection = getConnection();
	List<Car> carList = new ArrayList<>();
	try (PreparedStatement preparedStatement = connection.prepareStatement(GET_CARS_BY_CAR_PROVIDER_ID)) {
	    preparedStatement.setLong(1, id);
	    try (ResultSet result = preparedStatement.executeQuery()) {
		while (result.next()) {
		    Car car = new Car();
		    setFieldsForCar(result, car);
		    carList.add(car);
		}
	    } catch (SQLException e) {
		lOGGER.error(e.getMessage());
	    }
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
	return carList;
    }

    @Override
    public void add(Car car) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CAR)) {
	    preparedStatement.setInt(1, car.getPrice());
	    preparedStatement.setInt(2, car.getCarModel().getId());
	    preparedStatement.setLong(3, car.getCarProvider().getId());
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
	try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAR_BY_ID)) {
	    preparedStatement.setLong(1, id);
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }
    @Override
    public void update(Car car) {
	connection = getConnection();
	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAR_BY_ID)) {
	    preparedStatement.setInt(1, car.getPrice());
	    preparedStatement.setLong(2, car.getId());
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	} finally {
	    LazyConnectionPool.getInstance().releaseConnection(connection);
	}
    }

}
