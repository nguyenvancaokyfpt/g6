<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="w" value="${requestScope.webContactDetails}" />
<section style="background-color: rgba(255,255,255,0.7)">
    <div class="container my-5 py-5">
        <button onclick="history.back()" type="button" class="btn btn-primary">Go back</button>
        <div class="row d-flex justify-content-center">
            <div class="col-md-12 col-lg-10 col-xl-8">
                <form action="/webcontact/webcontactlist" method="post">
                    <input type="hidden" name="webcontactid" value="${w.category_id}">
                    <input type="hidden" name="action" value="reply">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-start align-items-center">
                                <img class="rounded-circle shadow-1-strong me-3"
                                     src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(19).webp" alt="avatar"
                                     width="60" height="60" />
                                <div>
                                    <h2 class="fw-bold text-primary mb-1">${w.full_name}</h2>
                                    <p class="text-muted small mb-0">
                                        Email: ${w.email}<br>Mobile: ${w.mobile}
                                    </p>
                                </div>
                            </div>

                            <p class="mt-3 mb-4 pb-2">
                                ${w.message}
                            </p>

                            <div class="small d-flex justify-content-start">
                                <p href="#!" class="d-flex align-items-center me-3">
                                <p class="mb-0">Training Support System</p>
                                </p>
                                <p href="#!" class="d-flex align-items-center me-3">
                                <p class="mb-0">Learning</p>
                            </div>
                        </div>
                        <div class="card-footer py-3 border-0" style="background-color: #f8f9fa;">
                            <div class="d-flex flex-start w-100">
                                <img class="rounded-circle shadow-1-strong me-3"
                                     src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(19).webp" alt="avatar"
                                     width="40" height="40" />
                                <div class="form-outline w-100">
                                    <textarea class="form-control" id="textAreaExample" rows="4"
                                              style="background: #fff;" placeholder="Reply message" name="reply">
                                        ${w.response == 'not response'?'' : w.response}
                                    </textarea>
                                </div>
                            </div>
                            <div class="float-end mt-2 pt-1">
                                <button type="submit" class="btn btn-primary btn-sm">Rep</button>
                                <button onclick="history.back()" type="button"
                                        class="btn btn-outline-primary btn-sm">Cancel</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>