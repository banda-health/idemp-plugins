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
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.StringTokenizer;
import java.util.logging.Level;

/**
 * Generate GraphQL Schemas.
 *
 * @author Kevin Burnett
 */
public class GraphQLSchemaGenerator {
	private static final CLogger log = CLogger.getCLogger(GraphQLSchemaGenerator.class);

	/**
	 * Generate Schema
	 *
	 * @param AD_Table_ID      table id
	 * @param directory        directory
	 * @param entityTypeFilter entity type filter for columns
	 */
	public GraphQLSchemaGenerator(int AD_Table_ID, String directory, String entityTypeFilter) {
		//	create column access methods
		StringBuilder stringBuilder = new StringBuilder();
		GeneratedColumns generatedColumns = createColumns(AD_Table_ID, entityTypeFilter);

		// Header
		String fileName = createHeader(AD_Table_ID, stringBuilder, generatedColumns);

		// Save
		if (!directory.endsWith(File.separator)) {
			directory += File.separator;
		}

		writeToFile(stringBuilder, directory + fileName + ".graphqls");
	}

	/**
	 * Add Header info to buffer
	 *
	 * @param AD_Table_ID      table
	 * @param stringBuilder    buffer
	 * @param generatedColumns GeneratedColumns
	 * @return file name
	 */
	private String createHeader(int AD_Table_ID, StringBuilder stringBuilder, GeneratedColumns generatedColumns) {
		String tableName = "";
		String sql = "SELECT TableName FROM AD_Table WHERE AD_Table_ID=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = DB.prepareStatement(sql, null);
			preparedStatement.setInt(1, AD_Table_ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				tableName = resultSet.getString(1);
			}
		} catch (SQLException e) {
			throw new DBException(e, sql);
		} finally {
			DB.close(resultSet, preparedStatement);
			resultSet = null;
			preparedStatement = null;
		}
		if (tableName == null) {
			throw new RuntimeException("TableName not found for ID=" + AD_Table_ID);
		}

		stringBuilder.append("# Generated Schema for ").append(tableName).append(" - DO NOT CHANGE\n")
				.append("#\t\t@author Banda Health (generated) ").append("\n")
				.append("#\t\t@version ").append(Adempiere.MAIN_VERSION).append(" - $Id$").append("\n")

				// Default Queries
				.append("extend type Query {\n")
				.append("\t").append(tableName).append("Get(page: Int, size: Int, sort: String, filter: String): ")
				.append(tableName).append("Connection!\n")
				.append("}\n\n")

				// Default Mutations
				.append("extend type Mutation {\n\t").append(tableName).append("Save(entity: ").append(tableName)
				.append("Input!): ").append(tableName).append("!\n\t").append(tableName)
				.append("Delete(uuids: [String!]!): Boolean!\n}\n\n")

				// Connection Type
				.append("type ").append(tableName).append("Connection {\n\tresults: [").append(tableName).append("!]!\n")
				.append("\tpagingInfo: PagingInfo!\n}\n\n");

		stringBuilder.append("type ").append(tableName).append(" {\n").append(generatedColumns.regularModel)
				.append("}\n\ninput ").append(tableName).append("Input {\n").append(generatedColumns.inputModel).append(
						"}\n");

