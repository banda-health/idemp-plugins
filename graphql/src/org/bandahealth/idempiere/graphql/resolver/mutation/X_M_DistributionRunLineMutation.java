package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_DistributionRunLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_DistributionRunLineInput;
import org.compiere.model.MDistributionRunLine;

import java.util.List;

/**
 * Generated Query Resolver for M_DistributionRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DistributionRunLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_DistributionRunLineInput.Table_Name;
	}

	public MDistributionRunLine M_DistributionRunLineSave(I_M_DistributionRunLineInput input, DataFetchingEnvironment environment) {
		return (MDistributionRunLine) super.save((X_M_DistributionRunLineInput) input, environment);
	}

	public boolean M_DistributionRunLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
