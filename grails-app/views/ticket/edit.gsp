

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Ticket</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Ticket List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Ticket</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Ticket</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${ticket}">
            <div class="errors">
                <g:renderErrors bean="${ticket}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${ticket?.id}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Description:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:ticket,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:ticket,field:'description')}"/>
                                </td>
                            </tr> 
                        
                                    <input type="hidden" id="reportedBy" name="reportedBy" value="${fieldValue(bean:ticket,field:'reportedBy')}"/>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="title">Title:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:ticket,field:'title','errors')}">
                                    <input type="text" id="title" name="title" value="${fieldValue(bean:ticket,field:'title')}"/>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
