<template>
  <div>
    <div>父组件</div>
<!--    <div>{{ message }}</div>-->
<!--    <ComponentOne :movies="movies" @response="getChildMessage" ref="componentOne"></ComponentOne>-->
<!--    <button @click="printChild">打印</button>-->
<!--    <ComponentSlot><button>组件button</button></ComponentSlot>-->

<!--    具名插槽-->
<!--    <ComponentSlot><span slot="left">替换</span></ComponentSlot>-->

<!--    作用域插槽-->
    <ComponentSlot>
      <template slot-scope="slot">
        <span v-for="item in slot.languages" :key="item">{{item}}-</span>
      </template>
    </ComponentSlot>
  </div>
</template>

<script>
import ComponentOne from '../../components/learn/ComponentOne';
import ComponentSlot from '../../components/learn/ComponentSlot';
export default {
  name: 'Communication',
  data () {
    return {
      movies: ['海尔兄弟', '海贼王'],
      message: '',
    };
  },
  mounted () {},
  methods: {
    getChildMessage (data) {
      console.log(data);
    },
    printChild () {
      // 通过$children获取所有子组件信息
      // console.log(this.$children);
      // this.$children[0].print();
      // 通过$refs获取某个子组件信息，默认为空对象，在组件上添加$ref
      this.$refs.componentOne.print();
    },
  },
  components: {
    ComponentSlot,
    ComponentOne,
  },
};
</script>

<style scoped></style>
