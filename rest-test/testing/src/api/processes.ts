import axios from 'axios';
import { ValueObject } from '../models';
import { Patient, Process } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './base';

class ProcessApi extends BaseApi<Process> {
	entityName = 'process';

	async getByUuid(valueObject: ValueObject, uuid: string): Promise<Process> {
		return (
			await axios.post<Process>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}/process/${uuid}`,
				undefined,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}

	async runAndExport(valueObject: ValueObject) {
		return (
			await axios.post<ArrayBuffer>(
				`${IDEMPIERE_ENDPOINT}/${
					this.entityName
				}/runandexport/${valueObject.processUuid!}/${valueObject.reportType.toUpperCase()}`,
				valueObject.processInformationParameters,
				{ ...this.getAuthorizationHeaders(valueObject), responseType: 'arraybuffer' },
			)
		).data;
	}
}

export const processApi = new ProcessApi();
