package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PrintColorInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PrintColorInput;
import org.compiere.model.X_AD_PrintColor;

import java.util.List;

/**
 * Generated Query Resolver for AD_PrintColor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_PrintColorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintColorInput.Table_Name;
	}

	public X_AD_PrintColor AD_PrintColorSave(I_AD_PrintColorInput input, DataFetchingEnvironment environment) {
		return (X_AD_PrintColor) super.save((X_AD_PrintColorInput) input, environment);
	}

	public boolean AD_PrintColorDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
