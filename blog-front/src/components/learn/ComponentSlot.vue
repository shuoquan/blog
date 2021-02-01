<template>
  <div>
    <p>插槽组件</p>
    <!--    <slot><span>默认插槽</span></slot>-->

    <!--    <slot name="left"><span>左</span></slot>-->
    <!--    <slot name="center"><span>中</span></slot>-->
    <!--    <slot name="right"><span>右</span></slot>-->

    <!--    作用域插槽-->
    <slot :languages="languages">
      <ul>
        <li v-for="item in languages" :key="item">
          {{ item }}
        </li>
      </ul>
    </slot>
  </div>
</template>

<script>
export default {
  name: 'ComponentSlot',
  data () {
    return {
      languages: ['Java', 'Javascript', 'Python', 'C++'],
    };
  },
};
</script>

<style scoped></style>
