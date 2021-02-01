<template>
  <div>
    <!--    <div class="box"></div>-->
    <transition name="transition">
      <div v-for="item in imgList" v-bind:key="item">
        <img :src="item" />
      </div>
    </transition>
  </div>
</template>

<script>
export default {
  name: 'WaterFall',
  data () {
    return {
      imgList: [
        'https://images.unsplash.com/photo-1610297987527-ce5ea2915e5f?ixid=MXwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxfHx8ZW58MHx8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60',
        'https://images.unsplash.com/photo-1610250009894-0ed98d52de1e?ixid=MXwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxN3x8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60',
        'https://images.unsplash.com/photo-1610312201003-a2850cc18eeb?ixid=MXwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwzOXx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60',
        'https://images.unsplash.com/photo-1610288311469-bbf025a6208d?ixid=MXwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw4M3x8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60',
      ],
      imgs: [],
    };
  },
  mounted () {
    this.imgs = document.querySelectorAll('img');
    window.onload = window.onscroll = () => {
      this.check();
    };
    window.onresize = () => {
      console.log('window.innerHeight', window.innerHeight);
      console.log('window.innerWidth', window.innerWidth);
      console.log(
        'document.documentElement.clientHeight',
        document.documentElement.clientHeight,
      );
      console.log(
        'document.documentElement.clientWidth',
        document.documentElement.clientWidth,
      );
      // console.log(document.getElementsByClassName('box')[0].clientWidth);
    };
  },
  methods: {
    check () {
      console.log('1')
      Array.from(this.imgs).forEach(el => {
        console.log('2')
        if (this.isIn(el)) {
          console.log('3')
          this.loadImg(el);
        }
      });
    },
    isIn (el) {
      const bound = el.getBoundingClientRect();
      console.log('bound', bound)
      const clientHeight = window.innerHeight;
      return bound.top <= clientHeight;
    },
    loadImg (el) {
      if (!el.src) {
        const source = el.dataset.src;
        el.src = source;
      }
    },
  },
};
</script>

<style scoped>
.box {
  height: 100px;
  width: 100px;
  background: #0ea432;
  margin: 0 auto;
}
.transition-enter-active,
.transition-leave-active{
  transition: all 1s ease;
}
.transition-leave-active,
.transition-enter{
  height: 0px;
}

.transition-leave,
.transition-enter-active{
  height: 500px;
}
</style>
