package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHBPSpecificPayerInfo;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_BP_Specific_Payer_InfoDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_BP_Specific_Payer_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_BP_Specific_Payer_InfoQuery extends POQuery<MBHBPSpecificPayerInfo> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHBPSpecificPayerInfo.Table_Name;
	}

	public CompletableFuture<MBHBPSpecificPayerInfo> BH_BP_Specific_Payer_Info(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHBPSpecificPayerInfo> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_BP_Specific_Payer_InfoDataLoader.DATALOADER_BH_BP_Specific_Payer_Info_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHBPSpecificPayerInfo> BH_BP_Specific_Payer_InfoGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
