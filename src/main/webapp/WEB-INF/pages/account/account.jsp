<%@ include file="/common/taglibs.jsp" %>

<title>Account Example</title>

<p>Please use the form below to modify an account's information.</p>

<s:form name="accountForm" action="account" method="post" validate="true">
    <s:hidden name="account.id" value="%{account.id}"/>

    <s:textfield label="Account Name" name="account.accountName"
                 value="%{account.accountName}" required="true" cssClass="text medium"/>

    <s:textfield label="Account Number" name="account.accountNumber"
                 value="%{account.accountNumber}" required="false" cssClass="text medium"/>

    <s:textfield label="Optional Number" name="account.optionalNumber"
                 value="%{account.optionalNumber}" required="false" cssClass="text medium"/>

    <s:textfield label="Balance" name="account.balance"
                 value="%{account.balance}" required="false" cssClass="text medium"/>

    <s:textfield label="Budget Billing" name="account.budgetBilling"
                 value="%{account.budgetBilling}" required="false" cssClass="text medium"/>

    <s:textfield label="Regular Payment" name="account.regularPayment"
                 value="%{account.regularPayment}" required="false" cssClass="text medium"/>

    <s:textfield label="Due Date" name="account.dueDate"
                 value="%{account.dueDate}" required="false" cssClass="text medium"/>

    <li class="buttonBar left">
        <s:submit method="save" value="Save" cssClass="button"/>
        <s:submit method="delete" value="Delete" cssClass="button"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement('account');
</script>

<div style="margin-top: 50px">
<s:action name="account!list" id="action" namespace="default"/>

<strong>Current accounts:</strong>
<ul class="glassList">
    <s:iterator value="#action.accounts">
        <li><s:a href="account.html?id=%{id}"><s:property value="accountName"/></s:a></li>
    </s:iterator>
</ul>
</div>
