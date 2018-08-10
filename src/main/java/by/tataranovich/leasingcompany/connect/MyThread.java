package by.tataranovich.leasingcompany.connect;

import java.sql.Connection;
import java.util.Random;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread extends Thread {

    private static final Logger lOGGER = LogManager.getLogger(MyThread.class);
    private LazyConnectionPool lazyConnectionPool;

    public MyThread(String name) {
	super(name);
	lazyConnectionPool = LazyConnectionPool.getInstance();
    }

    @Override
    public void run() {
	Connection connection = null;
	Random random = new Random();
	lOGGER.log(Level.INFO, "Run Thread " + Thread.currentThread().getName());
	try {
	    connection = lazyConnectionPool.getConnection();
	    lOGGER.log(Level.INFO, "The connection was TAKEN by " + Thread.currentThread().getName());
	    Thread.sleep(2000 + random.nextInt(1000));
	} catch (InterruptedException e) {
	    lOGGER.log(Level.ERROR, "Thread error in User");
	} finally {
	    lazyConnectionPool.releaseConnection(connection);
	    lOGGER.log(Level.INFO, "The connection was REALEASED by " + Thread.currentThread().getName());
	}
    }
}
