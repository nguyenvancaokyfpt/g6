<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    .container {
        background: #fff !important;
        border: none;
        border-radius: none
    }

    .abc {
        padding-left: 40px
    }

    .pqr {
        padding-right: 70px;
        padding-top: 14px
    }

    .para {
        padding-left: 40px;
    }

    .fa-star {
        color: yellow
    }

    li {
        list-style: none;
        line-height: 50px;
        color: #000
    }

    .col-md-2 {
        padding-bottom: 20px;
        font-weight: bold
    }

    .col-md-2 a {
        text-decoration: none;
        color: #000
    }

    .col-md-2.mio {
        font-size: 12px;
        padding-top: 7px
    }

    .des::after {
        content: '.';
        font-size: 0;
        display: block;
        border-radius: 20px;
        height: 6px;
        width: 55%;
        background: yellow;
        margin: 14px 0
    }

    .r4 {
        padding-left: 25px
    }

    .btn-outline-warning {
        border-radius: 0;
        border: 2px solid yellow;
        color: #000;
        font-size: 12px;
        font-weight: bold;
        width: 70%
    }

    @media screen and (max-width: 620px) {
        .container {
            width: 98%;
            display: flex;
            flex-flow: column;
            text-align: center
        }

        .des::after {
            content: '.';
            font-size: 0;
            display: block;
            border-radius: 20px;
            height: 6px;
            width: 35%;
            background: yellow;
            margin: 10px auto
        }

        .pqr {
            text-align: center;
            margin: 0 30px
        }

        .para {
            text-align: center;
            padding-left: 90px;
            padding-top: 10px
        }

        .klo {
            display: flex;
            text-align: center;
            margin: 0 auto;
            margin-right: 40px
        }
    }

    .btn.btn-primary {
        margin-bottom: 50px;
    }

    li {
        display: flex;
        align-items: center;
    }

    input,
    select,
    textarea {
        border: 1px solid rgba(0, 0, 0, 0.1);
    }

    label {
        display: inline-block;
        width: 100px;
    }
</style>
<c:set var="s" value="${requestScope.milestoneDetails}" />

<div class="container py-4 my-4 mx-auto d-flex flex-column">
    <div>
        <button onclick="history.back()" type="button" class="btn btn-primary">Go back</button>
    </div>
    <form action="/milestone/list" method="post">
        <input hidden type="text" name="action" value="update">
        <input hidden type="text" name="milestoneId" value="${s.milestoneId}">
        <div class="">
            <div class="row r1">
                <div class="col-md-9 abc">
                    <h1>
                        <label style="width: max-content">Milestone ID:</label>
                        <input type="text" class="form-control input-lg" name="milestoneId"
                               value="${s.milestoneId}">
                    </h1>
                </div>
                <p class="text-right para">
                    <label>Subject:</label>
                      <select name="subjectId">
                                <c:forEach items="${requestScope.subjectList}" var="u">
                                    <option value="${u.subjectId}" ${u.subjectId==s.subjectId?'selected':''}>
                                        ${u.subjectCode}
                                    </option>
                                </c:forEach>
                            </select>
                </p>
                  <p class="text-right para">
                    <label>Class Code</label>
                     <select name="classId">
                                <c:forEach items="${requestScope.classList}" var="u">
                                    <option value="${u.id}" ${u.id==s.classId?'selected':''}>
                                        ${u.classCode}
                                    </option>
                                </c:forEach>
                            </select>
                </p>
               
                  <p class="text-right para">
                    <label>From Date</label>
                    <input type="date" name="fromDate" value="${s.fromDate}">
                </p>
                  <p class="text-right para">
                    <label>To Date</label>
                    <input type="date" name="toDate" value="${s.toDate}">
                </p>
                    <p class="text-right para">
                    <label>Title</label>
                    <input type="text" name="title" value="${s.title}">
                </p>
                     <p class="text-right para">
                    <label>Assignment Body</label>
                    <input type="text" name="assBody" value="${s.assBody}">
                </p>
                <div>
                     <label>Description:</label>
                            <textarea name="description" rows="7" cols="50">
                                ${s.description}
                            </textarea>
                    </div>
                            <div>
                                <label>Status:</label>
                            <input type="radio" name="statusId" value="0"
                                   ${s.statusId==0?'checked':''}>Inactive&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="radio" name="statusId" value="1" ${s.statusId==1?'checked':''}>Active
                            </div>
            </div>
        </div>

        <div class="footer d-flex flex-column mt-5">
            <div class="row r4">
                <div class="col-md-2 myt ">
                    <button type="submit" class="btn btn-info">Update</button>
                </div>
            </div>
        </div>
    </form>
</div>