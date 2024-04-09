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
import org.adempiere.util.ModelInterfaceGenerator;
import org.compiere.Adempiere;
import org.compiere.model.MEntityType;
import org.compiere.model.MReference;
import org.compiere.model.MTable;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.TreeSet;

/**
 * Generate GraphQL Input Model Interfaces.
 *
 * @author Kevin Burnett
 */
public class GraphQLInputModelInterfaceGenerator {
	private static final CLogger log = CLogger.getCLogger(GraphQLInputModelInterfaceGenerator.class);
	private String packageName = "";
	private final ModelMap tableStructureExtensions;

	public static String getGeneratedName(String tableName) {
		return "I_" + tableName + "Input";
	}

	/**
	 * Generate Schema
	 *
	 * @param AD_Table_ID      table id
	 * @param directory        directory
	 * @param entityTypeFilter entity type filter for columns
	 */
	public GraphQLInputModelInterfaceGenerator(int AD_Table_ID, String entityTypeFilter, String directory,
			String packageName, Map<String, ModelMap> modelsForTables) throws FileNotFoundException {
		this.packageName = packageName;

		// Get the name of the model to extend
		tableStructureExtensions = modelsForTables.get(MTable.get(AD_Table_ID).getTableName());
		if (tableStructureExtensions == null) {
			throw new FileNotFoundException("Can't find file to match for table " + MTable.get(AD_Table_ID).getTableName());
		}

		// create column access methods
		StringBuilder generatedColumns = createColumns(AD_Table_ID, entityTypeFilter);

		// Header
		String fileName = createHeader(AD_Table_ID, generatedColumns);

		// Save
		if (!directory.endsWith(File.separator)) {
			directory += File.separator;
		}

		GraphQLUtil.writeToFile(generatedColumns, directory + fileName + ".java");
	}

	/**
	 * Add Header info to buffer
	 *
	 * @param AD_Table_ID      table
	 * @param generatedColumns GeneratedColumns
	 * @return file name
	 */
	private String createHeader(int AD_Table_ID, StringBuilder generatedColumns) {
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

		String interfaceName = getGeneratedName(tableName);
		StringBuilder generatedInterface = new StringBuilder()
				.append("package ").append(packageName).append(";\n\n");

		GraphQLUtil.createImports(classesToImport, generatedInterface);
		generatedInterface
				.append("/**\n * Generated Interface for ").append(tableName).append(" - DO NOT CHANGE\n *\n")
				.append(" * @author Banda Health (generated)").append("\n")
				.append(" * @version ").append(Adempiere.MAIN_VERSION).append(" - $Id$").append("\n */\n")

				// Interface definition
				.append("public interface ").append(interfaceName).append(" extends ")
				.append(tableStructureExtensions.getInterfaceName()).append(" {");

		generatedColumns.insert(0, generatedInterface);
		generatedColumns.append("\n}\n");

		return interfaceName;
	}

	/**
	 * Create Column access methods
	 *
	 * @param AD_Table_ID      table
	 * @param entityTypeFilter
	 * @return set/get method
	 */
	private StringBuilder createColumns(int AD_Table_ID, String entityTypeFilter) {
		StringBuilder generatedColumns = new StringBuilder();
		String sql = "SELECT c.ColumnName, c.AD_Reference_ID, c.AD_Reference_Value_ID, "   // 1..3
				+ " c.Name, c.Description, c.ColumnSQL, c.IsKey, c.entitytype " //  4..8
				+ "FROM AD_Column c "
				+ "WHERE c.AD_Table_ID =? "
				+ " AND c.IsActive = 'Y' "
				+ (!Util.isEmpty(entityTypeFilter) ? " AND c." + entityTypeFilter : "")
				+ " ORDER BY c.ColumnName";
		try (PreparedStatement preparedStatement = DB.prepareStatement(sql, null)) {
			preparedStatement.setInt(1, AD_Table_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String columnName = resultSet.getString(1);
				int displayType = resultSet.getInt(2);
				int AD_Reference_Value_ID = resultSet.getInt(3);
				String Name = resultSet.getString(4);
				String Description = resultSet.getString(5);
				String ColumnSQL = resultSet.getString(6);
				boolean virtualColumn = ColumnSQL != null && !ColumnSQL.isEmpty();
				boolean IsKey = "Y".equals(resultSet.getString(7));
				String entityType = resultSet.getString(8);
				//
				generatedColumns.append(
						createColumnMethods(columnName, displayType, AD_Reference_Value_ID, Name, Description, virtualColumn,
								IsKey, entityType, AD_Table_ID));
			}
		} catch (SQLException e) {
			throw new DBException(e, sql);
		}
		return generatedColumns;
	}

