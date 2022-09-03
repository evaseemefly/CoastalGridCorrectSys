<template>
	<div class="base-step-list space-between">
		<BaseInfoStepView
			:state="group.state"
			:name="group.name"
			:desc="group.desc"
			:lastDt="group.lastDt"
			v-for="group in groupStepList"
			:key="group.key"
			:sort="group.sort"
		></BaseInfoStepView>
	</div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
import BaseInfoStepView from '@/components/BaseInfoStepView.vue'
import { StateEnum, ProductLevelEnmu } from '@/enum'
import { getAllAreaStep } from '@/api'
const getGroupName = (level: ProductLevelEnmu): string => {
	let name = ''
	switch (level) {
		case ProductLevelEnmu.L0:
			name = '国家中心'
			break
		case ProductLevelEnmu.L1:
			name = '省台'
			break
		case ProductLevelEnmu.L2:
			name = '海区'
			break
		case ProductLevelEnmu.L3:
			name = '海区'
			break
		case ProductLevelEnmu.L4:
			name = '国家中心'
			break
		case ProductLevelEnmu.L5:
			name = '国家中心'
			break
	}
	return name
}

const getGroupDesc = (level: ProductLevelEnmu): string => {
	let name = ''
	switch (level) {
		case ProductLevelEnmu.L0:
			name = '国家指导产品'
			break
		case ProductLevelEnmu.L1:
			name = '交互订正产品'
			break
		case ProductLevelEnmu.L2:
			name = '订正融合产品'
			break
		case ProductLevelEnmu.L3:
			name = '人机订正产品'
			break
		case ProductLevelEnmu.L4:
			name = '融合产品'
			break
		case ProductLevelEnmu.L5:
			name = '人机订正产品'
			break
	}
	return name
}
@Component({ components: { BaseInfoStepView } })
export default class BaseInfoStepsView extends Vue {
	@Prop(Date)
	forecastDt: Date

	groupStepList: {
		code: string
		name: string
		desc: string
		lastDt: Date
		state: StateEnum
		sort: number
	}[] = [
		// {
		// 	code: '',
		// 	name: '国家中心',
		// 	desc: '国家级指导产品',
		// 	state: StateEnum.SUITED,
		// 	lastDt: new Date('2022-08-29 10:00'),
		// },
		// {
		// 	code: '',
		// 	name: '省级',
		// 	desc: '交互订正后产品',
		// 	state: StateEnum.UNSUITED,
		// 	lastDt: new Date('2022-08-29 10:00'),
		// },
		// {
		// 	code: '',
		// 	name: '海区级',
		// 	desc: '订正场融合产品',
		// 	state: StateEnum.UNSUITED,
		// 	lastDt: new Date('2022-08-29 10:00'),
		// },
		// {
		// 	code: '',
		// 	name: '海区级',
		// 	desc: '人机订正后产品',
		// 	state: StateEnum.UNSUITED,
		// 	lastDt: new Date('2022-08-29 10:00'),
		// },
		// {
		// 	code: '',
		// 	name: '国家中心',
		// 	desc: '三个海区融合产品',
		// 	state: StateEnum.UNSUITED,
		// 	lastDt: new Date('2022-08-29 10:00'),
		// },
		// {
		// 	code: '',
		// 	name: '国家中心',
		// 	desc: '人机订正后产品',
		// 	state: StateEnum.UNSUITED,
		// 	lastDt: new Date('2022-08-29 10:00'),
		// },
	]

	@Watch('forecastDt')
	onForecastDt(val: Date): void {
		this.groupStepList = []
		const levels = [
			ProductLevelEnmu.L0,
			ProductLevelEnmu.L1,
			ProductLevelEnmu.L2,
			ProductLevelEnmu.L3,
			ProductLevelEnmu.L4,
			ProductLevelEnmu.L5,
		]
		let tempGroupStepList: {
			code: string
			name: string
			desc: string
			lastDt: Date
			state: StateEnum
			sort: number
		}[] = []
		for (let index = 0; index < levels.length; index++) {
			const element = levels[index]
			const tempStep: {
				code: string
				name: string
				desc: string
				state: StateEnum
				lastDt: Date
				sort: number
			} = {}
			getAllAreaStep(element, val).then(
				(res: {
					status: number
					data: {
						level: number
						sort: number
						step_state: StateEnum
					}
				}) => {
					if (res.status === 200) {
						tempStep.code = element.toString()
						tempStep.name = getGroupName(element)
						tempStep.desc = getGroupDesc(element)
						tempStep.state = res.data.step_state
						tempStep.lastDt = new Date()
						tempStep.sort = index
						tempGroupStepList.push(tempStep)
					}
				}
			)
		}

		this.groupStepList = tempGroupStepList
	}
}
</script>
<style scoped>
.base-step-list {
	display: flex;
	width: 100%;
}
.space-between {
	justify-content: space-between !important;
}
</style>
