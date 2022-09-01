<template>
	<div class="element-flow-list-container">
		<div class="sea-area" v-for="seaArea in seaAreaFlowList" :key="seaArea.key">
			<!-- L0 国家级指导产品 -->
			<div
				class="flow-row national-flow"
				v-for="group in seaArea.groupList"
				:key="group.key"
				v-show="group.children.length == 0"
				:style="{ order: group.sort }"
			>
				<div class="flow-item" :class="[getSuitedCls(group.state)]">
					<div class="flow-item-title">{{ group.name }}</div>
					<div class="flow-item-subtitle">{{ group.desc }}</div>
					<div class="flow-item-content">
						<div class="item-state">
							<el-switch
								v-model="group.checked"
								active-color="#1e3799"
								inactive-color="#b71540"
							>
							</el-switch>
						</div>
						<div class="item-desc">{{ getSuitedVal(group.state) }}</div>
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
				<div
					class="flow-item"
					:class="[getSuitedCls(child.state)]"
					v-for="child in group.children"
					:key="child.key"
				>
					{{ child.name }}
				</div>
			</div>
		</div>
	</div>
</template>
<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
import { StateEnum, ElementTypeEnum, AreaEnum, ProductLevelEnmu, StepStateEnum } from '@/enum'
// api
import { getAreaStep } from '@/api'
const getSuitedCls = (state: StateEnum): string => {
	let clsName = ''
	switch (state) {
		case StateEnum.NULL:
			clsName = ''
			break
		case StateEnum.SUITED:
			clsName = 'suited'
			break
		case StateEnum.UNSUITED:
			clsName = 'un-suited'
			break
	}
	return clsName
}

const getGroupName = (level: ProductLevelEnmu): string => {
	let name = ''
	switch (level) {
		case ProductLevelEnmu.L0:
			name = '国家中心'
			break
		case ProductLevelEnmu.L1:
			name = '省台'
			break
		case ProductLevelEnmu.L2:
			name = '海区'
			break
		case ProductLevelEnmu.L3:
			name = '海区'
			break
		case ProductLevelEnmu.L4:
			name = '国家中心'
			break
		case ProductLevelEnmu.L5:
			name = '国家中心'
			break
	}
	return name
}

const getAreaName = (area: AreaEnum): string => {
	let name = ''
	switch (area) {
		case AreaEnum.NORTH:
			name = '北海区'
			break
		case AreaEnum.EAST:
			name = '东海区'
			break
		case AreaEnum.SOUTH:
			name = '南海区'
			break
	}
	return name
}

/** 各个要素视图 */
@Component({})
export default class ElementFlowView extends Vue {
	/** 要素名称 */
	@Prop(String)
	elementName: string

	/** 要素枚举类型 */
	@Prop(Number)
	elementType: ElementTypeEnum

	@Prop(Date)
	forecastDt: Date

	elementTitle = '要素A'
	flowState = false
	checked = true
	unChecked = false
	mydata: any = null

	getSuitedCls = (state: StateEnum): string => {
		let clsName = ''
		switch (state) {
			case StateEnum.NULL:
				clsName = ''
				break
			case StateEnum.SUITED:
				clsName = 'suited'
				break
			case StateEnum.UNSUITED:
				clsName = 'un-suited'
				break
		}
		return clsName
	}

	getSuitedVal = (state: StateEnum): string => {
		return state === StateEnum.SUITED ? '完成' : '未完成'
	}

	get flowOpt(): { forecastDt: Date; elementType: ElementTypeEnum } {
		const { forecastDt, elementType } = this
		return { forecastDt, elementType }
	}

