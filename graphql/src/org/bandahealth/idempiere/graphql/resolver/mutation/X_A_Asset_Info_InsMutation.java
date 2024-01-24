package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_Info_InsInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_Info_InsInput;
import org.compiere.model.X_A_Asset_Info_Ins;

import java.util.List;

/**
 * Generated Query Resolver for A_Asset_Info_Ins - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_Info_InsMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Info_InsInput.Table_Name;
	}

	public X_A_Asset_Info_Ins A_Asset_Info_InsSave(I_A_Asset_Info_InsInput input, DataFetchingEnvironment environment) {
		return (X_A_Asset_Info_Ins) super.save((X_A_Asset_Info_InsInput) input, environment);
	}

	public boolean A_Asset_Info_InsDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
