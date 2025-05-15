/**
 *  company.js
 */
window.onload = function(){
    $( "#regist-clear" ).on( "click", function() {
        $("form-regist").reset();
    });
    $( "#regist" ).on( "click", function() {
        restApi("/rest/company", "POST", createSendDate(""), addHistory);
    });
    $( "#query-clear" ).on( "click", function() {
        clearInput("edit-", "");
        setQueryButtons(false);
    });
    $( "#find" ).on( "click", function() {
        restApi("/rest/company-query", "POST", createSendDate("edit-"), updateQueryList);
    });
    $( "#edit" ).on( "click", function() {
        restApi("/rest/company", "PUT", createSendDate("edit-"), updateQueryList);
    });
    $( "#delete" ).on( "click", function() {
        restApi("/rest/company", "DELETE", createSendDate("edit-"), deleteQueryList);
    });
    setQueryButtons(false);
}

/**
 * 送信データ作成.
 */
function createSendDate(prefix) {
    var data = {
        form : {
            companyCd: $("#"+prefix+"company-cd").val(),
            companyName: $("#"+prefix+"company-nm").val(),
            auth: $("#"+prefix+"auth").val(),
            companyUrl: $("#"+prefix+"company-url").val(),
            specialSalesUrl: $("#"+prefix+"special-sales-url").val(),
            puraporiUrl: $("#"+prefix+"purapori-url").val(),
            email: $("#"+prefix+"email").val(),
            tel: $("#"+prefix+"tel").val()
        }
    }
    return jsonString = JSON.stringify(data);
}

/**
 *  登録履歴追加.
 */
function addHistory(response) {
    var result = response.result;
    if (result.length == 0) {
        return;
    }
    var html = createRowHtml("setHistItems", result[0]);
    $(html).appendTo('#regist-body');
}

function setHistItems(trEl) {
    loadLowData("", trEl);
}

/**
 *  検索結果表示.
 */
function updateQueryList(response) {
    var result = response.result;
    $("#search-cnt").html(result.length);
    if (result.length == 0) {
        return;
    }
    var html = "";
    for (var company of result) {
        html += createRowHtml("setQueryItems", company);
    }
    $("#query-body").html(html);
}

/**
 *  削除結果反映.
 */
function deleteQueryList(response) {
    $('#' + $("#edit-company-cd").val()).remove();
}

/**
 *  検索ボタン 設定.
 */
function setQueryItems(trEl) {
    loadLowData("edit-", trEl);
    setQueryButtons(true);
}

/**
 *  結果HTML 作成.
 */
function createRowHtml(onclick, company) {
    var html = "";
    html += "<tr id='" + company.companyCd + "' onclick='" + onclick + "(this);'>";
    html += "<td>" + authToName(company.auth) + "</td>";
    html += "<td>" + company.companyCd + "</td>";
    html += "<td>" + company.companyName + "</td>";
    html += "<td>" + company.tel + "</td>";
    html += "<td>" + company.email + "</td>";
    html += "<td>" + company.companyUrl + "</td>";
    html += "<td>" + company.specialSalesUrl + "</td>";
    html += "<td>" + company.puraporiUrl + "</td>";
    html += "</tr>";
    return html;
}

/**
 *  入力情報設定.
 */
function loadLowData(prefix, trEl) {
    var children = $(trEl).children();
    $("#"+prefix+"auth").val(strToAuth($(children[0]).html()));
    $("#"+prefix+"company-cd").val($(children[1]).html());
    $("#"+prefix+"company-nm").val($(children[2]).html());
    $("#"+prefix+"tel").val($(children[3]).html());
    $("#"+prefix+"email").val($(children[4]).html());
    $("#"+prefix+"company-url").val($(children[5]).html());
    $("#"+prefix+"special-sales-url").val($(children[6]).html());
    $("#"+prefix+"purapori-url").val($(children[7]).html());
}

/**
 *  入力情報クリア.
 */
function clearInput(prefix, auth) {
    $("#"+prefix+"auth").val(auth);
    $("#"+prefix+"company-cd").val("");
    $("#"+prefix+"company-nm").val("");
    $("#"+prefix+"tel").val("");
    $("#"+prefix+"company-url").val("");
    $("#"+prefix+"special-sales-url").val("");
    $("#"+prefix+"purapori-url").val("");
    $("#"+prefix+"email").val("");
}

function setQueryButtons(disabled) {
        $( "#find" ).prop('disabled', disabled);
        $( "#edit" ).prop('disabled', !disabled);
        $( "#delete" ).prop('disabled', !disabled);
        $('#edit-company-cd').attr('readonly',disabled);
}

function authToName(auth) {
    if (auth =='1'){
       return '管理者';
    } else if(auth == '2') {
        return '一般';
    } else {
        return '';
    }
}
function strToAuth(str) {
    if (str =='管理者'){
       return '1';
    } else if(str == '一般') {
        return '2';
    } else {
        return '';
    }
}