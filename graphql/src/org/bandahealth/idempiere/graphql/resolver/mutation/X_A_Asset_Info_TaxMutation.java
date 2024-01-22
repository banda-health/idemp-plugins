package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_Info_TaxInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_Info_TaxInput;
import org.compiere.model.X_A_Asset_Info_Tax;

import java.util.List;

/**
 * Generated Query Resolver for A_Asset_Info_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_Info_TaxMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Info_TaxInput.Table_Name;
	}

	public X_A_Asset_Info_Tax A_Asset_Info_TaxSave(I_A_Asset_Info_TaxInput input, DataFetchingEnvironment environment) {
		return (X_A_Asset_Info_Tax) super.save((X_A_Asset_Info_TaxInput) input, environment);
	}

	public boolean A_Asset_Info_TaxDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
