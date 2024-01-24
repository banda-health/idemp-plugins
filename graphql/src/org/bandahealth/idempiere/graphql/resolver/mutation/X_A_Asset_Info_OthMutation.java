package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_Info_OthInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_Info_OthInput;
import org.compiere.model.X_A_Asset_Info_Oth;

import java.util.List;

/**
 * Generated Query Resolver for A_Asset_Info_Oth - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_Info_OthMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Info_OthInput.Table_Name;
	}

	public X_A_Asset_Info_Oth A_Asset_Info_OthSave(I_A_Asset_Info_OthInput input, DataFetchingEnvironment environment) {
		return (X_A_Asset_Info_Oth) super.save((X_A_Asset_Info_OthInput) input, environment);
	}

	public boolean A_Asset_Info_OthDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
