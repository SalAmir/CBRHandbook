package ru.cbr.model;

import java.sql.Date;

public class Pzn {
	private String vkey = null;
	private String pzn = null;
	private String imy = null;
	private String name = null;
	private Date cb_date = null;
	private Date ce_date = null;
	
	public Pzn(String vkey, String pzn, String imy, String name, Date cb_date, Date ce_date) {
		this.vkey = vkey;
		this.pzn = pzn;
		this.imy = imy;
		this.name = name;
		this.cb_date = cb_date;
		this.ce_date = ce_date;
	}

	public String getVkey() {
		return vkey;
	}

	public void setVkey(String vkey) {
		this.vkey = vkey;
	}

	public String getPzn() {
		return pzn;
	}

	public void setPzn(String pzn) {
		this.pzn = pzn;
	}

	public String getImy() {
		return imy;
	}

	public void setImy(String imy) {
		this.imy = imy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCb_date() {
		return cb_date;
	}

	public void setCb_date(Date cb_date) {
		this.cb_date = cb_date;
	}

	public Date getCe_date() {
		return ce_date;
	}

	public void setCe_date(Date ce_date) {
		this.ce_date = ce_date;
	}
}
