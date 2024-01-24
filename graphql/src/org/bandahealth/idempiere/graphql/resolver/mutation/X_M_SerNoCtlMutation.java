package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_SerNoCtlInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_SerNoCtlInput;

import java.util.List;

/**
 * Generated Query Resolver for M_SerNoCtl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_SerNoCtlMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_SerNoCtlInput.Table_Name;
	}

	public MSerNoCtl_BH M_SerNoCtlSave(I_M_SerNoCtlInput input, DataFetchingEnvironment environment) {
		return (MSerNoCtl_BH) super.save((X_M_SerNoCtlInput) input, environment);
	}

	public boolean M_SerNoCtlDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
