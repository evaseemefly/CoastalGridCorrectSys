<template>
	<div id="ele_progress">
		<div class="progress-title">今日{{ elementName }}作业进度</div>
		<el-progress
			type="circle"
			:percentage="70"
			status="warning"
			color="rgb(44, 221, 212)"
		></el-progress>
	</div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
// enmu
import { ElementTypeEnum } from '@/enum'
@Component({})
export default class ElementProgressView extends Vue {
	@Prop(Number)
	elementType: ElementTypeEnum

	@Prop(String)
	elementName: string
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
