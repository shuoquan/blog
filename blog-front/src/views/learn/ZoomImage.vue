<template>
  <div class="previewModal" id="previewModal">
    <div style="height: 20px" @click="timeDuration()">点我</div>
    <Modal
      v-model="show"
      :footer-hide="true"
      width="55%"
      title="查看图片"
      class-name="previewModal"
      :styles="{ top: '15%' }"
    >
      <div class="identifyImgPage" id="father">
        <img
          src="http://img.haishen-inc.com/FvYgZAqi1lE71BCk1Kv0pZoAVQ0R"
          :width="imgShow ? '100%' : 'auto'"
          :height="imgShow ? 'auto' : '100%'"
          v-drag
        />
      </div>
    </Modal>
  </div>
</template>

<script>
import $ from 'jquery';
import * as  learnApi from '@/api/learn/learn'
export default {
  name: 'ZoomImage',
  components: {},

  props: {
    config: {
      //获取父级传的图片等信息

      type: Object,

      default: {},
    },
  },

  watch: {
    config: {
      handler (val, oldval) {
        if (val.imgsrc) {
          let img = new Image();

          img.src = val.imgsrc;

          this.imgShow = img.width > img.height;
        }
      },

      deep: true,

      immediate: true,
    },
  },

  data () {
    return {
      show: false, // 弹窗是否显示

      imgShow: true,
    };
  },

  mounted () {
    this.disabledMouseWheel();
  },

  directives: {
    //注册指令

    drag: function (el, binding) {
      let oDiv = el; //当前元素

      oDiv.onmousedown = function (e) {
        e.preventDefault();

        let bw = document.body.clientWidth;

        let bh = document.body.clientHeight;

        //鼠标按下，计算当前元素距离可视区的距离

        let disX = e.clientX - oDiv.offsetLeft;

        let disY = e.clientY - oDiv.offsetTop;

        // 计算两边坐标

        document.onmousemove = function (e) {
          let l = 0,
            t = 0;

          // 拖动边界

          if (e.clientX >= bw) {
            l = bw - disX;
          } else if (e.clientX <= 0) {
            l = 0 - disX;
          } else {
            l = e.clientX - disX;
          }

          if (e.clientY >= bh) {
            t = bh - disY;
          } else if (e.clientY <= 0) {
            t = 0 - disY;
          } else {
            t = e.clientY - disY;
          }

          //移动当前元素

          oDiv.style.left = l + 'px';

          oDiv.style.top = t + 'px';
        };

        // 鼠标停止移动时，事件移除

        document.onmouseup = function (e) {
          document.onmousemove = null;

          document.onmouseup = null;
        };
      };

      $(oDiv).bind(
        'mousewheel',

        function (e) {
          // 获取鼠标所在位置

          let { clientX, clientY } = e;

          // 获取元素距离屏幕边界左边和上边距离

          let offsetX = $(oDiv).offset().left;

          let offsetY = $(oDiv).offset().top;

          // 获取鼠标距离当前元素边界左边和上边距离

          let mouseToBorderX = clientX - offsetX;

          let mouseToBorderY = clientY - offsetY;

          // 获取元素width,height,left,top;注意元素为relative或absolute定位

          let width = $(oDiv).width();

          let height = $(oDiv).height();

          let left = parseFloat($(oDiv).css('left'));

          let top = parseFloat($(oDiv).css('top'));

          // 设置一下缩放幅度 ,值越大缩放的越快

          let ratio = e.originalEvent.deltaY < 0 ? 0.1 : -0.1;

          // 设置缩放后的宽高

          width = width * (1 + ratio);

          height = height * (1 + ratio);

          // 这里是关键一步

          // 可以想象,当元素宽度增加0.1倍,如果此时元素left值不变化，那么元素是会向右变大的，那么鼠标相

          // 对元素左上角的距离与最开始的距离相比就变了，变化量为mouseToBorderX*ratio，那么让元素left

          //  减去变化量即可保证鼠标相对元素不动

          left = left - mouseToBorderX * ratio;

          top = top - mouseToBorderY * ratio;

          if (width > 100) {
            $(oDiv).css({
              width: width + 'px',

              height: height + 'px',

              left: left + 'px',

              top: top + 'px',
            });
          }
        },
      );
    },
  },

  methods: {
    //禁用鼠标滚动 防止页面滚动

    disabledMouseWheel () {
      let div = document.getElementById('previewModal');

      if (div.addEventListener) {
        div.addEventListener('DOMMouseScroll', this.scrollFunc, false);
      }

      div.onmousewheel = div.onmousewheel = this.scrollFunc;
    },

    scrollFunc (evt) {
      evt = evt || window.event;

      if (evt.preventDefault) {
        // Firefox

        evt.preventDefault();

        evt.stopPropagation();
      } else {
        // IE

        evt.cancelBubble = true;

        evt.returnValue = false;
      }

      return false;
    },
    timeDuration () {
      learnApi.timeDuration().then((res)=>{
        console.log(res.data, '123')
      })
    }
  },
};
</script>

<style lang="scss">
.previewModal {
  .identifyImgPage {
    position: relative;

    width: 100%;

    height: 70vh;

    z-index: 2;

    overflow: hidden;
  }

  .identifyImgPage img {
    // height: 100%;

    // width: 100%;

    position: absolute;
  }
}
</style>
