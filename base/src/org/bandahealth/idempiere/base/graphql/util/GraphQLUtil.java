package org.bandahealth.idempiere.base.graphql.util;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.exceptions.DBException;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GraphQLUtil {
	private static final CLogger log = CLogger.getCLogger(GraphQLUtil.class);
	private static final Pattern tableNamePattern = Pattern.compile("Table_Name = \"(.*)\";");
	private static final Pattern packagePattern = Pattern.compile("(?<!//)package (.*);");

	/**
	 * Search through the codebase and get the file names (both generated and/or created) and return a mapping so that
	 * the generators can use the appropriate files
	 *
	 * @param customModelDirectory An additional custom model directory to search and extend what is searched in
	 *                             iDempiere's files
	 * @return A map of table names and their associated file data
	 * @throws IOException An exception if there's a problem reading the file contents
	 */
	public static Map<String, ModelMap> getModelsForTables(String customModelDirectory) throws IOException {
		// Look through all files and find the generated class
		String currentPath = Path.of("").toAbsolutePath().toString();
		List<File> modelFiles = Stream.concat(Stream.concat(Arrays.stream(
								Objects.requireNonNull(new File(currentPath + "/org.adempiere.base/src/org/compiere/model").listFiles())),
						Arrays.stream(Objects.requireNonNull(
								new File(currentPath + "/org.adempiere.base/src/org/compiere/report").listFiles()))), Arrays.stream(
						Objects.requireNonNull(new File(currentPath + "/org.adempiere.base/src/org/eevolution/model").listFiles())))
				.collect(Collectors.toList());
		File file;
		if (customModelDirectory != null && !customModelDirectory.isEmpty() &&
				(file = new File(customModelDirectory)).exists() && file.isDirectory()) {
			modelFiles = Stream.concat(modelFiles.stream(),
					Arrays.stream(Objects.requireNonNull(new File(customModelDirectory).listFiles()))).toList();
		}

		Map<String, ModelMap> modelsForTables = new HashMap<>();
		Map<String, String> interfacesByTable = new HashMap<>();
		Map<String, String> generatedClassByInterface = new HashMap<>();
		Map<String, String> manualClassByExtendedClass = new HashMap<>();
		Map<String, String> packageByClass = new HashMap<>();
		List<String> filesToSkip =
				List.of("PO.java", "Lookup.java", "TestCase.java", "EventObject.java", "EventListener.java");
		String deprecatedClass = "@Deprecated" + System.lineSeparator() + "public class ";

		// Cycle through the interfaces to find which tables we have
		for (File modelFile : modelFiles) {
			if (!modelFile.getName().endsWith(".java") || filesToSkip.contains(modelFile.getName())) {
				continue;
			}
			String content = Files.readString(modelFile.toPath());
			String structureName = modelFile.getName().replace(".java", "");
			Matcher packageMatcher = packagePattern.matcher(content);
			if (!packageMatcher.find()) {
				throw new AdempiereException("File " + modelFile.getName() + " doesn't have a package");
			}
			String structurePackage = packageMatcher.group(1);
			packageByClass.put(structureName, structurePackage);
			if (modelFile.getName().startsWith("I_")) {
				// This is potentially a generated interface, so get the table it pertains to (if any)
				Matcher tableNameMatcher = tableNamePattern.matcher(content);
				// This may not be a generated interface and thus may not have a table. Skip, if so
				if (!tableNameMatcher.find()) {
					continue;
				}
				String tableName = tableNameMatcher.group(1);
				modelsForTables.put(tableName, new ModelMap(tableName));
				modelsForTables.get(tableName).setInterfaceName(structureName);
				modelsForTables.get(tableName).setInterfacePackageName(structurePackage);
				interfacesByTable.put(tableName, structureName);
			} else if (modelFile.getName().startsWith("X_")) {
				// This is a generated class, so get the interface that's implemented
				String implementedInterfaceName = content.split(" implements ")[1].split(",")[0].trim();
				if (generatedClassByInterface.containsKey(implementedInterfaceName)) {
					throw new AdempiereException("More than one file implements interface " + implementedInterfaceName + ": " +
							generatedClassByInterface.get(implementedInterfaceName) + " and " + structureName);
				}
				generatedClassByInterface.put(implementedInterfaceName, structureName);
			} else if (content.contains(" extends ")) { // TODO - filter out if the class is deprecated...
				// This is a manual model of some sort, so put it in the appropriate place if it's not final
				if (!content.contains(" final class " + structureName) && !content.contains(deprecatedClass)) {
					String extendedClassName = content.split(" extends ")[1].trim().split("[\\s{]")[0].split(",")[0].trim();
					if (manualClassByExtendedClass.containsKey(extendedClassName)) {
						log.warning(("More than one file extends class " + extendedClassName + ": " +
								manualClassByExtendedClass.get(extendedClassName) + " and " + structureName));
					}
					manualClassByExtendedClass.put(extendedClassName, structureName);
				}
			}
		}

		// Now cycle through what we have and find the class to use for each table
		for (Map.Entry<String, String> tableAndInterface : interfacesByTable.entrySet()) {
			if (!generatedClassByInterface.containsKey(tableAndInterface.getValue())) {
				throw new AdempiereException(
						"Table " + tableAndInterface.getKey() + " does not have a class that implements it's interface " +
								tableAndInterface.getValue());
			}
			String generatedClass = generatedClassByInterface.get(tableAndInterface.getValue());
			modelsForTables.get(tableAndInterface.getKey()).setGeneratedClassName(generatedClass);
			modelsForTables.get(tableAndInterface.getKey()).setGeneratedClassPackageName(packageByClass.get(generatedClass));
			// If we don't have a manual class, we just use the generated class
			if (!manualClassByExtendedClass.containsKey(generatedClass)) {
				modelsForTables.get(tableAndInterface.getKey()).setClassName(generatedClass);
				modelsForTables.get(tableAndInterface.getKey()).setClassPackageName(packageByClass.get(generatedClass));
			} else {
				String manualClass = manualClassByExtendedClass.get(generatedClass);
				while (manualClassByExtendedClass.containsKey(manualClass)) {
					manualClass = manualClassByExtendedClass.get(manualClass);
				}
				modelsForTables.get(tableAndInterface.getKey()).setClassName(manualClass);
				modelsForTables.get(tableAndInterface.getKey()).setClassPackageName(packageByClass.get(manualClass));
			}
		}

		return modelsForTables;
	}


	/**
	 * Write to file
	 *
	 * @param stringBuilder string buffer
	 * @param fileName      file name
	 */
	public static void writeToFile(StringBuilder stringBuilder, String fileName) {
		try {
			File out = new File(fileName);
			Writer fw = new OutputStreamWriter(new FileOutputStream(out, false), StandardCharsets.UTF_8);
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
	 * Set Comment
	 *
	 * @param columnName    The column we're setting
	 * @param propertyName  The property to generate a get comment for
	 * @param description   An optional description of the property
	 * @param generatedCode The column getters/setters we're generating
	 */
	public static void generateJavaSetComment(String columnName, String propertyName, String description,
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
	public static void generateJavaGetComment(String propertyName, String description, StringBuilder generatedCode) {
		generatedCode.append("\n").append("\t/**\n\t * Get ").append(propertyName).append(".\n\t *\n\t * @return ")
				.append(description != null && !description.isEmpty() ? description : propertyName).append("\n\t */\n");
	}

	/**
	 * Perform basic validations for the generators and get the file output directory
	 *
	 * @param sourceFolder The source folder input for generated files to check
	 * @param tableName    The table name input to check
	 * @param packageName  The package name input to check
	 * @return An exception or the directory to use
	 */
	public static String validateSourceFolderTableNamePackageNameAndGetFileOutputDirectory(String sourceFolder,
			String tableName, String packageName) {
		if (packageName == null || packageName.trim().isEmpty()) {
			throw new IllegalArgumentException("Must specify package name");
		}
		return validateSourceFolderTableNameAndGetFileOutputDirectory(sourceFolder, tableName);
	}

	/**
	 * Perform basic validations for the generators and get the file output directory
	 *
	 * @param sourceFolder The source folder input for generated files to check
	 * @param tableName    The table name input to check
	 * @return An exception or the directory to use
	 */
	public static String validateSourceFolderTableNameAndGetFileOutputDirectory(String sourceFolder,
			String tableName) {
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

		return directory.toString();
	}

	/**
	 * Validations for generators that need the custom models folder and package name
	 *
	 * @param customModelSourceFolder The custom model source folder to check
	 * @param customModelPackageName  The custom model package name input to check
	 */
	public static void validateCustomModelsFolderAndPackageName(String customModelSourceFolder,
			String customModelPackageName) {
		if (customModelSourceFolder != null && !customModelSourceFolder.isEmpty()) {
			File file = new File(customModelSourceFolder);
			if (!file.exists()) {
				throw new IllegalArgumentException(
						"Custom model folder doesn't exist. sourceFolder=" + customModelSourceFolder);
			}
			if (customModelPackageName == null || customModelPackageName.trim().isEmpty()) {
				throw new IllegalArgumentException("Must specify custom model package name");
			}
			StringBuilder customModelDirectory = new StringBuilder().append(customModelSourceFolder.trim());
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
	}

	/**
	 * Get the column filter, if any, to pass to the generators
	 *
	 * @param columnEntityType The type of column to filter on
	 * @return A column filter
	 */
	public static String getColumnFilter(String columnEntityType) {
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
		return !columnFilterBuilder.isEmpty() ? columnFilterBuilder.toString() : null;
	}

	/**
	 * The generators all use the same SQL to fetch the tables to work with, so get the tables
	 *
	 * @param tableName         The table name(s) we're getting
	 * @param entityType        An entity type filter for the tables
	 * @param resultSetConsumer A consumer that will handle the result set returned by the queries
	 */
	public static void buildAndExecuteTableSql(String tableName, String entityType,
			ConsumerWithThrows<ResultSet> resultSetConsumer) {
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

		try (PreparedStatement preparedStatement = DB.prepareStatement(sql.toString(), null)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				resultSetConsumer.accept(resultSet);
			}
		} catch (SQLException e) {
			throw new DBException(e, sql.toString());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Generate java imports
	 *
	 * @param classesToImport The classes to be imported
	 * @param generatedCode   The code we're adding the imports to
	 */
	public static void createImports(Collection<String> classesToImport, StringBuilder generatedCode) {
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
}
