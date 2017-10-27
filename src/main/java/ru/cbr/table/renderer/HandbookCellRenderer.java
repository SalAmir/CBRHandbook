package ru.cbr.table.renderer;

import java.awt.Color;
import java.awt.Component;
import java.sql.Date;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import ru.cbr.helper.CollectionHelper;
import ru.cbr.model.Bnkseek;
import ru.cbr.table.model.HandbookModel;

public class HandbookCellRenderer implements TableCellRenderer {

	private JLabel renderer = new JLabel();
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		renderer.setIcon(null);
		renderer.setOpaque(true);
		renderer.setFont(table.getFont());
		table.setSelectionForeground(Color.WHITE);
		Color theBackground = table.getBackground();
		Color theForeground = table.getForeground();
		String theText = (value != null) ? value.toString() : "";
		String columnName = table.getColumnName(column);
		HandbookModel model = (HandbookModel)table.getModel();
		Bnkseek bnkseek = model.getBnkseek(row);
		
		if ("REAL".equals(columnName)) 
			theText = CollectionHelper.getDisplayNameReal(theText);
		else if ("PZN".equals(columnName)) 
			theText = CollectionHelper.getDisplayNamePzn(theText);
		else if ("UER".equals(columnName)) 
			theText = CollectionHelper.getDisplayNameUer(theText);
		else if ("RGN".equals(columnName)) 
			theText = CollectionHelper.getDisplayNameReg(theText);
		else if ("TNP".equals(columnName)) 
			theText = CollectionHelper.getDisplayNameTnp(theText);
		
		if (value instanceof Date) {
			Date date = (Date)value;
			theText = date.toLocaleString();
		}
		
		if (!isSelected) {
			renderer.setBackground(bnkseek.getColor());
			renderer.setForeground(theForeground);
		}
		else {
			renderer.setBackground(table.getSelectionBackground());
			renderer.setForeground(table.getSelectionForeground());
		}
		
		renderer.setText(theText);
		renderer.setHorizontalAlignment(JLabel.LEFT);
		return renderer;
	}

}
