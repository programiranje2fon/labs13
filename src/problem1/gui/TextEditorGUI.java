package problem1.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JTextField;

import problem1.poslovna_logika.TextDemo;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TextEditorGUI {

	private JFrame frmeditor;
	private JTextField textFieldNameEntry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextEditorGUI window = new TextEditorGUI();
					window.frmeditor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TextEditorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmeditor = new JFrame();
		frmeditor.setTitle("Editor 2");
		frmeditor.setBounds(100, 100, 450, 300);
		frmeditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmeditor.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		frmeditor.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JTextArea textAreaEditor = new JTextArea();
		scrollPane.setViewportView(textAreaEditor);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(120, 36));
		frmeditor.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblFileName = new JLabel("File name");
		lblFileName.setPreferredSize(new Dimension(100, 16));
		panel.add(lblFileName);
		
		textFieldNameEntry = new JTextField();
		panel.add(textFieldNameEntry);
		textFieldNameEntry.setColumns(10);
		
		JButton btnRead = new JButton("Read");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextDemo td = new TextDemo();
				String name = textFieldNameEntry.getText();
				String text = td.readText(name);
				textAreaEditor.setText(text);
			}
		});
		btnRead.setPreferredSize(new Dimension(100, 26));
		panel.add(btnRead);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaEditor.setText(null);
			}
		});
		btnDelete.setPreferredSize(new Dimension(100, 26));
		panel.add(btnDelete);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextDemo td = new TextDemo();
				String text = textAreaEditor.getText();
				String name = textFieldNameEntry.getText();
				td.writeText(name, text);				
			}
		});
		btnSave.setPreferredSize(new Dimension(100, 26));
		panel.add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		btnExit.setPreferredSize(new Dimension(100, 26));
		panel.add(btnExit);
	}

}
