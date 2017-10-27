package ru.cbr.database.manage;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ru.cbr.model.Bnkseek;

public class BnkseekDAO {

	private SqlSessionFactory sqlSessionFactory = null;

	public BnkseekDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@SuppressWarnings("unchecked")
	public  List<Bnkseek> selectAll(){
		List<Bnkseek> list = null;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			list = session.selectList("Bnkseek.selectAll");
		} finally {
			session.close();
		}
		return list;

	}

	public Bnkseek selectByVkey(String vkey){
		Bnkseek bnkseek = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			bnkseek = session.selectOne("Bnkseek.selectByVkey", vkey);

		} finally {
			session.close();
		}
		return bnkseek;
	} 

	public Bnkseek selectByNewnum(String newnum){
		Bnkseek bnkseek = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			bnkseek = session.selectOne("Bnkseek.selectByNewnum", newnum);

		} finally {
			session.close();
		}
		return bnkseek;
	} 
	
	public List<Bnkseek> selectFilter(HashMap<String, String> map){
		List<Bnkseek> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			list = session.selectList("Bnkseek.selectFilter", map);
		} finally {
			session.close();
		}
		return list;
	} 
	
	public int insert(Bnkseek bnkseek){
		int id = -1;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			id = session.insert("Bnkseek.insert", bnkseek);
		} finally {
			session.commit();
			session.close();
		}
		return id;
	}

	public void update(Bnkseek bnkseek){
		int id = -1;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			id = session.update("Bnkseek.update", bnkseek);

		} finally {
			session.commit();
			session.close();
		}
	}


	public void delete(String vkey){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("Bnkseek.delete", vkey);
		} finally {
			session.commit();
			session.close();
		}
	}
}
