<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.tss.constants.SessionConstants" %>
<div class="footer py-4 d-flex flex-lg-column" id="kt_footer" style="background-color: #181c2c;">
    <!--begin::Container-->
    <div
        class="container-fluid d-flex flex-column">
        <div class="d-flex flex-md-row align-items-center justify-content-between">
        <!--begin::Copyright-->
        <div class="text-gray-100 order-2 order-md-1">
            
            <a href="" target="_blank" class="text-gray-100 text-hover-primary">Gi?i Thi?u</a>
            <span class="text-muted fw-bold me-1">|</span>
            <a href="" target="_blank" class="text-gray-100 text-hover-primary">H?i & ?�p</a>
             <span class="text-muted fw-bold me-1">|</span>
            <a href="" target="_blank" class="text-gray-100 text-hover-primary">Ch�nh s�ch b?o m?t</a>
        </div>
        <!--end::Copyright-->
        <!--begin::Menu-->
        <div class="menu menu-gray-600 menu-hover-primary fw-bold order-1">
             <span class="text-muted fw-bold me-1">K?t n?i v?i ch�ng t�i</span>
             <div class="cursor-pointer symbol symbol-sm-20px">
                <img src="https://tuvaco.com.vn/wp-content/uploads/2018/01/facebook-icon-1024x1024.png" alt="facebook">
                <img src="https://nongsankhaianh.com/wp-content/uploads/2021/10/icon-zalo.png" alt="zalo">
                <img src="https://i.pinimg.com/564x/89/02/9f/89029fa5a56688268efe7d9076f76a85.jpg" alt="youtube">
            </div>
        </div>
        <!--end::Menu-->
    </div> 
         <div
             class="container-fluid d-flex flex-md-row align-items-center justify-content-between">
             <div
                 class="container-fluid d-flex flex-column" >
                 <!--begin::Copyright-->
                 <div class="text-light order-2 order-md-1" style="width: 300px;">
                     <h1 class="d-flex align-items-center fw-bolder my-1 fs-3 text-light">??A CH? V� TH�NG TIN LI�N H?</h1>
                     <ul>
                         <li><h5 >Address:</h5> ??i h?c FPT, Km29, ??i l? Th?ng Long, Khu CNC H�a L?c, Th?ch H�a, Th?ch Th?t, H� N?i</li>                         
                         <li><h5>Tel:</h5>(028) 22220219</li>
                         <li><h5>Email:</h5>fptuniversity@gmail.com</li>
                     </ul>
                 </div>
                 <!--end::Copyright-->
                 
             </div>
             <!--begin::Menu-->
                 <div class="container-fluid d-flex flex-column">
                      <h1 class="d-flex align-items-center text-light fw-bolder my-1 fs-3">Li�n h? c?n h? tr? ho?c nh?n th�ng tin</h1>
                      <input type="text" class="form-control form-control-solid mb-6" placeholder="H? v� t�n" value="${user.getFullname()}">
                      <input type="text" class="form-control form-control-solid mb-6" placeholder="Email" value="${user.getEmail()}">
                      <input type="text" class="form-control form-control-solid mb-6" placeholder="S? ?i?n tho?i"  value="${user.getMobile()}">
                      <textarea class="form-control mb-6" rows="2" placeholder="N?i dung c?n trao ??i,li�n l?c"></textarea>
                       <button type="submit" class="btn btn-primary" data-kt-users-modal-action="submit">
                            <span class="indicator-label">G?i th�ng tin</span>
                            <span class="indicator-progress">Please wait...
                                <span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
                        </button>
                 </div>
                 <!--end::Menu-->
         </div>
    </div>
    </div>
