package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_DD_OrderLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_DD_OrderLineInput;
import org.eevolution.model.MDDOrderLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for DD_OrderLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_DD_OrderLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_DD_OrderLineInput.Table_Name;
	}

	public MDDOrderLine DD_OrderLineSave(I_DD_OrderLineInput Entity, DataFetchingEnvironment environment) {
		return (MDDOrderLine) super.save((X_DD_OrderLineInput) Entity, environment);
	}

	public List<MDDOrderLine> DD_OrderLineSaveMany(List<I_DD_OrderLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_DD_OrderLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDDOrderLine) entity).collect(Collectors.toList());
	}

	public boolean DD_OrderLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
