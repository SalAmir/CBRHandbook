package ru.cbr.table;

import javax.swing.DefaultCellEditor;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTable;

import ru.cbr.constants.Constants;
import ru.cbr.database.manage.BnkseekDAO;
import ru.cbr.database.manage.PznDAO;
import ru.cbr.database.manage.RealDAO;
import ru.cbr.database.manage.RegDAO;
import ru.cbr.database.manage.TnpDAO;
import ru.cbr.database.manage.UerDAO;
import ru.cbr.helper.CollectionHelper;
import ru.cbr.helper.ComboboxValues;
import ru.cbr.helper.FieldList;
import ru.cbr.helper.WiderDropDownCombo;
import ru.cbr.model.Bnkseek;
import ru.cbr.model.Pzn;
import ru.cbr.model.Real;
import ru.cbr.table.model.HandbookModel;
import ru.cbr.table.renderer.HandbookCellRenderer;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.apache.ibatis.session.SqlSessionFactory;

import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import java.awt.Rectangle;
import javax.swing.SwingConstants;

public class Handbook extends JPanel {

	private JTable table = null;
	private HandbookModel handbookModel = null;
	private JTextField txtFdRgn;
	private JTextField txtFdBIK;
	private JCheckBox chckbxRgn;
	private JCheckBox chckbxBIK;
	private JCheckBox chckbxType;
	private WiderDropDownCombo<String> comboBoxType;
	
