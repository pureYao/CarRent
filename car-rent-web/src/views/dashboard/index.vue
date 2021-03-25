<template>
    <el-row :gutter="20">
      <el-col :span="8" style="background-color: #ccffbd;color: #40394a" class="dashboard-card">
        <i class="el-icon-user"></i>用户总数
      </el-col>
      <el-col :span="8" style="background-color: #7eca9c;color: #40394a" class="dashboard-card">
        <i class="el-icon-truck"></i>汽车总数
      </el-col>
      <el-col :span="8" style="background-color: #40394a;color: #ccffbd" class="dashboard-card">
        <i class="el-icon-money"></i>交易数量
      </el-col>
    </el-row>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name'
    ])
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
</style>
