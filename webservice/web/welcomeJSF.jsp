<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%--
    This file is an entry point for JavaServer Faces application.
--%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
<link rel="stylesheet" type="text/css" href="/webservice/jsfcrud.jsf" />
        </head>
        <body>
            <h1><h:outputText value="JavaServer Faces"/></h1>
                <h:form>
                    <h:commandLink action="#{produtor.listSetup}" value="Show All Produtor Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{estado.listSetup}" value="Show All Estado Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{cidade.listSetup}" value="Show All Cidade Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{empresa.listSetup}" value="Show All Empresa Items"/>
                </h:form>

        </body>
    </html>
</f:view>
