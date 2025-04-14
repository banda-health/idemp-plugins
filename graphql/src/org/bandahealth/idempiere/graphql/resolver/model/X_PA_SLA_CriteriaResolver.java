package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.X_PA_SLA_Criteria;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for PA_SLA_Criteria - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PA_SLA_CriteriaResolver extends POResolver<X_PA_SLA_Criteria> implements GraphQLResolver<X_PA_SLA_Criteria> {


	public Boolean IsManual(X_PA_SLA_Criteria entity, DataFetchingEnvironment environment) {
		return entity.isManual();
	}

}
