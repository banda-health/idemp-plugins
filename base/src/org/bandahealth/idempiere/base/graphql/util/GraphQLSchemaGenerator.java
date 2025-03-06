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
import org.compiere.model.MReference;
import org.compiere.model.MTable;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.Util;

import java.io.File;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

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

		GraphQLUtil.writeToFile(stringBuilder, directory + fileName + ".graphqls");
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
		try (PreparedStatement preparedStatement = DB.prepareStatement(sql, null)) {
			preparedStatement.setInt(1, AD_Table_ID);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					tableName = resultSet.getString(1);
				}
			}
		} catch (SQLException e) {
			throw new DBException(e, sql);
		}
		if (tableName == null) {
			throw new RuntimeException("TableName not found for ID=" + AD_Table_ID);
		}

		stringBuilder
				// File generation details
				.append("# Generated Schema for ").append(tableName).append(" - DO NOT CHANGE\n")
				.append("#\t\t@author Banda Health (generated) ").append("\n")
				.append("#\t\t@version ").append(Adempiere.MAIN_VERSION).append(" - $Id$").append("\n")

				// Default Queries
				.append("extend type Query {\n")
				.append("\t").append(tableName).append("(UU: String!): ").append(tableName).append("\n")
				.append("\t").append(tableName).append("Get(Page: Int, Size: Int, Sort: String, Filter: String): ")
				.append(tableName).append("Connection!\n")
				.append("}\n\n")

				// Default Mutations
				.append("extend type Mutation {\n")
				.append("\t").append(tableName).append("Save(Entity: ").append(tableName).append("Input!): ").append(tableName)
				.append("!\n")
				.append("\t").append(tableName).append("SaveMany(Entities: [").append(tableName).append("Input!]!): [")
				.append(tableName).append("!]!\n")
				.append("\t").append(tableName).append("Delete(UUs: [String!]!): Boolean!\n}\n\n")

				// Connection Type
				.append("type ").append(tableName).append("Connection {\n")
				.append("\tResults: [").append(tableName).append("!]!\n")
				.append("\tPagingInfo: PagingInfo!\n}\n\n")

				// Regular type
				.append("type ").append(tableName).append(" {\n")
				.append(generatedColumns.regularModel).append("}\n\n")

				// Input type
				.append("input ").append(tableName).append("Input {\n")
				.append(generatedColumns.inputModel).append("}\n");

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
		String sql = "SELECT c.ColumnName, c.IsMandatory, c.AD_Reference_ID, "    //	1..3
				+ " c.AD_Reference_Value_ID, SeqNo, c.Description, c.ColumnSQL, "  //	4..7
				+ " c.IsKey, c.IsIdentifier "  // 8..9
				+ "FROM AD_Column c "
				+ "WHERE c.AD_Table_ID=?"
				+ " AND c.IsActive='Y'"
				+ (!Util.isEmpty(entityTypeFilter) ? " AND c." + entityTypeFilter : "")
				+ " ORDER BY c.ColumnName";
		boolean isKeyNamePairCreated = false; // true if the method "getKeyNamePair" is already generated
		try (PreparedStatement preparedStatement = DB.prepareStatement(sql, null)) {
			preparedStatement.setInt(1, AD_Table_ID);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					String columnName = resultSet.getString(1);
					boolean isMandatory = "Y".equals(resultSet.getString(2));
					int displayType = resultSet.getInt(3);
					int AD_Reference_Value_ID = resultSet.getInt(4);
					int seqNo = resultSet.getInt(5);
					String Description = resultSet.getString(6);
					String ColumnSQL = resultSet.getString(7);
					boolean virtualColumn = ColumnSQL != null && !ColumnSQL.isEmpty();
					boolean IsKey = "Y".equals(resultSet.getString(8));
					boolean IsIdentifier = "Y".equals(resultSet.getString(9));
					//
					createFields(generatedColumns, columnName, isMandatory, displayType, AD_Reference_Value_ID, Description,
							virtualColumn, IsKey, AD_Table_ID);
					//
					if (seqNo == 1 && IsIdentifier) {
						if (!isKeyNamePairCreated) {
							isKeyNamePairCreated = true;
						} else {
							String msgException =
									"More than one primary identifier found " + " (AD_Table_ID=" + AD_Table_ID + ", ColumnName=" +
											columnName + ")";
							throw new RuntimeException(msgException);
						}
					}
				}
			}
		} catch (SQLException e) {
			throw new DBException(e, sql);
		}
		return generatedColumns;
	}

	/**
	 * Create the definitions for the schema fields
	 *
	 * @param generatedColumns class to hold generated columns
	 * @param columnName       column name
	 * @param isMandatory      mandatory
	 * @param displayType      display type
	 * @param AD_Reference_ID  validation reference
	 * @param Description      String
	 * @param virtualColumn    virtual column
	 * @return set/get method
	 */
	private void createFields(GeneratedColumns generatedColumns, String columnName, boolean isMandatory, int displayType,
			int AD_Reference_ID, String Description, boolean virtualColumn, boolean IsKey, int AD_Table_ID) {
		Class<?> clazz = ModelInterfaceGenerator.getClass(columnName, displayType, AD_Reference_ID);
		String dataType = ModelInterfaceGenerator.getDataTypeName(clazz, displayType);
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
				if (columnName.equals("CreatedBy") || columnName.equals("UpdatedBy")) {
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
				generatedColumns.inputModel.append(fieldName).append(": ForeignEntityInput");
				generatedColumns.inputModel.append("\n");
			} else if (columnName.equals("AD_Language")) {
				addGraphQLFields(generatedColumns, columnName, Description, columnName, isMandatory,
						shouldSkipInputField);
			} else if (columnName.equals("EntityType")) {
				addGraphQLFields(generatedColumns, "AD_EntityType", Description, "AD_EntityType", isMandatory,
						shouldSkipInputField);
			} else {
				String columnNameWithSuffixedIdRemoved = columnName.substring(0, columnName.length() - 3);
				if (columnName.endsWith("_ID") &&
						MTable.get(Env.getCtx(), AD_Table_ID).getColumn(columnNameWithSuffixedIdRemoved) == null &&
						MTable.get(Env.getCtx(), columnNameWithSuffixedIdRemoved) != null) {
					addGraphQLFields(generatedColumns, columnNameWithSuffixedIdRemoved, Description,
							columnNameWithSuffixedIdRemoved, isMandatory, shouldSkipInputField);
				} else if (columnName.equals("Logo_ID")) {
					addGraphQLFields(generatedColumns, columnNameWithSuffixedIdRemoved, Description, "AD_Image", isMandatory,
							shouldSkipInputField);
				} else if (columnName.equals("BH_To_Warehouse_ID") || columnName.equals("BH_From_Warehouse_ID")) {
					addGraphQLFields(generatedColumns, columnNameWithSuffixedIdRemoved, Description, "M_Warehouse", isMandatory,
							shouldSkipInputField);
				} else if (columnName.equals("From_BH_Concept_ID") || columnName.equals("To_BH_Concept_ID")) {
					addGraphQLFields(generatedColumns, columnNameWithSuffixedIdRemoved, Description, "BH_Concept", isMandatory,
							shouldSkipInputField);
				} else {
					log.warning("Did not generate a field for: " + columnName);
				}
			}
			return;
		} else if (columnName.equalsIgnoreCase(MTable.get(AD_Table_ID).getTableName() + "_UU")) {
			generatedColumns.regularModel.append("\tUU: ID!\n");
			generatedColumns.inputModel.append("\tUU: ID\n");
			return;
		} else if (columnName.endsWith("_UU")) {
			log.warning("Did not generate a field for: " + columnName);
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
		generatedColumns.regularModel.append("\t").append(columnName).append(": ");
		if (!shouldSkipInputField) {
			generatedColumns.inputModel.append("\t").append(columnName).append(": ");
		}

		if (clazz.equals(Integer.class)) {
			generatedColumns.regularModel.append("Int");
			if (!shouldSkipInputField) {
				generatedColumns.inputModel.append("Int");
			}
		} else if (clazz.equals(BigDecimal.class)) {
			generatedColumns.regularModel.append("BigDecimal");
			if (!shouldSkipInputField) {
				generatedColumns.inputModel.append("BigDecimal");
			}
		} else if (clazz.equals(Boolean.class)) {
			generatedColumns.regularModel.append("Boolean");
			if (!shouldSkipInputField) {
				generatedColumns.inputModel.append("Boolean");
			}
		} else if (displayType == 15) { // Date
			generatedColumns.regularModel.append("Date");
			if (!shouldSkipInputField) {
				generatedColumns.inputModel.append("Date");
			}
		} else if (clazz.equals(Timestamp.class)) {
			generatedColumns.regularModel.append("DateTime");
			if (!shouldSkipInputField) {
				generatedColumns.inputModel.append("DateTime");
			}
		} else if (clazz.equals(byte[].class)) {
			generatedColumns.regularModel.append("Binary");
			if (!shouldSkipInputField) {
				generatedColumns.inputModel.append("Binary");
			}
		} else if ((AD_Reference_ID > 0 &&
				MReference.get(AD_Reference_ID).getValidationType().equals(MReference.VALIDATIONTYPE_ListValidation) ||
				displayType == DisplayType.Payment) && clazz.equals(String.class)) {
			generatedColumns.regularModel.append("AD_Ref_List");
			if (!shouldSkipInputField) {
				generatedColumns.inputModel.append("ForeignEntityInput");
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
		generatedColumns.regularModel.append("\t").append(columnName).append(": ").append(fieldType);
		if (!shouldSkipInputField) {
			generatedColumns.inputModel.append("\t").append(columnName).append(": ForeignEntityInput");
		}
		if (isMandatory) {
			generatedColumns.regularModel.append("!");
		}
		generatedColumns.regularModel.append("\n");
		if (!shouldSkipInputField) {
			generatedColumns.inputModel.append("\n");
		}
	}

	/**
	 * @param sourceFolder
	 * @param entityType
	 * @param tableName
	 * @param columnEntityType
	 */
	public static void generateSource(String entityType, String tableName, String columnEntityType,
			String sourceFolder) {
		//
		String directory =
				GraphQLUtil.validateSourceFolderTableNameAndGetFileOutputDirectory(sourceFolder, tableName);
		String columnFilter = GraphQLUtil.getColumnFilter(columnEntityType);
		//
		GraphQLUtil.buildAndExecuteTableSql(tableName, entityType,
				(resultSet -> new GraphQLSchemaGenerator(resultSet.getInt(1), directory, columnFilter)));
	}

	record GeneratedColumns(StringBuilder regularModel, StringBuilder inputModel) {
	}
}
