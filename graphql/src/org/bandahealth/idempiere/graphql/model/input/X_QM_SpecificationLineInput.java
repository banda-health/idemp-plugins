package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MAttribute_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
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
	 * Standard constructor
	 */
	@JsonCreator
	public X_QM_SpecificationLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_QM_SpecificationLine(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set And/Or.
	 *
	 * @param AndOr Logical operation: AND or OR
	 */
	@JsonProperty("AndOr")
	public void setAndOrInput(I_AD_Ref_ListInput AndOr) {
		this.mAndOr = AndOr;
		MRefList_BH foreignEntity;
		if (AndOr != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AndOr.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAndOr(foreignEntity.getValue());
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
		MAttribute_BH foreignEntity;
		if (M_Attribute != null &&
				(foreignEntity = new Query(getCtx(), "M_Attribute", "M_Attribute_UU=?", get_TrxName())
						.setParameters(M_Attribute.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Attribute_ID(foreignEntity.get_ID());
		} else {
			super.setM_Attribute_ID(0);
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
		MRefList_BH foreignEntity;
		if (Operation != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Operation.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setOperation(foreignEntity.getValue());
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
		X_QM_Specification foreignEntity;
		if (get_ID() == 0 && QM_Specification != null &&
				(foreignEntity = new Query(getCtx(), "QM_Specification", "QM_Specification_UU=?", get_TrxName())
						.setParameters(QM_Specification.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setQM_Specification_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setQM_SpecificationLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getQM_SpecificationLine_UU();
	}
}
