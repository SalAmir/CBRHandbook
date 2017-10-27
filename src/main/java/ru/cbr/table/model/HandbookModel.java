package ru.cbr.table.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ru.cbr.helper.CollectionHelper;
import ru.cbr.helper.DateParser;
import ru.cbr.model.Bnkseek;

public class HandbookModel extends AbstractTableModel {

	private List<Bnkseek> listBnkseek = null;
	private List<String> columnNames = new ArrayList<String>();
	
	public HandbookModel(List<Bnkseek> listBnkseek, List<String> columnNames) {
		this.listBnkseek = listBnkseek;
		this.columnNames = columnNames;
	}
	
	public void updateTable(List<Bnkseek> listBnkseek) {
		this.listBnkseek = listBnkseek;
		fireTableDataChanged();
	}
	
	public Bnkseek getBnkseek(int row) {
		return listBnkseek.get(row);
	}
	
	public int getIndexObject(Bnkseek bnkseek) {
		return listBnkseek.indexOf(bnkseek);
	}
	
	public void remove(int row) {
		listBnkseek.remove(row);
		((ArrayList)listBnkseek).trimToSize();
		fireTableRowsDeleted(row, row);
	}
	
	public void removeAll() {
		listBnkseek.clear();
		((ArrayList)listBnkseek).trimToSize();
		fireTableDataChanged();
	}
	
	public void add(Bnkseek bnkseek) {
		listBnkseek.add(bnkseek);
	}
	
	public void clearData() {
		listBnkseek.clear();
		((ArrayList)listBnkseek).trimToSize();
	}

	public int getRowCount() {
		return listBnkseek.size();
	}

	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public String getColumnName(int column) {
		return columnNames.get(column);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Bnkseek bnkseek = listBnkseek.get(rowIndex);
		if (!bnkseek.isChanged())
			bnkseek.setChanged(true);
		
		String colName = getColumnName(columnIndex);
		if ("REAL".equals(colName)) 
			bnkseek.setReal(CollectionHelper.getReal(aValue.toString()));
		else if ("PZN".equals(colName)) 
			bnkseek.setPzn(CollectionHelper.getPzn(aValue.toString()));
		else if ("TNP".equals(colName)) 
			bnkseek.setTnp(CollectionHelper.getTnp(aValue.toString()));
		else if ("UER".equals(colName)) 
			bnkseek.setUer(CollectionHelper.getUer(aValue.toString()));
		else if ("RGN".equals(colName)) 
			bnkseek.setRgn(CollectionHelper.getReg(aValue.toString()));
		else if ("IND".equals(colName)) 
			bnkseek.setInd(aValue.toString());
		else if ("NNP".equals(colName)) 
			bnkseek.setNnp(aValue.toString());
		else if ("ADR".equals(colName)) 
			bnkseek.setAdr(aValue.toString());
		else if ("RKC".equals(colName)) 
			bnkseek.setRkc(aValue.toString());
		else if ("NAMEP".equals(colName)) 
			bnkseek.setNamep(aValue.toString());
		else if ("NEWNUM".equals(colName)) 
			bnkseek.setNewnum(aValue.toString());	
		else if ("TELEF".equals(colName)) 
			bnkseek.setTelef(aValue.toString());
		else if ("REGN".equals(colName)) 
			bnkseek.setRegn(aValue.toString());
		else if ("OKPO".equals(colName)) 
			bnkseek.setOkpo(aValue.toString());
		else if ("DT_IZM".equals(colName))
			bnkseek.setDtIzm(DateParser.getDate(aValue.toString()));
		else if ("KSNP".equals(colName)) 
			bnkseek.setKsnp(aValue.toString());
		else if ("DATE_IN".equals(colName)) 
			bnkseek.setDateIn(DateParser.getDate(aValue.toString()));
		else if ("DATE_CH".equals(colName)) 
			bnkseek.setDateCh(DateParser.getDate(aValue.toString()));
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Bnkseek bnkseek = listBnkseek.get(rowIndex);
		String colName = columnNames.get(columnIndex);
		
		if ("REAL".equals(colName)) 
			return listBnkseek.get(rowIndex).getReal();
		else if ("PZN".equals(colName)) 
			return listBnkseek.get(rowIndex).getPzn();
		else if ("UER".equals(colName)) 
			return listBnkseek.get(rowIndex).getUer();
		else if ("RGN".equals(colName)) 
			return listBnkseek.get(rowIndex).getRgn();
		else if ("IND".equals(colName)) 
			return bnkseek.getInd();
		else if ("TNP".equals(colName)) 
			return listBnkseek.get(rowIndex).getTnp();
		else if ("NNP".equals(colName)) 
			return bnkseek.getNnp();
		else if ("ADR".equals(colName)) 
			return bnkseek.getAdr();
		else if ("RKC".equals(colName)) 
			return bnkseek.getRkc();
		else if ("NAMEP".equals(colName)) 
			return bnkseek.getNamep();
		else if ("NEWNUM".equals(colName)) 
			return bnkseek.getNewnum();
		else if ("TELEF".equals(colName)) 
			return bnkseek.getTelef();
		else if ("REGN".equals(colName)) 
			return bnkseek.getRegn();
		else if ("OKPO".equals(colName)) 
			return bnkseek.getOkpo();
		else if ("DT_IZM".equals(colName)) 
			return bnkseek.getDtIzm();
		else if ("KSNP".equals(colName)) 
			return bnkseek.getKsnp();
		else if ("DATE_IN".equals(colName)) 
			return bnkseek.getDateIn();
		else if ("DATE_CH".equals(colName)) 
			return bnkseek.getDateCh();
		
		return "";
	}
}
