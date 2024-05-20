package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_U_WebMenuDataLoader;
import org.compiere.model.MRoleMenu;
import org.compiere.model.MWebMenu;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for U_RoleMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_U_RoleMenuResolver extends POResolver<MRoleMenu> implements GraphQLResolver<MRoleMenu> {



	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(MRoleMenu entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getAD_Role_ID());
	}


	/**
	 * Get Web Menu.
	 *
	 * @return Web Menu
	 */
	public CompletableFuture<MWebMenu> U_WebMenu(MRoleMenu entity, DataFetchingEnvironment environment) {
		if (entity.getU_WebMenu_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MWebMenu> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_U_WebMenuDataLoader.DATALOADER_U_WebMenu_BY_ID);
		return dataLoader.load(entity.getU_WebMenu_ID());
	}

}
