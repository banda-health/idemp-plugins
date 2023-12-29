package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_InOutInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_InOutInput;

import java.util.List;

/**
 * Generated Query Resolver for M_InOut - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InOutMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_InOutInput.Table_Name;
	}

	public MInOut_BH M_InOutSave(I_M_InOutInput input, DataFetchingEnvironment environment) {
		return (MInOut_BH) super.save((X_M_InOutInput) input, environment);
	}

	public boolean M_InOutDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
