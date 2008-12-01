

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Ticket List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Ticket</g:link></span>
        </div>
        <div class="body">
            <h1>Ticket List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="description" title="Description" />
                        
                   	        <g:sortableColumn property="reportedBy" title="Reported By" />
                        
                   	        <g:sortableColumn property="title" title="Title" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${ticketList}" status="i" var="ticket">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${ticket.id}">${fieldValue(bean:ticket, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:ticket, field:'description')}</td>
                        
                            <td>${fieldValue(bean:ticket, field:'reportedBy')}</td>
                        
                            <td>${fieldValue(bean:ticket, field:'title')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${Ticket.count()}" />
            </div>
        </div>
    </body>
</html>
