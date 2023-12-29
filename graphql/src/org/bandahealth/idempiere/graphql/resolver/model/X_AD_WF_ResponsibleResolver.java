package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MRefList;
import org.compiere.model.MRole;
import org.compiere.model.X_AD_WF_Responsible;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_WF_Responsible - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ResponsibleResolver extends POResolver<X_AD_WF_Responsible> implements GraphQLResolver<X_AD_WF_Responsible> {



	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<MRole> AD_Role(X_AD_WF_Responsible entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRole> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.AD_Role_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Role_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(X_AD_WF_Responsible entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(X_AD_WF_Responsible entity, DataFetchingEnvironment environment) {
		if (entity.getEntityType() <= 0) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.AD_EntityType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getEntityType());
	}

	static Map<String, String> RESPONSIBLETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_AD_WF_Responsible.RESPONSIBLETYPE_Organization, "283330be-8314-4c6b-ad2a-3b1bb3b7f8e2");
			put(X_AD_WF_Responsible.RESPONSIBLETYPE_Human, "03c43742-6077-4b9b-9c58-95b2705d70e0");
			put(X_AD_WF_Responsible.RESPONSIBLETYPE_Role, "b1adc7b9-4a2b-4760-bebf-912b01abfff7");
			put(X_AD_WF_Responsible.RESPONSIBLETYPE_SystemResource, "3fa9e107-a3d4-4103-94b5-b3c59c053dd7");
			put(X_AD_WF_Responsible.RESPONSIBLETYPE_Manual, "a9c99476-070e-4377-960d-19dbe7dff024");
		}
	};
	public CompletableFuture<MRefList> ResponsibleType_RL(X_AD_WF_Responsible entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getResponsibleType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(RESPONSIBLETYPE_UUIDS_BY_VALUE.get(entity.getResponsibleType()));
	}

}
