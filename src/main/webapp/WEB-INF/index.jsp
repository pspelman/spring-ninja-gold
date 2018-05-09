<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script type="text/javascript" src="js/scripts.js"></script>


</head>
<body>


<c:out value="Template works"/>
<div style="text-align:center" class="container">
    <h1>
        <c:out value="${titleMessage}"/>
    </h1>
    <%--<img class='big_logo' alt="Angular Logo" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNTAgMjUwIj4KICAgIDxwYXRoIGZpbGw9IiNERDAwMzEiIGQ9Ik0xMjUgMzBMMzEuOSA2My4ybDE0LjIgMTIzLjFMMTI1IDIzMGw3OC45LTQzLjcgMTQuMi0xMjMuMXoiIC8+CiAgICA8cGF0aCBmaWxsPSIjQzMwMDJGIiBkPSJNMTI1IDMwdjIyLjItLjFWMjMwbDc4LjktNDMuNyAxNC4yLTEyMy4xTDEyNSAzMHoiIC8+CiAgICA8cGF0aCAgZmlsbD0iI0ZGRkZGRiIgZD0iTTEyNSA1Mi4xTDY2LjggMTgyLjZoMjEuN2wxMS43LTI5LjJoNDkuNGwxMS43IDI5LjJIMTgzTDEyNSA1Mi4xem0xNyA4My4zaC0zNGwxNy00MC45IDE3IDQwLjl6IiAvPgogIDwvc3ZnPg==">--%>
    <p>Choose Your Path</p>
    
</div>
<h2>Your total gold: <c:out value="${total_gold}"/></h2>
<c:out value="${brokeMessage}" />


<div class="action_choices_div">

    <c:forEach items="${locations}" var="location">

    <div class="location_box">
        <span class="name">
            <form action="/activity" method="post">
            <input type="hidden" name="location" value="${location}"/>
                <button type="submit" class="btn">Go to ${location}</button>
            </form>
        </span>
    </div>
    </c:forEach>
</div>

    <div class="adventure_log">
        <h2>Adventure log</h2>

        <c:forEach items="${activityLog}" var="activity">
            -> ${activity} at <span class="tstamp">${activity.timestamp}</span> <br/>

        </c:forEach>
        <%--<p *ngFor="let adventure of adventure_log" class="activities">--%>
            <%--{{adventure.ninja_name}} {{adventure.event_description}} {{adventure.event_location}} and {{ adventure.outcome}} {{ adventure.outcome_amount }} gold at {{adventure.time}}</p>--%>
    </div>

</div>


</body>
</html>

<%--<c:forEach items="${locations}" var="location">--%>
    <%--<tr>--%>
        <%--<td>${location}<br/></td>--%>
    <%--</tr>--%>
    <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td>${location.status}</td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td>${location.requestType}</td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td>${location.requestedFor}</td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td>${location.timeSubmitted}</td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
<%--</c:forEach>--%>

<%--<c:out value="${locations}" />--%>

