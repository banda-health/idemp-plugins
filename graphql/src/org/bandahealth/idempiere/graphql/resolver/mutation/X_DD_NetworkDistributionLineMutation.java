package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_DD_NetworkDistributionLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_DD_NetworkDistributionLineInput;
import org.eevolution.model.X_DD_NetworkDistributionLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for DD_NetworkDistributionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_DD_NetworkDistributionLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_DD_NetworkDistributionLineInput.Table_Name;
	}

	public X_DD_NetworkDistributionLine DD_NetworkDistributionLineSave(I_DD_NetworkDistributionLineInput Entity, DataFetchingEnvironment environment) {
		return (X_DD_NetworkDistributionLine) super.save((X_DD_NetworkDistributionLineInput) Entity, environment);
	}

	public List<X_DD_NetworkDistributionLine> DD_NetworkDistributionLineSaveMany(List<I_DD_NetworkDistributionLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_DD_NetworkDistributionLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_DD_NetworkDistributionLine) entity).collect(Collectors.toList());
	}

	public boolean DD_NetworkDistributionLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