	/**
	 * Create the definitions for the schema fields
	 *
	 * @param columnName      column name
	 * @param displayType     display type
	 * @param AD_Reference_ID validation reference
	 * @param Name            String
	 * @param Description     String
	 * @param virtualColumn   virtual column
	 * @return set/get method
	 */
	private String createColumnMethods(String columnName, int displayType, int AD_Reference_ID, String Name,
			String Description, boolean virtualColumn, boolean IsKey, String entityType, int AD_Table_ID) {
		Class<?> clazz = ModelInterfaceGenerator.getClass(columnName, displayType, AD_Reference_ID);
		String dataType = ModelInterfaceGenerator.getDataTypeName(clazz, displayType);

		StringBuilder columnBuilder = new StringBuilder();

		if (columnName.equals("Created") || columnName.equals("CreatedBy") || columnName.equals("Updated") ||
				columnName.equals("UpdatedBy") || columnName.equals("AD_Client_ID") || virtualColumn) {
			return "";
		}

		String entityName = "";

		// TODO - New functionality
		// 1) Must understand which class to reference
		if (DisplayType.isID(displayType) && !IsKey) {
			String fieldName = ModelInterfaceGenerator.getFieldName(columnName);
			String referenceClassName =
					ModelInterfaceGenerator.getReferenceClassName(AD_Table_ID, columnName, displayType, AD_Reference_ID);
			//
			if (fieldName != null && referenceClassName != null) {
				String[] packagePath = referenceClassName.split("\\.");
				referenceClassName = packagePath[packagePath.length - 1].substring(2);
				entityName = fieldName;
			} else if (columnName.equals("AD_Language")) {
				entityName = columnName;
			} else if (columnName.equals("EntityType")) {
				entityName = "AD_EntityType";
			} else {
				String columnNameWithSuffixedIdRemoved = columnName.substring(0, columnName.length() - 3);
				// Possibly there isn't a mapping, but a table does exist we can use
				if (columnName.endsWith("_ID") && MTable.get(AD_Table_ID).getColumn(columnNameWithSuffixedIdRemoved) == null &&
						MTable.get(Env.getCtx(), columnNameWithSuffixedIdRemoved) != null) {
					entityName = columnNameWithSuffixedIdRemoved;
				} else if (columnName.equals("Logo_ID")) {
					entityName = columnNameWithSuffixedIdRemoved;
				} else if (columnName.equals("BH_To_Warehouse_ID") || columnName.equals("BH_From_Warehouse_ID")) {
					entityName = columnNameWithSuffixedIdRemoved;
				} else {
					log.warning("Did not generate a field for: " + columnName);
					return "";
				}
			}

			String interfaceToExtend = tableStructureExtensions.getInterfaceName();
			classesToImport.add(tableStructureExtensions.getInterfacePackageName() + "." + interfaceToExtend);
			columnBuilder.append("\n");

			GraphQLUtil.generateJavaSetComment(entityName, entityName, Description, columnBuilder);
			columnBuilder
					.append("\tvoid set").append(entityName).append("Input(ForeignEntityInput ").append(entityName)
					.append(");\n");

			GraphQLUtil.generateJavaGetComment(entityName, Description, columnBuilder);
			columnBuilder
					.append("\tForeignEntityInput ").append(entityName).append("();");

			return columnBuilder.toString();
		} else if (columnName.equalsIgnoreCase(MTable.get(AD_Table_ID).getTableName() + "_UU")) {
			columnBuilder.append("\n");
			GraphQLUtil.generateJavaSetComment("UU", "UU", Description, columnBuilder);
			columnBuilder.append("\tvoid setUU(String UU);\n");
			GraphQLUtil.generateJavaGetComment("UU", Description, columnBuilder);
			columnBuilder.append("\tString getUU();");
			return columnBuilder.toString();
		} else if (columnName.endsWith("_UU")) {
			log.warning("Did not generate a field for: " + columnName);
			return "";
		}

		if (AD_Reference_ID > 0 &&
				MReference.get(AD_Reference_ID).getValidationType().equals(MReference.VALIDATIONTYPE_ListValidation) &&
				clazz.equals(String.class)) {
			columnBuilder.append("\n");
			GraphQLUtil.generateJavaSetComment(columnName, columnName, Description, columnBuilder);
			columnBuilder.append("\tvoid set").append(columnName).append("Input(I_AD_Ref_ListInput ").append(columnName)
					.append(");\n");
			GraphQLUtil.generateJavaGetComment(columnName, Description, columnBuilder);
			columnBuilder.append("\tI_AD_Ref_ListInput ").append(columnName).append("();");
			return columnBuilder.toString();
		}

		// If the column is user-maintained and the table isn't, we need to generate
		boolean areColumnMethodsStoredOnAManualClassExtendingAnotherManualClass =
				entityType.equals(MEntityType.ENTITYTYPE_UserMaintained) &&
						!MTable.get(AD_Table_ID).getEntityType().equals(MEntityType.ENTITYTYPE_UserMaintained);
		if (areColumnMethodsStoredOnAManualClassExtendingAnotherManualClass) {
			columnBuilder
					.append("\n\n")
					.append("\t/**\n")
					.append("\t * Column name ").append(columnName).append("\n")
					.append("\t */\n")
					.append("\tstatic final String COLUMNNAME_").append(columnName)
					.append(" = \"").append(columnName).append("\";\n");

			// Create Java Comment
			GraphQLUtil.generateJavaSetComment(columnName, Name, Description, columnBuilder);
			// public void setColumn(xxx variable)
			columnBuilder.append("\tvoid set").append(columnName).append("(")
					.append(dataType).append(" ").append(columnName).append(");\n");

			// ****** Get Comment ******
			GraphQLUtil.generateJavaGetComment(Name, Description, columnBuilder);

			columnBuilder.append("\t").append(dataType);
			if (clazz.equals(Boolean.class)) {
				columnBuilder.append(" is");
				if (columnName.toLowerCase().startsWith("is")) {
					columnBuilder.append(columnName.substring(2));
				} else {
					columnBuilder.append(columnName);
				}
			} else {
				columnBuilder.append(" get").append(columnName);
			}
			columnBuilder.append("();");
			//
			addImportClass(clazz);
			return columnBuilder.toString();
		}

		return "";
	}

