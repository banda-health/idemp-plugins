package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDef_Proc_ParameterDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserDefProcParameter;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_UserDef_Proc_Parameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_UserDef_Proc_ParameterQuery extends POQuery<MUserDefProcParameter> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserDefProcParameter.Table_Name;
	}

	public CompletableFuture<MUserDefProcParameter> AD_UserDef_Proc_Parameter(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MUserDefProcParameter> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_UserDef_Proc_ParameterDataLoader.DATALOADER_AD_UserDef_Proc_Parameter_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MUserDefProcParameter> AD_UserDef_Proc_ParameterGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
