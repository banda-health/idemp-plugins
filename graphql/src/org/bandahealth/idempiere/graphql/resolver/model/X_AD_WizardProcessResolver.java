package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_NodeDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.model.X_AD_WizardProcess;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_WizardProcess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_WizardProcessResolver extends POResolver<X_AD_WizardProcess> implements GraphQLResolver<X_AD_WizardProcess> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(X_AD_WizardProcess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	public CompletableFuture<X_AD_WF_Node> AD_WF_Node(X_AD_WizardProcess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Node_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Node> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_NodeDataLoader.DATALOADER_AD_WF_Node_BY_ID);
		return dataLoader.load(entity.getAD_WF_Node_ID());
	}

	public static Map<String, String> WIZARDSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("N", "dd3f4502-2914-44af-b66f-1620f64c50a3"); // New
			put("P", "00609fa8-5d40-4d42-ba37-b5919acdc782"); // Pending
			put("F", "9829c724-da26-4442-ba9d-2d93d6e7858f"); // Finished
			put("I", "c79db7f7-2646-483b-bb19-36164ffbabb9"); // In-Progress
			put("S", "a3d49831-ba26-4f4b-91f4-24f44b09b812"); // Skipped
			put("D", "4e09d396-3fa6-461d-9cca-b2aede0c6e2a"); // Delayed
		}
	};
	public CompletableFuture<MRefList_BH> WizardStatus(X_AD_WizardProcess entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getWizardStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(WIZARDSTATUS_UUIDS_BY_VALUE.get(entity.getWizardStatus()));
	}

}
