package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_LdapProcessorDataLoader;
import org.compiere.model.MLdapProcessor;
import org.compiere.model.MLdapProcessorLog;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_LdapProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_LdapProcessorLogResolver extends POResolver<MLdapProcessorLog> implements GraphQLResolver<MLdapProcessorLog> {



	/**
	 * Get Ldap Processor.
	 *
	 * @return LDAP Server to authenticate and authorize external systems based on iDempiere
	 */
	public CompletableFuture<MLdapProcessor> AD_LdapProcessor(MLdapProcessorLog entity, DataFetchingEnvironment environment) {
		if (entity.getAD_LdapProcessor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLdapProcessor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_LdapProcessorDataLoader.DATALOADER_AD_LdapProcessor_BY_ID);
		return dataLoader.load(entity.getAD_LdapProcessor_ID());
	}

	public Boolean IsError(MLdapProcessorLog entity, DataFetchingEnvironment environment) {
		return entity.isError();
	}

}
