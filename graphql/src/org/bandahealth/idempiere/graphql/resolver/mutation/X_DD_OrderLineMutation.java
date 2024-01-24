package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_DD_OrderLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_DD_OrderLineInput;
import org.eevolution.model.MDDOrderLine;

import java.util.List;

/**
 * Generated Query Resolver for DD_OrderLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_DD_OrderLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_DD_OrderLineInput.Table_Name;
	}

	public MDDOrderLine DD_OrderLineSave(I_DD_OrderLineInput input, DataFetchingEnvironment environment) {
		return (MDDOrderLine) super.save((X_DD_OrderLineInput) input, environment);
	}

	public boolean DD_OrderLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
