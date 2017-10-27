package ru.cbr.model;

public class Uer {
	private String vkey = null;
	private String uer = null;
	private String uername = null;
	
	public Uer(String vkey, String uer, String uername) {
		super();
		this.vkey = vkey;
		this.uer = uer;
		this.uername = uername;
	}

	public String getVkey() {
		return vkey;
	}

	public void setVkey(String vkey) {
		this.vkey = vkey;
	}

	public String getUer() {
		return uer;
	}

	public void setUer(String uer) {
		this.uer = uer;
	}

	public String getUername() {
		return uername;
	}

	public void setUername(String uername) {
		this.uername = uername;
	}
	
	public String getUernameAtUer(String value) {
		if (uer.equals(value))
			return uername;
		
		return "";
	}
} 
