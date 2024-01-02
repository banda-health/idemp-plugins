package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.MTaxCategory;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for C_TaxCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxCategoryResolver extends POResolver<MTaxCategory> implements GraphQLResolver<MTaxCategory> {


	public Boolean IsDefault(MTaxCategory entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

}
