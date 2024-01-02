package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MRule;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_RuleInput extends MRule implements I_AD_RuleInput {

	 private I_AD_EntityTypeInput mAD_EntityType;
	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mAccessLevel;
	 private I_AD_Ref_ListInput mEventType;
	 private I_AD_Ref_ListInput mRuleType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_RuleInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Data Access Level.
	 *
	 * @param AccessLevel Access Level required
	 */
	@JsonProperty("AccessLevel")
	public void setAccessLevelInput(I_AD_Ref_ListInput AccessLevel) {
		this.mAccessLevel = AccessLevel;
		MRefList_BH foreignEntity;
		if (AccessLevel != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AccessLevel.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAccessLevel(foreignEntity.getValue());
		} else {
			this.setAccessLevel(null);
		}
	}

	/**
	 * Get Data Access Level.
	 *
	 * @return Access Level required
	 */
	@JsonProperty("AccessLevel")
	public I_AD_Ref_ListInput AccessLevel() {
		return mAccessLevel;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Rule_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Rule_UU();
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(I_AD_EntityTypeInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
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
	public I_AD_EntityTypeInput AD_EntityType() {
		return mAD_EntityType;
	}

	/**
	 * Set Event Type.
	 *
	 * @param EventType Type of Event
	 */
	@JsonProperty("EventType")
	public void setEventTypeInput(I_AD_Ref_ListInput EventType) {
		this.mEventType = EventType;
		MRefList_BH foreignEntity;
		if (EventType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(EventType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEventType(foreignEntity.getValue());
		} else {
			this.setEventType(null);
		}
	}

	/**
	 * Get Event Type.
	 *
	 * @return Type of Event
	 */
	@JsonProperty("EventType")
	public I_AD_Ref_ListInput EventType() {
		return mEventType;
	}

	/**
	 * Set Rule Type.
	 *
	 * @param RuleType Rule Type
	 */
	@JsonProperty("RuleType")
	public void setRuleTypeInput(I_AD_Ref_ListInput RuleType) {
		this.mRuleType = RuleType;
		MRefList_BH foreignEntity;
		if (RuleType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(RuleType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setRuleType(foreignEntity.getValue());
		} else {
			this.setRuleType(null);
		}
	}

	/**
	 * Get Rule Type.
	 *
	 * @return Rule Type
	 */
	@JsonProperty("RuleType")
	public I_AD_Ref_ListInput RuleType() {
		return mRuleType;
	}
}
