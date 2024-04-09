package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_U_WebMenuInput;
import org.bandahealth.idempiere.graphql.model.input.X_U_WebMenuInput;
import org.compiere.model.MWebMenu;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for U_WebMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_U_WebMenuMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_U_WebMenuInput.Table_Name;
	}

	public MWebMenu U_WebMenuSave(I_U_WebMenuInput Entity, DataFetchingEnvironment environment) {
		return (MWebMenu) super.save((X_U_WebMenuInput) Entity, environment);
	}

	public List<MWebMenu> U_WebMenuSaveMany(List<I_U_WebMenuInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_U_WebMenuInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MWebMenu) entity).collect(Collectors.toList());
	}

	public boolean U_WebMenuDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
