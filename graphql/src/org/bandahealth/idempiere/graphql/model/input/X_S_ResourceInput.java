package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_S_ResourceResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MResource;
import org.compiere.model.MResourceType;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for S_Resource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_S_ResourceInput extends MResource implements I_S_ResourceInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mM_Warehouse;
	private ForeignEntityInput mManufacturingResourceType;
	private ForeignEntityInput mS_ResourceType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The S_Resource_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_S_ResourceInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (!is_new()) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + AD_User.getUU());
			}
		} else {
			this.setAD_User_ID(0);
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
		if (M_Warehouse != null) {
			// Since an entity was passed, make sure it's in the DB
			MWarehouse_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
							.setParameters(M_Warehouse.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Warehouse_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Warehouse with UU " + M_Warehouse.getUU());
			}
		} else {
			this.setM_Warehouse_ID(0);
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
	public void setManufacturingResourceTypeInput(ForeignEntityInput ManufacturingResourceType) {
		this.mManufacturingResourceType = ManufacturingResourceType;
		if (ManufacturingResourceType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_S_ResourceResolver.MANUFACTURINGRESOURCETYPE_UUIDS_BY_VALUE.containsValue(ManufacturingResourceType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ManufacturingResourceType.getUU() +
						" is not in the list defined for the ManufacturingResourceType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ManufacturingResourceType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setManufacturingResourceType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ManufacturingResourceType.getUU());
			}
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
	public ForeignEntityInput ManufacturingResourceType() {
		return mManufacturingResourceType;
	}
	/**
	 * Set Resource.
	 *
	 * @param S_Resource_ID Resource
	 */
	@JsonProperty("S_Resource_ID")
	public void setS_Resource_IDFromJson(int S_Resource_ID) {
		if (get_ID() == 0) {
			super.setS_Resource_ID(S_Resource_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setS_Resource_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (S_ResourceType != null) {
			// Since an entity was passed, make sure it's in the DB
			MResourceType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "S_ResourceType", "S_ResourceType_UU=?", get_TrxName())
							.setParameters(S_ResourceType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setS_ResourceType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table S_ResourceType with UU " + S_ResourceType.getUU());
			}
		} else {
			this.setS_ResourceType_ID(0);
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
