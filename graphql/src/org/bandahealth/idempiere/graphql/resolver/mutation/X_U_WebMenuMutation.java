package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_U_WebMenuInput;
import org.bandahealth.idempiere.graphql.model.input.X_U_WebMenuInput;
import org.compiere.model.MWebMenu;

import java.util.List;

/**
 * Generated Query Resolver for U_WebMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_U_WebMenuMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_U_WebMenuInput.Table_Name;
	}

	public MWebMenu U_WebMenuSave(I_U_WebMenuInput input, DataFetchingEnvironment environment) {
		return (MWebMenu) super.save((X_U_WebMenuInput) input, environment);
	}

	public boolean U_WebMenuDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
