<%@ page contentType="text/html; charset=EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<script type='text/javascript'
		src='/appa/dwr/interface/commentService.js'></script>
	<script type='text/javascript' src='/appa/dwr/engine.js'></script>
	<script type='text/javascript' src='/appa/dwr/util.js'></script>
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
	<title>��� ���</title>
</head>
<body>
<hr />
<form id="comment" name="comment">
<p>
	<label for="writerName">�ۼ���:</label><br/>
	<input type="text" name="writerName" id="writerName" />
</p>
<p>
	<label for="content">����:</label><br/>
	<textarea name="content" id="content"></textarea>
</p>
<p>
	<input type="button" value="���" onclick="writeComment()" />
</p>
</form>
	<input type="button" value="�̸�" onclick="getName()" />
<hr/>
<div id="comments">
</div>
</body>
</html>