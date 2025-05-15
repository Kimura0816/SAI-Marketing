/**
 *  口座管理 スクリプト
 */
window.onload = function(){
    $( "#import" ).on( "click", function() {
        sendFile("form-import", "POST", "/import-account", importCallBack);
    });
    $( "#regist" ).on( "click", function() {
        restApi("/rest/account", "POST", createSendData(), addHistory);
    });
    $( "#query-clear" ).on( "click", function() {
        $("#form-query").reset();
//        clearInput("edit-", "");
    });
    $( "#find" ).on( "click", function() {
        restApi("/rest/account-query", "POST", createSendData(), updateQueryList);
    });
    $( "#edit" ).on( "click", function() {
        restApi("/rest/account", "POST", createSendData(), updateQueryList);
    });
}

/**
 * インポート　コールバック.
 */
const importCallBack = function importCallBack(data) {
    createTableHtml("#ng", data.rejected);

    $('#ok-cnt').html(data.length);
    $("#imported-body").html(createLowHtml(data.imported));
}

function createLowHtml(lowData) {
    var html = "";
    for (var account of lowData) {
        html += "<tr>";
        html += "<td>" + account.accountSeq + "</td>";
        html += "<td>" + account.branch + "</td>";
        html += "<td>" + account.branchNm + "</td>";
        html += "<td>" + account.account + "</td>";
        html += "<td>" + account.accountNm + "</td>";
        html += "<td>" + account.openDate + "</td>";
        html += "<td>" + toStatusNm(account.status) + "</td>";
        html += "<td>" + account.memo + "</td>";
        html += "</tr>";
    }
    return html;
}

/**
 * インポート結果の表示.
 */
function createTableHtml(prefix, data) {
    $(prefix + '-cnt').html(data.length);
    var html = "<table class='table table-striped'><thead><tr>";
    html += "<th></th><th>行</th><th>支店</th><th>支店名</th><th>口座</th><th>口座名義</th><th>開設日</th><th>状態</th><th></th>"
    html += "</tr></thead><tbody>"
    for (var rec of data) {
        html += "<tr><td></td>";
        html += "<td>" + rec.recordNumber + "</td>";
        for(var val of rec.values) {
            html += "<td>" + val + "</td>";
        }
        html += "</tr>";
    }
    html += "</tbody></table>"
    $(prefix + '-data').html(html);
}

/**
 *  rest送信データ作成.
 */
function createSendData() {
    var data = {
        form : {
            branch: $("#branch").val(),
            account: $("#account").val(),
            branchNm: $("#branch_nm").val(),
            accountNm: $("#account-nm").val(),
            openDate: $("#open-date").val(),
            status: $("#status").val(),
            tel: $("#tel").val(),
            memo: $("#memo").val()
        }
    }
    return jsonString = JSON.stringify(data);
}

/**
 *  検索結果表示.
 */
function updateQueryList(response) {
    var result = response.result;
    $("#search-cnt").html(result.length);
    $("#query-body").html(createLowHtml(result));
}

/**
 *  ステータス名の変換.
 */
function toStatusNm(status) {
    if (status == "0") {
        return "未使用";
    } else if (status == "1") {
        return "使用中";
    } else if (status == "9") {
        return "使用済";
    }
    return "";
}

