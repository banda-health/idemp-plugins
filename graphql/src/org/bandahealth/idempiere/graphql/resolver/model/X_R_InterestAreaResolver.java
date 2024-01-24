package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.MInterestArea;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for R_InterestArea - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_InterestAreaResolver extends POResolver<MInterestArea> implements GraphQLResolver<MInterestArea> {


	public Boolean IsSelfService(MInterestArea entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}

}
