<template>
	<div class="main-content">
		<div class="my-row my-row-1">
			<div class="my-row-title">
				主要统计信息<el-date-picker
					id="el_data_picker"
					v-model="currentForecastDt"
					size="mini"
					type="datetime"
					placeholder="预报时间"
					format="yyyy-MM-dd HH"
					selectableRange="['06:00','18:00']"
				>
				</el-date-picker>
			</div>
			<div class="my-row-content">
				<div class="my-statics-form">
					<StatisticanInfoView
						:minorTitle="FileStatisticalData.mimor"
						:primayTile="FileStatisticalData.primay"
						:primayColor="FileStatisticalData.primayColor"
					></StatisticanInfoView>
				</div>
				<div class="my-statics-form">
					<StatisticanInfoView
						:minorTitle="DailyStatisticalData.mimor"
						:primayTile="DailyStatisticalData.primay"
						:primayColor="DailyStatisticalData.primayColor"
					></StatisticanInfoView>
				</div>
				<div class="my-statics-form">
					<StatisticanInfoView
						:minorTitle="GroupStatisticalData.mimor"
						:primayTile="GroupStatisticalData.primay"
						:primayColor="GroupStatisticalData.primayColor"
					></StatisticanInfoView>
				</div>

				<div class="my-statics-form">
					<StatisticanInfoView
						:minorTitle="ProductTypeStatisticalData.mimor"
						:primayTile="ProductTypeStatisticalData.primay"
						:primayColor="ProductTypeStatisticalData.primayColor"
					></StatisticanInfoView>
				</div>
				<div class="my-statics-form">
					<StatisticanInfoView
						:minorTitle="FileAllSizeStatisticalData.mimor"
						:primayTile="FileAllSizeStatisticalData.primay"
						:primayColor="FileAllSizeStatisticalData.primayColor"
					></StatisticanInfoView>
				</div>
				<!-- <div class="my-histogran">
				<ProductProgressView></ProductProgressView>
			</div> -->
			</div>
		</div>
		<div class="my-row main-statistics-content my-row-4">
			<div class="my-row-title">作业流程进度</div>
			<div class="my-row-content">
				<div class="main-element-flow my-col-4">
					<ElementTabView
						:elementTypes="elementTypes"
						:selectedElement="selectedElementCode"
						@childSelectedCode="
							(val) => {
								selectedElementCode = val
							}
						"
					></ElementTabView>
					<ElementFlowView
						:elementName="selectedElementName"
						:elementType="selectedElementCode"
						:forecastDt="currentForecastDt"
					></ElementFlowView>
				</div>
				<div class="main-institutional-tree my-col-2">
					<div class="institutional-col-item">
						<!-- <InstitutionalTreeView></InstitutionalTreeView> -->
						<InstitutionalNightingaleView></InstitutionalNightingaleView>
					</div>
					<div class="institutional-col-item">
						<div>
							<RecentlyHistogranView
								:nearlyStatisticsList="nearlyStatisticsList"
							></RecentlyHistogranView>
						</div>
						<div>
							<ElementProgressView
								:elementName="selectedElementName"
								:elementType="selectedElementCode"
								:forecastDt="currentForecastDt"
							></ElementProgressView>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="my-row my-row-1 horizontal">
			<div class="my-row-title">总体流程及文件监听详情</div>
			<div class="my-row-content">
				<div class="my-col-4 horizontal space-between">
					<BaseInfoStepsView :forecastDt="currentForecastDt"></BaseInfoStepsView>
					<!-- <BaseInfoStepView
						v-for="item in baseStepList"
						:key="item.key"
						:headTitle="item.headTitle"
						:primaryTitle="item.primaryTitle"
						:subHeader="item.subHeader"
						:subFooter="item.subFooter"
						:borderColor="item.borderColor"
						:titleColor="item.titleColor"
					>
					</BaseInfoStepView> -->
				</div>
				<div class="my-col-2" style="">
					<LastModifyFieListView primaryTitle="最近文件"></LastModifyFieListView>
				</div>
			</div>
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
import InstitutionalNightingaleView from '@/components/InstitutionalNightingaleView.vue'
import ElementProgressView from '@/components/ElementProgressView.vue'
import ElementTabView from '@/components/ElementTabView.vue'
import BaseInfoProgressView from '@/components/BaseInfoProgressView.vue'
import BaseInfoStepView from '@/components/BaseInfoStepView.vue'
import BaseInfoStepsView from '@/components/BaseInfoStepsView.vue'
import LastModifyFieListView from '@/components/LastModifyFileListView.vue'

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
import { GroupEnum, StepStateEnum, ElementTypeEnum } from '@/enum'
// common 与 filter
import { filterStepState } from '@/filter'
interface IInfo {
	mimor: string
	primay: string
	primayColor: string
}
@Component({
	components: {
		RecentlyHistogranView,
		StepView,
		ProductProgressView,
		StatisticanInfoView,
		ElementFlowView,
		InstitutionalTreeView,
		InstitutionalNightingaleView,
		ElementProgressView,
		BaseInfoProgressView,
		LastModifyFieListView,
		BaseInfoStepView,
		ElementTabView,
		BaseInfoStepsView,
	},
})
export default class MainView extends Vue {
	groupTaskStepList: {
		code: string
		name: string
		stepList: { index: number; name: string; state: number }[]
	}[] = []
	groupStepList: { index: number; name: string; stepList: { title: string; desc: string }[] }[] =
		[]

