package ru.cbr.model;

public class Real {
	private String vkey = null;
	private String real = null;
	private String name_ogr = null;
	
	public Real(String vkey, String real, String name_ogr) {
		this.vkey = vkey;
		this.real = real;
		this.name_ogr = name_ogr;
	}

	public String getVkey() {
		return vkey;
	}

	public void setVkey(String vkey) {
		this.vkey = vkey;
	}

	public String getReal() {
		return real;
	}

	public void setReal(String real) {
		this.real = real;
	}

	public String getName_ogr() {
		return name_ogr;
	}

	public void setName_ogr(String name_ogr) {
		this.name_ogr = name_ogr;
	}
	
	public String getNameAtReal(String value) {
		if (real.equals(value))
			return name_ogr;
		
		return "";
	}
}
