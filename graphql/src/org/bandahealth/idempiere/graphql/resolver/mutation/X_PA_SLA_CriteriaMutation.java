package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_SLA_CriteriaInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_SLA_CriteriaInput;
import org.compiere.model.MSLACriteria;

import java.util.List;

/**
 * Generated Query Resolver for PA_SLA_Criteria - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_SLA_CriteriaMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_SLA_CriteriaInput.Table_Name;
	}

	public MSLACriteria PA_SLA_CriteriaSave(I_PA_SLA_CriteriaInput input, DataFetchingEnvironment environment) {
		return (MSLACriteria) super.save((X_PA_SLA_CriteriaInput) input, environment);
	}

	public boolean PA_SLA_CriteriaDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
