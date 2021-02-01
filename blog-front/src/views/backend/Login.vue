<template>
  <div class="m-container-small m-padded-tb-massive" style="max-width: 30em">
    <div class="ui container">
      <div class="ui middle aligned center aligned grid">
        <div class="column">
          <h2 class="ui teal image header">
            <div class="content">
              博客登陆后台
            </div>
          </h2>
          <form class="ui large form" method="post">
            <div class="ui segment">
              <div class="field">
                <div class="ui left icon input">
                  <i class="user icon"></i>
                  <input type="text" v-model="username" placeholder="用户名" />
                </div>
              </div>
              <div class="field">
                <div class="ui left icon input">
                  <i class="lock icon"></i>
                  <input type="password" v-model="password" placeholder="密码" />
                </div>
              </div>
              <div class="ui fluid large teal submit button">登录</div>
            </div>

            <div class="ui error message"></div>
          </form>
<!--          <div class="ui message">新用户？ <a href="login.php#">注册</a></div>-->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      username: '',
      password: '',
    };
  },
};
</script>

<style scoped></style>
