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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Generate GraphQL Input Model Classes.
 *
 * @author Kevin Burnett
 */
public class GraphQLInputModelClassGenerator {
	private static final CLogger log = CLogger.getCLogger(GraphQLInputModelClassGenerator.class);
	private String packageName = "";
	private final String modelResolverPackageName;
	private final ModelMap tableStructureExtensions;
	private final Map<String, ModelMap> modelsForTables;
	private final TreeSet<String> privateProperties = new TreeSet<>();

	public static String getGeneratedName(String tableName) {
		return "X_" + tableName + "Input";
	}

	/**
	 * Generate Schema
	 *
	 * @param AD_Table_ID      table id
	 * @param directory        directory
	 * @param entityTypeFilter entity type filter for columns
	 */
	public GraphQLInputModelClassGenerator(int AD_Table_ID, String entityTypeFilter, String directory,
			String packageName, String modelResolverPackageName, Map<String, ModelMap> modelsForTables)
			throws FileNotFoundException {
		this.packageName = packageName;
		this.modelsForTables = modelsForTables;
		this.modelResolverPackageName = modelResolverPackageName;

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

		String className = getGeneratedName(tableName);
		String interfaceName = GraphQLInputModelInterfaceGenerator.getGeneratedName(tableName);
		StringBuilder generatedClass = new StringBuilder()
				.append("package ").append(packageName).append(";\n\n");
		boolean hasIDColumn = MTable.get(Env.getCtx(), AD_Table_ID).getColumnIndex(tableName + "_ID") >= 0;

		// Insert the required iDempiere imports
		classesToImport.add("org.compiere.model.Query");
		classesToImport.add(tableStructureExtensions.getClassPackageName() + "." + tableStructureExtensions.getClassName());
		boolean hasUuidColumn = generatedColumns.toString().contains("public void setUU(String UU)");
		if (hasUuidColumn) {
			classesToImport.add("com.fasterxml.jackson.annotation.JsonCreator");
			classesToImport.add("com.fasterxml.jackson.annotation.JsonProperty");
			classesToImport.add("org.bandahealth.idempiere.graphql.utils.ModelUtil");
		}
		classesToImport.add("java.sql.ResultSet");
		classesToImport.add("org.compiere.util.Env");

		GraphQLUtil.createImports(classesToImport, generatedClass);
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
					.append("\t * @param UU The ").append(tableName).append("_UU to fetch this entity from the DB\n\t */\n")
					.append("\t@JsonCreator\n")
					.append("\tpublic ").append(className).append("(@JsonProperty(\"UU\") String UU) {\n");
			generatedClass
					.append("\t\tsuper(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);\n");
			generatedClass
					.append("\t\tsetUU(UU);\n")
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
		String sql = "SELECT c.ColumnName, c.IsUpdateable, c.AD_Reference_ID, "    //	1..3
				+ " c.AD_Reference_Value_ID, c.Name, c.Description, c.ColumnSQL, "  //	4..7
				+ " c.IsKey "  // 8
				+ "FROM AD_Column c "
				+ "WHERE c.AD_Table_ID=?"
				+ " AND c.IsActive='Y'"
				+ (!Util.isEmpty(entityTypeFilter) ? " AND c." + entityTypeFilter : "")
				+ " ORDER BY c.ColumnName";
		try (PreparedStatement preparedStatement = DB.prepareStatement(sql, null)) {
			preparedStatement.setInt(1, AD_Table_ID);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					String columnName = resultSet.getString(1);
					boolean isUpdatable = "Y".equals(resultSet.getString(2));
					int displayType = resultSet.getInt(3);
					int AD_Reference_Value_ID = resultSet.getInt(4);
					String Name = resultSet.getString(5);
					String Description = resultSet.getString(6);
					String ColumnSQL = resultSet.getString(7);
					boolean virtualColumn = ColumnSQL != null && !ColumnSQL.isEmpty();
					boolean IsKey = "Y".equals(resultSet.getString(8));
					//
					generatedColumns.append(
							createColumnMethods(columnName, isUpdatable, displayType, AD_Reference_Value_ID, Name, Description,
									virtualColumn, IsKey, AD_Table_ID));
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
	 * @param columnName      column name
	 * @param isUpdateable    updateable
	 * @param displayType     display type
	 * @param AD_Reference_ID validation reference
	 * @param Name            String
	 * @param Description     String
	 * @param virtualColumn   virtual column
	 * @return set/get method
	 */
	private String createColumnMethods(String columnName, boolean isUpdateable, int displayType, int AD_Reference_ID,
			String Name, String Description, boolean virtualColumn, boolean IsKey, int AD_Table_ID) {
		Class<?> clazz = ModelInterfaceGenerator.getClass(columnName, displayType, AD_Reference_ID);
		String dataType = ModelInterfaceGenerator.getDataTypeName(clazz, displayType);

		StringBuilder columnBuilder = new StringBuilder();

		if (columnName.equals("Created") || columnName.equals("CreatedBy") || columnName.equals("Updated") ||
				columnName.equals("UpdatedBy") || columnName.equals("AD_Client_ID") || virtualColumn) {
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
			String defaultValueMethod = "get_ID()";
			String defaultEmptyValue = "0";
			if (fieldName != null && referenceClassName != null) {
				// This entity is a foreign key, so let's work with it
				String[] packagePath = referenceClassName.split("\\.");
				referenceClassName = packagePath[packagePath.length - 1].substring(2);
				entityName = fieldName;
				foreignEntityTable = referenceClassName;
			} else if (columnName.equals("AD_Language")) {
				entityName = columnName;
				foreignEntityTable = columnName;
				defaultValueMethod = "getAD_Language()";
				defaultEmptyValue = "null";
			} else if (columnName.equals("EntityType")) {
				entityName = "AD_EntityType";
				foreignEntityTable = entityName;
				defaultValueMethod = "getEntityType()";
				defaultEmptyValue = "null";
			} else {
				String columnNameWithSuffixedIdRemoved = columnName.substring(0, columnName.length() - 3);
				if (columnName.endsWith("_ID") &&
						MTable.get(Env.getCtx(), AD_Table_ID).getColumn(columnNameWithSuffixedIdRemoved) == null &&
						MTable.get(Env.getCtx(), columnNameWithSuffixedIdRemoved) != null) {
					entityName = columnNameWithSuffixedIdRemoved;
					foreignEntityTable = entityName;
				} else if (columnName.equals("Logo_ID")) {
					entityName = columnNameWithSuffixedIdRemoved;
					foreignEntityTable = "AD_Image";
				} else if (columnName.equals("BH_To_Warehouse_ID") || columnName.equals("BH_From_Warehouse_ID")) {
					entityName = columnNameWithSuffixedIdRemoved;
					foreignEntityTable = "M_Warehouse";
				} else if (columnName.equals("From_BH_Concept_ID") || columnName.equals("To_BH_Concept_ID")) {
					entityName = columnNameWithSuffixedIdRemoved;
					foreignEntityTable = "BH_Concept";
				} else {
					log.warning("Did not generate a field for: " + columnName);
					return "";
				}
			}

			columnBuilder.append("\n");

			// Make sure that a private property is set correctly
			String propertyName = "m" + entityName;
			privateProperties.add("ForeignEntityInput " + propertyName);
			GraphQLUtil.generateJavaSetComment(entityName, Name, Description, columnBuilder);
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
					.append("\t\t\t\t\t\t\t.setParameters(").append(entityName).append(".getUU())")
					.append(".first()) != null && foreignEntity.get_ID() >= 0) {\n")
					.append("\t\t\t\tthis.set").append(columnName).append("(foreignEntity.").append(defaultValueMethod)
					.append(");\n")
					.append("\t\t\t} else {\n")
					.append("\t\t\t\tthrow new AdempiereException(\n")
					.append("\t\t\t\t\t\t\"Could not find entity in table ").append(foreignEntityTable)
					.append(" with UU \" + ").append(entityName).append(".getUU());\n")
					.append("\t\t\t}\n")
					.append("\t\t} else {\n")
					.append("\t\t\tthis.set").append(columnName).append("(").append(defaultEmptyValue).append(");\n")
					.append("\t\t}\n")
					.append("\t}\n");
			classesToImport.add("org.adempiere.exceptions.AdempiereException");

			GraphQLUtil.generateJavaGetComment(Name, Description, columnBuilder);
			columnBuilder
					.append("\t@JsonProperty(\"").append(entityName).append("\")\n")
					.append("\tpublic ForeignEntityInput ").append(entityName).append("() {\n")
					.append("\t\treturn ").append(propertyName).append(";\n")
					.append("\t}");

			return columnBuilder.toString();
		} else if (columnName.equalsIgnoreCase(MTable.get(AD_Table_ID).getTableName() + "_UU")) {
			// If this is the UUID column, we need to generate the UUID fields
			columnBuilder.append("\n");
			GraphQLUtil.generateJavaSetComment("UU", "UU", Description, columnBuilder);
			columnBuilder
					.append("\tpublic void setUU(String UU) {\n")
					.append("\t\tset").append(columnName).append("(UU);\n")
					.append("\t}\n");
			GraphQLUtil.generateJavaGetComment("UU", Description, columnBuilder);
			columnBuilder
					.append("\tpublic String getUU() {\n")
					.append("\t\treturn get").append(columnName).append("();\n")
					.append("\t}");

			// Since the UUID is always defined on the base, generated model, return
			return columnBuilder.toString();
		} else if (columnName.endsWith("_UU")) {
			log.warning("Did not generate a field for: " + columnName);
			return "";
		}

		// If the code is updatable from this point forward, the parent class can (potentially) handle it
		// Also, if the method is final somewhere in the iDempiere model tree, skip it
		List<String> columnsWhosSettersAreFinalInIDempiere = Arrays.asList("AD_Org_ID", "IsActive");
		if ((isUpdateable && AD_Reference_ID <= 0 && displayType != DisplayType.Payment) ||
				columnsWhosSettersAreFinalInIDempiere.contains(columnName)) {
			return columnBuilder.toString();
		} else if ((AD_Reference_ID > 0 &&
				MReference.get(AD_Reference_ID).getValidationType().equals(MReference.VALIDATIONTYPE_ListValidation) ||
				displayType == DisplayType.Payment) && clazz.equals(String.class)) {
			ModelMap classToUseMap = modelsForTables.get(MRefList.Table_Name);
			classesToImport.add(classToUseMap.getClassPackageName() + "." + classToUseMap.getClassName());
			classesToImport.add("com.fasterxml.jackson.annotation.JsonProperty");
			columnBuilder.append("\n");
			String returnType = "ForeignEntityInput";

			String modelResolverClassWithReferenceValuesList =
					GraphQLModelResolverGenerator.getGeneratedName(tableStructureExtensions.getTableName());
			classesToImport.add(modelResolverPackageName + "." + modelResolverClassWithReferenceValuesList);

			// Make sure that a private property is set correctly
			String propertyName = "m" + columnName;
			privateProperties.add(returnType + " " + propertyName);
			GraphQLUtil.generateJavaSetComment(columnName, Name, Description, columnBuilder);
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
					.append("\t\t\t// Since an entity was passed, make sure it's in the list of acceptable values\n")
					.append("\t\t\tif (!").append(modelResolverClassWithReferenceValuesList).append(".")
					.append(GraphQLModelResolverGenerator.getListValidationReferenceUuidsByValuePropertyName(columnName))
					.append(".containsValue(").append(columnName).append(".getUU())) {\n")
					.append("\t\t\t\tthrow new AdempiereException(\"The reference list UU of \" + ").append(columnName)
					.append(".getUU() +\n")
					.append("\t\t\t\t\t\t\" is not in the list defined for the ").append(columnName).append(" column\");\n")
					.append("\t\t\t}\n")
					.append("\t\t\t// Now make sure it's in the DB\n")
					.append("\t\t\t").append(modelForForeignEntity).append(" foreignEntity;\n")
					.append("\t\t\tif ((foreignEntity =\n")
					.append("\t\t\t\t\tnew Query(getCtx(), ").append(modelForForeignEntity).append(".Table_Name, ")
					.append(modelForForeignEntity).append(".COLUMNNAME_AD_Ref_List_UU + \"=?\", get_TrxName())\n")
					.append("\t\t\t\t\t\t\t.setParameters(").append(columnName).append(".getUU())")
					.append(".first()) != null && foreignEntity.get_ID() >= 0) {\n")
					.append("\t\t\t\tthis.set").append(columnName).append("(foreignEntity.getValue());\n")
					.append("\t\t\t} else {\n")
					.append("\t\t\t\tthrow new AdempiereException(\n")
					.append("\t\t\t\t\t\t\"Could not find entity in table \" + ").append(modelForForeignEntity)
					.append(".Table_Name + \" with UU \" + ").append(columnName).append(".getUU());\n")
					.append("\t\t\t}\n")
					.append("\t\t} else {\n")
					.append("\t\t\tthis.set").append(columnName).append("(null);\n")
					.append("\t\t}\n")
					.append("\t}\n");
			classesToImport.add("org.adempiere.exceptions.AdempiereException");

			GraphQLUtil.generateJavaGetComment(Name, Description, columnBuilder);
			columnBuilder
					.append("\t@JsonProperty(\"").append(columnName).append("\")\n")
					.append("\tpublic ").append(returnType).append(" ").append(columnName).append("() {\n")
					.append("\t\treturn ").append(propertyName).append(";\n")
					.append("\t}");
			return columnBuilder.toString();
		}

		// Since this property isn't updatable, we need to generate a method that updates the property only if the entity
		// is new
		GraphQLUtil.generateJavaSetComment(columnName, Name, Description, columnBuilder);
		columnBuilder
				.append("\n\tpublic void set").append(columnName).append("(").append(dataType).append(" ").append(columnName)
				.append(") {\n\t\tif (get_ID() == 0) {\n")
				.append("\t\t\tsuper.set").append(columnName).append("(").append(columnName)
				.append(");\n")
				.append("\t\t}\n\t}");
		addImportClass(clazz);
		//
		return columnBuilder.toString();
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
		if (clazz.isPrimitive()) {
			return;
		}
		addImportClass(clazz.getCanonicalName());
	}

	/**
	 * Generate java imports
	 *
	 * @param generatedClass The string to add the imports to
	 */
	private void createPrivateProperties(StringBuilder generatedClass) {
		for (String privateProperty : privateProperties) {
			generatedClass.append("\tprivate ").append(privateProperty).append(";").append("\n");
		}
		generatedClass.append("\n");
	}

	/**
	 * @param sourceFolder
	 * @param entityType
	 * @param tableName
	 * @param columnEntityType
	 */
	public static void generateSource(String entityType, String tableName, String columnEntityType, String sourceFolder,
			String packageName, String customModelSourceFolder, String customModelPackageName,
			String modelResolverPackageName, Map<String, ModelMap> modelsForTables) {
		//
		GraphQLUtil.validateCustomModelsFolderAndPackageName(customModelSourceFolder, customModelPackageName);
		String directory =
				GraphQLUtil.validateSourceFolderTableNamePackageNameAndGetFileOutputDirectory(sourceFolder, tableName,
						packageName);
		String columnFilter = GraphQLUtil.getColumnFilter(columnEntityType);
		//
		GraphQLUtil.buildAndExecuteTableSql(tableName, entityType,
				(resultSet -> new GraphQLInputModelClassGenerator(resultSet.getInt(1), columnFilter, directory, packageName,
						modelResolverPackageName, modelsForTables)));
	}
}
