package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHAllergy;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_AllergyDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Allergy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_AllergyQuery extends POQuery<MBHAllergy> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHAllergy.Table_Name;
	}

	public CompletableFuture<MBHAllergy> BH_Allergy(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHAllergy> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_AllergyDataLoader.DATALOADER_BH_Allergy_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHAllergy> BH_AllergyGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
