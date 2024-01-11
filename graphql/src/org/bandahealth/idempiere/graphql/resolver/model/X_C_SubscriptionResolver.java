package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_SubscriptionTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.X_C_Subscription;
import org.compiere.model.X_C_SubscriptionType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Subscription - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_SubscriptionResolver extends POResolver<X_C_Subscription> implements GraphQLResolver<X_C_Subscription> {



	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_C_Subscription entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.C_BPartner_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Subscription Type.
	 *
	 * @return Type of subscription
	 */
	public CompletableFuture<X_C_SubscriptionType> C_SubscriptionType(X_C_Subscription entity, DataFetchingEnvironment environment) {
		if (entity.getC_SubscriptionType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_SubscriptionType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_SubscriptionTypeDataLoader.C_SubscriptionType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_SubscriptionType_ID());
	}

	public Boolean IsDue(X_C_Subscription entity, DataFetchingEnvironment environment) {
		return entity.isDue();
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_C_Subscription entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}

}
