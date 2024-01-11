package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FormDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.compiere.model.MForm;
import org.compiere.model.MFormAccess;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Form_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Form_AccessResolver extends POResolver<MFormAccess> implements GraphQLResolver<MFormAccess> {



	/**
	 * Get Special Form.
	 *
	 * @return Special Form
	 */
	public CompletableFuture<MForm> AD_Form(MFormAccess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Form_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MForm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_FormDataLoader.AD_Form_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Form_ID());
	}


	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(MFormAccess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.AD_Role_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Role_ID());
	}

	public Boolean IsReadWrite(MFormAccess entity, DataFetchingEnvironment environment) {
		return entity.isReadWrite();
	}

}
