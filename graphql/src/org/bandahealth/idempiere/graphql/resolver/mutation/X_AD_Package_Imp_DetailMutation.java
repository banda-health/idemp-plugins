package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Package_Imp_DetailInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Package_Imp_DetailInput;
import org.compiere.model.X_AD_Package_Imp_Detail;

import java.util.List;

/**
 * Generated Query Resolver for AD_Package_Imp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Package_Imp_DetailMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Package_Imp_DetailInput.Table_Name;
	}

	public X_AD_Package_Imp_Detail AD_Package_Imp_DetailSave(I_AD_Package_Imp_DetailInput input, DataFetchingEnvironment environment) {
		return (X_AD_Package_Imp_Detail) super.save((X_AD_Package_Imp_DetailInput) input, environment);
	}

	public boolean AD_Package_Imp_DetailDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
