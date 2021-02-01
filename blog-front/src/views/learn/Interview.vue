<template>
  <div>
    <div
      style="width: 40px; height: 40px; line-height: 40px; background: #0ea432"
      id="test"
    >
      123
    </div>
    <div
      style="height: 1px; transform: scale(1, 0.5); background: #0d71bb"
    ></div>
  </div>
</template>

<script>
export default {
  name: 'Interview',
  mounted () {
    console.log(document.getElementById('test').parentNode.childNodes);
  },
};
</script>

<style scoped>
.offset {
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
}
</style>
