package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_Fact_Acct_SummaryInput;
import org.bandahealth.idempiere.graphql.model.input.X_Fact_Acct_SummaryInput;
import org.compiere.model.X_Fact_Acct_Summary;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for Fact_Acct_Summary - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_Fact_Acct_SummaryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_Fact_Acct_SummaryInput.Table_Name;
	}

	public X_Fact_Acct_Summary Fact_Acct_SummarySave(I_Fact_Acct_SummaryInput entity, DataFetchingEnvironment environment) {
		return (X_Fact_Acct_Summary) super.save((X_Fact_Acct_SummaryInput) entity, environment);
	}

	public List<X_Fact_Acct_Summary> Fact_Acct_SummarySaveMany(List<I_Fact_Acct_SummaryInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_Fact_Acct_SummaryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_Fact_Acct_Summary) entity).collect(Collectors.toList());
	}

	public boolean Fact_Acct_SummaryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
