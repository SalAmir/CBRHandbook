package ru.cbr.helper;

import java.util.List;

import ru.cbr.constants.Constants;
import ru.cbr.model.Pzn;
import ru.cbr.model.Real;
import ru.cbr.model.Reg;
import ru.cbr.model.Tnp;
import ru.cbr.model.Uer;

public class CollectionHelper {
	public static String getDisplayNameReal(String realName) {
		List<Real> list = Constants.realValues;
		if (list == null || list.isEmpty())
			return null;
		
		for (Real real : list) {
			if (realName.trim().equals(real.getReal().trim()))
				return real.getName_ogr().trim();
		}
		return null;
	}

	public static String getReal(String displayName) {
		List<Real> list = Constants.realValues;
		if (list == null || list.isEmpty())
			return null;
		
		for (Real real : list) {
			if (displayName.trim().equals(real.getName_ogr().trim()))
				return real.getReal();
		}
		return null;
	}
	
	public static String getDisplayNameTnp(String tnpName) {
		List<Tnp> list = Constants.tnpValues;
		if (list == null || list.isEmpty())
			return null;
		
		for (Tnp tnp : list) {
			if (tnpName.trim().equals(tnp.getTnp().trim()))
				return tnp.getFullname().trim();
		}
		return null;
	}

	public static String getTnp(String displayName) {
		List<Tnp> list = Constants.tnpValues;
		if (list == null || list.isEmpty())
			return null;
		
		for (Tnp tnp : list) {
			if (displayName.trim().equals(tnp.getFullname().trim()))
				return tnp.getTnp();
		}
		return null;
	}
	
	public static String getDisplayNamePzn(String pznName) {
		List<Pzn> list = Constants.pznValues;
		if (list == null || list.isEmpty())
			return null;
		
		for (Pzn pzn : list) {
			if (pznName.trim().equals(pzn.getPzn().trim()))
				return pzn.getName().trim();
		}
		return null;
	}

	public static String getPzn(String displayName) {
		List<Pzn> list = Constants.pznValues;
		if (list == null || list.isEmpty())
			return null;
		
		for (Pzn pzn : list) {
			if (displayName.trim().equals(pzn.getName().trim()))
				return pzn.getPzn();
		}
		return null;
	}
	
	public static String getDisplayNameReg(String rgnName) {
		List<Reg> list = Constants.regValues;
		if (list == null || list.isEmpty())
			return null;
		
		for (Reg rgn : list) {
			if (rgnName.trim().equals(rgn.getRgn().trim()))
				return rgn.getName().trim();
		}
		return null;
	}
	
	public static String getReg(String displayName) {
		List<Reg> list = Constants.regValues;
		if (list == null || list.isEmpty())
			return null;
		
		for (Reg rgn : list) {
			if (displayName.trim().equals(rgn.getName().trim()))
				return rgn.getRgn();
		}
		return null;
	}
	
	public static String getDisplayNameUer(String rgnName) {
		List<Uer> list = Constants.uerValues;
		if (list == null || list.isEmpty())
			return null;
		
		for (Uer uer : list) {
			if (rgnName.trim().equals(uer.getUer().trim()))
				return uer.getUername().trim();
		}
		return null;
	}
	
	public static String getUer(String displayName) {
		List<Uer> list = Constants.uerValues;
		if (list == null || list.isEmpty())
			return null;
		
		for (Uer uer : list) {
			if (displayName.trim().equals(uer.getUername().trim()))
				return uer.getUer();
		}
		return null;
	}
}
