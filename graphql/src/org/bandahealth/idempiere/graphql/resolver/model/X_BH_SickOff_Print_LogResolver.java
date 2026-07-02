package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHSickOff;
import org.bandahealth.idempiere.base.model.MBHSickOffPrintLog;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_SickOffDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_SickOff_Print_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_SickOff_Print_LogResolver extends POResolver<MBHSickOffPrintLog> implements GraphQLResolver<MBHSickOffPrintLog> {

	/**
	 * Get Sick Off.
	 *
	 * @return Sick Off
	 */
	public CompletableFuture<MBHSickOff> BH_SickOff(MBHSickOffPrintLog entity, DataFetchingEnvironment environment) {
		if (entity.getBH_SickOff_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHSickOff> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_SickOffDataLoader.DATALOADER_BH_SickOff_BY_ID);
		return dataLoader.load(entity.getBH_SickOff_ID());
	}

	/**
	 * Get Printed By.
	 *
	 * @return User who printed this record
	 */
	public CompletableFuture<MUser_BH> PrintedBy(MBHSickOffPrintLog entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MUser_BH> userDataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return userDataLoader.load(entity.getPrintedBy());
	}

}
