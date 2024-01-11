package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_StatusLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_StatusLineInput;
import org.compiere.model.MStatusLine;

import java.util.List;

/**
 * Generated Query Resolver for AD_StatusLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_StatusLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_StatusLineInput.Table_Name;
	}

	public MStatusLine AD_StatusLineSave(I_AD_StatusLineInput input, DataFetchingEnvironment environment) {
		return (MStatusLine) super.save((X_AD_StatusLineInput) input, environment);
	}

	public boolean AD_StatusLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
