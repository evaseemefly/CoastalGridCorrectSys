<template>
	<div class="main-content">
		<div class="my-row">
			<div class="my-statics-form">
				<StatisticanInfoView
					:minorTitle="GroupStatisticalData.mimor"
					:primayTile="GroupStatisticalData.primay"
				></StatisticanInfoView>
			</div>
			<div class="my-statics-form">
				<StatisticanInfoView
					:minorTitle="ProductStatisticalData.mimor"
					:primayTile="ProductStatisticalData.primay"
				></StatisticanInfoView>
			</div>
			<div class="my-statics-form">
				<StatisticanInfoView
					:minorTitle="ProductTypeStatisticalData.mimor"
					:primayTile="ProductTypeStatisticalData.primay"
				></StatisticanInfoView>
			</div>
			<div class="my-statics-form">
				<StatisticanInfoView
					:minorTitle="DailyStatisticalData.mimor"
					:primayTile="DailyStatisticalData.primay"
				></StatisticanInfoView>
			</div>
			<!-- <div class="my-histogran">
				<ProductProgressView></ProductProgressView>
			</div> -->
		</div>
		<div class="my-row">
			<ElementFlowView></ElementFlowView>
		</div>
		<div class="my-row">
			<InstitutionalTreeView></InstitutionalTreeView>
		</div>
		<div class="my-row height-2">
			<RecentlyHistogranView
				:nearlyStatisticsList="nearlyStatisticsList"
			></RecentlyHistogranView>
		</div>
		<div class="my-row height-2" :key="step.key" v-for="step in groupStepList">
			<StepView
				:groupName="step.name"
				:activedStepIndex="step.index"
				:stepList="step.stepList"
			></StepView>
		</div>
	</div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'

// 组件
import RecentlyHistogranView from '@/components/RecentlyHistogranView.vue'
import StepView from '@/components/StepView.vue'
import ProductProgressView from '@/components/ProductProgressView.vue'
import ElementFlowView from '@/components/ElementFlowView.vue'
// import StatisticanInfoView from '@/components/StatisticanInfoView.vue'
import StatisticanInfoView from '@/components/StatisticaInfoView.vue'
import InstitutionalTreeView from '@/components/InstitutionalTreeView.vue'
// api
import {
	getTaskByGroup,
	getGroupCount,
	getAllProduct,
	getProductMain,
	getNearlyProductInfo,
	getProductDailyInfo,
} from '@/api'
// enmu
import { GroupEnum, StepStateEnum } from '@/enum'
// common 与 filter
import { filterStepState } from '@/filter'
interface IInfo {
	mimor: string
	primay: string
}
@Component({
	components: {
		RecentlyHistogranView,
		StepView,
		ProductProgressView,
		StatisticanInfoView,
		ElementFlowView,
		InstitutionalTreeView,
	},
})
export default class MainView extends Vue {
	groupTaskStepList: {
		code: string
		name: string
		stepList: { index: number; name: string; state: number }[]
	}[] = []
	groupStepList: { index: number; name: string; stepList: { title: string; desc: string }[] }[] =
		[
			// {
			// 	index: 1,
			// 	stepList: [
			// 		{ title: '步骤1', desc: '国家级产生预报产品' },
			// 		{ title: '步骤2', desc: '融合海区预报产品' },
			// 		{ title: '步骤3', desc: '国家级订正产品' },
			// 	],
			// },
			// {
			// 	index: 1,
			// 	stepList: [
			// 		{ title: '步骤1', desc: '获取海区级预报产品并切分' },
			// 		{ title: '步骤2', desc: '产出省级预报产品' },
			// 	],
			// },
		]

	// 对应四个统计form的统计对象
	// 机构数量
	GroupStatisticalData: IInfo = {
		mimor: '机构数量',
		primay: '0',
	}

	// 产品数量
	ProductStatisticalData: IInfo = {
		mimor: '产品数量',
		primay: '5',
	}

	// 产品种类数量
	ProductTypeStatisticalData: IInfo = {
		mimor: '产品种类数量',
		primay: '0',
	}

	// 文件总数
	FileStatisticalData: IInfo = {
		mimor: '文件总数',
		primay: '21',
	}

	// 当日文件总数
	DailyStatisticalData: IInfo = {
		mimor: '当日文件总数',
		primay: '0',
	}

	nearlyStatisticsList: { count: number; size: number; typeCount: number; dt: Date }[] = []

