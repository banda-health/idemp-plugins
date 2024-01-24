package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.MStatusCategory;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for R_StatusCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_StatusCategoryResolver extends POResolver<MStatusCategory> implements GraphQLResolver<MStatusCategory> {


	public Boolean IsDefault(MStatusCategory entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

}
