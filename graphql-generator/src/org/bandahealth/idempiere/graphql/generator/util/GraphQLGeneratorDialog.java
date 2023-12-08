/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 2010 Heng Sin Low                							  *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 *****************************************************************************/
package org.bandahealth.idempiere.graphql.generator.util;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

import javax.swing.*;

/**
 * @author hengsin
 */
public class GraphQLGeneratorDialog extends JFrame implements ActionListener {

	/**
	 * default generated serial version Id
	 */
	private static final long serialVersionUID = 3546051609729699491L;
	private JButton generateButton;
	private JButton cancelButton;
	private JButton getSchemaFolderButton;
	private JButton getInputModelFolderButton;
	private JButton getCustomModelFolderButton;
	private JTextField schemaFolderField;
	private JTextField fPackageName;
	private JTextField fTableName;
	private JCheckBox generateSchemaCheckbox;
	private JCheckBox generateInputModelCheckbox;
	private JCheckBox fGenerateInterface;
	private JCheckBox fGenerateClass;
	private JTextField fEntityType;
	private JTextField fColumnEntityType;
	private JTextField inputModelDirectoryNameField;
	private JTextField inputModelPackageNameField;
	private JTextField customModelDirectoryNameField;
	private JTextField customModelPackageField;

	public GraphQLGeneratorDialog() {
		super();
		setTitle("GraphQL Generator");
		this.getContentPane().setLayout(new BorderLayout());
		Panel confirmPanel = new Panel();
		this.getContentPane().add(confirmPanel, BorderLayout.SOUTH);
		Panel mainPanel = new Panel();
		this.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridBagLayout());

		mainPanel.add(new JLabel("Table Name"), makeGbc(0, 0));
		fTableName = new JTextField("AD_ReplaceThis%");
		mainPanel.add(fTableName, makeGbc(1, 0));

		mainPanel.add(new JLabel("Table Entity Type"), makeGbc(0, 1));
		fEntityType = new JTextField("D");
		mainPanel.add(fEntityType, makeGbc(1, 1));

		mainPanel.add(new JLabel("Column Entity Type"), makeGbc(0, 2));
		fColumnEntityType = new JTextField("");
		mainPanel.add(fColumnEntityType, makeGbc(1, 2));

		String defaultPath = Path.of("").toAbsolutePath().getParent().getParent().toString();

		Panel filePanel = new Panel();
		filePanel.setLayout(new BorderLayout());
		customModelDirectoryNameField = new JTextField(defaultPath);
		filePanel.add(customModelDirectoryNameField, BorderLayout.CENTER);
		getCustomModelFolderButton = new JButton("...");
		getCustomModelFolderButton.setMargin(new Insets(0, 0, 0, 0));
		filePanel.add(getCustomModelFolderButton, BorderLayout.EAST);
		mainPanel.add(new JLabel("Custom Model Folder"), makeGbc(0, 3));
		mainPanel.add(filePanel, makeGbc(1, 3));
		getCustomModelFolderButton.addActionListener(this);

		mainPanel.add(new JLabel("Custom Model Package Name"), makeGbc(0, 4));
		customModelPackageField = new JTextField("org.bandahealth.idempiere.base.model");
		mainPanel.add(customModelPackageField, makeGbc(1, 4));

		Panel chkPanel = new Panel();
		chkPanel.setLayout(new GridLayout(1, 2));
		mainPanel.add(new JLabel(""), makeGbc(0, 5));
		mainPanel.add(chkPanel, makeGbc(1, 5));
		generateSchemaCheckbox = new JCheckBox("Generate Schema");
		generateSchemaCheckbox.setSelected(true);
		chkPanel.add(generateSchemaCheckbox);

		filePanel = new Panel();
		filePanel.setLayout(new BorderLayout());
		schemaFolderField = new JTextField(defaultPath);
		filePanel.add(schemaFolderField, BorderLayout.CENTER);
		getSchemaFolderButton = new JButton("...");
		getSchemaFolderButton.setMargin(new Insets(0, 0, 0, 0));
		filePanel.add(getSchemaFolderButton, BorderLayout.EAST);
		mainPanel.add(new JLabel("Schema Directory"), makeGbc(0, 6));
		mainPanel.add(filePanel, makeGbc(1, 6));
		getSchemaFolderButton.addActionListener(this);

		chkPanel = new Panel();
		chkPanel.setLayout(new GridLayout(1, 2));
		mainPanel.add(new JLabel(""), makeGbc(0, 7));
		mainPanel.add(chkPanel, makeGbc(1, 7));
		generateInputModelCheckbox = new JCheckBox("Generate Input Models");
		generateInputModelCheckbox.setSelected(true);
		chkPanel.add(generateInputModelCheckbox);

