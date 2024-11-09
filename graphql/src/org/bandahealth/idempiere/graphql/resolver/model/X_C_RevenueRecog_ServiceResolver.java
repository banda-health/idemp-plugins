package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RevenueRecognitionDataLoader;
import org.compiere.model.MRevenueRecogService;
import org.compiere.model.MRevenueRecognition;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_RevenueRecog_Service - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RevenueRecog_ServiceResolver extends POResolver<MRevenueRecogService> implements GraphQLResolver<MRevenueRecogService> {



	/**
	 * Get Revenue Recognition.
	 *
	 * @return Method for recording revenue
	 */
	public CompletableFuture<MRevenueRecognition> C_RevenueRecognition(MRevenueRecogService entity, DataFetchingEnvironment environment) {
		if (entity.getC_RevenueRecognition_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MRevenueRecognition> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RevenueRecognitionDataLoader.DATALOADER_C_RevenueRecognition_BY_ID);
		return dataLoader.load(entity.getC_RevenueRecognition_ID());
	}

}
