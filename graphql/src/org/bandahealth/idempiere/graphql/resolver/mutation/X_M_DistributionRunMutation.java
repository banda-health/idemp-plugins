package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_DistributionRunInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_DistributionRunInput;
import org.compiere.model.MDistributionRun;

import java.util.List;

/**
 * Generated Query Resolver for M_DistributionRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DistributionRunMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_DistributionRunInput.Table_Name;
	}

	public MDistributionRun M_DistributionRunSave(I_M_DistributionRunInput input, DataFetchingEnvironment environment) {
		return (MDistributionRun) super.save((X_M_DistributionRunInput) input, environment);
	}

	public boolean M_DistributionRunDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
