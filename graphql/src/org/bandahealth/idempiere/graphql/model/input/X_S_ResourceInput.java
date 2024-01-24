package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MResource;
import org.compiere.model.MResourceType;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for S_Resource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_S_ResourceInput extends MResource implements I_S_ResourceInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mM_Warehouse;
	private ForeignEntityInput mS_ResourceType;
	private I_AD_Ref_ListInput mManufacturingResourceType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_S_ResourceInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MResource(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
		} else {
			super.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public ForeignEntityInput AD_User() {
		return mAD_User;
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public void setM_WarehouseInput(ForeignEntityInput M_Warehouse) {
		this.mM_Warehouse = M_Warehouse;
		MWarehouse_BH foreignEntity;
		if (M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
						.setParameters(M_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Warehouse_ID(foreignEntity.get_ID());
		} else {
			super.setM_Warehouse_ID(0);
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public ForeignEntityInput M_Warehouse() {
		return mM_Warehouse;
	}

	/**
	 * Set Manufacturing Resource Type.
	 *
	 * @param ManufacturingResourceType Manufacturing Resource Type
	 */
	@JsonProperty("ManufacturingResourceType")
	public void setManufacturingResourceTypeInput(I_AD_Ref_ListInput ManufacturingResourceType) {
		this.mManufacturingResourceType = ManufacturingResourceType;
		MRefList_BH foreignEntity;
		if (ManufacturingResourceType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ManufacturingResourceType.getID())
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
	@JsonProperty("ManufacturingResourceType")
	public I_AD_Ref_ListInput ManufacturingResourceType() {
		return mManufacturingResourceType;
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
	@JsonProperty("S_ResourceType")
	public void setS_ResourceTypeInput(ForeignEntityInput S_ResourceType) {
		this.mS_ResourceType = S_ResourceType;
		MResourceType foreignEntity;
		if (S_ResourceType != null &&
				(foreignEntity = new Query(getCtx(), "S_ResourceType", "S_ResourceType_UU=?", get_TrxName())
						.setParameters(S_ResourceType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setS_ResourceType_ID(foreignEntity.get_ID());
		} else {
			super.setS_ResourceType_ID(0);
		}
	}

	/**
	 * Get Resource Type.
	 *
	 * @return Resource Type
	 */
	@JsonProperty("S_ResourceType")
	public ForeignEntityInput S_ResourceType() {
		return mS_ResourceType;
	}
}
