package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.MResourceType;
import org.compiere.model.Query;
import org.compiere.model.X_S_Resource;
import org.compiere.util.Env;

/**
 * Generated Model for S_Resource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_ResourceInput extends X_S_Resource implements I_S_ResourceInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput ManufacturingResourceType_RL;
	 private I_AD_UserInput AD_User;
	 private I_M_WarehouseInput M_Warehouse;
	 private I_S_ResourceTypeInput S_ResourceType;

	/**
	 * Standard constructor
	 */
	public X_S_ResourceInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	public void setAD_User(I_AD_UserInput AD_User) {
		this.AD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_User_ID(foreignEntity.get_ID());
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public I_AD_UserInput getAD_User() {
		return AD_User;
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	public void setM_Warehouse(I_M_WarehouseInput M_Warehouse) {
		this.M_Warehouse = M_Warehouse;
		MWarehouse_BH foreignEntity;
		if (M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), MWarehouse_BH.Table_Name, MWarehouse_BH.COLUMNNAME_M_Warehouse_UU + "=?", get_TrxName())
						.setParameters(M_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Warehouse_ID(foreignEntity.get_ID());
		} else {
			this.setM_Warehouse_ID(0);
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public I_M_WarehouseInput getM_Warehouse() {
		return M_Warehouse;
	}

	/**
	 * Set Manufacturing Resource Type.
	 *
	 * @param ManufacturingResourceType_RL Manufacturing Resource Type
	 */
	public void setManufacturingResourceType_RL(I_AD_Ref_ListInput ManufacturingResourceType_RL) {
		this.ManufacturingResourceType_RL = ManufacturingResourceType_RL;
		MRefList foreignEntity;
		if (ManufacturingResourceType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ManufacturingResourceType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setManufacturingResourceType(foreignEntity.getValue());
		} else {
			this.setManufacturingResourceType(null);
		}
	}

	/**
	 * Get Manufacturing Resource Type.
	 *
	 * @return Manufacturing Resource Type
	 */
	public I_AD_Ref_ListInput getManufacturingResourceType_RL() {
		return ManufacturingResourceType_RL;
	}
	/**
	 * Set Resource.
	 *
	 * @param S_Resource_ID Resource
	 */

	public void setS_Resource_ID(int S_Resource_ID) {
		if (get_ID() == 0) {
			super.setS_Resource_ID(S_Resource_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setS_Resource_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getS_Resource_UU();
	}

	/**
	 * Set Resource Type.
	 *
	 * @param S_ResourceType Resource Type
	 */
	public void setS_ResourceType(I_S_ResourceTypeInput S_ResourceType) {
		this.S_ResourceType = S_ResourceType;
		MResourceType foreignEntity;
		if (S_ResourceType != null &&
				(foreignEntity = new Query(getCtx(), MResourceType.Table_Name, MResourceType.COLUMNNAME_S_ResourceType_UU + "=?", get_TrxName())
						.setParameters(S_ResourceType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setS_ResourceType_ID(foreignEntity.get_ID());
		} else {
			this.setS_ResourceType_ID(0);
		}
	}

	/**
	 * Get Resource Type.
	 *
	 * @return Resource Type
	 */
	public I_S_ResourceTypeInput getS_ResourceType() {
		return S_ResourceType;
	}
}
