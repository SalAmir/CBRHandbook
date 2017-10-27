package ru.cbr.helper;

import java.util.List;

import ru.cbr.constants.Constants;
import ru.cbr.model.Pzn;
import ru.cbr.model.Real;
import ru.cbr.model.Reg;
import ru.cbr.model.Tnp;
import ru.cbr.model.Uer;

public class ComboboxValues {
	
	public static String[] getRealValues() {
		List<Real> list = Constants.realValues;
		String[] values = new String[list.size()];
		int i = 0;
		for (Real real : list) {
			values[i++] = real.getName_ogr();
		}
		return values;
	}
	
	public static String[] getPznValues() {
		List<Pzn> list = Constants.pznValues;
		String[] values = new String[list.size()];
		int i = 0;
		for (Pzn pzn : list) {
			values[i++] = pzn.getName();
		}
		return values;
	}
	
	public static String[] getRegValues() {
		List<Reg> list = Constants.regValues;
		String[] values = new String[list.size()];
		int i = 0;
		for (Reg reg : list) {
			values[i++] = reg.getName();
		}
		return values;
	}
	
	public static String[] getTnpValues() {
		List<Tnp> list = Constants.tnpValues;
		String[] values = new String[list.size()];
		int i = 0;
		for (Tnp tnp : list) {
			values[i++] = tnp.getFullname();
		}
		return values;
	}
	
	public static String[] getUerValues() {
		List<Uer> list = Constants.uerValues;
		String[] values = new String[list.size()];
		int i = 0;
		for (Uer uer : list) {
			values[i++] = uer.getUername();
		}
		return values;
	}
}
