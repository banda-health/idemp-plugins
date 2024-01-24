package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_DistributionInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_DistributionInput;
import org.compiere.model.MDistribution;

import java.util.List;

/**
 * Generated Query Resolver for GL_Distribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_DistributionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_DistributionInput.Table_Name;
	}

	public MDistribution GL_DistributionSave(I_GL_DistributionInput input, DataFetchingEnvironment environment) {
		return (MDistribution) super.save((X_GL_DistributionInput) input, environment);
	}

	public boolean GL_DistributionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
