package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payer_Info_FldDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Payer_Info_Fld - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payer_Info_FldQuery extends POQuery<MBHPayerInfoFld> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHPayerInfoFld.Table_Name;
	}

	public CompletableFuture<MBHPayerInfoFld> BH_Payer_Info_Fld(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHPayerInfoFld> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Payer_Info_FldDataLoader.DATALOADER_BH_Payer_Info_Fld_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHPayerInfoFld> BH_Payer_Info_FldGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
