<template>
	<div>
		<el-steps :active="2" align-center>
			<el-step title="步骤1" description="这是一段很长很长很长的描述性文字"></el-step>
			<el-step title="步骤2" description="这是一段很长很长很长的描述性文字"></el-step>
			<el-step title="步骤3" description="这是一段很长很长很长的描述性文字"></el-step>
			<el-step title="步骤4" description="这是一段很长很长很长的描述性文字"></el-step>
		</el-steps>
	</div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
@Component({})
export default class StepView extends Vue {
	mydata: any = null

	get computedTest() {
		return null
	}
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