	/** 加载当前全部机构的作业状态 */
	loadAllGroupTaskStep() {
		const now = new Date()
		const groups = [GroupEnum.NMF, GroupEnum.PZJ]

		const codes = groups.map((temp) => {
			return temp.toString()
		})
		return getTaskByGroup({ codes: codes, dt: now }).then((res) => {
			if (res.status === 200) {
				/*
						0:
							code: "1001"
							name: "国家海洋环境预报中心"
							step: Array(3)
							0: {step_index: 1, step_name: '指导产品上传', step_state: 9003}
							1: {step_index: 2, step_name: '融合产品上传', step_state: 9002}
							2: {step_index: 3, step_name: '订正产品上传', step_state: 9002}
							length: 3
							[[Prototype]]: Array(0)
							[[Prototype]]: Object
						1: {code: '1002', name: '浙江省台', step: Array(1)}
					*/
				let groupStepList: {
					index: number
					name: string
					stepList: { title: string; desc: string }[]
				}[] = []
				res.data.forEach(
					(element: {
						group_code: string
						group_name: string
						step_list: {
							step_index: number
							step_name: string
							step_state: StepStateEnum
						}[]
					}) => {
						let stepIndex: number = filterStepState(element.step_list)
						let stepList: { title: string; desc: string }[] = []

						element.step_list.forEach((temp) => {
							let stepDesc = ''
							switch (true) {
								case temp.step_state === StepStateEnum.SUCCESS:
									stepDesc = '已完成'
									break
								case temp.step_state === StepStateEnum.WAIT:
									stepDesc = '要素不全'
									break
								default:
									stepDesc = '未完成'
									break
							}
							let stepTemp = {
								title: `步骤:${temp.step_index}`,
								desc: `${temp.step_name}:${stepDesc}`,
							}
							stepList.push(stepTemp)
						})
						groupStepList.push({
							name: element.group_name,
							index: stepIndex,
							stepList: stepList,
						})
					}
				)
				return groupStepList
			}
		})
		// .then((resStepList) => {
		// 	console.log(resStepList)
		// })

		// return []
	}

	load7DaysStatisticsList() {
		const that = this
		getNearlyProductInfo().then(
			(res: {
				status: number
				data: {
					file_count: number
					files_size: number
					file_type_count: number
					dt: string
				}[]
			}) => {
				if (res.status === 200) {
					/*
				   [{file_count: '0', files_size: '0 GB', file_type_count: '0', dt: '2022-08-21'},
				 	{file_count: '4', files_size: '0.3 GB', file_type_count: '1', dt: '2022-08-18'}
				   ]
				*/
					console.log(res.data)
					that.nearlyStatisticsList = []
					res.data.forEach((tempDailyStatics) => {
						that.nearlyStatisticsList.push({
							count: tempDailyStatics.file_count,
							size: tempDailyStatics.files_size,
							typeCount: tempDailyStatics.file_type_count,
							dt: new Date(tempDailyStatics.dt),
						})
					})
				}
			}
		)
	}

	mounted() {
		const that = this
		// 获取机构总数
		getGroupCount().then(
			(res: {
				status: number
				data: {
					group_code: string
					group_name: string
				}[]
			}) => {
				that.GroupStatisticalData.primay =
					res.data !== undefined ? res.data.length.toString() : '0'
			}
		)
		// 获取产品总数
		getAllProduct().then(
			(res: {
				status: number
				data: {
					product_code: string
					product_name: string
				}[]
			}) => {
				that.ProductTypeStatisticalData.primay =
					res.data !== undefined ? res.data.length.toString() : '0'
			}
		)
		// 获取产品种类总数
		// 获取当日文件总数
		getProductDailyInfo()
			.then((res: { status: number; data: { file_count: number; files_size: number } }) => {
				that.DailyStatisticalData.primay =
					res.data !== undefined && res.data.file_count !== undefined
						? res.data.file_count.toString()
						: '0'
			})
			.catch()
		this.loadAllGroupTaskStep().then((res) => {
			if (res !== undefined) {
				// console.log(res)
				this.groupStepList = res
			}
		})
		this.load7DaysStatisticsList()
	}
}
</script>
<style scoped lang="less">
.main-content {
	display: flex;
	flex: 22;
	flex-direction: column;
	background: linear-gradient(rgb(70, 85, 129), rgb(49, 59, 89));
	position: absolute;
	left: 0px;
	right: 0px;
	height: 100%;
	align-items: center;
}
.my-row {
	background: #0a3d625e;
	width: 80%;
	margin: 10px;
	display: flex;
	// height: 20%;
	display: flex;
	align-items: center;
	justify-content: center;
	border-radius: 10px;
}
.my-statics-form {
	display: flex;
	flex-grow: 3;
	// background: rgb(53, 171, 116);
	height: 90%;
	margin: 8px;
}
.my-histogran {
	display: flex;
	flex-grow: 8;
	background: rgb(58, 202, 180);
	height: 90%;
	margin: 8px;
}
.height-2 {
	height: 20%;
}
</style>
