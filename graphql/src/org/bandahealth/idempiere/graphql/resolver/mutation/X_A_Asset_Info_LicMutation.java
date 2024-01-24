package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_Info_LicInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_Info_LicInput;
import org.compiere.model.X_A_Asset_Info_Lic;

import java.util.List;

/**
 * Generated Query Resolver for A_Asset_Info_Lic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_Info_LicMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Info_LicInput.Table_Name;
	}

	public X_A_Asset_Info_Lic A_Asset_Info_LicSave(I_A_Asset_Info_LicInput input, DataFetchingEnvironment environment) {
		return (X_A_Asset_Info_Lic) super.save((X_A_Asset_Info_LicInput) input, environment);
	}

	public boolean A_Asset_Info_LicDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
