<template>
  <div class="m-background">
    <nav class="ui inverted attached segment m-padded-tb-mini m-opacity-mini">
      <div class="ui container">
        <div class="ui inverted secondary menu stackable">
          <h2 class="ui teal header item">Blog</h2>
          <a class="item" :class="!display ? 'm-mobile-hide' : ''"
            ><i class="home icon"></i>首页</a
          >
          <a class="item" :class="!display ? 'm-mobile-hide' : ''"
            ><i class="idea icon"></i>分类</a
          >
          <a class="item" :class="!display ? 'm-mobile-hide' : ''"
            ><i class="tags icon"></i>标签</a
          >
          <a class="item" :class="!display ? 'm-mobile-hide' : ''"
            ><i class="clone icon"></i>归档</a
          >
          <a class="item" :class="!display ? 'm-mobile-hide' : ''"
            ><i class="info icon"></i>关于</a
          >
          <div class="item right" :class="!display ? 'm-mobile-hide' : ''">
            <div class="ui icon inverted transparent input">
              <input type="text" placeholder="Search..." />
              <i class="search link icon"></i>
            </div>
          </div>
        </div>
      </div>
      <a
        class="ui black icon button m-right-top m-mobile-show"
        @click="display = !display"
      >
        <i class="sidebar icon"></i>
      </a>
    </nav>
<!--    content-->
    <router-view></router-view>
    <footer class="ui inverted segment vertical m-padded-tb-massive m-opacity-mini">
      <div class="ui center aligned container">
        <div class="ui grid divided inverted stackable">
          <div class="three wide column">
            <div class="ui inverted link list">
              <img
                src="../assets/img/myinfo.png"
                class="ui rounded"
                style="width: 110px"
              />
            </div>
          </div>
          <div class="three wide column">
            <h4
              class="ui inverted header m-text-spaced m-text-thin m-opacity-mini"
            >
              最新博客
            </h4>
            <div class="ui inverted link list">
              <a class="item">用户故事</a>
              <a class="item">用户故事</a>
              <a class="item">用户故事</a>
            </div>
          </div>
          <div class="five wide column">
            <h4
              class="ui inverted header m-text-spaced m-text-thin m-opacity-mini"
            >
              联系我
            </h4>
            <div class="ui inverted link list">
              <a class="item">Email: shuoquand@outlook.com</a>
              <a class="item">QQ: 2753919456</a>
            </div>
          </div>
          <div class="five wide column">
            <h4
              class="ui inverted header m-text-spaced m-text-thin m-opacity-mini"
            >
              shuoquan
            </h4>
            <p class="m-text-spaced m-text-thin m-opacity-mini">
              这是我的个人博客， 会分享自己的学习、工作和生活。
            </p>
          </div>
        </div>
        <div class="ui inverted section divider"></div>
        <p class="m-text-thin m-text-spaced m-opacity-mini">
          CopyRight © 2020-2021 shuoquan
        </p>
      </div>
    </footer>
  </div>
</template>

<script>
export default {
  name: 'Layout',
  data () {
    return {
      display: false,
    };
  },
};
</script>

<style scoped>

.m-right-top {
  position: absolute;
  top: 0;
  right: 0;
}

@media screen and (max-width: 768px) {
  .m-mobile-hide {
    display: none !important;
  }
  .m-mobile-show {
    display: block !important;
  }
}
.m-mobile-show {
  display: none;
}

.m-background {
  background: url('../assets/img/background.jpg') fixed;
  background-size: cover;
}
</style>
