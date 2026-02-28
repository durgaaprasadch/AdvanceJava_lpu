<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<h2>Shopping Cart</h2>

<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>Product</th>
        <th>Quantity</th>
    </tr>

    <c:forEach var="e" items="${items}">
        <tr>
            <td>${e.key.name}</td>
            <td>${e.value}</td>
        </tr>
    </c:forEach>
</table>

<h3>Total Amount: ${total}</h3>

<br/>

<!-- Reset Cart -->
<form action="${pageContext.request.contextPath}/reset" method="post" style="display:inline">
    <button type="submit">Reset Cart</button>
</form>

&nbsp;&nbsp;

<!-- Home Button -->
<a href="${pageContext.request.contextPath}/">
    <button type="button">Home</button>
</a>