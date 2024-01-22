package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ModificationInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ModificationInput;
import org.compiere.model.X_AD_Modification;

import java.util.List;

/**
 * Generated Query Resolver for AD_Modification - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ModificationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ModificationInput.Table_Name;
	}

	public X_AD_Modification AD_ModificationSave(I_AD_ModificationInput input, DataFetchingEnvironment environment) {
		return (X_AD_Modification) super.save((X_AD_ModificationInput) input, environment);
	}

	public boolean AD_ModificationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
