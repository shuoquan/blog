<template>
  <div>
    <svg
      height="500"
      width="500"
      style="background: #0ea432"
      @click="getPosition"
      @mousemove.stop="movePoint($event)"
    >
      <g v-for="(item, idx) in pointsList" v-bind:key="idx">
        <circle
          :cx="item[0]"
          :cy="item[1]"
          r="6"
          stroke="black"
          stroke-width="2"
          fill="red"
          @mousedown.stop="mousedown(idx)"
          @mouseup.stop="mouseup"
          @click.ctrl.left="deletePoint($event, idx)"
        />
      </g>
      <polyline
        :points="points(pointsList)"
        style="fill:lime;stroke:purple;stroke-width:1;"
      />
    </svg>
  </div>
</template>

<script>
export default {
  name: 'MySvg',
  data () {
    return {
      pointsList: [],
      enable: true,
      curPoint: [],
      pointIdx: null,
    };
  },
  computed: {
    points: function () {
      return function (pointsList) {
        return pointsList.reduce((last, cur) => {
          return last + ` ${cur[0]}, ${cur[1]}`;
        }, '');
      };
    },
  },
  mounted () {
    // console.log(document.getElementsByTagName('svg'));
  },
  methods: {
    getPosition (event) {
      if (!this.enable) return;
      this.points += ` ${event.offsetX}, ${event.offsetY}`;
      this.pointsList.push([event.offsetX, event.offsetY]);
    },
    deletePoint (event, idx) {
      console.log('delete');
      this.pointsList.splice(idx, 1);
    },
    mouseup () {
      this.pointIdx = null;
    },
    mousedown (idx) {
      console.log('start');
      this.pointIdx = idx;
    },
    movePoint (event) {
      console.log('move', this.enable, event.buttons);
      if (event.buttons) {
        // console.log('event', event, event.target.attributes.index.value.split('|'))
        this.pointsList.splice(this.pointIdx, 1, [event.offsetX, event.offsetY]);
      }
    },
  },
};
</script>

<style scoped></style>
