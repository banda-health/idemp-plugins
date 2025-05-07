package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_U_WebMenuDataLoader;
import org.compiere.model.X_U_WebMenu;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for U_WebMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_U_WebMenuResolver extends POResolver<X_U_WebMenu> implements GraphQLResolver<X_U_WebMenu> {


	public Boolean HasSubMenu(X_U_WebMenu entity, DataFetchingEnvironment environment) {
		return entity.isHasSubMenu();
	}


	/**
	 * Get Parent Menu.
	 *
	 * @return Parent Menu
	 */
	public CompletableFuture<X_U_WebMenu> ParentMenu(X_U_WebMenu entity, DataFetchingEnvironment environment) {
		if (entity.getParentMenu_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_U_WebMenu> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_U_WebMenuDataLoader.DATALOADER_U_WebMenu_BY_ID);
		return dataLoader.load(entity.getParentMenu_ID());
	}

}
