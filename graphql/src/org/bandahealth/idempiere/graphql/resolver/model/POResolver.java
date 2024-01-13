package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ClientDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_OrgDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.compiere.model.MOrg;
import org.compiere.model.PO;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * This class is meant to put the common fetchers that exist on every entity
 */
public class POResolver<T extends PO> {
	/**
	 * Return the client entity for this object leveraging the client data loader
	 *
	 * @param entity      The entity to fetch data for
	 * @param environment The GraphQL environment object
	 * @return A completable future of the client
	 */
	public CompletableFuture<MClient_BH> AD_Client(T entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MClient_BH> clientDataloader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ClientDataLoader.DATALOADER_AD_Client_BY_ID);
		return clientDataloader.load(entity.getAD_Client_ID());
	}

	/**
	 * By default, map UUIDs to the ID field
	 *
	 * @param entity The entity to fetch data for
	 * @return An external ID for consumers
	 */
	public String ID(T entity) {
		return (String) entity.get_Value(entity.getUUIDColumnName());
	}

	/**
	 * Return whether the entity is active or not
	 *
	 * @param entity The entity to fetch data for
	 * @return Whether the entity is active
	 */
	public Boolean IsActive(T entity) {
		return entity.isActive();
	}

	/**
	 * Return the organization entity for this object leveraging the organization data loader
	 *
	 * @param entity      The entity to fetch data for
	 * @param environment The GraphQL environment object
	 * @return A completable future of the organization
	 */
	public CompletableFuture<MOrg> AD_Org(T entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MOrg> organizationDataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_OrgDataLoader.DATALOADER_AD_Org_BY_ID);
		return organizationDataLoader.load(entity.getAD_Org_ID());
	}

	/**
	 * Return the user entity for this object of who created this entity, leveraging the user data loader
	 *
	 * @param entity      The entity to fetch data for
	 * @param environment The GraphQL environment object
	 * @return A completable future of the user who created the entity
	 */
	public CompletableFuture<MUser_BH> CreatedBy(T entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MUser_BH> userDataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return userDataLoader.load(entity.getCreatedBy());
	}

	/**
	 * Return the user entity for this object of who last updated this entity, leveraging the user data loader
	 *
	 * @param entity      The entity to fetch data for
	 * @param environment The GraphQL environment object
	 * @return A completable future of the user last updated the entity
	 */
	public CompletableFuture<MUser_BH> UpdatedBy(T entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MUser_BH> userDataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return userDataLoader.load(entity.getUpdatedBy());
	}
}
