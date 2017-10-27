package ru.cbr.main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import ru.cbr.table.Handbook;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JFrame frame = new JFrame();
				frame.setContentPane(new Handbook());
				frame.setVisible(true);
				frame.setPreferredSize(new Dimension(1000, 450));
				frame.setMinimumSize(new Dimension(1000, 450));
				frame.setLocationRelativeTo(null);
				frame.setAlwaysOnTop(true);
			}
		});
	}
}
