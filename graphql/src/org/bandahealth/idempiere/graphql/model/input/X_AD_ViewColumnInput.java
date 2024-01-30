package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MViewColumn;
import org.compiere.model.MViewComponent;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_ViewColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ViewColumnInput extends MViewColumn implements I_AD_ViewColumnInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_ViewComponent;
	private I_AD_Ref_ListInput mDBDataType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_ViewColumn_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ViewColumnInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
	 * Set Database View Column.
	 *
	 * @param AD_ViewColumn_ID Database View Column
	 */

	public void setAD_ViewColumn_ID(int AD_ViewColumn_ID) {
		if (get_ID() == 0) {
			super.setAD_ViewColumn_ID(AD_ViewColumn_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_ViewColumn_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_ViewColumn_UU();
	}

	/**
	 * Set Database View Component.
	 *
	 * @param AD_ViewComponent Database View Component
	 */
	@JsonProperty("AD_ViewComponent")
	public void setAD_ViewComponentInput(ForeignEntityInput AD_ViewComponent) {
		this.mAD_ViewComponent = AD_ViewComponent;
		if (get_ID() != 0) {
			return;
		}
		if (AD_ViewComponent != null) {
			// Since an entity was passed, make sure it's in the DB
			MViewComponent foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_ViewComponent", "AD_ViewComponent_UU=?", get_TrxName())
							.setParameters(AD_ViewComponent.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_ViewComponent_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_ViewComponent with UUID " + AD_ViewComponent.getUUID());
			}
		} else {
			this.setAD_ViewComponent_ID(0);
		}
	}

	/**
	 * Get Database View Component.
	 *
	 * @return Database View Component
	 */
	@JsonProperty("AD_ViewComponent")
	public ForeignEntityInput AD_ViewComponent() {
		return mAD_ViewComponent;
	}

	/**
	 * Set Database Data Type.
	 *
	 * @param DBDataType Database Data Type
	 */
	@JsonProperty("DBDataType")
	public void setDBDataTypeInput(I_AD_Ref_ListInput DBDataType) {
		this.mDBDataType = DBDataType;
		if (DBDataType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DBDataType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDBDataType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DBDataType.getUUID());
			}
		} else {
			this.setDBDataType(null);
		}
	}

	/**
	 * Get Database Data Type.
	 *
	 * @return Database Data Type
	 */
	@JsonProperty("DBDataType")
	public I_AD_Ref_ListInput DBDataType() {
		return mDBDataType;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		if (AD_EntityType != null) {
			// Since an entity was passed, make sure it's in the DB
			MEntityType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
							.setParameters(AD_EntityType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setEntityType(foreignEntity.getEntityType());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UUID " + AD_EntityType.getUUID());
			}
		} else {
			this.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public ForeignEntityInput AD_EntityType() {
		return mAD_EntityType;
	}
}
