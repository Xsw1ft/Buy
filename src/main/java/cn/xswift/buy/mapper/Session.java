package cn.xswift.buy.mapper;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Session {

	protected static SqlSessionFactory getSqlSessionFactory() throws IOException {

		//´´½¨SessionFactory
		String resource = "cn/xswift/buy/mapper/mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		return sqlSessionFactory;

	}

}

