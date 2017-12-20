# Servlet_Context_Interfce
An object of ServletContext is created by the web container at time of deploying the project. This object can be used to get configuration information from web.xml file. There is only one ServletContext object per web application.  If any information is shared to many servlet, it is better to provide it from the web.xml file using the &lt;context-param> element.
