package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.compiere.model.MRefList;


@XmlRootElement
public class ReferenceList extends BaseEntity {
	/**
	 * Empty constructor needed for deserialization
	 */
	public ReferenceList() {}

	public ReferenceList(MRefList model) {
		super(model, model.getName(), model.getDescription(), model.getValue());
	}
}
