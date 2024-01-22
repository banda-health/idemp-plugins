package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_IssueKnownInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_IssueKnownInput;
import org.compiere.model.X_R_IssueKnown;

import java.util.List;

/**
 * Generated Query Resolver for R_IssueKnown - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_IssueKnownMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_IssueKnownInput.Table_Name;
	}

	public X_R_IssueKnown R_IssueKnownSave(I_R_IssueKnownInput input, DataFetchingEnvironment environment) {
		return (X_R_IssueKnown) super.save((X_R_IssueKnownInput) input, environment);
	}

	public boolean R_IssueKnownDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
