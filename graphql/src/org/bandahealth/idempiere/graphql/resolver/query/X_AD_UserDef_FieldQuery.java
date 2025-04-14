package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDef_FieldDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserDefField;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_UserDef_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_UserDef_FieldQuery extends POQuery<MUserDefField> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserDefField.Table_Name;
	}

	public CompletableFuture<MUserDefField> AD_UserDef_Field(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MUserDefField> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_UserDef_FieldDataLoader.DATALOADER_AD_UserDef_Field_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MUserDefField> AD_UserDef_FieldGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
