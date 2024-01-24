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
package org.bandahealth.idempiere.graphql.generator.util;

import org.adempiere.exceptions.DBException;
import org.adempiere.util.ModelInterfaceGenerator;
import org.compiere.Adempiere;
import org.compiere.model.MTable;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.logging.Level;

/**
 * Generate GraphQL Schemas.
 *
 * @author Kevin Burnett
 */
public class GraphQLMutationResolverGenerator {
	private static final CLogger log = CLogger.getCLogger(GraphQLMutationResolverGenerator.class);
	private String packageName = "";
	private String inputModelPackageName = "";
	private ModelMap tableStructureExtensions;

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

		writeToFile(generatedFile, directory + fileName + ".java");
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
		// TODO: Maybe fetch these from the input model generator?
		String generatedInterfaceInputName = "I_" + tableStructureExtensions.getTableName() + "Input";
		String generatedClassInputName = "X_" + tableStructureExtensions.getTableName() + "Input";

		classesToImport.add("graphql.kickstart.tools.GraphQLMutationResolver");
		classesToImport.add("graphql.schema.DataFetchingEnvironment");
		classesToImport.add(tableStructureExtensions.getClassPackageName() + "." + tableStructureExtensions.getClassName());
		classesToImport.add(inputModelPackageName + "." + generatedInterfaceInputName);
		classesToImport.add(inputModelPackageName + "." + generatedClassInputName);
		classesToImport.add("java.util.List");
		createImports(generatedClass);

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
				.append("\tpublic ").append(tableStructureExtensions.getClassName()).append(" ")
				.append(tableStructureExtensions.getTableName())
				.append("Save(").append(generatedInterfaceInputName).append(" input, DataFetchingEnvironment environment) {\n")
				.append("\t\treturn (").append(tableStructureExtensions.getClassName()).append(") super.save((")
				.append(generatedClassInputName).append(") input, environment);\n")
				.append("\t}\n\n")
				.append("\tpublic boolean ").append(tableStructureExtensions.getTableName())
				.append("Delete(List<String> uuids, DataFetchingEnvironment environment) {\n")
				.append("\t\treturn super.delete(uuids, environment);\n")
				.append("\t}\n")
				.append("}\n");

		generatedFile.insert(0, generatedClass);

