<template>
  <el-container>
    <el-header height="50">
      <el-form :inline="true" :model="exampleSearchForm" size="mini" class="demo-form-inline">
        <el-form-item label="名称">
          <el-input v-model="exampleSearchForm.name" placeholder="名称"></el-input>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="exampleSearchForm.email" placeholder="邮箱"></el-input>
        </el-form-item>
        <el-form-item label="年龄">
          <el-input v-model="exampleSearchForm.age" placeholder="年龄"></el-input>
        </el-form-item>

        <el-form-item label="启用状态">
          <el-select v-model="exampleSearchForm.validStatus" placeholder="启用状态">
            <el-option label="--请选择--" value=""></el-option>
            <el-option label="启用" value="Y"></el-option>
            <el-option label="停用" value="N"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="修改时间">
          <el-date-picker
            v-model="exampleSearchForm.lastUpdateTime"
            type="datetime"
            :editable=false
            value-format="yyyy-MM-dd hh:mm:ss"
            size="mini"
            placeholder="开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="修改时间">
          <el-date-picker
            :editable=false
            v-model="exampleSearchForm.lastUpdateTime2"
            value-format="yyyy-MM-dd hh:mm:ss"
            type="datetime"
            size="mini"
            placeholder="结束时间">
          </el-date-picker>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="onSearch">查询</el-button>
          <el-button type="info" @click="onClean">清空</el-button>
          <el-button type="success" @click="onAdd">新增</el-button>
          <el-button type="danger" @click="onDelete">删除</el-button>
        </el-form-item>
      </el-form>
    </el-header>
    <el-main>
      <el-table
        :data="exampleTableData"
        ref="multipleTable"
        @selection-change="onSelectionChange"
        :default-sort="{prop: 'last_update_time', order: 'descending'}"
        border max-height="360" style="width: 100%">
        <el-table-column type="selection" width="40"></el-table-column>
        <el-table-column prop="name" align="left" label="名称" width="200"></el-table-column>
        <el-table-column prop="email" align="left" label="邮箱" width="200"></el-table-column>
        <el-table-column prop="age" align="left" sortable label="年龄" width="200"></el-table-column>
        <el-table-column prop="validStatus" align="left" label="启用状态" width="200"
                         :formatter="formatterValidStatus"></el-table-column>
        <el-table-column prop="createTime" align="left" :formatter="formatterDate" label="创建日期" width="200"></el-table-column>
        <el-table-column prop="lastUpdateTime" align="left" :formatter="formatterDate" width="200" sortable label="最后修改日期"></el-table-column>
        <el-table-column fixed="right" align="left" width="180px;" label="操作">
          <template slot-scope="scope">
            <el-button size="mini" @click="onEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="onDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-dialog title="编辑信息" :visible.sync="dialogVisible" :show-close="false" width="40%">
        <el-form :model="exampleEditForm" status-icon :rules="exampleEditFormRule" ref="exampleEditForm"
                 label-width="100px" class="demo-ruleForm">
          <el-form-item label="名称" prop="name">
            <el-input type="text" v-model="exampleEditForm.name" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="年龄" prop="age">
            <el-input type="text" v-model.number="exampleEditForm.age" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model.email="exampleEditForm.email"></el-input>
          </el-form-item>
          <el-form-item label="状态">
            <el-select v-model="exampleEditForm.validStatus" placeholder="状态">
              <el-option label="启用" value="Y"></el-option>
              <el-option label="停用" value="N"></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="cancelEdit">取 消</el-button>
          <el-button @click="resetEdit">重 置</el-button>
          <el-button type="primary" @click="saveOrUpdate">确 定</el-button>
        </span>
      </el-dialog>
    </el-main>
    <el-footer>
      <div class="block">
        <el-pagination
          @size-change="onChangePageSize"
          @current-change="onChangeCurrentPage"
          :current-page.sync="exampleSearchForm.paging.currentPage"
          :page-sizes="[5, 10, 20, 50]"
          :page-size="exampleSearchForm.paging.pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="totalNum">
        </el-pagination>
      </div>
    </el-footer>
  </el-container>
</template>

