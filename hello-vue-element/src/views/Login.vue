<template>
    <div>
      <el-form :model="form" ref="form" :rules="rules" label-width="80px" class="login-box">
        <h1 class="login-title">欢迎登陆</h1>
        <el-form-item label="账号" prop="username">
            <el-input v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="form.password" type="password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="login('form')">登陆</el-button>
        </el-form-item>
      </el-form>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data(){
          return{
            form:{
              username:'',
              password:''
            },
            rules:{
              username:[
                {required: true, message:'请输入账号',trigger:'blur'}
              ],
              password:[
                {required: true, message:'请输入密码',trigger:'blur'}
              ],


            }
          }
        },
        methods:{
          login: function (formName) {
            this.$refs[formName].validate((valid) => {
              if (valid) {
                this.$router.push("/main");
              } else {
                this.$message({
                  showClose: true,
                  message: '请输入账号密码',
                  type: 'error'
                });

                return false;
              }
            });
          }
        }
    }
</script>

<style scoped>
  .login-title{
    text-align: center;
  }
  .login-box {
    text-align: left;
    width: 400px;
    border: 1px solid #DCDFE6;
    margin: 0 auto;
    margin-top: 150px;
    padding: 20px 50px 20px 20px ;
    border-radius: 30px;
    box-shadow: 0 0 10px;
  }

</style>
