package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RfQ_TopicSubscriberDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_Product_CategoryDataLoader;
import org.compiere.model.MRfQTopicSubscriber;
import org.compiere.model.MRfQTopicSubscriberOnly;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_RfQ_TopicSubscriberOnly - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_RfQ_TopicSubscriberOnlyResolver extends POResolver<MRfQTopicSubscriberOnly> implements GraphQLResolver<MRfQTopicSubscriberOnly> {



	/**
	 * Get RfQ Subscriber.
	 *
	 * @return Request for Quotation Topic Subscriber
	 */
	public CompletableFuture<MRfQTopicSubscriber> C_RfQ_TopicSubscriber(MRfQTopicSubscriberOnly entity, DataFetchingEnvironment environment) {
		if (entity.getC_RfQ_TopicSubscriber_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MRfQTopicSubscriber> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RfQ_TopicSubscriberDataLoader.DATALOADER_C_RfQ_TopicSubscriber_BY_ID);
		return dataLoader.load(entity.getC_RfQ_TopicSubscriber_ID());
	}


	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	public CompletableFuture<MProductCategory_BH> M_Product_Category(MRfQTopicSubscriberOnly entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_Category_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProductCategory_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_Product_CategoryDataLoader.DATALOADER_M_Product_Category_BY_ID);
		return dataLoader.load(entity.getM_Product_Category_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MRfQTopicSubscriberOnly entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

}
