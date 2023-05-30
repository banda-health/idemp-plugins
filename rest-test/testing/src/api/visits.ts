import axios from 'axios';
import { BaseApi, IDEMPIERE_ENDPOINT } from '.';
import { ValueObject } from '../models';
import { Visit } from '../types/org.bandahealth.idempiere.rest';

class VisitApi extends BaseApi<Visit> {
	entityName = 'visits';

	// TODO: Remove these when we call processing directly on the Order
	async process(valueObject: ValueObject, uuid: string, documentAction: string): Promise<Visit> {
		return (
			await axios.post<Visit>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}/${uuid}/process/${documentAction}`,
				undefined,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}

	async saveAndProcess(valueObject: ValueObject, data: Visit, documentAction: string): Promise<Visit> {
		return (
			await axios.post<Visit>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}/process/${documentAction}`,
				data,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}
}

export const visitApi = new VisitApi();
