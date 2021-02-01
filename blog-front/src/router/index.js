import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
  mode: 'hash',
  routes: [
    {
      path: '/',
      component: () => import('@/components/Layout'),
      meta: {},
      redirect: '/home',
      children: [
        {
          path: '/home',
          component: () => import('@/views/Home'),
          meta: {},
        },
        {
          path: '/article',
          component: () => import('@/views/Article'),
          meta: {},
        },
        {
          path: '/category',
          component: () => import('@/views/Category'),
          meta: {},
        },
      ],
    },
    {
      path: '/login',
      component: () => import('@/views/backend/Login'),
      meta: {},
    },
    {
      path: '/learn/basic',
      component: () => import('@/views/learn/Basic'),
      meta: {},
    },
    {
      path: '/learn/communication',
      component: () => import('@/views/learn/Communication'),
      meta: {},
    },
    {
      path: '/learn/waterfall',
      component: () => import('@/views/learn/WaterFall'),
      meta: {},
    },
    {
      path: '/learn/nexttick',
      component: () => import('@/views/learn/NextTick'),
      meta: {},
    },
    {
      path: '/learn/zoomimage',
      component: () => import('@/views/learn/ZoomImage'),
      meta: {},
    },
    {
      path: '/learn/svg',
      component: () => import('@/views/learn/MySvg'),
      meta: {},
    },
    {
      path: '/learn/interview',
      component: () => import('@/views/learn/Interview'),
      meta: {},
    }
  ],
});
