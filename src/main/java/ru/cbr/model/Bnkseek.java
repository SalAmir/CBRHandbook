package ru.cbr.model;

import java.awt.Color;
import java.sql.Date;

import ru.cbr.database.manage.BnkseekDAO;
import ru.cbr.random.generator.Generator;

public class Bnkseek {
	
	private String vkey = "";
	private String real = "";
	private String pzn = "";
	private String uer = "";
	private String reg = "";
	private String ind = "";
	private String tnp = "";
	private String nnp = "";
	private String adr = "";
	private String rkc = "";
	private String namep = "";
	private String newnum = "";
	private String telef = "";
	private String regn = "";
	private String okpo = "";
	private Date dt_izm = null;
	private String ksnp = "";
	private Date date_in = null;
	private Date date_ch = null;
	private boolean isChanged = false;
	private Color color = Color.WHITE;
	
	public Bnkseek(String vkey, String real, String pzn, String uer, String reg, String ind, String tnp, String nnp, String adr, String rkc,
			String namep, String newnum, String telef, String regn, String okpo, Date dtIzm, String ksnp, Date dateIn, Date dateCh) {
		this.vkey = vkey.trim();
		this.real = real.trim();
		this.pzn = pzn.trim();
		this.uer = uer.trim();
		this.reg = reg.trim();
		this.ind = ind.trim();
		this.tnp = tnp.trim();
		this.nnp = nnp.trim();
		this.adr = adr.trim();
		this.rkc = rkc.trim();
		this.namep = namep.trim();
		this.newnum = newnum.trim();
		this.telef = telef.trim();
		this.regn = regn.trim();
		this.okpo = okpo.trim();
		this.dt_izm = dtIzm;
		this.ksnp = ksnp.trim();
		this.date_in = dateIn;
		this.date_ch = dateCh;
	}
	
	public Bnkseek(BnkseekDAO bnkseekDAO) {
		String getVkey = Generator.getRandomString(8, 8);
		String getNewnum = Generator.getRandomString(9);
		while (bnkseekDAO.selectByVkey(getVkey) != null) {
			getVkey = Generator.getRandomString(8, 8);
		}
		while (bnkseekDAO.selectByNewnum(getNewnum) != null) {
			getNewnum = Generator.getRandomString(9);
		}
		this.vkey = getVkey;
		this.newnum = getNewnum;
		this.dt_izm = new Date(0, 0, 0);
		this.date_in = new Date(0, 0, 0);
	}
	
	public Bnkseek(){}
	
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
	
	public String getPzn() {
		return pzn;
	}
	
	public void setPzn(String pzn) {
		this.pzn = pzn;
	}
	
	public String getUer() {
		return uer;
	}
	
	public void setUer(String uer) {
		this.uer = uer;
	}
	
	public String getRgn() {
		return reg;
	}
	
	public void setRgn(String reg) {
		this.reg = reg;
	}

	public String getInd() {
		return ind;
	}
	
	public void setInd(String ind) {
		this.ind = ind;
	}
	
	public String getTnp() {
		return tnp;
	}
	
	public void setTnp(String tnp) {
		this.tnp = tnp;
	}

	public String getNnp() {
		return nnp;
	}
	
	public void setNnp(String nnp) {
		this.nnp = nnp;
	}
	
	public String getAdr() {
		return adr;
	}
	
	public void setAdr(String adr) {
		this.adr = adr;
	}
	
	public String getRkc() {
		return rkc;
	}
	
	public void setRkc(String rkc) {
		this.rkc = rkc;
	}
	
	public String getNamep() {
		return namep;
	}
	
	public void setNamep(String namep) {
		this.namep = namep;
	}
	
	public String getNewnum() {
		return newnum;
	}
	
	public void setNewnum(String newnum) {
		this.newnum = newnum;
	}
	
	public String getTelef() {
		return telef;
	}
	
	public void setTelef(String telef) {
		this.telef = telef;
	}
	
	public String getRegn() {
		return regn;
	}
	
	public void setRegn(String regn) {
		this.regn = regn;
	}
	
	public String getOkpo() {
		return okpo;
	}
	
	public void setOkpo(String okpo) {
		this.okpo = okpo;
	}
	
	public Date getDtIzm() {
		return dt_izm;
	}
	
	public void setDtIzm(Date dt_izm) {
		this.dt_izm = dt_izm;
	}
	
	public String getKsnp() {
		return ksnp;
	}
	
	public void setKsnp(String ksnp) {
		this.ksnp = ksnp;
	}
	
	public Date getDateIn() {
		return date_in;
	}
	
	public void setDateIn(Date date_in) {
		this.date_in = date_in;
	}
	
	public Date getDateCh() {
		return date_ch;
	}
	
	public void setDateCh(Date date_ch) {
		this.date_ch = date_ch;
	}
	
	public boolean isChanged() {
		return isChanged;
	}
	
	public void setChanged(boolean isChanged) {
		this.isChanged = isChanged;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
