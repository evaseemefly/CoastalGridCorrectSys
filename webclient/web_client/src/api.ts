/** 不再做按照业务切分，统一至此文件中 */
import axios from 'axios'

axios.defaults.withCredentials = true
// axios.defaults.headers['content-type'] = 'application/json;charset=UTF-8'
// axios.defaults.headers = {
// 	// 'Content-Type': 'application/json;charset=UTF-8',
// 	// 'Access-Control-Allow-Origin': 'http://121.36.51.94:8080',
// }

const HOST = 'http://121.36.51.94:8080'
// const HOST = 'http://localhost:8080'

const getTaskByGroup = (parm: { codes: string[]; dt: Date }) => {
	const area = 'task'
	const url = `${HOST}/${area}/group/info`
	return axios.get(url, {
		// headers: authHeader(),
		params: { now_dt: parm.dt, group_code: parm.codes },
	})
}

const getGroupCount = () => {
	const area = 'task'
	const url = `${HOST}/${area}/group/list`
	return axios.get(url, {
		// headers: authHeader(),
		params: {},
	})
}

const getAllProduct = () => {
	const area = 'product'
	const url = `${HOST}/${area}/group/list`
	return axios.get(url, {
		// headers: authHeader(),
		params: {},
	})
}

const getProductMain = () => {
	const area = 'statistics'
	const url = `${HOST}/${area}/product/main`
	return axios.get(url, {
		// headers: authHeader(),
		params: {},
	})
}

const getProductDailyInfo = () => {
	const area = 'statistics'
	const url = `${HOST}/${area}/product/file`
	return axios.get(url, {
		// headers: authHeader(),
		params: {},
	})
}

const getNearlyProductInfo = () => {
	const area = 'statistics'
	const url = `${HOST}/${area}/product/7days`
	return axios.get(url, {
		// headers: authHeader(),
		params: {},
	})
}

const getLastFileList = () => {
	const area = 'product'
	const url = `${HOST}/${area}/watch/list`
	return axios.get(url, {
		// headers: authHeader(),
		params: {},
	})
}

const getElmentRate = (elementTyppe: number, nowDt: Date, targetDt?: Date) => {
	const area = 'task'
	const url = `${HOST}/${area}/element/info`
	return axios.get(url, {
		// headers: authHeader(),
		params: {
			element_type: elementTyppe,
			now_dt: nowDt,
			target_dt: targetDt ? targetDt : null,
		},
	})
}

const getAreaStep = (elemntType: number, nowDt: Date, searArea: number, targetDt?: Date) => {
	const area = 'task'
	const url = `${HOST}/${area}/element/area/step`
	return axios.get(url, {
		// headers: authHeader(),
		params: {
			elementType: elemntType,
			now_dt: nowDt,
			area: searArea,
			target_dt: targetDt ? targetDt : null,
		},
	})
}

export {
	getTaskByGroup,
	getGroupCount,
	getAllProduct,
	getProductMain,
	getNearlyProductInfo,
	getProductDailyInfo,
	getLastFileList,
	getElmentRate,
	getAreaStep,
}
