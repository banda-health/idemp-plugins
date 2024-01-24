package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AlertProcessorDataLoader;
import org.compiere.model.MAlert;
import org.compiere.model.MAlertProcessor;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Alert - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_AlertResolver extends POResolver<MAlert> implements GraphQLResolver<MAlert> {



	/**
	 * Get Alert Processor.
	 *
	 * @return Alert Processor/Server Parameter
	 */
	public CompletableFuture<MAlertProcessor> AD_AlertProcessor(MAlert entity, DataFetchingEnvironment environment) {
		if (entity.getAD_AlertProcessor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAlertProcessor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_AlertProcessorDataLoader.DATALOADER_AD_AlertProcessor_BY_ID);
		return dataLoader.load(entity.getAD_AlertProcessor_ID());
	}

	public Boolean EnforceClientSecurity(MAlert entity, DataFetchingEnvironment environment) {
		return entity.isEnforceClientSecurity();
	}

	public Boolean EnforceRoleSecurity(MAlert entity, DataFetchingEnvironment environment) {
		return entity.isEnforceRoleSecurity();
	}

	public Boolean IsValid(MAlert entity, DataFetchingEnvironment environment) {
		return entity.isValid();
	}

}
