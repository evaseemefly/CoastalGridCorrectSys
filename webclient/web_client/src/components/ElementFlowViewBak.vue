<template>
	<div class="element-flow-list-container">
		<div class="sea-area" v-for="seaArea in seaAreaFlowList" :key="seaArea.key">
			<!-- L0 国家级指导产品 -->
			<div
				class="flow-row national-flow"
				v-for="group in seaArea.groupList"
				:key="group.key"
				v-show="group.children.length == 0"
			>
				<div class="flow-item suited">
					<div class="flow-item-title">国家中心</div>
					<div class="flow-item-subtitle">国家级指导产品</div>
					<div class="flow-item-content">
						<div class="item-state">
							<el-switch
								v-model="checked"
								active-color="#1e3799"
								inactive-color="#b71540"
							>
							</el-switch>
						</div>
						<div class="item-desc">上传完成</div>
					</div>
				</div>
			</div>
			<!-- L1 浙江省人机交互订正后产品 -->
			<div
				class="flow-row province-flow"
				v-for="group in seaArea.groupList"
				:key="group.key"
				v-show="group.children.length > 0"
			>
				<div class="flow-item un-suited" v-show="child in group.children">{{child.name}}</div>
			</div>
		</div>
		<div class="sea-area">
			<!-- L0 国家级指导产品 -->
			<div class="flow-row national-flow">
				<div class="flow-item suited">
					<div class="flow-item-title">国家中心</div>
					<div class="flow-item-subtitle">国家级指导产品</div>
					<div class="flow-item-content">
						<div class="item-state">
							<el-switch
								v-model="checked"
								active-color="#1e3799"
								inactive-color="#b71540"
							>
							</el-switch>
						</div>
						<div class="item-desc">上传完成</div>
					</div>
				</div>
			</div>
			<!-- L1 浙江省人机交互订正后产品 -->
			<div class="flow-row province-flow">
				<div class="flow-item un-suited">省台A</div>
				<div class="flow-item un-suited">省台A</div>
				<div class="flow-item suited">
					<div class="flow-item-title">省台A</div>
				</div>
				<div class="flow-item un-suited">省台A</div>
				<div class="flow-item un-suited">省台A</div>
			</div>
			<!-- L2：海区内所有省的订正场融合产品 -->
			<div class="flow-row region-flow">
				<div class="flow-item un-suited">北海区</div>
				<div class="flow-item suited">
					<div class="flow-item-title">东海区</div>
					<div class="flow-item-subtitle">省级订正后产品</div>
					<div class="flow-item-content">
						<div class="item-state">
							<el-switch
								v-model="checked"
								active-color="#1e3799"
								inactive-color="#b71540"
							>
							</el-switch>
						</div>
						<div class="item-desc">上传完成</div>
					</div>
				</div>
				<div class="flow-item un-suited">南海区</div>
			</div>
			<!-- L3：海区级人机交互订正后产品 -->
			<div class="flow-row region-flow">
				<div class="flow-item un-suited">北海区</div>
				<div class="flow-item suited">
					<div class="flow-item-title">东海区</div>
					<div class="flow-item-subtitle">省级订正后产品</div>
				</div>
				<div class="flow-item un-suited">南海区</div>
			</div>
			<!-- L4：三个海区融合产品 -->
			<div class="flow-row national-flow">
				<div class="flow-item suited">
					<div class="flow-item-title">国家中心</div>
					<div class="flow-item-subtitle">省级订正后产品</div>
					<div class="flow-item-content">
						<div class="item-state">
							<el-switch
								v-model="checked"
								active-color="#1e3799"
								inactive-color="#b71540"
							>
							</el-switch>
						</div>
						<div class="item-desc">上传完成</div>
					</div>
				</div>
			</div>
			<!-- L5：国家中心人机交互订正后产品 -->
			<div class="flow-row national-flow">
				<div class="flow-item check-out">
					<div class="flow-item-title">国家中心</div>
					<div class="flow-item-subtitle">省级订正后产品</div>
					<div class="flow-item-content">
						<div class="item-state">
							<el-switch
								v-model="unChecked"
								active-color="#1e3799"
								inactive-color="#b71540"
							>
							</el-switch>
						</div>
						<div class="item-desc">未完成</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
