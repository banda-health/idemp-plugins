package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_SplitInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_SplitInput;
import org.compiere.model.X_A_Asset_Split;

import java.util.List;

/**
 * Generated Query Resolver for A_Asset_Split - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_SplitMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_SplitInput.Table_Name;
	}

	public X_A_Asset_Split A_Asset_SplitSave(I_A_Asset_SplitInput input, DataFetchingEnvironment environment) {
		return (X_A_Asset_Split) super.save((X_A_Asset_SplitInput) input, environment);
	}

	public boolean A_Asset_SplitDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
