package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_GreetingDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_JobDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_MailTextDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCampaign;
import org.compiere.model.MImage;
import org.compiere.model.MLocation;
import org.compiere.model.MMailText;
import org.compiere.model.X_C_Greeting;
import org.compiere.model.X_C_Job;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_User - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_UserResolver extends POResolver<MUser_BH> implements GraphQLResolver<MUser_BH> {



	/**
	 * Get Image.
	 *
	 * @return Image or Icon
	 */
	public CompletableFuture<MImage> AD_Image(MUser_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Image_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MImage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ImageDataLoader.DATALOADER_AD_Image_BY_ID);
		return dataLoader.load(entity.getAD_Image_ID());
	}

	public Boolean BH_HasAcceptedTermsOfUse(MUser_BH entity, DataFetchingEnvironment environment) {
		return entity.isBH_HasAcceptedTermsOfUse();
	}


	/**
	 * Get BP Address.
	 *
	 * @return Address of the Business Partner
	 */
	public CompletableFuture<MLocation> BP_Location(MUser_BH entity, DataFetchingEnvironment environment) {
		if (entity.getBP_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_ID);
		return dataLoader.load(entity.getBP_Location_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MUser_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(MUser_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getC_BPartner_Location_ID());
	}


	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public CompletableFuture<MCampaign> C_Campaign(MUser_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.DATALOADER_C_Campaign_BY_ID);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Greeting.
	 *
	 * @return Greeting to print on correspondence
	 */
	public CompletableFuture<X_C_Greeting> C_Greeting(MUser_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Greeting_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_Greeting> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_GreetingDataLoader.DATALOADER_C_Greeting_BY_ID);
		return dataLoader.load(entity.getC_Greeting_ID());
	}


	/**
	 * Get Position.
	 *
	 * @return Job Position
	 */
	public CompletableFuture<X_C_Job> C_Job(MUser_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Job_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_Job> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_JobDataLoader.DATALOADER_C_Job_BY_ID);
		return dataLoader.load(entity.getC_Job_ID());
	}


	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public CompletableFuture<MLocation> C_Location(MUser_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_ID);
		return dataLoader.load(entity.getC_Location_ID());
	}

	public Boolean IsAddMailTextAutomatically(MUser_BH entity, DataFetchingEnvironment environment) {
		return entity.isAddMailTextAutomatically();
	}

	public Boolean IsExpired(MUser_BH entity, DataFetchingEnvironment environment) {
		return entity.isExpired();
	}

	public Boolean IsFullBPAccess(MUser_BH entity, DataFetchingEnvironment environment) {
		return entity.isFullBPAccess();
	}

	public Boolean IsInPayroll(MUser_BH entity, DataFetchingEnvironment environment) {
		return entity.isInPayroll();
	}

	public Boolean IsLocked(MUser_BH entity, DataFetchingEnvironment environment) {
		return entity.isLocked();
	}

	static Map<String, String> ISMENUAUTOEXPAND_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5");
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db");
		}
	};
	public CompletableFuture<MRefList_BH> IsMenuAutoExpand(MUser_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsMenuAutoExpand())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(ISMENUAUTOEXPAND_UUIDS_BY_VALUE.get(entity.getIsMenuAutoExpand()));
	}

	public Boolean IsNoExpire(MUser_BH entity, DataFetchingEnvironment environment) {
		return entity.isNoExpire();
	}

	public Boolean IsNoPasswordReset(MUser_BH entity, DataFetchingEnvironment environment) {
		return entity.isNoPasswordReset();
	}

	public Boolean IsSalesLead(MUser_BH entity, DataFetchingEnvironment environment) {
		return entity.isSalesLead();
	}

	public Boolean IsSupportUser(MUser_BH entity, DataFetchingEnvironment environment) {
		return entity.isSupportUser();
	}

	static Map<String, String> LEADSOURCE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("CC", "b5d3961b-0c9a-4f54-adda-8b5d2f99f5a5");
			put("EC", "770aeea9-0580-491e-8047-ccb10d5f1551");
			put("EM", "096bfbc5-011d-436e-b5c3-649bc4061d78");
			put("PT", "1329c248-b567-41d2-a48b-290b1edf8e2f");
			put("CN", "80579a39-d728-4f29-b490-9212d19e2193");
			put("TS", "86e0594b-436a-4adc-99d5-3d0149975cc9");
			put("WS", "24401e99-2c0d-4a5d-a7f6-cfabb92a15bf");
			put("WM", "21dc34d8-87af-40c5-88df-941e6c3c08dd");
			put("EL", "ff1640ae-b5ab-4278-96b7-75ec3f5df3b9");
		}
	};
	public CompletableFuture<MRefList_BH> LeadSource(MUser_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getLeadSource())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(LEADSOURCE_UUIDS_BY_VALUE.get(entity.getLeadSource()));
	}

	static Map<String, String> LEADSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("N", "8a664fb3-96ef-4b5b-879b-c32d340b4ca4");
			put("W", "bb1547ea-5e2f-4886-bcd3-1c2f0ffb19f0");
			put("E", "844fc440-4d79-4151-92c3-f4cd457be6dd");
			put("R", "7eee557a-482b-4520-ac84-ccab00c258ed");
			put("C", "bda2ba73-4d25-4964-861c-cb3c36d44ae2");
		}
	};
	public CompletableFuture<MRefList_BH> LeadStatus(MUser_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getLeadStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(LEADSTATUS_UUIDS_BY_VALUE.get(entity.getLeadStatus()));
	}

	static Map<String, String> NOTIFICATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("E", "e1ca3bcf-d8cb-451f-acd4-0a6773257650");
			put("N", "a85de9af-6e78-48e5-ae43-4f07734c2df3");
			put("X", "ca78475e-7191-402b-9d15-7244e87620f1");
			put("B", "aae5e850-38ca-4b15-9c9d-bee6402e7427");
		}
	};
	public CompletableFuture<MRefList_BH> NotificationType(MUser_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getNotificationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(NOTIFICATIONTYPE_UUIDS_BY_VALUE.get(entity.getNotificationType()));
	}

	public Boolean Processing(MUser_BH entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get Default mail template.
	 *
	 * @return Default mail template
	 */
	public CompletableFuture<MMailText> R_DefaultMailText(MUser_BH entity, DataFetchingEnvironment environment) {
		if (entity.getR_DefaultMailText_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMailText> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_MailTextDataLoader.DATALOADER_R_MailText_BY_ID);
		return dataLoader.load(entity.getR_DefaultMailText_ID());
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(MUser_BH entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSalesRep_ID());
	}


	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	public CompletableFuture<MUser_BH> Supervisor(MUser_BH entity, DataFetchingEnvironment environment) {
		if (entity.getSupervisor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSupervisor_ID());
	}

}