	/**
	 * Import classes
	 */
	private final Collection<String> classesToImport = new TreeSet<>();

	/**
	 * Add class name to class import list
	 *
	 * @param className The canonical class name to add to the import list
	 */
	private void addImportClass(String className) {
		if (className == null
				|| (className.startsWith("java.lang.") && !className.startsWith("java.lang.reflect."))
				|| className.startsWith(packageName + ".")) {
			return;
		}
		if (className.equals("byte[]")) {
			log.warning("Invalid type - " + className);
			return;
		}
		classesToImport.add(className);
	}

	/**
	 * Add class to class import list
	 *
	 * @param clazz The class to add to the import list
	 */
	private void addImportClass(Class<?> clazz) {
		if (clazz.isArray()) {
			clazz = clazz.getComponentType();
		}
		if (clazz.isPrimitive())
			return;
		addImportClass(clazz.getCanonicalName());
	}

	/**
	 * @param sourceFolder
	 * @param entityType
	 * @param tableName
	 * @param columnEntityType
	 */
	public static void generateSource(String entityType, String tableName, String columnEntityType, String sourceFolder,
			String packageName, String customModelSourceFolder, String customModelPackageName,
			Map<String, ModelMap> modelsForTables) {
		//
		GraphQLUtil.validateCustomModelsFolderAndPackageName(customModelSourceFolder, customModelPackageName);
		String directory =
				GraphQLUtil.validateSourceFolderTableNamePackageNameAndGetFileOutputDirectory(sourceFolder, tableName,
						packageName);
		String columnFilter = GraphQLUtil.getColumnFilter(columnEntityType);
		//
		GraphQLUtil.buildAndExecuteTableSql(tableName, entityType,
				(resultSet -> new GraphQLInputModelInterfaceGenerator(resultSet.getInt(1), columnFilter, directory,
						packageName, modelsForTables)));
	}
}
