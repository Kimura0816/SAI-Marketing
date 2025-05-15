package llc.cret.controller.admin;

import llc.cret.controller.dto.ImportResultDto;
import llc.cret.controller.dto.PaymentHistoryImportResponseDto;
import llc.cret.service.PaymentHistoryImportService;
import llc.cret.util.CsvUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 入金インポート コントローラ.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class PaymentImportController {
    private final PaymentHistoryImportService paymentHistoryImportService;

    @PostMapping("rest/payment-history/import")
    public ResponseEntity<PaymentHistoryImportResponseDto> doImport(
            @RequestParam("uploadFile") MultipartFile multipartFile){

        if (multipartFile.isEmpty()) {
            log.error("multipartFile isEmpty");
            return ResponseEntity.badRequest().body(null);
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream(), "Shift-JIS"));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.internalServerError().body(null);
        }

        List<CSVRecord> importRecList = CsvUtil.parse(reader);

        Map<String, List<CSVRecord>> resultMap = paymentHistoryImportService.importPaymentHistry(importRecList);

        // 応答データ設定
        PaymentHistoryImportResponseDto res = PaymentHistoryImportResponseDto.builder()
                .imported(createResult(resultMap.get("ok")))
                .rejected(createResult(resultMap.get("ng")))
                .build();

        return ResponseEntity.ok(res);
    }

    /**
     * インポート結果作成
     * @param data インポート結果
     * @return インポート結果DTO
     */
    private List<ImportResultDto> createResult(List<CSVRecord> data) {
        List<ImportResultDto> result = new ArrayList<>();
        for (CSVRecord rec : data) {
            result.add(
                    ImportResultDto.builder()
                            .recordNumber(rec.getRecordNumber())
                            .values(rec.values())
                            .build()
            );
        }
        return result;
    }
}
