package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Package_Imp_BackupDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Package_Imp_Backup;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Package_Imp_Backup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Package_Imp_BackupQuery extends POQuery<X_AD_Package_Imp_Backup> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Package_Imp_Backup.Table_Name;
	}

	public CompletableFuture<X_AD_Package_Imp_Backup> AD_Package_Imp_Backup(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_Package_Imp_Backup> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Package_Imp_BackupDataLoader.DATALOADER_AD_Package_Imp_Backup_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_Package_Imp_Backup> AD_Package_Imp_BackupGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
