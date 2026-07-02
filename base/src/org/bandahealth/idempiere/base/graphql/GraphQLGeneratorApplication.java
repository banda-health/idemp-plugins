/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 2010 Heng Sin Low                							  *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 *****************************************************************************/
package org.bandahealth.idempiere.base.graphql;

import org.adempiere.util.ModelClassGenerator;
import org.adempiere.util.ModelInterfaceGenerator;
import org.bandahealth.idempiere.base.graphql.util.GraphQLDataLoaderGenerator;
import org.bandahealth.idempiere.base.graphql.util.GraphQLGeneratorDialog;
import org.bandahealth.idempiere.base.graphql.util.GraphQLInputModelClassGenerator;
import org.bandahealth.idempiere.base.graphql.util.GraphQLInputModelInterfaceGenerator;
import org.bandahealth.idempiere.base.graphql.util.GraphQLModelResolverGenerator;
import org.bandahealth.idempiere.base.graphql.util.GraphQLMutationResolverGenerator;
import org.bandahealth.idempiere.base.graphql.util.GraphQLQueryResolverGenerator;
import org.bandahealth.idempiere.base.graphql.util.GraphQLSchemaGenerator;
import org.bandahealth.idempiere.base.graphql.util.GraphQLUtil;
import org.bandahealth.idempiere.base.graphql.util.ModelMap;
import org.bandahealth.idempiere.base.model.MBHGraphqlGeneratorTemplate;
import org.bandahealth.idempiere.base.utils.StringUtil;
import org.compiere.Adempiere;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkUtil;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

/**
 * @author hengsin
 * @author tbayen - command line start
 */
public class GraphQLGeneratorApplication implements IApplication {

