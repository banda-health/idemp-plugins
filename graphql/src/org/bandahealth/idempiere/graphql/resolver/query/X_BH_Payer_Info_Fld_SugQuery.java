package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldSug;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payer_Info_Fld_SugDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Payer_Info_Fld_Sug - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_Payer_Info_Fld_SugQuery extends POQuery<MBHPayerInfoFldSug> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHPayerInfoFldSug.Table_Name;
	}

	public CompletableFuture<MBHPayerInfoFldSug> BH_Payer_Info_Fld_Sug(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHPayerInfoFldSug> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Payer_Info_Fld_SugDataLoader.DATALOADER_BH_Payer_Info_Fld_Sug_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHPayerInfoFldSug> BH_Payer_Info_Fld_SugGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
