package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PrintFormatItemInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PrintFormatItemInput;
import org.compiere.model.X_AD_PrintFormatItem;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_PrintFormatItem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PrintFormatItemMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintFormatItemInput.Table_Name;
	}

	public X_AD_PrintFormatItem AD_PrintFormatItemSave(I_AD_PrintFormatItemInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_PrintFormatItem) super.save((X_AD_PrintFormatItemInput) Entity, environment);
	}

	public List<X_AD_PrintFormatItem> AD_PrintFormatItemSaveMany(List<I_AD_PrintFormatItemInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_PrintFormatItemInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_PrintFormatItem) entity).collect(Collectors.toList());
	}

	public boolean AD_PrintFormatItemDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
