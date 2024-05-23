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
package org.bandahealth.idempiere.base.graphql.util;

import org.bandahealth.idempiere.base.model.MBHGraphqlGeneratorTemplate;
import org.bandahealth.idempiere.base.utils.StringUtil;
import org.compiere.model.Query;
import org.compiere.util.Env;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GraphQLGeneratorDialog extends JFrame implements ActionListener {

	/**
	 * default generated serial version Id
	 */
	private static final long serialVersionUID = 3546051609729699491L;
	private final JButton generateButton;
	private final JButton cancelButton;
	private final JButton getSchemaFolderButton;
	private final JButton getInputModelFolderButton;
	private final JButton getCustomModelFolderButton;
	private final JButton getQueryResolverFolderButton;
	private final JButton getMutationResolverFolderButton;
	private final JButton getModelResolverFolderButton;
	private final JButton getDataLoaderFolderButton;
	private final JTextField schemaFolderField;
	private final JTextField fTableName;
	private final JCheckBox generateSchemaCheckbox;
	private final JCheckBox generateInputModelCheckbox;
	private final JCheckBox generateQueryResolverCheckbox;
	private final JCheckBox generateMutationResolverCheckbox;
	private final JCheckBox generateModelResolverCheckbox;
	private final JCheckBox generateDataLoaderCheckbox;
	private final JTextField fEntityType;
	private final JTextField fColumnEntityType;
	private final JTextField inputModelDirectoryNameField;
	private final JTextField inputModelPackageNameField;
	private final JTextField customModelDirectoryNameField;
	private final JTextField customModelPackageField;
	private final JTextField queryResolverDirectoryNameField;
	private final JTextField queryResolverPackageField;
	private final JTextField mutationResolverDirectoryNameField;
	private final JTextField mutationResolverPackageField;
	private final JTextField modelResolverDirectoryNameField;
	private final JTextField modelResolverPackageField;
	private final JTextField dataLoaderDirectoryNameField;
	private final JTextField dataLoaderPackageField;
	private final JComboBox<String> generatorTemplates;
	private final List<MBHGraphqlGeneratorTemplate> templates;

	public GraphQLGeneratorDialog() {
		super();
		setTitle("GraphQL Generator");
		this.getContentPane().setLayout(new BorderLayout());
		Panel confirmPanel = new Panel();
		this.getContentPane().add(confirmPanel, BorderLayout.SOUTH);
		Panel mainPanel = new Panel();
		this.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridBagLayout());

		int yPosition = 0;
		mainPanel.add(new JLabel("Template"), makeGbc(0, yPosition));
		templates =
				new Query(Env.getCtx(), MBHGraphqlGeneratorTemplate.Table_Name, null, null).setOnlyActiveRecords(true).list();
		List<String> templateNameSuggestions = new java.util.ArrayList<>(Collections.singletonList(""));
		templateNameSuggestions.addAll(templates.stream().map(MBHGraphqlGeneratorTemplate::getName).toList());
		generatorTemplates = new JComboBox<>(templateNameSuggestions.toArray(String[]::new));
		mainPanel.add(generatorTemplates, makeGbc(1, yPosition));
		generatorTemplates.addActionListener(this);

		yPosition++;
		mainPanel.add(new JLabel("Table Name"), makeGbc(0, yPosition));
		fTableName = new JTextField("AD_ReplaceThis%");
		mainPanel.add(fTableName, makeGbc(1, yPosition));

		yPosition++;
		mainPanel.add(new JLabel("Table Entity Type"), makeGbc(0, yPosition));
		fEntityType = new JTextField("D");
		mainPanel.add(fEntityType, makeGbc(1, yPosition));

		yPosition++;
		mainPanel.add(new JLabel("Column Entity Type"), makeGbc(0, yPosition));
		fColumnEntityType = new JTextField("");
		mainPanel.add(fColumnEntityType, makeGbc(1, yPosition));

		String defaultPath = Path.of("").toAbsolutePath().getParent().getParent().toString();

		yPosition++;
		Panel filePanel = new Panel();
		filePanel.setLayout(new BorderLayout());
		customModelDirectoryNameField = new JTextField(defaultPath);
		filePanel.add(customModelDirectoryNameField, BorderLayout.CENTER);
		getCustomModelFolderButton = new JButton("...");
		getCustomModelFolderButton.setMargin(new Insets(0, 0, 0, 0));
		filePanel.add(getCustomModelFolderButton, BorderLayout.EAST);
		mainPanel.add(new JLabel("Custom Model Folder"), makeGbc(0, yPosition));
		mainPanel.add(filePanel, makeGbc(1, yPosition));
		getCustomModelFolderButton.addActionListener(this);

		yPosition++;
		mainPanel.add(new JLabel("Custom Model Package Name"), makeGbc(0, yPosition));
		customModelPackageField = new JTextField("");
		mainPanel.add(customModelPackageField, makeGbc(1, yPosition));

		yPosition++;
		Panel chkPanel = new Panel();
		chkPanel.setLayout(new GridLayout(1, 2));
		mainPanel.add(new JLabel(""), makeGbc(0, yPosition));
		mainPanel.add(chkPanel, makeGbc(1, yPosition));
		generateSchemaCheckbox = new JCheckBox("Generate Schema");
		generateSchemaCheckbox.setSelected(true);
		chkPanel.add(generateSchemaCheckbox);

		yPosition++;
		filePanel = new Panel();
		filePanel.setLayout(new BorderLayout());
		schemaFolderField = new JTextField(defaultPath);
		filePanel.add(schemaFolderField, BorderLayout.CENTER);
		getSchemaFolderButton = new JButton("...");
		getSchemaFolderButton.setMargin(new Insets(0, 0, 0, 0));
		filePanel.add(getSchemaFolderButton, BorderLayout.EAST);
		mainPanel.add(new JLabel("Schema Directory"), makeGbc(0, yPosition));
		mainPanel.add(filePanel, makeGbc(1, yPosition));
		getSchemaFolderButton.addActionListener(this);

		yPosition++;
		chkPanel = new Panel();
		chkPanel.setLayout(new GridLayout(1, 2));
		mainPanel.add(new JLabel(""), makeGbc(0, yPosition));
		mainPanel.add(chkPanel, makeGbc(1, yPosition));
		generateInputModelCheckbox = new JCheckBox("Generate Input Models");
		generateInputModelCheckbox.setSelected(true);
		chkPanel.add(generateInputModelCheckbox);

		yPosition++;
		filePanel = new Panel();
		filePanel.setLayout(new BorderLayout());
		inputModelDirectoryNameField = new JTextField(defaultPath);
		filePanel.add(inputModelDirectoryNameField, BorderLayout.CENTER);
		getInputModelFolderButton = new JButton("...");
		getInputModelFolderButton.setMargin(new Insets(0, 0, 0, 0));
		filePanel.add(getInputModelFolderButton, BorderLayout.EAST);
		mainPanel.add(new JLabel("Input Model Folder"), makeGbc(0, yPosition));
		mainPanel.add(filePanel, makeGbc(1, yPosition));
		getInputModelFolderButton.addActionListener(this);

		yPosition++;
		mainPanel.add(new JLabel("Input Model Package Name"), makeGbc(0, yPosition));
		inputModelPackageNameField = new JTextField("");
		mainPanel.add(inputModelPackageNameField, makeGbc(1, yPosition));

		yPosition++;
		chkPanel = new Panel();
		chkPanel.setLayout(new GridLayout(1, 2));
		mainPanel.add(new JLabel(""), makeGbc(0, yPosition));
		mainPanel.add(chkPanel, makeGbc(1, yPosition));
		generateQueryResolverCheckbox = new JCheckBox("Generate Query Resolvers");
		generateQueryResolverCheckbox.setSelected(true);
		chkPanel.add(generateQueryResolverCheckbox);

		yPosition++;
		filePanel = new Panel();
		filePanel.setLayout(new BorderLayout());
		queryResolverDirectoryNameField = new JTextField(defaultPath);
		filePanel.add(queryResolverDirectoryNameField, BorderLayout.CENTER);
		getQueryResolverFolderButton = new JButton("...");
		getQueryResolverFolderButton.setMargin(new Insets(0, 0, 0, 0));
		filePanel.add(getQueryResolverFolderButton, BorderLayout.EAST);
		mainPanel.add(new JLabel("Query Resolver Folder"), makeGbc(0, yPosition));
		mainPanel.add(filePanel, makeGbc(1, yPosition));
		getQueryResolverFolderButton.addActionListener(this);

		yPosition++;
		mainPanel.add(new JLabel("Query Resolver Package Name"), makeGbc(0, yPosition));
		queryResolverPackageField = new JTextField("");
		mainPanel.add(queryResolverPackageField, makeGbc(1, yPosition));

		yPosition++;
		chkPanel = new Panel();
		chkPanel.setLayout(new GridLayout(1, 2));
		mainPanel.add(new JLabel(""), makeGbc(0, yPosition));
		mainPanel.add(chkPanel, makeGbc(1, yPosition));
		generateMutationResolverCheckbox = new JCheckBox("Generate Mutation Resolvers");
		generateMutationResolverCheckbox.setSelected(true);
		chkPanel.add(generateMutationResolverCheckbox);

		yPosition++;
		filePanel = new Panel();
		filePanel.setLayout(new BorderLayout());
		mutationResolverDirectoryNameField = new JTextField(defaultPath);
		filePanel.add(mutationResolverDirectoryNameField, BorderLayout.CENTER);
		getMutationResolverFolderButton = new JButton("...");
		getMutationResolverFolderButton.setMargin(new Insets(0, 0, 0, 0));
		filePanel.add(getMutationResolverFolderButton, BorderLayout.EAST);
		mainPanel.add(new JLabel("Mutation Resolver Folder"), makeGbc(0, yPosition));
		mainPanel.add(filePanel, makeGbc(1, yPosition));
		getMutationResolverFolderButton.addActionListener(this);

		yPosition++;
		mainPanel.add(new JLabel("Mutation Resolver Package Name"), makeGbc(0, yPosition));
		mutationResolverPackageField = new JTextField("");
		mainPanel.add(mutationResolverPackageField, makeGbc(1, yPosition));

		yPosition++;
		chkPanel = new Panel();
		chkPanel.setLayout(new GridLayout(1, 2));
		mainPanel.add(new JLabel(""), makeGbc(0, yPosition));
		mainPanel.add(chkPanel, makeGbc(1, yPosition));
		generateModelResolverCheckbox = new JCheckBox("Generate Model Resolvers");
		generateModelResolverCheckbox.setSelected(true);
		chkPanel.add(generateModelResolverCheckbox);

		yPosition++;
		filePanel = new Panel();
		filePanel.setLayout(new BorderLayout());
		modelResolverDirectoryNameField = new JTextField(defaultPath);
		filePanel.add(modelResolverDirectoryNameField, BorderLayout.CENTER);
		getModelResolverFolderButton = new JButton("...");
		getModelResolverFolderButton.setMargin(new Insets(0, 0, 0, 0));
		filePanel.add(getModelResolverFolderButton, BorderLayout.EAST);
		mainPanel.add(new JLabel("Model Resolver Folder"), makeGbc(0, yPosition));
		mainPanel.add(filePanel, makeGbc(1, yPosition));
		getModelResolverFolderButton.addActionListener(this);

		yPosition++;
		mainPanel.add(new JLabel("Model Resolver Package Name"), makeGbc(0, yPosition));
		modelResolverPackageField = new JTextField("");
		mainPanel.add(modelResolverPackageField, makeGbc(1, yPosition));

		yPosition++;
		chkPanel = new Panel();
		chkPanel.setLayout(new GridLayout(1, 2));
		mainPanel.add(new JLabel(""), makeGbc(0, yPosition));
		mainPanel.add(chkPanel, makeGbc(1, yPosition));
		generateDataLoaderCheckbox = new JCheckBox("Generate Data Loaders");
		generateDataLoaderCheckbox.setSelected(true);
		chkPanel.add(generateDataLoaderCheckbox);

		yPosition++;
		filePanel = new Panel();
		filePanel.setLayout(new BorderLayout());
		dataLoaderDirectoryNameField = new JTextField(defaultPath);
		filePanel.add(dataLoaderDirectoryNameField, BorderLayout.CENTER);
		getDataLoaderFolderButton = new JButton("...");
		getDataLoaderFolderButton.setMargin(new Insets(0, 0, 0, 0));
		filePanel.add(getDataLoaderFolderButton, BorderLayout.EAST);
		mainPanel.add(new JLabel("Data Loader Folder"), makeGbc(0, yPosition));
		mainPanel.add(filePanel, makeGbc(1, yPosition));
		getDataLoaderFolderButton.addActionListener(this);

		yPosition++;
		mainPanel.add(new JLabel("Data Loader Package Name"), makeGbc(0, yPosition));
		dataLoaderPackageField = new JTextField("");
		mainPanel.add(dataLoaderPackageField, makeGbc(1, yPosition));

		generateButton = new JButton("Generate Source");
		confirmPanel.add(generateButton);
		cancelButton = new JButton("Cancel");
		confirmPanel.add(cancelButton);
		generateButton.addActionListener(this);
		cancelButton.addActionListener(this);

		if (!templates.isEmpty()) {
			generatorTemplates.setSelectedIndex(1);
			updateFieldsWithTemplate(templates.get(0));
		}

		// Reset the size so that the boxes aren't too long
		SwingUtilities.invokeLater(() -> {
			pack();
			setSize(700, 750);
			setLocationRelativeTo(null);
		});
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
			String customModelFolderName = customModelDirectoryNameField.getText();
			String customModelPackageName = customModelPackageField.getText();
			Map<String, ModelMap> modelsForTables;
			try {
				modelsForTables = GraphQLUtil.getModelsForTables(customModelFolderName);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
			String inputModelFolder = "";
			String inputModelPackageName = "";
			if (generateInputModelCheckbox.isSelected() || generateMutationResolverCheckbox.isSelected()) {
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
			String queryResolverFolder = "";
			String queryResolverPackageName = "";
			if (generateQueryResolverCheckbox.isSelected()) {
				queryResolverFolder = queryResolverDirectoryNameField.getText();
				if (queryResolverFolder == null || queryResolverFolder.trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Please enter query resolver folder name", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				queryResolverPackageName = queryResolverPackageField.getText();
				if (queryResolverPackageName == null || queryResolverPackageName.trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Please enter query resolver package name", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			String mutationResolverFolder = "";
			String mutationResolverPackageName = "";
			if (generateMutationResolverCheckbox.isSelected()) {
				mutationResolverFolder = mutationResolverDirectoryNameField.getText();
				if (mutationResolverFolder == null || mutationResolverFolder.trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Please enter mutation resolver folder name", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				mutationResolverPackageName = mutationResolverPackageField.getText();
				if (mutationResolverPackageName == null || mutationResolverPackageName.trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Please enter mutation resolver package name", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			String dataLoaderFolder = "";
			String dataLoaderPackageName = "";
			if (generateDataLoaderCheckbox.isSelected() || generateModelResolverCheckbox.isSelected() ||
					generateQueryResolverCheckbox.isSelected()) {
				dataLoaderFolder = dataLoaderDirectoryNameField.getText();
				if (dataLoaderFolder == null || dataLoaderFolder.trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Please enter data loader folder name", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				dataLoaderPackageName = dataLoaderPackageField.getText();
				if (dataLoaderPackageName == null || dataLoaderPackageName.trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Please enter data loader package name", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			String modelResolverFolder = "";
			String modelResolverPackageName = "";
			if (generateModelResolverCheckbox.isSelected()) {
				modelResolverFolder = modelResolverDirectoryNameField.getText();
				if (modelResolverFolder == null || modelResolverFolder.trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Please enter model resolver folder name", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				modelResolverPackageName = modelResolverPackageField.getText();
				if (modelResolverPackageName == null || modelResolverPackageName.trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Please enter model resolver package name", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			String entityType = fEntityType.getText();
			if (!generateSchemaCheckbox.isSelected() && !generateInputModelCheckbox.isSelected() &&
					!generateQueryResolverCheckbox.isSelected() && !generateMutationResolverCheckbox.isSelected() &&
					!generateModelResolverCheckbox.isSelected() && !generateDataLoaderCheckbox.isSelected()) {
				JOptionPane.showMessageDialog(this, "Must select at least one of thing to generate",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Run the generators!
			String columnEntityType = fColumnEntityType.getText();
			this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			if (generateSchemaCheckbox.isSelected()) {
				GraphQLSchemaGenerator.generateSource(entityType, tableName, columnEntityType, schemaFolder);
			}
			if (generateInputModelCheckbox.isSelected()) {
				GraphQLInputModelInterfaceGenerator.generateSource(entityType, tableName, columnEntityType, inputModelFolder,
						inputModelPackageName, customModelFolderName, customModelPackageName, modelsForTables);
				GraphQLInputModelClassGenerator.generateSource(entityType, tableName, columnEntityType, inputModelFolder,
						inputModelPackageName, customModelFolderName, customModelPackageName, modelsForTables);
			}
			if (generateQueryResolverCheckbox.isSelected()) {
				GraphQLQueryResolverGenerator.generateSource(entityType, tableName, columnEntityType, queryResolverFolder,
						queryResolverPackageName, dataLoaderPackageName, modelsForTables);
			}
			if (generateMutationResolverCheckbox.isSelected()) {
				GraphQLMutationResolverGenerator.generateSource(entityType, tableName, mutationResolverFolder,
						mutationResolverPackageName, inputModelPackageName, modelsForTables);
			}
			if (generateModelResolverCheckbox.isSelected()) {
				GraphQLModelResolverGenerator.generateSource(entityType, tableName, columnEntityType,
						modelResolverFolder, modelResolverPackageName, dataLoaderPackageName, modelsForTables);
			}
			if (generateDataLoaderCheckbox.isSelected()) {
				GraphQLDataLoaderGenerator.generateSource(entityType, tableName, dataLoaderFolder, dataLoaderPackageName,
						modelsForTables);
			}
			this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
//			this.dispose();
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
		} else if (e.getSource() == getQueryResolverFolderButton) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(Path.of(queryResolverDirectoryNameField.getText()).toFile());
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int state = fileChooser.showOpenDialog(this);
			if (state == JFileChooser.APPROVE_OPTION) {
				queryResolverDirectoryNameField.setText(fileChooser.getSelectedFile().getAbsolutePath());
			}
		} else if (e.getSource() == getMutationResolverFolderButton) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(Path.of(mutationResolverDirectoryNameField.getText()).toFile());
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int state = fileChooser.showOpenDialog(this);
			if (state == JFileChooser.APPROVE_OPTION) {
				mutationResolverDirectoryNameField.setText(fileChooser.getSelectedFile().getAbsolutePath());
			}
		} else if (e.getSource() == getModelResolverFolderButton) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(Path.of(modelResolverDirectoryNameField.getText()).toFile());
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int state = fileChooser.showOpenDialog(this);
			if (state == JFileChooser.APPROVE_OPTION) {
				modelResolverDirectoryNameField.setText(fileChooser.getSelectedFile().getAbsolutePath());
			}
		} else if (e.getSource() == getDataLoaderFolderButton) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(Path.of(dataLoaderDirectoryNameField.getText()).toFile());
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int state = fileChooser.showOpenDialog(this);
			if (state == JFileChooser.APPROVE_OPTION) {
				dataLoaderDirectoryNameField.setText(fileChooser.getSelectedFile().getAbsolutePath());
			}
		} else if (e.getSource() == generatorTemplates) {
			// If we just selected the empty value, don't do anything
			MBHGraphqlGeneratorTemplate selectedTemplate;
			if (generatorTemplates.getSelectedIndex() == 0 || (selectedTemplate =
					templates.stream().filter(template -> template.getName().equals(generatorTemplates.getSelectedItem())).findFirst()
							.orElse(null)) == null) {
				return;
			}
			// Update all the fields accordingly
			updateFieldsWithTemplate(selectedTemplate);
		}
	}

	/**
	 * Based on the combobox selection, update the fields with whatever is saved in the selected template
	 *
	 * @param selectedTemplate The template to populate the fields with
	 */
	private void updateFieldsWithTemplate(MBHGraphqlGeneratorTemplate selectedTemplate) {
		if (!StringUtil.isNullOrEmpty(selectedTemplate.getTableName())) {
			fTableName.setText(selectedTemplate.getTableName());
		}
		if (!StringUtil.isNullOrEmpty(selectedTemplate.getTableEntityType())) {
			fEntityType.setText(selectedTemplate.getTableEntityType());
		}
		if (!StringUtil.isNullOrEmpty(selectedTemplate.getColumnEntityType())) {
			fColumnEntityType.setText(selectedTemplate.getColumnEntityType());
		}
		if (!StringUtil.isNullOrEmpty(selectedTemplate.getCustomModelFolder())) {
			customModelDirectoryNameField.setText(Path.of(selectedTemplate.getCustomModelFolder()).toString());
		}
		if (!StringUtil.isNullOrEmpty(selectedTemplate.getCustomModelPackageName())) {
			customModelPackageField.setText(selectedTemplate.getCustomModelPackageName());
		}
		if (!StringUtil.isNullOrEmpty(selectedTemplate.getSchemaFolder())) {
			schemaFolderField.setText(Path.of(selectedTemplate.getSchemaFolder()).toString());
		}
		if (!StringUtil.isNullOrEmpty(selectedTemplate.getInputModelFolder())) {
			inputModelDirectoryNameField.setText(Path.of(selectedTemplate.getInputModelFolder()).toString());
		}
		if (!StringUtil.isNullOrEmpty(selectedTemplate.getInputModelPackageName())) {
			inputModelPackageNameField.setText(selectedTemplate.getInputModelPackageName());
		}
		if (!StringUtil.isNullOrEmpty(selectedTemplate.getQueryResolverFolder())) {
			queryResolverDirectoryNameField.setText(Path.of(selectedTemplate.getQueryResolverFolder()).toString());
		}
		if (!StringUtil.isNullOrEmpty(selectedTemplate.getQueryResolverPackageName())) {
			queryResolverPackageField.setText(selectedTemplate.getQueryResolverPackageName());
		}
		if (!StringUtil.isNullOrEmpty(selectedTemplate.getMutationResolverFolder())) {
			mutationResolverDirectoryNameField.setText(Path.of(selectedTemplate.getMutationResolverFolder()).toString());
		}
		if (!StringUtil.isNullOrEmpty(selectedTemplate.getMutationResolverPackageName())) {
			mutationResolverPackageField.setText(selectedTemplate.getMutationResolverPackageName());
		}
		if (!StringUtil.isNullOrEmpty(selectedTemplate.getModelResolverFolder())) {
			modelResolverDirectoryNameField.setText(Path.of(selectedTemplate.getModelResolverFolder()).toString());
		}
		if (!StringUtil.isNullOrEmpty(selectedTemplate.getModelResolverPackageName())) {
			modelResolverPackageField.setText(selectedTemplate.getModelResolverPackageName());
		}
		if (!StringUtil.isNullOrEmpty(selectedTemplate.getDataLoaderFolder())) {
			dataLoaderDirectoryNameField.setText(Path.of(selectedTemplate.getDataLoaderFolder()).toString());
		}
		if (!StringUtil.isNullOrEmpty(selectedTemplate.getDataLoaderPackageName())) {
			dataLoaderPackageField.setText(selectedTemplate.getDataLoaderPackageName());
		}
	}
}
