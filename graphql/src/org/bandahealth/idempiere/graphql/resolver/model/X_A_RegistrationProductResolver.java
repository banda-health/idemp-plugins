package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_RegistrationAttributeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.MRegistrationAttribute;
import org.compiere.model.X_A_RegistrationProduct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_RegistrationProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_RegistrationProductResolver extends POResolver<X_A_RegistrationProduct> implements GraphQLResolver<X_A_RegistrationProduct> {



	/**
	 * Get Registration Attribute.
	 *
	 * @return Asset Registration Attribute
	 */
	public CompletableFuture<MRegistrationAttribute> A_RegistrationAttribute(X_A_RegistrationProduct entity, DataFetchingEnvironment environment) {
		if (entity.getA_RegistrationAttribute_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MRegistrationAttribute> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_RegistrationAttributeDataLoader.DATALOADER_A_RegistrationAttribute_BY_ID);
		return dataLoader.load(entity.getA_RegistrationAttribute_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_A_RegistrationProduct entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

}
