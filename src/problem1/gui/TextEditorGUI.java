package problem1.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import problem1.business_logic.TextDemo;

public class TextEditorGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private TextDemo textDemo = new TextDemo();

	private JPanel contentPane;
	private JPanel panel;
	private JTextArea textAreaEditor;
	private JLabel lblFileName;
	private JTextField textFieldNameEntry;
	private JButton btnRead;
	private JButton btnDelete;
	private JButton btnSave;
	private JButton btnZameni;
	private JButton btnTextAnalysis;
	private JButton btnIzadji;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextEditorGUI frame = new TextEditorGUI();
					frame.setVisible(true);
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
		setTitle("Text Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.WEST);
		contentPane.add(getTextAreaEditor(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(120, 10));
			panel.add(getLblFIleName());
			panel.add(getTextFieldNameEntry());
			panel.add(getBtnRead());
			panel.add(getBtnDelete());
			panel.add(getBtnSave());
			panel.add(getBtnReplace());
			panel.add(getBtnTextAnalysis());
			panel.add(getBtnExit());
		}
		return panel;
	}

	private JTextArea getTextAreaEditor() {
		if (textAreaEditor == null) {
			textAreaEditor = new JTextArea();
		}
		return textAreaEditor;
	}

	private JLabel getLblFIleName() {
		if (lblFileName == null) {
			lblFileName = new JLabel("File name:");
		}
		return lblFileName;
	}

	private JTextField getTextFieldNameEntry() {
		if (textFieldNameEntry == null) {
			textFieldNameEntry = new JTextField();
			textFieldNameEntry.setPreferredSize(new Dimension(100, 20));
			textFieldNameEntry.setColumns(10);
		}
		return textFieldNameEntry;
	}

	private JButton getBtnRead() {
		if (btnRead == null) {
			btnRead = new JButton("Read");
			btnRead.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String name = textFieldNameEntry.getText();
					try {
						String text = textDemo.readText(name);
						textAreaEditor.setText(text);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error reading file contents.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnRead.setPreferredSize(new Dimension(100, 23));
		}
		return btnRead;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textAreaEditor.setText("");
				}
			});
			btnDelete.setPreferredSize(new Dimension(100, 23));
		}
		return btnDelete;
	}

	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Save");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String text = textAreaEditor.getText();
					String name = textFieldNameEntry.getText();
					try {
						textDemo.writeText(name, text);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error writing to the file.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnSave.setPreferredSize(new Dimension(100, 23));
		}
		return btnSave;
	}

	private JButton getBtnReplace() {
		if (btnZameni == null) {
			btnZameni = new JButton("Replace");
			btnZameni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ReplaceDialog dialog = new ReplaceDialog(TextEditorGUI.this);
					dialog.setVisible(true);
				}
			});
			btnZameni.setPreferredSize(new Dimension(100, 23));
		}
		return btnZameni;
	}
	
	private boolean isWhiteSpace(char c) {
		return c == ' ' || c == '\n' || c == '\r';
	}

	private JButton getBtnTextAnalysis() {
		if (btnTextAnalysis == null) {
			btnTextAnalysis = new JButton("Analysis");
			btnTextAnalysis.setActionCommand("Analysis");
			btnTextAnalysis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String text = textAreaEditor.getText();
					int charCount = text.length();
					
					int wordCount = 0;
					for (int i = 0; i < text.length(); i++) {
						if(isWhiteSpace(text.charAt(i)))
							wordCount++;
					}
					
					if (!isWhiteSpace(text.charAt(text.length()-1)))
						wordCount++;
					
					StringBuffer message = new StringBuffer("Number of characters: ");
					message.append(charCount).append(", number of words: ").append(wordCount);
					
					JOptionPane.showMessageDialog(rootPane, message.toString(), 
							"Text Analysis", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			btnTextAnalysis.setPreferredSize(new Dimension(100, 23));
		}
		return btnTextAnalysis;
	}

	private JButton getBtnExit() {
		if (btnIzadji == null) {
			btnIzadji = new JButton("Exit");
			btnIzadji.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int response = JOptionPane.showConfirmDialog(null, "Would you like to exit the program?", "Confirm",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (response == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}
			});
			btnIzadji.setPreferredSize(new Dimension(100, 23));
		}
		return btnIzadji;
	}

	public void replaceString(String replaceWith, String replace) {
		String text = textAreaEditor.getText();
		String newText = text.replaceAll(replaceWith, replace);
		textAreaEditor.setText(newText);
	}

}
