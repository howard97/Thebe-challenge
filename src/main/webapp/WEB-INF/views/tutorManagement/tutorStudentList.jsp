<%--
  Created by IntelliJ IDEA.
  User: SAKALAH
  Date: 2021/08/06
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: SAKALAH
  Date: 2021/04/27
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="loading" lang="en" data-textdirection="ltr">
<!-- BEGIN: Head-->

<!-- Mirrored from pixinvent.com/stack-responsive-bootstrap-4-admin-template/html/ltr/vertical-modern-menu-template/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 26 Apr 2021 16:58:50 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>THEBE | CHALLENGE</title>
    <%-- <link rel="apple-touch-icon" href="../../../../app-assets/images/ico/apple-icon-120.png">
     <link rel="shortcut icon" type="image/x-icon" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/images/ico/favicon.ico">
     --%>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">

    <!-- BEGIN: Vendor CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/vendors.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/animate/animate.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/sweetalert2.min.css">
    <!-- END: Vendor CSS-->

    <!-- BEGIN: Theme CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/colors.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/components.min.css">
    <!-- END: Theme CSS-->

    <!-- BEGIN: Page CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-menu-modern.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/colors/palette-gradient.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/simple-line-icons/style.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/card-statistics.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/vertical-timeline.min.css">
    <!-- END: Page CSS-->

    <!-- BEGIN: Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END: Custom CSS-->

</head>
<!-- END: Head-->

<!-- BEGIN: Body-->
<body class="vertical-layout vertical-menu-modern 2-columns   fixed-navbar" data-open="click" data-menu="vertical-menu-modern" data-col="2-columns">
<!-- BEGIN: Header-->
<jsp:include page="../layout/navigationBar.jsp"/>
<!-- END: Header-->
<!-- BEGIN: Main Menu-->
<jsp:include page="../layout/menu.jsp"/>
<!-- END: Main Menu-->

<!--Begin: Main Content Here-->
<div class="app-content content">
    <div class="content-overlay"></div>
    <div class="content-wrapper">
        <div class="content-header row">
            <div class="content-header-left col-md-6 col-12 mb-2">
            </div>
            <div class="content-header-right col-md-6 col-12 mb-md-0 mb-2">
            </div>
        </div>

        <%--ADD CODE HERE--%>
        <div class="content-body"><!-- Zero configuration table -->
            <section id="configuration">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                 <span style="font-size: 1.2em;">
                                    <i class="fa fa-info-circle"></i>
                                    <strong>CHOOSE TUTOR MENU</strong>
                                    </span>
                                <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                                <div class="heading-elements">
                                    <ul class="list-inline mb-0">
                                        <li><a data-action="expand"><i class="feather icon-maximize"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="card-content collapse show">
                                <div class="card-body card-dashboard">
                                    <p class="card-text">List Of Students and tutors.</p>
                                    <table id="childrenTask" class="table table-striped table-bordered zero-configuration">
                                        <thead>
                                        <tr>
                                            <th>Student FirstName</th>
                                            <th>Student LastName</th>
                                            <th>Tutors</th>
                                            <th>Action</th>
                                        </tr>
                                        </thead>
                                          <tbody>
                                         <c:forEach var="item" items="${students}">
                                          <tr>
                                              <td>${item.firstName}</td>
                                              <td>${item.lastName}</td>
                                             <c:forEach var="tutor" items="${tutorList}">
                                              <td><select>
                                                  <option value="" selected>Select Tutor</option>
                                                  <option value="${tutor.id}">${tutor.firstName}${tutor.lastName}</option>
                                              </select></td>
                                              <th>
                                                  <input id="studentId" name="studentId" value="${item.id}" type="hidden">
                                                  <input id="tutorId" name="tutorId" value="${tutor.id}" type="hidden">
                                                  <button type="button" class="btn btn-primary"><a href="assignTutorToStudent/${item.id}?tutorId=${tutor.id}"><i class="fa fa-edit"></i></a></button>
                                              </th>
                                             </c:forEach>
                                          </tr>
                                         </c:forEach>
                                          </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <%--END HERE--%>
        </div>
    </div>
</div>


<!--End: Main Content Here-->


<!-- BEGIN: Footer-->
<jsp:include page="../layout/footer.jsp"/>
<!-- END: Footer-->

<!-- BEGIN: Vendor JS-->
<script src="app-assets/vendors/js/vendors.min.js"></script>
<!-- BEGIN Vendor JS-->

<!-- BEGIN: Page Vendor JS-->
<script src="app-assets/vendors/js/charts/apexcharts/apexcharts.min.js"></script>
<!-- END: Page Vendor JS-->

<!-- BEGIN: Theme JS-->
<script src="app-assets/js/core/app-menu.min.js"></script>
<script src="app-assets/js/core/app.min.js"></script>
<script src="app-assets/js/scripts/customizer.min.js"></script>
<!-- END: Theme JS-->


<!-- BEGIN: Page JS-->
<script src="app-assets/js/scripts/cards/card-statistics.min.js"></script>
<script src="app-assets/vendors/js/extensions/sweetalert2.all.min.js"></script>
<!-- END: Page JS-->
<!--BEGIN: PUT YOUR JAVASCRIPT HERE-->
<script src="app-assets/js/tutorManagement/tutorStudent.js"></script>
<!--END: PUT YOUR JAVASCRIPT HERE-->

</body>
<!-- END: Body-->

<!-- Mirrored from pixinvent.com/stack-responsive-bootstrap-4-admin-template/html/ltr/vertical-modern-menu-template/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 26 Apr 2021 16:58:55 GMT -->
</html>
