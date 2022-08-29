<template>
	<div class="tab-file-list">
		<div class="primary-title">{{ primaryTitle }}</div>
		<ul>
			<li v-for="item in fileList" :key="item.key">
				{{ item.fileName }}:{{ item.operateType }}
			</li>
		</ul>
	</div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
@Component({})
export default class LastModifyFieListView extends Vue {
	@Prop()
	primaryTitle: string

	fileList: { fileName: string; operateType: string }[] = [
		{ fileName: '测试测试测试测试测试测试文件1', operateType: '提交' },
		{ fileName: '测试测试测试测试测试测试文件1', operateType: '提交' },
		{ fileName: '测试测试测试测试测试测试文件1', operateType: '提交' },
		{ fileName: '测试测试测试测试测试测试文件1', operateType: '提交' },
	]
}
</script>
<style scoped lang="less">
.tab-file-list {
	display: flex;
	flex-direction: column;
	margin: 10px;
    margin-left: 30px;
	background: #3c6382;
	height: 114px;
	border-radius: 5px;
	div {
		flex-grow: 1;
		color: rgb(252, 206, 55);
		font-size: 18px;
		display: flex;
		justify-content: flex-start;
		padding-top: 10px;
		padding-left: 10px;
	}
	ul {
		flex-grow: 5;
		color: rgb(252, 249, 249);
		font-size: 15px;
		margin-top: 0px;
		li {
			list-style-type: none;
			display: flex;
			justify-content: flex-start;
		}
	}
}
</style>
