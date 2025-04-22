package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldValSug;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payer_Info_Fld_Val_SugDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Payer_Info_Fld_Val_Sug - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payer_Info_Fld_Val_SugQuery extends POQuery<MBHPayerInfoFldValSug> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHPayerInfoFldValSug.Table_Name;
	}

	public CompletableFuture<MBHPayerInfoFldValSug> BH_Payer_Info_Fld_Val_Sug(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHPayerInfoFldValSug> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Payer_Info_Fld_Val_SugDataLoader.DATALOADER_BH_Payer_Info_Fld_Val_Sug_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHPayerInfoFldValSug> BH_Payer_Info_Fld_Val_SugGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
