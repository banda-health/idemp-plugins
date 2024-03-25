package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_Cost_CollectorMAInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_Cost_CollectorMAInput;
import org.eevolution.model.X_PP_Cost_CollectorMA;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PP_Cost_CollectorMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Cost_CollectorMAMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_Cost_CollectorMAInput.Table_Name;
	}

	public X_PP_Cost_CollectorMA PP_Cost_CollectorMASave(I_PP_Cost_CollectorMAInput entity, DataFetchingEnvironment environment) {
		return (X_PP_Cost_CollectorMA) super.save((X_PP_Cost_CollectorMAInput) entity, environment);
	}

	public List<X_PP_Cost_CollectorMA> PP_Cost_CollectorMASaveMany(List<I_PP_Cost_CollectorMAInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_PP_Cost_CollectorMAInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_PP_Cost_CollectorMA) entity).collect(Collectors.toList());
	}

	public boolean PP_Cost_CollectorMADelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
