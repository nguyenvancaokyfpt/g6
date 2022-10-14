<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.tss.constants.ScreenConstants" %>

        <div id="kt_aside" class="aside aside-dark aside-hoverable" data-kt-drawer="true" data-kt-drawer-name="aside"
            data-kt-drawer-activate="{default: true, lg: false}" data-kt-drawer-overlay="true"
            data-kt-drawer-width="{default:'200px', '300px': '250px'}" data-kt-drawer-direction="start"
            data-kt-drawer-toggle="#kt_aside_mobile_toggle">
            <!--begin::Brand-->
            <div class="aside-logo flex-column-auto" id="kt_aside_logo">
                <!--begin::Logo-->
                <a href="/">
                    <img alt="Logo" src="assets/media/logos/logo-1.svg" class="h-15px logo" />
                </a>
                <!--end::Logo-->
                <!--begin::Aside toggler-->
                <div id="kt_aside_toggle" class="btn btn-icon w-auto px-0 btn-active-color-primary aside-toggle"
                    data-kt-toggle="true" data-kt-toggle-state="active" data-kt-toggle-target="body"
                    data-kt-toggle-name="aside-minimize">
                    <!--begin::Svg Icon | path: icons/duotone/Navigation/Angle-double-left.svg-->
                    <span class="svg-icon svg-icon-1 rotate-180">
                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px"
                            height="24px" viewBox="0 0 24 24" version="1.1">
                            <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                <polygon points="0 0 24 0 24 24 0 24" />
                                <path
                                    d="M5.29288961,6.70710318 C4.90236532,6.31657888 4.90236532,5.68341391 5.29288961,5.29288961 C5.68341391,4.90236532 6.31657888,4.90236532 6.70710318,5.29288961 L12.7071032,11.2928896 C13.0856821,11.6714686 13.0989277,12.281055 12.7371505,12.675721 L7.23715054,18.675721 C6.86395813,19.08284 6.23139076,19.1103429 5.82427177,18.7371505 C5.41715278,18.3639581 5.38964985,17.7313908 5.76284226,17.3242718 L10.6158586,12.0300721 L5.29288961,6.70710318 Z"
                                    fill="#000000" fill-rule="nonzero"
                                    transform="translate(8.999997, 11.999999) scale(-1, 1) translate(-8.999997, -11.999999)" />
                                <path
                                    d="M10.7071009,15.7071068 C10.3165766,16.0976311 9.68341162,16.0976311 9.29288733,15.7071068 C8.90236304,15.3165825 8.90236304,14.6834175 9.29288733,14.2928932 L15.2928873,8.29289322 C15.6714663,7.91431428 16.2810527,7.90106866 16.6757187,8.26284586 L22.6757187,13.7628459 C23.0828377,14.1360383 23.1103407,14.7686056 22.7371482,15.1757246 C22.3639558,15.5828436 21.7313885,15.6103465 21.3242695,15.2371541 L16.0300699,10.3841378 L10.7071009,15.7071068 Z"
                                    fill="#000000" fill-rule="nonzero" opacity="0.5"
                                    transform="translate(15.999997, 11.999999) scale(-1, 1) rotate(-270.000000) translate(-15.999997, -11.999999)" />
                            </g>
                        </svg>
                    </span>
                    <!--end::Svg Icon-->
                </div>
                <!--end::Aside toggler-->
            </div>
            <!--end::Brand-->
            <!--begin::Aside menu-->
            <div class="aside-menu flex-column-fluid">
                <!--begin::Aside Menu-->
                <div class="hover-scroll-overlay-y my-5 my-lg-5" id="kt_aside_menu_wrapper" data-kt-scroll="true"
                    data-kt-scroll-activate="{default: false, lg: true}" data-kt-scroll-height="auto"
                    data-kt-scroll-dependencies="#kt_aside_logo, #kt_aside_footer"
                    data-kt-scroll-wrappers="#kt_aside_menu" data-kt-scroll-offset="0">
                    <!--begin::Menu-->
                    <div class="menu menu-column menu-title-gray-800 menu-state-title-primary menu-state-icon-primary menu-state-bullet-primary menu-arrow-gray-500"
                        id="#kt_aside_menu" data-kt-menu="true">
                        <div class="menu-item ${screen == ScreenConstants.USER_DASHBOARD ? 'show' : ''}">
                            <a class="menu-link" href="${ScreenConstants.USER_DASHBOARD.getPath()}">
                                <span class="menu-icon">
                                    <!--begin::Svg Icon | path: icons/duotone/Design/PenAndRuller.svg-->
                                    <span class="svg-icon svg-icon-2">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24px" height="24px"
                                            viewBox="0 0 24 24" version="1.1">
                                            <path
                                                d="M3,16 L5,16 C5.55228475,16 6,15.5522847 6,15 C6,14.4477153 5.55228475,14 5,14 L3,14 L3,12 L5,12 C5.55228475,12 6,11.5522847 6,11 C6,10.4477153 5.55228475,10 5,10 L3,10 L3,8 L5,8 C5.55228475,8 6,7.55228475 6,7 C6,6.44771525 5.55228475,6 5,6 L3,6 L3,4 C3,3.44771525 3.44771525,3 4,3 L10,3 C10.5522847,3 11,3.44771525 11,4 L11,19 C11,19.5522847 10.5522847,20 10,20 L4,20 C3.44771525,20 3,19.5522847 3,19 L3,16 Z"
                                                fill="#000000" opacity="0.3" />
                                            <path
                                                d="M16,3 L19,3 C20.1045695,3 21,3.8954305 21,5 L21,15.2485298 C21,15.7329761 20.8241635,16.200956 20.5051534,16.565539 L17.8762883,19.5699562 C17.6944473,19.7777745 17.378566,19.7988332 17.1707477,19.6169922 C17.1540423,19.602375 17.1383289,19.5866616 17.1237117,19.5699562 L14.4948466,16.565539 C14.1758365,16.200956 14,15.7329761 14,15.2485298 L14,5 C14,3.8954305 14.8954305,3 16,3 Z"
                                                fill="#000000" />
                                        </svg>
                                    </span>
                                    <!--end::Svg Icon-->
                                </span>
                                <span class="menu-title">Dashboard</span>
                            </a>
                        </div>
                        <div class="menu-item">
                            <div class="menu-content pt-8 pb-2">
                                <span class="menu-section text-muted text-uppercase fs-8 ls-1">Menu</span>
                            </div>
                        </div>


                        <!-- Managerment -->
                        <c:if test="${permissionHelper.hasGroupPermissions('/management')}">
                            <div data-kt-menu-trigger="click"
                                class="menu-item menu-accordion ${screen.getParentPath() == '/management' ? 'show' : ''}">
                                <span class="menu-link">
                                    <span class="menu-icon">
                                        <!--begin::Svg Icon | path: icons/duotone/Code/Compiling.svg-->
                                        <span class="svg-icon svg-icon-2">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="24px" height="24px"
                                                viewBox="0 0 24 24" version="1.1">
                                                <path
                                                    d="M2.56066017,10.6819805 L4.68198052,8.56066017 C5.26776695,7.97487373 6.21751442,7.97487373 6.80330086,8.56066017 L8.9246212,10.6819805 C9.51040764,11.267767 9.51040764,12.2175144 8.9246212,12.8033009 L6.80330086,14.9246212 C6.21751442,15.5104076 5.26776695,15.5104076 4.68198052,14.9246212 L2.56066017,12.8033009 C1.97487373,12.2175144 1.97487373,11.267767 2.56066017,10.6819805 Z M14.5606602,10.6819805 L16.6819805,8.56066017 C17.267767,7.97487373 18.2175144,7.97487373 18.8033009,8.56066017 L20.9246212,10.6819805 C21.5104076,11.267767 21.5104076,12.2175144 20.9246212,12.8033009 L18.8033009,14.9246212 C18.2175144,15.5104076 17.267767,15.5104076 16.6819805,14.9246212 L14.5606602,12.8033009 C13.9748737,12.2175144 13.9748737,11.267767 14.5606602,10.6819805 Z"
                                                    fill="#000000" opacity="0.3" />
                                                <path
                                                    d="M8.56066017,16.6819805 L10.6819805,14.5606602 C11.267767,13.9748737 12.2175144,13.9748737 12.8033009,14.5606602 L14.9246212,16.6819805 C15.5104076,17.267767 15.5104076,18.2175144 14.9246212,18.8033009 L12.8033009,20.9246212 C12.2175144,21.5104076 11.267767,21.5104076 10.6819805,20.9246212 L8.56066017,18.8033009 C7.97487373,18.2175144 7.97487373,17.267767 8.56066017,16.6819805 Z M8.56066017,4.68198052 L10.6819805,2.56066017 C11.267767,1.97487373 12.2175144,1.97487373 12.8033009,2.56066017 L14.9246212,4.68198052 C15.5104076,5.26776695 15.5104076,6.21751442 14.9246212,6.80330086 L12.8033009,8.9246212 C12.2175144,9.51040764 11.267767,9.51040764 10.6819805,8.9246212 L8.56066017,6.80330086 C7.97487373,6.21751442 7.97487373,5.26776695 8.56066017,4.68198052 Z"
                                                    fill="#000000" />
                                            </svg>
                                        </span>
                                        <!--end::Svg Icon-->
                                    </span>
                                    <span class="menu-title">Managerment</span>
                                    <span class="menu-arrow"></span>
                                </span>
                                <div class="menu-sub menu-sub-accordion">
                                    <c:if test="${permissionHelper.hasPermission(ScreenConstants.USER_MANAGEMENT)}">
                                        <div class="menu-item">
                                            <a class="menu-link ${screen == ScreenConstants.USER_MANAGEMENT ? 'active' : ''}"
                                                href="${ScreenConstants.USER_MANAGEMENT.getPath()}">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">User</span>
                                            </a>
                                        </div>
                                    </c:if>
                                    <c:if test="${permissionHelper.hasPermission(ScreenConstants.TRAINEE_LIST)}">
                                        <div class="menu-item">
                                            <a class="menu-link ${screen == ScreenConstants.TRAINEE_LIST ? 'active' : ''}"
                                                href="${ScreenConstants.TRAINEE_LIST.getPath()}">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Trainee</span>
                                            </a>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </c:if>
                        <!-- End Managerment -->



                        <!-- Webcontact -->
                        <c:if test="${permissionHelper.hasGroupPermissions('/webcontact')}">
                            <div data-kt-menu-trigger="click"
                                class="menu-item menu-accordion ${screen.getParentPath() == '/webcontact' ? 'show' : ''}">
                                <span class="menu-link">
                                    <span class="menu-icon">
                                        <!--begin::Svg Icon | path: icons/duotone/Communication/Group-chat.svg-->
                                        <span class="svg-icon svg-icon-2">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="24px" height="24px"
                                                viewBox="0 0 24 24" version="1.1">
                                                <path
                                                    d="M16,15.6315789 L16,12 C16,10.3431458 14.6568542,9 13,9 L6.16183229,9 L6.16183229,5.52631579 C6.16183229,4.13107011 7.29290239,3 8.68814808,3 L20.4776218,3 C21.8728674,3 23.0039375,4.13107011 23.0039375,5.52631579 L23.0039375,13.1052632 L23.0206157,17.786793 C23.0215995,18.0629336 22.7985408,18.2875874 22.5224001,18.2885711 C22.3891754,18.2890457 22.2612702,18.2363324 22.1670655,18.1421277 L19.6565168,15.6315789 L16,15.6315789 Z"
                                                    fill="#000000" />
                                                <path
                                                    d="M1.98505595,18 L1.98505595,13 C1.98505595,11.8954305 2.88048645,11 3.98505595,11 L11.9850559,11 C13.0896254,11 13.9850559,11.8954305 13.9850559,13 L13.9850559,18 C13.9850559,19.1045695 13.0896254,20 11.9850559,20 L4.10078614,20 L2.85693427,21.1905292 C2.65744295,21.3814685 2.34093638,21.3745358 2.14999706,21.1750444 C2.06092565,21.0819836 2.01120804,20.958136 2.01120804,20.8293182 L2.01120804,18.32426 C1.99400175,18.2187196 1.98505595,18.1104045 1.98505595,18 Z M6.5,14 C6.22385763,14 6,14.2238576 6,14.5 C6,14.7761424 6.22385763,15 6.5,15 L11.5,15 C11.7761424,15 12,14.7761424 12,14.5 C12,14.2238576 11.7761424,14 11.5,14 L6.5,14 Z M9.5,16 C9.22385763,16 9,16.2238576 9,16.5 C9,16.7761424 9.22385763,17 9.5,17 L11.5,17 C11.7761424,17 12,16.7761424 12,16.5 C12,16.2238576 11.7761424,16 11.5,16 L9.5,16 Z"
                                                    fill="#000000" opacity="0.3" />
                                            </svg>
                                        </span>
                                        <!--end::Svg Icon-->
                                    </span>
                                    <span class="menu-title">Web Contact</span>
                                    <span class="menu-arrow"></span>
                                </span>
                                <div class="menu-sub menu-sub-accordion">
                                    <c:if test="${permissionHelper.hasPermission(ScreenConstants.WEB_CONTACT_LIST)}">
                                        <div class="menu-item">
                                            <a class="menu-link ${screen == ScreenConstants.WEB_CONTACT_LIST ? 'active' : ''}"
                                                href="${ScreenConstants.WEB_CONTACT_LIST.getPath()}">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Web Contact List</span>
                                            </a>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </c:if>
                        <!-- End Webcontact -->

                        <!-- Subject manager -->
                        <c:if test="${permissionHelper.hasGroupPermissions('/subject')}">
                            <div data-kt-menu-trigger="click"
                                class="menu-item menu-accordion ${screen.getParentPath() == '/subject' ? 'show' : ''}">
                                <span class="menu-link">
                                    <span class="menu-icon">
                                        <!--begin::Svg Icon | path: icons/duotone/Shopping/Box2.svg-->
                                        <span class="svg-icon svg-icon-2">
                                            <svg xmlns="http://www.w3.org/2000/svg"
                                                xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px"
                                                viewBox="0 0 24 24" version="1.1">
                                                <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                    <rect x="0" y="0" width="24" height="24" />
                                                    <path
                                                        d="M4,9.67471899 L10.880262,13.6470401 C10.9543486,13.689814 11.0320333,13.7207107 11.1111111,13.740321 L11.1111111,21.4444444 L4.49070127,17.526473 C4.18655139,17.3464765 4,17.0193034 4,16.6658832 L4,9.67471899 Z M20,9.56911707 L20,16.6658832 C20,17.0193034 19.8134486,17.3464765 19.5092987,17.526473 L12.8888889,21.4444444 L12.8888889,13.6728275 C12.9050191,13.6647696 12.9210067,13.6561758 12.9368301,13.6470401 L20,9.56911707 Z"
                                                        fill="#000000" />
                                                    <path
                                                        d="M4.21611835,7.74669402 C4.30015839,7.64056877 4.40623188,7.55087574 4.5299008,7.48500698 L11.5299008,3.75665466 C11.8237589,3.60013944 12.1762411,3.60013944 12.4700992,3.75665466 L19.4700992,7.48500698 C19.5654307,7.53578262 19.6503066,7.60071528 19.7226939,7.67641889 L12.0479413,12.1074394 C11.9974761,12.1365754 11.9509488,12.1699127 11.9085461,12.2067543 C11.8661433,12.1699127 11.819616,12.1365754 11.7691509,12.1074394 L4.21611835,7.74669402 Z"
                                                        fill="#000000" opacity="0.3" />
                                                </g>
                                            </svg>
                                        </span>
                                        <!--end::Svg Icon-->
                                    </span>
                                    <span class="menu-title">Subject</span>
                                    <span class="menu-arrow"></span>
                                </span>
                                <div class="menu-sub menu-sub-accordion">
                                    <c:if test="${permissionHelper.hasPermission(ScreenConstants.SUBJECT_LIST)}">
                                        <div class="menu-item ">
                                            <a class="menu-link ${screen == ScreenConstants.SUBJECT_LIST ? 'active' : ''}"
                                                href="${ScreenConstants.SUBJECT_LIST.getPath()}">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Subject List</span>
                                            </a>
                                        </div>
                                    </c:if>
                                    <c:if test="${permissionHelper.hasPermission(ScreenConstants.SUBJECT_SETTING)}">
                                        <div class="menu-item">
                                            <a class="menu-link ${screen == ScreenConstants.SUBJECT_SETTING ? 'active' : ''}"
                                                href="${ScreenConstants.SUBJECT_SETTING.getPath()}">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Subject Setting</span>
                                            </a>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </c:if>
                        <!-- End Subject manager -->
                        <!-- Milestone manager -->
                        <c:if test="${permissionHelper.hasGroupPermissions('/milestone')}">
                            <div data-kt-menu-trigger="click"
                                class="menu-item menu-accordion ${screen.getParentPath() == '/milestone' ? 'show' : ''}">
                                <span class="menu-link">
                                    <span class="menu-icon">
                                        <!--begin::Svg Icon | path: icons/duotone/Shopping/Box2.svg-->
                                        <span class="svg-icon svg-icon-2">
                                            <svg xmlns="http://www.w3.org/2000/svg"
                                                xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px"
                                                viewBox="0 0 24 24" version="1.1">
                                                <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                    <rect x="0" y="0" width="24" height="24" />
                                                    <path
                                                        d="M4,9.67471899 L10.880262,13.6470401 C10.9543486,13.689814 11.0320333,13.7207107 11.1111111,13.740321 L11.1111111,21.4444444 L4.49070127,17.526473 C4.18655139,17.3464765 4,17.0193034 4,16.6658832 L4,9.67471899 Z M20,9.56911707 L20,16.6658832 C20,17.0193034 19.8134486,17.3464765 19.5092987,17.526473 L12.8888889,21.4444444 L12.8888889,13.6728275 C12.9050191,13.6647696 12.9210067,13.6561758 12.9368301,13.6470401 L20,9.56911707 Z"
                                                        fill="#000000" />
                                                    <path
                                                        d="M4.21611835,7.74669402 C4.30015839,7.64056877 4.40623188,7.55087574 4.5299008,7.48500698 L11.5299008,3.75665466 C11.8237589,3.60013944 12.1762411,3.60013944 12.4700992,3.75665466 L19.4700992,7.48500698 C19.5654307,7.53578262 19.6503066,7.60071528 19.7226939,7.67641889 L12.0479413,12.1074394 C11.9974761,12.1365754 11.9509488,12.1699127 11.9085461,12.2067543 C11.8661433,12.1699127 11.819616,12.1365754 11.7691509,12.1074394 L4.21611835,7.74669402 Z"
                                                        fill="#000000" opacity="0.3" />
                                                </g>
                                            </svg>
                                        </span>
                                        <!--end::Svg Icon-->
                                    </span>
                                    <span class="menu-title">Milestone</span>
                                    <span class="menu-arrow"></span>
                                </span>
                                <div class="menu-sub menu-sub-accordion">
                                    <c:if test="${permissionHelper.hasPermission(ScreenConstants.MILESTONE_LIST)}">
                                        <div class="menu-item ">
                                            <a class="menu-link ${screen == ScreenConstants.MILESTONE_LIST ? 'active' : ''}"
                                                href="${ScreenConstants.MILESTONE_LIST.getPath()}">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title"> Milestone List</span>
                                            </a>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </c:if>
                        <!-- End Subject manager -->
                        <!-- Setting -->
                        <c:if test="${permissionHelper.hasGroupPermissions('/setting')}">
                            <div data-kt-menu-trigger="click"
                                class="menu-item menu-accordion ${screen.getParentPath() == '/setting' ? 'show' : ''}">
                                <span class="menu-link">
                                    <span class="menu-icon">
                                        <!--begin::Svg Icon | path: icons/duotone/Shopping/Box2.svg-->
                                        <span class="svg-icon svg-icon-2">
                                            <svg xmlns="http://www.w3.org/2000/svg"
                                                xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px"
                                                viewBox="0 0 24 24" version="1.1">
                                                <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                    <rect x="0" y="0" width="24" height="24" />
                                                    <path opacity="0.3"
                                                        d="M11.8 5.2L17.7 8.6V15.4L11.8 18.8L5.90001 15.4V8.6L11.8 5.2ZM11.8 2C11.5 2 11.2 2.1 11 2.2L3.8 6.4C3.3 6.7 3 7.3 3 7.9V16.2C3 16.8 3.3 17.4 3.8 17.7L11 21.9C11.3 22 11.5 22.1 11.8 22.1C12.1 22.1 12.4 22 12.6 21.9L19.8 17.7C20.3 17.4 20.6 16.8 20.6 16.2V7.9C20.6 7.3 20.3 6.7 19.8 6.4L12.6 2.2C12.4 2.1 12.1 2 11.8 2Z"
                                                        fill="currentColor" />
                                                    <path
                                                        d="M11.8 8.69995L8.90001 10.3V13.7L11.8 15.3L14.7 13.7V10.3L11.8 8.69995Z"
                                                        fill="currentColor" />
                                                </g>
                                            </svg>
                                        </span>
                                        <!--end::Svg Icon-->
                                    </span>
                                    <span class="menu-title">Setting</span>
                                    <span class="menu-arrow"></span>
                                </span>
                                <div class="menu-sub menu-sub-accordion">
                                    <c:if test="${permissionHelper.hasPermission(ScreenConstants.SETTING_SYSTEM_LIST)}">
                                        <div class="menu-item">
                                            <a class="menu-link ${screen == ScreenConstants.SETTING_SYSTEM_LIST ? 'active' : ''}"
                                                href="${ScreenConstants.SETTING_SYSTEM_LIST.getPath()}">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">System</span>
                                            </a>
                                        </div>
                                    </c:if>
                                    <c:if test="${permissionHelper.hasPermission(ScreenConstants.SETTING_ROLE_PERMISSIONS)}">
                                        <div class="menu-item">
                                            <a class="menu-link ${screen == ScreenConstants.SETTING_ROLE_PERMISSIONS ? 'active' : ''}"
                                                href="${ScreenConstants.SETTING_ROLE_PERMISSIONS.getPath()}">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Role Permission</span>
                                            </a>
                                        </div>
                                    </c:if>
                                    <c:if test="${permissionHelper.hasPermission(ScreenConstants.SETTING_CLASS)}">
                                        <div class="menu-item">
                                            <a class="menu-link ${screen == ScreenConstants.SETTING_CLASS ? 'active' : ''}"
                                                href="${ScreenConstants.SETTING_CLASS.getPath()}">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Class Setting</span>
                                            </a>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </c:if>
                        <!-- End Setting -->

                        <c:if test="${permissionHelper.hasGroupPermissions('/assignment')}">
                            <!-- Assignment -->
                            <div data-kt-menu-trigger="click"
                                class="menu-item menu-accordion ${screen.getParentPath() == '/assignment' ? 'show' : ''}">
                                <span class="menu-link">
                                    <span class="menu-icon">
                                        <!--begin::Svg Icon | path: icons/duotone/Shopping/Box2.svg-->
                                        <span class="svg-icon svg-icon-2">
                                            <svg xmlns="http://www.w3.org/2000/svg"
                                                xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px"
                                                viewBox="0 0 24 24" version="1.1">
                                                <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                    <polygon points="0 0 24 0 24 24 0 24"></polygon>
                                                    <path
                                                        d="M5.85714286,2 L13.7364114,2 C14.0910962,2 14.4343066,2.12568431 14.7051108,2.35473959 L19.4686994,6.3839416 C19.8056532,6.66894833 20,7.08787823 20,7.52920201 L20,20.0833333 C20,21.8738751 19.9795521,22 18.1428571,22 L5.85714286,22 C4.02044787,22 4,21.8738751 4,20.0833333 L4,3.91666667 C4,2.12612489 4.02044787,2 5.85714286,2 Z"
                                                        fill="#000000" fill-rule="nonzero" opacity="0.3"></path>
                                                    <rect fill="#000000" x="6" y="11" width="9" height="2" rx="1">
                                                    </rect>
                                                    <rect fill="#000000" x="6" y="15" width="5" height="2" rx="1">
                                                    </rect>
                                                </g>
                                            </svg>
                                        </span>
                                        <!--end::Svg Icon-->
                                    </span>
                                    <span class="menu-title">Assignment</span>
                                    <span class="menu-arrow"></span>
                                </span>
                                <div class="menu-sub menu-sub-accordion">
                                    <c:if test="${permissionHelper.hasPermission(ScreenConstants.ASSIGNNMENT_LIST)}">
                                        <div class="menu-item ">
                                            <a class="menu-link ${screen == ScreenConstants.ASSIGNNMENT_LIST ? 'active' : ''}"
                                                href="${ScreenConstants.ASSIGNNMENT_LIST.getPath()}">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Assignment List</span>
                                            </a>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <!-- End Assignment -->
                        </c:if>


                        <c:if test="${permissionHelper.hasGroupPermissions('/evalCriteria')}">
                            <!-- Eval -->
                            <div data-kt-menu-trigger="click"
                                class="menu-item menu-accordion ${screen.getParentPath() == '/evalCriteria' ? 'show' : ''}">
                                <span class="menu-link">
                                    <span class="menu-icon">
                                        <!--begin::Svg Icon | path: icons/duotone/Shopping/Box2.svg-->
                                        <span class="svg-icon svg-icon-2">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="24px" height="24px"
                                                viewBox="0 0 24 24" version="1.1">
                                                <path
                                                    d="M7,11 L15,11 C16.1045695,11 17,10.1045695 17,9 L17,8 L19,8 L19,9 C19,11.209139 17.209139,13 15,13 L7,13 L7,15 C7,15.5522847 6.55228475,16 6,16 C5.44771525,16 5,15.5522847 5,15 L5,9 C5,8.44771525 5.44771525,8 6,8 C6.55228475,8 7,8.44771525 7,9 L7,11 Z"
                                                    fill="#000000" opacity="0.3"></path>
                                                <path
                                                    d="M6,21 C7.1045695,21 8,20.1045695 8,19 C8,17.8954305 7.1045695,17 6,17 C4.8954305,17 4,17.8954305 4,19 C4,20.1045695 4.8954305,21 6,21 Z M6,23 C3.790861,23 2,21.209139 2,19 C2,16.790861 3.790861,15 6,15 C8.209139,15 10,16.790861 10,19 C10,21.209139 8.209139,23 6,23 Z"
                                                    fill="#000000" fill-rule="nonzero"></path>
                                                <path
                                                    d="M18,7 C19.1045695,7 20,6.1045695 20,5 C20,3.8954305 19.1045695,3 18,3 C16.8954305,3 16,3.8954305 16,5 C16,6.1045695 16.8954305,7 18,7 Z M18,9 C15.790861,9 14,7.209139 14,5 C14,2.790861 15.790861,1 18,1 C20.209139,1 22,2.790861 22,5 C22,7.209139 20.209139,9 18,9 Z"
                                                    fill="#000000" fill-rule="nonzero"></path>
                                                <path
                                                    d="M6,7 C7.1045695,7 8,6.1045695 8,5 C8,3.8954305 7.1045695,3 6,3 C4.8954305,3 4,3.8954305 4,5 C4,6.1045695 4.8954305,7 6,7 Z M6,9 C3.790861,9 2,7.209139 2,5 C2,2.790861 3.790861,1 6,1 C8.209139,1 10,2.790861 10,5 C10,7.209139 8.209139,9 6,9 Z"
                                                    fill="#000000" fill-rule="nonzero"></path>
                                            </svg>
                                        </span>
                                        <!--end::Svg Icon-->
                                    </span>
                                    <span class="menu-title">Eval Criteria</span>
                                    <span class="menu-arrow"></span>
                                </span>
                                <div class="menu-sub menu-sub-accordion">
                                    <c:if test="${permissionHelper.hasPermission(ScreenConstants.EVALCRITERIA_LIST)}">
                                        <div class="menu-item">
                                            <a class="menu-link ${screen == ScreenConstants.EVALCRITERIA_LIST ? 'active' : ''}"
                                                href="${ScreenConstants.EVALCRITERIA_LIST.getPath()}">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Eval Criteria List</span>
                                            </a>
                                        </div>
                                    </c:if>
                                    <c:if
                                        test="${permissionHelper.hasPermission(ScreenConstants.CLASS_EVAL_CRITERIA_LIST)}">
                                        <div class="menu-item">
                                            <a class="menu-link ${screen == ScreenConstants.CLASS_EVAL_CRITERIA_LIST ? 'active' : ''}"
                                                href="${ScreenConstants.CLASS_EVAL_CRITERIA_LIST.getPath()}">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Class Eval Criteria List</span>
                                            </a>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <!-- End Eval -->
                        </c:if>

                        <c:if test="${permissionHelper.hasGroupPermissions('/schedule')}">
                            <!-- SCHEDULE -->
                            <div data-kt-menu-trigger="click"
                                class="menu-item menu-accordion ${screen.getParentPath() == '/schedule' ? 'show' : ''}">
                                <span class="menu-link">
                                    <span class="menu-icon">
                                        <!--begin::Svg Icon | path: icons/duotone/Shopping/Box2.svg-->
                                        <span class="svg-icon svg-icon-2">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="24px" height="24px"
                                                viewBox="0 0 24 24" version="1.1">
                                                <path
                                                    d="M10.9630156,7.5 L11.0475062,7.5 C11.3043819,7.5 11.5194647,7.69464724 11.5450248,7.95024814 L12,12.5 L15.2480695,14.3560397 C15.403857,14.4450611 15.5,14.6107328 15.5,14.7901613 L15.5,15 C15.5,15.2109164 15.3290185,15.3818979 15.1181021,15.3818979 C15.0841582,15.3818979 15.0503659,15.3773725 15.0176181,15.3684413 L10.3986612,14.1087258 C10.1672824,14.0456225 10.0132986,13.8271186 10.0316926,13.5879956 L10.4644883,7.96165175 C10.4845267,7.70115317 10.7017474,7.5 10.9630156,7.5 Z"
                                                    fill="#000000" />
                                                <path
                                                    d="M7.38979581,2.8349582 C8.65216735,2.29743306 10.0413491,2 11.5,2 C17.2989899,2 22,6.70101013 22,12.5 C22,18.2989899 17.2989899,23 11.5,23 C5.70101013,23 1,18.2989899 1,12.5 C1,11.5151324 1.13559454,10.5619345 1.38913364,9.65805651 L3.31481075,10.1982117 C3.10672013,10.940064 3,11.7119264 3,12.5 C3,17.1944204 6.80557963,21 11.5,21 C16.1944204,21 20,17.1944204 20,12.5 C20,7.80557963 16.1944204,4 11.5,4 C10.54876,4 9.62236069,4.15592757 8.74872191,4.45446326 L9.93948308,5.87355717 C10.0088058,5.95617272 10.0495583,6.05898805 10.05566,6.16666224 C10.0712834,6.4423623 9.86044965,6.67852665 9.5847496,6.69415008 L4.71777931,6.96995273 C4.66931162,6.97269931 4.62070229,6.96837279 4.57348157,6.95710938 C4.30487471,6.89303938 4.13906482,6.62335149 4.20313482,6.35474463 L5.33163823,1.62361064 C5.35654118,1.51920756 5.41437908,1.4255891 5.49660017,1.35659741 C5.7081375,1.17909652 6.0235153,1.2066885 6.2010162,1.41822583 L7.38979581,2.8349582 Z"
                                                    fill="#000000" opacity="0.3" />
                                            </svg>
                                        </span>
                                        <!--end::Svg Icon-->
                                    </span>
                                    <span class="menu-title">Schedule</span>
                                    <span class="menu-arrow"></span>
                                </span>
                                <div class="menu-sub menu-sub-accordion">
                                    <c:if test="${permissionHelper.hasPermission(ScreenConstants.SCHEDULE_LIST)}">
                                        <div class="menu-item">
                                            <a class="menu-link ${screen == ScreenConstants.SCHEDULE_LIST ? 'active' : ''}"
                                                href="${ScreenConstants.SCHEDULE_LIST.getPath()}">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Schedule List</span>
                                            </a>
                                        </div>
                                    </c:if>
                                    <c:if test="${permissionHelper.hasPermission(ScreenConstants.SCHEDULE_ATTENDACE)}">
                                        <div class="menu-item">
                                            <a class="menu-link ${screen == ScreenConstants.SCHEDULE_ATTENDACE ? 'active' : ''}"
                                                href="${ScreenConstants.SCHEDULE_ATTENDACE.getPath()}">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Schedule Attendance</span>
                                            </a>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <!-- End SCHEDULE -->
                        </c:if>

                        <c:if test="${permissionHelper.hasGroupPermissions('/attendance')}">
                            <!-- ATTENDANCE -->
                            <div data-kt-menu-trigger="click"
                                class="menu-item menu-accordion ${screen.getParentPath() == '/attendance' ? 'show' : ''}">
                                <span class="menu-link">
                                    <span class="menu-icon">
                                        <!--begin::Svg Icon | path: icons/duotone/Shopping/Box2.svg-->
                                        <span class="svg-icon svg-icon-2">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="24px" height="24px"
                                                viewBox="0 0 24 24" version="1.1">
                                                <path
                                                    d="M8,3 L8,3.5 C8,4.32842712 8.67157288,5 9.5,5 L14.5,5 C15.3284271,5 16,4.32842712 16,3.5 L16,3 L18,3 C19.1045695,3 20,3.8954305 20,5 L20,21 C20,22.1045695 19.1045695,23 18,23 L6,23 C4.8954305,23 4,22.1045695 4,21 L4,5 C4,3.8954305 4.8954305,3 6,3 L8,3 Z"
                                                    fill="#000000" opacity="0.3" />
                                                <path
                                                    d="M11,2 C11,1.44771525 11.4477153,1 12,1 C12.5522847,1 13,1.44771525 13,2 L14.5,2 C14.7761424,2 15,2.22385763 15,2.5 L15,3.5 C15,3.77614237 14.7761424,4 14.5,4 L9.5,4 C9.22385763,4 9,3.77614237 9,3.5 L9,2.5 C9,2.22385763 9.22385763,2 9.5,2 L11,2 Z"
                                                    fill="#000000" />
                                                <rect fill="#000000" opacity="0.3" x="10" y="9" width="7" height="2"
                                                    rx="1" />
                                                <rect fill="#000000" opacity="0.3" x="7" y="9" width="2" height="2"
                                                    rx="1" />
                                                <rect fill="#000000" opacity="0.3" x="7" y="13" width="2" height="2"
                                                    rx="1" />
                                                <rect fill="#000000" opacity="0.3" x="10" y="13" width="7" height="2"
                                                    rx="1" />
                                                <rect fill="#000000" opacity="0.3" x="7" y="17" width="2" height="2"
                                                    rx="1" />
                                                <rect fill="#000000" opacity="0.3" x="10" y="17" width="7" height="2"
                                                    rx="1" />
                                            </svg>
                                        </span>
                                        <!--end::Svg Icon-->
                                    </span>
                                    <span class="menu-title">Attendance</span>
                                    <span class="menu-arrow"></span>
                                </span>
                                <div class="menu-sub menu-sub-accordion">
                                    <c:if test="${permissionHelper.hasPermission(ScreenConstants.ATTENDANCE_TRACKING)}">
                                        <div class="menu-item">
                                            <a class="menu-link ${screen == ScreenConstants.ATTENDANCE_TRACKING ? 'active' : ''}"
                                                href="${ScreenConstants.ATTENDANCE_TRACKING.getPath()}">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Attendance Tracking</span>
                                            </a>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <!-- End ATTENDANCE -->
                        </c:if>

                        <c:if test="${permissionHelper.hasGroupPermissions('/team')}">
                            <!-- TEAM -->
                            <div data-kt-menu-trigger="click"
                                class="menu-item menu-accordion ${screen.getParentPath() == '/team' ? 'show' : ''}">
                                <span class="menu-link">
                                    <span class="menu-icon">
                                        <!--begin::Svg Icon | path: icons/duotone/Shopping/Box2.svg-->
                                        <span class="svg-icon svg-icon-2">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="24px" height="24px"
                                                viewBox="0 0 24 24" version="1.1">
                                                <path
                                                    d="M18,14 C16.3431458,14 15,12.6568542 15,11 C15,9.34314575 16.3431458,8 18,8 C19.6568542,8 21,9.34314575 21,11 C21,12.6568542 19.6568542,14 18,14 Z M9,11 C6.790861,11 5,9.209139 5,7 C5,4.790861 6.790861,3 9,3 C11.209139,3 13,4.790861 13,7 C13,9.209139 11.209139,11 9,11 Z"
                                                    fill="#000000" fill-rule="nonzero" opacity="0.3" />
                                                <path
                                                    d="M17.6011961,15.0006174 C21.0077043,15.0378534 23.7891749,16.7601418 23.9984937,20.4 C24.0069246,20.5466056 23.9984937,21 23.4559499,21 L19.6,21 C19.6,18.7490654 18.8562935,16.6718327 17.6011961,15.0006174 Z M0.00065168429,20.1992055 C0.388258525,15.4265159 4.26191235,13 8.98334134,13 C13.7712164,13 17.7048837,15.2931929 17.9979143,20.2 C18.0095879,20.3954741 17.9979143,21 17.2466999,21 C13.541124,21 8.03472472,21 0.727502227,21 C0.476712155,21 -0.0204617505,20.45918 0.00065168429,20.1992055 Z"
                                                    fill="#000000" fill-rule="nonzero" />
                                            </svg>
                                        </span>
                                        <!--end::Svg Icon-->
                                    </span>
                                    <span class="menu-title">Team</span>
                                    <span class="menu-arrow"></span>
                                </span>
                                <div class="menu-sub menu-sub-accordion">
                                    <c:if test="${permissionHelper.hasPermission(ScreenConstants.TEAM_LIST)}">
                                        <div class="menu-item">
                                            <a class="menu-link ${screen == ScreenConstants.TEAM_LIST ? 'active' : ''}"
                                                href="${ScreenConstants.TEAM_LIST.getPath()}">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Team List</span>
                                            </a>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <!-- End TEAM -->
                        </c:if>

                        <c:if test="${permissionHelper.hasGroupPermissions('/issue')}">
                            <!-- Issue -->
                            <div data-kt-menu-trigger="click"
                                class="menu-item menu-accordion ${screen.getParentPath() == '/issue' ? 'show' : ''}">
                                <span class="menu-link">
                                    <span class="menu-icon">
                                        <!--begin::Svg Icon | path: icons/duotone/Shopping/Box2.svg-->
                                        <span class="svg-icon svg-icon-2">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="24px" height="24px"
                                                viewBox="0 0 24 24" version="1.1">
                                                <circle fill="#000000" opacity="0.3" cx="12" cy="12" r="10"/>
                                                <rect fill="#000000" x="11" y="10" width="2" height="7" rx="1"/>
                                                <rect fill="#000000" x="11" y="7" width="2" height="2" rx="1"/>
                                            </svg>
                                        </span>
                                        <!--end::Svg Icon-->
                                    </span>
                                    <span class="menu-title">Issue</span>
                                    <span class="menu-arrow"></span>
                                </span>
                                <div class="menu-sub menu-sub-accordion">
                                    <c:if test="${permissionHelper.hasPermission(ScreenConstants.ISSUE_LIST)}">
                                        <div class="menu-item">
                                            <a class="menu-link ${screen == ScreenConstants.ISSUE_LIST ? 'active' : ''}"
                                                href="${ScreenConstants.ISSUE_LIST.getPath()}">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Issue List</span>
                                            </a>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <!-- End TEAM -->
                        </c:if>

                    </div>

                    <!--end::Menu-->
                </div>
            </div>
            <!--end::Aside menu-->
        </div>