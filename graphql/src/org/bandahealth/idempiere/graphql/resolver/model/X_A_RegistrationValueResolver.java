package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_RegistrationAttributeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_RegistrationDataLoader;
import org.compiere.model.X_A_Registration;
import org.compiere.model.X_A_RegistrationAttribute;
import org.compiere.model.X_A_RegistrationValue;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_RegistrationValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_RegistrationValueResolver extends POResolver<X_A_RegistrationValue> implements GraphQLResolver<X_A_RegistrationValue> {



	/**
	 * Get Registration.
	 *
	 * @return User Asset Registration
	 */
	public CompletableFuture<X_A_Registration> A_Registration(X_A_RegistrationValue entity, DataFetchingEnvironment environment) {
		if (entity.getA_Registration_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_A_Registration> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_RegistrationDataLoader.DATALOADER_A_Registration_BY_ID);
		return dataLoader.load(entity.getA_Registration_ID());
	}


	/**
	 * Get Registration Attribute.
	 *
	 * @return Asset Registration Attribute
	 */
	public CompletableFuture<X_A_RegistrationAttribute> A_RegistrationAttribute(X_A_RegistrationValue entity, DataFetchingEnvironment environment) {
		if (entity.getA_RegistrationAttribute_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_A_RegistrationAttribute> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_RegistrationAttributeDataLoader.DATALOADER_A_RegistrationAttribute_BY_ID);
		return dataLoader.load(entity.getA_RegistrationAttribute_ID());
	}

}
