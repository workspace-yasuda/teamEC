<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/latte.css">
<link rel="stylesheet" type="text/css" href="./css/table.css">
<link rel="stylesheet" type="text/css" href="./css/input.css">
<link rel="stylesheet" type="text/css" href="./css/message.css">

<title>宛先情報入力画面</title>
</head>
<body>

	<div id="header">
		<jsp:include page="header.jsp" />
	</div>

	<div id="contents">
		<div id="top">
			<h1>宛先情報入力画面</h1>
		</div>

		<s:if test="familyNameError!=null && familyNameError.size()>0">
			<div class="error">
				<s:iterator value="familyNameError">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="firstNameError!=null && firstNameError.size()>0">
			<div class="error">
				<s:iterator value="firstNameError">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="familyNameKanaError!=null && familyNameKanaError.size()>0">
			<div class="error">
				<s:iterator value="familyNameKanaError">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="firstNameKanaError!=null && firstNameKanaError.size()>0">
			<div class="error">
				<s:iterator value="firstNameKanaError">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="emailError!=null && emailError.size()>0">
			<div class="error">
				<s:iterator value="emailError">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="telNumberError!=null && telNumberError.size()>0">
			<div class="error">
				<s:iterator value="telNumberError">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="userAddressError!=null && userAddressError.size()>0">
			<div class="error">
				<s:iterator value="userAddressError">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>

		<s:form action="CreateDestinationConfirmAction">

			<table class="c-table">

			<tbody>
				<tr>
					<th scope="row">姓</th>
					<td><s:textfield name="familyName" class="txt"
							value="%{#session.familyName}" placeholder="姓" /></td>
				</tr>
				<tr>
					<th scope="row">名</th>
					<td><s:textfield name="firstName" class="txt"
							value="%{#session.firstName}" placeholder="名" /></td>
				</tr>
				<tr>
					<th scope="row">姓ふりがな</th>
					<td><s:textfield name="familyNameKana" class="txt"
							value="%{#session.familyNameKana}" placeholder="姓ふりがな" /></td>
				</tr>
				<tr>
					<th scope="row">名ふりがな</th>
					<td><s:textfield name="firstNameKana" class="txt"
							value="%{#session.firstNameKana}" placeholder="名ふりがな" /></td>
				</tr>

				<tr>
					<th scope="row">住所</th>
					<td><s:textfield name="userAddress" class="txt"
							value="%{#session.userAddress}" placeholder="住所" /></td>
				</tr>

				<tr>
					<th scope="row">電話番号</th>
					<td><s:textfield name="telNumber" class="txt"
							value="%{#session.telNumber}" placeholder="電話番号" /></td>
				</tr>

				<tr>
					<th scope="row">メールアドレス</th>
					<td><s:textfield name="email" class="txt"
							value="%{#session.email}" placeholder="メールアドレス" /></td>
				</tr>
					</tbody>
			</table>

			<div class="submit_btn_box">
				<s:submit value="宛先情報確認" class="submit_btn"/>
			</div>
		</s:form>

	</div>

</body>
</html>