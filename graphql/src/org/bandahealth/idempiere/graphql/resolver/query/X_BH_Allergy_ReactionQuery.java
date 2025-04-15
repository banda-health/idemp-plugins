package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHAllergyReaction;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Allergy_ReactionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Allergy_Reaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_Allergy_ReactionQuery extends POQuery<MBHAllergyReaction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHAllergyReaction.Table_Name;
	}

	public CompletableFuture<MBHAllergyReaction> BH_Allergy_Reaction(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHAllergyReaction> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Allergy_ReactionDataLoader.DATALOADER_BH_Allergy_Reaction_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHAllergyReaction> BH_Allergy_ReactionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
