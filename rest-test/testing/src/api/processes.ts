import axios from 'axios';
import { ValueObject } from '../models';
import { Process } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './base';

class ProcessApi extends BaseApi<Process> {
	entityName = 'processes';

	async runAndExport(valueObject: ValueObject) {
		return (
			await axios.post<ArrayBuffer>(
				`${IDEMPIERE_ENDPOINT}/${
					this.entityName
				}/run-and-export/${valueObject.processUuid!}/${valueObject.reportType.toUpperCase()}`,
				valueObject.processInformationParameters,
				{ ...this.getAuthorizationHeaders(valueObject), responseType: 'arraybuffer' },
			)
		).data;
	}
}

export const processApi = new ProcessApi();
