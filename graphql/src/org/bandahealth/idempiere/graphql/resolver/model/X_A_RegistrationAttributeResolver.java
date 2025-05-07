package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.compiere.model.MRegistrationAttribute;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_RegistrationAttribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_RegistrationAttributeResolver extends POResolver<MRegistrationAttribute> implements GraphQLResolver<MRegistrationAttribute> {



	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	public CompletableFuture<MReference_BH> AD_Reference(MRegistrationAttribute entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_ID());
	}


	/**
	 * Get Reference Key.
	 *
	 * @return Required to specify, if data type is Table or List
	 */
	public CompletableFuture<MReference_BH> AD_Reference_Value(MRegistrationAttribute entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_Value_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_Value_ID());
	}

	public Boolean IsSelfService(MRegistrationAttribute entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}

}
