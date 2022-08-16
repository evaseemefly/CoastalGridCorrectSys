/** 不再做按照业务切分，统一至此文件中 */
import axios from 'axios'

const HOST = ''

const getTaskByGroup = (parm: { code: string; dt: Date }) => {
	const area = ''
	const url = `${HOST}${area}/group/info`
	return axios.get(url, {
		// headers: authHeader(),
		params: { group_code: parm.code, now_dt: parm.dt },
	})
}

const getGroupCount = () => {
	const area = ''
	const url = `${HOST}${area}/group/list`
	return axios.get(url, {
		// headers: authHeader(),
		params: {},
	})
}

export { getTaskByGroup, getGroupCount }
