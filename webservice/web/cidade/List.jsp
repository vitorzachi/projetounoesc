<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ include file="/cabecalho.jsp"%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listar Cidades</title>
            <link rel="stylesheet" type="text/css" href="/webservice/jsfcrud.jsf" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>Listar Cidades</h1>
        <h:form styleClass="jsfcrud_list_form">
            <h:outputText escape="false" value="(Nenhuma Cidade Cadastrada)<br />" rendered="#{cidade.pagingInfo.itemCount == 0}" />
            <h:panelGroup rendered="#{cidade.pagingInfo.itemCount > 0}">
                <h:outputText value="Item #{cidade.pagingInfo.firstItem + 1}..#{cidade.pagingInfo.lastItem} de #{cidade.pagingInfo.itemCount}"/>&nbsp;
                <h:commandLink action="#{cidade.prev}" value="Anterior #{cidade.pagingInfo.batchSize}" rendered="#{cidade.pagingInfo.firstItem >= cidade.pagingInfo.batchSize}"/>&nbsp;
                <h:commandLink action="#{cidade.next}" value="Próximo #{cidade.pagingInfo.batchSize}" rendered="#{cidade.pagingInfo.lastItem + cidade.pagingInfo.batchSize <= cidade.pagingInfo.itemCount}"/>&nbsp;
                <h:commandLink action="#{cidade.next}" value="Restantes #{cidade.pagingInfo.itemCount - cidade.pagingInfo.lastItem}"
                               rendered="#{cidade.pagingInfo.lastItem < cidade.pagingInfo.itemCount && cidade.pagingInfo.lastItem + cidade.pagingInfo.batchSize > cidade.pagingInfo.itemCount}"/>
                <h:dataTable value="#{cidade.cidadeItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Estado"/>
                        </f:facet>
                        <h:outputText value="#{item.estado}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Id"/>
                        </f:facet>
                        <h:outputText value="#{item.id}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="NomeCidade"/>
                        </f:facet>
                        <h:outputText value="#{item.nomeCidade}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText escape="false" value="&nbsp;"/>
                        </f:facet>
                        <h:commandLink value="Mostrar" action="#{cidade.detailSetup}">
                            <f:param name="jsfcrud.currentCidade" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][cidade.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Editar" action="#{cidade.editSetup}">
                            <f:param name="jsfcrud.currentCidade" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][cidade.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Excluir" action="#{cidade.destroy}">
                            <f:param name="jsfcrud.currentCidade" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][cidade.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                    </h:column>

                </h:dataTable>
            </h:panelGroup>
            <br />
            <h:commandLink action="#{cidade.createSetup}" value="Nova Cidade"/>
            <br />
            <br />
            <h:commandLink value="Início" action="welcome" immediate="true" />


        </h:form>
        </body>
    </html>
</f:view>
<%@ include file="/rodape.jsp"%>