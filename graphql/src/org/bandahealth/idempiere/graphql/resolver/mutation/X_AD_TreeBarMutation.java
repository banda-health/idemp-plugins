package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TreeBarInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TreeBarInput;
import org.compiere.model.X_AD_TreeBar;

import java.util.List;

/**
 * Generated Query Resolver for AD_TreeBar - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TreeBarMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeBarInput.Table_Name;
	}

	public X_AD_TreeBar AD_TreeBarSave(I_AD_TreeBarInput input, DataFetchingEnvironment environment) {
		return (X_AD_TreeBar) super.save((X_AD_TreeBarInput) input, environment);
	}

	public boolean AD_TreeBarDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
