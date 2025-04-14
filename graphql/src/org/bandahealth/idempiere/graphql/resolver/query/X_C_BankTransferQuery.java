package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankTransferDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBankTransfer;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_BankTransfer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_BankTransferQuery extends POQuery<MBankTransfer> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBankTransfer.Table_Name;
	}

	public CompletableFuture<MBankTransfer> C_BankTransfer(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBankTransfer> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BankTransferDataLoader.DATALOADER_C_BankTransfer_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBankTransfer> C_BankTransferGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
