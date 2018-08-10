package by.tataranovich.leasingcompany.connect;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LazyConnectionPool {
    private static final Logger lOGGER = LogManager.getLogger(LazyConnectionPool.class);
    private static LazyConnectionPool INSTANCE;
    private BlockingQueue<Connection> connectionPool;
    private AtomicInteger capacity;
    // private int currentCountConnection;
    private String url;
    private String user;
    private String password;
    private Connection connection = null;
    private Properties props;

    private final Object lock1 = new Object();

    private LazyConnectionPool() {
	try (FileInputStream cfg = new FileInputStream("src\\main\\resources\\database.properties")) {
	    props = new Properties();
	    props.load(cfg);
	    url = props.getProperty("jdbc.url");
	    user = props.getProperty("jdbc.username");
	    password = props.getProperty("jdbc.password");
	    capacity = new AtomicInteger(Integer.parseInt(props.getProperty("capacity")));
	    connectionPool = new ArrayBlockingQueue<Connection>(capacity.get());
	} catch (IOException e2) {
	    lOGGER.error(e2.getMessage());
	}
    }

    public static LazyConnectionPool getInstance() {
	if (INSTANCE == null)
	    INSTANCE = new LazyConnectionPool();
	return INSTANCE;
    }

    public Connection getConnection() throws InterruptedException {
	if (capacity.get() > 0) {
	    synchronized (lock1) {
		// double check locking
		if (capacity.get() > 0) {
		    capacity.decrementAndGet();
		    return createNewConnection();
		} else {
		    return getConnectionFromPool();
		}
	    }
	} else {
	    return getConnectionFromPool();
	}
    }

    public Connection getConnectionFromPool() throws InterruptedException {
	long start = System.currentTimeMillis();
	Connection connection = connectionPool.take();
	long end = System.currentTimeMillis();
	lOGGER.info(String.format("Waiting for %s seconds to get connection", (end - start) / 1000d));
	System.out.println(String.format("Waiting for %s seconds to get connection", (end - start) / 1000d));
	return connection;
    }

    public void releaseConnection(Connection connection) {
	if (connection != null) {
	    connectionPool.add(connection);
	    capacity.decrementAndGet();
	}
    }

    private Connection createNewConnection() {
	try {
	    connection = DriverManager.getConnection(url, user, password);
	} catch (SQLException e) {
	    lOGGER.error(e.getMessage());
	}
	return connection;
    }
}

// public Connection getConnection() throws InterruptedException {
// if (connectionPool.isEmpty() && (maxConnections > 0)) {
// connectionPool.add(open());
// maxConnections--;
// }
// return connectionPool.take();
// }

// remove
// protected void close(AutoCloseable resourse) {
// if (resourse != null)
// try {
// resourse.close();
// } catch (Exception e) {
// lOGGER.error(e.getMessage());
// }
// }
// }

// public void close() {
// connectionPool.forEach(Connection::close);
// }

/*
 * public static LazyConnectionPool getInstance() { Lock l = new
 * ReentrantLock(); l.lock(); try { if (INSTANCE == null) { INSTANCE = new
 * LazyConnectionPool(); } return INSTANCE; } finally { l.unlock(); } }
 */

// try
// with resources?

// private LazyConnectionPool() {
// //props = new Properties();
// // FileInputStream cfg = null;
// try (FileInputStream cfg = new FileInputStream("resources\\properties")) {
// Properties props = new Properties();
// props.load(cfg);
// } catch (FileNotFoundException e2) {
// lOGGER.error(e2.getMessage());
// } catch (IOException e2) {
// lOGGER.error(e2.getMessage());
// }
// url = props.getProperty("jdbc.url");
// user = props.getProperty("jdbc.username");
// password = props.getProperty("jdbc.password");
// capacity = new
// AtomicInteger(Integer.parseInt(props.getProperty("capacity")));
// connectionPool = new ArrayBlockingQueue<Connection>(capacity.get());
// }
