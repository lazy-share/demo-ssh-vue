'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  ADMIN_DOMAIN: '"http://localhost:8081/v1/demo-ssh-vue-api"'
})
