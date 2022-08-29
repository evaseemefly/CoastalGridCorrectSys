<template>
	<div id="main_nighting"></div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
import * as echarts from 'echarts'
@Component({})
export default class InstitutionalNightingaleView extends Vue {
	mydata: any = null
	mounted() {
		this.initCharts()
	}
	initCharts(): void {
		var chartDom = document.getElementById('main_nighting')
		var myChart = echarts.init(chartDom)
		var option

		option = {
			legend: {
				orient: 'vertical',
				left: '20',
                itemStyle:{
                    // color:'white'
                    
                },
                textStyle:{
                    color:'white'
                }
			},
			grid: {
				// show: true,
				top: '0px',
				left: '-100px',
				right: '-100px',
				bottom: '0px',
			},
			series: [
				{
					name: 'Nightingale Chart',
					type: 'pie',
					radius: [30, 90],
					center: ['70%', '50%'],
					roseType: 'area',
					itemStyle: {
						borderRadius: 8,
					},
					label: {
						show: false,
					},
					emphasis: {
						label: {
							show: true,
						},
					},
					data: [
						{ value: 40, name: 'L0-国家级指导产品' },
						{ value: 38, name: 'L1-浙江省人机交互订正后产品' },
						{ value: 32, name: 'L2-海区内所有省的订正场融合产品' },
						{ value: 30, name: 'L3-海区级人机交互订正后产品' },
						{ value: 28, name: 'L4-三个海区融合产品' },
						{ value: 26, name: 'L5-国家中心人机交互订正后产品' },
					],
				},
			],
		}

		option && myChart.setOption(option)
	}
}
</script>
<style scoped lang="less">
#main_nighting {
	width: 500px;
	height: 200px;
}
</style>
