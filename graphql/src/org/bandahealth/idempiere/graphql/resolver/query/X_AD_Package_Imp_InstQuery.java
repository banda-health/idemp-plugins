package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Package_Imp_InstDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Package_Imp_Inst;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Package_Imp_Inst - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Package_Imp_InstQuery extends POQuery<X_AD_Package_Imp_Inst> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Package_Imp_Inst.Table_Name;
	}

	public CompletableFuture<X_AD_Package_Imp_Inst> AD_Package_Imp_Inst(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_Package_Imp_Inst> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Package_Imp_InstDataLoader.DATALOADER_AD_Package_Imp_Inst_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_Package_Imp_Inst> AD_Package_Imp_InstGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
