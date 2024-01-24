package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_U_WebMenuDataLoader;
import org.compiere.model.MWebMenu;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for U_WebMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_U_WebMenuResolver extends POResolver<MWebMenu> implements GraphQLResolver<MWebMenu> {


	public Boolean HasSubMenu(MWebMenu entity, DataFetchingEnvironment environment) {
		return entity.isHasSubMenu();
	}


	/**
	 * Get Parent Menu.
	 *
	 * @return Parent Menu
	 */
	public CompletableFuture<MWebMenu> ParentMenu(MWebMenu entity, DataFetchingEnvironment environment) {
		if (entity.getParentMenu_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWebMenu> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_U_WebMenuDataLoader.DATALOADER_U_WebMenu_BY_ID);
		return dataLoader.load(entity.getParentMenu_ID());
	}

}
