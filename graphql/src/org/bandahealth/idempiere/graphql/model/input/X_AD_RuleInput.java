package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_RuleResolver;
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
 * @version Release 12 - $Id$
 */
public class X_AD_RuleInput extends MRule implements I_AD_RuleInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAccessLevel;
	private ForeignEntityInput mEventType;
	private ForeignEntityInput mRuleType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Rule_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_RuleInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Data Access Level.
	 *
	 * @param AccessLevel Access Level required
	 */
	@JsonProperty("AccessLevel")
	public void setAccessLevelInput(ForeignEntityInput AccessLevel) {
		this.mAccessLevel = AccessLevel;
		if (AccessLevel != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_RuleResolver.ACCESSLEVEL_UUIDS_BY_VALUE.containsValue(AccessLevel.getUU())) {
				throw new AdempiereException("The reference list UU of " + AccessLevel.getUU() +
						" is not in the list defined for the AccessLevel column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AccessLevel.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAccessLevel(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + AccessLevel.getUU());
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
	public ForeignEntityInput AccessLevel() {
		return mAccessLevel;
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
	 * Set Rule.
	 *
	 * @param AD_Rule_ID Rule
	 */
	@JsonProperty("AD_Rule_ID")
	public void setAD_Rule_IDFromJson(int AD_Rule_ID) {
		if (get_ID() == 0) {
			super.setAD_Rule_ID(AD_Rule_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Rule_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
							.setParameters(AD_EntityType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
	 * Set Event Type.
	 *
	 * @param EventType Type of Event
	 */
	@JsonProperty("EventType")
	public void setEventTypeInput(ForeignEntityInput EventType) {
		this.mEventType = EventType;
		if (EventType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_RuleResolver.EVENTTYPE_UUIDS_BY_VALUE.containsValue(EventType.getUU())) {
				throw new AdempiereException("The reference list UU of " + EventType.getUU() +
						" is not in the list defined for the EventType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(EventType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setEventType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + EventType.getUU());
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
	public ForeignEntityInput EventType() {
		return mEventType;
	}

	/**
	 * Set Rule Type.
	 *
	 * @param RuleType Rule Type
	 */
	@JsonProperty("RuleType")
	public void setRuleTypeInput(ForeignEntityInput RuleType) {
		this.mRuleType = RuleType;
		if (RuleType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_RuleResolver.RULETYPE_UUIDS_BY_VALUE.containsValue(RuleType.getUU())) {
				throw new AdempiereException("The reference list UU of " + RuleType.getUU() +
						" is not in the list defined for the RuleType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(RuleType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setRuleType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + RuleType.getUU());
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
	public ForeignEntityInput RuleType() {
		return mRuleType;
	}
}
