
<%@ page import="org.ojete.Vamonos" %>
<!doctype html>
<html>
    <head>
        <meta name="layout" content="mobile">
        <g:set var="entityName" value="${message(code: 'vamonos.label', default: 'Vamonos')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
		<div data-role="header" data-position="fixed">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<div data-role="navbar">
				<ul>
					<li><a data-icon="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
					<li><g:link data-icon="grid" data-ajax="false" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				</ul>
			</div>
		</div>
		<div data-role="content">
			<g:if test="${flash.message}">
			<div class="message">${flash.message}</div>
			</g:if>
			<dl>
			
				<dt><g:message code="vamonos.id.label" default="Id" /></dt>
				
					<dd><g:fieldValue bean="${vamonosInstance}" field="id"/></dd>
				
			
				<dt><g:message code="vamonos.flipao.label" default="Flipao" /></dt>
				
					<dd><g:formatBoolean boolean="${vamonosInstance?.flipao}" /></dd>
				
			
				<dt><g:message code="vamonos.fraseMitica.label" default="Frase Mitica" /></dt>
				
					<dd><g:fieldValue bean="${vamonosInstance}" field="fraseMitica"/></dd>
				
			
				<dt><g:message code="vamonos.nombre.label" default="Nombre" /></dt>
				
					<dd><g:fieldValue bean="${vamonosInstance}" field="nombre"/></dd>
				
			
			</dl>
			<g:form>
				<g:hiddenField name="id" value="${vamonosInstance?.id}" />
				<g:actionSubmit data-icon="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" />
			</g:form>
		</div>
		<div data-role="footer">
		</div>
    </body>
</html>
