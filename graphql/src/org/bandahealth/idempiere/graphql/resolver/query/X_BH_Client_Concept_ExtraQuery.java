package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Client_Concept_ExtraDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Client_Concept_Extra - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Client_Concept_ExtraQuery extends POQuery<MBHClientConceptExtra> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHClientConceptExtra.Table_Name;
	}

	public CompletableFuture<MBHClientConceptExtra> BH_Client_Concept_Extra(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHClientConceptExtra> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Client_Concept_ExtraDataLoader.DATALOADER_BH_Client_Concept_Extra_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHClientConceptExtra> BH_Client_Concept_ExtraGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