/** 各个要素视图 */
@Component({})
export default class ElementFlowView extends Vue {
	/** 要素名称 */
	elementTitle = '要素A'
	flowState = false
	checked = true
	unChecked = false
	mydata: any = null

	seaAreaFlowList: {
		code: number
		name: string
		groupList: {
			code: number
			name: string
			state: boolean
			level: number
			desc: string
			children: { code: number; name: string; state: boolean; level: number }[]
		}[]
	}[] = [
		{
			code: 1,
			name: '北海海区',
			groupList: [
				{
					code: 1,
					name: '国家中心',
					state: true,
					level: 0,
					desc: '国家级指导产品',
					children: [],
				},
				{
					code: 2,
					name: '省台',
					state: true,
					level: 0,
					desc: '国家级指导产品',
					children: [
						{
							code: 3,
							name: '省台A',
							state: true,
							level: 0,
						},
						{
							code: 4,
							name: '省台B',
							state: true,
							level: 0,
						},
						{
							code: 5,
							name: '省台C',
							state: true,
							level: 0,
						},
						{
							code: 6,
							name: '省台',
							state: true,
							level: 0,
						},
					],
				},
				{
					code: 3,
					name: '东海区',
					state: true,
					level: 0,
					desc: '国家级指导产品',
					children: [],
				},
				{
					code: 4,
					name: '东海区',
					state: true,
					level: 0,
					desc: '国家级指导产品',
					children: [],
				},
				{
					code: 4,
					name: '国家中心',
					state: true,
					level: 0,
					desc: '国家级指导产品',
					children: [],
				},
				{
					code: 4,
					name: '国家中心',
					state: true,
					level: 0,
					desc: '国家级指导产品',
					children: [],
				},
			],
		},
	]
}
</script>
<style scoped lang="less">
.element-flow-list-container {
	display: flex;
	height: 90%;
	width: 90%;
	margin: 10px;
	flex-direction: column;

	.national-flow {
	}
	.province-flow {
	}
	.region-flow {
	}
	.flow-item {
		height: 15%;
		width: 90%;
		// background: rgba(157, 231, 67, 0.772);
		margin: 5px;
		.flow-item-title {
		}
		.flow-item-content {
			.item-state {
			}
			.item-desc {
			}
		}
	}
}
.sea-area {
	display: flex !important;
}
.flow-row {
	height: 100%;
	width: 15%;
	background: rgb(40, 30, 95);
	margin-right: 10px;
	display: flex;
	flex-direction: column;
	border-radius: 5px;
}
.flow-item {
	flex-grow: 1;
	display: flex;
	flex-direction: column;
	border-radius: 5px;
	.flow-item-title {
		flex-grow: 1;
	}
	.flow-item-subtitle {
		flex-grow: 1;
		font-size: 13px;
		color: #797777;
	}
	.flow-item-content {
		flex-grow: 4;
		justify-content: space-around;
		display: flex;
		flex-direction: row;
		/* align-content: center; */
		justify-content: center;
		align-content: center;
		.item-state {
			display: flex;
			flex-direction: column;
			justify-content: center;
		}
		.item-desc {
			display: flex;
			flex-direction: column;
			justify-content: center;
			color: white;
			text-shadow: 2px 2px 3px #212020;
			font-size: 18px;
			font-weight: 600;
		}
	}
}
.suited {
	flex-grow: 4;
}

.element-flow-list-container {
	.flow-row {
		.flow-item.suited {
			background: #78db1b;
		}
		.flow-item.check-out {
			background: #f7b731;
		}
	}
	.flow-item.suited {
		.flow-item.suited {
			background: #78db1b;
		}
		.flow-item.un-suited {
			background: #457e10b5;
		}
	}
	.flow-item.un-suited {
		background: #457e10b5;
	}
	// .national-flow {
	// 	.flow-item.suited {
	// 		background: #43d4cf;
	// 	}
	// 	.flow-item.un-suited {
	// 		background: #457e10b5;
	// 	}
	// }
	// .province-flow {
	// 	.flow-item.suited {
	// 		background: #78db1b;
	// 	}
	// 	.flow-item.un-suited {
	// 		background: #457e10b5;
	// 	}
	// }
	// .region-flow {
	// 	.flow-item.suited {
	// 		background: #ffce2d;
	// 	}
	// 	.flow-item.un-suited {
	// 		background: #457e10b5;
	// 	}
	// }
}
</style>
