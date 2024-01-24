package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductPriceVendorBreakInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ProductPriceVendorBreakInput;
import org.compiere.model.X_M_ProductPriceVendorBreak;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_ProductPriceVendorBreak - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductPriceVendorBreakMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ProductPriceVendorBreakInput.Table_Name;
	}

	public X_M_ProductPriceVendorBreak M_ProductPriceVendorBreakSave(I_M_ProductPriceVendorBreakInput entity, DataFetchingEnvironment environment) {
		return (X_M_ProductPriceVendorBreak) super.save((X_M_ProductPriceVendorBreakInput) entity, environment);
	}

	public List<X_M_ProductPriceVendorBreak> M_ProductPriceVendorBreakSaveMany(List<I_M_ProductPriceVendorBreakInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_ProductPriceVendorBreakInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_ProductPriceVendorBreak) entity).collect(Collectors.toList());
	}

	public boolean M_ProductPriceVendorBreakDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
