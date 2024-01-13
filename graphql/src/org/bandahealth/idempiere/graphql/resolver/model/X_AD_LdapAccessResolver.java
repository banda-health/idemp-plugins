package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_LdapProcessorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_InterestAreaDataLoader;
import org.compiere.model.MInterestArea;
import org.compiere.model.MLdapAccess;
import org.compiere.model.MLdapProcessor;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_LdapAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_LdapAccessResolver extends POResolver<MLdapAccess> implements GraphQLResolver<MLdapAccess> {



	/**
	 * Get Ldap Processor.
	 *
	 * @return LDAP Server to authenticate and authorize external systems based on iDempiere
	 */
	public CompletableFuture<MLdapProcessor> AD_LdapProcessor(MLdapAccess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_LdapProcessor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLdapProcessor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_LdapProcessorDataLoader.DATALOADER_AD_LdapProcessor_BY_ID);
		return dataLoader.load(entity.getAD_LdapProcessor_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MLdapAccess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}

	public Boolean IsError(MLdapAccess entity, DataFetchingEnvironment environment) {
		return entity.isError();
	}


	/**
	 * Get Interest Area.
	 *
	 * @return Interest Area or Topic
	 */
	public CompletableFuture<MInterestArea> R_InterestArea(MLdapAccess entity, DataFetchingEnvironment environment) {
		if (entity.getR_InterestArea_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInterestArea> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_InterestAreaDataLoader.DATALOADER_R_InterestArea_BY_ID);
		return dataLoader.load(entity.getR_InterestArea_ID());
	}

}
