<%--
  Created by IntelliJ IDEA.
  User: SAKALAH
  Date: 2021/04/27
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<!-- BEGIN: Header-->
<nav class="header-navbar navbar-expand-lg navbar navbar-with-menu fixed-top navbar-dark navbar-shadow">
    <div class="navbar-wrapper">
        <div class="navbar-header">
            <ul class="nav navbar-nav flex-row">
                <li class="nav-item mobile-menu d-lg-none mr-auto"><a class="nav-link nav-menu-main menu-toggle hidden-xs" href="#"><i class="feather icon-menu font-large-1"></i></a></li>
                <li class="nav-item mr-auto"><a class="navbar-brand" href="#">
                    <h4 style="text-align: center" class="brand-text">THEBE Challenge</h4></a></li>
                <li class="nav-item d-none d-lg-block nav-toggle"><a class="nav-link modern-nav-toggle pr-0" data-toggle="collapse"><i class="fa fa-bars icon-toggle-right font-medium-3 white" data-ticon="feather.icon-toggle-right"></i></a></li>
                <li class="nav-item d-lg-none"><a class="nav-link open-navbar-container" data-toggle="collapse" data-target="#navbar-mobile"><i class="fa fa-ellipsis-v"></i></a></li>
            </ul>
        </div>
        <div class="navbar-container content">
            <div class="collapse navbar-collapse" id="navbar-mobile">
                <ul class="nav navbar-nav mr-auto float-left">
                    <li class="nav-item d-none d-md-block"><a class="nav-link nav-link-expand" href="#"><i class="icon icon-size-fullscreen"<%--class="ficon feather icon-maximize"--%>></i></a></li>
                    <li class="nav-item nav-search"><a class="nav-link nav-link-search" href="#"><i class="fa fa-search"></i></a>
                        <div class="search-input">
                            <input class="input" type="text" placeholder="Explore Stack..." tabindex="0" data-search="template-search">
                            <div class="search-input-close"><i class="feather icon-x"></i></div>
                            <ul class="search-list"></ul>
                        </div>
                    </li>
                    <%--<li class="dropdown nav-item mega-dropdown d-none d-lg-block"><a class="dropdown-toggle nav-link" href="#">Aquatech Management System</a></li>--%>
                    <%--<p>Aquatech Management System</p>--%>
                </ul>
                <ul class="nav navbar-nav float-right">
                    <li class="dropdown dropdown-language nav-item"><a class="dropdown-toggle nav-link" id="dropdown-flag" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="flag-icon flag-icon-gb"></i><span class="selected-language"></span></a>
                        <div class="dropdown-menu" aria-labelledby="dropdown-flag"><a class="dropdown-item" href="#" data-language="en"><i class="flag-icon flag-icon-us"></i> English</a><a class="dropdown-item" href="#" data-language="fr"><i class="flag-icon flag-icon-fr"></i> French</a><a class="dropdown-item" href="#" data-language="pt"><i class="flag-icon flag-icon-pt"></i> Portuguese</a><a class="dropdown-item" href="#" data-language="de"><i class="flag-icon flag-icon-de"></i> German</a></div>
                    </li>
                    <li class="dropdown dropdown-user nav-item"><a class="dropdown-toggle nav-link dropdown-user-link" href="#" data-toggle="dropdown">
                        <div class="avatar avatar-online"><img src="app-assets/images/portrait/small/howard-s-28.jpg" alt="avatar"><i></i></div><span class="user-name">Howard Sakala</span></a>
                        <div class="dropdown-menu dropdown-menu-right"><a class="dropdown-item" href="#"><i class="feather icon-user"></i> Edit Profile</a>
                            <div class="dropdown-divider"></div><a class="dropdown-item" href="#"><i class="feather icon-power"></i> Logout</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>
<!-- END: Header-->

