package ru.cbr.database.manage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ru.cbr.model.Uer;

public class UerDAO {

	private SqlSessionFactory sqlSessionFactory = null;

	public UerDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@SuppressWarnings("unchecked")
	public  List<Uer> selectAll(){
		List<Uer> list = null;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			list = session.selectList("Uer.selectAll");
		} finally {
			session.close();
		}
		return list;

	}

	public Uer selectByVkey(String vkey){
		Uer uer = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			uer = session.selectOne("Uer.selectByVkey", vkey);
		} finally {
			session.close();
		}
		return uer;
	} 
}
