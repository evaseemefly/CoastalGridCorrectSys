<template>
	<div class="base-step-list space-between">
		<BaseInfoStepView
			:state="group.state"
			:name="group.name"
			:desc="group.desc"
			:lastDt="group.lastDt"
			v-for="group in groupStepList"
			:key="group.key"
		></BaseInfoStepView>
	</div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
import BaseInfoStepView from '@/components/BaseInfoStepView.vue'
import { StateEnum } from '@/enum'

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
	}[] = [
		{
			code: '',
			name: '国家中心',
			desc: '国家级指导产品',
			state: StateEnum.SUITED,
			lastDt: new Date('2022-08-29 10:00'),
		},
		{
			code: '',
			name: '省级',
			desc: '交互订正后产品',
			state: StateEnum.UNSUITED,
			lastDt: new Date('2022-08-29 10:00'),
		},
		{
			code: '',
			name: '海区级',
			desc: '订正场融合产品',
			state: StateEnum.UNSUITED,
			lastDt: new Date('2022-08-29 10:00'),
		},
		{
			code: '',
			name: '海区级',
			desc: '人机订正后产品',
			state: StateEnum.UNSUITED,
			lastDt: new Date('2022-08-29 10:00'),
		},
		{
			code: '',
			name: '国家中心',
			desc: '三个海区融合产品',
			state: StateEnum.UNSUITED,
			lastDt: new Date('2022-08-29 10:00'),
		},
		{
			code: '',
			name: '国家中心',
			desc: '人机订正后产品',
			state: StateEnum.UNSUITED,
			lastDt: new Date('2022-08-29 10:00'),
		},
	]
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
