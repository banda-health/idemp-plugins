package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Sequence_NoInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Sequence_NoInput;
import org.compiere.model.X_AD_Sequence_No;

import java.util.List;

/**
 * Generated Query Resolver for AD_Sequence_No - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Sequence_NoMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Sequence_NoInput.Table_Name;
	}

	public X_AD_Sequence_No AD_Sequence_NoSave(I_AD_Sequence_NoInput input, DataFetchingEnvironment environment) {
		return (X_AD_Sequence_No) super.save((X_AD_Sequence_NoInput) input, environment);
	}

	public boolean AD_Sequence_NoDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
