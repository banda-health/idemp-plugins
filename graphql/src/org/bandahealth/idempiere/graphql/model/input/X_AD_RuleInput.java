package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
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

	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput AccessLevel_RL;
	 private I_AD_Ref_ListInput EventType_RL;
	 private I_AD_Ref_ListInput RuleType_RL;

	/**
	 * Standard constructor
	 */
	public X_AD_RuleInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Data Access Level.
	 *
	 * @param AccessLevel_RL Access Level required
	 */
	public void setAccessLevel_RL(I_AD_Ref_ListInput AccessLevel_RL) {
		this.AccessLevel_RL = AccessLevel_RL;
		MRefList foreignEntity;
		if (AccessLevel_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AccessLevel_RL.getID())
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
	public I_AD_Ref_ListInput getAccessLevel_RL() {
		return AccessLevel_RL;
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
	public void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType) {
		this.AD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEntityType(foreignEntity.get_ID());
		} else {
			this.setEntityType(0);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public I_AD_EntityTypeInput getAD_EntityType() {
		return AD_EntityType;
	}

	/**
	 * Set Event Type.
	 *
	 * @param EventType_RL Type of Event
	 */
	public void setEventType_RL(I_AD_Ref_ListInput EventType_RL) {
		this.EventType_RL = EventType_RL;
		MRefList foreignEntity;
		if (EventType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(EventType_RL.getID())
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
	public I_AD_Ref_ListInput getEventType_RL() {
		return EventType_RL;
	}

	/**
	 * Set Rule Type.
	 *
	 * @param RuleType_RL Rule Type
	 */
	public void setRuleType_RL(I_AD_Ref_ListInput RuleType_RL) {
		this.RuleType_RL = RuleType_RL;
		MRefList foreignEntity;
		if (RuleType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(RuleType_RL.getID())
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
	public I_AD_Ref_ListInput getRuleType_RL() {
		return RuleType_RL;
	}
}
