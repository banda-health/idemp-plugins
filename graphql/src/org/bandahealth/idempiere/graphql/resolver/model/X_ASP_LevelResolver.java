package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_ASP_ModuleDataLoader;
import org.compiere.model.X_ASP_Level;
import org.compiere.model.X_ASP_Module;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for ASP_Level - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_ASP_LevelResolver extends POResolver<X_ASP_Level> implements GraphQLResolver<X_ASP_Level> {



	/**
	 * Get ASP Module.
	 *
	 * @return ASP Module
	 */
	public CompletableFuture<X_ASP_Module> ASP_Module(X_ASP_Level entity, DataFetchingEnvironment environment) {
		if (entity.getASP_Module_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_ASP_Module> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_ASP_ModuleDataLoader.DATALOADER_ASP_Module_BY_ID);
		return dataLoader.load(entity.getASP_Module_ID());
	}

	public Boolean Processing(X_ASP_Level entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
