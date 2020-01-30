<template>
    <div>
      <el-container style="height: 500px; border: 1px solid #eee">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
          <el-menu :default-openeds="[]">
            <el-submenu index="1">
              <template slot="title"><i class="el-icon-message"></i>用户列表</template>
              <el-menu-item-group>
                <el-menu-item index="1-1"><router-link to="/user/add">新增用户</router-link></el-menu-item>
                <el-menu-item index="1-2"><router-link to="/user/list">用户列表</router-link></el-menu-item>
              </el-menu-item-group>


            </el-submenu>
            <el-submenu index="2">
              <template slot="title"><i class="el-icon-menu"></i>商品管理</template>
              <el-menu-item-group>
                <el-menu-item index="2-1">新增商品</el-menu-item>
                <el-menu-item index="2-2">商品列表</el-menu-item>
              </el-menu-item-group>

            </el-submenu>

          </el-menu>
        </el-aside>

        <el-container>
          <el-header style="text-align: right; font-size: 12px">
            <el-dropdown>
              <i class="el-icon-setting" style="margin-right: 15px"></i>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item>查看</el-dropdown-item>
                <el-dropdown-item>新增</el-dropdown-item>
                <el-dropdown-item>删除</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
            <span>王小虎</span>
          </el-header>

          <el-main>
            <router-view/>
          </el-main>
        </el-container>
      </el-container>
    </div>
</template>

<script>
    export default {
        name: "Main.vue",
        data() {
          const item = {
            date: '2016-05-02',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
          };
          return {
            tableData: Array(20).fill(item)
          }
        }
    }
</script>

<style scoped>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }
</style>
