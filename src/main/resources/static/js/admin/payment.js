/**
 *  口座管理 スクリプト
 */
window.onload = function(){
    $( "#import" ).on( "click", function() {
        sendFile("import-payment-form", "POST", "/rest/payment-history/import", importCallBack);
    });
    $( "#query-clear" ).on( "click", function() {
        clearInput("");
    });
    $( "#find" ).on( "click", function() {
        restApi("/rest/payment-history/query", "POST", createSendDate(), updateQueryList);
    });
}

/**
 * インポート　コールバック.
 */
const importCallBack = function importCallBack(data) {
    createTableHtml("#ng", data.rejected);
    createTableHtml("#ok", data.imported);
}

/**
 * インポート結果の表示.
 */
function createTableHtml(prefix, data) {
    $(prefix + '-cnt').html(data.length);
    if (data.length == 0) {
        return;
    }
    var html = "<table class='table table-striped'><thead><tr>";
    html += "<th></th><th>行</th><th>日付</th><th>内容</th><th>出金金額(円)</th><th>入金金額(円)</th><th>残高(円)</th><th>メモ</th>"
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

function clearInput() {
    $("#from").val("");
    $("#to").val("");
    $("#branch").val("");
    $("#account").val("");
    $("#transferSource").val("");
}

/**
 * 送信データ作成.
 */
function createSendDate() {
    var data = {
        from: $("#from").val(),
        to: $("#to").val(),
        branch: $("#branch").val(),
        account: $("#account").val(),
        transferSource: $("#transferSource").val()
    }
    return jsonString = JSON.stringify(data);
}

function updateQueryList(response) {
    var result = response.result;
    $("#search-cnt").html(result.length);
    if (result.length == 0) {
        return;
    }

    var html = "";
    for (var payment of result) {
        html += "<tr>";
        html += "<td>" + payment.historyNo   + "</td>";
        html += "<td>" + payment.depositDate   + "</td>";
        html += "<td>" + payment.branch   + "</td>";
        html += "<td>" + payment.account   + "</td>";
        html += "<td>" + payment.transferSource   + "</td>";
        html += "<td>" + payment.withdrawalAmount   + "</td>";
        html += "<td>" + payment.depositAmount   + "</td>";
        html += "<td>" + payment.balance   + "</td>";
        html += "<td>" + payment.memo   + "</td>";
        html += "</tr>";
    }
    $("#query-body").html(html);
}




