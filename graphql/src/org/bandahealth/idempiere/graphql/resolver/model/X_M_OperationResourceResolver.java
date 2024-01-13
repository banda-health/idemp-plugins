package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_JobDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductOperationDataLoader;
import org.compiere.model.MAsset;
import org.compiere.model.X_C_Job;
import org.compiere.model.X_M_OperationResource;
import org.compiere.model.X_M_ProductOperation;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_OperationResource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_OperationResourceResolver extends POResolver<X_M_OperationResource> implements GraphQLResolver<X_M_OperationResource> {



	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(X_M_OperationResource entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Asset_ID());
	}


	/**
	 * Get Position.
	 *
	 * @return Job Position
	 */
	public CompletableFuture<X_C_Job> C_Job(X_M_OperationResource entity, DataFetchingEnvironment environment) {
		if (entity.getC_Job_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_Job> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_JobDataLoader.DATALOADER_C_Job_BY_ID);
		return dataLoader.load(entity.getC_Job_ID());
	}


	/**
	 * Get Product Operation.
	 *
	 * @return Product Manufacturing Operation
	 */
	public CompletableFuture<X_M_ProductOperation> M_ProductOperation(X_M_OperationResource entity, DataFetchingEnvironment environment) {
		if (entity.getM_ProductOperation_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_M_ProductOperation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductOperationDataLoader.DATALOADER_M_ProductOperation_BY_ID);
		return dataLoader.load(entity.getM_ProductOperation_ID());
	}

}
