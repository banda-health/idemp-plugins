package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.MDunning;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for C_Dunning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_DunningResolver extends POResolver<MDunning> implements GraphQLResolver<MDunning> {


	public Boolean CreateLevelsSequentially(MDunning entity, DataFetchingEnvironment environment) {
		return entity.isCreateLevelsSequentially();
	}

	public Boolean IsDefault(MDunning entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	public Boolean SendDunningLetter(MDunning entity, DataFetchingEnvironment environment) {
		return entity.isSendDunningLetter();
	}

}
