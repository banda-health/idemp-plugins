package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_Cost_CollectorInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_Cost_CollectorInput;
import org.eevolution.model.X_PP_Cost_Collector;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PP_Cost_Collector - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Cost_CollectorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_Cost_CollectorInput.Table_Name;
	}

	public X_PP_Cost_Collector PP_Cost_CollectorSave(I_PP_Cost_CollectorInput Entity, DataFetchingEnvironment environment) {
		return (X_PP_Cost_Collector) super.save((X_PP_Cost_CollectorInput) Entity, environment);
	}

	public List<X_PP_Cost_Collector> PP_Cost_CollectorSaveMany(List<I_PP_Cost_CollectorInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PP_Cost_CollectorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_PP_Cost_Collector) entity).collect(Collectors.toList());
	}

	public boolean PP_Cost_CollectorDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
