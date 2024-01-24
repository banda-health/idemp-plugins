package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_MenuInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_MenuInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Menu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_MenuMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_MenuInput.Table_Name;
	}

	public MMenu_BH AD_MenuSave(I_AD_MenuInput entity, DataFetchingEnvironment environment) {
		return (MMenu_BH) super.save((X_AD_MenuInput) entity, environment);
	}

	public List<MMenu_BH> AD_MenuSaveMany(List<I_AD_MenuInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_MenuInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MMenu_BH) entity).collect(Collectors.toList());
	}

	public boolean AD_MenuDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
