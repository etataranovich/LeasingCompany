package by.tataranovich.deadlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static final Logger lOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
	Object lock1 = new Object();
	Object lock2 = new Object();
	ThreadDead1 threadDead1 = new ThreadDead1(lock1, lock2);
	ThreadDead2 threadDead2 = new ThreadDead2(lock1, lock2);
	threadDead1.start();
	threadDead2.start();
	lOGGER.info("smth bad has happened");
    }

}
 





 