

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Ticket</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Ticket List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Ticket</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${ticket}">
            <div class="errors">
                <g:renderErrors bean="${ticket}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
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
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="flow">Flow:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:ticket,field:'flow','errors')}">
                                    <g:select optionKey="id" from="${FlowDefinition.list()}" name="flow.id" value="${ticket?.flow?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="owner">Owner:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:ticket,field:'owner','errors')}">
                                    <g:select optionKey="id" from="${User.list()}" name="owner.id" value="${ticket?.owner?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="reportedBy">Reported By:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:ticket,field:'reportedBy','errors')}">
                                    <g:select optionKey="id" from="${User.list()}" name="reportedBy.id" value="${ticket?.reportedBy?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="state">State:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:ticket,field:'state','errors')}">
                                    <input type="text" id="state" name="state" value="${fieldValue(bean:ticket,field:'state')}" />
                                </td>
                            </tr> 
                        
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
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
