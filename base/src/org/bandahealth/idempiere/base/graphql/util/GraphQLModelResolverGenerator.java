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
import java.util.Collection;
import java.util.Map;
import java.util.TreeSet;

/**
 * Generate GraphQL model resolvers.
 *
 * @author Kevin Burnett
 */
public class GraphQLModelResolverGenerator {
	private static final CLogger log = CLogger.getCLogger(GraphQLModelResolverGenerator.class);
	private final String packageName;
	private final ModelMap tableStructureExtensions;
	private final Map<String, ModelMap> modelsForTables;
	private final String dataLoaderPackageName;

	/**
	 * Generate Schema
	 *
	 * @param AD_Table_ID      table id
	 * @param directory        directory
	 * @param entityTypeFilter entity type filter for columns
	 */
	public GraphQLModelResolverGenerator(int AD_Table_ID, String entityTypeFilter, String directory,
			String packageName, String dataLoaderPackageName, Map<String, ModelMap> modelsForTables)
			throws FileNotFoundException {
		this.packageName = packageName;
		this.modelsForTables = modelsForTables;
		this.dataLoaderPackageName = dataLoaderPackageName;

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

		String className = "X_" + tableName + "Resolver";
		StringBuilder generatedClass = new StringBuilder()
				.append("package ").append(packageName).append(";\n\n");

		// Insert the required iDempiere imports
		classesToImport.add("graphql.kickstart.tools.GraphQLResolver");
		classesToImport.add("graphql.schema.DataFetchingEnvironment");
		classesToImport.add("org.dataloader.DataLoader");
		classesToImport.add(tableStructureExtensions.getClassPackageName() + "." + tableStructureExtensions.getClassName());

		GraphQLUtil.createImports(classesToImport, generatedClass);
		generatedClass
				.append("/**\n * Generated ModelResolver for ").append(tableName).append(" - DO NOT CHANGE\n *\n")
				.append(" * @author Banda Health (generated)").append("\n")
				.append(" * @version ").append(Adempiere.MAIN_VERSION).append(" - $Id$").append("\n */\n")

				// Class definition
				.append("public class ").append(className).append(" extends POResolver<")
				.append(tableStructureExtensions.getClassName()).append("> implements GraphQLResolver<")
				.append(tableStructureExtensions.getClassName()).append("> {\n\n");

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
		String sql = "SELECT c.ColumnName, c.AD_Reference_ID, c.AD_Reference_Value_ID, "    //	1..3
				+ " c.Name, c.Description, c.IsKey, c.IsTranslated "  // 4..7
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
				int displayType = resultSet.getInt(2);
				int AD_Reference_Value_ID = resultSet.getInt(3);
				String Name = resultSet.getString(4);
				String Description = resultSet.getString(5);
				boolean IsKey = "Y".equals(resultSet.getString(6));
				boolean isTranslated = "Y".equals(resultSet.getString(7));
				//
				generatedColumns.append(
						createColumnMethods(columnName, displayType, AD_Reference_Value_ID, Name, Description, IsKey, isTranslated,
								AD_Table_ID));
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
	 * @return set/get method
	 */
	private String createColumnMethods(String columnName, int displayType, int AD_Reference_ID, String Name,
			String Description, boolean IsKey, boolean isTranslated, int AD_Table_ID) {
		Class<?> clazz = ModelInterfaceGenerator.getClass(columnName, displayType, AD_Reference_ID);
		String dataType = ModelInterfaceGenerator.getDataTypeName(clazz, displayType);

		StringBuilder columnBuilder = new StringBuilder();

		boolean shouldSkipInputField =
				columnName.equals("Created") || columnName.equals("CreatedBy") || columnName.equals("Updated") ||
						columnName.equals("UpdatedBy") || columnName.equals("AD_Client_ID") || columnName.equals("AD_Org_ID") ||
						columnName.endsWith("_UU") || columnName.equals("IsActive");

		// TODO - New functionality
		// 1) Must understand which class to reference
		if (shouldSkipInputField || IsKey) {
			return "";
		}
		if (DisplayType.isID(displayType)) {
			String fieldName = ModelInterfaceGenerator.getFieldName(columnName);
			String referenceClassName =
					ModelInterfaceGenerator.getReferenceClassName(AD_Table_ID, columnName, displayType, AD_Reference_ID);

			String foreignEntityTable = "";
			String entityName = "";
			String defaultCheckToReturnNull = "";
			String valueMapPrefix = "";
			String valueMapSuffix = "";
			columnBuilder.append("\n");
			if (fieldName != null && referenceClassName != null) {
				// This entity is a foreign key, so let's work with it
				String[] packagePath = referenceClassName.split("\\.");
				referenceClassName = packagePath[packagePath.length - 1].substring(2);
				entityName = fieldName;
				foreignEntityTable = referenceClassName;
				defaultCheckToReturnNull = "entity.get" + columnName + "() < 0";
			} else if (columnName.equals("AD_Language")) {
				entityName = columnName;
				foreignEntityTable = columnName;
				addImportClass("org.bandahealth.idempiere.graphql.utils.StringUtil");
				defaultCheckToReturnNull = "StringUtil.isNullOrEmpty(entity.get" + columnName + "())";
				valueMapPrefix =
						addLanguageCodeAndReturnReferenceUuidsByValueProperty(columnBuilder, columnName) + ".get(";
				valueMapSuffix = ")";
			} else if (columnName.equals("EntityType")) {
				entityName = "AD_EntityType";
				foreignEntityTable = entityName;
				addImportClass("org.bandahealth.idempiere.graphql.utils.StringUtil");
				defaultCheckToReturnNull = "StringUtil.isNullOrEmpty(entity.get" + columnName + "())";
				valueMapPrefix =
						addEntityTypeCodeAndReturnReferenceUuidsByValueProperty(columnBuilder, columnName) + ".get(";
				valueMapSuffix = ")";
			} else {
				String columnNameWithSuffixedIdRemoved = columnName.substring(0, columnName.length() - 3);
				if (columnName.endsWith("_ID") &&
						MTable.get(Env.getCtx(), columnNameWithSuffixedIdRemoved) != null) {
					entityName = columnNameWithSuffixedIdRemoved;
					foreignEntityTable = entityName;
					defaultCheckToReturnNull = "entity.get" + columnName + "() < 0";
				} else if (columnName.equals("Logo_ID")) {
					entityName = columnNameWithSuffixedIdRemoved;
					foreignEntityTable = "AD_Image";
					defaultCheckToReturnNull = "entity.get" + columnName + "() < 0";
				} else if (columnName.equals("BH_To_Warehouse_ID") || columnName.equals("BH_From_Warehouse_ID")) {
					entityName = columnNameWithSuffixedIdRemoved;
					foreignEntityTable = "M_Warehouse";
					defaultCheckToReturnNull = "entity.get" + columnName + "() < 0";
				} else {
					log.warning("Did not generate a field for: " + columnName);
					return "";
				}
			}

			ModelMap foreignModelMap = modelsForTables.get(foreignEntityTable);
			String modelForForeignEntity;
			if (foreignModelMap != null) {
				classesToImport.add(foreignModelMap.getClassPackageName() + "." + foreignModelMap.getClassName());
				modelForForeignEntity = foreignModelMap.getClassName();
			} else {
				log.warning(
						"Did not have any model or anything mapped for " + foreignEntityTable + ", so resorting to PO");
				addImportClass("org.compiere.model.PO");
				modelForForeignEntity = "PO";
			}
			String dataLoader = "X_" + foreignEntityTable + "DataLoader";
			classesToImport.add(dataLoaderPackageName + "." + dataLoader);
			classesToImport.add("java.util.concurrent.CompletableFuture");

			GraphQLUtil.generateJavaGetComment(Name, Description, columnBuilder);
			columnBuilder
					.append("\tpublic CompletableFuture<").append(modelForForeignEntity).append("> ")
					.append(entityName).append("(").append(tableStructureExtensions.getClassName())
					.append(" entity, DataFetchingEnvironment environment) {\n")
					.append("\t\tif (").append(defaultCheckToReturnNull).append(") {\n")
					.append("\t\t\treturn null;\n")
					.append("\t\t}\n")
					.append("\t\tDataLoader<Integer, ").append(modelForForeignEntity).append("> dataLoader =\n")
					.append("\t\t\t\tenvironment.getDataLoaderRegistry().getDataLoader(").append(dataLoader).append(".")
					.append(GraphQLDataLoaderGenerator.getDataLoaderByIdProperty(foreignEntityTable)).append(");\n")
					.append("\t\treturn dataLoader.load(").append(valueMapPrefix).append("entity.get").append(columnName)
					.append("()").append(valueMapSuffix).append(");\n")
					.append("\t}\n");
			return columnBuilder.toString();
		}

		// If the code is updatable from this point forward, the parent class can handle it
		if (AD_Reference_ID > 0 &&
				MReference.get(AD_Reference_ID).getValidationType().equals(MReference.VALIDATIONTYPE_ListValidation) &&
				clazz.equals(String.class)) {
			ModelMap classToUseMap = modelsForTables.get(MRefList.Table_Name);
			classesToImport.add(classToUseMap.getClassPackageName() + "." + classToUseMap.getClassName());
			ModelMap foreignModelMap = modelsForTables.get("AD_Ref_List");
			classesToImport.add(foreignModelMap.getClassPackageName() + "." + foreignModelMap.getClassName());
			classesToImport.add("java.util.concurrent.CompletableFuture");
			String dataLoader = "X_" + foreignModelMap.getTableName() + "DataLoader";
			classesToImport.add(dataLoaderPackageName + "." + dataLoader);

			// We need to generate a UUID by value for this associated reference
			// Make sure that a private property is set correctly
			columnBuilder.append("\n");
			String referenceListUuidByValuePropertyName =
					addListValidationCodeAndReturnReferenceUuidsByValueProperty(columnBuilder, AD_Reference_ID, columnName);
			classesToImport.add("org.bandahealth.idempiere.graphql.utils.StringUtil");
			columnBuilder
					.append("\tpublic CompletableFuture<").append(foreignModelMap.getClassName()).append("> ")
					.append(columnName).append("(").append(tableStructureExtensions.getClassName())
					.append(" entity, DataFetchingEnvironment environment) {\n")
					.append("\t\tif (StringUtil.isNullOrEmpty(entity.get").append(columnName).append("())) {\n")
					.append("\t\t\treturn null;\n")
					.append("\t\t}\n")
					.append("\t\tDataLoader<String, ").append(foreignModelMap.getClassName()).append("> dataLoader =\n")
					.append("\t\t\t\tenvironment.getDataLoaderRegistry().getDataLoader(").append(dataLoader)
					.append(".").append(GraphQLDataLoaderGenerator.getDataLoaderByUuidProperty(foreignModelMap.getTableName()))
					.append(");\n")
					.append("\t\treturn dataLoader.load(").append(referenceListUuidByValuePropertyName).append(".get(entity.get")
					.append(columnName).append("()));\n")
					.append("\t}\n");
			return columnBuilder.toString();
		} else if (clazz.equals(Boolean.class)) {
			// If Boolean, we need to add a method to handle the capitalization of this property
			String methodName = "is" + columnName.substring(2);
			if (columnName.startsWith("is")) {
				methodName = columnName;
			} else if (!columnName.startsWith("Is")) {
				methodName = "is" + columnName;
			}
			columnBuilder
					.append("\n")
					.append("\tpublic Boolean ").append(columnName).append("(").append(tableStructureExtensions.getClassName())
					.append(" entity, DataFetchingEnvironment environment) {\n")
					.append("\t\treturn entity.").append(methodName).append("();\n")
					.append("\t}\n");
			return columnBuilder.toString();
		} else if (columnName.substring(0, 1).equals(columnName.substring(0, 1).toLowerCase())) {
			// Since the column name is lower case, we need to make sure the resolver generates the correct methods
			columnBuilder
					.append("\n")
					.append("\tpublic ").append(dataType).append(" ").append(columnName).append("(")
					.append(tableStructureExtensions.getClassName())
					.append(" entity, DataFetchingEnvironment environment) {\n")
					.append("\t\treturn entity.get").append(columnName).append("();\n")
					.append("\t}\n");
			addImportClass(clazz);
			return columnBuilder.toString();
		} else if (isTranslated && clazz.equals(String.class)) {
			// We need to generate a duplicate method that will use a data loader to fetch the translation
			String languageDataLoaderName = "X_" + tableStructureExtensions.getTableName() + "_TrlDataLoader";
			addImportClass("org.bandahealth.idempiere.graphql.context.BandaGraphQLContext");
			addImportClass("org.compiere.model.PO");
			addImportClass("org.compiere.util.Env");
			addImportClass("org.compiere.util.Language");
			addImportClass("org.dataloader.DataLoader");
			addImportClass("java.util.concurrent.CompletableFuture");
			addImportClass(dataLoaderPackageName + "." + languageDataLoaderName);
			GraphQLUtil.generateJavaGetComment(Name, Description, columnBuilder);
			columnBuilder
					.append("\tpublic CompletableFuture<String> ").append(columnName).append("(")
					.append(tableStructureExtensions.getClassName())
					.append(" entity, DataFetchingEnvironment environment) {\n")
					.append("\t\tif (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {\n")
					.append("\t\t\treturn CompletableFuture.supplyAsync(entity::get").append(columnName).append(");\n")
					.append("\t\t}\n")
					.append("\t\tDataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()\n")
					.append("\t\t\t\t.getDataLoader(").append(languageDataLoaderName).append(".")
					.append(
							GraphQLDataLoaderGenerator.getDataLoaderByIdProperty(tableStructureExtensions.getTableName() + "_Trl"))
					.append(");\n")
					.append("\t\treturn dataLoader.load(entity.get_ID())\n")
					.append("\t\t\t\t.thenApply(translation -> translation != null ? translation.get_ValueAsString(")
					.append(tableStructureExtensions.getClassName()).append(".COLUMNNAME_").append(columnName).append(") :\n")
					.append("\t\t\t\t\t\tentity.get").append(columnName).append("());\n")
					.append("\t}\n");
			return columnBuilder.toString();
		}

		return "";
	}

	/**
	 * Since the DB stores values and we want reference lists, we need a way to map the values to the reference UUID so
	 * it can be loaded via a data loader
	 *
	 * @param generatedCode   buffer
	 * @param AD_Reference_ID reference
	 * @param columnName      column
	 * @return static parameter - Example:
	 * static Map<String, String> BH_PROCESS_STAGE_UUIDS_BY_VALUE = new HashMap<>() {
	 * {
	 * put("toclinician", "e74d5f99-fd01-4d54-ab35-7a630c43f064");
	 * put("tocashier", "fed0d4f4-4eb2-478c-beb4-9570a8da06bf");
	 * put("tolab", "e3eace1e-ee22-409b-a7ae-09cee5350b91");
	 * put("topharmacy", "24c32cc4-3fdb-4448-85a5-879eea7866ea");
	 * }
	 * };
	 */
	private String addListValidationCodeAndReturnReferenceUuidsByValueProperty(StringBuilder generatedCode,
			int AD_Reference_ID, String columnName) {
		String uuidsByValuePropertyName = columnName.toUpperCase() + "_UUIDS_BY_VALUE";
		classesToImport.add("java.util.HashMap");
		classesToImport.add("java.util.Map");
		generatedCode.append("\tstatic Map<String, String> ").append(uuidsByValuePropertyName)
				.append(" = new HashMap<>() {\n")
				.append("\t\t{\n");
		//
		String sql = "SELECT Value, AD_Ref_List_UU FROM AD_Ref_List WHERE AD_Reference_ID=? ORDER BY AD_Ref_List_ID";
		try (PreparedStatement preparedStatement = DB.prepareStatement(sql, null)) {
			preparedStatement.setInt(1, AD_Reference_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String value = resultSet.getString(1);
				String uuid = resultSet.getString(2);

				generatedCode.append("\t\t\tput(\"").append(value).append("\", \"").append(uuid).append("\");\n");
			}
		} catch (SQLException e) {
			throw new DBException(e, sql);
		}

		generatedCode.append("\t\t}\n")
				.append("\t};\n");
		return uuidsByValuePropertyName;
	}

	/**
	 * Since the DB stores values and we want entity types, we need a way to map the values to the entity type UUID so
	 * it can be loaded via a data loader
	 *
	 * @param generatedCode buffer
	 * @param columnName    column
	 * @return static parameter
	 */
	private String addEntityTypeCodeAndReturnReferenceUuidsByValueProperty(StringBuilder generatedCode,
			String columnName) {
		String uuidsByValuePropertyName = columnName.toUpperCase() + "_IDS_BY_ENTITY_TYPE";
		classesToImport.add("java.util.HashMap");
		classesToImport.add("java.util.Map");
		generatedCode.append("\tstatic Map<String, Integer> ").append(uuidsByValuePropertyName)
				.append(" = new HashMap<>() {\n")
				.append("\t\t{\n");
		//
		String sql = "SELECT entitytype, ad_entitytype_id FROM AD_EntityType ORDER BY AD_EntityType_ID";
		try (PreparedStatement preparedStatement = DB.prepareStatement(sql, null)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String value = resultSet.getString(1);
				Integer id = resultSet.getInt(2);

				generatedCode.append("\t\t\tput(\"").append(value).append("\", ").append(id).append(");\n");
			}
		} catch (SQLException e) {
			throw new DBException(e, sql);
		}

		generatedCode.append("\t\t}\n")
				.append("\t};\n");
		return uuidsByValuePropertyName;
	}

