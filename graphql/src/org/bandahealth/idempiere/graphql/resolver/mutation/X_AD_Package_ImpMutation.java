package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Package_ImpInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Package_ImpInput;
import org.compiere.model.X_AD_Package_Imp;

import java.util.List;

/**
 * Generated Query Resolver for AD_Package_Imp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_ImpMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Package_ImpInput.Table_Name;
	}

	public X_AD_Package_Imp AD_Package_ImpSave(I_AD_Package_ImpInput input, DataFetchingEnvironment environment) {
		return (X_AD_Package_Imp) super.save((X_AD_Package_ImpInput) input, environment);
	}

	public boolean AD_Package_ImpDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
