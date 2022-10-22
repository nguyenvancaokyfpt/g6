<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div data-kt-place="true" data-kt-place-mode="prepend"
        data-kt-place-parent="{default: '#kt_content_container', 'lg': '#kt_toolbar_container'}"
        class="page-title d-flex align-items-center me-3 flex-wrap mb-5 mb-lg-0 lh-1">
        <!--begin::Title-->
        <h1 class="d-flex align-items-center text-dark fw-bolder my-1 fs-3">${brecrumbs.get(brecrumbs.size() -
            1).getTitle()}</h1>
        <!--end::Title-->
        <!--begin::Separator-->
        <span class="h-20px border-gray-200 border-start mx-4"></span>
        <!--end::Separator-->
        <!--begin::Breadcrumb-->
        <ul class="breadcrumb breadcrumb-separatorless fw-bold fs-7 my-1">
            <c:forEach items="${brecrumbs}" var="p">
                <li class="breadcrumb-item">
                    <span class="bullet bg-gray-200 w-5px h-2px"></span>
                </li>
                <!--begin::Item-->
                <li class="breadcrumb-item text-muted">
                    <a href="${p.getPath()}" class="text-muted text-hover-primary">${p.getTitle()}</a>
                </li>
                <!--end::Item-->
            </c:forEach>
        </ul>
        <!--end::Breadcrumb-->
    </div>

    <!--begin::Wrapper-->
    <div class="d-flex align-items-center">
        <!--begin::Input group-->
        <div class="me-6">
            <!--begin::Select-->
            <select class="form-select form-select-sm form-select-solid" data-control="select2" data-placeholder="Class"
                data-hide-search="true" data-width-resolve="true" name="system_class" style="width:150px;">
                <option value="0">Classroom</option>
                <c:forEach items="${USER_CLASS}" var="d">
                    <option value="${d.getClassId()}"><span class="me-6">${d.getClassCode()}</span></option>
                </c:forEach>
            </select>
            <!--end::Select-->
        </div>
        <!--end::Input group=-->
    </div>
    <!--end::Wrapper-->