

<%@ page import="org.ojete.Vamonos" %>
<!doctype html>
<html>
    <head>
        <meta name="layout" content="mobile">
        <g:set var="entityName" value="${message(code: 'vamonos.label', default: 'Vamonos')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
		<div data-role="header" data-position="fixed">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
			<div data-role="navbar">
				<ul>
					<li><a data-icon="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
					<li><g:link data-icon="grid" data-ajax="false" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				</ul>
			</div>
		</div>
		<div data-role="content">
			<g:if test="${flash.message}">
			<div class="message" role="alert">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${vamonosInstance}">
			<div class="errors" role="alert">
				<g:renderErrors bean="${vamonosInstance}" as="list" />
			</div>
			</g:hasErrors>
			<g:form method="post" >
				<g:hiddenField name="id" value="${vamonosInstance?.id}" />
				<g:hiddenField name="version" value="${vamonosInstance?.version}" />
			
				<div data-role="fieldcontain">
					<label for="flipao"><g:message code="vamonos.flipao.label" default="Flipao" /></label>
					<g:checkBox name="flipao" value="${vamonosInstance?.flipao}" />
				</div>
			
				<div data-role="fieldcontain">
					<label for="fraseMitica"><g:message code="vamonos.fraseMitica.label" default="Frase Mitica" /></label>
					<g:textField name="fraseMitica" value="${vamonosInstance?.fraseMitica}" />
				</div>
			
				<div data-role="fieldcontain">
					<label for="nombre"><g:message code="vamonos.nombre.label" default="Nombre" /></label>
					<g:textField name="nombre" value="${vamonosInstance?.nombre}" />
				</div>
			
				<g:actionSubmit data-icon="check" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
			</g:form>
		</div>
		<div data-role="footer">
		</div>
    </body>
</html>