package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DistributionListDataLoader;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MDistributionList;
import org.compiere.model.MDistributionListLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_DistributionListLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_DistributionListLineResolver extends POResolver<MDistributionListLine> implements GraphQLResolver<MDistributionListLine> {



	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MDistributionListLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(MDistributionListLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getC_BPartner_Location_ID());
	}


	/**
	 * Get Distribution List.
	 *
	 * @return Distribution Lists allow to distribute products to a selected list of partners
	 */
	public CompletableFuture<MDistributionList> M_DistributionList(MDistributionListLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_DistributionList_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDistributionList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DistributionListDataLoader.DATALOADER_M_DistributionList_BY_ID);
		return dataLoader.load(entity.getM_DistributionList_ID());
	}

}
