package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImportTemplateDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.compiere.model.MImportTemplate;
import org.compiere.model.X_AD_ImportTemplateAccess;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_ImportTemplateAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ImportTemplateAccessResolver extends POResolver<X_AD_ImportTemplateAccess> implements GraphQLResolver<X_AD_ImportTemplateAccess> {



	/**
	 * Get Import Template.
	 *
	 * @return Import Template
	 */
	public CompletableFuture<MImportTemplate> AD_ImportTemplate(X_AD_ImportTemplateAccess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_ImportTemplate_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MImportTemplate> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ImportTemplateDataLoader.DATALOADER_AD_ImportTemplate_BY_ID);
		return dataLoader.load(entity.getAD_ImportTemplate_ID());
	}


	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(X_AD_ImportTemplateAccess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getAD_Role_ID());
	}

	public Boolean IsAllowInsert(X_AD_ImportTemplateAccess entity, DataFetchingEnvironment environment) {
		return entity.isAllowInsert();
	}

	public Boolean IsAllowMerge(X_AD_ImportTemplateAccess entity, DataFetchingEnvironment environment) {
		return entity.isAllowMerge();
	}

	public Boolean IsAllowUpdate(X_AD_ImportTemplateAccess entity, DataFetchingEnvironment environment) {
		return entity.isAllowUpdate();
	}

}