		return className;
	}

	/**
	 * Create the definitions for the schema fields
	 *
	 * @param columnName      column name
	 * @param isUpdateable    updateable
	 * @param isMandatory     mandatory
	 * @param displayType     display type
	 * @param AD_Reference_ID validation reference
	 * @param fieldLength     int
	 * @param defaultValue    default value
	 * @param ValueMin        String
	 * @param ValueMax        String
	 * @param VFormat         String
	 * @param Callout         String
	 * @param Name            String
	 * @param Description     String
	 * @param virtualColumn   virtual column
	 * @param IsEncrypted     stored encrypted
	 * @return set/get method
	 */
	private String createColumnMethods(String columnName, boolean isUpdateable, boolean isMandatory, int displayType,
			int AD_Reference_ID, int fieldLength, String defaultValue, String ValueMin, String ValueMax, String VFormat,
			String Callout, String Name, String Description, boolean virtualColumn, boolean IsEncrypted, boolean IsKey,
			int AD_Table_ID) {
		Class<?> clazz = ModelInterfaceGenerator.getClass(columnName, displayType, AD_Reference_ID);
		String dataType = ModelInterfaceGenerator.getDataTypeName(clazz, displayType);
		if (defaultValue == null) {
			defaultValue = "";
		}

		StringBuilder columnBuilder = new StringBuilder();

		boolean shouldSkipInputField =
				columnName.equals("Created") || columnName.equals("CreatedBy") || columnName.equals("Updated") ||
						columnName.equals("UpdatedBy") || columnName.equals("AD_Client_ID") || virtualColumn;

		// TODO - New functionality
		// 1) Must understand which class to reference
		if (shouldSkipInputField || !DisplayType.isID(displayType) || IsKey) {
			// If this is the UUID column, we need to generate the ID fields
			if ((!DisplayType.isID(displayType) || IsKey) && columnName.endsWith("_UU")) {
				columnBuilder.append("\n");
				generateJavaSetComment("ID", "ID", Description, columnBuilder);
				columnBuilder.append("\tvoid setID(String ID);\n");
				generateJavaGetComment("ID", Description, columnBuilder);
				columnBuilder.append("\tString getID();");
				return columnBuilder.toString();
			} else if (!shouldSkipInputField && AD_Reference_ID > 0) {
				columnName += "_RL";
				columnBuilder.append("\n");
				generateJavaSetComment(columnName, columnName, Description, columnBuilder);
				columnBuilder.append("\tvoid set").append(columnName).append("(I_AD_Ref_ListInput ").append(columnName)
						.append(");\n");
				generateJavaGetComment(columnName, Description, columnBuilder);
				columnBuilder.append("\tI_AD_Ref_ListInput get").append(columnName).append("();");
				return columnBuilder.toString();
			}
			return "";
		}

		String fieldName = ModelInterfaceGenerator.getFieldName(columnName);
		String referenceClassName =
				ModelInterfaceGenerator.getReferenceClassName(AD_Table_ID, columnName, displayType, AD_Reference_ID);

		String entityName = "";
		String returnType = "";
		if (fieldName != null && referenceClassName != null) {
			// If this isn't an ID column or the field isn't an account field (ends with "_A"), use the column name as the
			// field name
			if (!columnName.contains("_ID") && !fieldName.endsWith("_A")) {
				fieldName = columnName;
			}
			String[] packagePath = referenceClassName.split("\\.");
			referenceClassName = packagePath[packagePath.length - 1].substring(2);
			entityName = fieldName;
			returnType = "I_" + referenceClassName + "Input";
		} else if (columnName.equals("AD_Language")) {
			entityName = columnName;
			returnType = "I_" + columnName + "Input";
		} else if (columnName.equals("EntityType")) {
			entityName = "AD_EntityType";
			returnType = "I_" + entityName + "Input";
		} else {
			String columnNameWithSuffixedIdRemoved = columnName.substring(0, columnName.length() - 3);
			if (columnName.endsWith("_ID") &&
					MTable.get(Env.getCtx(), columnNameWithSuffixedIdRemoved) != null) {
				entityName = columnNameWithSuffixedIdRemoved;
				returnType = "I_" + columnNameWithSuffixedIdRemoved + "Input";
			} else if (columnName.equals("Logo_ID")) {
				entityName = "AD_Image";
				returnType = "I_" + entityName + "Input";
			} else {
				log.warning("Did not generate a field for: " + columnName);
				return "";
			}
		}

		String interfaceToExtend = tableStructureExtensions.getInterfaceName();
		classesToImport.add(tableStructureExtensions.getInterfacePackageName() + "." + interfaceToExtend);
		columnBuilder.append("\n");

		generateJavaSetComment(entityName, entityName, Description, columnBuilder);
		columnBuilder.append("\tvoid set").append(entityName).append("(").append(returnType).append(" ")
				.append(entityName).append(");\n");

		generateJavaGetComment(entityName, Description, columnBuilder);
		columnBuilder.append("\t").append(returnType).append(" get").append(entityName).append("();");

		return columnBuilder.toString();
	}

	/**
	 * Set Comment
	 *
	 * @param columnName    The column we're setting
	 * @param propertyName  The property to generate a get comment for
	 * @param description   An optional description of the property
	 * @param generatedCode The column getters/setters we're generating
	 */
	public void generateJavaSetComment(String columnName, String propertyName, String description,
			StringBuilder generatedCode) {
		generatedCode.append("\n").append("\t/**\n\t * Set ").append(propertyName).append(".\n\t *\n\t * @param ")
				.append(columnName).append(" ")
				.append(description != null && !description.isEmpty() ? description : propertyName).append("\n\t */\n");
	}

	/**
	 * Get Comment
	 *
	 * @param propertyName  The property to generate a get comment for
	 * @param description   An optional description of the property
	 * @param generatedCode The column getters/setters we're generating
	 */
	public void generateJavaGetComment(String propertyName, String description, StringBuilder generatedCode) {
		generatedCode.append("\n").append("\t/**\n\t * Get ").append(propertyName).append(".\n\t *\n\t * @return ")
				.append(description != null && !description.isEmpty() ? description : propertyName).append("\n\t */\n");
	}

	/**************************************************************************
	 * 	Write to file
	 *  @param stringBuilder string buffer
	 *  @param fileName file name
	 */
	private void writeToFile(StringBuilder stringBuilder, String fileName) {
		try {
			File out = new File(fileName);
			Writer fw = new OutputStreamWriter(new FileOutputStream(out, false), "UTF-8");
			for (int i = 0; i < stringBuilder.length(); i++) {
				char c = stringBuilder.charAt(i);
				//	after
				if (c == ';' || c == '}') {
					fw.write(c);
				}
				//	before & after
				else if (c == '{') {
					fw.write(c);
				} else {
					fw.write(c);
				}
			}
			fw.flush();
			fw.close();
			float size = out.length();
			size /= 1024;
			String msgout = out.getAbsolutePath() + " - " + size + " " + "kB";
			System.out.println(msgout);
		} catch (Exception ex) {
			log.log(Level.SEVERE, fileName, ex);
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Import classes
	 */
	private final Collection<String> classesToImport = new TreeSet<>();

	/**
	 * Generate java imports
	 *
	 * @param generatedCode
	 */
	private void createImports(StringBuilder generatedCode) {
		boolean hasJavaImports = false;
		for (String name : classesToImport) {
			if (name.startsWith("java.")) {
				hasJavaImports = true;
				continue;
			}
			generatedCode.append("import ").append(name).append(";").append("\n");
		}
		if (hasJavaImports) {
			generatedCode.append("\n");
			for (String name : classesToImport) {
				if (!name.startsWith("java.")) {
					continue;
				}
				generatedCode.append("import ").append(name).append(";").append("\n");
			}
		}
		generatedCode.append("\n");
	}

	/**
	 * String representation
	 *
	 * @return string representation
	 */
	public String toString() {
		return "GenerateModel[]";
	}

	/**
	 * @param sourceFolder
	 * @param entityType
	 * @param tableName
	 * @param columnEntityType
	 */
	public static void generateSource(String entityType, String tableName, String columnEntityType, String sourceFolder,
			String packageName, String inputModelPackageName, Map<String, ModelMap> modelsForTables) {
		if (sourceFolder == null || sourceFolder.trim().isEmpty()) {
			throw new IllegalArgumentException("Must specify source folder");
		}

		File file = new File(sourceFolder);
		if (!file.exists()) {
			throw new IllegalArgumentException("Source folder doesn't exists. sourceFolder=" + sourceFolder);
		}
		if (tableName == null || tableName.trim().isEmpty()) {
			throw new IllegalArgumentException("Must specify table name");
		}
		if (packageName == null || packageName.trim().isEmpty()) {
			throw new IllegalArgumentException("Must specify package name");
		}
		if (inputModelPackageName == null || inputModelPackageName.trim().isEmpty()) {
			throw new IllegalArgumentException("Must specify input model package name");
		}

		StringBuilder tableLike = new StringBuilder().append(tableName.trim());
		if (!tableLike.toString().startsWith("'") || !tableLike.toString().endsWith("'")) {
			tableLike = new StringBuilder("'").append(tableLike).append("'");
		}

		StringBuilder entityTypeFilter = new StringBuilder();
		if (entityType != null && !entityType.trim().isEmpty()) {
			entityTypeFilter.append("EntityType IN (");
			StringTokenizer tokenizer = new StringTokenizer(entityType, ",");
			int i = 0;
			while (tokenizer.hasMoreTokens()) {
				StringBuilder token = new StringBuilder().append(tokenizer.nextToken().trim());
				if (!token.toString().startsWith("'") || !token.toString().endsWith("'")) {
					token = new StringBuilder("'").append(token).append("'");
				}
				if (i > 0) {
					entityTypeFilter.append(",");
				}
				entityTypeFilter.append(token);
				i++;
			}
			entityTypeFilter.append(")");
		} else {
			entityTypeFilter.append("EntityType IN ('U','A')");
		}

		StringBuilder directory = new StringBuilder().append(sourceFolder.trim());
		if (!(directory.toString().endsWith("/") || directory.toString().endsWith("\\"))) {
			directory.append(File.separator);
		}
		if (File.separator.equals("/")) {
			directory = new StringBuilder(directory.toString().replaceAll("[\\\\]", File.separator));
		} else {
			directory = new StringBuilder(directory.toString().replaceAll("[/]", File.separator));
		}
		file = new File(directory.toString());
		if (!file.exists()) {
			file.mkdirs();
		}

		//	complete sql
		String filterViews = null;
		if (tableLike.toString().contains("%")) {
			filterViews = "AND (TableName IN ('RV_WarehousePrice','RV_BPartner') OR IsView='N')";  //	special views
		}
		if (tableLike.toString().equals("'%'")) {
			filterViews += " AND TableName NOT LIKE 'W|_%' ESCAPE '|'";  //	exclude webstore from general model generator
		}
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT AD_Table_ID ")
				.append("FROM AD_Table ")
				.append("WHERE IsActive = 'Y' AND TableName NOT LIKE '%_Trl' ");
		// Autodetect if we need to use IN or LIKE clause - teo_sarca [ 3020640 ]
		if (tableLike.indexOf(",") == -1) {
			sql.append(" AND TableName LIKE ").append(tableLike);
		} else {
			sql.append(" AND TableName IN (").append(tableLike).append(")"); // o"\n"y specific tables
		}
		sql.append(" AND ").append(entityTypeFilter);
		if (filterViews != null) {
			sql.append(filterViews);
		}
		sql.append(" ORDER BY TableName");
		//
		StringBuilder columnFilterBuilder = new StringBuilder();
		if (!Util.isEmpty(columnEntityType, true)) {
			columnFilterBuilder.append("EntityType IN (");
			StringTokenizer tokenizer = new StringTokenizer(columnEntityType, ",");
			int i = 0;
			while (tokenizer.hasMoreTokens()) {
				StringBuilder token = new StringBuilder().append(tokenizer.nextToken().trim());
				if (!token.toString().startsWith("'") || !token.toString().endsWith("'")) {
					token = new StringBuilder("'").append(token).append("'");
				}
				if (i > 0) {
					columnFilterBuilder.append(",");
				}
				columnFilterBuilder.append(token);
				i++;
			}
			columnFilterBuilder.append(")");
		}
		String columnFilter = columnFilterBuilder.length() > 0 ? columnFilterBuilder.toString() : null;

		try (PreparedStatement preparedStatement = DB.prepareStatement(sql.toString(), null)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				new GraphQLMutationResolverGenerator(resultSet.getInt(1), directory.toString(), packageName,
						inputModelPackageName, modelsForTables);
			}
		} catch (SQLException e) {
			throw new DBException(e, sql.toString());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
