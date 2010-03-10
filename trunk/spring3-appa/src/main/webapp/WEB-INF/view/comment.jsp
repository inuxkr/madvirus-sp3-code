<%@ page contentType="text/html; charset=EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<script type='text/javascript'
		src='/chap08/dwr/interface/commentService.js'></script>
	<script type='text/javascript' src='/chap08/dwr/engine.js'></script>
	<script type='text/javascript' src='/chap08/dwr/util.js'></script>
	<script type="text/javascript">
	window.onload = function() {
		commentService.list(onList);
	}
	var onList = function(data) {
		for (var i = 0 ; i < data.length ; i++) {
			appendCommentToUI(data[i]);
		}
	}
	function getName() {
		commentService.getName(onGetName);
	}
	
	var onGetName = function(data) {
		alert(data);
	}

	function writeComment() {
		var content = $('content');
		var newComment = {
			writerName: $('writerName').value,
			content: $('content').value
		};
		commentService.write(newComment, onWriteComment);
	}
	var onWriteComment = function(data) {
		appendCommentToUI(data);
	}
	function appendCommentToUI(comment) {
		var commentsDiv = $('comments');
		var newCommentDiv = document.createElement('div');
		newCommentDiv.id = 'comment'+comment.id;
		newCommentDiv.innerHTML = comment.writerName + ":" + comment.content;
		commentsDiv.appendChild(newCommentDiv);
	}
	</script>
	<title>댓글 목록</title>
</head>
<body>
<hr />
<form id="comment" name="comment">
<p>
	<label for="writerName">작성자:</label><br/>
	<input type="text" name="writerName" id="writerName" />
</p>
<p>
	<label for="content">내용:</label><br/>
	<textarea name="content" id="content"></textarea>
</p>
<p>
	<input type="button" value="등록" onclick="writeComment()" />
</p>
</form>
	<input type="button" value="이름" onclick="getName()" />
<hr/>
<div id="comments">
</div>
</body>
</html>