	/**
	 * Since the DB stores values and we want languages, we need a way to map the values to the language UUID so
	 * it can be loaded via a data loader
	 *
	 * @param generatedCode buffer
	 * @param columnName    column
	 * @return static parameter
	 */
	private String addLanguageCodeAndReturnReferenceUuidsByValueProperty(StringBuilder generatedCode,
			String columnName) {
		String uuidsByValuePropertyName = columnName.toUpperCase() + "_IDS_BY_LANGUAGE";
		classesToImport.add("java.util.HashMap");
		classesToImport.add("java.util.Map");
		generatedCode.append("\tstatic Map<String, Integer> ").append(uuidsByValuePropertyName)
				.append(" = new HashMap<>() {\n")
				.append("\t\t{\n");
		//
		String sql = "SELECT ad_language, ad_language_id FROM ad_language ORDER BY ad_language";
		try (PreparedStatement preparedStatement = DB.prepareStatement(sql, null)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String value = resultSet.getString(1);
				Integer id = resultSet.getInt(2);

				generatedCode.append("\t\t\tput(\"").append(value).append("\", ").append(id).append(");\n");
			}
		} catch (SQLException e) {
			throw new DBException(e, sql);
		}

		generatedCode.append("\t\t}\n")
				.append("\t};\n");
		return uuidsByValuePropertyName;
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
			String packageName, String dataLoaderPackageName, Map<String, ModelMap> modelsForTables) {
		//
		String directory =
				GraphQLUtil.validateSourceFolderTableNamePackageNameAndGetFileOutputDirectory(sourceFolder, tableName,
						packageName);
		String columnFilter = GraphQLUtil.getColumnFilter(columnEntityType);
		//
		GraphQLUtil.buildAndExecuteTableSql(tableName, entityType,
				(resultSet -> new GraphQLModelResolverGenerator(resultSet.getInt(1), columnFilter, directory, packageName,
						dataLoaderPackageName, modelsForTables)));
	}
}
