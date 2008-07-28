<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <title>Change List</title>
</head>
<body>
<div class="nav">
    <span class="menuButton"><a class="home" href="${createLinkTo(dir: '')}">Home</a></span>
    <span class="menuButton"><g:link class="create" action="create">New Change</g:link></span>
</div>
<div class="body">
    <h1>Change List</h1>
    <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
    </g:if>
    <div class="list">
        <table>
            <thead>
                <tr>

                    <g:sortableColumn property="id" title="Id"/>

                    <g:sortableColumn property="date" title="Date"/>

                    <g:sortableColumn property="sequence" title="Sequence"/>

                    <th>Ticket</th>

                </tr>
            </thead>
            <tbody>
                <g:each in="${changeList}" status="i" var="change">
                    <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

                        <td><g:link action="show" id="${change.id}">${fieldValue(bean: change, field: 'id')}</g:link></td>

                        <td>${fieldValue(bean: change, field: 'date')}</td>

                        <td>${fieldValue(bean: change, field: 'sequence')}</td>

                        <td>${fieldValue(bean: change, field: 'ticket')}</td>

                    </tr>
                </g:each>
            </tbody>
        </table>
    </div>
    <div class="paginateButtons">
        <g:paginate total="${Change.count()}"/>
    </div>
</div>
</body>
</html>
