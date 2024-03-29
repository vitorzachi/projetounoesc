<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%--
    This file is an entry point for JavaServer Faces application.
--%>
<%@ include file="/cabecalho.jsp"%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Início</title>
        </head>
        <body>
            <h1><h:outputText value="Início"/></h1>
            <h:form>
                <h:commandLink action="#{produtor.listSetup}" value="Produtor"/>
            </h:form>
            
            <h:form>
                <h:commandLink action="#{estado.listSetup}" value="Estado"/>
            </h:form>

            <h:form>
                <h:commandLink action="#{cidade.listSetup}" value="Cidade"/>
            </h:form>

            <h:form>
                <h:commandLink action="#{empresa.listSetup}" value="Empresa"/>
            </h:form>

        </body>
    </html>
</f:view>
<%@ include file="/rodape.jsp"%>