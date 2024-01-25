package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttribute_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
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
 * @version Release 7.1 - $Id$
 */
public class X_QM_SpecificationLineInput extends X_QM_SpecificationLine implements I_QM_SpecificationLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Attribute;
	private ForeignEntityInput mQM_Specification;
	private I_AD_Ref_ListInput mAndOr;
	private I_AD_Ref_ListInput mOperation;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The QM_SpecificationLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_QM_SpecificationLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_QM_SpecificationLine(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
	 * Set And/Or.
	 *
	 * @param AndOr Logical operation: AND or OR
	 */
	@JsonProperty("AndOr")
	public void setAndOrInput(I_AD_Ref_ListInput AndOr) {
		this.mAndOr = AndOr;
		if (AndOr != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AndOr.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAndOr(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + AndOr.getUUID());
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
	public I_AD_Ref_ListInput AndOr() {
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
			MAttribute_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Attribute", "M_Attribute_UU=?", get_TrxName())
							.setParameters(M_Attribute.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Attribute_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Attribute with UUID " + M_Attribute.getUUID());
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
	public void setOperationInput(I_AD_Ref_ListInput Operation) {
		this.mOperation = Operation;
		if (Operation != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Operation.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setOperation(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + Operation.getUUID());
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
	public I_AD_Ref_ListInput Operation() {
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
							.setParameters(QM_Specification.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setQM_Specification_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table QM_Specification with UUID " + QM_Specification.getUUID());
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

	public void setQM_SpecificationLine_ID(int QM_SpecificationLine_ID) {
		if (get_ID() == 0) {
			super.setQM_SpecificationLine_ID(QM_SpecificationLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setQM_SpecificationLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getQM_SpecificationLine_UU();
	}
}
