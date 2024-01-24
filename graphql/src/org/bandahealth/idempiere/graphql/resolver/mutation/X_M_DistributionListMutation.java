package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_DistributionListInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_DistributionListInput;
import org.compiere.model.MDistributionList;

import java.util.List;

/**
 * Generated Query Resolver for M_DistributionList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_DistributionListMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_DistributionListInput.Table_Name;
	}

	public MDistributionList M_DistributionListSave(I_M_DistributionListInput input, DataFetchingEnvironment environment) {
		return (MDistributionList) super.save((X_M_DistributionListInput) input, environment);
	}

	public boolean M_DistributionListDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
