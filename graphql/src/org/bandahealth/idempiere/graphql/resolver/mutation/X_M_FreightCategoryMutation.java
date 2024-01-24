package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_FreightCategoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_FreightCategoryInput;
import org.compiere.model.MFreightCategory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_FreightCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_FreightCategoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_FreightCategoryInput.Table_Name;
	}

	public MFreightCategory M_FreightCategorySave(I_M_FreightCategoryInput entity, DataFetchingEnvironment environment) {
		return (MFreightCategory) super.save((X_M_FreightCategoryInput) entity, environment);
	}

	public List<MFreightCategory> M_FreightCategorySaveMany(List<I_M_FreightCategoryInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_FreightCategoryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MFreightCategory) entity).collect(Collectors.toList());
	}

	public boolean M_FreightCategoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
