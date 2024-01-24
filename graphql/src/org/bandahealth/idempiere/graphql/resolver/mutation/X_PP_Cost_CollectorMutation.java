package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_Cost_CollectorInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_Cost_CollectorInput;
import org.eevolution.model.X_PP_Cost_Collector;

import java.util.List;

/**
 * Generated Query Resolver for PP_Cost_Collector - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PP_Cost_CollectorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_Cost_CollectorInput.Table_Name;
	}

	public X_PP_Cost_Collector PP_Cost_CollectorSave(I_PP_Cost_CollectorInput input, DataFetchingEnvironment environment) {
		return (X_PP_Cost_Collector) super.save((X_PP_Cost_CollectorInput) input, environment);
	}

	public boolean PP_Cost_CollectorDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
