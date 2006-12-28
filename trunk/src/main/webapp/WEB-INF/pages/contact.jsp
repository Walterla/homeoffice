<%@ include file="/common/taglibs.jsp" %>

<title>Contact Example</title>

<p>Please use the form below to modify a contact's information.</p>

<s:form name="contactForm" action="contact" method="post" validate="true">
    <s:hidden name="contact.id" value="%{contact.id}"/>

    <s:textfield label="First Name" name="contact.firstName"
                 value="%{contact.firstName}" required="true" cssClass="text medium"/>

    <s:textfield label="Last Name" name="contact.lastName"
                 value="%{contact.lastName}" required="true" cssClass="text medium"/>

    <li class="buttonBar left">
        <s:submit method="save" value="Save" cssClass="button"/>
        <s:submit method="delete" value="Delete" cssClass="button"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement('contact');
</script>

<div style="margin-top: 50px">
<s:action name="contact!list" id="action" namespace="default"/>

<strong>Current folks:</strong>
<ul class="glassList">
    <s:iterator value="#action.contacts">
        <li><s:a href="contact.html?id=%{id}"><s:property value="firstName"/> <s:property value="lastName"/></s:a></li>
    </s:iterator>
</ul>
</div>