	elementTypes: { index: number; name: string; code: ElementTypeEnum }[] = [
		{
			index: 0,
			name: '海面风',
			code: ElementTypeEnum.SSW,
		},
		{
			index: 1,
			name: '海浪',
			code: ElementTypeEnum.WAV,
		},
		{
			index: 2,
			name: '海流',
			code: ElementTypeEnum.OCU,
		},
		{
			index: 3,
			name: '海表面温度',
			code: ElementTypeEnum.SST,
		},
	]

	selectedElementCode: ElementTypeEnum = ElementTypeEnum.SSW

	selectedElementName = '海面风'

	nowDt: Date = new Date()

	currentForecastDt: Date = new Date()

	// 对应四个统计form的统计对象
	// 机构数量
	GroupStatisticalData: IInfo = {
		mimor: '机构数量',
		primay: '0',
		// primayColor: '#f6b93b',
		primayColor: '#78db1b',
	}

	// 产品数量
	ProductStatisticalData: IInfo = {
		mimor: '产品数量',
		primay: '0',
		// primayColor: '#e55039',
		primayColor: '#78db1b',
		// primayColor: '#f6b93b',
	}

	// 产品种类数量
	ProductTypeStatisticalData: IInfo = {
		mimor: '产品种类数量',
		primay: '0',
		// primayColor: '#6a89cc',
		primayColor: '#78db1b',
		// primayColor: '#f6b93b',
	}

	// 文件总数
	FileStatisticalData: IInfo = {
		mimor: '文件总数',
		primay: '0',
		primayColor: '#82ccdd',
		// primayColor: '#f6b93b',
	}

