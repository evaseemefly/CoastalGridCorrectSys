<template>
	<div class="tab-file-list">
		<div class="primary-title">{{ primaryTitle }}</div>

		<ul>
			<li v-for="item in fileList" :key="item.key">
				{{ formatDt2DHM(item.updatedDt) }} {{ item.fileName }} : {{ item.operateType }}
			</li>
		</ul>
	</div>
</template>
<script lang="ts">
import { format } from 'echarts'
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
@Component({})
export default class LastModifyFieListView extends Vue {
	@Prop()
	primaryTitle: string

	fileList: { fileName: string; operateType: string; updatedDt: Date }[] = [
		{
			fileName: 'NMF_BEN_OSM_CSDT_202208300800_120003_WAV_00_L0',
			operateType: '提交',
			updatedDt: new Date('2022-08-29T23:02:54.000Z'),
		},
		{
			fileName: 'NMF_BEN_OSM_CSDT_202208300800_120003_SSW_00_L0',
			operateType: '提交',
			updatedDt: new Date('2022-08-29T21:55:41.000Z'),
		},
		{
			fileName: 'NMF_BEN_OSM_CSDT_202208292000_120003_WAV_00_L0',
			operateType: '提交',
			updatedDt: new Date('2022-08-29T09:38:06.000Z'),
		},
		{
			fileName: 'NMF_BEN_OSM_CSDT_202208290800_120003_WAV_00_L0',
			operateType: '提交',
			updatedDt: new Date('2022-08-29T09:34:41.000Z'),
		},
	]

	formatDt2DHM = (val: Date): string => {
		let formatStr = ''
		formatStr = `${val.getDate()} ${('0' + val.getHours()).slice(-2)}:${(
			'0' + val.getMinutes()
		).slice(-2)}`
		return formatStr
	}
}
</script>
<style scoped lang="less">
.tab-file-list {
	display: flex;
	flex-direction: column;
	margin: 10px;
	margin-left: 30px;
	// background: #2554787a;
	background: #1243445e;
	height: 114px;
	border-radius: 5px;
	div {
		flex-grow: 1;
		// color: rgb(252, 206, 55);
		color: white;
		font-size: 18px;
		display: flex;
		justify-content: flex-start;
		// padding-top: 10px;
		// padding-left: 10px;
		margin: 5px;
		margin-left: 20px;
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
			color: #fbfdff96;
		}
	}
}
.test {
	color: rgb(44, 221, 212);
	color: rgb(114, 60, 214);
}
</style>
