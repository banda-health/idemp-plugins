package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MInfoColumn;
import org.compiere.model.MInfoWindow;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_InfoRelated;

import java.sql.ResultSet;

/**
 * Generated Model for AD_InfoRelated - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_InfoRelatedInput extends X_AD_InfoRelated implements I_AD_InfoRelatedInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_InfoWindow;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mParentRelatedColumn;
	private ForeignEntityInput mRelatedColumn;
	private ForeignEntityInput mRelatedInfo;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_InfoRelatedInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_InfoRelated(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}
	/**
	 * Set InfoRelated.
	 *
	 * @param AD_InfoRelated_ID InfoRelated
	 */

	public void setAD_InfoRelated_ID(int AD_InfoRelated_ID) {
		if (get_ID() == 0) {
			super.setAD_InfoRelated_ID(AD_InfoRelated_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_InfoRelated_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_InfoRelated_UU();
	}

	/**
	 * Set Info Window.
	 *
	 * @param AD_InfoWindow Info and search/select Window
	 */
	@JsonProperty("AD_InfoWindow")
	public void setAD_InfoWindowInput(ForeignEntityInput AD_InfoWindow) {
		this.mAD_InfoWindow = AD_InfoWindow;
		MInfoWindow foreignEntity;
		if (AD_InfoWindow != null &&
				(foreignEntity = new Query(getCtx(), "AD_InfoWindow", "AD_InfoWindow_UU=?", get_TrxName())
						.setParameters(AD_InfoWindow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_InfoWindow_ID(foreignEntity.get_ID());
		} else {
			super.setAD_InfoWindow_ID(0);
		}
	}

	/**
	 * Get Info Window.
	 *
	 * @return Info and search/select Window
	 */
	@JsonProperty("AD_InfoWindow")
	public ForeignEntityInput AD_InfoWindow() {
		return mAD_InfoWindow;
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

	/**
	 * Set Parent Related Column.
	 *
	 * @param ParentRelatedColumn column in parent info window, link with column in this relate info
	 */
	@JsonProperty("ParentRelatedColumn")
	public void setParentRelatedColumnInput(ForeignEntityInput ParentRelatedColumn) {
		this.mParentRelatedColumn = ParentRelatedColumn;
		MInfoColumn foreignEntity;
		if (ParentRelatedColumn != null &&
				(foreignEntity = new Query(getCtx(), "AD_InfoColumn", "AD_InfoColumn_UU=?", get_TrxName())
						.setParameters(ParentRelatedColumn.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setParentRelatedColumn_ID(foreignEntity.get_ID());
		} else {
			super.setParentRelatedColumn_ID(0);
		}
	}

	/**
	 * Get Parent Related Column.
	 *
	 * @return column in parent info window, link with column in this relate info
	 */
	@JsonProperty("ParentRelatedColumn")
	public ForeignEntityInput ParentRelatedColumn() {
		return mParentRelatedColumn;
	}

	/**
	 * Set Related Info Column.
	 *
	 * @param RelatedColumn Related Info Column
	 */
	@JsonProperty("RelatedColumn")
	public void setRelatedColumnInput(ForeignEntityInput RelatedColumn) {
		this.mRelatedColumn = RelatedColumn;
		MInfoColumn foreignEntity;
		if (RelatedColumn != null &&
				(foreignEntity = new Query(getCtx(), "AD_InfoColumn", "AD_InfoColumn_UU=?", get_TrxName())
						.setParameters(RelatedColumn.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setRelatedColumn_ID(foreignEntity.get_ID());
		} else {
			super.setRelatedColumn_ID(0);
		}
	}

	/**
	 * Get Related Info Column.
	 *
	 * @return Related Info Column
	 */
	@JsonProperty("RelatedColumn")
	public ForeignEntityInput RelatedColumn() {
		return mRelatedColumn;
	}

	/**
	 * Set Related Info Window.
	 *
	 * @param RelatedInfo Related Info Window
	 */
	@JsonProperty("RelatedInfo")
	public void setRelatedInfoInput(ForeignEntityInput RelatedInfo) {
		this.mRelatedInfo = RelatedInfo;
		MInfoWindow foreignEntity;
		if (RelatedInfo != null &&
				(foreignEntity = new Query(getCtx(), "AD_InfoWindow", "AD_InfoWindow_UU=?", get_TrxName())
						.setParameters(RelatedInfo.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setRelatedInfo_ID(foreignEntity.get_ID());
		} else {
			super.setRelatedInfo_ID(0);
		}
	}

	/**
	 * Get Related Info Window.
	 *
	 * @return Related Info Window
	 */
	@JsonProperty("RelatedInfo")
	public ForeignEntityInput RelatedInfo() {
		return mRelatedInfo;
	}
}
