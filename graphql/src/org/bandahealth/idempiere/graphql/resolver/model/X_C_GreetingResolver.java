package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.X_C_Greeting;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for C_Greeting - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_GreetingResolver extends POResolver<X_C_Greeting> implements GraphQLResolver<X_C_Greeting> {


	public Boolean IsDefault(X_C_Greeting entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	public Boolean IsFirstNameOnly(X_C_Greeting entity, DataFetchingEnvironment environment) {
		return entity.isFirstNameOnly();
	}

}
