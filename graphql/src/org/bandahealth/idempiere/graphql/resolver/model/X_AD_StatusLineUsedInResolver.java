package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MTable_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_StatusLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TabDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WindowDataLoader;
import org.compiere.model.MStatusLine;
import org.compiere.model.MStatusLineUsedIn;
import org.compiere.model.MTab;
import org.compiere.model.MWindow;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_StatusLineUsedIn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_StatusLineUsedInResolver extends POResolver<MStatusLineUsedIn> implements GraphQLResolver<MStatusLineUsedIn> {



	/**
	 * Get Status Line.
	 *
	 * @return Status Line
	 */
	public CompletableFuture<MStatusLine> AD_StatusLine(MStatusLineUsedIn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_StatusLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MStatusLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_StatusLineDataLoader.DATALOADER_AD_StatusLine_BY_ID);
		return dataLoader.load(entity.getAD_StatusLine_ID());
	}


	/**
	 * Get Tab.
	 *
	 * @return Tab within a Window
	 */
	public CompletableFuture<MTab> AD_Tab(MStatusLineUsedIn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tab_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTab> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TabDataLoader.DATALOADER_AD_Tab_BY_ID);
		return dataLoader.load(entity.getAD_Tab_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable_BH> AD_Table(MStatusLineUsedIn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public CompletableFuture<MWindow> AD_Window(MStatusLineUsedIn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Window_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WindowDataLoader.DATALOADER_AD_Window_BY_ID);
		return dataLoader.load(entity.getAD_Window_ID());
	}

	public Boolean IsStatusLine(MStatusLineUsedIn entity, DataFetchingEnvironment environment) {
		return entity.isStatusLine();
	}

}
