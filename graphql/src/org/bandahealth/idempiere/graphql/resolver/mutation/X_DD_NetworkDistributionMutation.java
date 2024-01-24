package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_DD_NetworkDistributionInput;
import org.bandahealth.idempiere.graphql.model.input.X_DD_NetworkDistributionInput;
import org.eevolution.model.X_DD_NetworkDistribution;

import java.util.List;

/**
 * Generated Query Resolver for DD_NetworkDistribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_DD_NetworkDistributionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_DD_NetworkDistributionInput.Table_Name;
	}

	public X_DD_NetworkDistribution DD_NetworkDistributionSave(I_DD_NetworkDistributionInput input, DataFetchingEnvironment environment) {
		return (X_DD_NetworkDistribution) super.save((X_DD_NetworkDistributionInput) input, environment);
	}

	public boolean DD_NetworkDistributionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
