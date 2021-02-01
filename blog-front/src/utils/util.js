// 触发高频事件后n秒内函数只会执行一次,如果n秒内高频事件再次被触发,则重新计算时间 防抖
export function _debounce (fn, delay) {
  let timer = '';
  return function () {
    let th = this;
    let args = arguments;
    clearTimeout(timer);
    timer = setTimeout(function () {
      fn.apply(th, args);
    }, delay);
  };
}
// 限制发送频次 节流
export function _throttle (fn, interval) {
  let canRun = true;
  return function () {
    if (!canRun) return;
    else {
      canRun = false;
      fn.apply(this, arguments);
    }
    setTimeout(() => {
      canRun = true;
    }, interval);
  };
}
