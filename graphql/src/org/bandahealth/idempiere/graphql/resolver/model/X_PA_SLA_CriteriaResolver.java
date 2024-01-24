package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.MSLACriteria;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for PA_SLA_Criteria - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_SLA_CriteriaResolver extends POResolver<MSLACriteria> implements GraphQLResolver<MSLACriteria> {


	public Boolean IsManual(MSLACriteria entity, DataFetchingEnvironment environment) {
		return entity.isManual();
	}

}
