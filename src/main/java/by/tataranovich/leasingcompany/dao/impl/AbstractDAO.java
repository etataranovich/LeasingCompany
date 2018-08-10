package by.tataranovich.leasingcompany.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tataranovich.leasingcompany.connect.LazyConnectionPool;

public abstract class AbstractDAO<T> {
    private static final Logger lOGGER = LogManager.getLogger(AbstractDAO.class);
    Connection connection = null;

    public static SqlSessionFactory getSqlSessionFactory() {
	String resource = "src\\main\\resources\\mybatis.xml";
	InputStream inputStream = null;
	try {
	    inputStream = Resources.getResourceAsStream(resource);
	} catch (IOException e) {
	    lOGGER.error(e.getMessage());
	}
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	return sqlSessionFactory;
    }

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
