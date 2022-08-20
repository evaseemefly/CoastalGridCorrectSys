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
		<div class="my-row height-2">
			<RecentlyHistogranView
				:nearlyStatisticsList="nearlyStatisticsList"
			></RecentlyHistogranView>
		</div>
		<div class="my-row height-2" :key="step.key" v-for="step in groupStepList">
			<StepView :activedStepIndex="step.index" :stepList="step.stepList"></StepView>
		</div>
		<!-- <div class="my-row height-2"><StepView></StepView></div> -->
	</div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'

// 组件
import RecentlyHistogranView from '@/components/RecentlyHistogranView.vue'
import StepView from '@/components/StepView.vue'
import ProductProgressView from '@/components/ProductProgressView.vue'
// import StatisticanInfoView from '@/components/StatisticanInfoView.vue'
import StatisticanInfoView from '@/components/StatisticaInfoView.vue'
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
import { GroupEnum } from '@/enum'
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
	},
})
export default class MainView extends Vue {
	groupTaskStepList: {
		code: string
		name: string
		stepList: { index: number; name: string; state: number }[]
	}[] = []
	groupStepList: { index: number; stepList: { title: string; desc: string }[] }[] = [
		{
			index: 1,
			stepList: [
				{ title: '步骤1', desc: '国家级产生预报产品' },
				{ title: '步骤2', desc: '融合海区预报产品' },
				{ title: '步骤3', desc: '国家级订正产品' },
			],
		},
		{
			index: 1,
			stepList: [
				{ title: '步骤1', desc: '获取海区级预报产品并切分' },
				{ title: '步骤2', desc: '产出省级预报产品' },
			],
		},
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

	nearlyStatisticsList: { count: number; size: number; typeCount: number; dt: Date }[] = [
		{ count: 5, size: 12, typeCount: 4, dt: new Date() },
		{ count: 6, size: 12, typeCount: 4, dt: new Date() },
		{ count: 7, size: 12, typeCount: 4, dt: new Date() },
		{ count: 5, size: 12, typeCount: 4, dt: new Date() },
	]

	async loadAllGroupTaskStep(): Promise<{ code: string; name: string; step: number }[]> {
		const now = new Date()
		const groups = [GroupEnum.NMF, GroupEnum.PZJ]
		let groupStepList: { code: string; name: string; step: number }[] = []
		const codes = groups.map((temp) => {
			return temp.toString()
		})
		await getTaskByGroup({ codes: codes, dt: now }).then((res) => {
			if (res.status === 200) {
				res.data.forEach((element) => {
					let tempGroupStep = {
						code: element.group_code,
						name: element.group_name,
						step: element.step_list,
					}
					groupStepList.push(tempGroupStep)
				})
			}
		})

		return groupStepList
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
		getProductDailyInfo().then(
			(res: { status: number; data: { files_count: number; files_size: number } }) => {
				that.DailyStatisticalData.primay =
					res.data !== undefined ? res.data.files_count.toString() : '0'
			}
		)
		this.loadAllGroupTaskStep().then((res) => {
			console.log(res)
		})
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
