<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../../../assets/css/teamlist.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" />
<div class="post d-flex flex-column-fluid" id="kt_post">
    <!--begin::Container-->
    <div id="kt_content_container" class="container-fluid">
        <!--begin::Card-->
        <div class="card">
            <div class="p-5 teamFilter">
                <div class="row">
                    <div class="col-4">
                        <select id="selectedMile" style="margin-left:20x;" class="form-select"
                                onchange="getClass()">
                            <option value="" selected disabled>Select Milestone</option>
                            <c:forEach items="${requestScope.miles}" var="m">
                                <option value="${m.milestoneId}">${m.title} - ${m.classCode}</option>
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

            <!-- Example model popup -->
            <!-- <a type="button" class="dropdown-item text-center" data-bs-toggle="modal" data-bs-target="#model1">Deactivate </a>
            <div class="modal fade" id="model1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" style="display: none;">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h5 class="modal-title" id="exampleModalLabel">Comfirm</h5>
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                      Do you want to Deactivate this Eval Criteria?
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                      <a class="btn btn-primary" href="/evalCriteria/evalCriteriaDetails?action=changeStatus&amp;evalId=1&amp;status=1">Deactivate</a>
                    </div>
                  </div>
                </div>
              </div> -->
        </div>
    </div>
</div>