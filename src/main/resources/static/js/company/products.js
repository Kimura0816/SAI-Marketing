/**
 *  goods.js
 */
window.onload = function(){
    $( "#regist-clear" ).on( "click", function() {
        $("form-regist").reset();
    });
    $( "#regist" ).on( "click", function() {
        restApi("/rest/product", "POST", createRegistDate(), registed);
    });
}

/**
 * 登録データ作成.
 */
function createRegistDate() {
    var data = {
        form : {
            productCd: $("#product-cd").val(),
            productNm: $("#product-nm").val(),
            price: $("#price").val(),
            paymentPeriod: $("#payment-period").val(),
            surl: $("#sur").val(),
            agreementUrl: $("#agreement-url").val(),
            coolingOffPeriodPrl: $("#cooling-off-period-url").val(),
            coolingOffPeriodExplanation: $("#cooling-off-period-explanation").val(),
            dispAddress: $("#disp-address").val(),
            dispNm: $("#disp-name").val(),
            dispAge: $("#disp-age").val(),
            dispJob: $("#disp-job").val(),
            dispTel: $("#disp-tel").val(),
            dispEmail: $("#disp-email").val()
        }
    }
    return jsonString = JSON.stringify(data);
}

/**
 * 登録完了処理.
 */
function registed() {

}