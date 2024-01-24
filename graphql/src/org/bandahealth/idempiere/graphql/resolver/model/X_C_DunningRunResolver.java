package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DunningDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DunningLevelDataLoader;
import org.compiere.model.MDunning;
import org.compiere.model.MDunningLevel;
import org.compiere.model.MDunningRun;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_DunningRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DunningRunResolver extends POResolver<MDunningRun> implements GraphQLResolver<MDunningRun> {



	/**
	 * Get Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	public CompletableFuture<MDunning> C_Dunning(MDunningRun entity, DataFetchingEnvironment environment) {
		if (entity.getC_Dunning_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDunning> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DunningDataLoader.DATALOADER_C_Dunning_BY_ID);
		return dataLoader.load(entity.getC_Dunning_ID());
	}


	/**
	 * Get Dunning Level.
	 *
	 * @return Dunning Level
	 */
	public CompletableFuture<MDunningLevel> C_DunningLevel(MDunningRun entity, DataFetchingEnvironment environment) {
		if (entity.getC_DunningLevel_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDunningLevel> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DunningLevelDataLoader.DATALOADER_C_DunningLevel_BY_ID);
		return dataLoader.load(entity.getC_DunningLevel_ID());
	}

	public Boolean Processed(MDunningRun entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MDunningRun entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
