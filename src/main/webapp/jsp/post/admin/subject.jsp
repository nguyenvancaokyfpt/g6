<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    label{
        width: 100px;
        margin: 5px 0;
    }
</style>
<div>
    <button type="button" class="btn btn-primary" 
            style="float: right; margin-right: 200px" data-bs-toggle="modal" 
            data-bs-target="#addSubject">
        Add Subject
    </button>
</div>
<section class="bg-light py-4 my-5">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2 class="mb-3 text-primary">Subject List</h2>
            </div>
            <c:forEach items="${requestScope.subjectList}" var="s">
                <div class="col-md-6 col-lg-4">
                    <div class="card my-3 subject_card">
                        <img onclick="viewDetails('${s.subjectId}', 'get')" src="https://images.pexels.com/photos/325185/pexels-photo-325185.jpeg"
                             class="card-image-top" alt="thumbnail">
                        <div class="card-body">
                            <h3  class="card-title">
                                <a onclick="viewDetails('${s.subjectId}', 'get')" style="color: #181c32">${s.subjectName}</a>
                            </h3>
                            <p class="card-text subject_des">
                                ${s.body}
                            </p>
                            <a onclick="viewDetails('${s.subjectId}', 'get')" class="btn btn-primary">Read More</a>
                            <c:if test="${s.statusId==1}">
                                <button onclick="loaddata('${s.subjectId}', '${s.subjectName}', 'inactive')" 
                                        type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                    Inactive
                                </button>
                            </c:if>
                            <c:if test="${s.statusId!=1}">
                                <button onclick="loaddata('${s.subjectId}', '${s.subjectName}', 'active')" 
                                        type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                    Active
                                </button>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>

            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-end">
                    <c:forEach items="${requestScope.pages}" var="p">
                        <li class="page-item">
                            <a class="page-link" href="/subject/list?pageNo=${p}">${p}</a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
    </div>
</section>

<form hidden id="callPost" action="/subject/list" method="post">
    <input type="text" value="" name="subjectId" id="subjectId"/>
    <input type="text" value="" name="action" id="action"/>
</form>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Subject</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" id="content_modal">

            </div>
            <div class="modal-footer">
                <button id="btn_cf" onclick="cf()" type="button" class="btn btn-primary">Confirm</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


<!--add subject-->
<div class="modal fade" id="addSubject" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add Subject</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/subject/list" method="post">
                <div class="modal-body">
                    <input hidden type="text" name="action" value="create">
                    <div class="">
                        <div class="row r1">
                            <div class="col-md-9 abc">
                                <h1>
                                    <label style="width: max-content">Subject Name:</label>
                                    <input type="type" name="subjectName">
                                </h1>
                            </div>
                            <p class="text-right para">
                                <label>Subject code:</label>
                                <input type="type" name="subjectCode">
                            </p>
                        </div>
                    </div>
                    <div class="container-body mt-4">
                        <div class="row r3">
                            <div class="col-md-10 p-0 klo">
                                <ul>
                                    <li>
                                        <label>Expert:</label>
                                        <select name="expertId">
                                            <c:forEach items="${requestScope.userList}" var="u">
                                                <option value="${u.userId}">
                                                    ${u.fullname}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </li>
                                    <li>
                                        <label>Manager:</label>
                                        <select name="managerId">
                                            <c:forEach items="${requestScope.userList}" var="u">
                                                <option value="${u.userId}">
                                                    ${u.fullname}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </li>
                                    <li>
                                        <label>Status:</label> 
                                        <input type="radio" name="statusId" value="0">Inactive&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="radio" name="statusId" value="1" checked>Active
                                    </li>
                                    <li>
                                        <label>Description:</label>
                                        <textarea name="body" rows="7" cols="50">
                                            
                                        </textarea>
                                    </li>
                                </ul>
                            </div>
                            <!--<div class="col-md-7"> <img src="https://images.pexels.com/photos/60597/dahlia-red-blossom-bloom-60597.jpeg" width="90%" height="95%"> </div>-->
                        </div>
                    </div>
                </div> 
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Add</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    var myModal = document.getElementById('myModal');
    var myInput = document.getElementById('myInput');

    myModal.addEventListener('shown.bs.modal', function () {
        myInput.focus();
    });

    var subjectId;
    var action;
    function loaddata(x, y, z) {
        document.getElementById('content_modal').innerHTML = "Do you want to " + z + " this " + y + " ?";
        subjectId = x;
        action = z;
    }

    function viewDetails(x, y) {
        document.getElementById('subjectId').value = x;
        document.getElementById('action').value = y;
        document.getElementById('callPost').submit();
    }

    function inactive() {
        document.getElementById('subjectId').value = subjectId;
        document.getElementById('action').value = 'inactive';
        document.getElementById('callPost').submit();
    }

    function active() {
        document.getElementById('subjectId').value = subjectId;
        document.getElementById('action').value = 'active';
        document.getElementById('callPost').submit();
    }

    function cf() {
        if (action === 'inactive') {
            document.getElementById('btn_cf').onclick = inactive();
        } else if (action === 'active') {
            document.getElementById('btn_cf').onclick = active();
        }
    }

</script>