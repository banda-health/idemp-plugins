package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DistributionListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DistributionRunDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.MDistributionList;
import org.compiere.model.MDistributionRun;
import org.compiere.model.MDistributionRunLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_DistributionRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_DistributionRunLineResolver extends POResolver<MDistributionRunLine> implements GraphQLResolver<MDistributionRunLine> {



	/**
	 * Get Distribution List.
	 *
	 * @return Distribution Lists allow to distribute products to a selected list of partners
	 */
	public CompletableFuture<MDistributionList> M_DistributionList(MDistributionRunLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_DistributionList_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MDistributionList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DistributionListDataLoader.DATALOADER_M_DistributionList_BY_ID);
		return dataLoader.load(entity.getM_DistributionList_ID());
	}


	/**
	 * Get Distribution Run.
	 *
	 * @return Distribution Run create Orders to distribute products to a selected list of partners
	 */
	public CompletableFuture<MDistributionRun> M_DistributionRun(MDistributionRunLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_DistributionRun_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MDistributionRun> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DistributionRunDataLoader.DATALOADER_M_DistributionRun_BY_ID);
		return dataLoader.load(entity.getM_DistributionRun_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MDistributionRunLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

}
