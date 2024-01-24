package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_Order_NodeInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_Order_NodeInput;
import org.eevolution.model.X_PP_Order_Node;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PP_Order_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_NodeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order_NodeInput.Table_Name;
	}

	public X_PP_Order_Node PP_Order_NodeSave(I_PP_Order_NodeInput entity, DataFetchingEnvironment environment) {
		return (X_PP_Order_Node) super.save((X_PP_Order_NodeInput) entity, environment);
	}

	public List<X_PP_Order_Node> PP_Order_NodeSaveMany(List<I_PP_Order_NodeInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_PP_Order_NodeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_PP_Order_Node) entity).collect(Collectors.toList());
	}

	public boolean PP_Order_NodeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
