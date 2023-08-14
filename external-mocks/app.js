import express from 'express';
import { readFileSync } from 'fs';

const app = express();
const port = process.env.PORT;

const addOclHeaders = (response) => {
	response.append('num_found', '2');
	return response;
};

app.get(
	'/ocl/orgs/:org/sources/:source/concepts/:concept?',
	(request, response) => {
		const concepts = JSON.parse(
			readFileSync(
				`./files/ocl/${request.params.source}-concepts${
					request.params.concept ? '-' + request.params.concept : ''
				}.json`
			).toString()
		);
		response.append('num_found', concepts?.length || 1).json(concepts);
	}
);

app.listen(port, () => {
	console.log(`External mocks listening on port ${port}`);
});
