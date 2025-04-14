package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.X_C_BP_Relation;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_BP_Relation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_BP_RelationResolver extends POResolver<X_C_BP_Relation> implements GraphQLResolver<X_C_BP_Relation> {



	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_C_BP_Relation entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
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
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(X_C_BP_Relation entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getC_BPartner_Location_ID());
	}


	/**
	 * Get Related Partner.
	 *
	 * @return Related Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartnerRelation(X_C_BP_Relation entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartnerRelation_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartnerRelation_ID());
	}


	/**
	 * Get Related Partner Location.
	 *
	 * @return Location of the related Business Partner
	 */
	public CompletableFuture<MBPartnerLocation> C_BPartnerRelation_Location(X_C_BP_Relation entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartnerRelation_Location_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getC_BPartnerRelation_Location_ID());
	}

	public Boolean IsBillTo(X_C_BP_Relation entity, DataFetchingEnvironment environment) {
		return entity.isBillTo();
	}

	public Boolean IsPayFrom(X_C_BP_Relation entity, DataFetchingEnvironment environment) {
		return entity.isPayFrom();
	}

	public Boolean IsRemitTo(X_C_BP_Relation entity, DataFetchingEnvironment environment) {
		return entity.isRemitTo();
	}

	public Boolean IsShipTo(X_C_BP_Relation entity, DataFetchingEnvironment environment) {
		return entity.isShipTo();
	}

}
