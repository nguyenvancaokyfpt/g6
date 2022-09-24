<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    .btn.btn-primary{
        margin-bottom: 50px;
    }

    li{
        display: flex;
        align-items: center;
    }

    input, select, textarea{
        border: 1px solid rgba(0,0,0,0.1);
    }

    label{
        display: inline-block;
        width: 100px;
    }
</style>
<c:set var="s" value="${requestScope.subject}"/>

<div class="container py-4 my-4 mx-auto d-flex flex-column">
    <div>
        <button onclick="history.back()" type="button" class="btn btn-primary">Go back</button>
    </div>
    <form action="/subject/list" method="post">
        <input hidden type="text" name="action" value="update">
        <input hidden type="text" name="subjectId" value="${s.subjectId}">
        <div class="">
            <div class="row r1">
                <div class="col-md-9 abc">
                    <h1>
                        <label style="width: max-content">Subject Name:</label>
                        <input type="type" name="subjectName" value="${s.subjectName}">
                    </h1>
                </div>
                <p class="text-right para">
                    <label>Subject code:</label>
                    <input type="type" name="subjectCode" value="${s.subjectCode}">
                </p>
            </div>
        </div>
        <div class="container-body mt-4">
            <div class="row r3">
                <div class="col-md-5 p-0 klo">
                    <ul>
                        <li>
                            <label>Expert:</label>
                            <select name="expertId">
                                <c:forEach items="${requestScope.userList}" var="u">
                                    <option value="${u.userId}" 
                                            ${u.userId==s.expertId?'selected':''}>
                                        ${u.fullname}
                                    </option>
                                </c:forEach>
                            </select>
                        </li>
                        <li>
                            <label>Manager:</label>
                            <select name="managerId">
                                <c:forEach items="${requestScope.userList}" var="u">
                                    <option value="${u.userId}" 
                                            ${u.userId==s.managerId?'selected':''}>
                                        ${u.fullname}
                                    </option>
                                </c:forEach>
                            </select>
                        </li>
                        <li>
                            <label>Status:</label> 
                            <input type="radio" name="statusId" value="0" ${s.statusId==0?'checked':''}>Inactive&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="radio" name="statusId" value="1" ${s.statusId==1?'checked':''}>Active
                        </li>
                        <li>
                            <label>Description:</label>
                            <textarea name="body" rows="7" cols="50">
                                ${s.body}
                            </textarea>
                        </li>
                    </ul>
                </div>
                <div class="col-md-7"> <img src="https://images.pexels.com/photos/60597/dahlia-red-blossom-bloom-60597.jpeg" width="90%" height="95%"> </div>
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

