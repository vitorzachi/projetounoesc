<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Usuario Items</title>
            <link rel="stylesheet" type="text/css" href="/webService/jsfcrud.jsf" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>Listing Usuario Items</h1>
        <h:form styleClass="jsfcrud_list_form">
            <h:outputText escape="false" value="(No Usuario Items Found)<br />" rendered="#{usuario.pagingInfo.itemCount == 0}" />
            <h:panelGroup rendered="#{usuario.pagingInfo.itemCount > 0}">
                <h:outputText value="Item #{usuario.pagingInfo.firstItem + 1}..#{usuario.pagingInfo.lastItem} of #{usuario.pagingInfo.itemCount}"/>&nbsp;
                <h:commandLink action="#{usuario.prev}" value="Previous #{usuario.pagingInfo.batchSize}" rendered="#{usuario.pagingInfo.firstItem >= usuario.pagingInfo.batchSize}"/>&nbsp;
                <h:commandLink action="#{usuario.next}" value="Next #{usuario.pagingInfo.batchSize}" rendered="#{usuario.pagingInfo.lastItem + usuario.pagingInfo.batchSize <= usuario.pagingInfo.itemCount}"/>&nbsp;
                <h:commandLink action="#{usuario.next}" value="Remaining #{usuario.pagingInfo.itemCount - usuario.pagingInfo.lastItem}"
                               rendered="#{usuario.pagingInfo.lastItem < usuario.pagingInfo.itemCount && usuario.pagingInfo.lastItem + usuario.pagingInfo.batchSize > usuario.pagingInfo.itemCount}"/>
                <h:dataTable value="#{usuario.usuarioItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Id"/>
                        </f:facet>
                        <h:outputText value="#{item.id}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Senha"/>
                        </f:facet>
                        <h:outputText value="#{item.senha}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Usuario"/>
                        </f:facet>
                        <h:outputText value="#{item.usuario}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText escape="false" value="&nbsp;"/>
                        </f:facet>
                        <h:commandLink value="Show" action="#{usuario.detailSetup}">
                            <f:param name="jsfcrud.currentUsuario" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][usuario.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Edit" action="#{usuario.editSetup}">
                            <f:param name="jsfcrud.currentUsuario" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][usuario.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Destroy" action="#{usuario.destroy}">
                            <f:param name="jsfcrud.currentUsuario" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][usuario.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                    </h:column>

                </h:dataTable>
            </h:panelGroup>
            <br />
            <h:commandLink action="#{usuario.createSetup}" value="New Usuario"/>
            <br />


        </h:form>
        </body>
    </html>
</f:view>
