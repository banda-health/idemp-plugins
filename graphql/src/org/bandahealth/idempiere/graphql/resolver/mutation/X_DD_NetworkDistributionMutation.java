package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_DD_NetworkDistributionInput;
import org.bandahealth.idempiere.graphql.model.input.X_DD_NetworkDistributionInput;
import org.eevolution.model.X_DD_NetworkDistribution;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for DD_NetworkDistribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_DD_NetworkDistributionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_DD_NetworkDistributionInput.Table_Name;
	}

	public X_DD_NetworkDistribution DD_NetworkDistributionSave(I_DD_NetworkDistributionInput Entity, DataFetchingEnvironment environment) {
		return (X_DD_NetworkDistribution) super.save((X_DD_NetworkDistributionInput) Entity, environment);
	}

	public List<X_DD_NetworkDistribution> DD_NetworkDistributionSaveMany(List<I_DD_NetworkDistributionInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_DD_NetworkDistributionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_DD_NetworkDistribution) entity).collect(Collectors.toList());
	}

	public boolean DD_NetworkDistributionDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
