package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_PriceListInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_PriceListInput;
import org.compiere.model.X_I_PriceList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for I_PriceList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_PriceListMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_PriceListInput.Table_Name;
	}

	public X_I_PriceList I_PriceListSave(I_I_PriceListInput Entity, DataFetchingEnvironment environment) {
		return (X_I_PriceList) super.save((X_I_PriceListInput) Entity, environment);
	}

	public List<X_I_PriceList> I_PriceListSaveMany(List<I_I_PriceListInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_I_PriceListInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_I_PriceList) entity).collect(Collectors.toList());
	}

	public boolean I_PriceListDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
