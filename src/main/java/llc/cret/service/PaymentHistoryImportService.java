package llc.cret.service;

import jakarta.transaction.Transactional;
import llc.cret.repository.PaymentHistoryRepository;
import llc.cret.repository.entity.PaymentHistory;
import llc.cret.util.ConvertUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static llc.cret.util.ConvertUtil.manyToImteger;

/**
 * 入金サービス.
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PaymentHistoryImportService {
    private final PaymentHistoryRepository paymentHistoryRepository;

    /**
     * 入金履歴インポート.
     * @param csvData インポートファイル
     * @return 取込結果
     */
    public Map<String, List<CSVRecord>> importPaymentHistry(List<CSVRecord> csvData) {
        /** 取込データ */
        List<CSVRecord> importData = new LinkedList<>();
        /** リジェクトデータ */
        List<CSVRecord> rejectData = new LinkedList<>();

        // 入金履歴生成
        List<PaymentHistory> paymentHistoryList = new ArrayList<>();
        for (CSVRecord rec : csvData) {
            String[] values = rec.values();
            if (values.length != 6) {
                rejectData.add(rec);
                continue;
            }
            PaymentHistory history = new PaymentHistory();
            String[] date = values[0].split("/");
            if (date.length != 3) {
                rejectData.add(rec);
                continue;
            }
            history.setDepositDate(LocalDate.of(parseInt(date[0]), parseInt(date[1]), parseInt(date[2])));
            String contents = values[1];
            history.setBranch(ConvertUtil.toHalfWidthNum(contents.substring(5, 8)));
            history.setAccount(ConvertUtil.toHalfWidthNum(contents.substring(8, 15)));
            history.setTransferSource(contents.substring(15));
            history.setWithdrawalAmount(manyToImteger(values[2]));
            history.setDepositAmount(manyToImteger(values[3]));
            history.setBalance(manyToImteger(values[4]));
            history.setMemo(values[5]);

            paymentHistoryList.add(history);
            importData.add(rec);
        }
        paymentHistoryRepository.saveAll(paymentHistoryList);
        return Map.of("ok", importData, "ng", rejectData);
    }
}
