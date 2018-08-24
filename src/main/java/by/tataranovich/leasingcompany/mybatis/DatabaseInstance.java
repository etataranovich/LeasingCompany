package by.tataranovich.leasingcompany.mybatis;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseInstance {
    private static final Logger lOGGER = LogManager.getLogger(DatabaseInstance.class);
    private static DatabaseInstance INSTANCE = null;
    private SqlSessionFactory factory;


    private DatabaseInstance() {
	String resource = "mybatis.xml";
	try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
	    this.factory = new SqlSessionFactoryBuilder().build(inputStream);
	} catch (IOException e) {
	    lOGGER.error(e.getMessage());
	}
    }

    public SqlSessionFactory getFactory() {
	return this.factory;
    }

    public static DatabaseInstance getInstance() {
	if (INSTANCE == null)
	    INSTANCE = new DatabaseInstance();
	return INSTANCE;
    }

}


