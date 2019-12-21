package problem1.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReplaceDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField replaceField;
	private JTextField replaceWithField;
	
	private TextEditorGUI mainWindow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReplaceDialog dialog = new ReplaceDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ReplaceDialog(TextEditorGUI glavniProzor) {
		this();
		this.mainWindow = glavniProzor;
	}
	
	/**
	 * Create the dialog.
	 */
	public ReplaceDialog() {
		setTitle("Replace string");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Replace in string:");
		lblNewLabel.setBounds(28, 37, 113, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Replace with string:");
		lblNewLabel_1.setBounds(28, 90, 113, 14);
		contentPanel.add(lblNewLabel_1);
		
		replaceField = new JTextField();
		replaceField.setBounds(151, 34, 127, 20);
		contentPanel.add(replaceField);
		replaceField.setColumns(10);
		
		replaceWithField = new JTextField();
		replaceWithField.setBounds(151, 87, 127, 20);
		contentPanel.add(replaceWithField);
		replaceWithField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String replaceIn= replaceField.getText().trim();
						String replaceWith = replaceWithField.getText().trim();
						mainWindow.replaceString(replaceIn, replaceWith);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
		