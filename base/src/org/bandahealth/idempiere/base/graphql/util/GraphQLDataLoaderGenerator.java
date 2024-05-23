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
import org.compiere.util.Env;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.TreeSet;

/**
 * Generate GraphQL Schemas.
 *
 * @author Kevin Burnett
 */
public class GraphQLDataLoaderGenerator {
	private String packageName = "";
	private final ModelMap tableStructureExtensions;
	private final Map<String, ModelMap> modelsForTables;

	public static String getDataLoaderByIdProperty(String tableName) {
		return "DATALOADER_" + tableName + "_BY_ID";
	}

	public static String getDataLoaderByUuidProperty(String tableName) {
		return "DATALOADER_" + tableName + "_BY_UUID";
	}

	public static String getGeneratedName(String tableName) {
		return "X_" + tableName + "DataLoader";
	}

	/**
	 * Generate Schema
	 *
	 * @param AD_Table_ID table id
	 * @param directory   directory
	 */
	public GraphQLDataLoaderGenerator(int AD_Table_ID, String directory, String packageName,
			Map<String, ModelMap> modelsForTables) throws FileNotFoundException {
		this.packageName = packageName;
		this.modelsForTables = modelsForTables;

		if (!directory.endsWith(File.separator)) {
			directory += File.separator;
		}

		// Get the name of the model to extend
		tableStructureExtensions = modelsForTables.get(MTable.get(AD_Table_ID).getTableName());
		if (tableStructureExtensions == null) {
			throw new FileNotFoundException("Can't find file to match for table " + MTable.get(AD_Table_ID).getTableName());
		}

		// Header
		StringBuilder generatedFile = new StringBuilder();
		String fileName = createHeader(AD_Table_ID, generatedFile);

		// Save
		GraphQLUtil.writeToFile(generatedFile, directory + fileName + ".java");

		// If this table has translations, we need a data loader to handle loading
		MTable translationTable;
		if ((translationTable = MTable.get(Env.getCtx(), MTable.get(Env.getCtx(), AD_Table_ID).getTableName() + "_Trl")) !=
				null && translationTable.get_ID() > 0) {
			generatedFile = new StringBuilder();
			fileName = createTranslationHeader(translationTable.getAD_Table_ID(), AD_Table_ID, generatedFile);

			// Save
			GraphQLUtil.writeToFile(generatedFile, directory + fileName + ".java");
		} else {
			classesToImport.clear();
		}
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
		}
		
		if (tableName == null) {
			throw new RuntimeException("TableName not found for ID=" + AD_Table_ID);
		}

		String getByIdDataLoaderIdentifierProperty = getDataLoaderByIdProperty(tableStructureExtensions.getTableName());
		String getByUuidDataLoaderIdentifierProperty =
				getDataLoaderByUuidProperty(tableStructureExtensions.getTableName());
		String className = getGeneratedName(tableName);
		StringBuilder generatedClass = new StringBuilder()
				.append("package ").append(packageName).append(";\n\n");

		classesToImport.add(tableStructureExtensions.getClassPackageName() + "." + tableStructureExtensions.getClassName());
		GraphQLUtil.createImports(classesToImport, generatedClass);

		generatedClass
				.append("/**\n * Data Loader for ").append(tableName).append(" - DO NOT CHANGE\n *\n")
				.append(" * @author Banda Health (generated)").append("\n")
				.append(" * @version ").append(Adempiere.MAIN_VERSION).append(" - $Id$").append("\n */\n")

				// Data loader definition
				.append("public class ").append(className).append(" extends PODataLoader<")
				.append(tableStructureExtensions.getClassName()).append("> {\n")

				// Default data loader identifiers
				.append("\tpublic static String ").append(getByIdDataLoaderIdentifierProperty)
				.append(" = \"").append(tableStructureExtensions.getTableName())
				.append("ByIdDataLoader\";\n")
				.append("\tpublic static String ").append(getByUuidDataLoaderIdentifierProperty)
				.append(" = \"").append(tableStructureExtensions.getTableName())
				.append("ByUuidDataLoader\";\n\n")

				// Table Name Override
				.append("\t@Override\n")
				.append("\tprotected String getTableName() {\n")
				.append("\t\treturn ").append(tableStructureExtensions.getClassName()).append(".Table_Name;\n")
				.append("\t}\n\n")

				// Methods to return identifiers for default data loaders
				.append("\t@Override\n")
				.append("\tprotected String getByIdDataLoaderName() {\n")
				.append("\t\treturn ").append(getByIdDataLoaderIdentifierProperty).append(";\n")
				.append("\t}\n\n")

				.append("\t@Override\n")
				.append("\tprotected String getByUuidDataLoaderName() {\n")
				.append("\t\treturn ").append(getByUuidDataLoaderIdentifierProperty).append(";\n")
				.append("\t}\n")
				.append("}\n");

		generatedFile.insert(0, generatedClass);

