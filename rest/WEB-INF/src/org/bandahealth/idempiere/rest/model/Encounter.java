package org.bandahealth.idempiere.rest.model;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MBHEncounter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Encounter extends BaseMetadata {

	@JsonIgnore
	private int visitId;

	private String encounterType;

	private List<Observation> observations = new ArrayList<>();
	private List<EncounterDiagnosis> encounterDiagnosis = new ArrayList<>();

	private static final long serialVersionUID = 1L;

	public Encounter() {
	}

	public Encounter(MBHEncounter entity) {
		super(entity);

		this.encounterType = entity.getBH_EncounterType();
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public String getEncounterType() {
		return encounterType;
	}

	public void setEncounterType(String encounterType) {
		this.encounterType = encounterType;
	}

	public List<Observation> getObservations() {
		return observations;
	}

	public void setObservations(List<Observation> observations) {
		this.observations = observations;
	}

	public List<EncounterDiagnosis> getEncounterDiagnosis() {
		return encounterDiagnosis;
	}

	public void setEncounterDiagnosis(List<EncounterDiagnosis> encounterDiagnosis) {
		this.encounterDiagnosis = encounterDiagnosis;
	}
}
