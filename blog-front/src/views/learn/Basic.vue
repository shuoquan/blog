<template>
  <div>
    <!--    <div>{{ lastName + firstName }}</div>-->
    <!--    <div>{{ getName() }}</div>-->
    <!--    <div>{{ fullName }}</div>-->
    <div>{{ person.name }}</div>
    <input v-model="name" @keyup.esc="getName()" />
    <div>{{ name }}</div>
    <button @click="getName($event)">点击</button>
    <MyComponentTwo></MyComponentTwo>
    <input :value="age" @input="inputAge"/>

    <div style="padding: 20px; width: 100px; height: 100px; background: #f17000; margin: 0 auto; position: relative">
      <div style="top: 0px; width: 200px; height: 200px; background: #0e8c8c; position: absolute">

      </div>
    </div>

    <div class="triangle"></div>
  </div>
</template>
<script>
import Vue from 'vue';
const myComponentOne = Vue.extend({
  template: '<div> <h2>标题</h2> <div>我是组件1</div> </div>',
});
const myComponentTwo = Vue.extend({
  template:
    '<div> <h2>标题</h2> <div>我是组件2</div> <MyComponentOne></MyComponentOne></div>',
  components: {
    MyComponentOne: myComponentOne,
  },
});
// 全局组件
// Vue.component('MyComponent', myComponent);
// 语法糖
// const myComponentOne = Vue.component('MyComponent', {
//   template: '<div> <h2>标题</h2> <div>我是组件1</div> </div>'
// })
export default {
  name: 'Basic',
  data () {
    return {
      firstName: 'ding',
      lastName: 'shuoquan',
      person: {
        name: '',
      },
      name: '',
      age: '12',
    };
  },
  components: {
    // MyComponentOne: myComponentOne, // 局部组件
    MyComponentTwo: myComponentTwo,
  },
  created () {},
  mounted () {},
  computed: {
    // fullName: {
    //   get: function () {
    //     return this.firstName + this.lastName;
    //   },
    //   set: function () {
    //   }
    // }
    fullName () {
      console.log('fullname');
      return this.firstName + this.lastName;
    },
  },
  methods: {
    getName (event) {
      console.log('getname', event);
      console.log(this.name, typeof this.name);
      return this.firstName + this.lastName;
    },
    inputAge(event) {
      console.log(event.target.value);
      console.log(this.age)
    }
  },
  watch: {
    person: {
      handler (now, old) {
        // console.log(old.name, now.name);
      },
      deep: true,
      immediate: true,
    },
  },
};
</script>
<!--<script>-->
<!--const obj = {-->
<!--  name: 'bob',-->
<!--  age: 12-->
<!--}-->
<!--function abc() {-->
<!--  return obj;-->
<!--}-->
<!--const obj1 = abc();-->
<!--const obj2 = abc();-->
<!--const obj3 = abc();-->
<!--obj1.name = 'dd';-->
<!--console.log(obj1, obj2, obj3)-->
<!--</script>-->
<style scoped>
.triangle {
  width: 100px;
  height: 50px;
  border: 1px solid #f56100;
  position: relative;
  transition: all 1s;
  transform-origin: 150% 0;
}
.triangle::after{
  content: '';
  position: absolute;
  top: 10px;
  right: 8px;
  width: 15px;
  height: 15px;
  border-bottom: 1px solid red;
  border-right: 1px solid red;
  transform: rotate(45deg);
  transition: all 0.4s;
}
/*.triangle:hover::after{*/
/*  transform: rotate(225deg);*/
/*}*/
.triangle:hover{
  transform: rotate(360deg);
}
</style>
