package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldVal;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payer_Info_Fld_ValDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Payer_Info_Fld_Val - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Payer_Info_Fld_ValQuery extends POQuery<MBHPayerInfoFldVal> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHPayerInfoFldVal.Table_Name;
	}

	public CompletableFuture<MBHPayerInfoFldVal> BH_Payer_Info_Fld_Val(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHPayerInfoFldVal> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Payer_Info_Fld_ValDataLoader.DATALOADER_BH_Payer_Info_Fld_Val_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHPayerInfoFldVal> BH_Payer_Info_Fld_ValGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
