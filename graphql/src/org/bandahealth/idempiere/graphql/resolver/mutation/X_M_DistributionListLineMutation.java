package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_DistributionListLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_DistributionListLineInput;
import org.compiere.model.MDistributionListLine;

import java.util.List;

/**
 * Generated Query Resolver for M_DistributionListLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_DistributionListLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_DistributionListLineInput.Table_Name;
	}

	public MDistributionListLine M_DistributionListLineSave(I_M_DistributionListLineInput input, DataFetchingEnvironment environment) {
		return (MDistributionListLine) super.save((X_M_DistributionListLineInput) input, environment);
	}

	public boolean M_DistributionListLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
