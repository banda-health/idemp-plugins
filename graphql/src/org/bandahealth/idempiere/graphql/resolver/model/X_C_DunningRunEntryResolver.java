package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DunningLevelDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DunningRunDataLoader;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MDunningLevel;
import org.compiere.model.MDunningRun;
import org.compiere.model.MDunningRunEntry;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_DunningRunEntry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_DunningRunEntryResolver extends POResolver<MDunningRunEntry> implements GraphQLResolver<MDunningRunEntry> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MDunningRunEntry entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MDunningRunEntry entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 0) {
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
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(MDunningRunEntry entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getC_BPartner_Location_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MDunningRunEntry entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Dunning Level.
	 *
	 * @return Dunning Level
	 */
	public CompletableFuture<MDunningLevel> C_DunningLevel(MDunningRunEntry entity, DataFetchingEnvironment environment) {
		if (entity.getC_DunningLevel_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDunningLevel> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DunningLevelDataLoader.DATALOADER_C_DunningLevel_BY_ID);
		return dataLoader.load(entity.getC_DunningLevel_ID());
	}


	/**
	 * Get Dunning Run.
	 *
	 * @return Dunning Run
	 */
	public CompletableFuture<MDunningRun> C_DunningRun(MDunningRunEntry entity, DataFetchingEnvironment environment) {
		if (entity.getC_DunningRun_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDunningRun> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DunningRunDataLoader.DATALOADER_C_DunningRun_BY_ID);
		return dataLoader.load(entity.getC_DunningRun_ID());
	}

	public Boolean Processed(MDunningRunEntry entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(MDunningRunEntry entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSalesRep_ID());
	}

}
