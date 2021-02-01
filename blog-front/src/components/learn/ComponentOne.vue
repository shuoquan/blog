<template>
  <div>
    <div v-for="(item, index) in movies" v-bind:key="index">
      {{ item }}
    </div>
    <button @click="sendMessageToParent">点击子组件</button>
  </div>
</template>

<script>
export default {
  name: 'ComponentOne',
  data () {
    return {
      name: 'heihei',
    };
  },
  props: {
    movies: {
      type: Array,
      default () {
        return [];
      },
    },
    message: {
      type: String,
      default: '',
      required: false,
    },
  },
  methods: {
    sendMessageToParent () {
      // this.$emit('response', '点击子组件');
      // 获取父组件信息
      console.log(this.$parent);
      console.log(this.$root);
    },
    print () {
      console.log('子组件');
    },
  },
};
</script>

<style scoped></style>
