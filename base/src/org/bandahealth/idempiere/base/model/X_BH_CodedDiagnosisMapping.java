/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.I_Persistent;
import org.compiere.model.PO;
import org.compiere.model.POInfo;

/**
 * Generated Model for BH_CodedDiagnosisMapping
 * 
 * @author iDempiere (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_CodedDiagnosisMapping extends PO implements I_BH_CodedDiagnosisMapping, I_Persistent {

	/**
	 *
	 */
	private static final long serialVersionUID = 20200526L;

	/** Standard Constructor */
	public X_BH_CodedDiagnosisMapping(Properties ctx, int BH_CodedDiagnosisMapping_ID, String trxName) {
		super(ctx, BH_CodedDiagnosisMapping_ID, trxName);
	}

	/** Load Constructor */
	public X_BH_CodedDiagnosisMapping(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * AccessLevel
	 * 
	 * @return 4 - System
	 */
	protected int get_AccessLevel() {
		return accessLevel.intValue();
	}

	/**
	 * Load Meta Data
	 * 
	 * @return
	 */
	protected POInfo initPO(Properties ctx) {
		POInfo poi = POInfo.getPOInfo(ctx, Table_ID, get_TrxName());
		return poi;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("X_BH_CodedDiagnosisMapping[").append(get_ID()).append(",ConceptName=")
				.append(getBH_ConceptNameResolved()).append("]");
		return sb.toString();
	}

	/**
	 * Set BH_CodedDiagnosis_ID.
	 * 
	 * @param BH_CodedDiagnosis_ID BH_CodedDiagnosis
	 */
	public void setBH_CodedDiagnosis_ID(int BH_CodedDiagnosis_ID) {
		if (BH_CodedDiagnosis_ID < 1)
			set_ValueNoCheck(COLUMNNAME_BH_Coded_Diagnosis_ID, null);
		else
			set_ValueNoCheck(COLUMNNAME_BH_Coded_Diagnosis_ID, Integer.valueOf(BH_CodedDiagnosis_ID));
	}

	/**
	 * Get BH_CodedDiagnosis.
	 * 
	 * @return BH_CodedDiagnosis
	 */
	public int getBH_CodedDiagnosis_ID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_Coded_Diagnosis_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	/**
	 * Set BH_CodedDiagnosisMapping_UU.
	 * 
	 * @param BH_CodedDiagnosisMapping_UU
	 */
	public void setBH_CodedDiagnosisMapping_UU(String BH_CodedDiagnosisMapping_UU) {
		set_Value(COLUMNNAME_BH_Coded_Diagnosis_Mapping_UU, BH_CodedDiagnosisMapping_UU);
	}

	/**
	 * Get BH_CodedDiagnosis_UU.
	 * 
	 * @return BH_CodedDiagnosis_UU
	 */
	public String getBH_CodedDiagnosisMapping_UU() {
		return (String) get_Value(COLUMNNAME_BH_Coded_Diagnosis_Mapping_UU);
	}

	@Override
	public void setBH_CodedDiagnosisMapping_ID(int BH_CodedDiagnosisMapping_ID) {
		if (BH_CodedDiagnosisMapping_ID < 1)
			set_ValueNoCheck(COLUMNNAME_BH_Coded_Diagnosis_Mapping_ID, null);
		else
			set_ValueNoCheck(COLUMNNAME_BH_Coded_Diagnosis_Mapping_ID, Integer.valueOf(BH_CodedDiagnosisMapping_ID));
	}

	@Override
	public int getBH_CodedDiagnosisMapping_ID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_Coded_Diagnosis_Mapping_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	@Override
	public void setBH_Source(String BH_Source) {
		set_Value(COLUMNNAME_BH_Source, BH_Source);
	}

	@Override
	public String getBH_Source() {
		return (String) get_Value(COLUMNNAME_BH_Source);
	}

	@Override
	public void setBH_ExternalID(String BH_External_ID) {
		set_Value(COLUMNNAME_BH_ExternalId, BH_External_ID);
	}

	@Override
	public String getBH_ExternalID() {
		return (String) get_Value(COLUMNNAME_BH_ExternalId);
	}

	@Override
	public void setBH_MapType(String BH_MapType) {
		set_Value(COLUMNNAME_BH_MapType, BH_MapType);
	}

	@Override
	public String getBH_MapType() {
		return (String) get_Value(COLUMNNAME_BH_MapType);
	}

	@Override
	public void setBH_Owner(String BH_Owner) {
		set_Value(COLUMNNAME_BH_Owner, BH_Owner);
	}

	@Override
	public String getBH_Owner() {
		return (String) get_Value(COLUMNNAME_BH_Owner);
	}

	@Override
	public void setBH_ConceptCode(String BH_ConceptCode) {
		set_Value(COLUMNNAME_BH_ConceptCode, BH_ConceptCode);
	}

	@Override
	public String getBH_ConceptCode() {
		return (String) get_Value(COLUMNNAME_BH_ConceptCode);
	}

	@Override
	public void setBH_ConceptNameResolved(String BH_ConceptNameResolved) {
		set_Value(COLUMNNAME_BH_ConceptNameResolved, BH_ConceptNameResolved);
	}

	@Override
	public String getBH_ConceptNameResolved() {
		return (String) get_Value(COLUMNNAME_BH_ConceptNameResolved);
	}
}