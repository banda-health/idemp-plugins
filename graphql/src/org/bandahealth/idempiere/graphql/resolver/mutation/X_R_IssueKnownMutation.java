package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_IssueKnownInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_IssueKnownInput;
import org.compiere.model.X_R_IssueKnown;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_IssueKnown - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_IssueKnownMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_IssueKnownInput.Table_Name;
	}

	public X_R_IssueKnown R_IssueKnownSave(I_R_IssueKnownInput Entity, DataFetchingEnvironment environment) {
		return (X_R_IssueKnown) super.save((X_R_IssueKnownInput) Entity, environment);
	}

	public List<X_R_IssueKnown> R_IssueKnownSaveMany(List<I_R_IssueKnownInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_R_IssueKnownInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_R_IssueKnown) entity).collect(Collectors.toList());
	}

	public boolean R_IssueKnownDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
