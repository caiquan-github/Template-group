import Vue from 'vue'
import Router from 'vue-router'

import Main from '@/views/Main'
import Login from '@/views/Login'

import UserAdd from '@/views/user/Add'
import UserList from '@/views/user/list'


Vue.use(Router);

export default new Router({
  routes:[
    {
      name: 'Login',
      path: '/login',
      component: Login
    },
    {
      name: 'Main',
      path: '/main',
      component: Main,
      children:[
        {name: UserAdd, path: '/user/add',component: UserAdd},
        {name: UserList, path: '/user/list',component: UserList}
      ]
    }
  ]

})
