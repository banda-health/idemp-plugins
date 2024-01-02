package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for C_Currency - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CurrencyResolver extends POResolver<MCurrency_BH> implements GraphQLResolver<MCurrency_BH> {


	public Boolean IsEMUMember(MCurrency_BH entity, DataFetchingEnvironment environment) {
		return entity.isEMUMember();
	}

	public Boolean IsEuro(MCurrency_BH entity, DataFetchingEnvironment environment) {
		return entity.isEuro();
	}

}
