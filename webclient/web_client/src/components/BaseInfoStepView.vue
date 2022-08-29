<template>
	<div class="base-info-step-container" :style="{ 'background-color': borderColor }">
		<div class="base-info-header">{{ headTitle }}</div>
		<div class="base-info-body">
			<div class="body-primary-title">{{ primaryTitle }}</div>
			<div class="body-sub-content">
				<div class="sub-content-header" :style="{ color: titleColor }">{{ subHeader }}</div>
				<div class="sub-content-footer">{{ subFooter }}</div>
			</div>
		</div>
	</div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
@Component({})
export default class BaseInfoStepView extends Vue {
	@Prop()
	headTitle: string
	@Prop()
	primaryTitle: string
	@Prop()
	subHeader: string
	@Prop()
	subFooter: string

	@Prop()
	borderColor: string
	@Prop()
	titleColor: string
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
#test {
	color: #075a56;
	color: white;
}
</style>
