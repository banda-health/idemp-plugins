package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MRule;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_RuleInput extends MRule implements I_AD_RuleInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mAccessLevel;
	private I_AD_Ref_ListInput mEventType;
	private I_AD_Ref_ListInput mRuleType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Rule_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_RuleInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MRule(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Data Access Level.
	 *
	 * @param AccessLevel Access Level required
	 */
	@JsonProperty("AccessLevel")
	public void setAccessLevelInput(I_AD_Ref_ListInput AccessLevel) {
		this.mAccessLevel = AccessLevel;
		if (AccessLevel != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AccessLevel.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAccessLevel(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + AccessLevel.getUUID());
			}
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
	 * Set Rule.
	 *
	 * @param AD_Rule_ID Rule
	 */

	public void setAD_Rule_ID(int AD_Rule_ID) {
		if (get_ID() == 0) {
			super.setAD_Rule_ID(AD_Rule_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Rule_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_Rule_UU();
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
	 * Set Event Type.
	 *
	 * @param EventType Type of Event
	 */
	@JsonProperty("EventType")
	public void setEventTypeInput(I_AD_Ref_ListInput EventType) {
		this.mEventType = EventType;
		if (EventType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(EventType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setEventType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + EventType.getUUID());
			}
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
		if (RuleType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(RuleType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setRuleType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + RuleType.getUUID());
			}
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
