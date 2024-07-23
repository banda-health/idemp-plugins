package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_QM_SpecificationLineResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAttribute;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_QM_Specification;
import org.eevolution.model.X_QM_SpecificationLine;

import java.sql.ResultSet;

/**
 * Generated Model for QM_SpecificationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_QM_SpecificationLineInput extends X_QM_SpecificationLine implements I_QM_SpecificationLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAndOr;
	private ForeignEntityInput mM_Attribute;
	private ForeignEntityInput mOperation;
	private ForeignEntityInput mQM_Specification;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The QM_SpecificationLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_QM_SpecificationLineInput(@JsonProperty("UU") String UU) {
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
	 * Set And/Or.
	 *
	 * @param AndOr Logical operation: AND or OR
	 */
	@JsonProperty("AndOr")
	public void setAndOrInput(ForeignEntityInput AndOr) {
		this.mAndOr = AndOr;
		if (AndOr != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_QM_SpecificationLineResolver.ANDOR_UUIDS_BY_VALUE.containsValue(AndOr.getUU())) {
				throw new AdempiereException("The reference list UU of " + AndOr.getUU() +
						" is not in the list defined for the AndOr column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AndOr.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAndOr(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + AndOr.getUU());
			}
		} else {
			this.setAndOr(null);
		}
	}

	/**
	 * Get And/Or.
	 *
	 * @return Logical operation: AND or OR
	 */
	@JsonProperty("AndOr")
	public ForeignEntityInput AndOr() {
		return mAndOr;
	}

	/**
	 * Set Attribute.
	 *
	 * @param M_Attribute Product Attribute
	 */
	@JsonProperty("M_Attribute")
	public void setM_AttributeInput(ForeignEntityInput M_Attribute) {
		this.mM_Attribute = M_Attribute;
		if (M_Attribute != null) {
			// Since an entity was passed, make sure it's in the DB
			MAttribute foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Attribute", "M_Attribute_UU=?", get_TrxName())
							.setParameters(M_Attribute.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_Attribute_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Attribute with UU " + M_Attribute.getUU());
			}
		} else {
			this.setM_Attribute_ID(0);
		}
	}

	/**
	 * Get Attribute.
	 *
	 * @return Product Attribute
	 */
	@JsonProperty("M_Attribute")
	public ForeignEntityInput M_Attribute() {
		return mM_Attribute;
	}

	/**
	 * Set Operation.
	 *
	 * @param Operation Compare Operation
	 */
	@JsonProperty("Operation")
	public void setOperationInput(ForeignEntityInput Operation) {
		this.mOperation = Operation;
		if (Operation != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_QM_SpecificationLineResolver.OPERATION_UUIDS_BY_VALUE.containsValue(Operation.getUU())) {
				throw new AdempiereException("The reference list UU of " + Operation.getUU() +
						" is not in the list defined for the Operation column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Operation.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setOperation(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Operation.getUU());
			}
		} else {
			this.setOperation(null);
		}
	}

	/**
	 * Get Operation.
	 *
	 * @return Compare Operation
	 */
	@JsonProperty("Operation")
	public ForeignEntityInput Operation() {
		return mOperation;
	}

	/**
	 * Set Quality Specification.
	 *
	 * @param QM_Specification Quality Specification
	 */
	@JsonProperty("QM_Specification")
	public void setQM_SpecificationInput(ForeignEntityInput QM_Specification) {
		this.mQM_Specification = QM_Specification;
		if (get_ID() != 0) {
			return;
		}
		if (QM_Specification != null) {
			// Since an entity was passed, make sure it's in the DB
			X_QM_Specification foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "QM_Specification", "QM_Specification_UU=?", get_TrxName())
							.setParameters(QM_Specification.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setQM_Specification_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table QM_Specification with UU " + QM_Specification.getUU());
			}
		} else {
			this.setQM_Specification_ID(0);
		}
	}

	/**
	 * Get Quality Specification.
	 *
	 * @return Quality Specification
	 */
	@JsonProperty("QM_Specification")
	public ForeignEntityInput QM_Specification() {
		return mQM_Specification;
	}
	/**
	 * Set QM Specification Line.
	 *
	 * @param QM_SpecificationLine_ID QM Specification Line
	 */
	@JsonProperty("QM_SpecificationLine_ID")
	public void setQM_SpecificationLine_IDFromJson(int QM_SpecificationLine_ID) {
		if (get_ID() == 0) {
			super.setQM_SpecificationLine_ID(QM_SpecificationLine_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setQM_SpecificationLine_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getQM_SpecificationLine_UU();
	}
}
