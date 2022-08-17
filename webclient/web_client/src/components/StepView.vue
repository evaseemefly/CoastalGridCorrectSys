<template>
	<div>
		<el-steps :active="activedStepIndex" align-center>
			<el-step
				:title="stepTemp.title"
				:description="stepTemp.desc"
				:key="stepTemp.key"
				v-for="stepTemp in stepList"
			></el-step>
			<!-- <el-step title="步骤2" description="这是一段很长很长很长的描述性文字"></el-step>
			<el-step title="步骤3" description="这是一段很长很长很长的描述性文字"></el-step>
			<el-step title="步骤4" description="这是一段很长很长很长的描述性文字"></el-step> -->
		</el-steps>
	</div>
</template>
<script lang="ts">
import { List } from 'echarts'
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
@Component({})
export default class StepView extends Vue {
	@Prop(Number)
	activedStepIndex: number

	@Prop(List)
	stepList: { title: string; desc: string }[]
}
</script>
<style lang="less">
.el-steps {
	.el-step__title {
		color: #a4acb4 !important;
	}
	.el-step__description.is-finish {
		color: #fdfeff !important;
	}
	.el-step__icon {
		background: #f5f705 !important;
	}
}
</style>
