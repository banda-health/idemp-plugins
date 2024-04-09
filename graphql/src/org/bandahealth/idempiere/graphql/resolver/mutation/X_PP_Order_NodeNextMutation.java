package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_Order_NodeNextInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_Order_NodeNextInput;
import org.eevolution.model.X_PP_Order_NodeNext;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PP_Order_NodeNext - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Order_NodeNextMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order_NodeNextInput.Table_Name;
	}

	public X_PP_Order_NodeNext PP_Order_NodeNextSave(I_PP_Order_NodeNextInput Entity, DataFetchingEnvironment environment) {
		return (X_PP_Order_NodeNext) super.save((X_PP_Order_NodeNextInput) Entity, environment);
	}

	public List<X_PP_Order_NodeNext> PP_Order_NodeNextSaveMany(List<I_PP_Order_NodeNextInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PP_Order_NodeNextInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_PP_Order_NodeNext) entity).collect(Collectors.toList());
	}

	public boolean PP_Order_NodeNextDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
