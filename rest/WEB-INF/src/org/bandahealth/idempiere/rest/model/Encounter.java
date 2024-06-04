package org.bandahealth.idempiere.rest.model;

import java.sql.Timestamp;
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
	private ReferenceList encounterType;
	private List<Observation> observations = new ArrayList<>();
	private List<EncounterDiagnosis> encounterDiagnoses = new ArrayList<>();
	private List<EncounterDiagnostic> encounterDiagnostics = new ArrayList<>();
	private Timestamp encounterDate;

	private static final long serialVersionUID = 1L;

	public Encounter() {
	}

	public Encounter(MBHEncounter entity) {
		super(entity);

		this.visitId = entity.getBH_Visit_ID();
		this.encounterDate = entity.getBH_Encounter_Date();
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public ReferenceList getEncounterType() {
		return encounterType;
	}

	public void setEncounterType(ReferenceList encounterType) {
		this.encounterType = encounterType;
	}

	public List<Observation> getObservations() {
		return observations;
	}

	public void setObservations(List<Observation> observations) {
		this.observations = observations;
	}

	public List<EncounterDiagnosis> getEncounterDiagnoses() {
		return encounterDiagnoses;
	}

	public void setEncounterDiagnoses(List<EncounterDiagnosis> encounterDiagnoses) {
		this.encounterDiagnoses = encounterDiagnoses;
	}

	public List<EncounterDiagnostic> getEncounterDiagnostics() {
		return encounterDiagnostics;
	}

	public void setEncounterDiagnostics(List<EncounterDiagnostic> encounterDiagnostics) {
		this.encounterDiagnostics = encounterDiagnostics;
	}

	public Timestamp getEncounterDate() {
		return encounterDate;
	}

	public void setEncounterDate(Timestamp encounterDate) {
		this.encounterDate = encounterDate;
	}
}
