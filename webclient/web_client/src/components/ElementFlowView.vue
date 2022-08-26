<template>
	<div class="element-flow-list-container">
        <div class=""></div>
        <div class=""></div>
        <div class=""></div>
        <div class=""></div>
        <div class=""></div>
        <div class=""></div>
    </div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
/** 各个要素视图 */
@Component({})
export default class ElementFlowView extends Vue {
    /** 要素名称 */
    elementTitle='要素A'
	mydata: any = null
	mounted() {}
	get computedTest() {
		return null
	}
}
</script>
<style scoped></style>
