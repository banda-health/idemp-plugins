package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.base.model.MTree_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_MenuDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TreeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.compiere.model.X_AD_TreeBar;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_TreeBar - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TreeBarResolver extends POResolver<X_AD_TreeBar> implements GraphQLResolver<X_AD_TreeBar> {



	/**
	 * Get Menu.
	 *
	 * @return Identifies a Menu
	 */
	public CompletableFuture<MMenu_BH> AD_Menu(X_AD_TreeBar entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Menu_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMenu_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_MenuDataLoader.DATALOADER_AD_Menu_BY_ID);
		return dataLoader.load(entity.getAD_Menu_ID());
	}


	/**
	 * Get Tree.
	 *
	 * @return Identifies a Tree
	 */
	public CompletableFuture<MTree_BH> AD_Tree(X_AD_TreeBar entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(X_AD_TreeBar entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}

	public Boolean IsFavourite(X_AD_TreeBar entity, DataFetchingEnvironment environment) {
		return entity.isFavourite();
	}

}
