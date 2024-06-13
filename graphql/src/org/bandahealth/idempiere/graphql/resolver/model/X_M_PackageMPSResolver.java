package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PackageDataLoader;
import org.compiere.model.MPackage;
import org.compiere.model.MPackageMPS;
import org.compiere.model.MUOM;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_PackageMPS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PackageMPSResolver extends POResolver<MPackageMPS> implements GraphQLResolver<MPackageMPS> {



	/**
	 * Get UOM for Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	public CompletableFuture<MUOM> C_UOM_Length(MPackageMPS entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_Length_ID() < 0) {
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
	public CompletableFuture<MUOM> C_UOM_Weight(MPackageMPS entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_Weight_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_Weight_ID());
	}


	/**
	 * Get Package.
	 *
	 * @return Shipment Package
	 */
	public CompletableFuture<MPackage> M_Package(MPackageMPS entity, DataFetchingEnvironment environment) {
		if (entity.getM_Package_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MPackage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PackageDataLoader.DATALOADER_M_Package_BY_ID);
		return dataLoader.load(entity.getM_Package_ID());
	}

	public Boolean Processed(MPackageMPS entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
