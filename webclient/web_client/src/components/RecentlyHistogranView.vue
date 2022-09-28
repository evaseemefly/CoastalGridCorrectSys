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

	sortDt(desc = false): { count: number; size: number; typeCount: number; dt: Date }[] {
		let sourceDtList: { count: number; size: number; typeCount: number; dt: Date }[] =
			this.get7DaysStatisticsList
		let sortedDtList: { count: number; size: number; typeCount: number; dt: Date }[] =
			sourceDtList.sort((a, b) => {
				if (desc) {
					return b.dt - a.dt
				} else {
					return a.dt - b.dt
				}
			})
		return sortedDtList
	}

	@Watch('get7DaysStatisticsList')
	on7DaysStatisticsList(
		val: { count: number; size: number; typeCount: number; dt: Date }[]
	): void {
		// console.log(`监听到7days统计传入发声变化:${val}`)
		this.initChart()
	}

	initChart(): void {
		let dom = document.getElementById('recently_histogran')
		const that = this
		this.dtList = []
		this.dtStrList = []
		this.fileCountList = []
		const nearlyStatisticsList = this.sortDt(false)

		nearlyStatisticsList.forEach((temp) => {
			const dtStr = fortmatDate2YMD(temp.dt)
			// that.dtList.push(temp.dt)
			that.dtStrList.push(dtStr)
			that.fileCountList.push(temp.count)
		})

		if (dom !== null) {
			// 基于准备好的dom，初始化echarts实例
			var myChart = echarts.init(dom)
			// 绘制图表
			// 暂时不使用 line,使用 bar
			const option = {
				title: {
					text: '近7日数据量',
					textStyle: {
						color: 'white',
					},
				},
				grid: {
					left: '8%',
					right: '5%',
					top: '5%',
					bottom: '15%',
				},
				tooltip: {},
				xAxis: {
					data: that.dtStrList,
				},
				yAxis: {
					splitLine: {
						show: false,
					},
				},
				series: [
					{
						name: '数据量',
						type: 'line',
						data: that.fileCountList,
					},
				],
				// lineStyle: { color: '#f6b93b' },
				lineStyle: { color: '#78db1b' },
				// lineStyle: { color: 'rgb(44, 221, 212)' },
			}
			// const option = {
			// 	tooltip: {
			// 		trigger: 'axis',
			// 		axisPointer: {
			// 			type: 'shadow',
			// 		},
			// 	},
			// 	grid: {
			// 		left: '3%',
			// 		right: '4%',
			// 		bottom: '1%',
			// 		containLabel: true,
			// 	},
			// 	xAxis: [
			// 		{
			// 			type: 'category',
			// 			data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
			// 			axisTick: {
			// 				alignWithLabel: true,
			// 			},
			// 		},
			// 	],
			// 	yAxis: [
			// 		{
			// 			type: 'value',
			// 		},
			// 	],
			// 	series: [
			// 		{
			// 			name: 'Direct',
			// 			type: 'bar',
			// 			itemStyle: {
			// 				color: '#38ada9',
			// 			},
			// 			barWidth: '60%',
			// 			data: [10, 52, 200, 334, 390, 330, 220],
			// 		},
			// 	],
			// }
			// const element = document.getElementById('recently_histogran')
			// setTimeout(() => {
			// 	// 基于准备好的dom，初始化echarts实例
			// 	const myChart = echarts.init(element, '', {
			// 		width: document.getElementById('recently_histogran')?.offsetWidth,
			// 		height: document.getElementById('recently_histogran')?.offsetHeight,
			// 	})
			// 	// 绘制图表
			// 	option && myChart.setOption(option)
			// }, 0)

			option && myChart.setOption(option)
		}
	}

	mounted() {
		this.initChart()
	}
}
</script>
<style scoped lang="less">
#recently_histogran {
	// height: 100%;
	width: 90%;
	height: 250px;
	// width: 260px;
}
</style>
