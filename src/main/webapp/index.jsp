<%-- 
    Document   : index
    Created on : Sep 17, 2022, 8:24:20 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><base href="">
        <meta charset="utf-8" />
        <title>Training support system</title>
        <meta name="description" content="Metronic admin dashboard live demo. Check out all the features of the admin panel. A large number of settings, additional services and widgets." />
        <meta name="keywords" content="Metronic, bootstrap, bootstrap 5, Angular 11, VueJs, React, Laravel, admin themes, web design, figma, web development, ree admin themes, bootstrap admin, bootstrap dashboard" />
        <link rel="canonical" href="Https://preview.keenthemes.com/metronic8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="shortcut icon" href="assets/media/logos/favicon.ico" />
        <!--begin::Fonts-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" />
        <!--end::Fonts-->
        <!--begin::Global Stylesheets Bundle(used by all pages)-->
        <link href="assets/plugins/global/plugins.bundle.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/style.bundle.css" rel="stylesheet" type="text/css" />
        <!--end::Global Stylesheets Bundle-->
    </head>
    <body id="kt_body" class="header-fixed header-tablet-and-mobile-fixed toolbar-enabled toolbar-fixed toolbar-tablet-and-mobile-fixed aside-enabled aside-fixed">

        <div class="d-flex flex-column flex-root">
            <div class="page d-flex flex-row flex-column-fluid">
                <jsp:include page="slidebar.jsp"></jsp:include>
                <div class="wrapper d-flex flex-column flex-row-fluid" id="kt_wrapper">
                    <jsp:include page="header.jsp"></jsp:include>  
                     <jsp:include page="dashboard.jsp"></jsp:include>
                    <jsp:include page="footer.jsp"></jsp:include>
                </div>
                </div>
            </div>
        
       
        <!--begin::Javascript-->
        <!--begin::Global Javascript Bundle(used by all pages)-->
        <script src="assets/plugins/global/plugins.bundle.js"></script>
        <script src="assets/js/scripts.bundle.js"></script>
        <!--end::Global Javascript Bundle-->
        <!--begin::Page Custom Javascript(used by this page)-->
        <script src="assets/js/custom/widgets.js"></script>
        <script src="assets/js/custom/apps/chat/chat.js"></script>
        <script src="assets/js/custom/modals/create-app.js"></script>
        <script src="assets/js/custom/modals/upgrade-plan.js"></script>
        <!--end::Page Custom Javascript-->
        <!--end::Javascript-->
    </body>
</html>
