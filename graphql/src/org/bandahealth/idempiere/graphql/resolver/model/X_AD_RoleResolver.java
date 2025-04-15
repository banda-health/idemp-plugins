package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTree_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TreeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Role - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_RoleResolver extends POResolver<X_AD_Role> implements GraphQLResolver<X_AD_Role> {



	/**
	 * Get Menu Tree.
	 *
	 * @return Tree of the menu
	 */
	public CompletableFuture<MTree_BH> AD_Tree_Menu(X_AD_Role entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_Menu_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_Menu_ID());
	}


	/**
	 * Get Organization Tree.
	 *
	 * @return Trees are used for (financial) reporting and security access (via role)
	 */
	public CompletableFuture<MTree_BH> AD_Tree_Org(X_AD_Role entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_Org_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_Org_ID());
	}

	public Boolean Allow_Info_Account(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isAllow_Info_Account();
	}

	public Boolean Allow_Info_Asset(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isAllow_Info_Asset();
	}

	public Boolean Allow_Info_BPartner(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isAllow_Info_BPartner();
	}

	public Boolean Allow_Info_InOut(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isAllow_Info_InOut();
	}

	public Boolean Allow_Info_Invoice(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isAllow_Info_Invoice();
	}

	public Boolean Allow_Info_Order(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isAllow_Info_Order();
	}

	public Boolean Allow_Info_Payment(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isAllow_Info_Payment();
	}

	public Boolean Allow_Info_Product(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isAllow_Info_Product();
	}

	public Boolean Allow_Info_Resource(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isAllow_Info_Resource();
	}

	public Boolean Allow_Info_Schedule(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isAllow_Info_Schedule();
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(X_AD_Role entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}

	public Boolean IsAccessAdvanced(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isAccessAdvanced();
	}

	public Boolean IsAccessAllOrgs(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isAccessAllOrgs();
	}

	public Boolean IsCanApproveOwnDoc(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isCanApproveOwnDoc();
	}

	public Boolean IsCanExport(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isCanExport();
	}

	public Boolean IsCanReport(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isCanReport();
	}

	public Boolean IsChangeLog(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isChangeLog();
	}

	public Boolean IsClientAdministrator(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isClientAdministrator();
	}

	public Boolean IsDiscountAllowedOnTotal(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isDiscountAllowedOnTotal();
	}

	public Boolean IsDiscountUptoLimitPrice(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isDiscountUptoLimitPrice();
	}

	public Boolean IsManual(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isManual();
	}

	public Boolean IsMasterRole(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isMasterRole();
	}

	public Boolean IsMenuAutoExpand(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isMenuAutoExpand();
	}

	public Boolean IsPersonalAccess(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isPersonalAccess();
	}

	public Boolean IsPersonalLock(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isPersonalLock();
	}

	public Boolean IsShowAcct(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isShowAcct();
	}

	public Boolean IsUseUserOrgAccess(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isUseUserOrgAccess();
	}

	public Boolean OverwritePriceLimit(X_AD_Role entity, DataFetchingEnvironment environment) {
		return entity.isOverwritePriceLimit();
	}

	public static Map<String, String> PREFERENCETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "83843d71-2a13-4c6f-912f-dd92b1faeaa5"); // Client
			put("O", "925937f5-882b-459e-a044-6156cd642415"); // Organization
			put("U", "1e3cec47-4ddd-4543-b9de-0b52125f464b"); // User
			put("N", "7b6855b5-554c-4350-a4c1-605523bc56e1"); // None
		}
	};
	public CompletableFuture<MRefList_BH> PreferenceType(X_AD_Role entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPreferenceType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PREFERENCETYPE_UUIDS_BY_VALUE.get(entity.getPreferenceType()));
	}

	public static Map<String, String> ROLETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("ZK", "af5be523-6318-4b6c-bc8b-f51ecd0de2d0"); // WebUI
			put("WS", "ff7ae569-ea86-4c21-9aff-6a9073f4b677"); // WebService
			put("SS", "3b6ad66c-e962-46a5-a3ec-b8787ee4c754"); // System Support
			put("MO", "78962d5b-b6bb-4798-8f9d-fd36381b58ed"); // Mobile
			put("SW", "b6d02ebf-6845-47d9-b91e-b956084333e8"); // Swing
			put("E1", "d6bc8c6d-d5bf-458c-81f7-4d3f11303d6d"); // External App 1
			put("E2", "79a2e44a-dfd6-4114-b835-5392c4736eb9"); // External App 2
			put("E3", "f158da0d-6ad6-4f2e-aa65-099417d6217b"); // External App 3
			put("E4", "d136b0f9-658a-4e79-b22f-3cf995da34ff"); // External App 4
			put("E5", "b06729fb-ce8e-4bff-b6da-0f38bdefa55e"); // External App 5
		}
	};
	public CompletableFuture<MRefList_BH> RoleType(X_AD_Role entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getRoleType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ROLETYPE_UUIDS_BY_VALUE.get(entity.getRoleType()));
	}


	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	public CompletableFuture<MUser_BH> Supervisor(X_AD_Role entity, DataFetchingEnvironment environment) {
		if (entity.getSupervisor_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSupervisor_ID());
	}

	public static Map<String, String> USERLEVEL_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S  ", "e8d54adf-89fa-43f6-90aa-32f3d57c1bfc"); // System
			put(" C ", "1c9b74bd-a284-4c2b-9ad1-826e53c01bae"); // Client
			put("  O", "23b5d43e-7691-4a8f-b9ee-969cca173609"); // Organization
			put(" CO", "ac273750-1ebd-4bf1-9637-b693fa7a5794"); // Client+Organization
		}
	};
	public CompletableFuture<MRefList_BH> UserLevel(X_AD_Role entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getUserLevel())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(USERLEVEL_UUIDS_BY_VALUE.get(entity.getUserLevel()));
	}

}
