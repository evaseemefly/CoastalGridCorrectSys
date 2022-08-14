<template>
	<div class="main-content">
		<div class="my-row">
			<div class="my-statics-form"></div>
			<div class="my-statics-form"></div>
			<div class=""></div>
			<div class="my-histogran">
				<!-- <RecentlyHistogranView></RecentlyHistogranView> -->
                <ProductProgressView></ProductProgressView>
			</div>
		</div>
		<div class="my-row">
            <RecentlyHistogranView></RecentlyHistogranView>
        </div>
		<div class="my-row"><StepView></StepView></div>
		<div class="my-row"><StepView></StepView></div>
	</div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'

// 组件
import RecentlyHistogranView from '@/components/RecentlyHistogranView.vue'
import StepView from '@/components/StepView.vue'
import ProductProgressView from '@/components/ProductProgressView.vue'
@Component({
	components: {
		RecentlyHistogranView,
		StepView,
        ProductProgressView
	},
})
export default class MainView extends Vue {
	mydata: any = null
	get computedTest() {
		return null
	}
}
</script>
<style scoped lang="less">
.main-content {
	display: flex;
	flex: 22;
	flex-direction: column;
	background: linear-gradient(rgb(70, 85, 129), rgb(49, 59, 89));
	position: absolute;
	left: 0px;
	right: 0px;
	height: 100%;
	align-items: center;
}
.my-row {
	background: rgb(143, 110, 57);
	width: 80%;
	margin: 10px;
	display: flex;
	height: 20%;
	display: flex;
	align-items: center;
	justify-content: center;
}
.my-statics-form {
	display: flex;
	flex-grow: 3;
	background: rgb(53, 171, 116);
	height: 90%;
	margin: 8px;
}
.my-histogran {
	display: flex;
	flex-grow: 8;
	background: rgb(58, 202, 180);
	height: 90%;
	margin: 8px;
}
</style>
