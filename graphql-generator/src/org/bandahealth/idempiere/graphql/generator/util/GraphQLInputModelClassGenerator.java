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
import org.compiere.model.MRefList;
import org.compiere.model.MReference;
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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.logging.Level;

/**
 * Generate GraphQL Schemas.
 *
 * @author Kevin Burnett
 */
public class GraphQLInputModelClassGenerator {
	private static final CLogger log = CLogger.getCLogger(GraphQLInputModelClassGenerator.class);
	private String packageName = "";
	private ModelMap tableStructureExtensions;
	private Map<String, ModelMap> modelsForTables;
	private TreeSet<String> privateProperties = new TreeSet<>();

	/**
	 * Generate Schema
	 *
	 * @param AD_Table_ID      table id
	 * @param directory        directory
	 * @param entityTypeFilter entity type filter for columns
	 */
	public GraphQLInputModelClassGenerator(int AD_Table_ID, String entityTypeFilter, String directory,
			String packageName, Map<String, ModelMap> modelsForTables) throws FileNotFoundException {
		this.packageName = packageName;
		this.modelsForTables = modelsForTables;

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

		writeToFile(generatedColumns, directory + fileName + ".java");
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

		String className = "X_" + tableName + "Input";
		String interfaceName = "I_" + tableName + "Input";
		StringBuilder generatedClass = new StringBuilder()
				.append("package ").append(packageName).append(";\n\n");
		boolean hasIDColumn = MTable.get(Env.getCtx(), AD_Table_ID).getColumnIndex(tableName + "_ID") >= 0;

		// Insert the required iDempiere imports
		classesToImport.add("org.compiere.model.Query");
		classesToImport.add(tableStructureExtensions.getClassPackageName() + "." + tableStructureExtensions.getClassName());
		boolean hasUuidColumn = generatedColumns.toString().contains("public void setUUID(String UUID)");
		if (hasUuidColumn) {
			classesToImport.add("com.fasterxml.jackson.annotation.JsonCreator");
			classesToImport.add("com.fasterxml.jackson.annotation.JsonProperty");
			classesToImport.add("org.bandahealth.idempiere.graphql.utils.ModelUtil");
		}
		classesToImport.add("java.sql.ResultSet");
		classesToImport.add("org.compiere.util.Env");

		createImports(generatedClass);
		generatedClass
				.append("/**\n * Generated Model for ").append(tableName).append(" - DO NOT CHANGE\n *\n")
				.append(" * @author Banda Health (generated)").append("\n")
				.append(" * @version ").append(Adempiere.MAIN_VERSION).append(" - $Id$").append("\n */\n")

				// Class definition
				.append("public class ").append(className).append(" extends ")
				.append(tableStructureExtensions.getClassName()).append(" implements ").append(interfaceName)
				.append(" {\n\n");

		createPrivateProperties(generatedClass);
		if (hasUuidColumn) {
			generatedClass
					.append("\t/**\n\t * Standard constructor (don't forget to use @JsonCreator and @JsonProperty\n")
					.append("\t * annotations from the super class since those aren't inherited)\n")
					.append("\t *\n")
					.append("\t * @param UUID The ").append(tableName).append("_UU to fetch this entity from the DB\n\t */\n")
					.append("\t@JsonCreator\n")
					.append("\tpublic ").append(className).append("(@JsonProperty(\"UUID\") String UUID) {\n");
			// If we have the UUID, we can leverage the ID constructor
			// Otherwise we'll use the result set constructor
			if (hasIDColumn) {
				generatedClass
						.append("\t\tsuper(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);\n");
			} else {
				generatedClass
						.append("\t\tsuper(Env.getCtx(), ModelUtil.getModelResultSet(new ")
						.append(tableStructureExtensions.getClassName())
						.append("(null, (ResultSet) null, null),\n")
						.append("\t\t\t\tnull, Table_Name, UUID), null);\n");
			}
			generatedClass
					.append("\t\tsetUUID(UUID);\n")
					.append("\t}");
		} else {
			generatedClass
					.append("\t/**\n\t * Standard constructor\n\t */\n")
					.append("\tpublic ").append(className).append("() {\n");
			if (hasIDColumn) {
				generatedClass
						.append("\t\tsuper(Env.getCtx(), 0, null);\n");
			} else {
				generatedClass
						.append("\t\tsuper(Env.getCtx(), (ResultSet) null, null);\n");
			}
			generatedClass
					.append("\t}");
		}

		generatedColumns.insert(0, generatedClass);
		generatedColumns.append("\n}\n");

		return className;
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
		String sql = "SELECT c.ColumnName, c.IsUpdateable, c.IsMandatory,"    //	1..3
				+ " c.AD_Reference_ID, c.AD_Reference_Value_ID, DefaultValue, SeqNo, "  //	4..7
				+ " c.FieldLength, c.ValueMin, c.ValueMax, c.VFormat, c.Callout, "  //	8..12
				+ " c.Name, c.Description, c.ColumnSQL, c.IsEncrypted, c.IsKey, "  // 13..17
				+ " c.entitytype "
				+ "FROM AD_Column c "
				+ "WHERE c.AD_Table_ID=?"
				+ " AND c.IsActive='Y'"
				+ (!Util.isEmpty(entityTypeFilter) ? " AND c." + entityTypeFilter : "")
				+ " ORDER BY c.ColumnName";
		try (PreparedStatement preparedStatement = DB.prepareStatement(sql, null)) {
			preparedStatement.setInt(1, AD_Table_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
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
				boolean virtualColumn = ColumnSQL != null && !ColumnSQL.isEmpty();
				boolean IsEncrypted = "Y".equals(resultSet.getString(16));
				boolean IsKey = "Y".equals(resultSet.getString(17));
				String entityType = resultSet.getString(18);
				//
				generatedColumns.append(
						createColumnMethods(columnName, isUpdatable, isMandatory, displayType, AD_Reference_Value_ID, fieldLength,
								defaultValue, ValueMin, ValueMax, VFormat, Callout, Name, Description, virtualColumn, IsEncrypted,
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
			String entityType, int AD_Table_ID) {
		Class<?> clazz = ModelInterfaceGenerator.getClass(columnName, displayType, AD_Reference_ID);
		String dataType = ModelInterfaceGenerator.getDataTypeName(clazz, displayType);
		if (defaultValue == null) {
			defaultValue = "";
		}

		//	Set	********
		String setValue = "set_Value";
		if (IsEncrypted) {
			setValue = "set_ValueE";
		}
		// Handle isUpdatable
		if (!isUpdateable) {
			setValue = "set_ValueNoCheck";
			if (IsEncrypted) {
				setValue = "set_ValueNoCheckE";
			}
		}

		StringBuilder columnBuilder = new StringBuilder();

		if (columnName.equals("Created") || columnName.equals("CreatedBy") || columnName.equals("Updated") ||
				columnName.equals("UpdatedBy") || columnName.equals("AD_Client_ID")) {
			return "";
		}

		// We will ignore typical Java POJO methods so that we can ensure the correct method is used when a super-class
		// may already have a method defined
		// See ordering at: https://www.graphql-java-kickstart.com/tools/schema-definition/#field-mapping-priority

		// TODO - New functionality
		// 1) Must understand which class to reference
		if (DisplayType.isID(displayType) && !IsKey) {
			String fieldName = ModelInterfaceGenerator.getFieldName(columnName);
			String referenceClassName =
					ModelInterfaceGenerator.getReferenceClassName(AD_Table_ID, columnName, displayType, AD_Reference_ID);

			String foreignEntityTable = "";
			String entityName = "";
			String returnType = "";
			String defaultValueMethod = "get_ID()";
			String defaultEmptyValue = "0";
			if (fieldName != null && referenceClassName != null) {
				// This entity is a foreign key, so let's work with it
				String[] packagePath = referenceClassName.split("\\.");
				referenceClassName = packagePath[packagePath.length - 1].substring(2);
				entityName = fieldName;
				returnType = "I_" + referenceClassName + "Input";
				foreignEntityTable = referenceClassName;
			} else if (columnName.equals("AD_Language")) {
				entityName = columnName;
				returnType = "I_" + columnName + "Input";
				foreignEntityTable = columnName;
				defaultValueMethod = "getAD_Language()";
				defaultEmptyValue = "null";
			} else if (columnName.equals("EntityType")) {
				entityName = "AD_EntityType";
				returnType = "I_" + entityName + "Input";
				foreignEntityTable = entityName;
				defaultValueMethod = "getEntityType()";
				defaultEmptyValue = "null";
			} else {
				String columnNameWithSuffixedIdRemoved = columnName.substring(0, columnName.length() - 3);
				if (columnName.endsWith("_ID") &&
						MTable.get(Env.getCtx(), AD_Table_ID).getColumn(columnNameWithSuffixedIdRemoved) == null &&
						MTable.get(Env.getCtx(), columnNameWithSuffixedIdRemoved) != null) {
					entityName = columnNameWithSuffixedIdRemoved;
					returnType = "I_" + columnNameWithSuffixedIdRemoved + "Input";
					foreignEntityTable = entityName;
				} else if (columnName.equals("Logo_ID")) {
					entityName = columnNameWithSuffixedIdRemoved;
					returnType = "I_AD_ImageInput";
					foreignEntityTable = "AD_Image";
				} else if (columnName.equals("BH_To_Warehouse_ID") || columnName.equals("BH_From_Warehouse_ID")) {
					entityName = columnNameWithSuffixedIdRemoved;
					returnType = "I_M_WarehouseInput";
					foreignEntityTable = "M_Warehouse";
				} else {
					log.warning("Did not generate a field for: " + columnName);
					return "";
				}
			}

			columnBuilder.append("\n");

			// Make sure that a private property is set correctly
			String propertyName = "m" + entityName;
//			privateProperties.add(returnType + " " + propertyName);
			privateProperties.add("ForeignEntityInput " + propertyName);
			generateJavaSetComment(entityName, Name, Description, columnBuilder);
			ModelMap foreignEntityModelMap = modelsForTables.get(foreignEntityTable);
			String modelForForeignEntity;
			if (foreignEntityModelMap == null) {
				log.warning(
						"Did not have any model or anything mapped for " + foreignEntityTable + ", so resorting to PO");
				addImportClass("org.compiere.model.PO");
				modelForForeignEntity = "PO";
			} else {
				classesToImport.add(foreignEntityModelMap.getClassPackageName() + "." + foreignEntityModelMap.getClassName());
				modelForForeignEntity = foreignEntityModelMap.getClassName();
			}
			classesToImport.add("com.fasterxml.jackson.annotation.JsonProperty");
			columnBuilder
					.append("\t@JsonProperty(\"").append(entityName).append("\")\n")
					.append("\tpublic void set").append(entityName).append("Input(ForeignEntityInput ").append(entityName)
					.append(") {\n")
					.append("\t\tthis.").append(propertyName).append(" = ").append(entityName).append(";\n");
			if (!isUpdateable) {
				columnBuilder
						.append("\t\tif (get_ID() != 0) {\n")
						.append("\t\t\treturn;\n")
						.append("\t\t}\n");
			}
			columnBuilder
					.append("\t\tif (").append(entityName).append(" != null) {\n")
					.append("\t\t\t// Since an entity was passed, make sure it's in the DB\n")
					.append("\t\t\t").append(modelForForeignEntity).append(" foreignEntity;\n")
					.append("\t\t\tif ((foreignEntity =\n")
					.append("\t\t\t\t\tnew Query(getCtx(), \"").append(foreignEntityTable).append("\", \"")
					.append(foreignEntityTable).append("_UU=?\", get_TrxName())\n")
					.append("\t\t\t\t\t\t\t.setParameters(").append(entityName).append(".getUUID())")
					.append(".first()) != null && foreignEntity.get_ID() >= 0) {\n")
					.append("\t\t\t\tthis.set").append(columnName).append("(foreignEntity.").append(defaultValueMethod)
					.append(");\n")
					.append("\t\t\t} else {\n")
					.append("\t\t\t\tthrow new AdempiereException(\n")
					.append("\t\t\t\t\t\t\"Could not find entity in table ").append(foreignEntityTable)
					.append(" with UUID \" + ").append(entityName).append(".getUUID());\n")
					.append("\t\t\t}\n")
					.append("\t\t} else {\n")
					.append("\t\t\tthis.set").append(columnName).append("(").append(defaultEmptyValue).append(");\n")
					.append("\t\t}\n")
					.append("\t}\n");
			classesToImport.add("org.adempiere.exceptions.AdempiereException");

			generateJavaGetComment(Name, Description, columnBuilder);
			columnBuilder
					.append("\t@JsonProperty(\"").append(entityName).append("\")\n")
//					.append("\tpublic ").append(returnType).append(" ").append(entityName).append("() {\n")
					.append("\tpublic ForeignEntityInput ").append(entityName).append("() {\n")
					.append("\t\treturn ").append(propertyName).append(";\n")
					.append("\t}");

//			addImportClass(clazz);

			return columnBuilder.toString();
		} else if (columnName.endsWith("_UU")) {
			// If this is the UUID column, we need to generate the UUID fields
			columnBuilder.append("\n");
			generateJavaSetComment("UUID", "UUID", Description, columnBuilder);
			columnBuilder
					.append("\tpublic void setUUID(String UUID) {\n")
					.append("\t\tset").append(columnName).append("(UUID);\n")
					.append("\t}\n");
			generateJavaGetComment("UUID", Description, columnBuilder);
			columnBuilder
					.append("\tpublic String getUUID() {\n")
					.append("\t\treturn get").append(columnName).append("();\n")
					.append("\t}");

			// Since the UUID is always defined on the base, generated model, return
			return columnBuilder.toString();
		}
//
//		// If the column is user-maintained and the table isn't, we need to generate
//		boolean wereColumnMethodsGeneratedElsewhere = !(entityType.equals(MEntityType.ENTITYTYPE_UserMaintained) &&
//				!MTable.get(AD_Table_ID).getEntityType().equals(MEntityType.ENTITYTYPE_UserMaintained));
//		if (!wereColumnMethodsGeneratedElsewhere) {
//			columnBuilder.append("\n");
//			// Create Java Comment
//			generateJavaSetComment(columnName, Name, Description, columnBuilder);
//
//			//	public void setColumn (xxx variable)
//			columnBuilder
//					.append("\tpublic void set").append(columnName).append("(").append(dataType).append(" ").append(columnName)
//					.append(") {\n");
//
//			//	List Validation
//			if (AD_Reference_ID != 0 && String.class == clazz) {
//				String staticVar = addListValidation(columnBuilder, AD_Reference_ID, columnName);
//				columnBuilder.insert(0, staticVar);
//			}
//
//			//	Payment Validation
//			if (displayType == DisplayType.Payment) {
//				String staticVar = addListValidation(columnBuilder, REFERENCE_PAYMENTRULE, columnName);
//				columnBuilder.insert(0, staticVar);
//			} else if (clazz.equals(Integer.class)) {
//				String optionalIndent = "";
//				String optionalClose = "";
//				if (columnName.endsWith("_ID")) {
//					int firstOK = 1;
//					//	check special column
//					if (columnName.equals("AD_Org_ID") || columnName.equals("Record_ID") || columnName.equals
//					("C_DocType_ID") ||
//							columnName.equals("Node_ID") || columnName.equals("AD_Role_ID") ||
//							columnName.equals("M_AttributeSet_ID") || columnName.equals("M_AttributeSetInstance_ID")) {
//						firstOK = 0;
//					}
//					//	set _ID to null if < 0 for special column or < 1 for others
//					columnBuilder
//							.append("\t\tif (").append(columnName).append(" < ").append(firstOK).append(") {\n")
//							.append("\t\t\t").append(setValue).append("(COLUMNNAME_").append(columnName).append(", null);\n")
//							.append("\t\t} else {\n");
//					optionalIndent = "\t";
//					optionalClose = "\t\t}\n";
//				}
//				columnBuilder
//						.append(optionalIndent).append("\t\t").append(setValue).append("(COLUMNNAME_").append(columnName)
//						.append(", ").append(columnName).append(");\n")
//						.append(optionalClose);
//			} else if (clazz.equals(Boolean.class)) {
//				columnBuilder
//						.append("\t\t").append(setValue).append("(COLUMNNAME_").append(columnName).append(", ")
//						.append(columnName).append(");\n");
//			} else {
//				columnBuilder
//						.append("\t\t").append(setValue).append("(COLUMNNAME_").append(columnName).append(", ")
//						.append(columnName).append(");\n");
//			}
//			columnBuilder
//					.append("\t}\n\n");
//
//
//			//	****** Get Comment ******
//			generateJavaGetComment(Name, Description, columnBuilder);
//
//			//	Get	********
//			String getValue = "get_Value";
//			if (IsEncrypted) {
//				getValue = "get_ValueE";
//			}
//
//			columnBuilder.append("\tpublic ").append(dataType);
//			if (clazz.equals(Boolean.class)) {
//				columnBuilder.append(" is");
//				if (columnName.toLowerCase().startsWith("is")) {
//					columnBuilder.append(columnName.substring(2));
//				} else {
//					columnBuilder.append(columnName);
//				}
//			} else {
//				columnBuilder.append(" get").append(columnName);
//			}
//			columnBuilder
//					.append("() {\n ");
//			if (clazz.equals(Integer.class)) {
//				columnBuilder
//						.append("\t\tInteger columnValue = (Integer) ").append(getValue).append("(COLUMNNAME_").append
//						(columnName)
//						.append(");\n")
//						.append("\t\tif (columnValue == null) {\n")
//						.append("\t\t\treturn 0;\n")
//						.append("\t\t}\n")
//						.append("\t\treturn columnValue;\n");
//			} else if (clazz.equals(BigDecimal.class)) {
//				columnBuilder
//						.append("\t\tBigDecimal columnValue = (BigDecimal) ").append(getValue).append("(COLUMNNAME_")
//						.append(columnName)
//						.append(");\n")
//						.append("\t\tif (columnValue == null) {\n")
//						.append("\t\t\treturn Env.ZERO;\n")
//						.append("\t\t}\n")
//						.append("\t\treturn columnValue;\n");
//				addImportClass(java.math.BigDecimal.class);
//				addImportClass(org.compiere.util.Env.class);
//			} else if (clazz.equals(Boolean.class)) {
//				columnBuilder
//						.append("\t\tObject columnValue = ").append(getValue).append("(COLUMNNAME_").append(columnName)
//						.append(");\n")
//						.append("\t\tif (columnValue != null) {\n")
//						.append("\t\t\tif (columnValue instanceof Boolean) {\n")
//						.append("\t\t\t\treturn ((Boolean) columnValue);\n")
//						.append("\t\t\t}\n")
//						.append("\t\t\treturn \"Y\".equals(columnValue);\n")
//						.append("\t\t}\n")
//						.append("\t\treturn false;\n");
//			} else if (dataType.equals("Object")) {
//				columnBuilder
//						.append("\t\treturn ").append(getValue).append("(COLUMNNAME_").append(columnName).append(");\n");
//			} else {
//				columnBuilder
//						.append("\t\treturn (").append(dataType).append(") ").append(getValue)
//						.append("(COLUMNNAME_").append(columnName).append(");\n");
//				addImportClass(clazz);
//			}
//			columnBuilder
//					.append("\t}\n");
//		}

		// If the code is updatable from this point forward, the parent class can (potentially) handle it
		// Also, if the method is final somewhere in the iDempiere model tree, skip it
		List<String> columnsWhosSettersAreFinalInIDempiere = Arrays.asList("AD_Org_ID", "IsActive");
		if ((isUpdateable && AD_Reference_ID <= 0) || columnsWhosSettersAreFinalInIDempiere.contains(columnName)) {
			return columnBuilder.toString();
		} else if (AD_Reference_ID > 0 &&
				MReference.get(AD_Reference_ID).getValidationType().equals(MReference.VALIDATIONTYPE_ListValidation) &&
				clazz.equals(String.class)) {
			ModelMap classToUseMap = modelsForTables.get(MRefList.Table_Name);
			classesToImport.add(classToUseMap.getClassPackageName() + "." + classToUseMap.getClassName());
			classesToImport.add("com.fasterxml.jackson.annotation.JsonProperty");
			columnBuilder.append("\n");
			String returnType = "I_AD_Ref_ListInput";

			// Make sure that a private property is set correctly
			String propertyName = "m" + columnName;
			privateProperties.add(returnType + " " + propertyName);
			generateJavaSetComment(columnName, Name, Description, columnBuilder);
			String modelForForeignEntity = classToUseMap.getClassName();
			columnBuilder
					.append("\t@JsonProperty(\"").append(columnName).append("\")\n")
					.append("\tpublic void set").append(columnName).append("Input(").append(returnType).append(" ")
					.append(columnName).append(") {\n")
					.append("\t\tthis.").append(propertyName).append(" = ").append(columnName).append(";\n");
			if (!isUpdateable) {
				columnBuilder
						.append("\t\tif (get_ID() != 0) {\n")
						.append("\t\t\treturn;\n")
						.append("\t\t}\n");
			}
			columnBuilder
					.append("\t\tif (").append(columnName).append(" != null) {\n")
					.append("\t\t\t// Since an entity was passed, make sure it's in the DB\n")
					.append("\t\t\t").append(modelForForeignEntity).append(" foreignEntity;\n")
					.append("\t\t\tif ((foreignEntity =\n")
					.append("\t\t\t\t\tnew Query(getCtx(), ").append(modelForForeignEntity).append(".Table_Name, ")
					.append(modelForForeignEntity).append(".COLUMNNAME_AD_Ref_List_UU + \"=?\", get_TrxName())\n")
					.append("\t\t\t\t\t\t\t.setParameters(").append(columnName).append(".getUUID())")
					.append(".first()) != null && foreignEntity.get_ID() >= 0) {\n")
					.append("\t\t\t\tthis.set").append(columnName).append("(foreignEntity.getValue());\n")
					.append("\t\t\t} else {\n")
					.append("\t\t\t\tthrow new AdempiereException(\n")
					.append("\t\t\t\t\t\t\"Could not find entity in table \" + ").append(modelForForeignEntity)
					.append(".Table_Name + \" with UUID \" + ").append(columnName).append(".getUUID());\n")
					.append("\t\t\t}\n")
					.append("\t\t} else {\n")
					.append("\t\t\tthis.set").append(columnName).append("(null);\n")
					.append("\t\t}\n")
					.append("\t}\n");
			classesToImport.add("org.adempiere.exceptions.AdempiereException");

			generateJavaGetComment(Name, Description, columnBuilder);
			columnBuilder
					.append("\t@JsonProperty(\"").append(columnName).append("\")\n")
					.append("\tpublic ").append(returnType).append(" ").append(columnName).append("() {\n")
					.append("\t\treturn ").append(propertyName).append(";\n")
					.append("\t}");
			return columnBuilder.toString();
		}

//		if (wereColumnMethodsGeneratedElsewhere) {
		// Since this property isn't updatable, we need to generate a method that updates the property only if the entity
		// is new
		generateJavaSetComment(columnName, Name, Description, columnBuilder);
//			String methodLocation = wereColumnMethodsGeneratedElsewhere ? "super" : "this";
		columnBuilder
				.append("\n\tpublic void set").append(columnName).append("(").append(dataType).append(" ").append(columnName)
				.append(") {\n\t\tif (get_ID() == 0) {\n")
				.append("\t\t\tsuper.set").append(columnName).append("(").append(columnName)
				.append(");\n")
				.append("\t\t}\n\t}");
		addImportClass(clazz);
//		}
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


	/**
	 * Add List Validation
	 *
	 * @param generatedCode   buffer - example:
	 *                        if (NextAction.equals("N") || NextAction.equals("F"));
	 *                        else throw new IllegalArgumentException ("NextAction Invalid value - Reference_ID=219 - N
	 *                        - F");
	 * @param AD_Reference_ID reference
	 * @param columnName      column
	 * @return static parameter - Example:
	 * public static final int NEXTACTION_AD_Reference_ID=219;
	 * public static final String NEXTACTION_None = "N";
	 * public static final String NEXTACTION_FollowUp = "F";
	 */
	private String addListValidation(StringBuilder generatedCode, int AD_Reference_ID, String columnName) {
		StringBuilder returnValue = new StringBuilder();
		if (AD_Reference_ID <= MTable.MAX_OFFICIAL_ID) {
			returnValue
					.append("\t/**\n")
					.append("\t * ").append(columnName).append(" AD_Reference_ID=").append(AD_Reference_ID).append("\n")
					.append("\t */\n")
					.append("\tpublic static final int ").append(columnName.toUpperCase())
					.append("_AD_Reference_ID=").append(AD_Reference_ID).append(";");
		}
		//
		boolean found = false;
		StringBuilder values = new StringBuilder("Reference_ID=").append(AD_Reference_ID);
		StringBuilder statement = new StringBuilder();
		//
		String sql = "SELECT Value, Name FROM AD_Ref_List WHERE AD_Reference_ID=? ORDER BY AD_Ref_List_ID";
		try (PreparedStatement preparedStatement = DB.prepareStatement(sql, null)) {
			preparedStatement.setInt(1, AD_Reference_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String value = resultSet.getString(1);
				values.append(" - ").append(value);
				if (statement.length() == 0) {
					statement.append("\n\t\tif (").append(columnName).append(".equals(\"").append(value).append("\")");
				} else {
					statement.append(" || ").append(columnName).append(".equals(\"").append(value).append("\")");
				}
				//
				if (!found) {
					found = true;
				}

				//	Name (SmallTalkNotation)
				String name = resultSet.getString(2);
				char[] nameArray = name.toCharArray();
				StringBuilder nameClean = new StringBuilder();
				boolean initCap = true;
				for (char c : nameArray) {
					if (Character.isJavaIdentifierPart(c)) {
						if (initCap) {
							nameClean.append(Character.toUpperCase(c));
						} else {
							nameClean.append(c);
						}
						initCap = false;
					} else {
						if (c == '+') {
							nameClean.append("Plus");
						} else if (c == '-') {
							nameClean.append("_");
						} else if (c == '>') {
							if (name.indexOf('<') == -1) {  //	ignore <xx>
								nameClean.append("Gt");
							}
						} else if (c == '<') {
							if (name.indexOf('>') == -1) {  //	ignore <xx>
								nameClean.append("Le");
							}
						} else if (c == '!') {
							nameClean.append("Not");
						} else if (c == '=') {
							nameClean.append("Eq");
						} else if (c == '~') {
							nameClean.append("Like");
						}
						initCap = true;
					}
				}
				returnValue
						.append("\n\t/**\n")
						.append("\t * ").append(name).append(" = ").append(value).append("\n")
						.append("\t */\n")
						.append("\tpublic static final String ").append(columnName.toUpperCase())
						.append("_").append(nameClean)
						.append(" = \"").append(value).append("\";");
			}
		} catch (SQLException e) {
			throw new DBException(e, sql);
		}
		statement.append(")")
				.append("; ")
				.append("else ")
				.append("throw new IllegalArgumentException (\"").append(columnName)
				.append(" Invalid value - \" + ").append(columnName)
				.append(" + \" - ").append(values).append("\");");
		// [1762461] - Remove hardcoded list items checking in generated models
		// if (found && !columnName.equals("EntityType"))
		//	sb.append (statement);
		generatedCode.append("\n");
		return returnValue.toString();
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
	 * Generate java imports
	 *
	 * @param generatedClass
	 */
	private void createImports(StringBuilder generatedClass) {
		boolean hasJavaImports = false;
		for (String name : classesToImport) {
			if (name.startsWith("java.")) {
				hasJavaImports = true;
				continue;
			}
			generatedClass.append("import ").append(name).append(";").append("\n");
		}
		if (hasJavaImports) {
			generatedClass.append("\n");
			for (String name : classesToImport) {
				if (!name.startsWith("java.")) {
					continue;
				}
				generatedClass.append("import ").append(name).append(";").append("\n");
			}
		}
		generatedClass.append("\n");
	}

	/**
	 * Generate java imports
	 *
	 * @param generatedClass
	 */
	private void createPrivateProperties(StringBuilder generatedClass) {
		for (String privateProperty : privateProperties) {
			generatedClass.append("\tprivate ").append(privateProperty).append(";").append("\n");
		}
		generatedClass.append("\n");
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
			String packageName, String customModelSourceFolder, String customModelPackageName,
			Map<String, ModelMap> modelsForTables) {
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
		boolean doCustomModelsExist = false;
		if (customModelSourceFolder != null && !customModelSourceFolder.isEmpty()) {
			file = new File(customModelSourceFolder);
			if (!file.exists()) {
				throw new IllegalArgumentException("Custom model folder doesn't exists. sourceFolder=" + sourceFolder);
			}
			if (customModelPackageName == null || customModelPackageName.trim().isEmpty()) {
				throw new IllegalArgumentException("Must specify custom model package name");
			}
			doCustomModelsExist = true;
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
		StringBuilder customModelDirectory = new StringBuilder();
		if (doCustomModelsExist) {
			customModelDirectory = new StringBuilder().append(customModelSourceFolder.trim());
			if (!(customModelDirectory.toString().endsWith("/") || customModelDirectory.toString().endsWith("\\"))) {
				customModelDirectory.append(File.separator);
			}
			if (File.separator.equals("/")) {
				customModelDirectory = new StringBuilder(customModelDirectory.toString().replaceAll("[\\\\]", File.separator));
			} else {
				customModelDirectory = new StringBuilder(customModelDirectory.toString().replaceAll("[/]", File.separator));
			}
			file = new File(customModelDirectory.toString());
			if (!file.exists()) {
				file.mkdirs();
			}
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

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = DB.prepareStatement(sql.toString(), null);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				new GraphQLInputModelClassGenerator(resultSet.getInt(1), columnFilter, directory.toString(), packageName,
						modelsForTables);
			}
		} catch (SQLException e) {
			throw new DBException(e, sql.toString());
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			DB.close(resultSet, preparedStatement);
			resultSet = null;
			preparedStatement = null;
		}
	}
}
