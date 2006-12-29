<%@ include file="/common/taglibs.jsp" %>

<title>Business Example</title>

<p>Please use the form below to modify a business's information.</p>

<s:form name="businessForm" action="business" method="post" validate="true">
    <s:hidden name="business.id" value="%{business.id}"/>

    <s:textfield label="Business Name" name="business.businessName"
                 value="%{business.businessName}" required="true" cssClass="text medium"/>

    <s:textfield label="First Name" name="business.firstName"
                 value="%{business.firstName}" required="false" cssClass="text medium"/>

    <s:textfield label="Last Name" name="business.lastName"
                 value="%{business.lastName}" required="false" cssClass="text medium"/>

    <s:textfield label="Business Phone" name="business.businessPhone"
                 value="%{business.businessPhone}" required="false" cssClass="text medium"/>

    <s:textfield label="Business Fax" name="business.businessFax"
                 value="%{business.businessFax}" required="false" cssClass="text medium"/>

    <s:textfield label="Business Email" name="business.businessEmail"
                 value="%{business.businessEmail}" required="false" cssClass="text medium"/>

    <s:textfield label="Business Website" name="business.businessWebsite"
                 value="%{business.businessWebsite}" required="false" cssClass="text medium"/>

    <li class="buttonBar left">
        <s:submit method="save" value="Save" cssClass="button"/>
        <s:submit method="delete" value="Delete" cssClass="button"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement('business');
</script>
<div style="margin-top: 50px">
<s:action name="business!list" id="action" namespace="default"/>

<strong>Current businesses:</strong>
<ul class="glassList">
    <s:iterator value="#action.businesses">
        <li><s:a href="business.html?id=%{id}"><s:property value="businessName"/></s:a></li>
    </s:iterator>
</ul>
</div>
