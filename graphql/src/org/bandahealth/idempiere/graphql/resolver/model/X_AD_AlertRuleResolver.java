package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AlertDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.compiere.model.MAlert;
import org.compiere.model.MAlertRule;
import org.compiere.model.MTable;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_AlertRule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AlertRuleResolver extends POResolver<MAlertRule> implements GraphQLResolver<MAlertRule> {



	/**
	 * Get Alert.
	 *
	 * @return iDempiere Alert
	 */
	public CompletableFuture<MAlert> AD_Alert(MAlertRule entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Alert_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAlert> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_AlertDataLoader.AD_Alert_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Alert_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MAlertRule entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.AD_Table_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Table_ID());
	}

	public Boolean IsValid(MAlertRule entity, DataFetchingEnvironment environment) {
		return entity.isValid();
	}

}
