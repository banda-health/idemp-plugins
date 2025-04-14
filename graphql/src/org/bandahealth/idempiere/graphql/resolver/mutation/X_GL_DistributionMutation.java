package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_DistributionInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_DistributionInput;
import org.compiere.model.MDistribution;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for GL_Distribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_GL_DistributionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_DistributionInput.Table_Name;
	}

	public MDistribution GL_DistributionSave(I_GL_DistributionInput Entity, DataFetchingEnvironment environment) {
		return (MDistribution) super.save((X_GL_DistributionInput) Entity, environment);
	}

	public List<MDistribution> GL_DistributionSaveMany(List<I_GL_DistributionInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_GL_DistributionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDistribution) entity).collect(Collectors.toList());
	}

	public boolean GL_DistributionDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
