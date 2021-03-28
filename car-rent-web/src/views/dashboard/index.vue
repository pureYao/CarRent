<template>
  <el-row :gutter="80" style="margin: 30px">
    <el-col :span="8">
      <div style="background-color: #ccffbd;color: #40394a" class="dashboard-card">
        <i class="el-icon-user"></i>
        <span class="item-name">用户总数</span>
        <span class="item-num">12345</span>
      </div>
    </el-col>
    <el-col :span="8">
      <div style="background-color: #7eca9c;color: #40394a" class="dashboard-card">
        <i class="el-icon-truck"></i>
        <span class="item-name">汽车总数</span>
        <span class="item-num">12345</span>
      </div>
    </el-col>
    <el-col :span="8">
      <div style="background-color: #40394a;color: #ccffbd" class="dashboard-card">
        <i class="el-icon-money"></i>
        <span class="item-name">今日交易</span>
        <span class="item-num">12345</span>
      </div>
    </el-col>
    <div style="margin-top: 200px">
    <el-table
        :data="tableData"
        border
        style="width: 100%">
      <el-table-column
          prop="date"
          label="管理员"
          width="280">
      </el-table-column>
      <el-table-column
          prop="name"
          label="xxx"
          width="380">
      </el-table-column>
    </el-table>
    </div>
  </el-row>
</template>

<script>

export default {
  data() {
    return {
      tableData: [{
        date: '车行',
        name: 'xxx',
      }, {
        date: '登录时间',
        name: 'xxxx-xx-xx',
      }]
    }
  }
}
</script>

<style lang="scss" scoped>

.dashboard-card{
  height: 150px;
  border-radius: 20px;
  font-size: 20px;
  font-weight: bold;
  i{
    margin:15px;
    font-size:100px;
  }
}
.item-name{
  position: relative;
  bottom: 55px;
  left: 40px;
}
.item-num{
  position: relative;
  bottom: 10px;
  right: 35px;
}

</style>