	// 当日文件总数
	DailyStatisticalData: IInfo = {
		mimor: '当日文件总数',
		primay: '0',
		// primayColor: '#78e08f',
		primayColor: '#82ccdd',
		// primayColor: '#f6b93b',
	}
	FileAllSizeStatisticalData: IInfo = {
		mimor: '文件总大小',
		primay: '0',
		// primayColor: '#78e08f',
		primayColor: '#78db1b',
	}
	baseStepList: {
		headTitle: string
		primaryTitle: string
		subHeader: string
		subFooter: string
		borderColor: string
		titleColor: string
	}[] = [
		{
			headTitle: '国家中心',
			primaryTitle: '国家级指导产品',
			subHeader: '完成',
			subFooter: '2022-08-29 10:00',
			borderColor: '#78db1b',
			titleColor: 'white',
		},
		{
			headTitle: '省级',
			primaryTitle: '交互订正后产品',
			subHeader: '完成',
			subFooter: '2022-08-29 10:00',
			borderColor: '#78db1b',
			titleColor: 'white',
		},
		{
			headTitle: '海区级',
			primaryTitle: '订正场融合产品',
			subHeader: '完成',
			subFooter: '2022-08-29 10:00',
			borderColor: '#78db1b',
			titleColor: 'white',
		},
		{
			headTitle: '海区级',
			primaryTitle: '人机订正后产品',
			subHeader: '未完成',
			subFooter: '2022-08-29 10:00',
			borderColor: '#f6b93b',
			titleColor: 'white',
		},
		{
			headTitle: '国家中心',
			primaryTitle: '三个海区融合产品',
			subHeader: '完成',
			subFooter: '2022-08-29 10:00',
			borderColor: '#78db1b',
			titleColor: 'white',
		},
		{
			headTitle: '国家中心',
			primaryTitle: '人机订正后产品',
			subHeader: '未完成',
			subFooter: '2022-08-29 10:00',
			borderColor: '#f6b93b',
			titleColor: 'white',
		},
	]

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
		getProductMain().then(
			(res: {
				status: number
				data: {
					forecast_issurer_count: number
					forecast_product_count: number
					forecast_product_size: number
				}
			}) => {
				this.FileStatisticalData.primay = res.data.forecast_product_count.toString()
				this.GroupStatisticalData.primay = res.data.forecast_issurer_count.toString()
				this.FileAllSizeStatisticalData.primay = `${res.data.forecast_product_size.toFixed(
					2
				)}GB`
			}
		)
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
		this.currentForecastDt = this.convertNow2ForecastDt(this.nowDt)
	}
	convertNow2ForecastDt(val: Date): Date {
		const now = val
		const nowHours = now.getHours()
		let forecastDt: Date = new Date(now.getFullYear(), now.getMonth(), now.getDate(), 8, 0)
		if (nowHours >= 18) {
			forecastDt = new Date(now.getFullYear(), now.getMonth(), now.getDate(), 20, 0)
		}
		return forecastDt
	}

	@Watch('nowDt')
	onNowDt(val: Date): void {
		this.currentForecastDt = this.convertNow2ForecastDt(val)
	}

	@Watch('selectedElementCode')
	onSelectedEleCode(code: ElementTypeEnum): void {
		const query = this.elementTypes.filter((temp) => {
			return temp.code === code
		})
		if (query.length > 0) {
			this.selectedElementName = query[0].name
		}
	}
}
</script>
<style scoped lang="less">
.main-content {
	display: flex;
	flex: 22;
	flex-direction: column;
	background: linear-gradient(#4b6584, rgb(49, 59, 89));
	position: absolute;
	left: 0px;
	top: 0px;
	right: 0px;
	// height: 100%;
	bottom: 0px;
	align-items: center;
	.main-statistics-content {
		// height: 100%;
		.main-element-flow {
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			height: 100%;
		}
		.main-institutional-tree {
			height: 100%;
			display: flex;
			flex-direction: column;
			margin-right: 20px;
			border-radius: 10px;
			overflow: hidden;
			.institutional-col-item {
				flex-grow: 1;
				background: #1243445e;
				display: flex;
				flex-direction: row;
				justify-content: center;
				align-content: center;
				align-items: center;
				div {
					height: 95%;
				}
			}
			// .institutional-col-item :nth-child(2) {

			// }
		}
		.main-institutional-tree > .institutional-col-item:nth-child(2) {
			// background: green;
			display: flex;

			div {
				flex-grow: 1;
				// background: red;
				// height: 100%;
				width: 100%;
				height: 270px;
				// background: #3b76a15e;
				margin: 10px;
			}
		}
	}
}

.horizontal {
	display: flex;
	flex-direction: row;
}
.my-row-1 {
	flex-grow: 1;
	// height: 100%;
}
.my-row-4 {
	flex-grow: 3;
}
.my-col-4 {
	flex-grow: 4;
}
.my-col-3 {
	flex-grow: 3;
	// width: 100%;
	// height: 100%;
}
.my-col-2 {
	flex-grow: 2;
	// width: 100%;
	// height: 100%;
}
.my-col-1 {
	flex-grow: 1;
}

.main-statistics-content {
	display: flex;
}
.my-row {
	background: #0a3d625e;
	width: 80%;
	// height: 100%;
	margin: 5px;
	display: flex;
	flex-direction: column;
	border-radius: 10px;
	.my-row-title {
		min-height: 30px;
		color: white;
		display: flex;
		align-content: center;
		align-items: center;
		justify-content: space-between;
		margin-left: 50px;
		font-size: 20px;
		font-weight: bold;
	}
	.my-row-content {
		display: flex;
		align-items: center;
		justify-content: center;
	}
}
.el-date-editor {
	width: 150px !important;
	margin: 5px;
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
.space-between {
	justify-content: space-between !important;
}
</style>
