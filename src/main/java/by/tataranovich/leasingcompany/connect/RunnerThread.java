package by.tataranovich.leasingcompany.connect;

//import org.apache.logging.log4j.Level;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class RunnerThread {
    //private static final Logger lOGGER = LogManager.getLogger(RunnerThread.class);
    public static void main(String[] args) throws InterruptedException {
	int countMyThread = 10;
	System.out.println("fged");
	for (int i = 1; i < countMyThread; i++) {
	    MyThread myThread = new MyThread("MyThread " + i);
	    myThread.start();
	}
	System.out.println("fged");
    }
}
