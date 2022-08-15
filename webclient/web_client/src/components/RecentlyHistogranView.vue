<template>
	<div id="recently_histogran"></div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
import * as echarts from 'echarts'
@Component({})
export default class RecentlyHistogranView extends Vue {
	mydata: any = null
	mounted() {
		let dom = document.getElementById('recently_histogran')
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
					data: ['8-13', '8-14', '8-15', '8-16', '8-17', '8-18', '8-19'],
				},
				yAxis: {},
				series: [
					{
						name: '数据量',
						type: 'line',
						data: [5, 20, 36, 10, 10, 20,21],
					},
				],
				lineStyle: { color: '#f6b93b' },
			})
		}
	}
	get computedTest() {
		return null
	}
}
</script>
<style scoped lang="less">
#recently_histogran {
	height: 100%;
	width: 100%;
}
</style>
