package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_Order_BOMLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_Order_BOMLineInput;
import org.eevolution.model.X_PP_Order_BOMLine;

import java.util.List;

/**
 * Generated Query Resolver for PP_Order_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PP_Order_BOMLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order_BOMLineInput.Table_Name;
	}

	public X_PP_Order_BOMLine PP_Order_BOMLineSave(I_PP_Order_BOMLineInput input, DataFetchingEnvironment environment) {
		return (X_PP_Order_BOMLine) super.save((X_PP_Order_BOMLineInput) input, environment);
	}

	public boolean PP_Order_BOMLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
