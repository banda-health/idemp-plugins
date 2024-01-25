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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_InfoRelated_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_InfoRelatedInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_AD_InfoRelated(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_InfoRelated_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
							.setParameters(AD_InfoWindow.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_InfoWindow_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_InfoWindow with UUID " + AD_InfoWindow.getUUID());
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
							.setParameters(AD_EntityType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
							.setParameters(ParentRelatedColumn.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setParentRelatedColumn_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_InfoColumn with UUID " + ParentRelatedColumn.getUUID());
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
							.setParameters(RelatedColumn.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setRelatedColumn_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_InfoColumn with UUID " + RelatedColumn.getUUID());
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
							.setParameters(RelatedInfo.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setRelatedInfo_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_InfoWindow with UUID " + RelatedInfo.getUUID());
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
