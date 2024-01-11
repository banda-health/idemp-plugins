package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_MatchPOInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_MatchPOInput;
import org.compiere.model.MMatchPO;

import java.util.List;

/**
 * Generated Query Resolver for M_MatchPO - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_MatchPOMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_MatchPOInput.Table_Name;
	}

	public MMatchPO M_MatchPOSave(I_M_MatchPOInput input, DataFetchingEnvironment environment) {
		return (MMatchPO) super.save((X_M_MatchPOInput) input, environment);
	}

	public boolean M_MatchPODelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
