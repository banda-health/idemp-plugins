package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_ASP_LevelDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_ASP_ModuleDataLoader;
import org.compiere.model.X_ASP_ClientLevel;
import org.compiere.model.X_ASP_Level;
import org.compiere.model.X_ASP_Module;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for ASP_ClientLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_ASP_ClientLevelResolver extends POResolver<X_ASP_ClientLevel> implements GraphQLResolver<X_ASP_ClientLevel> {



	/**
	 * Get ASP Level.
	 *
	 * @return ASP Level
	 */
	public CompletableFuture<X_ASP_Level> ASP_Level(X_ASP_ClientLevel entity, DataFetchingEnvironment environment) {
		if (entity.getASP_Level_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_ASP_Level> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_ASP_LevelDataLoader.DATALOADER_ASP_Level_BY_ID);
		return dataLoader.load(entity.getASP_Level_ID());
	}


	/**
	 * Get ASP Module.
	 *
	 * @return ASP Module
	 */
	public CompletableFuture<X_ASP_Module> ASP_Module(X_ASP_ClientLevel entity, DataFetchingEnvironment environment) {
		if (entity.getASP_Module_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_ASP_Module> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_ASP_ModuleDataLoader.DATALOADER_ASP_Module_BY_ID);
		return dataLoader.load(entity.getASP_Module_ID());
	}

}
