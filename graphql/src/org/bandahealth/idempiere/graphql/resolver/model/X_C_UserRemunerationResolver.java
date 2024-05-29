package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RemunerationDataLoader;
import org.compiere.model.X_C_Remuneration;
import org.compiere.model.X_C_UserRemuneration;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_UserRemuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_UserRemunerationResolver extends POResolver<X_C_UserRemuneration> implements GraphQLResolver<X_C_UserRemuneration> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(X_C_UserRemuneration entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Remuneration.
	 *
	 * @return Wage or Salary
	 */
	public CompletableFuture<X_C_Remuneration> C_Remuneration(X_C_UserRemuneration entity, DataFetchingEnvironment environment) {
		if (entity.getC_Remuneration_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_C_Remuneration> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RemunerationDataLoader.DATALOADER_C_Remuneration_BY_ID);
		return dataLoader.load(entity.getC_Remuneration_ID());
	}

}
