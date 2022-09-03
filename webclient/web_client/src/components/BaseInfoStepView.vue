<template>
	<div class="base-info-step-container" :class="[getSuitedCls()]" :style="{ order: sort }">
		<div class="base-info-header">{{ name }}</div>
		<div class="base-info-body">
			<div class="body-primary-title">{{ desc }}</div>
			<div class="body-sub-content">
				<div class="sub-content-header">
					{{ getSuitVal() }}
				</div>
				<div class="sub-content-footer">{{ formatDt2YMDHm(lastDt) }}</div>
			</div>
		</div>
	</div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
import { StateEnum } from '@/enum'
@Component({})
export default class BaseInfoStepView extends Vue {
	@Prop()
	state: number

	@Prop()
	name: string
	@Prop()
	desc: string
	@Prop()
	lastDt: Date

	@Prop()
	sort: number

	getSuitedCls(): string {
		const state = this.state
		let clsName = ''
		switch (state) {
			case StateEnum.NULL:
				clsName = ''
				break
			case StateEnum.SUITED:
				clsName = 'suited'
				break
			case StateEnum.UNSUITED:
				clsName = 'un-suited'
				break
		}
		return clsName
	}

	getSuitVal(): string {
		const state = this.state
		let val = ''
		val = state === StateEnum.SUITED ? '完成' : '未完成'
		return val
	}

	formatDt2YMDHm = (val: Date): string => {
		const dtStr = `${val.getFullYear()}-${val.getMonth()}-${val.getDate()} ${(
			'0' + val.getHours()
		).slice(-2)}:${('0' + val.getMinutes()).slice(-2)}`
		return dtStr
	}
}
</script>
<style scoped lang="less">
.base-info-step-container {
	display: flex;
	flex-direction: column;
	background: #293140bf;
	border-radius: 5px;
	justify-content: center;
	align-content: flex-start;
	align-content: flex-start;
	padding: 8px;
	width: 120px;
	.base-info-header {
		height: 20px;
		color: rgba(245, 163, 69, 0.897);

		// margin: 10px;
		font-size: 16px;
		font-weight: 600;
		display: flex;
		justify-content: flex-start;
		margin-top: 3px;
		margin-bottom: 5px;

		text-shadow: 2px 2px 3px #212020;
	}
	.base-info-body {
		display: flex;
		flex-direction: column;
		.body-primary-title {
			color: rgb(167, 175, 182);
			height: 20px;
			display: flex;
			justify-content: flex-start;
			font-size: 15px;
		}
		.body-sub-content {
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-content: flex-start;
			.sub-content-header {
				color: rgb(47, 155, 62);
				font-size: 20px;
				display: flex;
				justify-content: flex-start;
				font-size: 18px;
				font-weight: 600;
				margin-top: 5px;
				margin-bottom: 5px;

				text-shadow: 2px 2px 3px #212020;
			}
			.sub-content-footer {
				color: white;
				display: flex;
				justify-content: flex-start;
				font-size: 12px;
			}
		}
	}
}
.suited {
	background: #78db1b;
	.base-info-body {
		.body-sub-content {
			.sub-content-header {
				color: white;
			}
		}
	}
}
.un-suited {
	background: #267445;
}
#test {
	color: #075a56;
	color: white;
}
</style>
