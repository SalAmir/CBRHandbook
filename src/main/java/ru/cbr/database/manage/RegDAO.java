package ru.cbr.database.manage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ru.cbr.model.Reg;

public class RegDAO {

	private SqlSessionFactory sqlSessionFactory = null;

	public RegDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@SuppressWarnings("unchecked")
	public  List<Reg> selectAll(){
		List<Reg> list = null;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			list = session.selectList("Reg.selectAll");
		} finally {
			session.close();
		}
		return list;

	}

	public Reg selectByVkey(String vkey){
		Reg reg = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			reg = session.selectOne("Reg.selectByVkey", vkey);
		} finally {
			session.close();
		}
		return reg;
	} 
}
