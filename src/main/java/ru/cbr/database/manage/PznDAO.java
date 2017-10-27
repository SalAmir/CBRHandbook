package ru.cbr.database.manage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ru.cbr.model.Pzn;

public class PznDAO {

	private SqlSessionFactory sqlSessionFactory = null;

	public PznDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@SuppressWarnings("unchecked")
	public  List<Pzn> selectAll(){
		List<Pzn> list = null;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			list = session.selectList("Pzn.selectAll");
		} finally {
			session.close();
		}
		return list;

	}

	public Pzn selectByVkey(String vkey){
		Pzn pzn = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			pzn = session.selectOne("Pzn.selectByVkey", vkey);
		} finally {
			session.close();
		}
		return pzn;
	} 
}