	@Watch('flowOpt')
	onFlowOpt(val: { forecastDt: Date; elementType: ElementTypeEnum }): void {
		// console.log(val)
		const self = this
		// 监听到预报时间或 elementtype 变化时手动获取三个海区的状态
		const areas = [AreaEnum.NORTH, AreaEnum.EAST, AreaEnum.SOUTH]
		this.seaAreaFlowList = []
		areas.forEach((area) => {
			getAreaStep(val.elementType, new Date(), area, val.forecastDt).then(
				(res: {
					data: {
						index: number // 为sort排序的顺序
						product_type: number
						group_list: {
							group_code: number
							group_name: string
							pid: number
							sort: number	// 此sort有问题，暂时不使用
							step_state: number
						}[]
					}[]
					status: number
				}) => {
					if (res.status === 200) {
						// console.log(res.data)
						let tempAreaStep: any = {
							code: 0,
							name: '',
							groupList: [],
						}
						tempAreaStep['code'] = area
						tempAreaStep['name'] = getAreaName(area)

						res.data.forEach((temp) => {
							let _tempGroup = {
								code: 0,
								name: '',
								state: StateEnum.NULL,
								level: 0,
								desc: '',
								sort: 0,
								checked: false,
								children: [],
							}
							_tempGroup['code'] = temp.product_type
							_tempGroup['name'] = getGroupName(temp.product_type)
							_tempGroup['sort'] = temp.index

							if (temp.product_type === ProductLevelEnmu.L1) {
								let groupList = []
								if (temp.group_list && temp.group_list.length > 0) {
									let children = []
									temp.group_list.forEach((tempGroup) => {
										const child = {
											code: tempGroup.group_code,
											name: tempGroup.group_name,
											level: 0,
											checked:
												tempGroup.step_state == StepStateEnum.SUCCESS
													? true
													: false,
											state:
												tempGroup.step_state == StepStateEnum.SUCCESS
													? StateEnum.SUITED
													: StateEnum.UNSUITED,
										}
										children.push(child)
									})
									_tempGroup['children'] = children
								}
							}
							// 非 L1 级产品
							else {
								if (temp.group_list && temp.group_list.length > 0) {
									const child = temp.group_list[0]
									_tempGroup['level'] = 0
									_tempGroup['state'] =
										child.step_state == StepStateEnum.SUCCESS
											? StateEnum.SUITED
											: StateEnum.UNSUITED
									_tempGroup['desc'] = child.group_name
									// _tempGroup['sort'] = child.sort
									_tempGroup['checked'] =
										child.step_state == StepStateEnum.SUCCESS ? true : false
								}
							}
							tempAreaStep.groupList.push(_tempGroup)
						})
						this.seaAreaFlowList.push(tempAreaStep)
					}
				}
			)
		})
	}

	seaAreaFlowList: {
		code: number
		name: string
		groupList: {
			code: number
			name: string
			state: StateEnum
			checked: boolean
			level: number
			desc: string
			sort: number
			children: {
				code: number
				name: string
				state: StateEnum
				level: number

				checked: boolean
			}[]
		}[]
	}[] = [
		{
			code: 2,
			name: '东海海区',
			groupList: [
				{
					code: 1,
					name: '国家中心',
					state: StateEnum.SUITED,
					level: 0,
					desc: '国家级指导产品',
					sort: 0,
					checked: true,
					children: [],
				},
				{
					code: 2,
					name: '省台',
					state: StateEnum.NULL,
					level: 0,
					desc: '国家级指导产品',
					sort: 1,
					checked: true,
					children: [
						{
							code: 3,
							name: '江苏省台',
							state: StateEnum.SUITED,
							level: 0,
							checked: true,
						},
						{
							code: 4,
							name: '上海市台',
							state: StateEnum.UNSUITED,
							level: 0,
							checked: false,
						},
						{
							code: 5,
							name: '浙江省台',
							state: StateEnum.SUITED,
							level: 0,
							checked: true,
						},
						{
							code: 6,
							name: '福建省台',
							state: StateEnum.UNSUITED,
							level: 0,
							checked: false,
						},
					],
				},
				{
					code: 3,
					name: '东海区',
					state: StateEnum.SUITED,
					level: 0,
					desc: '国家级指导产品',
					sort: 2,
					checked: true,
					children: [],
				},
				{
					code: 4,
					name: '东海区',
					state: StateEnum.SUITED,
					level: 0,
					desc: '国家级指导产品',
					sort: 3,
					checked: true,
					children: [],
				},
				{
					code: 4,
					name: '国家中心',
					state: StateEnum.SUITED,
					level: 0,
					desc: '国家级指导产品',
					sort: 4,
					checked: true,
					children: [],
				},
				{
					code: 4,
					name: '国家中心',
					state: StateEnum.UNSUITED,
					level: 0,
					sort: 5,
					checked: false,
					desc: '国家级指导产品',
					children: [],
				},
			],
		},
	]

