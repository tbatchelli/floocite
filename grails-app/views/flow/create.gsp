

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Flow</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Flow List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Flow</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${flow}">
            <div class="errors">
                <g:renderErrors bean="${flow}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="definition">Definition:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:flow,field:'definition','errors')}">
                                    <g:select optionKey="id" from="${FlowDefinition.list()}" name="definition.id" value="${flow?.definition?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="flowState">Flow State:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:flow,field:'flowState','errors')}">
                                    <g:select optionKey="id" from="${FlowState.list()}" name="flowState.id" value="${flow?.flowState?.id}" ></g:select>
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
