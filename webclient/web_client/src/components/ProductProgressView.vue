<template>
	<div class="vertical">
		<div class="my-row-item">
			<el-progress type="circle" :percentage="100" status="success"></el-progress>
		</div>
		<div class="my-row-item">
			<el-progress type="circle" :percentage="85" status="warning"></el-progress>
		</div>
	</div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
@Component({})
export default class ProductProgressView extends Vue {
	mydata: any = null
	get computedTest() {
		return null
	}
}
</script>
<style scoped lang="less">
.vertical{
    display: flex;
    flex-direction: row;
    padding: 3px;
}
.my-row-item{

}
</style>
