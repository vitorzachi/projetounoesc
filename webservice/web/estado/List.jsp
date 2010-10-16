<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ include file="/cabecalho.jsp"%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Lista de Estados</title>
            <link rel="stylesheet" type="text/css" href="/webservice/jsfcrud.jsf" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>Lista de Estados</h1>
        <h:form styleClass="jsfcrud_list_form">
            <h:outputText escape="false" value="(Nenhum Estado Cadastrado)<br />" rendered="#{estado.pagingInfo.itemCount == 0}" />
            <h:panelGroup rendered="#{estado.pagingInfo.itemCount > 0}">
                <h:outputText value="Item #{estado.pagingInfo.firstItem + 1}..#{estado.pagingInfo.lastItem} de #{estado.pagingInfo.itemCount}"/>&nbsp;
                <h:commandLink action="#{estado.prev}" value="Anterior #{estado.pagingInfo.batchSize}" rendered="#{estado.pagingInfo.firstItem >= estado.pagingInfo.batchSize}"/>&nbsp;
                <h:commandLink action="#{estado.next}" value="Próximo #{estado.pagingInfo.batchSize}" rendered="#{estado.pagingInfo.lastItem + estado.pagingInfo.batchSize <= estado.pagingInfo.itemCount}"/>&nbsp;
                <h:commandLink action="#{estado.next}" value="Restante #{estado.pagingInfo.itemCount - estado.pagingInfo.lastItem}"
                               rendered="#{estado.pagingInfo.lastItem < estado.pagingInfo.itemCount && estado.pagingInfo.lastItem + estado.pagingInfo.batchSize > estado.pagingInfo.itemCount}"/>
                <h:dataTable value="#{estado.estadoItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Id"/>
                        </f:facet>
                        <h:outputText value="#{item.id}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="NomeEstado"/>
                        </f:facet>
                        <h:outputText value="#{item.nomeEstado}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="SiglaEstado"/>
                        </f:facet>
                        <h:outputText value="#{item.siglaEstado}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText escape="false" value="&nbsp;"/>
                        </f:facet>
                        <h:commandLink value="Mostrar" action="#{estado.detailSetup}">
                            <f:param name="jsfcrud.currentEstado" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][estado.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Editar" action="#{estado.editSetup}">
                            <f:param name="jsfcrud.currentEstado" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][estado.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Excluir" action="#{estado.destroy}">
                            <f:param name="jsfcrud.currentEstado" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][estado.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                    </h:column>

                </h:dataTable>
            </h:panelGroup>
            <br />
            <h:commandLink action="#{estado.createSetup}" value="Novo Estado"/>
            <br />
            <br />
            <h:commandLink value="Início" action="welcome" immediate="true" />


        </h:form>
        </body>
    </html>
</f:view>
<%@ include file="/rodape.jsp"%>