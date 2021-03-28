<template>
  <div class="app-container">
    <el-row>
      <el-col :span="5">
        <el-input v-model="input" prefix-icon="el-icon-search" placeholder="请输入车牌号"></el-input>
      </el-col>
      <el-col :span="5">
        <el-select v-model="value" placeholder="状态">
          <el-option
              v-for="item in status"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
        </el-select>
      </el-col>
      <el-col :span="5">
        <div class="block">
          <el-date-picker
              v-model="start_time"
              type="date"
              placeholder="开始日期">
              suffix-icon="el-icon-date"
          </el-date-picker>
        </div>
      </el-col>
      <el-col :span="5">
        <div class="block">
          <el-date-picker
              v-model="end_time"
              type="date"
              placeholder="结束日期">
              suffix-icon="el-icon-date"
          </el-date-picker>
        </div>
      </el-col>
      <el-button type="primary">搜索</el-button>
    </el-row>
    <br>
    <el-table v-loading="listLoading" :data="list" element-loading-text="Loading" border fit highlight-current-row>
      <el-table-column align="center" label="ID" width="95">
        <template slot-scope="scope">
          {{ scope.$index }}
        </template>
      </el-table-column>
      <el-table-column label="租车人姓名" width="125">
        <template slot-scope="scope">
          {{ scope.row.author }}
        </template>
      </el-table-column>
      <el-table-column label="租车车牌号" width="125" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.author }}</span>
        </template>
      </el-table-column>
      <el-table-column label="租借日期" width="300" align="center">
        <template slot-scope="scope">
          {{ scope.row.pageviews }}
        </template>
      </el-table-column>
      <el-table-column label="租借天数" width="150" align="center">
        <template slot-scope="scope">
          {{ scope.row.pageviews }}
        </template>
      </el-table-column>
      <el-table-column label="状态" width="100" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.status | statusFilter">{{ scope.row.status }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template>
          <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button
              size="mini"
              type="danger"
              @click="delRent">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getList } from '@/api/table'

export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'gray',
        deleted: 'danger',
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      list: null,
      listLoading: true,
      input: '',
      start_time:'',
      end_time:'',
      value:'',
      status: [{
        value: 'true',
        label: '租借中'
      },{
        value: 'false',
        label: '已结束'
      }]
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      getList().then(response => {
        this.list = response.data.items
        this.listLoading = false
      })
    },
    delRent(){
      this.$confirm('此操作将永久该条信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: '删除成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    }
  }
}
</script>
