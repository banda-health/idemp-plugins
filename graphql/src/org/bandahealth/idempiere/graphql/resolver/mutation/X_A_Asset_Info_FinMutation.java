package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_Info_FinInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_Info_FinInput;
import org.compiere.model.X_A_Asset_Info_Fin;

import java.util.List;

/**
 * Generated Query Resolver for A_Asset_Info_Fin - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_Info_FinMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Info_FinInput.Table_Name;
	}

	public X_A_Asset_Info_Fin A_Asset_Info_FinSave(I_A_Asset_Info_FinInput input, DataFetchingEnvironment environment) {
		return (X_A_Asset_Info_Fin) super.save((X_A_Asset_Info_FinInput) input, environment);
	}

	public boolean A_Asset_Info_FinDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