		return "X_" + tableName;
	}

	/**
	 * Create Column access methods
	 *
	 * @param AD_Table_ID      table
	 * @param entityTypeFilter
	 * @return set/get method
	 */
	private GeneratedColumns createColumns(int AD_Table_ID, String entityTypeFilter) {
		GeneratedColumns generatedColumns = new GeneratedColumns(new StringBuilder(), new StringBuilder());
		String sql = "SELECT c.ColumnName, c.IsUpdateable, c.IsMandatory,"    //	1..3
				+ " c.AD_Reference_ID, c.AD_Reference_Value_ID, DefaultValue, SeqNo, "  //	4..7
				+ " c.FieldLength, c.ValueMin, c.ValueMax, c.VFormat, c.Callout, "  //	8..12
				+ " c.Name, c.Description, c.ColumnSQL, c.IsEncrypted, c.IsKey, c.IsIdentifier "  // 13..18
				+ "FROM AD_Column c "
				+ "WHERE c.AD_Table_ID=?"
				+ " AND c.IsActive='Y'"
				+ (!Util.isEmpty(entityTypeFilter) ? " AND c." + entityTypeFilter : "")
				+ " ORDER BY c.ColumnName";
		boolean isKeyNamePairCreated = false; // true if the method "getKeyNamePair" is already generated
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = DB.prepareStatement(sql, null);
			preparedStatement.setInt(1, AD_Table_ID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String columnName = resultSet.getString(1);
				boolean isUpdatable = "Y".equals(resultSet.getString(2));
				boolean isMandatory = "Y".equals(resultSet.getString(3));
				int displayType = resultSet.getInt(4);
				int AD_Reference_Value_ID = resultSet.getInt(5);
				String defaultValue = resultSet.getString(6);
				int seqNo = resultSet.getInt(7);
				int fieldLength = resultSet.getInt(8);
				String ValueMin = resultSet.getString(9);
				String ValueMax = resultSet.getString(10);
				String VFormat = resultSet.getString(11);
				String Callout = resultSet.getString(12);
				String Name = resultSet.getString(13);
				String Description = resultSet.getString(14);
				String ColumnSQL = resultSet.getString(15);
				boolean virtualColumn = ColumnSQL != null && ColumnSQL.length() > 0;
				boolean IsEncrypted = "Y".equals(resultSet.getString(16));
				boolean IsKey = "Y".equals(resultSet.getString(17));
				boolean IsIdentifier = "Y".equals(resultSet.getString(18));
				//
				createFields(generatedColumns, columnName, isUpdatable, isMandatory,
						displayType, AD_Reference_Value_ID, fieldLength, defaultValue, ValueMin, ValueMax, VFormat, Callout, Name,
						Description, virtualColumn, IsEncrypted, IsKey, AD_Table_ID);
				//
				if (seqNo == 1 && IsIdentifier) {
					if (!isKeyNamePairCreated) {
						isKeyNamePairCreated = true;
					} else {
						StringBuilder msgException = new StringBuilder("More than one primary identifier found ")
								.append(" (AD_Table_ID=").append(AD_Table_ID).append(", ColumnName=").append(columnName).append(")");
						throw new RuntimeException(msgException.toString());
					}
				}
			}
		} catch (SQLException e) {
			throw new DBException(e, sql);
		} finally {
			DB.close(resultSet, preparedStatement);
			resultSet = null;
			preparedStatement = null;
		}
		MTable translationTable;
		if ((translationTable = MTable.get(Env.getCtx(), MTable.get(Env.getCtx(), AD_Table_ID).getTableName() + "_Trl")) !=
				null && translationTable.get_ID() > 0) {
			generatedColumns.regularModel.append("\t").append(translationTable.getTableName()).append(": [")
					.append(translationTable.getTableName()).append("!]!\n");
			generatedColumns.inputModel.append("\t").append(translationTable.getTableName()).append(": [")
					.append(translationTable.getTableName()).append("Input!]\n");
		}
		return generatedColumns;
	}

	/**
	 * Create the definitions for the schema fields
	 *
	 * @param generatedColumns class to hold generated columns
	 * @param columnName       column name
	 * @param isUpdateable     updateable
	 * @param isMandatory      mandatory
	 * @param displayType      display type
	 * @param AD_Reference_ID  validation reference
	 * @param fieldLength      int
	 * @param defaultValue     default value
	 * @param ValueMin         String
	 * @param ValueMax         String
	 * @param VFormat          String
	 * @param Callout          String
	 * @param Name             String
	 * @param Description      String
	 * @param virtualColumn    virtual column
	 * @param IsEncrypted      stored encrypted
	 * @return set/get method
	 */
	private void createFields(GeneratedColumns generatedColumns, String columnName, boolean isUpdateable,
			boolean isMandatory, int displayType, int AD_Reference_ID, int fieldLength, String defaultValue, String ValueMin,
			String ValueMax, String VFormat, String Callout, String Name, String Description, boolean virtualColumn,
			boolean IsEncrypted, boolean IsKey, int AD_Table_ID) {
		Class<?> clazz = ModelInterfaceGenerator.getClass(columnName, displayType, AD_Reference_ID);
		String dataType = ModelInterfaceGenerator.getDataTypeName(clazz, displayType);
		if (defaultValue == null) {
			defaultValue = "";
		}
		if (DisplayType.isLOB(displayType)) {
			//	No length check for LOBs
			fieldLength = 0;
		}
		boolean shouldSkipInputField =
				columnName.equals("Created") || columnName.equals("CreatedBy") || columnName.equals("Updated") ||
						columnName.equals("UpdatedBy") || columnName.equals("AD_Client_ID") || virtualColumn;

		// TODO - New functionality
		// 1) Must understand which class to reference
		if (DisplayType.isID(displayType) && !IsKey) {
			String fieldName = ModelInterfaceGenerator.getFieldName(columnName);
			String referenceClassName =
					ModelInterfaceGenerator.getReferenceClassName(AD_Table_ID, columnName, displayType, AD_Reference_ID);
			//
			if (fieldName != null && referenceClassName != null) {
				if (!columnName.contains("_ID")) {
					fieldName = columnName;
				}
				if (Description != null && !Description.isEmpty()) {
					generatedColumns.regularModel.append("\t# ").append(Description).append("\n");
				}
				String[] packagePath = referenceClassName.split("\\.");
				referenceClassName = packagePath[packagePath.length - 1].substring(2);
				generatedColumns.regularModel.append("\t").append(fieldName).append(": ").append(referenceClassName);
				if (isMandatory || displayType == DisplayType.Binary) {
					generatedColumns.regularModel.append("!");
				}
				generatedColumns.regularModel.append("\n");
				// We don't generate inputs for these columns
				if (shouldSkipInputField) {
					return;
				}
				generatedColumns.inputModel.append("\t");
				if (Description != null && !Description.isEmpty()) {
					generatedColumns.inputModel.append("# ").append(Description).append("\n\t");
				}
				generatedColumns.inputModel.append(fieldName).append(": ").append(referenceClassName).append("Input");
				generatedColumns.inputModel.append("\n");
			} else if (columnName.equals("AD_Language")) {
				addGraphQLFields(generatedColumns, columnName, Description, columnName, isMandatory, shouldSkipInputField);
			} else if (columnName.equals("EntityType")) {
				addGraphQLFields(generatedColumns, columnName, Description, "AD_EntityType", isMandatory,
						shouldSkipInputField);
			} else {
				String columnNameWithSuffixedIdRemoved = columnName.substring(0, columnName.length() - 3);
				if (columnName.endsWith("_ID") &&
						MTable.get(Env.getCtx(), columnNameWithSuffixedIdRemoved) != null) {
					String entityName = columnNameWithSuffixedIdRemoved;
					addGraphQLFields(generatedColumns, entityName, Description, entityName, isMandatory, shouldSkipInputField);
				} else if (columnName.equals("Logo_ID")) {
					String entityName = columnNameWithSuffixedIdRemoved;
					addGraphQLFields(generatedColumns, entityName, Description, "AD_Image", isMandatory, shouldSkipInputField);
				} else {
					log.warning("Did not generate a field for: " + columnName);
				}
			}
			return;
		} else if (columnName.endsWith("_UU")) {
			generatedColumns.regularModel.append("\tID: ID!\n");
			generatedColumns.inputModel.append("\tID: ID\n");
			return;
		} else if (IsKey) {
			return;
		}

		if (Description != null && !Description.isEmpty()) {
			generatedColumns.regularModel.append("\t# ").append(Description).append("\n");
			if (!shouldSkipInputField) {
				generatedColumns.inputModel.append("\t# ").append(Description).append("\n");
			}
		}
		String neededPropertySuffix = "";
		if (AD_Reference_ID > 0) {
			neededPropertySuffix = "_RL";
		}
		generatedColumns.regularModel.append("\t").append(columnName).append(neededPropertySuffix).append(": ");
		if (!shouldSkipInputField) {
			generatedColumns.inputModel.append("\t").append(columnName).append(neededPropertySuffix).append(": ");
		}

		if (clazz.equals(Integer.class) || clazz.equals(BigDecimal.class)) {
			generatedColumns.regularModel.append("Int");
			if (!shouldSkipInputField) {
				generatedColumns.inputModel.append("Int");
			}
		} else if (clazz.equals(Boolean.class)) {
			generatedColumns.regularModel.append("Boolean");
			if (!shouldSkipInputField) {
				generatedColumns.inputModel.append("Boolean");
			}
		} else if (clazz.equals(Timestamp.class)) {
			generatedColumns.regularModel.append("Date");
			if (!shouldSkipInputField) {
				generatedColumns.inputModel.append("Date");
			}
		} else if (clazz.equals(byte[].class)) {
			generatedColumns.regularModel.append("String");
			if (!shouldSkipInputField) {
				generatedColumns.inputModel.append("String");
			}
		} else if (AD_Reference_ID > 0) {
			generatedColumns.regularModel.append("AD_Ref_List");
			if (!shouldSkipInputField) {
				generatedColumns.inputModel.append("AD_Ref_ListInput");
			}
		} else {
			generatedColumns.regularModel.append(dataType);
			if (!shouldSkipInputField) {
				generatedColumns.inputModel.append(dataType);
			}
		}
		if (isMandatory || clazz.equals(Boolean.class)) {
			generatedColumns.regularModel.append("!");
		}
		generatedColumns.regularModel.append("\n");
		if (!shouldSkipInputField) {
			generatedColumns.inputModel.append("\n");
		}
	}

	/**
	 * Add the appropriate fields to the generated columns
	 *
	 * @param generatedColumns     The columns for the different types
	 * @param columnName           The column name to use
	 * @param description          A description of the column
	 * @param fieldType            What type the field resolves to
	 * @param isMandatory          Whether the field is mandatory
	 * @param shouldSkipInputField Whether the input should leverage this field
	 */
	private void addGraphQLFields(GeneratedColumns generatedColumns, String columnName, String description,
			String fieldType, boolean isMandatory, boolean shouldSkipInputField) {
		if (description != null && !description.isEmpty()) {
			generatedColumns.regularModel.append("\t# ").append(description).append("\n");
			if (!shouldSkipInputField) {
				generatedColumns.inputModel.append("\t# ").append(description).append("\n");
			}
		}
		String entityName = columnName.substring(0, columnName.length() - 3);
		generatedColumns.regularModel.append("\t").append(columnName).append(": ").append(fieldType);
		if (!shouldSkipInputField) {
			generatedColumns.inputModel.append("\t").append(columnName).append(": ").append(fieldType).append("Input");
		}
		if (isMandatory) {
			generatedColumns.regularModel.append("!");
		}
		generatedColumns.regularModel.append("\n");
		if (!shouldSkipInputField) {
			generatedColumns.inputModel.append("\n");
		}
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
	public static void generateSource(String entityType, String tableName, String columnEntityType,
			String sourceFolder) {
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
				.append("WHERE IsActive = 'Y' ");
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

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = DB.prepareStatement(sql.toString(), null);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				new GraphQLSchemaGenerator(resultSet.getInt(1), directory.toString(), columnFilter);
			}
		} catch (SQLException e) {
			throw new DBException(e, sql.toString());
		} finally {
			DB.close(resultSet, preparedStatement);
			resultSet = null;
			preparedStatement = null;
		}
	}

	static class GeneratedColumns {
		final StringBuilder regularModel;
		final StringBuilder inputModel;

		public GeneratedColumns(StringBuilder regularModel, StringBuilder inputModel) {
			this.regularModel = regularModel;
			this.inputModel = inputModel;
		}
	}
}
