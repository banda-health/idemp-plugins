package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PackageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PackageMPSDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.MInOutLine;
import org.compiere.model.MPackage;
import org.compiere.model.MPackageLine;
import org.compiere.model.MPackageMPS;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_PackageLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_PackageLineResolver extends POResolver<MPackageLine> implements GraphQLResolver<MPackageLine> {



	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	public CompletableFuture<MInOutLine> M_InOutLine(MPackageLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_InOutLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInOutLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutLineDataLoader.DATALOADER_M_InOutLine_BY_ID);
		return dataLoader.load(entity.getM_InOutLine_ID());
	}


	/**
	 * Get Package.
	 *
	 * @return Shipment Package
	 */
	public CompletableFuture<MPackage> M_Package(MPackageLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Package_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPackage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PackageDataLoader.DATALOADER_M_Package_BY_ID);
		return dataLoader.load(entity.getM_Package_ID());
	}


	/**
	 * Get Package MPS.
	 *
	 * @return Package MPS
	 */
	public CompletableFuture<MPackageMPS> M_PackageMPS(MPackageLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_PackageMPS_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPackageMPS> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PackageMPSDataLoader.DATALOADER_M_PackageMPS_BY_ID);
		return dataLoader.load(entity.getM_PackageMPS_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MPackageLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

}
