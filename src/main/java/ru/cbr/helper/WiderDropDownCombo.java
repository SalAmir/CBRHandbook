package ru.cbr.helper;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class WiderDropDownCombo<E> extends JComboBox<E> {
	private String type = null;
	private int widestLengh = 0;
	private boolean layingOut = false;
	private boolean wide = false;

	public WiderDropDownCombo() {
		super(new DefaultComboBoxModel<E>());
	}
	
	public WiderDropDownCombo(E[] objs) {
		super(new DefaultComboBoxModel<E>(objs));
	}
	
	public WiderDropDownCombo(ComboBoxModel<E> aModel) {
		super(aModel);
	}
	
	public boolean isWide() {
		return wide;
	}

	public void setWide(boolean wide) {
		this.wide = wide;
		widestLengh = getWidestItemWidth();
	}

	public Dimension getSize() {
		Dimension dim = super.getSize();
		if (!layingOut && isWide())
			dim.width = Math.max(widestLengh, dim.width);
		return dim;
	}

	public int getWidestItemWidth() {
		int numOfItems = this.getItemCount();
		Font font = this.getFont();
		FontMetrics metrics = this.getFontMetrics(font);
		int widest = 0;
		for (int i = 0; i < numOfItems; i++) {
			Object item = this.getItemAt(i);
			int lineWidth = metrics.stringWidth(item.toString());
			widest = Math.max(widest, lineWidth);
		}

		return widest + 5;
	}

	public void doLayout() {
		try {
			layingOut = true;
			super.doLayout();
		} finally {
			layingOut = false;
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String t) {
		type = t;
	}
}
