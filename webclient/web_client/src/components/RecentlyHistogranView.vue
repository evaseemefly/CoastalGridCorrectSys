<template>
	<div id="recently_histogran"></div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
import * as echarts from 'echarts'
@Component({})
export default class RecentlyHistogranView extends Vue {
	mydata: any = null

	dtList: Date[] = []

	fileCountList: number[] = []

	@Prop(Array)
	nearlyStatisticsList: { count: number; size: number; typeCount: number; dt: Date }[] = []

	mounted() {
		let dom = document.getElementById('recently_histogran')
		const that = this

		that.nearlyStatisticsList.forEach((temp) => {
			that.dtList.push(temp.dt)
			that.fileCountList.push(temp.count)
		})
		if (dom !== null) {
			// 基于准备好的dom，初始化echarts实例
			var myChart = echarts.init(dom)
			// 绘制图表
			myChart.setOption({
				title: {
					text: '近7日数据量',
				},
				grid: {
					left: '5%',
					right: '5%',
					top: '5%',
					bottom: '15%',
				},
				tooltip: {},
				xAxis: {
					data: that.dtList,
				},
				yAxis: {},
				series: [
					{
						name: '数据量',
						type: 'line',
						data: that.fileCountList,
					},
				],
				lineStyle: { color: '#f6b93b' },
			})
		}
	}
}
</script>
<style scoped lang="less">
#recently_histogran {
	height: 100%;
	width: 100%;
}
</style>
