<template>
  <div class="container">
    <el-table
      :data="$store.state.ranking === 'min' ? table.data.slice(0, 5) : showTable"
      style="width: 100%"
    >
      <el-table-column
        :prop="item.prop"
        :label="item.label"
        :width="item.width"
        v-for="(item, index) in table.column"
        :key="index"
      ></el-table-column>
    </el-table>
    <div class="block" v-if="$store.state.ranking=='max'">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="table.pageNum"
        :page-sizes="[10, 20, 50, 100]"
        :page-size="table.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="table.total"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  name: "Table",
  data() {
    return {
      table: {
        column: [],
        // 当前页
        pageNum: 1,
        // 每页的条数
        pageSize: 10,
        total: 0,
        data: [],
      },
    };
  },
  props: {
    data: Object,
  },
  computed: {
    showTable() {
      return this.table.data.slice(
        (this.table.pageNum - 1) * this.table.pageSize,
        this.table.pageNum * this.table.pageSize
      );
    },
  },
  methods: {
    init(val) {
      for (const key in val) {
        if (Object.keys(this.table).includes(key)) {
          this.table[key] = val[key];
        }
      }
    },
    handleSizeChange(val) {
      this.table.pageSize = val;
      this.table.pageNum = 1;
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.table.pageNum = val;
      console.log(`当前页: ${val}`);
    },
  },
  watch: {
    data: {
      handler(newVal) {
        this.init(newVal);
      },
      immediate: true,
      deep: true,
    },
  },
};
</script>

<style lang="less" scoped>
/*最外层透明*/
/deep/ .el-table, /deep/ .el-table__expanded-cell{
  background-color: transparent;
}
/* 表格内背景颜色 */
/deep/ .el-table th,
/deep/ .el-table tr,
/deep/ .el-table td {
  background-color: transparent;
}
.container{
  background: url('@/assets/img/rank.jpg');
}
</style>