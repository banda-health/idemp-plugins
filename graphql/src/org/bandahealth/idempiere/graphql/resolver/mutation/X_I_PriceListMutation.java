package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_PriceListInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_PriceListInput;
import org.compiere.model.X_I_PriceList;

import java.util.List;

/**
 * Generated Query Resolver for I_PriceList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_I_PriceListMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_PriceListInput.Table_Name;
	}

	public X_I_PriceList I_PriceListSave(I_I_PriceListInput input, DataFetchingEnvironment environment) {
		return (X_I_PriceList) super.save((X_I_PriceListInput) input, environment);
	}

	public boolean I_PriceListDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
