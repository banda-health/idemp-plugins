package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.graphql.model.input.I_C_OrderLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_OrderLineInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_OrderLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_OrderLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_OrderLineInput.Table_Name;
	}

	public MOrderLine_BH C_OrderLineSave(I_C_OrderLineInput Entity, DataFetchingEnvironment environment) {
		return (MOrderLine_BH) super.save((X_C_OrderLineInput) Entity, environment);
	}

	public List<MOrderLine_BH> C_OrderLineSaveMany(List<I_C_OrderLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_OrderLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MOrderLine_BH) entity).collect(Collectors.toList());
	}

	public boolean C_OrderLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
