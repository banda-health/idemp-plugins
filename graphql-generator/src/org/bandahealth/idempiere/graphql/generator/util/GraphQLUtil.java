package org.bandahealth.idempiere.graphql.generator.util;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.util.CLogger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GraphQLUtil {
	private static final CLogger log = CLogger.getCLogger(GraphQLUtil.class);
	private static Pattern tableNamePattern = Pattern.compile("Table_Name = \"(.*)\";");
	private static Pattern packagePattern = Pattern.compile("(?<!//)package (.*);");

	public static Map<String, ModelMap> getModelsForTables(String customModelDirectory) throws IOException {
		// Look through all files and find the generated class
		String currentPath = Path.of("").toAbsolutePath().toString();
		List<File> modelFiles = Stream.concat(
				Arrays.stream(
						Objects.requireNonNull(new File(currentPath + "/org.adempiere.base/src/org/compiere/model").listFiles())),
				Arrays.stream(
						Objects.requireNonNull(new File(currentPath + "/org.adempiere.base/src/org/eevolution/model").listFiles()))
		).collect(Collectors.toList());
		File file;
		if (customModelDirectory != null && !customModelDirectory.isEmpty() &&
				(file = new File(customModelDirectory)).exists() && file.isDirectory()) {
			modelFiles = Stream.concat(modelFiles.stream(), Arrays.stream(
					Objects.requireNonNull(new File(customModelDirectory).listFiles()))).collect(Collectors.toList());
		}

		Map<String, ModelMap> modelsForTables = new HashMap<>();
		Map<String, String> interfacesByTable = new HashMap<>();
		Map<String, String> generatedClassByInterface = new HashMap<>();
		Map<String, String> manualClassByExtendedClass = new HashMap<>();
		Map<String, String> packageByClass = new HashMap<>();
		List<String> filesToSkip =
				Arrays.asList("PO.java", "Lookup.java", "TestCase.java", "EventObject.java", "EventListener.java");

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
			} else if (content.contains(" extends ")) {
				// This is a manual model of some sort, so put it in the appropriate place if it's not final
				if (!content.contains(" final class " + structureName)) {
					String extendedClassName = content.split(" extends ")[1].trim().split("\\s")[0].split(",")[0].trim();
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
}
