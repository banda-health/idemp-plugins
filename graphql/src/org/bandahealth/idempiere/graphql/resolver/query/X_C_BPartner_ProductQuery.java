package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_ProductDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBPartnerProduct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_BPartner_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_BPartner_ProductQuery extends POQuery<MBPartnerProduct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBPartnerProduct.Table_Name;
	}

	public CompletableFuture<MBPartnerProduct> C_BPartner_Product(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBPartnerProduct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BPartner_ProductDataLoader.DATALOADER_C_BPartner_Product_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBPartnerProduct> C_BPartner_ProductGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
