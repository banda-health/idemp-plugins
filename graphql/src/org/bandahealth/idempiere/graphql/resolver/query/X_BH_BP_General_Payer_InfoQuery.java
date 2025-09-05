package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHBPGeneralPayerInfo;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_BP_General_Payer_InfoDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_BP_General_Payer_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_BP_General_Payer_InfoQuery extends POQuery<MBHBPGeneralPayerInfo> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHBPGeneralPayerInfo.Table_Name;
	}

	public CompletableFuture<MBHBPGeneralPayerInfo> BH_BP_General_Payer_Info(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHBPGeneralPayerInfo> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_BP_General_Payer_InfoDataLoader.DATALOADER_BH_BP_General_Payer_Info_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHBPGeneralPayerInfo> BH_BP_General_Payer_InfoGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
