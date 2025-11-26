<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cafe Menu - 신규 등록</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shopping.css">
</head>

<body>

	<div class="container">
		<h1>새로운 메뉴 등록</h1>

		<form
			action="${pageContext.request.contextPath}/ProductServlet?command=product_write"
			method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>메뉴명</td>
					<td><input type="text" name="name" required
						placeholder="예: 아메리카노" /></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="number" name="price" required
						placeholder="예: 4500" /></td>
				</tr>
				<tr>
					<td>설명</td>
					<td><textarea name="description" rows="4"
							placeholder="메뉴에 대한 설명을 입력하세요..."></textarea></td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><input type="file" name="pictureurl" accept="image/*" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center; padding-top: 30px;">
						<input type="submit" value="등록하기" class="btn" /> <input
						type="button" value="취소" onclick="history.back();"
						class="btn btn-secondary" />
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>

</html>