package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_RegistrationAttributeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_RegistrationDataLoader;
import org.compiere.model.MRegistration;
import org.compiere.model.MRegistrationAttribute;
import org.compiere.model.MRegistrationValue;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_RegistrationValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_RegistrationValueResolver extends POResolver<MRegistrationValue> implements GraphQLResolver<MRegistrationValue> {



	/**
	 * Get Registration.
	 *
	 * @return User Asset Registration
	 */
	public CompletableFuture<MRegistration> A_Registration(MRegistrationValue entity, DataFetchingEnvironment environment) {
		if (entity.getA_Registration_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRegistration> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_RegistrationDataLoader.DATALOADER_A_Registration_BY_ID);
		return dataLoader.load(entity.getA_Registration_ID());
	}


	/**
	 * Get Registration Attribute.
	 *
	 * @return Asset Registration Attribute
	 */
	public CompletableFuture<MRegistrationAttribute> A_RegistrationAttribute(MRegistrationValue entity, DataFetchingEnvironment environment) {
		if (entity.getA_RegistrationAttribute_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRegistrationAttribute> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_RegistrationAttributeDataLoader.DATALOADER_A_RegistrationAttribute_BY_ID);
		return dataLoader.load(entity.getA_RegistrationAttribute_ID());
	}

}
