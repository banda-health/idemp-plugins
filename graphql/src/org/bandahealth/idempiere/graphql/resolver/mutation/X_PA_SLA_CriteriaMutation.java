package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_SLA_CriteriaInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_SLA_CriteriaInput;
import org.compiere.model.X_PA_SLA_Criteria;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_SLA_Criteria - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_SLA_CriteriaMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_SLA_CriteriaInput.Table_Name;
	}

	public X_PA_SLA_Criteria PA_SLA_CriteriaSave(I_PA_SLA_CriteriaInput Entity, DataFetchingEnvironment environment) {
		return (X_PA_SLA_Criteria) super.save((X_PA_SLA_CriteriaInput) Entity, environment);
	}

	public List<X_PA_SLA_Criteria> PA_SLA_CriteriaSaveMany(List<I_PA_SLA_CriteriaInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PA_SLA_CriteriaInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_PA_SLA_Criteria) entity).collect(Collectors.toList());
	}

	public boolean PA_SLA_CriteriaDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
