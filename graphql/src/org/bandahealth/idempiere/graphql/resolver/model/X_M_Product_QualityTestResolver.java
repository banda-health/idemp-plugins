package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_QualityTestDataLoader;
import org.compiere.model.MQualityTest;
import org.compiere.model.X_M_Product_QualityTest;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Product_QualityTest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_Product_QualityTestResolver extends POResolver<X_M_Product_QualityTest> implements GraphQLResolver<X_M_Product_QualityTest> {



	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_M_Product_QualityTest entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Quality Test.
	 *
	 * @return Quality Test
	 */
	public CompletableFuture<MQualityTest> M_QualityTest(X_M_Product_QualityTest entity, DataFetchingEnvironment environment) {
		if (entity.getM_QualityTest_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MQualityTest> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_QualityTestDataLoader.DATALOADER_M_QualityTest_BY_ID);
		return dataLoader.load(entity.getM_QualityTest_ID());
	}

}
