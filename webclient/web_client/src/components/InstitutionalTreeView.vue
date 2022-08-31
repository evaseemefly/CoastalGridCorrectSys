<template>
	<div id="main_tree"></div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
import * as echarts from 'echarts'
@Component({})
export default class InstitutionalTreeView extends Vue {
	mounted() {
		this.initCharts()
	}
	initCharts(): void {
		type EChartsOption = echarts.EChartsOption

		var chartDom = document.getElementById('main_tree')!
		var myChart = echarts.init(chartDom)
		var option: EChartsOption

		var data = [
			{
				name: '国家级',
				children: [
					{
						name: '国家预报中心',
						value: 30,
					},
				],
			},
			{
				name: '北海区',
				value: 10,
				// children: [
				// 	{
				// 		name: '北海预报中心',
				// 		value: 15,
				// 	},
				// ],
			},
			{
				name: '东海区',
				children: [
					{
						name: '东海预报中心',
						value: 15,
					},
					{
						name: '省级预报台',
						children: [
							{
								name: '浙江省台',
								value: 15,
							},
							{
								name: '江苏省台',
								value: 15,
							},
						],
					},
				],
			},
			{
				name: '南海区',
				value: 10,
				// children: [
				// 	{
				// 		name: '南海预报中心',
				// 		value: 15,
				// 	},
				// ],
			},
		]

		option = {
			series: {
				type: 'sunburst',
				// emphasis: {
				//     focus: 'ancestor'
				// },
				data: data,
				radius: [60, '90%'],
				itemStyle: {
					borderRadius: 7,
					borderWidth: 2,
				},
				label: {
					rotate: 'radial',
				},
			},
			legend: {
				top: 'bottom',
			},
		}

		option && myChart.setOption(option)
	}
}
</script>
<style scoped lang="less">
#main_tree {
	// width: 90%;
	width: 90%;
	height: 300px;
}
</style>
