package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImageDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MImage;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Image - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ImageQuery extends POQuery<MImage> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MImage.Table_Name;
	}

	public CompletableFuture<MImage> AD_Image(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MImage> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ImageDataLoader.DATALOADER_AD_Image_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MImage> AD_ImageGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
