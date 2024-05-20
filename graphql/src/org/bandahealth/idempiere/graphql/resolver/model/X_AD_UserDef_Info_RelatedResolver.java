package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_InfoRelatedDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDef_InfoDataLoader;
import org.compiere.model.MUserDefInfo;
import org.compiere.model.MUserDefInfoRelated;
import org.compiere.model.X_AD_InfoRelated;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_UserDef_Info_Related - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserDef_Info_RelatedResolver extends POResolver<MUserDefInfoRelated> implements GraphQLResolver<MUserDefInfoRelated> {



	/**
	 * Get Info Related.
	 *
	 * @return Info Related
	 */
	public CompletableFuture<X_AD_InfoRelated> AD_InfoRelated(MUserDefInfoRelated entity, DataFetchingEnvironment environment) {
		if (entity.getAD_InfoRelated_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_AD_InfoRelated> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_InfoRelatedDataLoader.DATALOADER_AD_InfoRelated_BY_ID);
		return dataLoader.load(entity.getAD_InfoRelated_ID());
	}


	/**
	 * Get User defined Info Window.
	 *
	 * @return User defined Info Window
	 */
	public CompletableFuture<MUserDefInfo> AD_UserDef_Info(MUserDefInfoRelated entity, DataFetchingEnvironment environment) {
		if (entity.getAD_UserDef_Info_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUserDefInfo> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDef_InfoDataLoader.DATALOADER_AD_UserDef_Info_BY_ID);
		return dataLoader.load(entity.getAD_UserDef_Info_ID());
	}

}
