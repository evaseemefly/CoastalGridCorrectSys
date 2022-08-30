<template>
	<div class="element-tab">
		<div
			v-for="item in elementTypes"
			:key="item.index"
			:class="item.code === selectedElement ? 'selected' : 'unselected'"
			@click="updateSelectedCode(item.code)"
		>
			{{ item.name }}
		</div>
	</div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
// enmu
import { GroupEnum, StepStateEnum, ElementTypeEnum } from '@/enum'
@Component({})
export default class ElementTabView extends Vue {
	@Prop(Array)
	elementTypes: { index: number; name: string; code: ElementTypeEnum }[]

	@Prop(Number)
	selectedElement: ElementTypeEnum

	updateSelectedCode(val: ElementTypeEnum): void {
		this.$emit('childSelectedCode', val)
	}
}
</script>
<style scoped lang="less">
.element-tab {
	display: flex;
	justify-content: flex-start;
	width: 100%;
	color: white;
	margin-left: 40px;
	div {
		height: 30px;
		width: 100px;
		// background: #457e10b5;

		border-radius: 5px;
		margin-right: 10px;
		margin-left: 10px;
		display: flex;
		align-content: center;
		justify-content: center;
		align-items: center;
		cursor: pointer;
	}
	.selected {
		background: rgb(246, 185, 59);
	}
	.unselected {
		background: rgba(204, 164, 85, 0.699);
	}
}
</style>
