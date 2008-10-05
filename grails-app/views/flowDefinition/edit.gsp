

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit FlowDefinition</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">FlowDefinition List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New FlowDefinition</g:link></span>
        </div>
        <div class="body">
            <h1>Edit FlowDefinition</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${flowDefinition}">
            <div class="errors">
                <g:renderErrors bean="${flowDefinition}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${flowDefinition?.id}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="states">States:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:flowDefinition,field:'states','errors')}">
                                    
<ul>
<g:each var="s" in="${flowDefinition?.states?}">
    <li><g:link controller="flowState" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="flowState" params="['flowDefinition.id':flowDefinition?.id]" action="create">Add FlowState</g:link>

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
