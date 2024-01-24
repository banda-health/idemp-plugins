package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PriceListInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PriceListInput;
import org.compiere.model.MPriceList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_PriceList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_PriceListMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PriceListInput.Table_Name;
	}

	public MPriceList M_PriceListSave(I_M_PriceListInput entity, DataFetchingEnvironment environment) {
		return (MPriceList) super.save((X_M_PriceListInput) entity, environment);
	}

	public List<MPriceList> M_PriceListSaveMany(List<I_M_PriceListInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_PriceListInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPriceList) entity).collect(Collectors.toList());
	}

	public boolean M_PriceListDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