<script>
  import * as Constant from "../../constant/index";
  import Utils from "../../utils/index";
  import GenericHeader from '../../components/GenericHeader'


  export default {
    name: 'Home',

    methods: {
      //查询
      onSearch() {
        let self = this;
        this.$axios({
          headers: {
            'Content-Type': 'application/json'
          },
          method: 'post',
          url: Constant.ADMIN_EXAMPLES_URI,
          data: Utils.toJsonStr(self.exampleSearchForm)
        }).then(function (resp) {
          if (resp.code !== Constant.REQ_SUCCESS) {
            self.$alert(resp.msg, '系统提示');
          } else {
            self.totalNum = Number.parseInt(resp.data.count);
            self.exampleTableData = resp.data.data;
          }
        }).catch(resp => {
          console.log(resp);
          self.$message(resp.msg ? resp.msg : '请求出错', '系统提示');
        });
      },

      //触发删除事件
      onDelete(index, row) {
        let self = this;
        if (!row && this.multipleSelection.length < 1) {
          this.$message('请至少选择一项进行操作');
          return;
        }
        this.$confirm('此操作将永久删除文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          let deleteIds = [];
          if (row) {
            deleteIds.push(row.id);
          } else {
            for (let index in this.multipleSelection) {
              deleteIds.push(this.multipleSelection[index].id);
            }
          }
          this.$axios.delete(Constant.ADMIN_EXAMPLES_URI + '/' + deleteIds.join(',')).then(function (resp) {
            if (resp.code === Constant.REQ_SUCCESS) {
              self.onSearch();
              self.$message({type: 'success', message: '删除成功!'});
            } else {
              self.$message({type: 'info', message: resp.msg});
            }
          }).catch(resp => {
            self.$message({type: 'error', message: '服务器错误'});
          });
        }).catch(() => {
          self.$message({type: 'info', message: '已取消删除'});
        });
      },

      //取消编辑
      cancelEdit() {
        this.resetEdit();
        this.dialogVisible = false;
      },

      //重置按钮
      resetEdit() {
        this.exampleEditForm.id = '';
        this.exampleEditForm.name = '';
        this.exampleEditForm.age = '';
        this.exampleEditForm.email = '';
      },
      /**
       * 新增、修改
       */
      saveOrUpdate() {
        let self = this;
        this.$refs['exampleEditForm'].validate((valid) => {
          if (valid) {
            this.$axios.put(Constant.ADMIN_EXAMPLES_URI, self.exampleEditForm).then(function (resp) {

              if (resp.code === Constant.REQ_SUCCESS) {
                self.onSearch();
                self.$message({type: 'success', message: '操作成功!'});
              } else {
                self.$message({type: 'info', message: resp.msg});
              }
            }).catch(resp => {
              self.$message({type: 'error', message: '系统错误'});
            });
            this.dialogVisible = false;
          } else {
            this.$message({type: 'warning', message: '表单验证不通过'});
          }
        });
      },

      /**
       * 触发修改按钮
       * @param index
       * @param row
       */
      onEdit(index, row) {
        this.exampleEditForm.id = row.id;
        this.exampleEditForm.name = row.name;
        this.exampleEditForm.age = row.age;
        this.exampleEditForm.email = row.email;
        this.exampleEditForm.validStatus = row.validStatus;
        this.dialogVisible = true;
      },

      /**
       * 触发修改页面条数事件
       */
      onChangePageSize(pageSize) {
        this.exampleSearchForm.paging.pageSize = pageSize;
        this.onSearch();
      },

      /**
       * 触发修改当前页事件
       */
      onChangeCurrentPage() {
        this.onSearch();
      },

      /**
       * 清除编辑表单
       */
      onClean() {
        this.exampleSearchForm.name = '';
        this.exampleSearchForm.age = '';
        this.exampleSearchForm.email = '';
        this.exampleSearchForm.validStatus = '';
        this.exampleSearchForm.lastUpdateTime = '';
        this.exampleSearchForm.lastUpdateTime2 = '';
      },

      /**
       * 触发新增按钮
       */
      onAdd() {
        this.resetEdit();
        this.dialogVisible = true;
      },

      /**
       * 格式化validStatus列
       * @param row
       * @param column
       * @param cellValue
       * @returns {string}
       */
      formatterValidStatus(row, column, cellValue) {
        if (cellValue === 'Y') {
          return '启用'
        } else {
          return '停用'
        }
      },

      formatterDate(row, column, cellValue){
        return Utils.formatDate(new Date(cellValue), 'yyyy-MM-dd hh:mm:ss')
      },


      /**
       * 全选事件
       * @param rows
       */
      onSelectionChange(rows) {
        this.multipleSelection = rows;
      }
    },

    /**
     * Vue属性
     * @returns {{exampleEditFormRule: {name: *[], age: *[], email: *[]}, dialogVisible: boolean, multipleSelection: Array, exampleSearchForm: {name: string, age: string, email: string, validStatus: string, lastUpdateTime: string, lastUpdateTime2: string, paging: {pageSize: number, currentPage: number}}, exampleEditForm: {id: string, name: string, age: string, email: string, validStatus: string, last_update_time: string, create_time: string}, totalNum: number, exampleTableData: Array}}
     */
    data() {
      let checkAddName = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('请输入名称'));
        }
        if (value.length > 20) {
          return callback(new Error('名称长度不能大于20'));
        }
        callback();
      };
      let checkAddAge = (rule, value, callback) => {
        if (value === '') {
          return callback(new Error('请输入年龄'));
        }
        if (value > 60 || value < 18) {
          return callback(new Error('年龄必须在18-60岁之间'));
        }
        callback();
      };
      let checkAddEmail = (rule, value, callback) => {
        if (value === '') {
          return callback(new Error('请输入邮箱'));
        }
        let reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
        if (!reg.test(value)) {
          return callback(new Error('请输入正确的邮箱格式'));
        }
        callback();
      };
      return {
        exampleEditFormRule: {
          name: [
            {validator: checkAddName, trigger: 'blur'}
          ],
          age: [
            {validator: checkAddAge, trigger: 'blur'}
          ],
          email: [
            {validator: checkAddEmail, trigger: 'blur'}
          ]
        },
        dialogVisible: false,
        multipleSelection: [],
        exampleSearchForm: {
          name: '',
          age: '',
          email: '',
          validStatus: '',
          lastUpdateTime: '',
          lastUpdateTime2: '',
          paging: {
            pageSize: 5,
            currentPage: 1
          }
        },
        exampleEditForm: {
          id: '',
          name: '',
          age: '',
          email: '',
          validStatus: 'Y',
        },
        totalNum: 100,
        exampleTableData: [],
      }
    },

    /**
     * 计算属性定义
     */
    computed: {},

    /**
     * 初始化钩子函数
     */
    created: function () {
      this.onSearch();
    }
  }
</script>

<style scoped>
  .el-header {
    background-color: gainsboro;
    color: #333;
    padding: 0px;
    padding: 15px;
    margin-bottom: 10px;
    text-align: left;
    line-height: 0px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 0px;
    padding: 0px;
  }

  .el-footer {
    background-color: #E9EEF3;
    color: white;
    font-size: x-small;
    text-align: center;
    line-height: 0px;
    padding: 0px;
    padding-top: 20px;
  }
</style>
