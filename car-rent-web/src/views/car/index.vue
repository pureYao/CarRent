<template>
  <div class="app-container">
    <el-row>
      <el-col :span="5">
        <el-input v-model="input" prefix-icon="el-icon-search" placeholder="请输入车牌号"></el-input>
      </el-col>
      <el-col :span="5">
        <el-select v-model="value" placeholder="颜色">
          <el-option
              v-for="item in colors"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
        </el-select>
      </el-col>
      <el-col :span="5">
        <el-select v-model="status_value" placeholder="租赁状态">
          <el-option
              v-for="item in car_status"
              :key="item.status_value"
              :label="item.label"
              :value="item.status_value">
          </el-option>
        </el-select>
      </el-col>
      <el-button type="primary">搜索</el-button>
      <el-button type="primary" @click="addCarForm = true">新增车辆</el-button>
      <el-dialog title="新增车辆" :visible.sync="addCarForm">
        <el-form :model="form">
          <el-form-item label="车牌号" :label-width="formLabelWidth">
            <el-input v-model="form.carId" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="车名" :label-width="formLabelWidth">
            <el-input v-model="form.carName" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="车辆颜色" :label-width="formLabelWidth">
            <el-select v-model="form.carColor" placeholder="请选车辆颜色">
              <el-option label="红色" value="red"></el-option>
              <el-option label="黑色" value="black"></el-option>
              <el-option label="蓝色" value="blue"></el-option>
              <el-option label="绿色" value="green"></el-option>
              <el-option label="橙色" value="orange"></el-option>
              <el-option label="黄色" value="yellow"></el-option>
              <el-option label="紫色" value="purple"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="描述" :label-width="formLabelWidth">
            <el-input type="textarea" v-model="form.desc" autocomplete="off"></el-input>

          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="addCarForm = false">取 消</el-button>
          <el-button type="primary" @click="addCarForm = false">确 定</el-button>
        </div>
      </el-dialog>
    </el-row>
    <br>
    <el-table v-loading="listLoading" :data="list" element-loading-text="Loading" border fit highlight-current-row>
      <el-table-column align="center" label="车牌号" width="125">
        <template slot-scope="scope">
          {{ scope.$index }}
        </template>
      </el-table-column>
      <el-table-column label="车名" width="200">
        <template slot-scope="scope">
          {{ scope.row.author }}
        </template>
      </el-table-column>
      <el-table-column label="颜色" width="125" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.author }}</span>
        </template>
      </el-table-column>
      <el-table-column label="车况描述" width="325" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.author }}</span>
        </template>
      </el-table-column>
      <el-table-column label="租赁状态" width="80" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.status | statusFilter">{{ scope.row.status }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template>
          <el-button
              size="mini"
              @click="editCarForm=true">编辑</el-button>
          <el-button
              size="mini"
              type="danger"
              @click="delCar">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="编辑车辆" :visible.sync="editCarForm">
      <el-form :model="form">
        <el-form-item label="车牌号" :label-width="formLabelWidth">
          <el-input v-model="form.carId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="车名" :label-width="formLabelWidth">
          <el-input v-model="form.carName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="车辆颜色" :label-width="formLabelWidth">
          <el-select v-model="form.carColor" placeholder="请选车辆颜色">
            <el-option label="红色" value="red"></el-option>
            <el-option label="黑色" value="black"></el-option>
            <el-option label="蓝色" value="blue"></el-option>
            <el-option label="绿色" value="green"></el-option>
            <el-option label="橙色" value="orange"></el-option>
            <el-option label="黄色" value="yellow"></el-option>
            <el-option label="紫色" value="purple"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="描述" :label-width="formLabelWidth">
          <el-input type="textarea" v-model="form.desc" autocomplete="off"></el-input>

        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addCarForm = false">取 消</el-button>
        <el-button type="primary" @click="addCarForm = false">确 定</el-button>
      </div>
    </el-dialog>
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
        deleted: 'danger'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      list: null,
      listLoading: true,
      input: '',
      value:'',
      status_value:'',
      car_status:[{
        status_value:'true',
        label:'已借出'
      },{
        status_value:'false',
        label:'未借出'
      }],
      colors: [{
        value: 'red',
        label: '红色'
      }, {
        value: 'black',
        label: '黑色'
      }, {
        value: 'blue',
        label: '蓝色'
      },{
        value: 'green',
        label: '绿色'
      },{
        value: 'orange',
        label: '橙色'
      },{
        value: 'yellow',
        label: '黄色'
      },{
        value: 'purple',
        label: '紫色'
      }],
      addCarForm: false,
      form: {
        carId:'',
        carName: '',
        carColor:'',
        desc: ''
      },
      formLabelWidth: '120px',
      editCarForm: false,
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
    delCar() {
      this.$confirm('此操作将永久删除此车信息, 是否继续?', '提示', {
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
