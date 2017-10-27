package ru.cbr.model;

public class Reg {
	private String vkey = null;
	private String rgn = null;
	private String name = null;
	private String center = null;
	private String namet = null;
	
	public Reg(String vkey, String rgn, String name, String center, String namet) {
		super();
		this.vkey = vkey;
		this.rgn = rgn;
		this.name = name;
		this.center = center;
		this.namet = namet;
	}

	public String getVkey() {
		return vkey;
	}

	public void setVkey(String vkey) {
		this.vkey = vkey;
	}

	public String getRgn() {
		return rgn;
	}

	public void setRgn(String rgn) {
		this.rgn = rgn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getNamet() {
		return namet;
	}

	public void setNamet(String namet) {
		this.namet = namet;
	}
	
	public String getNameAtReg(String value) {
		if (rgn.equals(value))
			return name;
		
		return "";
	}
}
