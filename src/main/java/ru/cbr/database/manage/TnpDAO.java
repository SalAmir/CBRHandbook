package ru.cbr.database.manage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ru.cbr.model.Tnp;

public class TnpDAO {

	private SqlSessionFactory sqlSessionFactory = null;

	public TnpDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@SuppressWarnings("unchecked")
	public  List<Tnp> selectAll(){
		List<Tnp> list = null;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			list = session.selectList("Tnp.selectAll");
		} finally {
			session.close();
		}
		return list;

	}

	public Tnp selectByVkey(String vkey){
		Tnp tnp = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			tnp = session.selectOne("Tnp.selectByVkey", vkey);
		} finally {
			session.close();
		}
		return tnp;
	} 
}
