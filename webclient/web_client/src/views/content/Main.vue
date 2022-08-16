<template>
	<div class="main-content">
		<div class="my-row">
			<div class="my-statics-form">
				<StatisticanInfoView
					minorTitle="测试标题1"
					primayTile="测试主内容1"
				></StatisticanInfoView>
			</div>
			<div class="my-statics-form">
				<StatisticanInfoView
					minorTitle="测试标题1"
					primayTile="测试主内容1"
				></StatisticanInfoView>
			</div>
			<div class="my-statics-form">
				<StatisticanInfoView
					minorTitle="测试标题1"
					primayTile="测试主内容1"
				></StatisticanInfoView>
			</div>
			<div class="my-statics-form">
				<StatisticanInfoView
					minorTitle="测试标题1"
					primayTile="测试主内容1"
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
import { getTaskByGroup, getGroupCount } from '@/api'
// enmu
import { GroupEnum } from '@/enum'
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
	groupStepList: { index: number; stepList: { title: string; desc: string }[] }[] = []
	nearlyStatisticsList: { count: number; size: number; typeCount: number; dt: Date }[] = []

	loadAllGroupTaskStep() {
		const now = new Date()
		const groups = [GroupEnum.NMF]
		let groupStepList = []
		return groups.forEach((tempGroup) => {
			getTaskByGroup({ code: tempGroup.toString(), dt: now }).then((res) => {
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
				return groupStepList
			})
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
