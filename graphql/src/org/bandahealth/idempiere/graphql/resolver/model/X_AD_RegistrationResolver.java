package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SystemDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LocationDataLoader;
import org.compiere.model.MLocation;
import org.compiere.model.MSystem;
import org.compiere.model.M_Registration;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Registration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_RegistrationResolver extends POResolver<M_Registration> implements GraphQLResolver<M_Registration> {



	/**
	 * Get System.
	 *
	 * @return System Definition
	 */
	public CompletableFuture<MSystem> AD_System(M_Registration entity, DataFetchingEnvironment environment) {
		if (entity.getAD_System_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MSystem> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_SystemDataLoader.DATALOADER_AD_System_BY_ID);
		return dataLoader.load(entity.getAD_System_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(M_Registration entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public CompletableFuture<MLocation> C_Location(M_Registration entity, DataFetchingEnvironment environment) {
		if (entity.getC_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_ID);
		return dataLoader.load(entity.getC_Location_ID());
	}

	public Boolean IsAllowPublish(M_Registration entity, DataFetchingEnvironment environment) {
		return entity.isAllowPublish();
	}

	public Boolean IsAllowStatistics(M_Registration entity, DataFetchingEnvironment environment) {
		return entity.isAllowStatistics();
	}

	public Boolean IsInProduction(M_Registration entity, DataFetchingEnvironment environment) {
		return entity.isInProduction();
	}

	public Boolean IsRegistered(M_Registration entity, DataFetchingEnvironment environment) {
		return entity.isRegistered();
	}

	public Boolean Processing(M_Registration entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
