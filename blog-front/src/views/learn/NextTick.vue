<template>
  <div>
    <!--    <div ref="msgDiv">{{ msg }}</div>-->
    <!--    <div v-if="msg1">Message got outside $nextTick: {{ msg1 }}</div>-->
    <!--    <div v-if="msg2">Message got inside $nextTick: {{ msg2 }}</div>-->
    <!--    <div v-if="msg3">Message got outside $nextTick: {{ msg3 }}</div>-->
    <!--    <button @click="changeMsg">-->
    <!--      Change the Message-->
    <!--    </button>-->
    <button @click="debounce">防抖</button>
  </div>
</template>

<script>
import * as util from '@/utils/util.js';
export default {
  name: 'NextTick',
  data () {
    return {
      msg: 'Hello Vue.',
      msg1: '',
      msg2: '',
      msg3: '',
    };
  },
  methods: {
    changeMsg () {
      console.log(this.$refs.msgDiv.innerHTML);
      this.msg = 'Hello world.';
      this.msg1 = this.$refs.msgDiv.innerHTML;
      this.$nextTick(() => {
        this.msg2 = this.$refs.msgDiv.innerHTML;
      });
      this.msg3 = this.$refs.msgDiv.innerHTML;
    },
    debounce: util._debounce(() => {
      console.log('hello world');
    }, 5000),
    throttle: util._throttle(() => {
      console.log('pp');
    }, 5000),
  },
};
</script>

<style scoped></style>
