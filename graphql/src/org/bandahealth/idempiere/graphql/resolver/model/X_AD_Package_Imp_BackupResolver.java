package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Package_ImpDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Package_Imp_DetailDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.compiere.model.MColumn;
import org.compiere.model.MTable;
import org.compiere.model.X_AD_Package_Imp;
import org.compiere.model.X_AD_Package_Imp_Backup;
import org.compiere.model.X_AD_Package_Imp_Detail;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Package_Imp_Backup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Package_Imp_BackupResolver extends POResolver<X_AD_Package_Imp_Backup> implements GraphQLResolver<X_AD_Package_Imp_Backup> {



	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public CompletableFuture<MColumn> AD_Column(X_AD_Package_Imp_Backup entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Column_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.DATALOADER_AD_Column_BY_ID);
		return dataLoader.load(entity.getAD_Column_ID());
	}


	/**
	 * Get Imp. Package Detail.
	 *
	 * @return Imp. Package Detail
	 */
	public CompletableFuture<X_AD_Package_Imp_Detail> AD_Package_Imp_Detail(X_AD_Package_Imp_Backup entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Package_Imp_Detail_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Package_Imp_Detail> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Package_Imp_DetailDataLoader.DATALOADER_AD_Package_Imp_Detail_BY_ID);
		return dataLoader.load(entity.getAD_Package_Imp_Detail_ID());
	}


	/**
	 * Get Package Imp..
	 *
	 * @return Package Imp.
	 */
	public CompletableFuture<X_AD_Package_Imp> AD_Package_Imp(X_AD_Package_Imp_Backup entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Package_Imp_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Package_Imp> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Package_ImpDataLoader.DATALOADER_AD_Package_Imp_BY_ID);
		return dataLoader.load(entity.getAD_Package_Imp_ID());
	}


	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	public CompletableFuture<MReference_BH> AD_Reference(X_AD_Package_Imp_Backup entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(X_AD_Package_Imp_Backup entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}

	public Boolean Uninstall(X_AD_Package_Imp_Backup entity, DataFetchingEnvironment environment) {
		return entity.isUninstall();
	}

}
