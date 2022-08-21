import moment from 'moment'
import { StepStateEnum } from '@/enum'

/** 根据传入的 step list 获取进行到的 step index */
const filterStepState = (
	vals: { step_index: number; step_name: string; step_state: StepStateEnum }[]
): number => {
	let index = -1
	vals.map((temp) => {
		if (temp.step_state === StepStateEnum.SUCCESS || temp.step_state === StepStateEnum.WAIT) {
			index = temp.step_index
		}
	})
	return index
}

const fortmatDate2YMD = (now: Date): string => {
	return moment(now).format('YYYY-MM-DD')
}

export { filterStepState, fortmatDate2YMD }
