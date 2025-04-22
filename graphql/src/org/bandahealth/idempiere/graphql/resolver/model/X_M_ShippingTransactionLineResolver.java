package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PackageMPSDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShippingTransactionDataLoader;
import org.compiere.model.MPackageMPS;
import org.compiere.model.MShippingTransaction;
import org.compiere.model.MShippingTransactionLine;
import org.compiere.model.MUOM;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_ShippingTransactionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ShippingTransactionLineResolver extends POResolver<MShippingTransactionLine> implements GraphQLResolver<MShippingTransactionLine> {



	/**
	 * Get UOM for Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	public CompletableFuture<MUOM> C_UOM_Length(MShippingTransactionLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_Length_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_Length_ID());
	}


	/**
	 * Get UOM for Weight.
	 *
	 * @return Standard Unit of Measure for Weight
	 */
	public CompletableFuture<MUOM> C_UOM_Weight(MShippingTransactionLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_Weight_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_Weight_ID());
	}


	/**
	 * Get Package MPS.
	 *
	 * @return Package MPS
	 */
	public CompletableFuture<MPackageMPS> M_PackageMPS(MShippingTransactionLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_PackageMPS_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPackageMPS> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PackageMPSDataLoader.DATALOADER_M_PackageMPS_BY_ID);
		return dataLoader.load(entity.getM_PackageMPS_ID());
	}


	/**
	 * Get Shipping Transaction.
	 *
	 * @return Shipping Transaction
	 */
	public CompletableFuture<MShippingTransaction> M_ShippingTransaction(MShippingTransactionLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShippingTransaction_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MShippingTransaction> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShippingTransactionDataLoader.DATALOADER_M_ShippingTransaction_BY_ID);
		return dataLoader.load(entity.getM_ShippingTransaction_ID());
	}

	public Boolean Processed(MShippingTransactionLine entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
