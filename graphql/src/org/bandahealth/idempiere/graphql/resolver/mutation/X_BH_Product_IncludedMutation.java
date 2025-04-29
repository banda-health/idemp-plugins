package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHProductIncluded;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Product_IncludedInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Product_IncludedInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Product_Included - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Product_IncludedMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Product_IncludedInput.Table_Name;
	}

	public MBHProductIncluded BH_Product_IncludedSave(I_BH_Product_IncludedInput Entity, DataFetchingEnvironment environment) {
		return (MBHProductIncluded) super.save((X_BH_Product_IncludedInput) Entity, environment);
	}

	public List<MBHProductIncluded> BH_Product_IncludedSaveMany(List<I_BH_Product_IncludedInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Product_IncludedInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHProductIncluded) entity).collect(Collectors.toList());
	}

	public boolean BH_Product_IncludedDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
