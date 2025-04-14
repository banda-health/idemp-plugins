package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_RecentItemInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_RecentItemInput;
import org.compiere.model.MRecentItem;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_RecentItem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_RecentItemMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_RecentItemInput.Table_Name;
	}

	public MRecentItem AD_RecentItemSave(I_AD_RecentItemInput Entity, DataFetchingEnvironment environment) {
		return (MRecentItem) super.save((X_AD_RecentItemInput) Entity, environment);
	}

	public List<MRecentItem> AD_RecentItemSaveMany(List<I_AD_RecentItemInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_RecentItemInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRecentItem) entity).collect(Collectors.toList());
	}

	public boolean AD_RecentItemDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
