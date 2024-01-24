package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MViewColumn;
import org.compiere.model.MViewComponent;
import org.compiere.model.Query;

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
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_ViewColumnInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MViewColumn(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_ViewColumn_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MViewComponent foreignEntity;
		if (get_ID() == 0 && AD_ViewComponent != null &&
				(foreignEntity = new Query(getCtx(), "AD_ViewComponent", "AD_ViewComponent_UU=?", get_TrxName())
						.setParameters(AD_ViewComponent.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_ViewComponent_ID(foreignEntity.get_ID());
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
		MRefList_BH foreignEntity;
		if (DBDataType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DBDataType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDBDataType(foreignEntity.getValue());
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
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setEntityType(foreignEntity.getEntityType());
		} else {
			super.setEntityType(null);
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
