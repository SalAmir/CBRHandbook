package ru.cbr.model;

public class Tnp {
	private String vkey = null;
	private String tnp = null;
	private String fullname = null;
	private String shortname = null;
	
	public Tnp(String vkey, String tnp, String fullname, String shortname) {
		this.vkey = vkey;
		this.tnp = tnp;
		this.fullname = fullname;
		this.shortname = shortname;
	}

	public String getVkey() {
		return vkey;
	}

	public void setVkey(String vkey) {
		this.vkey = vkey;
	}

	public String getTnp() {
		return tnp;
	}

	public void setTnp(String tnp) {
		this.tnp = tnp;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	
	public String getgetFullnameAtTnp(String value) {
		if (tnp.equals(value))
			return fullname;
		
		return "";
	}
}
