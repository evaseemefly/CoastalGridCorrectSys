<template>
	<div id="recently_histogran"></div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
import * as echarts from 'echarts'
import { fortmatDate2YMD } from '@/filter'
@Component({})
export default class RecentlyHistogranView extends Vue {
	dtList: Date[] = []
	dtStrList: string[] = []

	fileCountList: number[] = []

	@Prop(Array)
	nearlyStatisticsList: { count: number; size: number; typeCount: number; dt: Date }[]

	get get7DaysStatisticsList(): { count: number; size: number; typeCount: number; dt: Date }[] {
		return [...this.nearlyStatisticsList]
	}

	@Watch('get7DaysStatisticsList')
	on7DaysStatisticsList(
		val: { count: number; size: number; typeCount: number; dt: Date }[]
	): void {
		console.log(`监听到7days统计传入发声变化:${val}`)
		this.initChart()
	}

	initChart(): void {
		let dom = document.getElementById('recently_histogran')
		const that = this
		this.dtList = []
		this.dtStrList = []
		this.fileCountList = []
		that.nearlyStatisticsList.forEach((temp) => {
			const dtStr = fortmatDate2YMD(temp.dt)
			// that.dtList.push(temp.dt)
			that.dtStrList.push(dtStr)
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
					data: that.dtStrList,
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

	mounted() {
		this.initChart()
	}
}
</script>
<style scoped lang="less">
#recently_histogran {
	height: 100%;
	width: 100%;
}
</style>
