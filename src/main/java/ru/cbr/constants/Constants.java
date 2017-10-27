package ru.cbr.constants;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import ru.cbr.connection.MyBatisConnectionFactory;
//import ru.cbr.database.manage.Manage;
import ru.cbr.database.manage.PznDAO;
import ru.cbr.database.manage.RealDAO;
import ru.cbr.database.manage.RegDAO;
import ru.cbr.database.manage.TnpDAO;
import ru.cbr.database.manage.UerDAO;
import ru.cbr.model.Pzn;
import ru.cbr.model.Real;
import ru.cbr.model.Reg;
import ru.cbr.model.Tnp;
import ru.cbr.model.Uer;

public class Constants {
	
	public static SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();

	public static PznDAO pznDAO = new PznDAO(sqlSessionFactory);
	public static RealDAO realDAO = new RealDAO(sqlSessionFactory);
	public static RegDAO regDAO = new RegDAO(sqlSessionFactory);
	public static TnpDAO tnpDAO = new TnpDAO(sqlSessionFactory);
	public static UerDAO uerDAO = new UerDAO(sqlSessionFactory);
	
	public static List<Pzn> pznValues = pznDAO.selectAll();
	public static List<Real> realValues = realDAO.selectAll();
	public static List<Tnp> tnpValues = tnpDAO.selectAll();
	public static List<Reg> regValues = regDAO.selectAll();
	public static List<Uer> uerValues = uerDAO.selectAll();
}
