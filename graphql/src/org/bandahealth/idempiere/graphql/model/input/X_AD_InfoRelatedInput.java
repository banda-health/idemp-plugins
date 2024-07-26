package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MInfoColumn;
import org.compiere.model.MInfoWindow;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_InfoRelated;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_InfoRelated - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_InfoRelatedInput extends X_AD_InfoRelated implements I_AD_InfoRelatedInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_InfoWindow;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mParentRelatedColumn;
	private ForeignEntityInput mRelatedColumn;
	private ForeignEntityInput mRelatedInfo;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_InfoRelated_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_InfoRelatedInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}
	/**
	 * Set Info Related.
	 *
	 * @param AD_InfoRelated_ID Info Related
	 */
	@JsonProperty("AD_InfoRelated_ID")
	public void setAD_InfoRelated_IDFromJson(int AD_InfoRelated_ID) {
		if (get_ID() == 0) {
			super.setAD_InfoRelated_ID(AD_InfoRelated_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_InfoRelated_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (AD_InfoWindow != null) {
			// Since an entity was passed, make sure it's in the DB
			MInfoWindow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_InfoWindow", "AD_InfoWindow_UU=?", get_TrxName())
							.setParameters(AD_InfoWindow.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_InfoWindow_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_InfoWindow with UU " + AD_InfoWindow.getUU());
			}
		} else {
			this.setAD_InfoWindow_ID(0);
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
	 * @param AD_Org Organizational entity within tenant
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
							.setParameters(AD_EntityType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setEntityType(foreignEntity.getEntityType());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UU " + AD_EntityType.getUU());
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

	/**
	 * Set Parent Related Column.
	 *
	 * @param ParentRelatedColumn column in parent info window, link with column in this relate info
	 */
	@JsonProperty("ParentRelatedColumn")
	public void setParentRelatedColumnInput(ForeignEntityInput ParentRelatedColumn) {
		this.mParentRelatedColumn = ParentRelatedColumn;
		if (ParentRelatedColumn != null) {
			// Since an entity was passed, make sure it's in the DB
			MInfoColumn foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_InfoColumn", "AD_InfoColumn_UU=?", get_TrxName())
							.setParameters(ParentRelatedColumn.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setParentRelatedColumn_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_InfoColumn with UU " + ParentRelatedColumn.getUU());
			}
		} else {
			this.setParentRelatedColumn_ID(0);
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
		if (RelatedColumn != null) {
			// Since an entity was passed, make sure it's in the DB
			MInfoColumn foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_InfoColumn", "AD_InfoColumn_UU=?", get_TrxName())
							.setParameters(RelatedColumn.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setRelatedColumn_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_InfoColumn with UU " + RelatedColumn.getUU());
			}
		} else {
			this.setRelatedColumn_ID(0);
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
		if (RelatedInfo != null) {
			// Since an entity was passed, make sure it's in the DB
			MInfoWindow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_InfoWindow", "AD_InfoWindow_UU=?", get_TrxName())
							.setParameters(RelatedInfo.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setRelatedInfo_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_InfoWindow with UU " + RelatedInfo.getUU());
			}
		} else {
			this.setRelatedInfo_ID(0);
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
