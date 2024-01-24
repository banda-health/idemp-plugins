package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_StyleLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_StyleLineInput;
import org.compiere.model.X_AD_StyleLine;

import java.util.List;

/**
 * Generated Query Resolver for AD_StyleLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_StyleLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_StyleLineInput.Table_Name;
	}

	public X_AD_StyleLine AD_StyleLineSave(I_AD_StyleLineInput input, DataFetchingEnvironment environment) {
		return (X_AD_StyleLine) super.save((X_AD_StyleLineInput) input, environment);
	}

	public boolean AD_StyleLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
