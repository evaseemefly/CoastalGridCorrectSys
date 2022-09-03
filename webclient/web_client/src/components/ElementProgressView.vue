<template>
	<div id="ele_progress">
		<div class="progress-title">今日{{ elementName }}作业进度</div>
		<el-progress type="circle" :percentage="rate" :color="colors"></el-progress>
	</div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
// enmu
import { ElementTypeEnum } from '@/enum'
// api
import { getElmentRate } from '@/api'
@Component({})
export default class ElementProgressView extends Vue {
	@Prop(Number)
	elementType: ElementTypeEnum

	@Prop(String)
	elementName: string

	@Prop(Date)
	forecastDt: Date

	rate = 0

	colors = [
		{ color: '#f56c6c', percentage: 20 },
		{ color: '#e6a23c', percentage: 40 },
		// { color: '#5cb87a', percentage: 60 },
		{ color: 'rgb(130, 204, 221)', percentage: 80 },
		{ color: '#78db1b', percentage: 100 },
	]

	// status = ''

	get watchOpt(): { elementType: ElementTypeEnum; forecastDt: Date } {
		const { elementType, forecastDt } = this

		return { elementType, forecastDt }
	}

	@Watch('watchOpt')
	onEleType(val: { elementType: ElementTypeEnum; forecastDt: Date }): void {
		// console.log(val)
		const self = this
		getElmentRate(val.elementType, new Date(), val.forecastDt).then((res) => {
			if (res.status === 200) {
				// console.log(res.data)
				if (res.data.rate) {
					self.rate = res.data.rate * 100
				} else {
					self.rate = 0
				}
			}
		})
	}

	get status(): string {
		let status = ''
		if (this.rate === 0) {
			status = 'exception'
		} else if (this.rate < 50) {
			status = ''
		} else if (this.rate === 100) {
			status = 'success'
		}
		return status
	}

	get statusColor(): string {
		let color = ''
		if (this.rate < 50) {
			color = 'gb(130, 204, 221);'
		} else if (this.rate === 100) {
			color = '#78db1b'
		}
		return color
	}
}
</script>
<style scoped lang="less">
#ele_progress {
	height: 90%;
	width: 90%;
	.progress-title {
		height: 50px;
		color: white;
	}
	// display: flex;
	// flex-direction:column ;
}
</style>
