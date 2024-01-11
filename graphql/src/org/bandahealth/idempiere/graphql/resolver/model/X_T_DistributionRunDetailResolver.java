package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DistributionListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DistributionListLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DistributionRunDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DistributionRunLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MDistributionList;
import org.compiere.model.MDistributionListLine;
import org.compiere.model.MDistributionRun;
import org.compiere.model.MDistributionRunDetail;
import org.compiere.model.MDistributionRunLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for T_DistributionRunDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_DistributionRunDetailResolver extends POResolver<MDistributionRunDetail> implements GraphQLResolver<MDistributionRunDetail> {



	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MDistributionRunDetail entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.C_BPartner_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(MDistributionRunDetail entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.C_BPartner_Location_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BPartner_Location_ID());
	}


	/**
	 * Get Distribution List.
	 *
	 * @return Distribution Lists allow to distribute products to a selected list of partners
	 */
	public CompletableFuture<MDistributionList> M_DistributionList(MDistributionRunDetail entity, DataFetchingEnvironment environment) {
		if (entity.getM_DistributionList_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDistributionList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DistributionListDataLoader.M_DistributionList_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_DistributionList_ID());
	}


	/**
	 * Get Distribution List Line.
	 *
	 * @return Distribution List Line with Business Partner and Quantity/Percentage
	 */
	public CompletableFuture<MDistributionListLine> M_DistributionListLine(MDistributionRunDetail entity, DataFetchingEnvironment environment) {
		if (entity.getM_DistributionListLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDistributionListLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DistributionListLineDataLoader.M_DistributionListLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_DistributionListLine_ID());
	}


	/**
	 * Get Distribution Run.
	 *
	 * @return Distribution Run create Orders to distribute products to a selected list of partners
	 */
	public CompletableFuture<MDistributionRun> M_DistributionRun(MDistributionRunDetail entity, DataFetchingEnvironment environment) {
		if (entity.getM_DistributionRun_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDistributionRun> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DistributionRunDataLoader.M_DistributionRun_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_DistributionRun_ID());
	}


	/**
	 * Get Distribution Run Line.
	 *
	 * @return Distribution Run Lines define Distribution List, the Product and Quantities
	 */
	public CompletableFuture<MDistributionRunLine> M_DistributionRunLine(MDistributionRunDetail entity, DataFetchingEnvironment environment) {
		if (entity.getM_DistributionRunLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDistributionRunLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DistributionRunLineDataLoader.M_DistributionRunLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_DistributionRunLine_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MDistributionRunDetail entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}

}
