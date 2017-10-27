package ru.cbr.database.manage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ru.cbr.model.Real;

public class RealDAO {

	private SqlSessionFactory sqlSessionFactory = null;

	public RealDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@SuppressWarnings("unchecked")
	public  List<Real> selectAll(){
		List<Real> list = null;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			list = session.selectList("Real.selectAll");
		} finally {
			session.close();
		}
		return list;

	}

	public Real selectByVkey(String vkey){
		Real real = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			real = session.selectOne("Real.selectByVkey", vkey);
		} finally {
			session.close();
		}
		return real;
	} 
}
