package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_LotCtlInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_LotCtlInput;
import org.compiere.model.MLotCtl;

import java.util.List;

/**
 * Generated Query Resolver for M_LotCtl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_LotCtlMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_LotCtlInput.Table_Name;
	}

	public MLotCtl M_LotCtlSave(I_M_LotCtlInput input, DataFetchingEnvironment environment) {
		return (MLotCtl) super.save((X_M_LotCtlInput) input, environment);
	}

	public boolean M_LotCtlDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
