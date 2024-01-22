package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_SubstituteInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_SubstituteInput;
import org.compiere.model.X_M_Substitute;

import java.util.List;

/**
 * Generated Query Resolver for M_Substitute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_SubstituteMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_SubstituteInput.Table_Name;
	}

	public X_M_Substitute M_SubstituteSave(I_M_SubstituteInput input, DataFetchingEnvironment environment) {
		return (X_M_Substitute) super.save((X_M_SubstituteInput) input, environment);
	}

	public boolean M_SubstituteDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