	// seaAreaFlowList: {
	// 	code: number
	// 	name: string
	// 	groupList: {
	// 		code: number
	// 		name: string
	// 		state: StateEnum
	// 		checked: boolean
	// 		level: number
	// 		desc: string
	// 		sort: number
	// 		children: {
	// 			code: number
	// 			name: string
	// 			state: StateEnum
	// 			level: number

	// 			checked: boolean
	// 		}[]
	// 	}[]
	// }[] = [
	// 	{
	// 		code: 1,
	// 		name: '北海海区',
	// 		groupList: [
	// 			{
	// 				code: 1,
	// 				name: '国家中心',
	// 				state: StateEnum.UNSUITED,
	// 				level: 0,
	// 				desc: '国家级指导产品',
	// 				sort: 0,
	// 				checked: false,
	// 				children: [],
	// 			},
	// 			{
	// 				code: 2,
	// 				name: '省台',
	// 				state: StateEnum.UNSUITED,
	// 				level: 0,
	// 				desc: '国家级指导产品',
	// 				sort: 1,
	// 				checked: true,
	// 				children: [
	// 					{
	// 						code: 3,
	// 						name: '省台A',
	// 						state: StateEnum.UNSUITED,
	// 						level: 0,
	// 						checked: false,
	// 					},
	// 					{
	// 						code: 4,
	// 						name: '省台B',
	// 						state: StateEnum.UNSUITED,
	// 						level: 0,
	// 						checked: false,
	// 					},
	// 					{
	// 						code: 5,
	// 						name: '省台C',
	// 						state: StateEnum.UNSUITED,
	// 						level: 0,
	// 						checked: false,
	// 					},
	// 					{
	// 						code: 6,
	// 						name: '省台',
	// 						state: StateEnum.UNSUITED,
	// 						level: 0,
	// 						checked: false,
	// 					},
	// 				],
	// 			},
	// 			{
	// 				code: 3,
	// 				name: '北海区',
	// 				state: StateEnum.UNSUITED,
	// 				level: 0,
	// 				desc: '国家级指导产品',
	// 				sort: 2,
	// 				checked: false,
	// 				children: [],
	// 			},
	// 			{
	// 				code: 4,
	// 				name: '北海区',
	// 				state: StateEnum.UNSUITED,
	// 				level: 0,
	// 				desc: '国家级指导产品',
	// 				sort: 3,
	// 				checked: false,
	// 				children: [],
	// 			},
	// 			{
	// 				code: 4,
	// 				name: '国家中心',
	// 				state: StateEnum.UNSUITED,
	// 				level: 0,
	// 				desc: '国家级指导产品',
	// 				sort: 4,
	// 				checked: false,
	// 				children: [],
	// 			},
	// 			{
	// 				code: 4,
	// 				name: '国家中心',
	// 				state: StateEnum.UNSUITED,
	// 				level: 0,
	// 				sort: 5,
	// 				checked: false,
	// 				desc: '国家级指导产品',
	// 				children: [],
	// 			},
	// 		],
	// 	},
	// 	{
	// 		code: 2,
	// 		name: '东海海区',
	// 		groupList: [
	// 			{
	// 				code: 1,
	// 				name: '国家中心',
	// 				state: StateEnum.SUITED,
	// 				level: 0,
	// 				desc: '国家级指导产品',
	// 				sort: 0,
	// 				checked: true,
	// 				children: [],
	// 			},
	// 			{
	// 				code: 2,
	// 				name: '省台',
	// 				state: StateEnum.NULL,
	// 				level: 0,
	// 				desc: '国家级指导产品',
	// 				sort: 1,
	// 				checked: true,
	// 				children: [
	// 					{
	// 						code: 3,
	// 						name: '江苏省台',
	// 						state: StateEnum.SUITED,
	// 						level: 0,
	// 						checked: true,
	// 					},
	// 					{
	// 						code: 4,
	// 						name: '上海市台',
	// 						state: StateEnum.UNSUITED,
	// 						level: 0,
	// 						checked: false,
	// 					},
	// 					{
	// 						code: 5,
	// 						name: '浙江省台',
	// 						state: StateEnum.SUITED,
	// 						level: 0,
	// 						checked: true,
	// 					},
	// 					{
	// 						code: 6,
	// 						name: '福建省台',
	// 						state: StateEnum.UNSUITED,
	// 						level: 0,
	// 						checked: false,
	// 					},
	// 				],
	// 			},
	// 			{
	// 				code: 3,
	// 				name: '东海区',
	// 				state: StateEnum.SUITED,
	// 				level: 0,
	// 				desc: '国家级指导产品',
	// 				sort: 2,
	// 				checked: true,
	// 				children: [],
	// 			},
	// 			{
	// 				code: 4,
	// 				name: '东海区',
	// 				state: StateEnum.SUITED,
	// 				level: 0,
	// 				desc: '国家级指导产品',
	// 				sort: 3,
	// 				checked: true,
	// 				children: [],
	// 			},
	// 			{
	// 				code: 4,
	// 				name: '国家中心',
	// 				state: StateEnum.SUITED,
	// 				level: 0,
	// 				desc: '国家级指导产品',
	// 				sort: 4,
	// 				checked: true,
	// 				children: [],
	// 			},
	// 			{
	// 				code: 4,
	// 				name: '国家中心',
	// 				state: StateEnum.UNSUITED,
	// 				level: 0,
	// 				sort: 5,
	// 				checked: false,
	// 				desc: '国家级指导产品',
	// 				children: [],
	// 			},
	// 		],
	// 	},
	// 	{
	// 		code: 3,
	// 		name: '南海海区',
	// 		groupList: [
	// 			{
	// 				code: 1,
	// 				name: '国家中心',
	// 				state: StateEnum.UNSUITED,
	// 				level: 0,
	// 				desc: '国家级指导产品',
	// 				sort: 0,
	// 				checked: false,
	// 				children: [],
	// 			},
	// 			{
	// 				code: 2,
	// 				name: '省台',
	// 				state: StateEnum.UNSUITED,
	// 				level: 0,
	// 				desc: '国家级指导产品',
	// 				sort: 1,
	// 				checked: true,
	// 				children: [
	// 					{
	// 						code: 3,
	// 						name: '省台A',
	// 						state: StateEnum.UNSUITED,
	// 						level: 0,
	// 						checked: false,
	// 					},
	// 					{
	// 						code: 4,
	// 						name: '省台B',
	// 						state: StateEnum.UNSUITED,
	// 						level: 0,
	// 						checked: false,
	// 					},
	// 					{
	// 						code: 5,
	// 						name: '省台C',
	// 						state: StateEnum.UNSUITED,
	// 						level: 0,
	// 						checked: false,
	// 					},
	// 					{
	// 						code: 6,
	// 						name: '省台',
	// 						state: StateEnum.UNSUITED,
	// 						level: 0,
	// 						checked: false,
	// 					},
	// 				],
	// 			},
	// 			{
	// 				code: 3,
	// 				name: '南海区',
	// 				state: StateEnum.UNSUITED,
	// 				level: 0,
	// 				desc: '国家级指导产品',
	// 				sort: 2,
	// 				checked: false,
	// 				children: [],
	// 			},
	// 			{
	// 				code: 4,
	// 				name: '南海区',
	// 				state: StateEnum.UNSUITED,
	// 				level: 0,
	// 				desc: '国家级指导产品',
	// 				sort: 3,
	// 				checked: false,
	// 				children: [],
	// 			},
	// 			{
	// 				code: 4,
	// 				name: '国家中心',
	// 				state: StateEnum.UNSUITED,
	// 				level: 0,
	// 				desc: '国家级指导产品',
	// 				sort: 4,
	// 				checked: false,
	// 				children: [],
	// 			},
	// 			{
	// 				code: 4,
	// 				name: '国家中心',
	// 				state: StateEnum.UNSUITED,
	// 				level: 0,
	// 				sort: 5,
	// 				checked: false,
	// 				desc: '国家级指导产品',
	// 				children: [],
	// 			},
	// 		],
	// 	},
	// ]
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
