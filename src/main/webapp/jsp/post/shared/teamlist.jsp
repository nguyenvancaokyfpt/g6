<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <style>
        .accordion {
            border: 1px solid #e4e6ef;
        }

        .accordion__button {
            display: block;
            width: 100%;
            padding: 15px;
            border: none;
            outline: none;
            cursor: pointer;
            background-color: #f8f9fa;
            color: black;
            font-weight: 600;
            text-align: left;
            transition: background 0.2s;
        }

        .accordion__button::before {
            content: '\25be';
            float: left;
            margin-right: 10px;
            transform: scale(1.5);
        }

        .Waiting::before {
            color: #cc6961;
        }

        /* .accordion__button--active + .accordion__content {
    display: block;
} */

        .accordion__button--active::before {
            content: '\25b4';
        }

        .accordion__content {
            overflow: hidden;
            max-height: 0;
            transition: max-height 0.2s;

            padding: 0 15px;

            /* display: none;
    overflow: auto; */
        }

        .memberItem {
            padding: 15px 0;
        }

        .btn-create {
            color: blue;
            text-decoration: underline;
            cursor: pointer;
            font-size: 13px;
            padding-left: 15px;
        }

        .create_notification {
            color: #cc6961;
            font-weight: 600;
            font-size: 16px;
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" />
    <div class="post d-flex flex-column-fluid" id="kt_post">
        <!--begin::Container-->
        <div id="kt_content_container" class="container">
            <!--begin::Card-->
            <div class="card">
                <div class="p-5 teamFilter">
                    <div class="row">
                        <div class="col-4">
                            <select id="selectedMile" style="margin-left:20x;" class="form-select"
                                onchange="getClass()">
                                <option value="" selected disabled>Select Milestone</option>
                                <c:forEach items="${requestScope.miles}" var="m">
                                    <option value="${m.milestoneId}">${m.title}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-4">
                            <select class="form-select">
                                <option>All Member Statuses</option>
                                <option value="1">Active</option>
                                <option value="0">Inactive</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div id="teamBody" style="padding-bottom: 50px;">

                </div>
            </div>
        </div>
    </div>