<template>
	<div id="ele_progress">
		<div class="progress-title">今日海浪作业进度</div>
		<el-progress type="circle" :percentage="70" status="warning"></el-progress>
	</div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
@Component({})
export default class ElementProgressView extends Vue {}
</script>
<style scoped lang="less">
#ele_progress {
	height: 90%;
	width: 90%;
    .progress-title{
        height: 50px;
    }
    // display: flex;
    // flex-direction:column ;
}
</style>
