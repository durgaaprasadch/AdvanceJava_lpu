<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<h2>Available Products</h2>

<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>Product Name</th>
        <th>Price </th>
        <th>Quantity in Cart</th>
        <th>Action</th>
    </tr>

    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>
                <c:choose>
                    <c:when test="${cartQuantities[p.id] != null}">
                        ${cartQuantities[p.id]}
                    </c:when>
                    <c:otherwise>
                        0
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <form action="add" method="post">
                    <input type="hidden" name="id" value="${p.id}" />
                    <button type="submit">Add to Cart</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<br/>

<a href="${pageContext.request.contextPath}/cart">
    <button type="button">Go to Cart</button>
</a>