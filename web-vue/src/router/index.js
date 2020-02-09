import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/pages/Login'
import Home from '@/pages/Home'
import Example from '@/pages/example/Example'

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/login',
      component: Login
    },
    {
      path: '/', component: Home, children: [
        {path: 'example', component: Example},
      ]
    }
  ]
})
