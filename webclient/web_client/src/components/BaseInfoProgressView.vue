<template>
	<div class="base-info-progress-container">
		<div class="primary-title">{{ primaryTitle }}</div>
		<div class="progress">
			<el-progress
				type="circle"
				:percentage="progress"
				:status="getProgressStatus"
			></el-progress>
		</div>
		<div class="sub-title">{{ subTitle }}</div>
	</div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'

/** 基础信息进度视图 */
@Component({})
export default class BaseInfoProgressView extends Vue {
	@Prop()
	primaryTitle: string

	@Prop()
	subTitle: string

	/** 进度 */
	@Prop()
	progress: number

	get getProgressStatus(): string {
		let progress = 0
		let status = ''
		if (this.progress !== undefined) {
			progress = this.progress
		}
		if (progress == 0) status = ''
		else if (progress > 0 && progress < 40) status = 'exception'
		else if (progress > 0 && progress < 80) status = 'warning'
		else if (progress > 0 && progress == 100) status = 'success'
		return status
	}
}
</script>
<style lang="less">
.base-info-progress-container {
	display: flex;
	width: 160px;
	height: 150px;
	flex-direction: column;
	justify-content: center;
	background: #0a273c7a;
	border-radius: 5px;
	/* align-content: center; */
	align-content: center;
	.primary-title {
		color: white;
		flex-grow: 1;
	}
	.sub-title {
		color: rgba(211, 190, 190, 0.829);
		flex-grow: 2;
	}
	.progress {
		display: flex;
		// flex-grow: 3;
		width: 100%;
		height: 100px;
		justify-content: center;
		.el-progress {
			.el-progress-circle {
				width: 80px !important;
				height: 80px !important;
			}
		}
	}
}
</style>
