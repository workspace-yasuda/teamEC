<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/latte.css">
<link rel="stylesheet" type="text/css" href="./css/table.css">

<title>宛先情報入力確認画面</title>
</head>
<body>

	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	<div id="contents">
		<div id="top">
			<h1>宛先情報入力確認画面</h1>
		</div>

		<s:form action="CreateDestinationCompleteAction">

			<table class="c-table">
				</tbody>
				<tr id="box">
					<th scope="row">姓</th>
					<td><s:property value="familyName" /></td>
				</tr>

				<tr id="box">
					<th scope="row">名</th>
					<td><s:property value="firstName" /></td>
				</tr>

				<tr id="box">
					<th scope="row">姓ふりがな</th>
					<td><s:property value="familyNameKana" /></td>
				</tr>

				<tr id="box">
					<th scope="row">名ふりがな</th>
					<td><s:property value="firstNameKana" /></td>
				</tr>


				<tr id="box">
					<th scope="row">住所</th>
					<td><s:property value="userAddress" /></td>
				</tr>

				<tr id="box">
					<th scope="row">電話番号</th>
					<td><s:property value="telNumber" /></td>
				</tr>

				<tr id="box">
					<th scope="row">メールアドレス</th>
					<td><s:property value="email" /></td>
				</tr>
					</tbody>

			</table>

		<div class="submit_btn_box">
			<s:submit value="宛先情報登録" class="submit_btn" />
		</div>

		</s:form>

			<s:form action="CreateDestinationAction">
			<div class="submit_btn_box">
				<s:submit value="戻る" class="submit_btn" />
	</div>
				<s:hidden id="backFlag" name="backFlag" value="1"/>
			</s:form>
	</div>

</body>
</html>