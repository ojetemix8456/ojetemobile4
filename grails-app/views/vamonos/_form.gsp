<%@ page import="org.ojete.Vamonos" %>



<div class="fieldcontain ${hasErrors(bean: vamonosInstance, field: 'flipao', 'error')} ">
	<label for="flipao">
		<g:message code="vamonos.flipao.label" default="Flipao" />
		
	</label>
	<g:checkBox name="flipao" value="${vamonosInstance?.flipao}" />
</div>

<div class="fieldcontain ${hasErrors(bean: vamonosInstance, field: 'fraseMitica', 'error')} ">
	<label for="fraseMitica">
		<g:message code="vamonos.fraseMitica.label" default="Frase Mitica" />
		
	</label>
	<g:textField name="fraseMitica" value="${vamonosInstance?.fraseMitica}" />
</div>

<div class="fieldcontain ${hasErrors(bean: vamonosInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="vamonos.nombre.label" default="Nombre" />
		
	</label>
	<g:textField name="nombre" value="${vamonosInstance?.nombre}" />
</div>

