package by.tataranovich.leasingcompany.connect;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tataranovich.leasingcompany.dao.IAddressDAO;
import by.tataranovich.leasingcompany.dao.impl.AbstractDAO;
import by.tataranovich.leasingcompany.model.Address;

public class RunnerMyBatis {
    
    private static final Logger lOGGER = LogManager.getLogger(RunnerMyBatis.class);
    
    public static void main(String[] args) {

	// @Override
	// public void add(Address address) {
	// SqlSession session = null;
	// try {
	// session = getSqlSessionFactory().openSession();
	// session.insert("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisAddressDao.add",
	// address);
	// session.commit();
	// } finally {
	// close(session);
	// }
	// }
	//

	SqlSessionFactory sqlSessionFactory;
	IAddressDAO addressDAO;
	InputStream is = null;

	// Reader reader = null;
	try {
	    // is = Resources.getResourceAsStream("src\\main\\resources\\mybatis2.xml");
	    is = Resources.getResourceAsStream(getClass().getResource("src\\main\\resources\\mybatis.xml"));

	    sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	    addressDAO = sqlSessionFactory.openSession().getMapper(IAddressDAO.class);
	    List<Address> addresses = addressDAO.getAll();
	    Address address = addressDAO.getById((long) 1);
	    System.out.println(address);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public static SqlSessionFactory getSqlSessionFactory() {
	String resource = "mybatis.xml";
	InputStream inputStream = null;
	try {
	    inputStream = Resources.getResourceAsStream(resource);
	} catch (IOException e) {
	    lOGGER.error(e.getMessage());
	}
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	return sqlSessionFactory;
    }

}
