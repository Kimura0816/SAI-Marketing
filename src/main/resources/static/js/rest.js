function sendForm(formId, method, url, callBack)
{
	// フォームデータを取得
	var formData = new FormData(document.getElementById(formId));
	var formJson = JSON.stringify(formData);

	var xhttpreq = new XMLHttpRequest();
	xhttpreq.onreadystatechange = function() {
		if (xhttpreq.readyState == 4 && xhttpreq.status == 200) {
            console.log(xhr.responseText); //JSON
            var data = JSON.parse(xhr.responseText);
            console.log(data); //js Object
            callBack(data);
		}
	};
	xhttpreq.open(method, url, true);
	xhttpreq.setRequestHeader('Content-Type', 'application/json; charset="UTF-8"');
	xhttpreq.send(formJson);
}

function sendFile(formId, method, url, callBack)
{
	// フォームデータを取得
	var formData = new FormData(document.getElementById(formId));

	var xhttpreq = new XMLHttpRequest();
	xhttpreq.onreadystatechange = function() {
		if (xhttpreq.readyState == 4 && xhttpreq.status == 200) {
            console.log(xhttpreq.responseText); //JSON
            var data = JSON.parse(xhttpreq.responseText);
            console.log(data); //js Object
            callBack(data);
		}
	};
	xhttpreq.open(method, url, true);
	xhttpreq.send(formData);
}

/**
 * Rest api call.
 */
function restApi(url, method, jsonString, callBack) {
    $.ajax({
      url: url,
      type: method, // or POST
      data: jsonString,
      Accept : "application/json",
      contentType: "application/json",
      success: function(response) {
        callBack(response);
      },
      error: function(xhr, status, error) {
        $("#div-danger-message >div").html(error);
      }
    });
}