	public Handbook() {
		final BnkseekDAO bnkseekDAO = new BnkseekDAO(Constants.sqlSessionFactory);
		
		setMinimumSize(new Dimension(1000, 450));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{945, 0};
		gridBagLayout.rowHeights = new int[]{137, 213, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);

		JLabel lblNewLabel = new JLabel("Фильтры:");

		JSplitPane splitPane = new JSplitPane();

		JSplitPane splitPane_1 = new JSplitPane();

		JSplitPane splitPane_2 = new JSplitPane();

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(new Rectangle(0, 0, 3, 0));

		JButton btnAdd = new JButton("Добавить строку");
		btnAdd.setHorizontalTextPosition(SwingConstants.LEFT);
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bnkseek bnkseek = new Bnkseek(bnkseekDAO);
				bnkseek.setChanged(true);
				bnkseekDAO.insert(bnkseek);
				handbookModel.add(bnkseek);
				int index = handbookModel.getIndexObject(bnkseek);
				if (index == -1)
					return;

				handbookModel.fireTableDataChanged();
				table.setRowSelectionInterval(index, index);
			}
		});

		JButton btnDelete = new JButton("Удалить строку");
		btnDelete.setHorizontalTextPosition(SwingConstants.LEFT);
		btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selRows = table.getSelectedRows();
				for (int i = 0; i < selRows.length; i++) {
					int row = selRows[i];
					if (row == -1 || row >= handbookModel.getRowCount())
						return;

					bnkseekDAO.delete(handbookModel.getBnkseek(row).getVkey());
					handbookModel.remove(row);
				}
			}
		});

		JButton btnUpdate = new JButton("Обновить выделенные строки");
		btnUpdate.setHorizontalTextPosition(SwingConstants.LEFT);
		btnUpdate.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selRows = table.getSelectedRows(); {
					for (int i = 0; i < selRows.length; i++) {
						Bnkseek bnkseek = handbookModel.getBnkseek(selRows[i]);
						bnkseekDAO.update(bnkseek);
					}
				}
			}
		});

		JButton btnUpdateAll = new JButton("Обновить всё");
		btnUpdateAll.setHorizontalTextPosition(SwingConstants.LEFT);
		btnUpdateAll.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdateAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < handbookModel.getRowCount(); i++) {
					Bnkseek bnkseek = handbookModel.getBnkseek(i);
					if (bnkseek.isChanged())
						bnkseekDAO.update(bnkseek);
				}
			}
		});
		
		JButton btnNewButton = new JButton("Выполнить");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executeFilter(bnkseekDAO);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Загрузить полностью");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handbookModel.updateTable(bnkseekDAO.selectAll());
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(190))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(splitPane_2, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
								.addComponent(splitPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(28)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDelete))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnUpdateAll)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1))
						.addComponent(btnUpdate))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnAdd)
										.addComponent(btnDelete))
									.addGap(13)
									.addComponent(btnUpdate)
									.addGap(9)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnUpdateAll)
										.addComponent(btnNewButton_1)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(splitPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(splitPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addGap(1))))
		);

		chckbxBIK = new JCheckBox("БИК      ");
		splitPane_2.setLeftComponent(chckbxBIK);

		txtFdBIK = new JTextField();
		splitPane_2.setRightComponent(txtFdBIK);
		txtFdBIK.setColumns(10);

		txtFdRgn = new JTextField();
		splitPane_1.setRightComponent(txtFdRgn);
		txtFdRgn.setColumns(10);

		chckbxRgn = new JCheckBox("Регион");
		splitPane_1.setLeftComponent(chckbxRgn);

		chckbxType = new JCheckBox("Тип       ");
		splitPane.setLeftComponent(chckbxType);

		comboBoxType = new WiderDropDownCombo<String>(ComboboxValues.getPznValues());
		comboBoxType.setWide(true);
		splitPane.setRightComponent(comboBoxType);
		panel.setLayout(gl_panel);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 10, 10, 10);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);

		WiderDropDownCombo<String> realCombobox = new WiderDropDownCombo<String>(ComboboxValues.getRealValues());
		realCombobox.setWide(true);

		WiderDropDownCombo<String> pznCombobox = new WiderDropDownCombo<String>(ComboboxValues.getPznValues());
		pznCombobox.setWide(true);

		WiderDropDownCombo<String> uerCombobox = new WiderDropDownCombo<String>(ComboboxValues.getUerValues());
		uerCombobox.setWide(true);

		WiderDropDownCombo<String> rgnCombobox = new WiderDropDownCombo<String>(ComboboxValues.getRegValues());
		rgnCombobox.setWide(true);

		WiderDropDownCombo<String> tnpCombobox = new WiderDropDownCombo<String>(ComboboxValues.getTnpValues());
		tnpCombobox.setWide(true);

		handbookModel = new HandbookModel(bnkseekDAO.selectAll(), Arrays.asList("REAL", "PZN", "UER", "RGN", "IND", "TNP", "NNP", "ADR",
				"RKC", "NAMEP", "NEWNUM", "TELEF", "REGN", "OKPO", "DT_IZM", "KSNP", "DATE_IN", "DATE_CH"));

		table = new JTable(handbookModel);
		table.getColumn("REAL").setCellEditor(new DefaultCellEditor(realCombobox));
		table.getColumn("PZN").setCellEditor(new DefaultCellEditor(pznCombobox));
		table.getColumn("UER").setCellEditor(new DefaultCellEditor(uerCombobox));
		table.getColumn("RGN").setCellEditor(new DefaultCellEditor(rgnCombobox));
		table.getColumn("TNP").setCellEditor(new DefaultCellEditor(tnpCombobox));
		table.setDefaultRenderer(Object.class, new HandbookCellRenderer());
		scrollPane.setViewportView(table);
	}
	
	private void executeFilter(BnkseekDAO bnkseekDAO) {
		if (!chckbxBIK.isSelected() && !chckbxRgn.isSelected() && !chckbxType.isSelected())
			return;
		
		HashMap<String, String> map = new HashMap<String, String>();
		if (chckbxBIK.isSelected()) 
			map.put("bik", txtFdBIK.getText());
		if (chckbxRgn.isSelected()) 
			map.put("rgn", txtFdRgn.getText());
		if (chckbxType.isSelected()) 
			map.put("type", CollectionHelper.getPzn(comboBoxType.getSelectedItem().toString()));
		
		List<Bnkseek> listFilter = bnkseekDAO.selectFilter(map);
		if (listFilter == null || listFilter.isEmpty()) {
			JOptionPane.showConfirmDialog(this, "По заданным критериям ничего не найдено", "Поиск", JOptionPane.YES_OPTION);
			return;
		}

		handbookModel.updateTable(listFilter);
	}
}
