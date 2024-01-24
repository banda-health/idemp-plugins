package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_DemandDetailInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_DemandDetailInput;
import org.compiere.model.X_M_DemandDetail;

import java.util.List;

/**
 * Generated Query Resolver for M_DemandDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_DemandDetailMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_DemandDetailInput.Table_Name;
	}

	public X_M_DemandDetail M_DemandDetailSave(I_M_DemandDetailInput input, DataFetchingEnvironment environment) {
		return (X_M_DemandDetail) super.save((X_M_DemandDetailInput) input, environment);
	}

	public boolean M_DemandDetailDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
