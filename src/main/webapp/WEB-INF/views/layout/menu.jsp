<%--
  Created by IntelliJ IDEA.
  User: SAKALAH
  Date: 2021/04/27
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<!-- BEGIN: Main Menu-->
<div class="main-menu menu-fixed menu-dark menu-accordion menu-shadow" data-scroll-to-active="true">
    <div class="main-menu-content">
        <ul class="navigation navigation-main" id="main-menu-navigation" data-menu="menu-navigation">
            <li class=" navigation-header"><span>THEBE</span><i class=" feather icon-minus" data-toggle="tooltip" data-placement="right" data-original-title="General"></i>
            </li>
            <%--  ADD MENU INCLUDES --%>
            <jsp:include page="menus/studentMenu.jsp"/>
            <jsp:include page="menus/tutorMenu.jsp"/>
        </ul>
    </div>
</div>
<!-- END: Main Menu-->