		return className;
	}

	/**
	 * Add Header info to buffer
	 *
	 * @param translationTableId table
	 * @param generatedFile      GeneratedColumns
	 * @return file name
	 */
	private String createTranslationHeader(int translationTableId, int relatedTableId, StringBuilder generatedFile) {
		String tableName = null;
		String sql = "SELECT TableName FROM AD_Table WHERE AD_Table_ID=?";
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = DB.prepareStatement(sql, null);
			preparedStatement.setInt(1, translationTableId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				tableName = resultSet.getString(1);
			}
		} catch (SQLException e) {
			throw new DBException(e, sql);
		} finally {
			DB.close(resultSet, preparedStatement);
		}
		if (tableName == null) {
			throw new RuntimeException("TableName not found for ID=" + translationTableId);
		}

		String getByIdDataLoaderIdentifierProperty = getDataLoaderByIdProperty(tableName);
		String getByUuidDataLoaderIdentifierProperty = getDataLoaderByUuidProperty(tableName);
		String className = getGeneratedName(tableName);
		StringBuilder generatedClass = new StringBuilder()
				.append("package ").append(packageName).append(";\n\n");

		classesToImport.add(tableStructureExtensions.getClassPackageName() + "." + tableStructureExtensions.getClassName());
		classesToImport.add("org.bandahealth.idempiere.graphql.utils.QueryUtil");
		classesToImport.add("org.compiere.model.PO");
		classesToImport.add("org.compiere.model.Query");
		classesToImport.add("org.compiere.util.Env");
		classesToImport.add("org.dataloader.DataLoader");
		classesToImport.add("org.dataloader.DataLoaderRegistry");
		classesToImport.add("org.dataloader.MappedBatchLoaderWithContext");

		classesToImport.add("java.util.ArrayList");
		classesToImport.add("java.util.List");
		classesToImport.add("java.util.Properties");
		classesToImport.add("java.util.concurrent.CompletableFuture");
		classesToImport.add("java.util.stream.Collectors");

		GraphQLUtil.createImports(classesToImport, generatedClass);

		ModelMap relatedTableModelMap = modelsForTables.get(MTable.get(Env.getCtx(), relatedTableId).getTableName());
		String regularTableModelAndField =
				relatedTableModelMap.getClassName() + ".COLUMNNAME_" + relatedTableModelMap.getTableName() + "_ID";
		generatedClass
				.append("/**\n * Data Loader for ").append(tableName).append(" - DO NOT CHANGE\n *\n")
				.append(" * @author Banda Health (generated)").append("\n")
				.append(" * @version ").append(Adempiere.MAIN_VERSION).append(" - $Id$").append("\n */\n")

				// Data loader definition
				.append("public class ").append(className).append(" extends PODataLoader<PO> {\n")

				// Default data loader identifiers
				.append("\tpublic static String ").append(getByIdDataLoaderIdentifierProperty)
				.append(" = \"").append(tableName)
				.append("ByIdDataLoader\";\n")
				.append("\tpublic static String ").append(getByUuidDataLoaderIdentifierProperty)
				.append(" = \"").append(tableName)
				.append("ByUuidDataLoader\";\n\n")

				// Table Name Override
				.append("\t@Override\n")
				.append("\tprotected String getTableName() {\n")
				.append("\t\treturn ").append(relatedTableModelMap.getClassName()).append(".Table_Name + \"_Trl\";\n")
				.append("\t}\n\n")

				// Methods to return identifiers for default data loaders
				.append("\t@Override\n")
				.append("\tprotected String getByIdDataLoaderName() {\n")
				.append("\t\treturn null;\n")
				.append("\t}\n\n")

				.append("\t@Override\n")
				.append("\tprotected String getByUuidDataLoaderName() {\n")
				.append("\t\treturn ").append(getByUuidDataLoaderIdentifierProperty).append(";\n")
				.append("\t}\n\n")

				// We need to override the register to register the real get-by-ID method
				.append("\t@Override\n")
				.append("\tpublic void register(DataLoaderRegistry registry, Properties idempiereContext) {\n")
				.append("\t\tsuper.register(registry, idempiereContext);\n")
				.append("\t\tregistry.register(").append(getByIdDataLoaderIdentifierProperty).append(",\n")
				.append("\t\t\t\tDataLoader.newMappedDataLoader(getByIdAndLanguageBatchLoader(),\n")
				.append("\t\t\t\t\t\tgetOptionsWithCache(idempiereContext)));\n")
				.append("\t}\n")
				.append("\n")
				.append("\tprivate MappedBatchLoaderWithContext<Integer, PO> getByIdAndLanguageBatchLoader() {\n")
				.append("\t\treturn (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {\n")
				.append("\t\t\tList<Object> parameters = new ArrayList<>();\n")
				.append("\t\t\tString whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(keys, parameters);\n")
				.append("\t\t\tparameters.add(Env.getLanguage(batchLoaderEnvironment.getContext()).getAD_Language());\n")
				.append("\t\t\tList<PO> translations = new Query(batchLoaderEnvironment.getContext(), getTableName(),\n")
				.append("\t\t\t\t\t").append(regularTableModelAndField)
				.append(" + \" IN (\" + whereClause + \") AND AD_Language = ?\", null).setParameters(\n")
				.append("\t\t\t\t\tparameters).list();\n")
				.append("\t\t\treturn translations.stream().collect(\n")
				.append("\t\t\t\t\tCollectors.toMap(translation -> translation.get_ValueAsInt(")
				.append(regularTableModelAndField).append("),\n")
				.append("\t\t\t\t\t\t\ttranslation -> translation));\n")
				.append("\t\t});\n")
				.append("\t}\n")
				.append("}\n");

		generatedFile.insert(0, generatedClass);
		
		// prevent memory leak.
		classesToImport.clear();

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
			Map<String, ModelMap> modelsForTables) {
		//
		String directory =
				GraphQLUtil.validateSourceFolderTableNamePackageNameAndGetFileOutputDirectory(sourceFolder, tableName,
						packageName);
		//
		GraphQLUtil.buildAndExecuteTableSql(tableName, entityType,
				(resultSet -> new GraphQLDataLoaderGenerator(resultSet.getInt(1), directory, packageName, modelsForTables)));
	}
}
