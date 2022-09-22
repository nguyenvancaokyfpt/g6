<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="i" items="${customJs}">
    <script src="assets/js/custom/${i}"></script>
</c:forEach>

