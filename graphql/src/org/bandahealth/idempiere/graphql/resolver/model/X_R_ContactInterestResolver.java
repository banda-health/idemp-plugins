package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_InterestAreaDataLoader;
import org.compiere.model.MContactInterest;
import org.compiere.model.MInterestArea;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for R_ContactInterest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_ContactInterestResolver extends POResolver<MContactInterest> implements GraphQLResolver<MContactInterest> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MContactInterest entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Interest Area.
	 *
	 * @return Interest Area or Topic
	 */
	public CompletableFuture<MInterestArea> R_InterestArea(MContactInterest entity, DataFetchingEnvironment environment) {
		if (entity.getR_InterestArea_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInterestArea> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_InterestAreaDataLoader.DATALOADER_R_InterestArea_BY_ID);
		return dataLoader.load(entity.getR_InterestArea_ID());
	}

}
