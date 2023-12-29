package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FormDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintColorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFontDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WindowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.compiere.model.MDocumentStatus;
import org.compiere.model.MEntityType;
import org.compiere.model.MForm;
import org.compiere.model.MProject;
import org.compiere.model.MRole;
import org.compiere.model.MTable;
import org.compiere.model.MWindow;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_AD_PrintFont;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for PA_DocumentStatus - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_DocumentStatusResolver extends POResolver<MDocumentStatus> implements GraphQLResolver<MDocumentStatus> {



	/**
	 * Get Special Form.
	 *
	 * @return Special Form
	 */
	public CompletableFuture<MForm> AD_Form(MDocumentStatus entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MRole> AD_Role(MDocumentStatus entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRole> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.AD_Role_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Role_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MDocumentStatus entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.AD_Table_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MDocumentStatus entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public CompletableFuture<MWindow> AD_Window(MDocumentStatus entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Window_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WindowDataLoader.AD_Window_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Window_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MDocumentStatus entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.C_Project_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Project_ID());
	}


	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(MDocumentStatus entity, DataFetchingEnvironment environment) {
		if (entity.getEntityType() <= 0) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.AD_EntityType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getEntityType());
	}


	/**
	 * Get Print Color for Name.
	 *
	 * @return Print Color for Name
	 */
	public CompletableFuture<X_AD_PrintColor> Name_PrintColor(MDocumentStatus entity, DataFetchingEnvironment environment) {
		if (entity.getName_PrintColor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.AD_PrintColor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getName_PrintColor_ID());
	}


	/**
	 * Get Print Font for Name.
	 *
	 * @return Print Font for Name
	 */
	public CompletableFuture<X_AD_PrintFont> Name_PrintFont(MDocumentStatus entity, DataFetchingEnvironment environment) {
		if (entity.getName_PrintFont_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFont> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFontDataLoader.AD_PrintFont_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getName_PrintFont_ID());
	}


	/**
	 * Get Print Color for Number.
	 *
	 * @return Print Color for Number
	 */
	public CompletableFuture<X_AD_PrintColor> Number_PrintColor(MDocumentStatus entity, DataFetchingEnvironment environment) {
		if (entity.getNumber_PrintColor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.AD_PrintColor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getNumber_PrintColor_ID());
	}


	/**
	 * Get Print Font for Number.
	 *
	 * @return Print Font for Number
	 */
	public CompletableFuture<X_AD_PrintFont> Number_PrintFont(MDocumentStatus entity, DataFetchingEnvironment environment) {
		if (entity.getNumber_PrintFont_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFont> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFontDataLoader.AD_PrintFont_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getNumber_PrintFont_ID());
	}

}
