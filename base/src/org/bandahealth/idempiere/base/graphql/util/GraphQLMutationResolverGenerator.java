/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2006 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 * Contributor(s): Carlos Ruiz - globalqss                                    *
 *                 Teo Sarca - www.arhipac.ro                                 *
 *                 Trifon Trifonov                                            *
 *****************************************************************************/
package org.bandahealth.idempiere.base.graphql.util;

import org.adempiere.exceptions.DBException;
import org.compiere.Adempiere;
import org.compiere.model.MTable;
import org.compiere.util.DB;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.TreeSet;

/**
 * Generate GraphQL mutation resolvers.
 *
 * @author Kevin Burnett
 */
public class GraphQLMutationResolverGenerator {
	private final String packageName;
	private final String inputModelPackageName;
	private final ModelMap tableStructureExtensions;

	/**
	 * Generate Schema
	 *
	 * @param AD_Table_ID table id
	 * @param directory   directory
	 */
	public GraphQLMutationResolverGenerator(int AD_Table_ID, String directory, String packageName,
			String inputModelPackageName, Map<String, ModelMap> modelsForTables) throws FileNotFoundException {
		this.packageName = packageName;
		this.inputModelPackageName = inputModelPackageName;

		// Get the name of the model to extend
		tableStructureExtensions = modelsForTables.get(MTable.get(AD_Table_ID).getTableName());
		if (tableStructureExtensions == null) {
			throw new FileNotFoundException("Can't find file to match for table " + MTable.get(AD_Table_ID).getTableName());
		}

		// Header
		StringBuilder generatedFile = new StringBuilder();
		String fileName = createHeader(AD_Table_ID, generatedFile);

		// Save
		if (!directory.endsWith(File.separator)) {
			directory += File.separator;
		}

		GraphQLUtil.writeToFile(generatedFile, directory + fileName + ".java");
	}

	/**
	 * Add Header info to buffer
	 *
	 * @param AD_Table_ID   table
	 * @param generatedFile GeneratedColumns
	 * @return file name
	 */
	private String createHeader(int AD_Table_ID, StringBuilder generatedFile) {
		String tableName = null;
		String sql = "SELECT TableName FROM AD_Table WHERE AD_Table_ID=?";
		try (PreparedStatement preparedStatement = DB.prepareStatement(sql, null)) {
			preparedStatement.setInt(1, AD_Table_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				tableName = resultSet.getString(1);
			}
		} catch (SQLException e) {
			throw new DBException(e, sql);
		}
		if (tableName == null) {
			throw new RuntimeException("TableName not found for ID=" + AD_Table_ID);
		}

		String className = "X_" + tableName + "Mutation";
		StringBuilder generatedClass = new StringBuilder()
				.append("package ").append(packageName).append(";\n\n");
		String generatedInterfaceInputName =
				GraphQLInputModelInterfaceGenerator.getGeneratedName(tableStructureExtensions.getTableName());
		String generatedClassInputName =
				GraphQLInputModelClassGenerator.getGeneratedName(tableStructureExtensions.getTableName());

		classesToImport.add("graphql.kickstart.tools.GraphQLMutationResolver");
		classesToImport.add("graphql.schema.DataFetchingEnvironment");
		classesToImport.add(tableStructureExtensions.getClassPackageName() + "." + tableStructureExtensions.getClassName());
		classesToImport.add(inputModelPackageName + "." + generatedInterfaceInputName);
		classesToImport.add(inputModelPackageName + "." + generatedClassInputName);
		classesToImport.add("java.util.List");
		classesToImport.add("java.util.stream.Collectors");
		GraphQLUtil.createImports(classesToImport, generatedClass);

		generatedClass
				.append("/**\n * Generated Query Resolver for ").append(tableName).append(" - DO NOT CHANGE\n *\n")
				.append(" * @author Banda Health (generated)").append("\n")
				.append(" * @version ").append(Adempiere.MAIN_VERSION).append(" - $Id$").append("\n */\n")

				// Query Resolver definition
				.append("public class ").append(className).append(" extends POMutation implements GraphQLMutationResolver {\n")

				// Table Name Override
				.append("\t@Override\n")
				.append("\tprotected String getTableName() {\n")
				.append("\t\treturn ").append(generatedClassInputName).append(".Table_Name;\n")
				.append("\t}\n\n")

				// Default Mutations from the Schema
				// Save
				.append("\tpublic ").append(tableStructureExtensions.getClassName()).append(" ")
				.append(tableStructureExtensions.getTableName())
				.append("Save(").append(generatedInterfaceInputName)
				.append(" Entity, DataFetchingEnvironment environment) {\n")
				.append("\t\treturn (").append(tableStructureExtensions.getClassName()).append(") super.save((")
				.append(generatedClassInputName).append(") Entity, environment);\n")
				.append("\t}\n\n")
				// SaveMany
				.append("\tpublic List<").append(tableStructureExtensions.getClassName()).append("> ")
				.append(tableStructureExtensions.getTableName()).append("SaveMany(List<").append(generatedInterfaceInputName)
				.append("> Entities, DataFetchingEnvironment environment) {\n")
				.append("\t\treturn super.saveMany(Entities.stream().map(entity -> (").append(generatedClassInputName)
				.append(") entity).collect(Collectors.toList()),\n")
				.append("\t\t\t\tenvironment).stream().map(entity -> (").append(tableStructureExtensions.getClassName())
				.append(") entity).collect(Collectors.toList());\n")
				.append("\t}\n\n")
				// Delete
				.append("\tpublic boolean ").append(tableStructureExtensions.getTableName())
				.append("Delete(List<String> UUs, DataFetchingEnvironment environment) {\n")
				.append("\t\treturn super.delete(UUs, environment);\n")
				.append("\t}\n")
				.append("}\n");

		generatedFile.insert(0, generatedClass);

		return className;
	}

	/**
	 * Import classes
	 */
	private final Collection<String> classesToImport = new TreeSet<>();

	/**
	 * @param sourceFolder
	 * @param entityType
	 * @param tableName
	 */
	public static void generateSource(String entityType, String tableName, String sourceFolder, String packageName,
			String inputModelPackageName, Map<String, ModelMap> modelsForTables) {
		//
		String directory =
				GraphQLUtil.validateSourceFolderTableNamePackageNameAndGetFileOutputDirectory(sourceFolder, tableName,
						packageName);
		//
		GraphQLUtil.buildAndExecuteTableSql(tableName, entityType,
				(resultSet -> new GraphQLMutationResolverGenerator(resultSet.getInt(1), directory, packageName,
						inputModelPackageName, modelsForTables)));
	}
}
