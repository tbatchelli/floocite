<%@ page contentType="text/html;charset=UTF-8" %>
<div id="menu">
  <nobr>
    <g:isLoggedIn>
      <b> <g:loggedInUserInfo field="username"/></b> |
      <g:link controller="logout" action="index">Logout</g:link>
    </g:isLoggedIn>
    <g:isNotLoggedIn>
      <g:link controller="login" action="index">Login</g:link>
    </g:isNotLoggedIn>
  </nobr>
</div>