	private static final String GRAPHQL_TEMPLATE_UU = "0b9c9d6a-6e59-4ba4-995a-6762c9effe03";

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	@Override
	public Object start(IApplicationContext context) throws Exception {
		Adempiere.startup(false);
		Map<?, ?> args = context.getArguments();
		// IDEMPIERE-1686 - GenerateModel does not take commandline arguments
		String commandlineArgs[] = (String[]) args.get("application.args");
		if (commandlineArgs.length >= 1 && "graphql".equals(commandlineArgs[0])) {
			if (commandlineArgs.length < 2) {
				System.out.println("usage: graphql tableName [tableName...]");
				return IApplication.EXIT_OK;
			}
			String[] tableNames = new String[commandlineArgs.length - 1];
			System.arraycopy(commandlineArgs, 1, tableNames, 0, tableNames.length);
			runGraphQLGeneration(tableNames);
			stopFramework();
			return IApplication.EXIT_OK;
		} else if (commandlineArgs.length >= 4) {
			String folder = commandlineArgs[0];
			String packageName = commandlineArgs[1];
			String entityType = commandlineArgs[2];
			String tableName = commandlineArgs[3];
			String columnEntityType = null;
			if (commandlineArgs.length >= 5) {
				columnEntityType = commandlineArgs[4];
			}
			ModelInterfaceGenerator.generateSource(folder, packageName, entityType, tableName, columnEntityType);
			ModelClassGenerator.generateSource(folder, packageName, entityType, tableName, columnEntityType);
			stopFramework();
			return IApplication.EXIT_OK;
		} else if (commandlineArgs.length != 0) {
			System.out.println(
					"usage: ModelGenerator folder packageName tableEntityType tableName columnEntityType\n" +
							"   or: graphql tableName [tableName...]");
			return IApplication.EXIT_OK;
		} else {
			GraphQLGeneratorDialog dialog = new GraphQLGeneratorDialog();
			dialog.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					context.setResult(IApplication.EXIT_OK, GraphQLGeneratorApplication.this);
					try {
						// async stop https://www.eclipse.org/forums/index.php?t=msg&th=31999&goto=103832&#msg_103832
						// can cast getBundle(0) to org.osgi.framework.launch.Framework in case want more
						FrameworkUtil.getBundle(GraphQLGeneratorApplication.class).getBundleContext().getBundle(0).stop();
					} catch (BundleException be) {
						System.exit(0);
					}
				}

			});
			//dialog.setModal(true);
			dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			dialog.pack();
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		}

		// async stop on close window
		return IApplicationContext.EXIT_ASYNC_RESULT;
	}

	private void runGraphQLGeneration(String[] tableNames) throws IOException {
		MBHGraphqlGeneratorTemplate template = new Query(Env.getCtx(), MBHGraphqlGeneratorTemplate.Table_Name,
				MBHGraphqlGeneratorTemplate.COLUMNNAME_BH_GraphQLGeneratorTemplate_UU + "=?", null)
				.setParameters(GRAPHQL_TEMPLATE_UU).first();
		if (template == null) {
			throw new IllegalStateException("GraphQL generator template not found: " + GRAPHQL_TEMPLATE_UU);
		}

		String entityType = template.getTableEntityType();
		String columnEntityType = template.getColumnEntityType();
		String customModelFolder = GraphQLUtil.resolveCustomModelDirectory(template.getCustomModelFolder());
		if (customModelFolder == null) {
			customModelFolder = GraphQLUtil.resolveCustomModelDirectory(
					"/workspace/idemp-banda/base/src/org/bandahealth/idempiere/base/model");
		}
		if (customModelFolder == null) {
			throw new IllegalStateException("Could not resolve custom model folder");
		}
		Path repoRoot = Path.of(customModelFolder).resolve("../../../../../../..").normalize();
		Map<String, ModelMap> modelsForTables = GraphQLUtil.getModelsForTables(customModelFolder);

		String schemaFolder = resolveFolder(template.getSchemaFolder(), repoRoot.resolve("graphql/WEB-INF/resources"));
		String inputModelFolder = resolveFolder(template.getInputModelFolder(),
				repoRoot.resolve("graphql/src/org/bandahealth/idempiere/graphql/model/input"));
		String queryResolverFolder = resolveFolder(template.getQueryResolverFolder(),
				repoRoot.resolve("graphql/src/org/bandahealth/idempiere/graphql/resolver/query"));
		String mutationResolverFolder = resolveFolder(template.getMutationResolverFolder(),
				repoRoot.resolve("graphql/src/org/bandahealth/idempiere/graphql/resolver/mutation"));
		String modelResolverFolder = resolveFolder(template.getModelResolverFolder(),
				repoRoot.resolve("graphql/src/org/bandahealth/idempiere/graphql/resolver/model"));
		String dataLoaderFolder = resolveFolder(template.getDataLoaderFolder(),
				repoRoot.resolve("graphql/src/org/bandahealth/idempiere/graphql/dataloader/impl"));

		for (String tableName : tableNames) {
			System.out.println("Generating GraphQL artifacts for " + tableName);
			GraphQLSchemaGenerator.generateSource(entityType, tableName, columnEntityType, schemaFolder);
			GraphQLInputModelInterfaceGenerator.generateSource(entityType, tableName, columnEntityType,
					inputModelFolder, template.getInputModelPackageName(), customModelFolder,
					template.getCustomModelPackageName(), modelsForTables);
			GraphQLInputModelClassGenerator.generateSource(entityType, tableName, columnEntityType,
					inputModelFolder, template.getInputModelPackageName(), customModelFolder,
					template.getCustomModelPackageName(), template.getModelResolverPackageName(), modelsForTables);
			GraphQLQueryResolverGenerator.generateSource(entityType, tableName, columnEntityType,
					queryResolverFolder, template.getQueryResolverPackageName(),
					template.getDataLoaderPackageName(), modelsForTables);
			GraphQLMutationResolverGenerator.generateSource(entityType, tableName, mutationResolverFolder,
					template.getMutationResolverPackageName(), template.getInputModelPackageName(), modelsForTables);
			GraphQLModelResolverGenerator.generateSource(entityType, tableName, columnEntityType,
					modelResolverFolder, template.getModelResolverPackageName(),
					template.getDataLoaderPackageName(), modelsForTables);
			GraphQLDataLoaderGenerator.generateSource(entityType, tableName, dataLoaderFolder,
					template.getDataLoaderPackageName(), modelsForTables);
		}
	}

	private static String resolveFolder(String configuredFolder, Path defaultFolder) {
		if (!StringUtil.isNullOrEmpty(configuredFolder)) {
			return Path.of(configuredFolder).toString();
		}
		return defaultFolder.toString();
	}

	private static void stopFramework() {
		try {
			FrameworkUtil.getBundle(GraphQLGeneratorApplication.class).getBundleContext().getBundle(0).stop();
		} catch (BundleException be) {
			System.exit(0);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	@Override
	public void stop() {
	}

}
