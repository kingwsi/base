<template>
  <div>
    <a-tabs default-active-key="1">
      <a-tab-pane key="1" tab="基本信息">
        <a-row type="flex" justify="center" v-if="!tableInfo">
          <a-col :span="12">
            <a-input-search
              placeholder="input search text"
              enter-button="Search"
              size="large"
              @search="onSearch"
            />
          </a-col>
        </a-row>
        <a-card :bordered="false" v-if="tableInfo">
          <a-descriptions title="表信息">
            <a-descriptions-item label="表名">{{ tableInfo.name }}</a-descriptions-item>
            <a-descriptions-item label="备注">{{ tableInfo.comment }}</a-descriptions-item>
          </a-descriptions>
          <a-divider style="margin-bottom: 32px"/>
          <a-descriptions title="生成预览">
            <a-descriptions-item label="Entity名称">{{ tableInfo.entityName }}</a-descriptions-item>
            <a-descriptions-item label="Controller名称">{{ tableInfo.controllerName }}</a-descriptions-item>
            <a-descriptions-item label="Service名称">{{ tableInfo.serviceName }}</a-descriptions-item>
            <a-descriptions-item label="Mapper名称">{{ tableInfo.mapperName }}</a-descriptions-item>
            <a-descriptions-item label="xml名称">{{ tableInfo.xmlName }}</a-descriptions-item>
            <a-descriptions-item label="备注">	无</a-descriptions-item>
          </a-descriptions>
          <a-divider style="margin-bottom: 32px"/>
        </a-card>
      </a-tab-pane>
      <a-tab-pane key="2" tab="列明细" force-render>
        <div class="title">详细</div>
        <a-table
          :columns="fieldColumns"
          :data-source="tableInfo.fields"
          row-key="name"
          v-if="tableInfo">
        </a-table>
      </a-tab-pane>
      <a-tab-pane key="3" tab="Tab 3">
        Content of Tab Pane 3
      </a-tab-pane>
    </a-tabs>
  </div>
</template>
<script>
import { GetTableInfo } from '@/api/generatorCode'
import { STable } from '@/components'
export default {
  data () {
    return {
      tableInfo: null,
      visible: false,
      confirmLoading: false,
      fieldColumns: [
        {
          title: '列',
          dataIndex: 'name',
          key: 'name'
        },
        {
          title: '属性',
          dataIndex: 'propertyName',
          key: 'propertyName'
        },
        {
          title: '数据类型',
          dataIndex: 'columnType',
          key: 'columnType'
        },
        {
          title: 'propertyType',
          dataIndex: 'propertyType',
          key: 'propertyType'
        }
      ]
    }
  },
  components: {
    STable
  },
  methods: {
    onSearch (value) {
      GetTableInfo(value).then(res => {
        if (res.code === 200) {
          this.tableInfo = res.data
          this.$message.info('表信息获取成功！')
        } else {
          this.$message.err('表信息获取失败！')
        }
      })
    },
    loadData: () => {
        return new Promise(resolve => {
          resolve({
            data: this.tableInfo.fields
            })
        })
      }
  }
}
</script>