		filePanel = new Panel();
		filePanel.setLayout(new BorderLayout());
		inputModelDirectoryNameField = new JTextField(defaultPath);
		filePanel.add(inputModelDirectoryNameField, BorderLayout.CENTER);
		getInputModelFolderButton = new JButton("...");
		getInputModelFolderButton.setMargin(new Insets(0, 0, 0, 0));
		filePanel.add(getInputModelFolderButton, BorderLayout.EAST);
		mainPanel.add(new JLabel("Input Model Folder"), makeGbc(0, 8));
		mainPanel.add(filePanel, makeGbc(1, 8));
		getInputModelFolderButton.addActionListener(this);

		mainPanel.add(new JLabel("Input Model Package Name"), makeGbc(0, 9));
		inputModelPackageNameField = new JTextField("org.bandahealth.idempiere.graphql.model.input");
		mainPanel.add(inputModelPackageNameField, makeGbc(1, 9));

//		chkPanel = new Panel();
//		chkPanel.setLayout(new GridLayout(1, 2));
//		mainPanel.add(new JLabel(""), makeGbc(0, 5));
//		mainPanel.add(chkPanel, makeGbc(1, 5));
//		fGenerateInterface = new JCheckBox("Generate Interface");
//		fGenerateInterface.setSelected(true);
//		chkPanel.add(fGenerateInterface);
//		fGenerateClass = new JCheckBox("Generate Class");
//		fGenerateClass.setSelected(true);
//		chkPanel.add(fGenerateClass);

		generateButton = new JButton("Generate Source");
		confirmPanel.add(generateButton);
		cancelButton = new JButton("Cancel");
		confirmPanel.add(cancelButton);
		generateButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}

	private GridBagConstraints makeGbc(int x, int y) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.weightx = x;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(2, 2, 2, 2);
		gbc.anchor = (x == 0) ? GridBagConstraints.LINE_START : GridBagConstraints.LINE_END;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		return gbc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == generateButton) {
			String tableName = fTableName.getText();
			if (tableName == null || tableName.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please enter table name", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String schemaFolder = "";
			if (generateSchemaCheckbox.isSelected()) {
				schemaFolder = schemaFolderField.getText();
				if (schemaFolder == null || schemaFolder.trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Please enter schema folder name", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			String inputModelFolder = "";
			String inputModelPackageName = "";
			String customModelFolderName = customModelDirectoryNameField.getText();
			String customModelPackageName = customModelPackageField.getText();
			if (generateInputModelCheckbox.isSelected()) {
				inputModelFolder = inputModelDirectoryNameField.getText();
				if (inputModelFolder == null || inputModelFolder.trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Please enter input model folder name", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				inputModelPackageName = inputModelPackageNameField.getText();
				if (inputModelPackageName == null || inputModelPackageName.trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Please enter input model package name", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			String entityType = fEntityType.getText();
			if (!generateSchemaCheckbox.isSelected() && !generateInputModelCheckbox.isSelected()) {
				JOptionPane.showMessageDialog(this, "Must select at least one of thing to generate",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String columnEntityType = fColumnEntityType.getText();
			this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			if (generateSchemaCheckbox.isSelected()) {
				GraphQLSchemaGenerator.generateSource(entityType, tableName, columnEntityType, schemaFolder);
			}
			if (generateInputModelCheckbox.isSelected()) {
				GraphQLInputModelGenerator.generateSource(entityType, tableName, columnEntityType, inputModelFolder,
						inputModelPackageName, customModelFolderName, customModelPackageName);
			}
			this.dispose();
		} else if (e.getSource() == cancelButton) {
			this.dispose();
		} else if (e.getSource() == getSchemaFolderButton) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(Path.of(schemaFolderField.getText()).toFile());
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int state = fileChooser.showOpenDialog(this);
			if (state == JFileChooser.APPROVE_OPTION) {
				schemaFolderField.setText(fileChooser.getSelectedFile().getAbsolutePath());
			}
		} else if (e.getSource() == getInputModelFolderButton) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(Path.of(inputModelDirectoryNameField.getText()).toFile());
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int state = fileChooser.showOpenDialog(this);
			if (state == JFileChooser.APPROVE_OPTION) {
				inputModelDirectoryNameField.setText(fileChooser.getSelectedFile().getAbsolutePath());
			}
		} else if (e.getSource() == getCustomModelFolderButton) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(Path.of(customModelDirectoryNameField.getText()).toFile());
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int state = fileChooser.showOpenDialog(this);
			if (state == JFileChooser.APPROVE_OPTION) {
				customModelDirectoryNameField.setText(fileChooser.getSelectedFile().getAbsolutePath());
			}
		}
	}

}
