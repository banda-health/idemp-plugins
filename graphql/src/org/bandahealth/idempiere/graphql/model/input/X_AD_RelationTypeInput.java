package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_RelationTypeResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_RelationType;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_RelationType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_RelationTypeInput extends X_AD_RelationType implements I_AD_RelationTypeInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Reference_Source;
	private ForeignEntityInput mAD_Reference_Target;
	private ForeignEntityInput mRole_Source;
	private ForeignEntityInput mRole_Target;
	private ForeignEntityInput mType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_RelationType_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_RelationTypeInput(@JsonProperty("UU") String UU) {
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
	 * Set Source Reference.
	 *
	 * @param AD_Reference_Source Source Reference
	 */
	@JsonProperty("AD_Reference_Source")
	public void setAD_Reference_SourceInput(ForeignEntityInput AD_Reference_Source) {
		this.mAD_Reference_Source = AD_Reference_Source;
		if (AD_Reference_Source != null) {
			// Since an entity was passed, make sure it's in the DB
			MReference_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
							.setParameters(AD_Reference_Source.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Reference_Source_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Reference with UU " + AD_Reference_Source.getUU());
			}
		} else {
			this.setAD_Reference_Source_ID(0);
		}
	}

	/**
	 * Get Source Reference.
	 *
	 * @return Source Reference
	 */
	@JsonProperty("AD_Reference_Source")
	public ForeignEntityInput AD_Reference_Source() {
		return mAD_Reference_Source;
	}

	/**
	 * Set Target Reference.
	 *
	 * @param AD_Reference_Target Target Reference
	 */
	@JsonProperty("AD_Reference_Target")
	public void setAD_Reference_TargetInput(ForeignEntityInput AD_Reference_Target) {
		this.mAD_Reference_Target = AD_Reference_Target;
		if (AD_Reference_Target != null) {
			// Since an entity was passed, make sure it's in the DB
			MReference_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
							.setParameters(AD_Reference_Target.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Reference_Target_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Reference with UU " + AD_Reference_Target.getUU());
			}
		} else {
			this.setAD_Reference_Target_ID(0);
		}
	}

	/**
	 * Get Target Reference.
	 *
	 * @return Target Reference
	 */
	@JsonProperty("AD_Reference_Target")
	public ForeignEntityInput AD_Reference_Target() {
		return mAD_Reference_Target;
	}
	/**
	 * Set Relation Type.
	 *
	 * @param AD_RelationType_ID Relation Type
	 */
	@JsonProperty("AD_RelationType_ID")
	public void setAD_RelationType_IDFromJson(int AD_RelationType_ID) {
		if (get_ID() == 0) {
			super.setAD_RelationType_ID(AD_RelationType_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_RelationType_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_RelationType_UU();
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
	 * Set Source Role.
	 *
	 * @param Role_Source If set, this role will be used as label for the zoom destination instead of the destinations's window name
	 */
	@JsonProperty("Role_Source")
	public void setRole_SourceInput(ForeignEntityInput Role_Source) {
		this.mRole_Source = Role_Source;
		if (Role_Source != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_RelationTypeResolver.ROLE_SOURCE_UUIDS_BY_VALUE.containsValue(Role_Source.getUU())) {
				throw new AdempiereException("The reference list UU of " + Role_Source.getUU() +
						" is not in the list defined for the Role_Source column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Role_Source.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setRole_Source(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Role_Source.getUU());
			}
		} else {
			this.setRole_Source(null);
		}
	}

	/**
	 * Get Source Role.
	 *
	 * @return If set, this role will be used as label for the zoom destination instead of the destinations's window name
	 */
	@JsonProperty("Role_Source")
	public ForeignEntityInput Role_Source() {
		return mRole_Source;
	}

	/**
	 * Set Target Role.
	 *
	 * @param Role_Target If set, this role will be used as label for the zoom destination instead of the destinations's window name
	 */
	@JsonProperty("Role_Target")
	public void setRole_TargetInput(ForeignEntityInput Role_Target) {
		this.mRole_Target = Role_Target;
		if (Role_Target != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_RelationTypeResolver.ROLE_TARGET_UUIDS_BY_VALUE.containsValue(Role_Target.getUU())) {
				throw new AdempiereException("The reference list UU of " + Role_Target.getUU() +
						" is not in the list defined for the Role_Target column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Role_Target.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setRole_Target(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Role_Target.getUU());
			}
		} else {
			this.setRole_Target(null);
		}
	}

	/**
	 * Get Target Role.
	 *
	 * @return If set, this role will be used as label for the zoom destination instead of the destinations's window name
	 */
	@JsonProperty("Role_Target")
	public ForeignEntityInput Role_Target() {
		return mRole_Target;
	}

	/**
	 * Set Type.
	 *
	 * @param Type Type of Validation (SQL, Java Script, Java Language)
	 */
	@JsonProperty("Type")
	public void setTypeInput(ForeignEntityInput Type) {
		this.mType = Type;
		if (Type != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_RelationTypeResolver.TYPE_UUIDS_BY_VALUE.containsValue(Type.getUU())) {
				throw new AdempiereException("The reference list UU of " + Type.getUU() +
						" is not in the list defined for the Type column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Type.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Type.getUU());
			}
		} else {
			this.setType(null);
		}
	}

	/**
	 * Get Type.
	 *
	 * @return Type of Validation (SQL, Java Script, Java Language)
	 */
	@JsonProperty("Type")
	public ForeignEntityInput Type() {
		return mType;
	}
}
