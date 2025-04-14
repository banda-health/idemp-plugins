package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPaymentRef;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_PaymentRef - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_PaymentRefResolver extends POResolver<MBHPaymentRef> implements GraphQLResolver<MBHPaymentRef> {



	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	public CompletableFuture<MReference_BH> AD_Reference(MBHPaymentRef entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_ID());
	}

}
